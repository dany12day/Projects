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


public class IstoricUmpleriDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricUmpleri = "call viewIstoricUmpleri(?)";
	private final static String findNrUmpleri  = "call findNrUmpleri()";
	private final static String insertIntoIstoricUmpleri= "insert into IstoricUmpleri(idBazin, dataUmplere, actualitate) values\r\n" + 
			"(?,?,1)";
	public static ArrayList<Date> findById(int idBazin, Date dataGolire) {
		ArrayList<Date> toReturn = new ArrayList<Date>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrUmpleri);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricUmpleri");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricUmpleri);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				Date dataGolireT = rs.getDate("dataUmplere");
				if(dataGolireT.getYear() == dataGolire.getYear() && idBazinT==idBazin)
					toReturn.add(dataGolireT);
				
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
	
	public static void insertIntoIstoricUmpleri(int idBazin, Date dataUmplere) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricUmpleri, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setDate(2, dataUmplere);
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
