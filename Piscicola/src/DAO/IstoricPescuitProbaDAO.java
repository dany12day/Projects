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
import Model.IstoricPescuitProba;


public class IstoricPescuitProbaDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricPescuitProba = "call viewIstoricPescuitProba(?)";
	private final static String findNrIstoricPescuitProba = "call findNrIstoricPescuitProba()";
	private final static String insertIntoIstoricIstoricPescuitProba = "insert into IstoricPescuitProba(idBazin, greutateMedie, dataPescuitProba, actualitate) values\r\n" + 
			"(?,?,?,1)";
	public static ArrayList<IstoricPescuitProba> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricPescuitProba> toReturn = new ArrayList<IstoricPescuitProba>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrIstoricPescuitProba);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricPescuitProba");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricPescuitProba);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				int idBazinT=rs.getInt("idBazin");
				float procentOxigenT = rs.getFloat("greutateMedie");
				Date dataPescuitProbaT = rs.getDate("dataPescuitProba");
				if(dataPescuitProbaT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin)
					toReturn.add(new IstoricPescuitProba(procentOxigenT, dataPescuitProbaT));
				
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
	

	public static void insertIntoIstoricIstoricPescuitProba(int idBazin,float greutateMedie, Date dataPescuitProba) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricIstoricPescuitProba, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setFloat(2, greutateMedie);
			findStatement.setDate(3, dataPescuitProba);
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
