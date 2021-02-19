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
import Model.DetaliiCantitatiFuraje;


public class DetaliiCantitatiFurajeDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String findStatementString = "call viewDetaliiCantitatiFuraje(?,?)";
	private final static String findNrFuraje = "call findNrFuraje()";

	public static ArrayList<DetaliiCantitatiFuraje> findById(int idBazin) {
		ArrayList<DetaliiCantitatiFuraje> toReturn = new ArrayList<DetaliiCantitatiFuraje>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findNrFuraje);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idTipFuraj");
			for(int i=3; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, idBazin);
				findStatement.setInt(2, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				
				String numeFuraj = rs.getString("tipFuraj");
				float cantitateIntrodusa = rs.getFloat("cantitateIntrodusa");
				toReturn.add(new DetaliiCantitatiFuraje(numeFuraj, cantitateIntrodusa));
				
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
	
	
	
	
}
