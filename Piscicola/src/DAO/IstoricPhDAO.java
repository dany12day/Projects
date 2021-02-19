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
import Model.IstoricNivelApa;
import Model.IstoricOxigen;
import Model.IstoricPh;


public class IstoricPhDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricPh = "call viewIstoricPh(?)";
	private final static String findNrIstoricPh = "call findNrIstoricPh()";
	private final static String insertIntoIstoricPh = "insert into IstoricPh(idBazin, procentPh, dataOperatiune, actualitate) values\r\n" + 
			"(?,?,?,1)";
	public static ArrayList<IstoricPh> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricPh> toReturn = new ArrayList<IstoricPh>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrIstoricPh);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricPh");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricPh);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				float procentPhT = rs.getFloat("procentPh");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin)
					toReturn.add(new IstoricPh(procentPhT, dataOperatiuneT));
				
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
	
	public static void insertIntoIstoricPh(int idBazin,float procentPh, Date dataOperatiune) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricPh, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setFloat(2, procentPh);
			findStatement.setDate(3, dataOperatiune);
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
