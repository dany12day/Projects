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
import Model.IstoricFuraj;


public class IstoricFurajDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricFuraje = "call viewIstoricFuraje(?)";
	private final static String findNrFurajari = "call findNrFurajari()";
	private final static String insertIntoIstoricFuraje = "insert into IstoricFuraj(idBazin, idTipFuraj, cantitateOperatiune, dataOperatiune, actualitate) values\r\n" + 
			"(?,?,?,?,1)";
	public static ArrayList<IstoricFuraj> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricFuraj> toReturn = new ArrayList<IstoricFuraj>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrFurajari);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricFuraj");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricFuraje);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				String tipFurajT= rs.getString("tipFuraj");
				float cantitateOperatiuneT= rs.getFloat("cantitateOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin &&
						!tipFurajT.contentEquals("Balegar") && !tipFurajT.contentEquals("Fitoplancton"))
					toReturn.add(new IstoricFuraj(tipFurajT, cantitateOperatiuneT, dataOperatiuneT));
				
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
	
	public static ArrayList<IstoricFuraj> findByIdBalegar(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricFuraj> toReturn = new ArrayList<IstoricFuraj>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrFurajari);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricFuraj");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricFuraje);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				String tipFurajT= rs.getString("tipFuraj");
				float cantitateOperatiuneT= rs.getFloat("cantitateOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin &&
						tipFurajT.contentEquals("Balegar"))
					toReturn.add(new IstoricFuraj(tipFurajT, cantitateOperatiuneT, dataOperatiuneT));
				
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
	public static ArrayList<IstoricFuraj> findByIdFitoplancton(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricFuraj> toReturn = new ArrayList<IstoricFuraj>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrFurajari);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricFuraj");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricFuraje);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				String tipFurajT= rs.getString("tipFuraj");
				float cantitateOperatiuneT= rs.getFloat("cantitateOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin &&
						tipFurajT.contentEquals("Fitoplancton"))
					toReturn.add(new IstoricFuraj(tipFurajT, cantitateOperatiuneT, dataOperatiuneT));
				
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
	
	public static void insertIntoIstoricFuraje(int idBazin, int idTipFuraj,float cantitate, Date dataOperatiune) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricFuraje, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setInt(2, idTipFuraj);
			findStatement.setFloat(3, cantitate);
			findStatement.setDate(4, dataOperatiune);
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
