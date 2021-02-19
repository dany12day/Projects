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
import Model.IstoricPescuitProba;
import Model.IstoricPeste;


public class IstoricPesteDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(DetaliiCantitatiFurajeDAO.class.getName());
	
	private final static String viewIstoricPeste = "call viewIstoricPeste(?)";
	private final static String findNrIstoricPesti = "call findNrIstoricPesti()";
	private final static String insertIntoIstoricPeste = "insert into IstoricPeste(idBazin, idTipPeste, cantitateOperatiune, dataOperatiune, tipOperatiune, actualitate) values\r\n" + 
			"(?,?,?,?,?,1)";

	public static ArrayList<IstoricPeste> findById(int idBazin, Date dataOperatiune) {
		ArrayList<IstoricPeste> toReturn = new ArrayList<IstoricPeste>();
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findNrIstoricPesti);
			rs = findStatement.executeQuery();
			rs.next();
			int nrFuraje = rs.getInt("idIstoricPeste");
			for(int i=1; i<=nrFuraje; i++) {	
				findStatement = dbConnection.prepareStatement(viewIstoricPeste);
				findStatement.setInt(1, i);
				rs = findStatement.executeQuery();
				rs.next();
				String tipPesteT = rs.getString("tipPeste");
				int idBazinT=rs.getInt("idBazin");
				float cantitateOperatiuneT = rs.getFloat("cantitateOperatiune");
				Date dataOperatiuneT = rs.getDate("dataOperatiune");
				String tipOperatiuneT = rs.getString("tipOperatiune");
				
				if(dataOperatiuneT.getYear() == dataOperatiune.getYear() && idBazinT==idBazin)
					toReturn.add(new IstoricPeste(tipPesteT,cantitateOperatiuneT,dataOperatiuneT,tipOperatiuneT));
				
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
	
	public static void insertIntoIstoricPeste(int idBazin, int idTipPeste,float cantitate, Date data, String tipOperatiune) {
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(insertIntoIstoricPeste, Statement.RETURN_GENERATED_KEYS);
			findStatement.setInt(1, idBazin);
			findStatement.setInt(2, idTipPeste);
			findStatement.setFloat(3, cantitate);
			findStatement.setDate(4, data);
			findStatement.setString(5, tipOperatiune);
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
