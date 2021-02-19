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
import Model.Masini;

public class MasiniDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(MasiniDAO.class.getName());
	
	private final static String findStatementString = "SELECT * FROM Masini where idMasina = ?";
	private final static String findNrMasini = "call findNrMasini()";
	private final static String adaugaTMasina = "insert into Masini(numeMasini, kmParcursi, consum, cost) values (?, 0, 0, 0)";

	public static Masini findById(int idMasina) {
		Masini toReturn = null;

		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, idMasina);
			rs = findStatement.executeQuery();
			rs.next();
			String numeMasini = rs.getString("numeMasini");
			float kmParcursi = rs.getFloat("kmParcursi");
			float consum = rs.getFloat("consum");
			float cost = rs.getFloat("cost");
			toReturn = new Masini(idMasina, numeMasini, kmParcursi, consum, cost);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return toReturn;
	}
	

	public static ArrayList<Masini> findMasini() {
		ArrayList<Masini> toReturn = new ArrayList<Masini>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrMasini);
			rs = findStatement.executeQuery();
			rs.next();
			int nrTipuri = rs.getInt("idMasina");
			for(int i=1; i<=nrTipuri; i++) {
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				String numeMasini = rs.getString("numeMasini");
				float kmParcursi = rs.getFloat("kmParcursi");
				float consum = rs.getFloat("consum");
				float cost = rs.getFloat("cost");
				toReturn.add(new Masini(i, numeMasini, kmParcursi, consum, cost));
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
	
	public static void AdaugaMasina(String Masina) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			
			findStatement = dbConnection.prepareStatement(adaugaTMasina, Statement.RETURN_GENERATED_KEYS);
			findStatement.setString(1, Masina);
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
