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
import Model.Bazin;

public class BazinDAO {
	private static int nrRaport=0;
	protected static final Logger LOGGER = Logger.getLogger(BazinDAO.class.getName());
	
	private final static String findStatementString = "call viewDetaliiBazin(?)";
	private final static String resetStatementString = "call resetareBazin(?)";

	public static Bazin findById(int idBazin) {
		Bazin toReturn = null;
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, idBazin);
			rs = findStatement.executeQuery();
			rs.next();
			float cantitatePeste = rs.getFloat("cantitatePeste");
			float cantitateFuraj = rs.getFloat("cantitateFuraj");
			float medieOxigen = rs.getFloat("medieOxigen");
			float mediePh = rs.getFloat("mediePh");
			float medieTemperatura = rs.getFloat("medieTemperatura");
			float cantitateBalegar = rs.getFloat("cantitateBalegar");
			float medieNivelApa = rs.getFloat("medieNivelApa");
			float cantitateFitoplancton = rs.getFloat("cantitateFitoplancton");
			Date ultimaDezinfectare = rs.getDate("ultimaDezinfectare");
			Date ultimaUmplere= rs.getDate("ultimaUmplere");
			Date ultimaGolire = rs.getDate("ultimaGolire");
			Date dataPescuitProba= rs.getDate("dataPescuitProba");
			float greutateMedie = rs.getFloat("greutateMedie");
			toReturn = new Bazin(idBazin, cantitatePeste, cantitateFuraj, medieOxigen, mediePh, medieTemperatura,
					cantitateBalegar, medieNivelApa, cantitateFitoplancton, ultimaDezinfectare,ultimaUmplere,
					ultimaGolire, dataPescuitProba, greutateMedie);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexiuneBazaDate.close(rs);
			ConexiuneBazaDate.close(findStatement);
			ConexiuneBazaDate.close(dbConnection);
		}
		return toReturn;
	}
	
	public static Bazin resetById(int idBazin) {
		Bazin toReturn = null;
		Connection dbConnection = ConexiuneBazaDate.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			
			findStatement = dbConnection.prepareStatement(resetStatementString);
			findStatement.setInt(1, idBazin);
			rs = findStatement.executeQuery();
			rs.next();
			
			
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
