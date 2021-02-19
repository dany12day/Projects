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
import Model.DetaliiCantitatiPeste;


public class DetaliiCantitatiPesteDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiPesteDAO.class.getName());
	
	private final static String findStatementString = "call viewDetaliiCantitatiPeste(?,?)";
	private final static String findNrPesti = "call findNrPesti()";

	public static ArrayList<DetaliiCantitatiPeste> findByIdBazin(int idBazin) {
		ArrayList<DetaliiCantitatiPeste> toReturn = new ArrayList<DetaliiCantitatiPeste>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findNrPesti);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idTipPeste");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(findStatementString);
				findStatement.setInt(1, idBazin);
				findStatement.setInt(2, i);
				rs = findStatement.executeQuery();
				
				rs.next();
				
				String tipPeste = rs.getString("tipPeste");
				float cantitateIntrodusa = rs.getFloat("cantitateIntrodusa");
				float cantitateScoasa = rs.getFloat("cantitateScoasa");
				float cantitateRamasa = rs.getFloat("cantitateRamasa");
				toReturn.add(new DetaliiCantitatiPeste(tipPeste, cantitateIntrodusa, cantitateScoasa, cantitateRamasa));
				
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
