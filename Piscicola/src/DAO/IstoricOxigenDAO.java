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


public class IstoricOxigenDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricOxigen = "call viewIstoricOxigen(?)";
	private final static String findNrIstoricOxigen = "call findNrIstoricOxigen()";
	private final static String insertIntoIstoricOxigen = "insert into IstoricOxigen(idBazin, procentOxigen, dataOperatiune, actualitate) values\r\n" + 
			"(?,?,?,1)";
	public static ArrayList<IstoricOxigen> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricOxigen> toReturn = new ArrayList<IstoricOxigen>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrIstoricOxigen);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricOxigen");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricOxigen);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				float procentOxigenT = rs.getFloat("procentOxigen");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin)
					toReturn.add(new IstoricOxigen(procentOxigenT, dataOperatiuneT));
				
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
	
	
	public static void insertIntoIstoricOxigen(int idBazin,float procentOxigen, Date dataOperatiune) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricOxigen, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setFloat(2, procentOxigen);
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
