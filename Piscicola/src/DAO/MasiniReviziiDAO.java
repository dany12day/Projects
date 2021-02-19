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
import Model.MasiniRevizii;

public class MasiniReviziiDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(MasiniReviziiDAO.class.getName());
	
	private final static String findStatementString = "select * from MasiniRevizii where idMasiniRevizii=?";
	private final static String findNrRevizii = "call findNrRevizii()";
	private final static String adaugaRevizie = "insert into MasiniRevizii(idMasina, dataRevizia, expirareRevizie, cost , pieseSchimbate) values\r\n" + 
			"(?,?,?,?,?)";
	

	public static ArrayList<MasiniRevizii> findReviziiById(int idMasina, Date perioada) {
		ArrayList<MasiniRevizii> toReturn = new ArrayList<MasiniRevizii>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrRevizii);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasiniRevizii");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idMasina2= rs.getInt("idMasina");
				Date dataRevizia = rs.getDate("dataRevizia");
				Date expirareRevizie = rs.getDate("expirareRevizie");
				float cost = rs.getFloat("cost");
				String pieseSchimbate = rs.getString("pieseSchimbate");
				if(idMasina == idMasina2 && perioada.getYear()==dataRevizia.getYear())
					toReturn.add(new MasiniRevizii(dataRevizia,expirareRevizie,cost,pieseSchimbate));
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
	
	public static MasiniRevizii findultimaReviziiById(int idMasina) {
		MasiniRevizii toReturn = null;
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrRevizii);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasiniRevizii");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idMasina2= rs.getInt("idMasina");
				Date dataRevizia = rs.getDate("dataRevizia");
				Date expirareRevizie = rs.getDate("expirareRevizie");
				if(idMasina == idMasina2)
					toReturn=new MasiniRevizii(dataRevizia,expirareRevizie,0,"");
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
	
	public static void AdaugaRevizie(int idMasina, Date dataRevizia, Date expirareRevizie, float cost, String pieseSchimbate) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaRevizie, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idMasina);
			findStatement.setDate(2, dataRevizia);
			findStatement.setDate(3, expirareRevizie);
			findStatement.setFloat(4, cost);
			findStatement.setString(5, pieseSchimbate);
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
