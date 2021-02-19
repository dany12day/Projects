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
import Model.TipuriPeste;

public class TipuriPesteDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(TipuriPesteDAO.class.getName());
	
	private final static String findStatementString = "SELECT * FROM TipuriPeste where idTipPeste = ?";
	private final static String findfindNrPesti = "call findNrPesti()";
	private final static String adaugaTipPeste = "insert into TipuriPeste(tipPeste, disponibilitateTipPeste) values (?, true)";

	public static TipuriPeste findById(int idTipPeste) {
		TipuriPeste toReturn = null;

		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, idTipPeste);
			rs = findStatement.executeQuery();
			rs.next();
			String tipPeste = rs.getString("tipPeste");
			Boolean disponibilitateTipPeste = rs.getBoolean("disponibilitateTipPeste");
			System.out.println("tip peste :"+ tipPeste);
			toReturn = new TipuriPeste(idTipPeste, tipPeste, disponibilitateTipPeste);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return toReturn;
	}
	

	public static ArrayList<String> findTipuriPesti() {
		ArrayList<String> toReturn = new ArrayList<String>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findfindNrPesti);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idTipPeste");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				String tipPeste = rs.getString("tipPeste");
				toReturn.add(tipPeste);
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
	
	public static void AdaugaTipPeste(String tipPeste) {
		System.out.println(tipPeste);
		TipuriPeste toReturn = null;
		System.out.println("DA");
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		System.out.println("DA");
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaTipPeste, Statement.RETURN_GENERATED_KEYS);
			findStatement.setString(1, tipPeste);
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
