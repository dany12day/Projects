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
import Model.MasiniLunar;

public class MasiniLunarDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(MasiniLunarDAO.class.getName());
	
	private final static String findStatementString = "select MasiniLunar.idMasina,MasiniLunar.consum,MasiniLunar.kmParcursi,MasiniLunar.luna, MasiniLunar.cost from masini inner join MasiniLunar on masini.idMasina=MasiniLunar.idMasina where MasiniLunar.idMasiniLunar=?";
	private final static String findNrCurseLunar = "call findNrCurseLunar()";
	
	

	public static ArrayList<MasiniLunar> findCurseByIdAndYear(int idMasina, Date perioada) {
		ArrayList<MasiniLunar> toReturn = new ArrayList<MasiniLunar>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrCurseLunar);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasiniLunar");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				float kmParcursi = rs.getFloat("kmParcursi");
				float consum = rs.getFloat("consum");
				float cost = rs.getFloat("cost");
				Date dataCursa = rs.getDate("luna");
				int idMasina2 = rs.getInt("idMasina");
				if(idMasina == idMasina2 && perioada.getYear()==dataCursa.getYear())
					toReturn.add(new MasiniLunar( consum, kmParcursi, dataCursa, cost));
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
	
	
}
