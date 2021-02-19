package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConexiuneBazaDate.ConexiuneBazaDate;
import Model.Bazine;
import Model.TipuriPeste;


public class BazineDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(BazineDAO.class.getName());
	
	private final static String findStatementString = "SELECT * FROM Bazine where idBazin = ?";
	private final static String findStatementAllString = "SELECT numeBazin FROM Bazine where idBazin = ?";
	private final static String adaugaBazin = "insert into Bazine(numeBazin) values (?)";
	private final static String findNrBazine = "call findNrBazine()";
	
	public static Bazine findBazineById(int idBazine) {
		Bazine toReturn = null;
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, idBazine);
			rs = findStatement.executeQuery();
			
			rs.next();
			String numeBazin = rs.getString("numeBazin");
			
			toReturn = new Bazine(idBazine, numeBazin);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return toReturn;
	}
	
	public static ArrayList<String> findBazine() {
		ArrayList<String> numeBazine= new ArrayList<>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findNrBazine);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idBazin");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementAllString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				String numeBazin = rs.getString("numeBazin");
				
				numeBazine.add(numeBazin);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return numeBazine;
	}
	
	public static void AdaugaBazin(String numeBazin) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaBazin, Statement.RETURN_GENERATED_KEYS);
			findStatement.setString(1, numeBazin);
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
