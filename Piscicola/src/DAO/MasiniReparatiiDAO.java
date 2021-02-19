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

import org.w3c.dom.Text;

import ConexiuneBazaDate.ConexiuneBazaDate;
import Model.Masini;
import Model.MasiniCurse;
import Model.MasiniReparatii;
import Model.MasiniRevizii;

public class MasiniReparatiiDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(MasiniReparatiiDAO.class.getName());
	
	private final static String findStatementString = "select * from MasiniReparatii where idMasiniReparatii=?";
	private final static String findNrReparatii = "call findNrReparatii()";
	private final static String adaugaReparatie = "insert into MasiniReparatii(idMasina, cost, mecanic, problemeAparute, dataReparatie) values\r\n" + 
			"(?,?,?,?,?)";
	

	public static ArrayList<MasiniReparatii> findReparatiiById(int idMasina, Date perioada) {
		ArrayList<MasiniReparatii> toReturn = new ArrayList<MasiniReparatii>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrReparatii);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasiniReparatii");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idMasina2 = rs.getInt("idMasina");
				float cost= rs.getFloat("cost");
				String mecanic = rs.getString("mecanic");
				String problemeAparute = rs.getString("problemeAparute");
				Date dataReparatie = rs.getDate("dataReparatie");
				if(idMasina == idMasina2 && perioada.getYear()==dataReparatie.getYear())
					toReturn.add(new MasiniReparatii(cost, mecanic , problemeAparute , dataReparatie ));
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
	
	
	public static void AdaugaReparatie(int idMasina,float cost,String mecanic ,String problemeAparute ,Date dataReparatie ) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaReparatie, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idMasina);
			findStatement.setFloat(2, cost);
			findStatement.setString(3, mecanic);
			findStatement.setString(4, problemeAparute);
			findStatement.setDate(5, dataReparatie);
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
