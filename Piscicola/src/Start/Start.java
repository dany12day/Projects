package Start;

import javax.swing.JFrame;

import DAO.DetaliiCantitatiFurajeDAO;
import DAO.IstoricDezinfectiiDAO;
import DAO.IstoricFurajDAO;
import DAO.IstoricGoliriDAO;
import DAO.IstoricNivelApaDAO;
import DAO.IstoricOxigenDAO;
import DAO.IstoricPescuitProbaDAO;
import DAO.IstoricPesteDAO;
import DAO.IstoricPhDAO;
import DAO.IstoricTemperaturaDAO;
import DAO.IstoricUmpleriDAO;
import DAO.MasiniCurseDAO;
import DAO.MasiniDAO;
import DAO.MasiniLunarDAO;
import DAO.MasiniReparatiiDAO;
import DAO.MasiniReviziiDAO;
import DAO.TipuriFurajDAO;
import DAO.TipuriPesteDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import Interfata.View;
import Model.DetaliiCantitatiFuraje;
import Model.DetaliiCantitatiPeste;
import Model.IstoricFuraj;
import Model.IstoricNivelApa;
import Model.IstoricOxigen;
import Model.IstoricPescuitProba;
import Model.IstoricPeste;
import Model.IstoricPh;
import Model.IstoricTemperatura;
import Model.Masini;
import Model.MasiniCurse;
import Model.MasiniLunar;
import Model.MasiniReparatii;
import Model.MasiniRevizii;
import Model.TipuriPeste;

public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
	
	public static void main(String[] args) {
		
		JFrame frame = new View("Baza de date");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}

}
