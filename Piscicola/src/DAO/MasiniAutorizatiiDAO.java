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
import Model.MasiniAutorizatii;
import Model.MasiniCurse;
import Model.MasiniRevizii;

public class MasiniAutorizatiiDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(MasiniAutorizatiiDAO.class.getName());
	
	private final static String findStatementString = "select * from MasiniAutorizatii where idMasiniAutorizatii=?";
	private final static String findNrRevizii = "call findNrAutorizatii()";
	private final static String adaugaRevizie = "insert into MasiniAutorizatii(idMasina, numeAutorizatie, dataAutorizatie, dataAutorizatieExpirare) values\r\n" + 
			"(?,?,?,?)";
	

	public static ArrayList<MasiniAutorizatii> findAutorizatiiById(int idMasina, Date perioada) {
		ArrayList<MasiniAutorizatii> toReturn = new ArrayList<MasiniAutorizatii>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrRevizii);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasiniAutorizatii");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idMasina2= rs.getInt("idMasina");
				Date dataRevizia = rs.getDate("dataAutorizatie");
				Date expirareRevizie = rs.getDate("dataAutorizatieExpirare");
				String pieseSchimbate = rs.getString("numeAutorizatie");
				if(idMasina == idMasina2 && perioada.getYear()==dataRevizia.getYear())
					toReturn.add(new MasiniAutorizatii(dataRevizia,expirareRevizie,pieseSchimbate));
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
	
	
	
	public static void AdaugaAutorizatie(int idMasina, Date dataAutorizatie, Date dataAutorizatieExpirare, String numeAutorizatie) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaRevizie, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idMasina);
			findStatement.setString(2, numeAutorizatie);
			findStatement.setDate(3, dataAutorizatie);
			findStatement.setDate(4, dataAutorizatieExpirare);
			
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
