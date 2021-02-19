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
import Model.TipuriFuraj;
import Model.TipuriPeste;

public class TipuriFurajDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(TipuriFurajDAO.class.getName());
	
	private final static String findStatementString = "call findFuraj(?)";
	private final static String findNrFurajuri = "call findNrFuraje()";
	private final static String adaugaTipFuraj = "insert into TipuriFuraj(tipFuraj, disponibilitateTipFuraj) values (?, true)";

	public static TipuriFuraj findById(int idTipFuraj) {
		TipuriFuraj toReturn = null;

		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, idTipFuraj);
			rs = findStatement.executeQuery();
			rs.next();
			String tipFuraj = rs.getString("tipFuraj");
			Boolean disponibilitateTipFuraj = rs.getBoolean("disponibilitateTipFuraj");
			toReturn = new TipuriFuraj(idTipFuraj, tipFuraj, disponibilitateTipFuraj);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return toReturn;
	}
	

	public static ArrayList<String> findTipuriFuraj() {
		ArrayList<String> toReturn = new ArrayList<String>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrFurajuri);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idTipFuraj");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				String tipPeste = rs.getString("tipFuraj");
				if(!tipPeste.contentEquals("Balegar") && !tipPeste.contentEquals("Fitoplancton")) {
					toReturn.add(tipPeste);
				}
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
	
	public static void AdaugaTipFuraj(String tipFuraj) {
		TipuriPeste toReturn = null;
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaTipFuraj, Statement.RETURN_GENERATED_KEYS);
			findStatement.setString(1, tipFuraj);
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
