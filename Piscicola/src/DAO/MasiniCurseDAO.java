package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConexiuneBazaDate.ConexiuneBazaDate;
import Model.Masini;
import Model.MasiniCurse;

public class MasiniCurseDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(MasiniCurseDAO.class.getName());
	
	private final static String findStatementString = "select MasiniCurse.idMasina,numeMasini,sofer,masinicurse.consum,masinicurse.kmParcursi,destinatie,masinicurse.dataCursa,masinicurse.cost from masini inner join masinicurse on masini.idMasina=masinicurse.idMasina where MasiniCurse.idMasiniCurse=?";
	private final static String findNrCurse = "call findNrCurse()";
	private final static String adaugaCursa = "insert into MasiniCurse(idMasina, sofer, consum, kmParcursi, cost, costPerLitru, destinatie, dataCursa) values\r\n" + 
			"(?,?,?,?,?,?,?,?)";
	

	public static ArrayList<MasiniCurse> findCurseById(int idMasina, Date perioada) {
		ArrayList<MasiniCurse> toReturn = new ArrayList<MasiniCurse>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrCurse);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasiniCurse");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				String numeMasini = rs.getString("numeMasini");
				String sofer = rs.getString("sofer");
				float kmParcursi = rs.getFloat("kmParcursi");
				float consum = rs.getFloat("consum");
				float cost = rs.getFloat("cost");
				String destinatie = rs.getString("destinatie");
				Date dataCursa = rs.getDate("dataCursa");
				int idMasina2 = rs.getInt("idMasina");
				if(idMasina == idMasina2 && perioada.getYear()==dataCursa.getYear())
					toReturn.add(new MasiniCurse(numeMasini,sofer, consum, cost, kmParcursi, destinatie, dataCursa));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return toReturn;
	}
	
	public static void AdaugaCursa(int idMasina,String sofer,float consum, float costPerLitru,float kmParcursi, String destinatie,Date dataCursa) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaCursa, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idMasina);
			findStatement.setString(2, sofer);
			findStatement.setFloat(3, consum);
			findStatement.setFloat(4, kmParcursi);
			findStatement.setFloat(5, costPerLitru * consum);
			findStatement.setFloat(6, costPerLitru);
			findStatement.setString(7, destinatie);
			findStatement.setDate(8, dataCursa);
			findStatement.executeUpdate();
			rs = findStatement.getGeneratedKeys();
			rs.next();

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
	}
}
