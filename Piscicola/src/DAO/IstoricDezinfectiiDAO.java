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
import Model.DetaliiCantitatiFuraje;


public class IstoricDezinfectiiDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricDezinfectii = "call viewIstoricDezinfectii(?)";
	private final static String findNrDezinfectari = "call findNrDezinfectari()";
	private final static String insertIntoIstoricDezinfectie = "insert into IstoricDezinfectii(idBazin, dataDezinfectare, actualitate) values\r\n" + 
			"(?,?,1)";
	public static ArrayList<Date> findById(int idBazin, Date dataDezinfectare) {
		ArrayList<Date> toReturn = new ArrayList<Date>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrDezinfectari);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricDezinfectii");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricDezinfectii);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				Date dataDezinfectareT = rs.getDate("dataDezinfectare");
				if(dataDezinfectareT.getYear() == dataDezinfectare.getYear() && idBazinT==idBazin)
					toReturn.add(dataDezinfectareT);
				
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
	
	
	public static void insertIntoIstoricDezinfectie(int idBazin, Date dataDezinfectare) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricDezinfectie, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setDate(2, dataDezinfectare);
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
