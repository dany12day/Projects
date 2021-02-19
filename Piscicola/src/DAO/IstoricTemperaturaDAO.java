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
import Model.IstoricTemperatura;


public class IstoricTemperaturaDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricTemperatura = "call viewIstoricTemperatura(?)";
	private final static String findNrIstoricTemperatura = "call findNrIstoricTemperatura()";
	private final static String insertIntoIstoricTemperatura = "insert into IstoricTemperatura(idBazin, temperatura, dataOperatiune, actualitate) values\r\n" + 
			"(?,?,?,1)";
	public static ArrayList<IstoricTemperatura> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricTemperatura> toReturn = new ArrayList<IstoricTemperatura>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrIstoricTemperatura);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricTemperatura");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricTemperatura);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				float temperaturaT = rs.getFloat("temperatura");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin)
					toReturn.add(new IstoricTemperatura(temperaturaT, dataOperatiuneT));
				
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
	
	public static void insertIntoIstoricTemperatura(int idBazin,float teperatura, Date dataOperatiune) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricTemperatura, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setFloat(2, teperatura);
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
