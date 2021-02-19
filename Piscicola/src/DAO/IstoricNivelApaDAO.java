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


public class IstoricNivelApaDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricNivelApa = "call viewIstoricNivelApa(?)";
	private final static String findNrNivelApa = "call findNrNivelApa()";
	private final static String insertIntoIstoricNivelApa = "insert into IstoricNivelApa(idBazin, nivelApa, dataOperatiune, actualitate) values\r\n" + 
			"(?,?,?,1)";
	public static ArrayList<IstoricNivelApa> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricNivelApa> toReturn = new ArrayList<IstoricNivelApa>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrNivelApa);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricNivelApa");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricNivelApa);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				float nivelApaT = rs.getFloat("nivelApa");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin)
					toReturn.add(new IstoricNivelApa(nivelApaT, dataOperatiuneT));
				
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
	
	public static void insertIntoIstoricNivelApa(int idBazin,float nivelApa, Date dataOperatiune) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricNivelApa, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setFloat(2, nivelApa);
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
