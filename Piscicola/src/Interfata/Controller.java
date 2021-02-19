package Interfata;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import DAO.BazinDAO;
import DAO.BazineDAO;
import DAO.DetaliiCantitatiFurajeDAO;
import DAO.DetaliiCantitatiPesteDAO;
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
import DAO.MasiniAutorizatiiDAO;
import DAO.MasiniCurseDAO;
import DAO.MasiniDAO;
import DAO.MasiniLunarDAO;
import DAO.MasiniReparatiiDAO;
import DAO.MasiniReviziiDAO;
import DAO.TipuriFurajDAO;
import DAO.TipuriPesteDAO;
import Model.Bazin;
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
import Model.MasiniAutorizatii;
import Model.MasiniCurse;
import Model.MasiniLunar;
import Model.MasiniReparatii;
import Model.MasiniRevizii;

public class Controller implements ActionListener{
	
	private View view;
	
	private int adaugare=1;
	private int idBazin=1;
	private int idMasina=1;
	private int pus=3;
	private int adaugareMare=1;
	private int adaugareASR=1;
	private Bazin bazin = new Bazin();
	private Masini masina = new Masini();
	private MasiniRevizii masiniRevizii = new MasiniRevizii();
	private ArrayList<DetaliiCantitatiPeste> detaliiCantitatiPeste= new ArrayList<DetaliiCantitatiPeste>();
	private ArrayList<DetaliiCantitatiFuraje> detaliiCantitatiFuraje= new ArrayList<DetaliiCantitatiFuraje>();
	
	public Controller(View v) {
		this.view = v;
	}

	public void actualizareDate() {
		try {
			bazin = BazinDAO.findById(idBazin);
			detaliiCantitatiPeste=DetaliiCantitatiPesteDAO.findByIdBazin(idBazin);
			detaliiCantitatiFuraje=DetaliiCantitatiFurajeDAO.findById(idBazin);
			view.fillBazine(bazin,detaliiCantitatiPeste,detaliiCantitatiFuraje);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	public void actualizareMasini() {
		try {
			masina = MasiniDAO.findById(idMasina);
			masiniRevizii = MasiniReviziiDAO.findultimaReviziiById(idMasina);
			view.fillMasina(masina,masiniRevizii);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		
		if(source == view.getBazine()) {
			view.getPanouPrincipal().setVisible(false);
			view.getPanouBazine().setVisible(true);
		}
		
		if(source == view.getInapoiBazine()) {
			view.getPanouBazine().setVisible(false);
			view.getPanouPrincipal().setVisible(true);
		}
		
		if(source == view.getInapoiBazin()) {	
			view.getPanouBazin().setVisible(false);
			view.getPanouBazine().setVisible(true);
		}
		
		if(source == view.getCautaBazin()) {
			
			idBazin=view.getSelectareBazin().getSelectedIndex();
			if(idBazin!=0) {
				view.getPanouBazine().setVisible(false);
				this.actualizareDate();
				//view.crearePanouBazin();
				view.getPanouBazin().setVisible(true);
			}
		}
		
		if(source == view.getAngajati()) {
			view.getPanouPrincipal().setVisible(false);
			view.getPanouAngajati().setVisible(true);
		}
		
		if(source == view.getInapoiAngajati()) {
			view.getPanouPrincipal().setVisible(true);
			view.getPanouAngajati().setVisible(false);
		}
		
		if(source == view.getMasini()) {
			view.getPanouPrincipal().setVisible(false);
			view.getPanouMasini().setVisible(true);
		}
		
		if(source == view.getCautaMasina()) {
			idMasina=view.getSelectareMasina().getSelectedIndex();
			if(idMasina!=0) {
				view.getPanouMasini().setVisible(false);
				this.actualizareMasini();
				view.getPanouMasina().setVisible(true);
			}
		}
		
		if(source == view.getInapoiMasina()) {
			view.getPanouMasina().setVisible(false);
			view.getPanouMasini().setVisible(true);
		}
		
		if(source == view.getInapoiMasini()) {
			view.getPanouPrincipal().setVisible(true);
			view.getPanouMasini().setVisible(false);
		}
		
		if(source == view.getGeneral()) {
			view.getPanouPrincipal().setVisible(false);
			view.getPanouGeneral().setVisible(true);
		}
		
		if(source == view.getInapoiGeneral()) {
			view.getPanouPrincipal().setVisible(true);
			view.getPanouGeneral().setVisible(false);
		}
		
		if(source == view.getDetaliiCantitatePeste()) {
			view.getPanouBazin().setVisible(false);
			view.getPanouPesteCantitati().setVisible(true);
		}
		
		if(source == view.getInapoiPeste()) {
			view.getPanouPesteCantitati().setVisible(false);
			view.getPanouBazin().setVisible(true);
		}
		
		if(source == view.getResetareBazin()) {
			view.getPanouBazin().setVisible(false);
			view.getPanouResetareBazin().setVisible(true);
		}
		
		if(source == view.getResetareBazinDa()) {
			view.getPanouBazin().setVisible(true);
			BazinDAO.resetById(idBazin);
			this.actualizareDate();
			view.getPanouResetareBazin().setVisible(false);
		}
		
		if(source == view.getResetareBazinNu()) {
			view.getPanouBazin().setVisible(true);
			view.getPanouResetareBazin().setVisible(false);
		}
		
		if(source == view.getInapoiIstoric()) {
			view.getPanouIstoric().setVisible(false);
			view.getPanouSelectareAn().setVisible(true);
		}
		
		if(source == view.getIstoricPeste()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=1;
			view.getPanouPesteCantitati().setVisible(false);
		}
		
		if(source == view.getIstoricFuraje()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=2;
			view.getPanouFurajeCantitati().setVisible(false);
		}
		
		if(source == view.getAdaugareFuraj()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(true);
			adaugare=2;
			view.getAdaugareUnicTXT().setText("Introduceti cantitate de furaj introdusa");
			view.getPanouFurajeCantitati().setVisible(false);
		}
		
		if(source == view.getInapoiAdaugareTipPeste()) {
			view.getPanouAdaugareTipPeste().setVisible(false);
			view.getPanouPesteCantitati().setVisible(true);
		}
		
		if(source == view.getAdaugarePeste()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getPestiMeniu().setVisible(true);
			view.getAdaugareUnicTXT().setText("Introduceti cantitate de peste cu care doriti sa populati");
			adaugare=1;
			pus=1;
			view.getFurajMeniu().setVisible(false);
			view.getPanouPesteCantitati().setVisible(false);
		}
		
		if(source == view.getScoaterePeste()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getPestiMeniu().setVisible(true);
			view.getAdaugareUnicTXT().setText("Introduceti cantitate de peste pe care doriti sa o pescuiti");
			adaugare=1;
			pus=2;
			view.getFurajMeniu().setVisible(false);
			view.getPanouPesteCantitati().setVisible(false);
		}
		
		if(source == view.getAdaugareTipPeste()) {
			view.getPanouAdaugareTipPeste().setVisible(true);
			
			view.getPanouPesteCantitati().setVisible(false);
		}
		
		if(source == view.getAdaugareTipFurajFinal()) {
			TipuriFurajDAO.AdaugaTipFuraj(view.getAdaugareTipFurajFinalNr().getText());
			this.actualizareDate();
			
		}
		
		if(source == view.getAdaugareTipPesteFinal()) {
			TipuriPesteDAO.AdaugaTipPeste(view.getAdaugareTipPesteFinalNr().getText());
			this.actualizareDate();
		}
		
		if(source == view.getInapoiFuraj()) {
			view.getPanouFurajeCantitati().setVisible(false);
			view.getPanouBazin().setVisible(true);
		}
		
		if(source == view.getDetaliiCantitateFuraje()) {
			view.getPanouBazin().setVisible(false);
			view.getPanouFurajeCantitati().setVisible(true);
		}
		if(source == view.getInapoiAdaugareTipFuraj()) {
			view.getPanouAdaugareTipFuraj().setVisible(false);
			view.getPanouFurajeCantitati().setVisible(true);
		}
		if(source == view.getAdaugareTipFuraj()) {
			view.getPanouAdaugareTipFuraj().setVisible(true);
			view.getPanouFurajeCantitati().setVisible(false);
		}
		
		if(source == view.getDetaliiMedieOxigen()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=3;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiMediePh()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=4;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiBalegar()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=5;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getVeziIstoricCurse()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=13;
			view.getPanouMasina().setVisible(false);
		}
		
		if(source == view.getVeziIstoricCurseLunar()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=14;
			view.getPanouMasina().setVisible(false);
		}
		
		if(source == view.getVeziIstoricRevizii()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=15;
			view.getPanouMasina().setVisible(false);
		}
		
		if(source == view.getVeziIstoricReparatii()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=16;
			view.getPanouMasina().setVisible(false);
		}
		
		if(source == view.getVeziIstoricAutorizatii()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=17;
			view.getPanouMasina().setVisible(false);
		}
		
		if(source == view.getInapoiSelectareAn()) {
			System.out.println();
			if(adaugare<=12) {
				view.getPanouSelectareAn().setVisible(false);
				view.getPanouBazin().setVisible(true);
			}
			else {
				view.getPanouSelectareAn().setVisible(false);
				view.getPanouMasina().setVisible(true);
			}
		}
		
		
		
		if(source == view.getSelectareAn()) {
			view.getPanouSelectareAn().setVisible(false);
			int an = view.getSelectareAnMeniu().getSelectedIndex()+120;
			java.util.Date utilDate = new java.util.Date();
			utilDate.setDate(1);
			utilDate.setMonth(1);
			utilDate.setYear(an);
			java.sql.Date sqlDate = convertJavaDateToSqlDate(utilDate);
			switch(adaugare) {
			case 1:
				view.resetListaIstoric();
				ArrayList<IstoricPeste> istoricPeste= IstoricPesteDAO.findById(idBazin, sqlDate);
				for (IstoricPeste istoricPeste2 : istoricPeste) {
					if(istoricPeste2.getTipOperatiune().contentEquals("Populare"))
						view.addToListaIstoric("La data de : " + istoricPeste2.getDataOperatiune()+ " in acest bazin a fost populata cantitatea de "+istoricPeste2.getCantitateOperatiune() +" Kg "+ istoricPeste2.getTipPeste());
					else
						view.addToListaIstoric("La data de : " + istoricPeste2.getDataOperatiune()+ " din acest bazin a fost pescuita cantitatea de "+istoricPeste2.getCantitateOperatiune() +" Kg "+ istoricPeste2.getTipPeste());
				}
				
			break;
			case 2:
				view.resetListaIstoric();
				ArrayList<IstoricFuraj> istoricFuraje= IstoricFurajDAO.findById(idBazin, sqlDate);
				for (IstoricFuraj istoricFuraj2 : istoricFuraje) {
					view.addToListaIstoric("La data de : " + istoricFuraj2.getDataOperatiune()+ " in acest bazin a fost adaugata cantitatea de "+istoricFuraj2.getCantitateOperatiune() +" Kg "+ istoricFuraj2.getTipFuraj());
				}
				
		    break;
			case 3:
				view.resetListaIstoric();
				ArrayList<IstoricOxigen> istoricOxigen= IstoricOxigenDAO.findById(idBazin, sqlDate);
				for (IstoricOxigen istoricOxigen2 : istoricOxigen) {
					view.addToListaIstoric("La data de : " + istoricOxigen2.getDataOperatiune()+ " in acest bazin o fost inregistrat procentul de "+istoricOxigen2.getProcentOxigen() +"% Oxigen ");
				}
				
			break;
			case 4:
				view.resetListaIstoric();
				ArrayList<IstoricPh> istoricPh= IstoricPhDAO.findById(idBazin, sqlDate);
				for (IstoricPh istoricPh2 : istoricPh) {
					view.addToListaIstoric("La data de : " + istoricPh2.getDataOperatiune()+ " in acest bazin o fost inregistrat nivelul de "+istoricPh2.getProcentPh() +" Ph ");
				}
				
			break;
			case 5:
				view.resetListaIstoric();
				ArrayList<IstoricFuraj> istoricFurajBalegar= IstoricFurajDAO.findByIdBalegar(idBazin, sqlDate);
				for (IstoricFuraj istoricFuraj2 : istoricFurajBalegar) {
					view.addToListaIstoric("La data de : " + istoricFuraj2.getDataOperatiune()+ " in acest bazin a fost adaugata cantitatea de "+istoricFuraj2.getCantitateOperatiune() +" Kg Balegar");
				}
				
			break;
			case 6:
				view.resetListaIstoric();
				ArrayList<IstoricTemperatura> istoricTemperatura= IstoricTemperaturaDAO.findById(idBazin, sqlDate);
				for (IstoricTemperatura istoricTemperatura2 : istoricTemperatura) {
					view.addToListaIstoric("La data de : " + istoricTemperatura2.getDataOperatiune()+ " in acest bazin a fost masurata temperatura de "+istoricTemperatura2.getTemperatura() +" grade C");
				}
			break;
			case 7:
				view.resetListaIstoric();
				ArrayList<IstoricNivelApa> istoricNivelApa= IstoricNivelApaDAO.findById(idBazin, sqlDate);
				for (IstoricNivelApa istoricNivelApa2 : istoricNivelApa) {
					view.addToListaIstoric("La data de : " + istoricNivelApa2.getDataOperatiune()+ " in acest bazin a fost masurat nivelul de apa de "+istoricNivelApa2.getNivelApa() +" M");
				}
		    break;
			case 8:
				view.resetListaIstoric();
				ArrayList<IstoricFuraj> istoricFurajFitoplancton= IstoricFurajDAO.findByIdFitoplancton(idBazin, sqlDate);
				for (IstoricFuraj istoricFuraj2 : istoricFurajFitoplancton) {
					view.addToListaIstoric("La data de : " + istoricFuraj2.getDataOperatiune()+ " in acest bazin a fost adaugata cantitatea de "+istoricFuraj2.getCantitateOperatiune() +" Kg Fitoplancton");
				}
		    break;
			case 9:
				view.resetListaIstoric();
				ArrayList<Date> data= IstoricDezinfectiiDAO.findById(idBazin, sqlDate);
				for (Date data2 : data) {
					view.addToListaIstoric("La data de : " + data2 + " in acest bazin a fost dezinfectat");
				}
			break;
			case 10:
				view.resetListaIstoric();
				ArrayList<Date> umplere= IstoricUmpleriDAO.findById(idBazin, sqlDate);
				for (Date umplere2 : umplere) {
					view.addToListaIstoric("La data de : " + umplere2 + " acest bazin a fost umplut");
				}
	        break;
			case 11:
				view.resetListaIstoric();
				ArrayList<Date> golire= IstoricGoliriDAO.findById(idBazin, sqlDate);
				for (Date golire2 : golire) {
					view.addToListaIstoric("La data de : " + golire2 + " acest bazin a fost golit");
				}
	        break;
			case 12:
				view.resetListaIstoric();
				ArrayList<IstoricPescuitProba> istoricPescuitProba= IstoricPescuitProbaDAO.findById(idBazin, sqlDate);
				for (IstoricPescuitProba istoricPescuitProba2 : istoricPescuitProba) {
					view.addToListaIstoric("La data de : " + istoricPescuitProba2.getDataPescuitProba()+ " in acest bazin a fost masurata greutatea medie de "+istoricPescuitProba2.getGreutateMedie() +" Kg");
				}
	        break;
			case 13:
				view.resetListaIstoric();
				ArrayList<MasiniCurse> masiniCurse= MasiniCurseDAO.findCurseById(idMasina, sqlDate);
				for (MasiniCurse masiniCurse2 : masiniCurse) {
					view.addToListaIstoric("La data de : " + masiniCurse2.getDataCursa()+ " a plecat in cursa soferul "+masiniCurse2.getSofer() + " la urmatoarele destinatii/destinatie "+ masiniCurse2.getDestinatie()+"  a parcurs dinstanta de "+ masiniCurse2.getKmParcursi()+" Km si a avut consumul de " + masiniCurse2.getConsum()+" l si costul de deplasare de "+ masiniCurse2.getCost()+ " lei");
				}
	        break;
			case 14:
				view.resetListaIstoric();
				ArrayList<MasiniLunar> masiniLunar= MasiniLunarDAO.findCurseByIdAndYear(idMasina, sqlDate);
				for (MasiniLunar masiniCurse2 : masiniLunar) {
					view.addToListaIstoric("In luna : " + (masiniCurse2.getLuna().getMonth()+1) +" masina a parcurs dinstanta de "+ masiniCurse2.getKmParcursi()+" Km si a avut consumul de " + masiniCurse2.getConsum()+" l" + " si a avut costul de " + masiniCurse2.getCost()+ " lei ");
				}
	        break;
			case 15:
				view.resetListaIstoric();
				ArrayList<MasiniRevizii> masiniRevizii= MasiniReviziiDAO.findReviziiById(idMasina, sqlDate);
				for (MasiniRevizii masiniCurse2 : masiniRevizii) {
					view.addToListaIstoric("A fost facuta o revizie la data de " + masiniCurse2.getDataRevizia() +" care expira la data de "+ masiniCurse2.getExpirareRevizie()+" urmatoarele piese au avut probleme: " + masiniCurse2.getPieseSchimbate() + " costul total a fost de : "+ masiniCurse2.getCost() + " lei");
				}
	        break;
			case 16:
				view.resetListaIstoric();
				ArrayList<MasiniReparatii> masiniReparatii= MasiniReparatiiDAO.findReparatiiById(idMasina, sqlDate);
				for (MasiniReparatii masiniCurse2 : masiniReparatii) {
					view.addToListaIstoric("La data de " + masiniCurse2.getDataReparatie() + " masina a fost dusa la reparat la mecanicul " + masiniCurse2.getMecanic() + " costul reparatiei a fost de " + masiniCurse2.getCost() + " lei iar urmatoarele probleme au fost constatate : " + masiniCurse2.getProblemeAparute());
				}
	        break;
			default:
				view.resetListaIstoric();
				ArrayList<MasiniAutorizatii> masiniAutorizatii= MasiniAutorizatiiDAO.findAutorizatiiById(idMasina, sqlDate);
				for (MasiniAutorizatii masiniCurse2 : masiniAutorizatii) {
					view.addToListaIstoric("Autorizatia "+masiniCurse2.getNumeAutorizatie()+" a fost facuta  la data de " + masiniCurse2.getDataAutorizatie() +" care expira la data de "+ masiniCurse2.getDataAutorizatieExpirare());
				}
		}
			view.crearePanouIstoric();
			view.getPanouIstoric().setVisible(true);
		}
		
		if(source == view.getInapoiIstoric()) {
			view.getPanouSelectareAn().setVisible(true);
			view.getPanouIstoric().setVisible(false);
		}
		
		if(source == view.getDetaliiTemperatura()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=6;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiNivelApa()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=7;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiCantitateFitoplancton()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=8;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiDezinfectie()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=9;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiUmplere()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=10;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getDetaliiGolire()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=11;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getPescuitDeProba()) {
			view.getPanouSelectareAn().setVisible(true);
			adaugare=12;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicPeste()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getPestiMeniu().setVisible(true);
			view.getFurajMeniu().setVisible(false);
			view.getAdaugareUnicTXT().setText("Introduceti cantitate de peste cu care doriti sa populati");
			adaugare=1;
			pus=1;
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicFuraj()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(true);
			adaugare=2;
			view.getAdaugareUnicTXT().setText("Scrieti cantitate de furaj introdusa in apa");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicOxigen()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=3;
			view.getAdaugareUnicTXT().setText("Introduceti cantitate de Oxigen inregistrata si data");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicPh()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=4;
			view.getAdaugareUnicTXT().setText("Introduceti valoare Ph-ului inregistrat si data");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicBalegar()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=5;
			view.getAdaugareUnicTXT().setText("Introduceti cantitatea de balegar adaugata si data");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicTemperatura()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=6;
			view.getAdaugareUnicTXT().setText("Introduceti temperatura masurata si data");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicNivelApa()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=7;
			view.getAdaugareUnicTXT().setText("Introduceti nivelul apei masurata si data");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicFitoplancton()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=8;
			view.getAdaugareUnicTXT().setText("Introduceti cantitatea de fitoplancton adaugata si data");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicDezinfectie()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(false);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=9;
			view.getAdaugareUnicTXT().setText("Introduceti data ultimei dezinfectii");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicUmplere()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(false);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=10;
			view.getAdaugareUnicTXT().setText("Introduceti data ultimei umpleri de bazin");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicGolire()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(false);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=11;
			view.getAdaugareUnicTXT().setText("Introduceti data ultimei goliri de bazin");
			view.getPanouBazin().setVisible(false);
		}
		
		if(source == view.getAdaugareUnicPescuitDeProba()) {
			view.getPanouAdaugareUnic().setVisible(true);
			view.getAdaugareUnicNR().setVisible(true);
			view.getPestiMeniu().setVisible(false);
			view.getFurajMeniu().setVisible(false);
			adaugare=12;
			view.getAdaugareUnicTXT().setText("Introduceti marimea medie a pestilor si data la care s-a efectuat pescuitul de proba");
			view.getPanouBazin().setVisible(false);
		}
		if(source == view.getInapoiAdaugareUnic()) {
			view.getPanouAdaugareUnic().setVisible(false);
			view.getAdaugareUnicNR().setText(" Introduceti_cantitate_(zecimalele_sunt_despartite_de_._nu_de_,)_");
			view.getSelectareZiAdaugareUnic().setSelectedIndex(0);
			view.getSelectareLunaAdaugareUnic().setSelectedIndex(0);
			view.getSelectareAnAdaugareUnic().setSelectedIndex(0);
			this.actualizareDate();
			view.getPanouBazin().setVisible(true);
		}
		
		if(source == view.getAdaugareUnic()) {
			
			int zi = view.getSelectareZiAdaugareUnic().getSelectedIndex()+1;
			int luna = view.getSelectareLunaAdaugareUnic().getSelectedIndex();
			int an = view.getSelectareAnAdaugareUnic().getSelectedIndex()+120;
			
			java.util.Date utilDate = new java.util.Date();
			utilDate.setDate(zi);
			utilDate.setMonth(luna);
			utilDate.setYear(an);
			System.out.println("java.util.Date : " + utilDate);

			java.sql.Date sqlDate = convertJavaDateToSqlDate(utilDate);
			System.out.println("java.sql.Date : " + sqlDate);
			switch(adaugare) {
				case 1:
					int idTipPeste=view.getPestiMeniu().getSelectedIndex();
					if(idTipPeste!=0) {
						float cantitate =Float.valueOf(view.getAdaugareUnicNR().getText());
						if(pus==1)
							IstoricPesteDAO.insertIntoIstoricPeste(idBazin, idTipPeste, cantitate, sqlDate, "Populare");
						else
							IstoricPesteDAO.insertIntoIstoricPeste(idBazin, idTipPeste, cantitate, sqlDate, "Pescuire");
					}
				break;
				case 2:
					int idTipFuraj=view.getFurajMeniu().getSelectedIndex()+2;
					if(idTipFuraj!=0) {
						float cantitate =Float.valueOf(view.getAdaugareUnicNR().getText());
						IstoricFurajDAO.insertIntoIstoricFuraje(idBazin, idTipFuraj, cantitate, sqlDate);
					}
			    break;
				case 3:
					float procentOxigen =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricOxigenDAO.insertIntoIstoricOxigen(idBazin, procentOxigen, sqlDate);
				break;
				case 4:
					float valoarePh =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricPhDAO.insertIntoIstoricPh(idBazin, valoarePh, sqlDate);
				break;
				case 5:
					float cantitateBalegar =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricFurajDAO.insertIntoIstoricFuraje(idBazin, 1, cantitateBalegar, sqlDate);
				break;
				case 6:
					float teperatura =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricTemperaturaDAO.insertIntoIstoricTemperatura(idBazin, teperatura, sqlDate);
				break;
				case 7:
					float nivelApa =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricNivelApaDAO.insertIntoIstoricNivelApa(idBazin, nivelApa, sqlDate);
			    break;
				case 8:
					float cantitateFitoplancton =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricFurajDAO.insertIntoIstoricFuraje(idBazin, 2, cantitateFitoplancton, sqlDate);
			    break;
				case 9:
					IstoricDezinfectiiDAO.insertIntoIstoricDezinfectie(idBazin, sqlDate);
				break;
				case 10:
					IstoricUmpleriDAO.insertIntoIstoricUmpleri(idBazin, sqlDate);
		        break;
				case 11:
					IstoricGoliriDAO.insertIntoIstoricGoliri(idBazin, sqlDate);
		        break;
				default:
					float marimeMedie =Float.valueOf(view.getAdaugareUnicNR().getText());
					IstoricPescuitProbaDAO.insertIntoIstoricIstoricPescuitProba(idBazin, marimeMedie, sqlDate);
			}
			
		}
		if(source == view.getAdaugaBazin()) {
			view.getPanouBazine().setVisible(false);
			adaugareMare=1;
			view.getAdaugareTXT().setText("Introduceti numele bazinului pe care doriti sa il adaugati ");
			view.getAdaugareNR().setText("numele_Bazinului");
			view.getPanouAdaugare().setVisible(true);
		}
		if(source == view.getAdaugaMasina()) {
			view.getPanouMasini().setVisible(false);
			adaugareMare=2;
			view.getAdaugareTXT().setText("Introduceti numele masinii pe care doriti sa o adaugati ");
			view.getAdaugareNR().setText("numele_Masinii");
			view.getPanouAdaugare().setVisible(true);
		}
		if(source == view.getInapoiAdaugare()) {
			if(adaugareMare==1) {
				view.getPanouBazine().setVisible(true);
				view.getPanouAdaugare().setVisible(false);
			}
			else {
				view.getPanouMasini().setVisible(true);
				view.getPanouAdaugare().setVisible(false);
			}
		}
		if(source == view.getAdaugare()) {
			String nume =view.getAdaugareNR().getText();
			System.out.println(nume);
			if(adaugareMare==1) {
				BazineDAO.AdaugaBazin(nume);
			}
			else {
				MasiniDAO.AdaugaMasina(nume);
			}
		}
		
		if(source == view.getAduagaReparatie()) {
			view.getPanouMasina().setVisible(false);
			view.getPanouAdaugareReparatie().setVisible(true);
		}
		
		if(source == view.getInapoiAdaugareReparatie()) {
			view.getPanouMasina().setVisible(true);
			view.getPanouAdaugareReparatie().setVisible(false);
			view.getAdaugareReparatieCostNR().setText("Introduceti_costul_reparatiei");
			view.getAdaugareReparatieMecanicNR().setText("Introduceti_numele_mecanicului");
			view.getAdaugareReparatieProblemeAparuteNR().setText("Introduceti_problemele_defectiunile_sesizate_de_mecanic_in_urma_repararii");
			view.getSelectareZiAdaugareReparatieData().setSelectedIndex(0);
			view.getSelectareLunaAdaugareReparatieData().setSelectedIndex(0);
			view.getSelectareAnAdaugareReparatieData().setSelectedIndex(0);
			this.actualizareMasini();
		}
		
		if(source == view.getAdaugareReparatie()) {
			int zi = view.getSelectareZiAdaugareReparatieData().getSelectedIndex()+1;
			int luna = view.getSelectareLunaAdaugareReparatieData().getSelectedIndex();
			int an = view.getSelectareAnAdaugareReparatieData().getSelectedIndex()+120;
			java.util.Date utilDate = new java.util.Date();
			utilDate.setDate(zi);
			utilDate.setMonth(luna);
			utilDate.setYear(an);
			java.sql.Date sqlDate = convertJavaDateToSqlDate(utilDate);
			MasiniReparatiiDAO.AdaugaReparatie(idMasina, Float.valueOf(view.getAdaugareReparatieCostNR().getText()), view.getAdaugareReparatieMecanicNR().getText(), view.getAdaugareReparatieProblemeAparuteNR().getText(), sqlDate);
			
		}
		
		if(source == view.getAduagaRevizie()) {
			view.getAdaugareRevizie().setText("Adauga revizia");
			view.getAdaugareRevizieCostNR().setVisible(true);
			view.getAdaugareRevizieCostTXT().setVisible(true);
			view.getAdaugareRevizieTXT().setText("Introduceti data la care a fost facuta revizia");
			view.getAdaugareRevizieExpirareTXT().setText("Introduceti data la care expira revizia");
			view.getAdaugareRevizieProblemeAparuteNR().setText("Introduceti_problemele_constatate_de_mecanic");
			view.getAdaugareRevizieProblemeAparuteTXT().setText("Introduceti problemele constatate de mecanic: ");
			view.getPanouMasina().setVisible(false);
			view.getPanouAdaugareRevizie().setVisible(true);
			adaugareASR=1;
		}
		
		if(source == view.getInapoiAdaugareRevizie()) {
			view.getPanouAdaugareRevizie().setVisible(false);
			view.getSelectareZiAdaugareRevizie().setSelectedIndex(0);
			view.getSelectareLunaAdaugareRevizie().setSelectedIndex(0);
			view.getSelectareAnAdaugareRevizie().setSelectedIndex(0);
			view.getSelectareZiAdaugareRevizieExpirare().setSelectedIndex(0);
			view.getSelectareLunaAdaugareRevizieExpirare().setSelectedIndex(0);
			view.getSelectareAnAdaugareRevizieExpirare().setSelectedIndex(0);
			this.actualizareMasini();
			view.getPanouMasina().setVisible(true);
		}
		
		if(source == view.getAdaugareRevizie()) {
			int zi = view.getSelectareZiAdaugareRevizie().getSelectedIndex()+1;
			int luna = view.getSelectareLunaAdaugareRevizie().getSelectedIndex();
			int an = view.getSelectareAnAdaugareRevizie().getSelectedIndex()+120;
			java.util.Date utilDate = new java.util.Date();
			utilDate.setDate(zi);
			utilDate.setMonth(luna);
			utilDate.setYear(an);
			java.sql.Date sqlDate = convertJavaDateToSqlDate(utilDate);
			
			int zi2 = view.getSelectareZiAdaugareRevizieExpirare().getSelectedIndex()+1;
			int luna2 = view.getSelectareLunaAdaugareRevizieExpirare().getSelectedIndex();
			int an2 = view.getSelectareAnAdaugareRevizieExpirare().getSelectedIndex()+120;
			java.util.Date utilDate2 = new java.util.Date();
			utilDate2.setDate(zi2);
			utilDate2.setMonth(luna2);
			utilDate2.setYear(an2);
			java.sql.Date sqlDate2 = convertJavaDateToSqlDate(utilDate2);
			String pieseSchimbate=view.getAdaugareRevizieProblemeAparuteNR().getText();
			if(adaugareASR==1) {
				
				float cost=Float.valueOf(view.getAdaugareRevizieCostNR().getText());
				MasiniReviziiDAO.AdaugaRevizie(idMasina, sqlDate, sqlDate2, cost, pieseSchimbate);
			}
			else {
				MasiniAutorizatiiDAO.AdaugaAutorizatie(idMasina, sqlDate, sqlDate2, pieseSchimbate);
			}
		}
		
		if(source == view.getAdaugaCursa()) {
			view.getPanouMasina().setVisible(false);
			view.getPanouAdaugareCursa().setVisible(true);
		}
		
		if(source == view.getInapoiAdaugareCursa()) {
			view.getPanouAdaugareCursa().setVisible(false);

			view.getSelectareZiAdaugareCursa().setSelectedIndex(0);
			view.getSelectareLunaAdaugareCursa().setSelectedIndex(0);
			view.getSelectareAnAdaugareCursa().setSelectedIndex(0);
			
			view.getAdaugareCursaSoferNR().setText("Introduceti_numele_soferului");
			view.getAdaugareCursaDistantaNR().setText("Introduceti_distanta_parcursa");
			view.getAdaugareCursaConsumNR().setText("Introduceti_consumul");
			view.getAdaugareCursaDestinatieNR().setText("Introduceti_destinatia_destinatiile");
			view.getAdaugareCursaPretPerLitruNR().setText("cost_per_litru");
			this.actualizareMasini();
			
			view.getPanouMasina().setVisible(true);
		}
		
		if(source == view.getAdaugareCursa()) {
			int zi = view.getSelectareZiAdaugareCursa().getSelectedIndex()+1;
			int luna = view.getSelectareLunaAdaugareCursa().getSelectedIndex();
			int an = view.getSelectareAnAdaugareCursa().getSelectedIndex()+120;
			java.util.Date utilDate = new java.util.Date();
			utilDate.setDate(zi);
			utilDate.setMonth(luna);
			utilDate.setYear(an);
			java.sql.Date sqlDate = convertJavaDateToSqlDate(utilDate);
			MasiniCurseDAO.AdaugaCursa(idMasina, view.getAdaugareCursaSoferNR().getText(), Float.valueOf(view.getAdaugareCursaConsumNR().getText()), Float.valueOf(view.getAdaugareCursaPretPerLitruNR().getText()), Float.valueOf(view.getAdaugareCursaDistantaNR().getText()), view.getAdaugareCursaDestinatieNR().getText(), sqlDate);
		}
		
		if(source == view.getAdaugareAutorizatie()) {
			view.getAdaugareRevizie().setText("Adauga autorizatia");
			view.getAdaugareRevizieCostNR().setVisible(false);
			view.getAdaugareRevizieCostTXT().setVisible(false);
			view.getAdaugareRevizieTXT().setText("Introduceti data la care a fost facuta autorizatia");
			view.getAdaugareRevizieExpirareTXT().setText("Introduceti data la care expira autorizatia");
			view.getAdaugareRevizieProblemeAparuteNR().setText("Introduceti_numele_autorizatiei");
			view.getAdaugareRevizieProblemeAparuteTXT().setText("Introduceti numele autorizatiei: ");
			view.getPanouMasina().setVisible(false);
			view.getPanouAdaugareRevizie().setVisible(true);
			adaugareASR=2;
		}
		
	}
	public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date)
	{
		// java.util.Date contains both date and time information
		// java.sql.Date contains only date information (without time)
		return new java.sql.Date(date.getTime());
	}
}