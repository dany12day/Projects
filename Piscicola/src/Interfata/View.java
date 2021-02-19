package Interfata;
import java.awt.GridBagLayout;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

import ConexiuneBazaDate.ConexiuneBazaDate;
import DAO.BazinDAO;
import DAO.BazineDAO;
import DAO.DetaliiCantitatiFurajeDAO;
import DAO.DetaliiCantitatiPesteDAO;
import DAO.MasiniDAO;
import DAO.MasiniReviziiDAO;
import Model.Bazin;
import Model.DetaliiCantitatiFuraje;
import Model.DetaliiCantitatiPeste;
import Model.Masini;
import Model.MasiniRevizii;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class View extends JFrame{
	
	private static final long serialVersionUID = 1L;

	Controller controller = new Controller(this);
	private JPanel panou = new JPanel(new GridBagLayout());
	
	private JPanel panouPrincipal = new JPanel(new GridBagLayout());
	private JPanel panouBazine = new JPanel(new GridBagLayout());
	private JPanel panouBazin = new JPanel(new GridBagLayout());
	private JPanel panouPesteCantitati = new JPanel(new GridBagLayout());
	private JPanel panouFurajeCantitati = new JPanel(new GridBagLayout());
	private JPanel panouMasini = new JPanel(new GridBagLayout());
	private JPanel panouGeneral = new JPanel(new GridBagLayout());
	private JPanel panouAngajati = new JPanel(new GridBagLayout());
	private JPanel panouResetareBazin = new JPanel(new GridBagLayout());
	private JPanel panouAdaugareTipPeste = new JPanel(new GridBagLayout());
	private JPanel panouAdaugareTipFuraj = new JPanel(new GridBagLayout());
	private JPanel panouSelectareAn = new JPanel(new GridBagLayout());
	private JPanel panouIstoric = new JPanel(new GridBagLayout());
	private JPanel panouAdaugareUnic = new JPanel(new GridBagLayout());
	private JPanel panouMasina = new JPanel(new GridBagLayout());
	private JPanel panouAdaugare = new JPanel(new GridBagLayout());
	private JPanel panouAdaugareCursa = new JPanel(new GridBagLayout());
	private JPanel panouAdaugareRevizie = new JPanel(new GridBagLayout());
	private JPanel panouAdaugareReparatie = new JPanel(new GridBagLayout());
	
	private GridBagConstraints cPrincipal = new GridBagConstraints();
	private GridBagConstraints cBazine = new GridBagConstraints();
	private GridBagConstraints cBazin = new GridBagConstraints();
	private GridBagConstraints cPeste = new GridBagConstraints();
	private GridBagConstraints cFuraje = new GridBagConstraints();
	private GridBagConstraints cMasini = new GridBagConstraints();
	private GridBagConstraints cGeneral = new GridBagConstraints();
	private GridBagConstraints cAngajati = new GridBagConstraints();
	private GridBagConstraints cResetareBazin = new GridBagConstraints();
	private GridBagConstraints cAdaugareTipPeste = new GridBagConstraints();
	private GridBagConstraints cAdaugareTipFuraj = new GridBagConstraints();
	private GridBagConstraints cSelectareAn = new GridBagConstraints();
	private GridBagConstraints cIstoric = new GridBagConstraints();
	private GridBagConstraints cAdaugareUnic = new GridBagConstraints();
	private GridBagConstraints cMasina = new GridBagConstraints();
	private GridBagConstraints cAdaugare = new GridBagConstraints();
	private GridBagConstraints cAdaugareCursa = new GridBagConstraints();
	private GridBagConstraints cAdaugareRevizie = new GridBagConstraints();
	private GridBagConstraints cAdaugareReparatie = new GridBagConstraints();
	
	private JButton bazine = new JButton("Bazine");
	private JButton masini = new JButton("Masini");
	private JButton general = new JButton("General");
	private JButton angajati = new JButton("Angajati");
	private JButton bazin1 = new JButton("Bazin_1");
	private JButton bazin2 = new JButton("Bazin_2");
	private JButton masina1 = new JButton("Masina_1");
	private JButton detaliiCantitatePeste = new JButton("Vezi detalii cantiati");
	private JButton detaliiCantitateFuraje = new JButton("Vezi detalii furaje");
	private JButton detaliiMedieOxigen = new JButton("Vezi istoric oxigen");
	private JButton detaliiMediePh = new JButton("Vezi istoric Ph");
	private JButton detaliiBalegar = new JButton("Vezi detalii balegar");
	private JButton detaliiTemperatura = new JButton("Vezi istoric temperaturi");
	private JButton detaliiNivelApa = new JButton("Vezi istoric nivel de apa");
	private JButton detaliiCantitateFitoplancton = new JButton("Vezi detalii fitoplancton");
	private JButton detaliiDezinfectie = new JButton("Vezi istoric dezinfectari");
	private JButton detaliiUmplere = new JButton("Vezi istoric umplere");
	private JButton detaliiGolire = new JButton("Vezi istoric golire");
	private JButton pescuitDeProba = new JButton("Vezi istoricul pescuirilor de proba");
	private JButton adaugareUnicPeste = new JButton("Adauga in bazin peste");
	private JButton adaugareUnicFuraj = new JButton("Adauga in bazin furaj");
	private JButton adaugareUnicOxigen = new JButton("Adauga o masurare de Oxigen");
	private JButton adaugareUnicPh = new JButton("Adauga o masurare de Ph");
	private JButton adaugareUnicBalegar = new JButton("Adauga in bazin Balegar");
	private JButton adaugareUnicTemperatura = new JButton("Adauga o masurare de Temperatura");
	private JButton adaugareUnicNivelApa = new JButton("Adauga o masurare de Nivel de Apa");
	private JButton adaugareUnicFitoplancton = new JButton("Adauga o masurare de Fitoplancton");
	private JButton adaugareUnicDezinfectie = new JButton("Adauga data de Dezinfectare");
	private JButton adaugareUnicUmplere = new JButton("Adauga data de Umplere");
	private JButton adaugareUnicGolire = new JButton("Adauga data de Golire");
	private JButton adaugareUnicPescuitDeProba = new JButton("Adauga o pescuire de proba");
	private JButton istoricPeste = new JButton("Vizualizare istoric");
	private JButton adaugarePeste = new JButton("Adauga cantiate peste");
	private JButton scoaterePeste = new JButton("Scoate cantitate peste");
	private JButton adaugareTipPeste = new JButton("Adauga un nou tip de peste");
	private JButton istoricFuraje = new JButton("Vizualizare istoric");
	private JButton adaugareFuraj = new JButton("Adauga cantiate furaje");
	private JButton adaugareTipFuraj = new JButton("Adauga un nou tip de furaj");
	private JButton resetareBazin = new JButton("Resetare bazin");
	private JButton resetareBazinDa = new JButton("Da");
	private JButton resetareBazinNu = new JButton("Nu");
	private JButton adaugaPeste = new JButton("Adaugati");
	private JButton scoatePeste = new JButton("Scoateti");
	private JButton introducereTipPeste = new JButton("Adaugati");
	private JButton adaugaFuraj = new JButton("Adaugati");
	private JButton introducereTipFuraj = new JButton("Adaugati");
	private JButton selectareAn = new JButton("Cautati");
	private JButton adaugareUnic = new JButton("Adaugati");
	private JButton cautaBazin = new JButton("Cauta Bazin");
	private JButton adaugareTipPesteFinal = new JButton("Adauga un nou tip de peste");
	private JButton adaugareTipFurajFinal = new JButton("Adauga un nou tip de peste");
	private JButton cautaMasina = new JButton("Cauta Masina");
	private JButton adaugaMasina = new JButton("Adauga Masina");
	private JButton adaugaBazin = new JButton("Adauga Bazin");
	private JButton veziIstoricCurse = new JButton("Vizualizati istoricul curselor");
	private JButton adaugaCursa = new JButton("Adaugati o cursa");
	private JButton veziIstoricCurseLunar = new JButton("Vizualizati istoricul curselor lunar");
	private JButton veziIstoricRevizii= new JButton("Vizualizati istoricul reviziilor");
	private JButton aduagaRevizie = new JButton("Adauga o revizie");
	private JButton veziIstoricReparatii= new JButton("Vizualizati istoricul reparatiilor");
	private JButton aduagaReparatie = new JButton("Adauga o reparatie");
	private JButton adaugare = new JButton("Adauga");
	private JButton adaugareCursa= new JButton("Adaugati cursa");
	private JButton adaugareRevizie = new JButton("Adaugati o revizia");
	private JButton adaugareReparatie = new JButton("Adaugati o reparatie");
	private JButton adaugareAutorizatie = new JButton("Adaugati o autorizatie");
	private JButton veziIstoricAutorizatii = new JButton("Vezi istoric autorizatii");
	
	private JButton inapoiBazine = new JButton("Inapoi");
	private JButton inapoiBazin = new JButton("Inapoi");
	private JButton inapoiMasini = new JButton("Inapoi");
	private JButton inapoiMasina = new JButton("Inapoi");
	private JButton inapoiGeneral = new JButton("Inapoi");
	private JButton inapoiAngajati = new JButton("Inapoi");
	private JButton inapoiPeste = new JButton("Inapoi");
	private JButton inapoiAdaugareTipPeste = new JButton("Inapoi");
	private JButton inapoiFuraj = new JButton("Inapoi");
	private JButton inapoiAdaugareTipFuraj = new JButton("Inapoi");
	private JButton inapoiSelectareAn = new JButton("Inapoi");
	private JButton inapoiIstoric = new JButton("Inapoi");
	private JButton inapoiAdaugareUnic = new JButton("Inapoi");
	private JButton inapoiAdaugare = new JButton("Inapoi");
	private JButton inapoiAdaugareCursa = new JButton("Inapoi");
	private JButton inapoiAdaugareRevizie = new JButton("Inapoi");
	private JButton inapoiAdaugareReparatie = new JButton("Inapoi");
	
	private JLabel cantitatePesteTXT = new JLabel("Cantitate totala de peste ramasa : ");
	private JLabel cantitatePesteNR = new JLabel("           ");
	private JLabel cantitateFurajeTXT = new JLabel("Cantitate totala furaje:");
	private JLabel cantitateFurajeNR = new JLabel("            ");
	private JLabel medieOxigenTXT = new JLabel("Medie Oxigen:");
	private JLabel medieOxigenNR = new JLabel("             ");
	private JLabel mediePhTXT = new JLabel("Medie Ph:");
	private JLabel mediePhNR = new JLabel("             ");
	private JLabel cantitateBalegarTXT = new JLabel("Cantitate Balegar:");
	private JLabel cantitateBalegarNR = new JLabel("1");
	private JLabel medieTemperaturaTXT = new JLabel("Medie Temperatura:");
	private JLabel medieTemperaturaNR = new JLabel("             ");
	private JLabel medieNivelApaTXT = new JLabel("Medie nivel apa:");
	private JLabel medieNivelApaNR = new JLabel("             ");
	private JLabel cantitateFitoplanctonTXT = new JLabel("Cantiatate fitoplacton:");
	private JLabel cantitateFitoplanctonNR = new JLabel("             ");
	private JLabel dezinfectieTXT = new JLabel("Ultima dezinfectare:");
	private JLabel dezinfectieNR = new JLabel("             ");
	private JLabel umplereTXT = new JLabel("Ultima umplere:");
	private JLabel umplereNR = new JLabel("             ");
	private JLabel golireTXT = new JLabel("Ultima golire:");
	private JLabel golireNR = new JLabel("             ");
	private JLabel tipPesteTXT = new JLabel("Tip Peste");
	private JLabel tipFurajTXT = new JLabel("Tip Furaj");
	private JLabel cantitatePesteIntrodusaTXT = new JLabel("Cantitade de peste introdusa");
	private JLabel cantitateFurajIntrodusaTXT = new JLabel("Cantitade de furaje introduse");
	private JLabel cantitatePesteScoasaTXT = new JLabel("Cantitade de peste scoasa");
	private JLabel cantitatePesteSiguraMinimaTXT = new JLabel("Cantitade de peste ramasa");
	private JLabel cantitatePesteEstimataTXT = new JLabel("Cantitade de peste aproximata");
	private JLabel resetareBazinTXT = new JLabel("Sunteti sigur ca doriti sa stergeti datele din acest bazin. Toate datele actuale se vor sterge insa acestea vor ramane salvate in istoric");
	private JLabel introducereTipPesteTXT = new JLabel("Scrieti tipul de peste pe care doriti sa il introduceti: ");
	private JLabel introducereTipFurajTXT = new JLabel("Scrieti tipul de furaj pe care doriti sa il introduceti: ");
	private JLabel tipPesteIsotricTXT = new JLabel("Tip Peste");
	private JLabel dataPesteIstoricTXT = new JLabel("Data");
	private JLabel tipOperatiunePesteIstoricTXT = new JLabel("Scos/Introdus");
	private JLabel cantitatePesteIntrodusaIstoricTXT = new JLabel("Cantitate de peste");
	private JLabel pescuitDeProbaTXT = new JLabel("Greutatea medie a pestilor si data ultimei verificari");
	private JLabel pescuitDeProbaNR = new JLabel("                        ");
	private JLabel adaugareUnicTXT = new JLabel("Introduceti datele inregistrate");
	private JLabel adaugareTipPesteFinalTXT = new JLabel("Introduceti noul tip de peste");
	private JLabel adaugareTipFurajFinalTXT = new JLabel("Introduceti noul tip de furaj");
	private JLabel distantaParcursaTXT = new JLabel("Distanta parcursa de acest autovehicul:");
	private JLabel consumRealizatTXT = new JLabel("Cantitatea de combustibil utilizata de acest autovehicul:");
	private JLabel costFunctionareTXT = new JLabel("Costul generat de vehicul:");
	private JLabel dataRevizieTXT = new JLabel("Data la care a fost efectuata ultima revizie:");
	private JLabel dataExpirareRevizieTXT = new JLabel("Data la care expira ultima revizie:");
	private JLabel distantaParcursaNR = new JLabel("         0           ");
	private JLabel consumRealizatNR = new JLabel("           0        ");
	private JLabel costFunctionareNR = new JLabel("          0         ");
	private JLabel dataRevizieNR = new JLabel("          0         ");
	private JLabel dataExpirareRevizieNR = new JLabel("             0           ");
	private JLabel spatiu1 = new JLabel("                       ");
	private JLabel spatiu2 = new JLabel("                       ");
	private JLabel adaugareTXT = new JLabel("                       ");
	private JLabel adaugareCursaSoferTXT = new JLabel("Introduceti numele soferului");
	private JLabel adaugareCursaDistantaTXT = new JLabel("Introduceti distanta parcursa");
	private JLabel adaugareCursaConsumTXT = new JLabel("Introduceti consumul");
	private JLabel adaugareCursaPretPerLitruTXT = new JLabel("Introduceti pretul platit per litru de combustibil");
	private JLabel adaugareCursaDestinatieTXT = new JLabel("Introduceti destinatia");
	private JLabel adaugareCursaDataTXT = new JLabel("Introduceti data");
	private JLabel adaugareRevizieTXT = new JLabel("Introduceti data la care a fost facuta revizia");
	private JLabel adaugareRevizieExpirareTXT = new JLabel("Introduceti data la care revizia expira");
	private JLabel adaugareRevizieCostTXT = new JLabel("Introduceti costul reviziei");
	private JLabel adaugareRevizieProblemeAparuteTXT = new JLabel("Introduceti problemele defectiunile sesizate de mecanic in urma reviziei");
	private JLabel adaugareReparatieCostTXT = new JLabel("Introduceti costul reparatiei");
	private JLabel adaugareReparatieMecanicTXT = new JLabel("Introduceti firma care a realizat reparatiile");
	private JLabel adaugareReparatieDataTXT = new JLabel("Introduceti data la care a fost efectuata reparatia");
	private JLabel adaugareReparatieProblemeAparuteTXT = new JLabel("Introduceti problemele constatate de mecanic");
	
	private JLabel selectareAnTXT = new JLabel("Alegeti anul al carui istoric doriti sa il vizualizati");
	
	private int nrTipuriPesti=0;
	private JLabel[] tipPeste = new JLabel[100];
	private String[] tipPesteSTR;
	private JLabel[] cantitatePesteIntrodusa = new JLabel[100];
	private JLabel[] cantitatePesteScoasa = new JLabel[100];
	private JLabel[] cantitatePesteSiguraMinima = new JLabel[100];
	private JLabel[] cantitatePesteEstimata = new JLabel[100];
	
	private int nrTipuriFuraje=0;
	private JLabel[] tipFuraj = new JLabel[100];
	private JLabel[] cantitateFurajIntrodusa = new JLabel[100];
	private String[] tipFurajSTR;
	
	private JLabel[] gol = new JLabel[10000];
	
	private JComboBox pestiMeniu = new JComboBox();
	private JComboBox furajMeniu = new JComboBox();
	private JComboBox selectareAnMeniu = new JComboBox();
	private JComboBox selectareZiAdaugareUnic = new JComboBox();
	private JComboBox selectareLunaAdaugareUnic = new JComboBox();
	private JComboBox selectareAnAdaugareUnic = new JComboBox();
	private JComboBox selectareBazin = new JComboBox();
	private JComboBox selectareMasina = new JComboBox();
	private JComboBox selectareZiAdaugareCursa = new JComboBox();
	private JComboBox selectareLunaAdaugareCursa = new JComboBox();
	private JComboBox selectareAnAdaugareCursa = new JComboBox();
	private JComboBox selectareZiAdaugareRevizie = new JComboBox();
	private JComboBox selectareLunaAdaugareRevizie = new JComboBox();
	private JComboBox selectareAnAdaugareRevizie = new JComboBox();
	private JComboBox selectareZiAdaugareRevizieExpirare = new JComboBox();
	private JComboBox selectareLunaAdaugareRevizieExpirare = new JComboBox();
	private JComboBox selectareAnAdaugareRevizieExpirare = new JComboBox();
	private JComboBox selectareZiAdaugareReparatieData = new JComboBox();
	private JComboBox selectareLunaAdaugareReparatieData = new JComboBox();
	private JComboBox selectareAnAdaugareReparatieData = new JComboBox();
	         
	private JTextField cantitateDePesteAdaugata = new JTextField("Introduceti_cantitatea_de_peste_aduagata");
	private JTextField cantitateDePesteScoasa = new JTextField("Introduceti_cantitatea_de_peste_scoasa");
	private JTextField introducereTipPesteNR = new JTextField("Introduceti_numele_pestelui");
	private JTextField cantitateDeFurajAdaugata = new JTextField("Introduceti_cantitatea_de_furaj_aduagata");
	private JTextField introducereTipFurajNR = new JTextField("Introduceti_numele_furajului");
	private JTextField adaugareUnicNR = new JTextField("Introduceti_cantitate_(zecimalele_sunt_despartite_de_._nu_de_,)");
	private JTextField adaugareTipPesteFinalNr = new JTextField("Introduceti_numele_Pestelui");
	private JTextField adaugareTipFurajFinalNr = new JTextField("Introduceti_numele_furajului");
	private JTextField adaugareNR = new JTextField("                    ");
	private JTextField adaugareCursaSoferNR = new JTextField("Introduceti_numele_soferului");
	private JTextField adaugareCursaDistantaNR = new JTextField("Introduceti_distanta_parcursa");
	private JTextField adaugareCursaConsumNR = new JTextField("Introduceti_consumul");
	private JTextField adaugareCursaDestinatieNR = new JTextField("Introduceti_destinatia_destinatiile");
	private JTextField adaugareRevizieCostNR = new JTextField("Introduceti_costul_reviziei");
	private JTextField adaugareRevizieProblemeAparuteNR = new JTextField("Introduceti_problemele_defectiunile_sesizate_de_mecanic_in_urma_reviziei");
	private JTextField adaugareReparatieCostNR = new JTextField("Introduceti_costul_reparatiei");
	private JTextField adaugareReparatieMecanicNR = new JTextField("Introduceti_numele_mecanicului");
	private JTextField adaugareReparatieProblemeAparuteNR = new JTextField("Introduceti_problemele_defectiunile_sesizate_de_mecanic_in_urma_repararii");
	private JTextField adaugareCursaPretPerLitruNR = new JTextField("cost_per_litru");

	
	private ArrayList<String> listaIstoric = new ArrayList<>(100);
	private JScrollPane scrollPane = new JScrollPane();

	
	public View(String name) {
		super(name);
		
		panouPrincipal.setVisible(true);
		panou.add(panouPrincipal);
		
		panouBazine.setVisible(false);
		panou.add(panouBazine);
		
		panouPesteCantitati.setVisible(false);
		panou.add(panouPesteCantitati);
		
		panouBazin.setVisible(false);
		panou.add(panouBazin);
		
		panouAdaugare.setVisible(false);
		panou.add(panouAdaugare);
		
		panouAdaugareTipPeste.setVisible(false);
		panou.add(panouAdaugareTipPeste);
		
		panouFurajeCantitati.setVisible(false);
		panou.add(panouFurajeCantitati);
		
		panouAdaugareTipFuraj.setVisible(false);
		panou.add(panouAdaugareTipFuraj);
		
		panouResetareBazin.setVisible(false);
		panou.add(panouResetareBazin);
		
		panouMasini.setVisible(false);
		panou.add(panouMasini);
		
		panouMasina.setVisible(false);
		panou.add(panouMasina);
		
		panouAngajati.setVisible(false);
		panou.add(panouAngajati);
		
		panouSelectareAn.setVisible(false);
		panou.add(panouSelectareAn);
		
		panouIstoric.setVisible(false);
		panou.add(panouIstoric);
		
		panouAdaugareUnic.setVisible(false);
		panou.add(panouAdaugareUnic);
		
		panouAdaugareCursa.setVisible(false);
		panou.add(panouAdaugareCursa);
		
		panouAdaugareRevizie.setVisible(false);
		panou.add(panouAdaugareRevizie);
		
		panouAdaugareReparatie.setVisible(false);
		panou.add(panouAdaugareReparatie);
		
		this.crearePanouPrincipal();
		
		this.crearePanouBazine();
		
		this.crearePanouMasini();
		
		this.crearePanouMasina();
		
		this.crearePanouAngajati();
		
		this.crearePanouGeneral();
		
		try {
			this.fillBazine(BazinDAO.findById(1), DetaliiCantitatiPesteDAO.findByIdBazin(1), DetaliiCantitatiFurajeDAO.findById(1));
			
			this.fillMasina(MasiniDAO.findById(1) , MasiniReviziiDAO.findultimaReviziiById(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.crearePanouBazin();
		
		this.crearePanouPesteCantitati();
		
		this.crearePanouFurajeCantitati();
		
		this.crearePanouResetareBazin();
		
		this.crearePanouSelectareAn();
		
		this.crearePanouAdaugareTipFuraj();
		
		this.crearePanouAdaugareTipPeste();
		
		this.crearePanouIstoric();
		
		this.crearePanouAdaugareUnic();
		
		this.crearePanouAdaugare();
		
		this.crearePanouAdaugareReparatie();
		
		this.crearePanouAdaugareRevizie();
		
		this.crearePanouAdaugareCursa();
		
		this.add(panou);
	}
	
	public void crearePanouPrincipal() {
		panouPrincipal.removeAll();
		
		for(int i=0; i<10000; i++) {
			gol[i]= new JLabel("                    ");
		}
		
		for(int i=0; i<60; i++) {
			for(int j=0; j<21; j++) {
				if((j%2==0 && i==1) || i!=10) {
					cPrincipal.gridx=j;
					cPrincipal.gridy=i;
					panouPrincipal.add(gol[i+j],cPrincipal);
				}
			}
		}
		
		cPrincipal.gridx=4;
		cPrincipal.gridy=20;
		panouPrincipal.add(bazine,cPrincipal);
		bazine.addActionListener( controller);
		
		cPrincipal.gridx=8;
		cPrincipal.gridy=20;
		panouPrincipal.add(masini,cPrincipal);
		masini.addActionListener( controller);
		
		cPrincipal.gridx=12;
		cPrincipal.gridy=20;
		panouPrincipal.add(general,cPrincipal);
		general.addActionListener( controller);
		general.setVisible(false);
		
		cPrincipal.gridx=16;
		cPrincipal.gridy=20;
		panouPrincipal.add(angajati,cPrincipal);
		angajati.addActionListener( controller);
		angajati.setVisible(false);
		
	}
	
	public void crearePanouBazine() {
		panouBazine.removeAll();
		
		String[] bazin =new String[100];
		BazineDAO bazine = new BazineDAO();
		ArrayList<String> bazineLista = bazine.findBazine();
		int i=1;
		bazin[0]="Selectati bazinul pe care doriti sa il vedeti";
		for (String string : bazineLista) {
			bazin[i]=string;
			i++;
		}
		selectareBazin= new JComboBox(bazin);
		
		cBazine.gridx=0;
		cBazine.gridy=0;
		panouBazine.add(selectareBazin,cBazine);
		
		cBazine.gridx=1;
		cBazine.gridy=0;
		panouBazine.add(cautaBazin,cBazine);
		cautaBazin.addActionListener(controller);
		
		cBazine.gridx=0;
		cBazine.gridy=1;
		panouBazine.add(inapoiBazine,cBazine);
		inapoiBazine.addActionListener(controller);
		
		cBazine.gridx=1;
		cBazine.gridy=1;
		panouBazine.add(adaugaBazin,cBazine);
		adaugaBazin.addActionListener(controller);
		
		
		
	}
	
	public void crearePanouBazin() {
		panouBazin.removeAll();
		
		cBazin.gridx=0;
		cBazin.gridy=0;
		panouBazin.add(cantitatePesteTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=0;
		panouBazin.add(gol[11],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=0;
		panouBazin.add(cantitatePesteNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=0;
		panouBazin.add(gol[13],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=0;
		panouBazin.add(detaliiCantitatePeste,cBazin);
		detaliiCantitatePeste.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=0;
		panouBazin.add(adaugareUnicPeste,cBazin);
		adaugareUnicPeste.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=2;
		panouBazin.add(cantitateFurajeTXT,cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=2;
		panouBazin.add(gol[21],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=2;
		panouBazin.add(cantitateFurajeNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=2;
		panouBazin.add(gol[23],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=2;
		panouBazin.add(detaliiCantitateFuraje,cBazin);
		detaliiCantitateFuraje.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=2;
		panouBazin.add(adaugareUnicFuraj,cBazin);
		adaugareUnicFuraj.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=4;
		panouBazin.add(medieOxigenTXT,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=4;
		panouBazin.add(gol[41],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=4;
		panouBazin.add(medieOxigenNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=4;
		panouBazin.add(gol[43],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=4;
		panouBazin.add(detaliiMedieOxigen,cBazin);
		detaliiMedieOxigen.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=4;
		panouBazin.add(adaugareUnicOxigen,cBazin);
		adaugareUnicOxigen.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=6;
		panouBazin.add(mediePhTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=6;
		panouBazin.add(gol[61],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=6;
		panouBazin.add(mediePhNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=6;
		panouBazin.add(gol[63],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=6;
		panouBazin.add(detaliiMediePh,cBazin);
		detaliiMediePh.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=6;
		panouBazin.add(adaugareUnicPh,cBazin);
		adaugareUnicPh.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=8;
		panouBazin.add(cantitateBalegarTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=8;
		panouBazin.add(gol[81],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=8;
		panouBazin.add(cantitateBalegarNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=8;
		panouBazin.add(gol[83],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=8;
		panouBazin.add(detaliiBalegar,cBazin);
		detaliiBalegar.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=8;
		panouBazin.add(adaugareUnicBalegar,cBazin);
		adaugareUnicBalegar.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=10;
		panouBazin.add(medieTemperaturaTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=10;
		panouBazin.add(gol[1101],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=10;
		panouBazin.add(medieTemperaturaNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=10;
		panouBazin.add(gol[1103],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=10;
		panouBazin.add(detaliiTemperatura,cBazin);
		detaliiTemperatura.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=10;
		panouBazin.add(adaugareUnicTemperatura,cBazin);
		adaugareUnicTemperatura.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=12;
		panouBazin.add(medieNivelApaTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=12;
		panouBazin.add(gol[1121],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=12;
		panouBazin.add(medieNivelApaNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=12;
		panouBazin.add(gol[1123],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=12;
		panouBazin.add(detaliiNivelApa,cBazin);
		detaliiNivelApa.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=12;
		panouBazin.add(adaugareUnicNivelApa,cBazin);
		adaugareUnicNivelApa.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=14;
		panouBazin.add(cantitateFitoplanctonTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=14;
		panouBazin.add(gol[1141],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=14;
		panouBazin.add(cantitateFitoplanctonNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=14;
		panouBazin.add(gol[143],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=14;
		panouBazin.add(detaliiCantitateFitoplancton,cBazin);
		detaliiCantitateFitoplancton.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=14;
		panouBazin.add(adaugareUnicFitoplancton,cBazin);
		adaugareUnicFitoplancton.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=16;
		panouBazin.add(dezinfectieTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=16;
		panouBazin.add(gol[161],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=16;
		panouBazin.add(dezinfectieNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=16;
		panouBazin.add(gol[163],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=16;
		panouBazin.add(detaliiDezinfectie,cBazin);
		detaliiDezinfectie.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=16;
		panouBazin.add(adaugareUnicDezinfectie,cBazin);
		adaugareUnicDezinfectie.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=18;
		panouBazin.add(umplereTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=18;
		panouBazin.add(gol[181],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=18;
		panouBazin.add(umplereNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=18;
		panouBazin.add(gol[183],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=18;
		panouBazin.add(detaliiUmplere,cBazin);
		detaliiUmplere.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=18;
		panouBazin.add(adaugareUnicUmplere,cBazin);
		adaugareUnicUmplere.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=20;
		panouBazin.add(golireTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=20;
		panouBazin.add(gol[201],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=20;
		panouBazin.add(golireNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=20;
		panouBazin.add(gol[203],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=20;
		panouBazin.add(detaliiGolire,cBazin);
		detaliiGolire.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=20;
		panouBazin.add(adaugareUnicGolire,cBazin);
		adaugareUnicGolire.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=22;
		panouBazin.add(pescuitDeProbaTXT,cBazin);
		
		cBazin.gridx=1;
		cBazin.gridy=22;
		panouBazin.add(gol[221],cBazin);
		
		cBazin.gridx=2;
		cBazin.gridy=22;
		panouBazin.add(pescuitDeProbaNR,cBazin);
		
		cBazin.gridx=3;
		cBazin.gridy=22;
		panouBazin.add(gol[223],cBazin);
		
		cBazin.gridx=4;
		cBazin.gridy=22;
		panouBazin.add(pescuitDeProba,cBazin);
		pescuitDeProba.addActionListener(controller);
		
		cBazin.gridx=5;
		cBazin.gridy=22;
		panouBazin.add(adaugareUnicPescuitDeProba,cBazin);
		adaugareUnicPescuitDeProba.addActionListener(controller);
		
		cBazin.gridx=0;
		cBazin.gridy=24;
		panouBazin.add(resetareBazin,cBazin);
		resetareBazin.addActionListener( controller);
		
		cPeste.gridx=1;
		cPeste.gridy=24;
		panouBazin.add(gol[22],cPeste);
		
		cBazin.gridx=2;
		cBazin.gridy=24;
		panouBazin.add(inapoiBazin,cBazin);
		inapoiBazin.addActionListener( controller);
		
		cPeste.gridx=0;
		cPeste.gridy=1;
		panouBazin.add(gol[990],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=3;
		panouBazin.add(gol[991],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=5;
		panouBazin.add(gol[992],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=7;
		panouBazin.add(gol[993],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=9;
		panouBazin.add(gol[994],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=11;
		panouBazin.add(gol[995],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=13;
		panouBazin.add(gol[996],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=15;
		panouBazin.add(gol[997],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=17;
		panouBazin.add(gol[998],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=19;
		panouBazin.add(gol[999],cPeste);
		
		cPeste.gridx=0;
		cPeste.gridy=21;
		panouBazin.add(gol[9910],cPeste);
		cPeste.gridx=0;
		cPeste.gridy=23;
		panouBazin.add(gol[9911],cPeste);
		
		
	}

	public void crearePanouPesteCantitati() {
		panouPesteCantitati.removeAll();
		
		cPeste.gridx=0;
		cPeste.gridy=0;
		panouPesteCantitati.add(tipPesteTXT,cPeste);
		
		cPeste.gridx=1;
		cPeste.gridy=0;
		panouPesteCantitati.add(gol[4],cPeste);
		
		cPeste.gridx=2;
		cPeste.gridy=0;
		panouPesteCantitati.add(cantitatePesteIntrodusaTXT,cPeste);
		
		cPeste.gridx=3;
		cPeste.gridy=0;
		panouPesteCantitati.add(gol[5],cPeste);
		
		cPeste.gridx=4;
		cPeste.gridy=0;
		panouPesteCantitati.add(cantitatePesteScoasaTXT,cPeste);
		
		cPeste.gridx=5;
		cPeste.gridy=0;
		panouPesteCantitati.add(gol[6],cPeste);
		
		cPeste.gridx=6;
		cPeste.gridy=0;
		panouPesteCantitati.add(cantitatePesteSiguraMinimaTXT,cPeste);
		
		cPeste.gridx=7;
		cPeste.gridy=0;
		panouPesteCantitati.add(gol[7],cPeste);
		
		
		for(int i=20; i< nrTipuriPesti*20+20; i++) {
			cPeste.gridx=i%10;
			cPeste.gridy=i/10+2;
			if(i%20==0) 
				panouPesteCantitati.add(tipPeste[i/20],cPeste);
			else
				panouPesteCantitati.add(gol[i+200],cPeste);
			if(i%20==2)
				panouPesteCantitati.add(cantitatePesteIntrodusa[i/20],cPeste);
			else
				panouPesteCantitati.add(gol[i+200],cPeste);
			if(i%20==4)
				panouPesteCantitati.add(cantitatePesteScoasa[i/20],cPeste);
			else
				panouPesteCantitati.add(gol[i+200],cPeste);
			if(i%20==6)
				panouPesteCantitati.add(cantitatePesteSiguraMinima[i/20],cPeste);
			else 
				panouPesteCantitati.add(gol[i+200],cPeste);
			
		}
		
		
		for(int i= 0; i<20; i++) {
			cPeste.gridx=i%10;
			cPeste.gridy=nrTipuriPesti*20;
			if(i%10==0) 
				panouPesteCantitati.add(tipPeste[0],cPeste);
			else
				panouPesteCantitati.add(gol[i+100],cPeste);
			if(i%10==2)
				panouPesteCantitati.add(cantitatePesteIntrodusa[0],cPeste);
			else
				panouPesteCantitati.add(gol[i+100],cPeste);
			if(i%10==4)
				panouPesteCantitati.add(cantitatePesteScoasa[0],cPeste);
			else
				panouPesteCantitati.add(gol[i+100],cPeste);
			if(i%10==6)
				panouPesteCantitati.add(cantitatePesteSiguraMinima[0],cPeste);
			else 
				panouPesteCantitati.add(gol[i+100],cPeste);
		}

		cPeste.gridx=0;
		cPeste.gridy=nrTipuriPesti*20+40;
		panouPesteCantitati.add(istoricPeste,cPeste);
		istoricPeste.addActionListener( controller);
		
		cPeste.gridx=2;
		cPeste.gridy=nrTipuriPesti*20+40;
		panouPesteCantitati.add(adaugarePeste,cPeste);
		adaugarePeste.addActionListener( controller);
		
		cPeste.gridx=4;
		cPeste.gridy=nrTipuriPesti*20+40;
		panouPesteCantitati.add(scoaterePeste,cPeste);
		scoaterePeste.addActionListener( controller);
		
		cPeste.gridx=6;
		cPeste.gridy=nrTipuriPesti*20+40;
		panouPesteCantitati.add(adaugareTipPeste,cPeste);
		adaugareTipPeste.addActionListener( controller);
		
		cPeste.gridx=0;
		cPeste.gridy=nrTipuriPesti*20+20;
		panouPesteCantitati.add(gol[1000],cPeste);
		
		cPeste.gridx=1;
		cPeste.gridy=1;
		panouPesteCantitati.add(gol[1001],cPeste);
		
		cPeste.gridx=8;
		cPeste.gridy=nrTipuriPesti*20+60;
		panouPesteCantitati.add(inapoiPeste,cPeste);
		inapoiPeste.addActionListener( controller);
		
	}
	
	public void crearePanouFurajeCantitati() {
		
		panouFurajeCantitati.removeAll();
		
		cFuraje.gridx=0;
		cFuraje.gridy=0;
		panouFurajeCantitati.add(tipFurajTXT,cFuraje);
		
		cFuraje.gridx=1;
		cFuraje.gridy=0;
		panouFurajeCantitati.add(gol[4],cFuraje);
		
		cFuraje.gridx=2;
		cFuraje.gridy=0;
		panouFurajeCantitati.add(cantitateFurajIntrodusaTXT,cFuraje);
		
		for(int i=20; i< nrTipuriFuraje*20+20; i++) {
			cFuraje.gridx=i%10;
			cFuraje.gridy=i/10+2;
			if(i%20==0) 
				panouFurajeCantitati.add(tipFuraj[i/20],cFuraje);
			else
				panouFurajeCantitati.add(gol[i+300],cFuraje);
			if(i%20==2)
				panouFurajeCantitati.add(cantitateFurajIntrodusa[i/20],cFuraje);
			else
				panouFurajeCantitati.add(gol[i+300],cFuraje);
		}
		
		
		for(int i= 0; i<20; i++) {
			cFuraje.gridx=i%10;
			cFuraje.gridy=nrTipuriFuraje*20;
			if(i%10==0) 
				panouFurajeCantitati.add(tipFuraj[0],cFuraje);
			else
				panouFurajeCantitati.add(gol[i+100],cFuraje);
			if(i%10==2)
				panouFurajeCantitati.add(cantitateFurajIntrodusa[0],cFuraje);
			else
				panouFurajeCantitati.add(gol[i+100],cFuraje);
		}
		
		cFuraje.gridx=0;
		cFuraje.gridy=nrTipuriFuraje*20+40;
		panouFurajeCantitati.add(istoricFuraje,cFuraje);
		istoricFuraje.addActionListener( controller);
		
		cFuraje.gridx=2;
		cFuraje.gridy=nrTipuriFuraje*20+40;
		panouFurajeCantitati.add(adaugareFuraj,cFuraje);
		adaugareFuraj.addActionListener( controller);
		
		cFuraje.gridx=4;
		cFuraje.gridy=nrTipuriFuraje*20+40;
		panouFurajeCantitati.add(adaugareTipFuraj,cFuraje);
		adaugareTipFuraj.addActionListener( controller);
		
		cFuraje.gridx=0;
		cFuraje.gridy=nrTipuriFuraje*20+20;
		panouFurajeCantitati.add(gol[1000],cFuraje);
		
		cFuraje.gridx=1;
		cFuraje.gridy=1;
		panouFurajeCantitati.add(gol[1001],cFuraje);
		
		cFuraje.gridx=6;
		cFuraje.gridy=nrTipuriFuraje*20+40;
		panouFurajeCantitati.add(inapoiFuraj,cFuraje);
		inapoiFuraj.addActionListener(controller);
		
		
	}
	
	public void crearePanouSelectareAn() {
		panouSelectareAn.removeAll();
		
		String[] ani =new String[31];
		for(int i=2020; i<=2050; i++) {
			ani[i-2020]=Integer.toString(i);
		}
		selectareAnMeniu= new JComboBox(ani);
		
		cSelectareAn.gridx=0;
		cSelectareAn.gridy=0;
		panouSelectareAn.add(selectareAnTXT,cSelectareAn);
		
		cSelectareAn.gridx=1;
		cSelectareAn.gridy=0;
		panouSelectareAn.add(selectareAnMeniu,cSelectareAn);
		
		cSelectareAn.gridx=2;
		cSelectareAn.gridy=0;
		panouSelectareAn.add(selectareAn,cSelectareAn);
		selectareAn.addActionListener(controller);
		
		cSelectareAn.gridx=0;
		cSelectareAn.gridy=1;
		panouSelectareAn.add(inapoiSelectareAn,cSelectareAn);
		inapoiSelectareAn.addActionListener(controller);
	}
	
	public void crearePanouIstoric() {
		panouIstoric.removeAll();
		
		
		final JList<String> list = new JList<String>(listaIstoric.toArray(new String[listaIstoric.size()]));
	    scrollPane.setViewportView(list);
	    list.setLayoutOrientation(JList.VERTICAL);
	    scrollPane.setPreferredSize(new Dimension(600, 400));
	    
	    cIstoric.gridx=0;
	    cIstoric.gridy=0;
		panouIstoric.add(scrollPane,cIstoric);
	    
		cIstoric.gridx=0;
		cIstoric.gridy=1;
		panouIstoric.add(inapoiIstoric,cIstoric);
		inapoiIstoric.addActionListener(controller);
	    
	    panou.add(panouIstoric);
		
	}
	
	public void crearePanouAdaugareUnic(){
		
		panouAdaugareUnic.removeAll();
		
		String[] zi =new String[31];
		for(int i=1; i<32; i++) {
			zi[i-1]=Integer.toString(i);
		}
		selectareZiAdaugareUnic= new JComboBox(zi);
		
		String[] luna =new String[12];
		for(int i=1; i<13; i++) {
			luna[i-1]=Integer.toString(i);
		}
		selectareLunaAdaugareUnic= new JComboBox(luna);
		
		String[] ani =new String[31];
		for(int i=2020; i<=2050; i++) {
			ani[i-2020]=Integer.toString(i);
		}
		selectareAnAdaugareUnic= new JComboBox(ani);
		
		tipPesteSTR[0]="Selectati tipul de peste";
		tipFurajSTR[0]="Selectati tipul de furaj";
		
		pestiMeniu= new JComboBox(tipPesteSTR);
		furajMeniu = new JComboBox(tipFurajSTR);
		
		
		cAdaugareUnic.gridx=0;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(adaugareUnicTXT,cAdaugareUnic);
		
		cAdaugareUnic.gridx=1;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(pestiMeniu,cAdaugareUnic);
		
		cAdaugareUnic.gridx=2;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(furajMeniu,cAdaugareUnic);
		
		cAdaugareUnic.gridx=3;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(adaugareUnicNR,cAdaugareUnic);
		
		cAdaugareUnic.gridx=4;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(selectareZiAdaugareUnic,cAdaugareUnic);
		
		cAdaugareUnic.gridx=5;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(selectareLunaAdaugareUnic,cAdaugareUnic);
		
		cAdaugareUnic.gridx=6;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(selectareAnAdaugareUnic,cAdaugareUnic);
		
		cAdaugareUnic.gridx=7;
		cAdaugareUnic.gridy=0;
		panouAdaugareUnic.add(adaugareUnic,cAdaugareUnic);
		adaugareUnic.addActionListener(controller);
		
		cAdaugareUnic.gridx=0;
		cAdaugareUnic.gridy=1;
		panouAdaugareUnic.add(inapoiAdaugareUnic,cAdaugareUnic);
		inapoiAdaugareUnic.addActionListener(controller);
		
	}
	
	public void crearePanouAdaugareTipFuraj() {
		panouAdaugareTipFuraj.removeAll();
		
		cAdaugareTipFuraj.gridx=0;
		cAdaugareTipFuraj.gridy=0;
		panouAdaugareTipFuraj.add(adaugareTipFurajFinalTXT,cAdaugareTipFuraj);
		
		cAdaugareTipFuraj.gridx=1;
		cAdaugareTipFuraj.gridy=0;
		panouAdaugareTipFuraj.add(adaugareTipFurajFinalNr,cAdaugareTipFuraj);
		
		cAdaugareTipFuraj.gridx=2;
		cAdaugareTipFuraj.gridy=0;
		panouAdaugareTipFuraj.add(adaugareTipFurajFinal,cAdaugareTipFuraj);
		adaugareTipFurajFinal.addActionListener(controller);
		
		cAdaugareTipFuraj.gridx=0;
		cAdaugareTipFuraj.gridy=1;
		panouAdaugareTipFuraj.add(inapoiAdaugareTipFuraj,cAdaugareTipFuraj);
		inapoiAdaugareTipFuraj.addActionListener(controller);
		
		
	}
	
	public void crearePanouAdaugareTipPeste() {
		panouAdaugareTipPeste.removeAll();
		
		cAdaugareTipPeste.gridx=0;
		cAdaugareTipPeste.gridy=0;
		panouAdaugareTipPeste.add(adaugareTipPesteFinalTXT,cAdaugareTipPeste);
		
		cAdaugareTipPeste.gridx=1;
		cAdaugareTipPeste.gridy=0;
		panouAdaugareTipPeste.add(adaugareTipPesteFinalNr,cAdaugareTipPeste);
		
		cAdaugareTipPeste.gridx=2;
		cAdaugareTipPeste.gridy=0;
		panouAdaugareTipPeste.add(adaugareTipPesteFinal,cAdaugareTipPeste);
		adaugareTipPesteFinal.addActionListener(controller);
		
		cAdaugareTipPeste.gridx=0;
		cAdaugareTipPeste.gridy=1;
		panouAdaugareTipPeste.add(inapoiAdaugareTipPeste,cAdaugareTipPeste);
		inapoiAdaugareTipPeste.addActionListener(controller);
	}
	
	public void crearePanouResetareBazin(){
		
		panouResetareBazin.removeAll();
		
		cResetareBazin.gridx=1;
		cResetareBazin.gridy=0;
		panouResetareBazin.add(resetareBazinTXT,cResetareBazin);
		
		cResetareBazin.gridx=0;
		cResetareBazin.gridy=1;
		panouResetareBazin.add(resetareBazinDa,cResetareBazin);
		resetareBazinDa.addActionListener(controller);
		
		cResetareBazin.gridx=2;
		cResetareBazin.gridy=1;
		panouResetareBazin.add(resetareBazinNu,cResetareBazin);
		resetareBazinNu.addActionListener(controller);
		
		
	}
	
	public void crearePanouMasini() {
		
		panouMasini.removeAll();
		
		String[] masini =new String[200];
		ArrayList<Masini> masiniLista = MasiniDAO.findMasini();
		int i=1;
		masini[0]="Selectati masina pe care doriti sa o vedeti";
		for (Masini string : masiniLista) {
			masini[i]=string.getNumeMasini();
			i++;
		}
		selectareMasina= new JComboBox(masini);
		 
		cBazine.gridx=0;
		cBazine.gridy=0;
		panouMasini.add(selectareMasina,cMasini);
		masina1.addActionListener(controller);
		
		cBazine.gridx=0;
		cBazine.gridy=1;
		panouMasini.add(cautaMasina,cMasini);
		cautaMasina.addActionListener(controller);
		
		cMasini.gridx=0;
		cMasini.gridy=1;
		panouMasini.add(inapoiMasini,cMasini);
		inapoiMasini.addActionListener(controller);
		
		cMasini.gridx=1;
		cMasini.gridy=1;
		panouMasini.add(adaugaMasina,cMasini);
		adaugaMasina.addActionListener(controller);
		
		
	}

	public void crearePanouMasina() {
		
		panouMasina.removeAll();
		
		cMasina.gridx=0;
		cMasina.gridy=0;
		panouMasina.add(distantaParcursaTXT,cMasina);
		
		cMasina.gridx=1;
		cMasina.gridy=0;
		panouMasina.add(spatiu1,cMasina);
		
		cMasina.gridx=2;
		cMasina.gridy=0;
		panouMasina.add(distantaParcursaNR,cMasina);
		
		cMasina.gridx=3;
		cMasina.gridy=0;
		panouMasina.add(spatiu2,cMasina);
		
		cMasina.gridx=0;
		cMasina.gridy=2;
		panouMasina.add(consumRealizatTXT,cMasina);
		
		cMasina.gridx=2;
		cMasina.gridy=2;
		panouMasina.add(consumRealizatNR,cMasina);
		
		cMasina.gridx=0;
		cMasina.gridy=4;
		panouMasina.add(costFunctionareTXT,cMasina);
		
		cMasina.gridx=2;
		cMasina.gridy=4;
		panouMasina.add(costFunctionareNR,cMasina);
		
		cMasina.gridx=0;
		cMasina.gridy=6;
		panouMasina.add(dataRevizieTXT,cMasina);
		
		cMasina.gridx=2;
		cMasina.gridy=6;
		panouMasina.add(dataRevizieNR,cMasina);
		
		cMasina.gridx=0;
		cMasina.gridy=8;
		panouMasina.add(dataExpirareRevizieTXT,cMasina);
		
		cMasina.gridx=2;
		cMasina.gridy=8;
		panouMasina.add(dataExpirareRevizieNR,cMasina);
		
		cMasina.gridx=0;
		cMasina.gridy=10;
		panouMasina.add(veziIstoricCurse,cMasina);
		veziIstoricCurse.addActionListener(controller);
		
		cMasina.gridx=1;
		cMasina.gridy=10;
		panouMasina.add(adaugaCursa,cMasina);
		adaugaCursa.addActionListener(controller);
		
		cMasina.gridx=0;
		cMasina.gridy=12;
		panouMasina.add(veziIstoricCurseLunar,cMasina);
		veziIstoricCurseLunar.addActionListener(controller);
		
		cMasina.gridx=0;
		cMasina.gridy=14;
		panouMasina.add(veziIstoricRevizii,cMasina);
		veziIstoricRevizii.addActionListener(controller);
		
		cMasina.gridx=1;
		cMasina.gridy=14;
		panouMasina.add(aduagaRevizie,cMasina);
		aduagaRevizie.addActionListener(controller);
		
		cMasina.gridx=0;
		cMasina.gridy=16;
		panouMasina.add(veziIstoricReparatii,cMasina);
		veziIstoricReparatii.addActionListener(controller);
		
		cMasina.gridx=1;
		cMasina.gridy=16;
		panouMasina.add(aduagaReparatie,cMasina);
		aduagaReparatie.addActionListener(controller);
		
		cMasina.gridx=0;
		cMasina.gridy=18;
		panouMasina.add(veziIstoricAutorizatii,cMasina);
		veziIstoricAutorizatii.addActionListener(controller);
		
		cMasina.gridx=1;
		cMasina.gridy=18;
		panouMasina.add(adaugareAutorizatie,cMasina);
		adaugareAutorizatie.addActionListener(controller);
		

		cMasina.gridx=0;
		cMasina.gridy=20;
		panouMasina.add(inapoiMasina,cMasina);
		inapoiMasina.addActionListener(controller);
		
		
		cMasina.gridx=1;
		cMasina.gridy=1;
		panouMasina.add(gol[9990],cMasina);
		
		cMasina.gridx=3;
		cMasina.gridy=3;
		panouMasina.add(gol[9991],cMasina);
		
		cMasina.gridx=5;
		cMasina.gridy=5;
		panouMasina.add(gol[9992],cMasina);
		
		cMasina.gridx=5;
		cMasina.gridy=5;
		panouMasina.add(gol[9993],cMasina);
		
		cMasina.gridx=7;
		cMasina.gridy=7;
		panouMasina.add(gol[9994],cMasina);
		
		cMasina.gridx=9;
		cMasina.gridy=9;
		panouMasina.add(gol[9995],cMasina);
		
		cMasina.gridx=11;
		cMasina.gridy=11;
		panouMasina.add(gol[9996],cMasina);
		
		cMasina.gridx=13;
		cMasina.gridy=13;
		panouMasina.add(gol[9997],cMasina);
		
		cMasina.gridx=15;
		cMasina.gridy=15;
		panouMasina.add(gol[9998],cMasina);
		
		cMasina.gridx=17;
		cMasina.gridy=17;
		panouMasina.add(gol[9999],cMasina);
		
		cMasina.gridx=19;
		cMasina.gridy=19;
		panouMasina.add(gol[8999],cMasina);
		
		cMasina.gridx=21;
		cMasina.gridy=21;
		panouMasina.add(gol[8998],cMasina);
	}
	
	public void crearePanouAngajati() {
		
		panouAngajati.removeAll();
		
		cAngajati.gridx=0;
		cAngajati.gridy=0;
		panouAngajati.add(inapoiAngajati,cAngajati);
		inapoiAngajati.addActionListener(controller);
		
		
	}
	
	public void crearePanouGeneral() {
		
		panouGeneral.removeAll();
		
		cGeneral.gridx=0;
		cGeneral.gridy=0;
		panouGeneral.add(inapoiGeneral,cGeneral);
		inapoiGeneral.addActionListener(controller);
		
		
	}

	public void crearePanouAdaugare() {
		panouAdaugare.removeAll();
		
		cAdaugare.gridx=0;
		cAdaugare.gridy=0;
		panouAdaugare.add(adaugareTXT,cAdaugare);
		
		cAdaugare.gridx=1;
		cAdaugare.gridy=0;
		panouAdaugare.add(adaugareNR,cAdaugare);
		
		cAdaugare.gridx=2;
		cAdaugare.gridy=0;
		panouAdaugare.add(adaugare,cAdaugare);
		adaugare.addActionListener(controller);
		
		cAdaugare.gridx=0;
		cAdaugare.gridy=1;
		panouAdaugare.add(inapoiAdaugare,cAdaugare);
		inapoiAdaugare.addActionListener(controller);
		
	}

	public void crearePanouAdaugareReparatie() {
		panouAdaugareReparatie.removeAll();
		
		String[] zi =new String[31];
		for(int i=1; i<32; i++) {
			zi[i-1]=Integer.toString(i);
		}
		selectareZiAdaugareReparatieData= new JComboBox(zi);
		
		String[] luna =new String[12];
		for(int i=1; i<13; i++) {
			luna[i-1]=Integer.toString(i);
		}
		selectareLunaAdaugareReparatieData= new JComboBox(luna);
		
		String[] ani =new String[31];
		for(int i=2020; i<=2050; i++) {
			ani[i-2020]=Integer.toString(i);
		}
		selectareAnAdaugareReparatieData= new JComboBox(ani);
		
		zi[0]="zi";
		luna[0]="luna";
		ani[0]="an";
		
		cAdaugareReparatie.gridx=0;
		cAdaugareReparatie.gridy=0;
		panouAdaugareReparatie.add(adaugareReparatieCostTXT,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=1;
		cAdaugareReparatie.gridy=0;
		panouAdaugareReparatie.add(adaugareReparatieCostNR,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=0;
		cAdaugareReparatie.gridy=1;
		panouAdaugareReparatie.add(adaugareReparatieMecanicTXT,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=1;
		cAdaugareReparatie.gridy=1;
		panouAdaugareReparatie.add(adaugareReparatieMecanicNR,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=0;
		cAdaugareReparatie.gridy=2;
		panouAdaugareReparatie.add(adaugareReparatieProblemeAparuteTXT,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=1;
		cAdaugareReparatie.gridy=2;
		panouAdaugareReparatie.add(adaugareReparatieProblemeAparuteNR,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=0;
		cAdaugareReparatie.gridy=3;
		panouAdaugareReparatie.add(adaugareReparatieDataTXT,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=2;
		cAdaugareReparatie.gridy=3;
		panouAdaugareReparatie.add(selectareZiAdaugareReparatieData,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=3;
		cAdaugareReparatie.gridy=3;
		panouAdaugareReparatie.add(selectareLunaAdaugareReparatieData,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=4;
		cAdaugareReparatie.gridy=3;
		panouAdaugareReparatie.add(selectareAnAdaugareReparatieData,cAdaugareReparatie);
		
		cAdaugareReparatie.gridx=0;
		cAdaugareReparatie.gridy=4;
		panouAdaugareReparatie.add(inapoiAdaugareReparatie,cAdaugareReparatie);
		inapoiAdaugareReparatie.addActionListener(controller);
		
		cAdaugareReparatie.gridx=1;
		cAdaugareReparatie.gridy=4;
		panouAdaugareReparatie.add(adaugareReparatie,cAdaugareReparatie);
		adaugareReparatie.addActionListener(controller);
		
	}
	
	public void crearePanouAdaugareRevizie() {
		panouAdaugareRevizie.removeAll();
		
		String[] zi1 =new String[31];
		for(int i=1; i<32; i++) {
			zi1[i-1]=Integer.toString(i);
		}
		selectareZiAdaugareRevizie= new JComboBox(zi1);
		
		String[] luna1 =new String[12];
		for(int i=1; i<13; i++) {
			luna1[i-1]=Integer.toString(i);
		}
		selectareLunaAdaugareRevizie= new JComboBox(luna1);
		
		String[] ani1 =new String[31];
		for(int i=2020; i<=2050; i++) {
			ani1[i-2020]=Integer.toString(i);
		}
		selectareAnAdaugareRevizie= new JComboBox(ani1);
		
		String[] zi2 =new String[31];
		for(int i=1; i<32; i++) {
			zi2[i-1]=Integer.toString(i);
		}
		selectareZiAdaugareRevizieExpirare= new JComboBox(zi2);
		
		String[] luna2 =new String[12];
		for(int i=1; i<13; i++) {
			luna2[i-1]=Integer.toString(i);
		}
		selectareLunaAdaugareRevizieExpirare= new JComboBox(luna2);
		
		String[] ani2 =new String[31];
		for(int i=2020; i<=2050; i++) {
			ani2[i-2020]=Integer.toString(i);
		}
		selectareAnAdaugareRevizieExpirare= new JComboBox(ani2);
		
		
		cAdaugareRevizie.gridx=0;
		cAdaugareRevizie.gridy=0;
		panouAdaugareRevizie.add(adaugareRevizieTXT,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=2;
		cAdaugareRevizie.gridy=0;
		panouAdaugareRevizie.add(selectareZiAdaugareRevizie,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=3;
		cAdaugareRevizie.gridy=0;
		panouAdaugareRevizie.add(selectareLunaAdaugareRevizie,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=4;
		cAdaugareRevizie.gridy=0;
		panouAdaugareRevizie.add(selectareAnAdaugareRevizie,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=0;
		cAdaugareRevizie.gridy=1;
		panouAdaugareRevizie.add(adaugareRevizieExpirareTXT,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=2;
		cAdaugareRevizie.gridy=1;
		panouAdaugareRevizie.add(selectareZiAdaugareRevizieExpirare,cAdaugareRevizie);

		cAdaugareRevizie.gridx=3;
		cAdaugareRevizie.gridy=1;
		panouAdaugareRevizie.add(selectareLunaAdaugareRevizieExpirare,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=4;
		cAdaugareRevizie.gridy=1;
		panouAdaugareRevizie.add(selectareAnAdaugareRevizieExpirare,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=0;
		cAdaugareRevizie.gridy=2;
		panouAdaugareRevizie.add(adaugareRevizieCostTXT,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=1;
		cAdaugareRevizie.gridy=2;
		panouAdaugareRevizie.add(adaugareRevizieCostNR,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=0;
		cAdaugareRevizie.gridy=3;
		panouAdaugareRevizie.add(adaugareRevizieProblemeAparuteTXT,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=1;
		cAdaugareRevizie.gridy=3;
		panouAdaugareRevizie.add(adaugareRevizieProblemeAparuteNR,cAdaugareRevizie);
		
		cAdaugareRevizie.gridx=0;
		cAdaugareRevizie.gridy=4;
		panouAdaugareRevizie.add(inapoiAdaugareRevizie,cAdaugareRevizie);
		inapoiAdaugareRevizie.addActionListener(controller);
		
		cAdaugareRevizie.gridx=1;
		cAdaugareRevizie.gridy=4;
		panouAdaugareRevizie.add(adaugareRevizie,cAdaugareRevizie);
		adaugareRevizie.addActionListener(controller);
	}
	 
	public void crearePanouAdaugareCursa() {
		panouAdaugareCursa.removeAll();
		
		String[] zi =new String[31];
		for(int i=1; i<32; i++) {
			zi[i-1]=Integer.toString(i);
		}
		selectareZiAdaugareCursa= new JComboBox(zi);
		
		String[] luna =new String[12];
		for(int i=1; i<13; i++) {
			luna[i-1]=Integer.toString(i);
		}
		selectareLunaAdaugareCursa= new JComboBox(luna);
		
		String[] ani =new String[31];
		for(int i=2020; i<=2050; i++) {
			ani[i-2020]=Integer.toString(i);
		}
		selectareAnAdaugareCursa= new JComboBox(ani);
		
		zi[0]="zi";
		luna[0]="luna";
		ani[0]="an";
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=0;
		panouAdaugareCursa.add(adaugareCursaSoferTXT,cAdaugareCursa);
		
		cAdaugareCursa.gridx=1;
		cAdaugareCursa.gridy=0;
		panouAdaugareCursa.add(adaugareCursaSoferNR,cAdaugareCursa);
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=1;
		panouAdaugareCursa.add(adaugareCursaConsumTXT,cAdaugareCursa);
		
		cAdaugareCursa.gridx=1;
		cAdaugareCursa.gridy=1;
		panouAdaugareCursa.add(adaugareCursaConsumNR,cAdaugareCursa);
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=2;
		panouAdaugareCursa.add(adaugareCursaPretPerLitruTXT,cAdaugareCursa);
		
		cAdaugareCursa.gridx=1;
		cAdaugareCursa.gridy=2;
		panouAdaugareCursa.add(adaugareCursaPretPerLitruNR,cAdaugareCursa);
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=3;
		panouAdaugareCursa.add(adaugareCursaDistantaTXT,cAdaugareCursa);
		
		cAdaugareCursa.gridx=1;
		cAdaugareCursa.gridy=3;
		panouAdaugareCursa.add(adaugareCursaDistantaNR,cAdaugareCursa);
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=4;
		panouAdaugareCursa.add(adaugareCursaDestinatieTXT,cAdaugareCursa);
		
		cAdaugareCursa.gridx=1;
		cAdaugareCursa.gridy=4;
		panouAdaugareCursa.add(adaugareCursaDestinatieNR,cAdaugareCursa);
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=5;
		panouAdaugareCursa.add(adaugareCursaDataTXT,cAdaugareCursa);
		
		cAdaugareCursa.gridx=2;
		cAdaugareCursa.gridy=5;
		panouAdaugareCursa.add(selectareZiAdaugareCursa,cAdaugareCursa);
		
		cAdaugareCursa.gridx=3;
		cAdaugareCursa.gridy=5;
		panouAdaugareCursa.add(selectareLunaAdaugareCursa,cAdaugareCursa);
		
		cAdaugareCursa.gridx=4;
		cAdaugareCursa.gridy=5;
		panouAdaugareCursa.add(selectareAnAdaugareCursa,cAdaugareCursa);
		
		cAdaugareCursa.gridx=0;
		cAdaugareCursa.gridy=6;
		panouAdaugareCursa.add(inapoiAdaugareCursa,cAdaugareCursa);
		inapoiAdaugareCursa.addActionListener(controller);
		
		cAdaugareCursa.gridx=1;
		cAdaugareCursa.gridy=6;
		panouAdaugareCursa.add(adaugareCursa,cAdaugareCursa);
		adaugareCursa.addActionListener(controller);
	}	

	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public JPanel getPanouPrincipal() {
		return panouPrincipal;
	}
	public void setPanouPrincipal(JPanel pane) {
		this.panouPrincipal = pane;
	}
	public GridBagConstraints getcPrincipal() {
		return cPrincipal;
	}
	public void setcPrincipal(GridBagConstraints cPrincipal) {
		this.cPrincipal = cPrincipal;
	}
	public JButton getBazine() {
		return bazine;
	}
	public void setBazine(JButton bazine) {
		this.bazine = bazine;
	}
	public JButton getMasini() {
		return masini;
	}
	public void setMasini(JButton masini) {
		this.masini = masini;
	}
	public JButton getGeneral() {
		return general;
	}
	public void setGeneral(JButton general) {
		this.general = general;
	}
	public JButton getAngajati() {
		return angajati;
	}
	public void setAngajati(JButton angajati) {
		this.angajati = angajati;
	}
	public JLabel[] getGol() {
		return gol;
	}
	public void setGol(JLabel[] gol) {
		this.gol = gol;
	}
	
	public JPanel getPanouBazine() {
		return panouBazine;
	}

	public void setPanouBazine(JPanel panouBazine) {
		this.panouBazine = panouBazine;
	}

	public GridBagConstraints getcBazine() {
		return cBazine;
	}

	public void setcBazine(GridBagConstraints cBazine) {
		this.cBazine = cBazine;
	}

	public JButton getInapoiBazine() {
		return inapoiBazine;
	}

	public void setInapoiBazine(JButton inapoiBazine) {
		this.inapoiBazine = inapoiBazine;
	}

	public JButton getBazin1() {
		return bazin1;
	}

	public void setBazin1(JButton bazin1) {
		this.bazin1 = bazin1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	public JPanel getPanou() {
		return panou;
	}

	public void setPanou(JPanel panou) {
		this.panou = panou;
	}

	public JPanel getPanouMasini() {
		return panouMasini;
	}

	public void setPanouMasini(JPanel panouMasini) {
		this.panouMasini = panouMasini;
	}

	public JPanel getPanouGeneral() {
		return panouGeneral;
	}

	public void setPanouGeneral(JPanel panouGeneral) {
		this.panouGeneral = panouGeneral;
	}

	public JPanel getPanouAngajati() {
		return panouAngajati;
	}

	public void setPanouAngajati(JPanel panouAngajati) {
		this.panouAngajati = panouAngajati;
	}

	public GridBagConstraints getcMasini() {
		return cMasini;
	}

	public void setcMasini(GridBagConstraints cMasini) {
		this.cMasini = cMasini;
	}

	public GridBagConstraints getcGeneral() {
		return cGeneral;
	}

	public void setcGeneral(GridBagConstraints cGeneral) {
		this.cGeneral = cGeneral;
	}

	public GridBagConstraints getcAngajati() {
		return cAngajati;
	}

	public void setcAngajati(GridBagConstraints cAngajati) {
		this.cAngajati = cAngajati;
	}

	public JButton getInapoiMasini() {
		return inapoiMasini;
	}

	public void setInapoiMasini(JButton inapoiMasini) {
		this.inapoiMasini = inapoiMasini;
	}

	public JButton getInapoiGeneral() {
		return inapoiGeneral;
	}

	public void setInapoiGeneral(JButton inapoiGeneral) {
		this.inapoiGeneral = inapoiGeneral;
	}

	public JButton getInapoiAngajati() {
		return inapoiAngajati;
	}

	public void setInapoiAngajati(JButton inapoiAngajati) {
		this.inapoiAngajati = inapoiAngajati;
	}

	public JButton getMasina1() {
		return masina1;
	}

	public void setMasina1(JButton masina1) {
		this.masina1 = masina1;
	}

	
	public JButton getBazin2() {
		return bazin2;
	}

	public void setBazin2(JButton bazin2) {
		this.bazin2 = bazin2;
	}

	
	public JPanel getPanouBazin() {
		return panouBazin;
	}

	public void setPanouBazin(JPanel panouBazin) {
		this.panouBazin = panouBazin;
	}

	public GridBagConstraints getcBazin() {
		return cBazin;
	}

	public void setcBazin(GridBagConstraints cBazin) {
		this.cBazin = cBazin;
	}

	public JButton getInapoiBazin() {
		return inapoiBazin;
	}

	public void setInapoiBazin(JButton inapoiBazin) {
		this.inapoiBazin = inapoiBazin;
	}

	
	
	public JPanel getPanouPesteCantitati() {
		return panouPesteCantitati;
	}

	public void setPanouPesteCantitati(JPanel panouPeste) {
		this.panouPesteCantitati = panouPeste;
	}

	public GridBagConstraints getcPeste() {
		return cPeste;
	}

	public void setcPeste(GridBagConstraints cPeste) {
		this.cPeste = cPeste;
	}

	public JButton getDetaliiCantitatePeste() {
		return detaliiCantitatePeste;
	}

	public void setDetaliiCantitatePeste(JButton detaliiCantitatePeste) {
		this.detaliiCantitatePeste = detaliiCantitatePeste;
	}

	public JButton getDetaliiCantitateFuraje() {
		return detaliiCantitateFuraje;
	}

	public void setDetaliiCantitateFuraje(JButton detaliiCantitateFuraje) {
		this.detaliiCantitateFuraje = detaliiCantitateFuraje;
	}

	public JButton getDetaliiMedieOxigen() {
		return detaliiMedieOxigen;
	}

	public void setDetaliiMedieOxigen(JButton detaliiMedieOxigen) {
		this.detaliiMedieOxigen = detaliiMedieOxigen;
	}

	public JButton getDetaliiMediePh() {
		return detaliiMediePh;
	}

	public void setDetaliiMediePh(JButton detaliiMediePh) {
		this.detaliiMediePh = detaliiMediePh;
	}

	public JButton getIstoricPeste() {
		return istoricPeste;
	}

	public void setIstoricPeste(JButton istoricPeste) {
		this.istoricPeste = istoricPeste;
	}

	public JButton getAdaugarePeste() {
		return adaugarePeste;
	}

	public void setAdaugarePeste(JButton adaugarePeste) {
		this.adaugarePeste = adaugarePeste;
	}

	public JButton getScoaterePeste() {
		return scoaterePeste;
	}

	public void setScoaterePeste(JButton scoaterePeste) {
		this.scoaterePeste = scoaterePeste;
	}

	public JButton getAdaugareTipPeste() {
		return adaugareTipPeste;
	}

	public void setAdaugareTipPeste(JButton adaugareTipPeste) {
		this.adaugareTipPeste = adaugareTipPeste;
	}

	public JButton getInapoiPeste() {
		return inapoiPeste;
	}

	public void setInapoiPeste(JButton inapoiPeste) {
		this.inapoiPeste = inapoiPeste;
	}

	public JLabel getCantitatePesteTXT() {
		return cantitatePesteTXT;
	}

	public void setCantitatePesteTXT(JLabel cantitatePesteTXT) {
		this.cantitatePesteTXT = cantitatePesteTXT;
	}

	public JLabel getCantitatePesteNR() {
		return cantitatePesteNR;
	}

	public void setCantitatePesteNR(String cantitatePesteNR) {
		this.cantitatePesteNR.setText(cantitatePesteNR);
	}

	public JLabel getCantitateFurajeTXT() {
		return cantitateFurajeTXT;
	}

	public void setCantitateFurajeTXT(JLabel cantitateFurajeTXT) {
		this.cantitateFurajeTXT = cantitateFurajeTXT;
	}

	public JLabel getCantitateFurajeNR() {
		return cantitateFurajeNR;
	}

	public void setCantitateFurajeNR(String cantitateFurajeNR) {
		this.cantitateFurajeNR.setText(cantitateFurajeNR);
	}

	public JLabel getMedieOxigenTXT() {
		return medieOxigenTXT;
	}

	public void setMedieOxigenTXT(JLabel medieOxigenTXT) {
		this.medieOxigenTXT = medieOxigenTXT;
	}

	public JLabel getMedieOxigenNR() {
		return medieOxigenNR;
	}

	public void setMedieOxigenNR(String medieOxigenNR) {
		this.medieOxigenNR.setText(medieOxigenNR);;
	}

	public JLabel getMediePhTXT() {
		return mediePhTXT;
	}

	public void setMediePhTXT(JLabel mediePhTXT) {
		this.mediePhTXT = mediePhTXT;
	}

	public JLabel getMediePhNR() {
		return mediePhNR;
	}

	public void setMediePhNR(String mediePhNR) {
		this.mediePhNR.setText(mediePhNR);
	}

	
	
	public JButton getDetaliiBalegar() {
		return detaliiBalegar;
	}

	public void setDetaliiBalegar(JButton detaliiBalegar) {
		this.detaliiBalegar = detaliiBalegar;
	}

	public JButton getDetaliiTemperatura() {
		return detaliiTemperatura;
	}

	public void setDetaliiTemperatura(JButton detaliiTemperatura) {
		this.detaliiTemperatura = detaliiTemperatura;
	}

	public JButton getDetaliiNivelApa() {
		return detaliiNivelApa;
	}

	public void setDetaliiNivelApa(JButton detaliiNivelApa) {
		this.detaliiNivelApa = detaliiNivelApa;
	}

	public JButton getDetaliiCantitateFitoplancton() {
		return detaliiCantitateFitoplancton;
	}

	public void setDetaliiCantitateFitoplancton(JButton detaliiCantitateFitoplancton) {
		this.detaliiCantitateFitoplancton = detaliiCantitateFitoplancton;
	}

	public JButton getDetaliiDezinfectie() {
		return detaliiDezinfectie;
	}

	public void setDetaliiDezinfectie(JButton detaliiDezinfectie) {
		this.detaliiDezinfectie = detaliiDezinfectie;
	}

	public JButton getDetaliiUmplere() {
		return detaliiUmplere;
	}

	public void setDetaliiUmplere(JButton detaliiUmplere) {
		this.detaliiUmplere = detaliiUmplere;
	}

	public JButton getDetaliiGolire() {
		return detaliiGolire;
	}

	public void setDetaliiGolire(JButton detaliiGolire) {
		this.detaliiGolire = detaliiGolire;
	}

	public JLabel getCantitateBalegarTXT() {
		return cantitateBalegarTXT;
	}

	public void setCantitateBalegarTXT(String cantitateBalegarTXT) {
		this.cantitateBalegarTXT.setText(cantitateBalegarTXT);
	}

	public JLabel getCantitateBalegarNR() {
		return cantitateBalegarNR;
	}

	public void setCantitateBalegarNR(String cantitateBalegarNR) {
		this.cantitateBalegarNR.setText(cantitateBalegarNR);
	}

	public JLabel getMedieTemperaturaTXT() {
		return medieTemperaturaTXT;
	}

	public void setMedieTemperaturaTXT(String medieTemperaturaTXT) {
		this.medieTemperaturaTXT.setText(medieTemperaturaTXT);
	}

	public JLabel getMedieTemperaturaNR() {
		return medieTemperaturaNR;
	}

	public void setMedieTemperaturaNR(String medieTemperaturaNR) {
		this.medieTemperaturaNR.setText(medieTemperaturaNR);
	}

	public JLabel getMedieNivelApaTXT() {
		return medieNivelApaTXT;
	}

	public void setMedieNivelApaTXT(String medieNivelApaTXT) {
		this.medieNivelApaTXT.setText(medieNivelApaTXT);
	}

	public JLabel getMedieNivelApaNR() {
		return medieNivelApaNR;
	}

	public void setMedieNivelApaNR(String medieNivelApaNR) {
		this.medieNivelApaNR.setText(medieNivelApaNR);
	}

	public JLabel getCantitateFitoplanctonTXT() {
		return cantitateFitoplanctonTXT;
	}

	public void setCantitateFitoplanctonTXT(String cantiateFitoplanctonTXT) {
		this.cantitateFitoplanctonTXT.setText(cantiateFitoplanctonTXT);
	}

	public JLabel getCantitateFitoplanctonNR() {
		return cantitateFitoplanctonNR;
	}

	public void setCantitateFitoplanctonNR(String cantiateFitoplanctonNR) {
		this.cantitateFitoplanctonNR.setText(cantiateFitoplanctonNR);
	}

	public JLabel getDezinfectieTXT() {
		return dezinfectieTXT;
	}

	public void setDezinfectieTXT(String dezinfectieTXT) {
		this.dezinfectieTXT.setText(dezinfectieTXT);
	}

	public JLabel getDezinfectieNR() {
		return dezinfectieNR;
	}

	public void setDezinfectieNR(String dezinfectieNR) {
		this.dezinfectieNR.setText(dezinfectieNR);
	}

	public JLabel getUmplereTXT() {
		return umplereTXT;
	}

	public void setUmplereTXT(String umplereTXT) {
		this.umplereTXT.setText(umplereTXT);
	}
	
	public JLabel getGolireTXT() {
		return umplereTXT;
	}

	public void setGolireTXT(String golireTXT) {
		this.golireTXT.setText(golireTXT);
	}

	public JLabel getUmplereNR() {
		return umplereNR;
	}

	public void setUmplereNR(String umplereNR) {
		this.umplereNR.setText(umplereNR);
	}

	public JLabel getGolireNR() {
		return golireNR;
	}

	public void setGolireNR(String golireNR) {
		this.golireNR.setText(golireNR);
	}

	public void setCantitatePesteNR(JLabel cantitatePesteNR) {
		this.cantitatePesteNR = cantitatePesteNR;
	}

	public void setCantitateFurajeNR(JLabel cantitateFurajeNR) {
		this.cantitateFurajeNR = cantitateFurajeNR;
	}

	public void setMedieOxigenNR(JLabel medieOxigenNR) {
		this.medieOxigenNR = medieOxigenNR;
	}

	public void setMediePhNR(JLabel mediePhNR) {
		this.mediePhNR = mediePhNR;
	}

	public void setTipPeste(JLabel[] tipPeste) {
		this.tipPeste = tipPeste;
	}

	public void setCantitatePesteIntrodusa(JLabel[] cantitatePesteIntrodusa) {
		this.cantitatePesteIntrodusa = cantitatePesteIntrodusa;
	}

	public void setCantitatePesteScoasa(JLabel[] cantitatePesteScoasa) {
		this.cantitatePesteScoasa = cantitatePesteScoasa;
	}

	public void setCantitatePesteSiguraMinima(JLabel[] cantitatePesteSiguraMinima) {
		this.cantitatePesteSiguraMinima = cantitatePesteSiguraMinima;
	}

	public void setCantitatePesteEstimata(JLabel[] cantitatePesteEstimata) {
		this.cantitatePesteEstimata = cantitatePesteEstimata;
	}

	public JLabel getTipPesteTXT() {
		return tipPesteTXT;
	}

	public void setTipPesteTXT(JLabel tipPesteTXT) {
		this.tipPesteTXT = tipPesteTXT;
	}

	public JLabel getCantitatePesteIntrodusaTXT() {
		return cantitatePesteIntrodusaTXT;
	}

	public void setCantitatePesteIntrodusaTXT(JLabel cantitatePesteIntrodusaTXT) {
		this.cantitatePesteIntrodusaTXT = cantitatePesteIntrodusaTXT;
	}

	public JLabel getCantitatePesteScoasaTXT() {
		return cantitatePesteScoasaTXT;
	}

	public void setCantitatePesteScoasaTXT(JLabel cantitatePesteScoasaTXT) {
		this.cantitatePesteScoasaTXT = cantitatePesteScoasaTXT;
	}

	public JLabel getCantitatePesteEstimataTXT() {
		return cantitatePesteEstimataTXT;
	}

	public void setCantitatePesteEstimataTXT(JLabel cantitatePesteEstimataTXT) {
		this.cantitatePesteEstimataTXT = cantitatePesteEstimataTXT;
	}

	public JLabel[] getTipPeste() {
		return tipPeste;
	}

	public void setTipPeste(String[] tipPeste) {
		this.tipPesteSTR=tipPeste;
		this.tipPeste = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.tipPeste[i]= new JLabel("                    ");
		}
		int i=0;
		for (String string : tipPeste) {
			this.tipPeste[i].setText(string);
			i++;
		}
	}

	public JLabel[] getCantitatePesteIntrodusa() {
		return cantitatePesteIntrodusa;
	}

	public void setCantitatePesteIntrodusa(String[] cantitatePesteIntrodusa) {
		this.cantitatePesteIntrodusa = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.cantitatePesteIntrodusa[i]= new JLabel("                    ");
		}
		
		int i=0;
		for (String string : cantitatePesteIntrodusa) {
			this.cantitatePesteIntrodusa[i].setText(string);
			i++;
		}
	}

	public JLabel[] getCantitatePesteScoasa() {
		return cantitatePesteScoasa;
	}

	public void setCantitatePesteScoasa(String[] cantitatePesteScoasa) {
		this.cantitatePesteScoasa = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.cantitatePesteScoasa[i]= new JLabel("                    ");
		}
		
		int i=0;
		for (String string : cantitatePesteScoasa) {
			this.cantitatePesteScoasa[i].setText(string);
			i++;
		}
	}

	public JLabel[] getCantitatePesteEstimata() {
		return cantitatePesteEstimata;
	}

	public void setCantitatePesteEstimata(String[] cantitatePesteEstimata) {
		this.cantitatePesteEstimata = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.cantitatePesteEstimata[i]= new JLabel("                    ");
		}
		
		int i=0;
		for (String string : cantitatePesteEstimata) {
			this.cantitatePesteEstimata[i].setText(string);
			i++;
		}
	}

	public int getNrTipuriPesti() {
		return nrTipuriPesti;
	}

	public void setNrTipuriPesti(int nrTipuriPesti) {
		this.nrTipuriPesti = nrTipuriPesti;
	}
	
	public JLabel getCantitatePesteSiguraMinimaTXT() {
		return cantitatePesteSiguraMinimaTXT;
	}

	public void setCantitatePesteSiguraMinimaTXT(JLabel cantitatePesteSiguraMinimaTXT) {
		this.cantitatePesteSiguraMinimaTXT = cantitatePesteSiguraMinimaTXT;
	}

	public JLabel[] getCantitatePesteSiguraMinima() {
		return cantitatePesteSiguraMinima;
	}

	public void setCantitatePesteSiguraMinima(String[] cantitatePesteSiguraMinima) {
		this.cantitatePesteSiguraMinima = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.cantitatePesteSiguraMinima[i]= new JLabel("                    ");
		}
		int i=0;
		for (String string : cantitatePesteSiguraMinima) {
			this.cantitatePesteSiguraMinima[i].setText(string);
			i++;
		}
	}

	
	public JPanel getPanouResetareBazin() {
		return panouResetareBazin;
	}

	public void setPanouResetareBazin(JPanel panouResetareBazin) {
		this.panouResetareBazin = panouResetareBazin;
	}

	public GridBagConstraints getcResetareBazin() {
		return cResetareBazin;
	}

	public void setcResetareBazin(GridBagConstraints cResetareBazin) {
		this.cResetareBazin = cResetareBazin;
	}

	public JButton getResetareBazin() {
		return resetareBazin;
	}

	public void setResetareBazin(JButton resetareBazin) {
		this.resetareBazin = resetareBazin;
	}

	public JButton getResetareBazinDa() {
		return resetareBazinDa;
	}

	public void setResetareBazinDa(JButton resetareBazinDa) {
		this.resetareBazinDa = resetareBazinDa;
	}

	public JButton getResetareBazinNu() {
		return resetareBazinNu;
	}

	public void setResetareBazinNu(JButton resetareBazinNu) {
		this.resetareBazinNu = resetareBazinNu;
	}

	public JLabel getResetareBazinTXT() {
		return resetareBazinTXT;
	}

	public void setResetareBazinTXT(JLabel resetareBazinTXT) {
		this.resetareBazinTXT = resetareBazinTXT;
	}

	public JPanel getPanouAdaugareTipPeste() {
		return panouAdaugareTipPeste;
	}

	public void setPanouAdaugareTipPeste(JPanel panouAdaugareTipPeste) {
		this.panouAdaugareTipPeste = panouAdaugareTipPeste;
	}

	public GridBagConstraints getcAdaugareTipPeste() {
		return cAdaugareTipPeste;
	}

	public void setcAdaugareTipPeste(GridBagConstraints cAdaugareTipPeste) {
		this.cAdaugareTipPeste = cAdaugareTipPeste;
	}

	public JButton getInapoiAdaugareTipPeste() {
		return inapoiAdaugareTipPeste;
	}

	public void setInapoiAdaugareTipPeste(JButton inapoiAdaugareTipPeste) {
		this.inapoiAdaugareTipPeste = inapoiAdaugareTipPeste;
	}

	public void setCantitateBalegarTXT(JLabel cantitateBalegarTXT) {
		this.cantitateBalegarTXT = cantitateBalegarTXT;
	}

	public void setCantitateBalegarNR(JLabel cantitateBalegarNR) {
		this.cantitateBalegarNR = cantitateBalegarNR;
	}

	public void setMedieTemperaturaTXT(JLabel medieTemperaturaTXT) {
		this.medieTemperaturaTXT = medieTemperaturaTXT;
	}

	public void setMedieTemperaturaNR(JLabel medieTemperaturaNR) {
		this.medieTemperaturaNR = medieTemperaturaNR;
	}

	public void setMedieNivelApaTXT(JLabel medieNivelApaTXT) {
		this.medieNivelApaTXT = medieNivelApaTXT;
	}

	public void setMedieNivelApaNR(JLabel medieNivelApaNR) {
		this.medieNivelApaNR = medieNivelApaNR;
	}

	public void setCantitateFitoplanctonTXT(JLabel cantitateFitoplanctonTXT) {
		this.cantitateFitoplanctonTXT = cantitateFitoplanctonTXT;
	}

	public void setCantitateFitoplanctonNR(JLabel cantitateFitoplanctonNR) {
		this.cantitateFitoplanctonNR = cantitateFitoplanctonNR;
	}

	public void setDezinfectieTXT(JLabel dezinfectieTXT) {
		this.dezinfectieTXT = dezinfectieTXT;
	}

	public void setDezinfectieNR(JLabel dezinfectieNR) {
		this.dezinfectieNR = dezinfectieNR;
	}

	public void setUmplereTXT(JLabel umplereTXT) {
		this.umplereTXT = umplereTXT;
	}

	public void setUmplereNR(JLabel umplereNR) {
		this.umplereNR = umplereNR;
	}

	public void setGolireTXT(JLabel golireTXT) {
		this.golireTXT = golireTXT;
	}

	public void setGolireNR(JLabel golireNR) {
		this.golireNR = golireNR;
	}
	public JComboBox getPestiMeniu() {
		return pestiMeniu;
	}

	public void setPestiMeniu(JComboBox pestiMeniu) {
		this.pestiMeniu = pestiMeniu;
	}

	public JTextField getCantitateDePesteAdaugata() {
		return cantitateDePesteAdaugata;
	}

	public void setCantitateDePesteAdaugata(JTextField cantitateDePesteAdaugata) {
		this.cantitateDePesteAdaugata = cantitateDePesteAdaugata;
	}

	public JTextField getCantitateDePesteScoasa() {
		return cantitateDePesteScoasa;
	}

	public void setCantitateDePesteScoasa(JTextField cantitateDePesteScoasa) {
		this.cantitateDePesteScoasa = cantitateDePesteScoasa;
	}

	public JButton getAdaugaPeste() {
		return adaugaPeste;
	}

	public void setAdaugaPeste(JButton adaugaPeste) {
		this.adaugaPeste = adaugaPeste;
	}

	public JButton getScoatePeste() {
		return scoatePeste;
	}

	public void setScoatePeste(JButton scoatePeste) {
		this.scoatePeste = scoatePeste;
	}
	
	public JPanel getPanouFurajeCantitati() {
		return panouFurajeCantitati;
	}

	public void setPanouFurajeCantitati(JPanel panouFurajeCantitati) {
		this.panouFurajeCantitati = panouFurajeCantitati;
	}

	public GridBagConstraints getcFuraje() {
		return cFuraje;
	}

	public void setcFuraje(GridBagConstraints cFuraje) {
		this.cFuraje = cFuraje;
	}

	public JButton getIstoricFuraje() {
		return istoricFuraje;
	}

	public void setIstoricFuraje(JButton istoricFuraje) {
		this.istoricFuraje = istoricFuraje;
	}

	public JButton getAdaugareFuraj() {
		return adaugareFuraj;
	}

	public void setAdaugareFuraj(JButton adaugareFuraj) {
		this.adaugareFuraj = adaugareFuraj;
	}

	public JButton getAdaugareTipFuraj() {
		return adaugareTipFuraj;
	}

	public void setAdaugareTipFuraj(JButton adaugareTipFuraj) {
		this.adaugareTipFuraj = adaugareTipFuraj;
	}

	public JButton getIntroducereTipPeste() {
		return introducereTipPeste;
	}

	public void setIntroducereTipPeste(JButton introducereTipPeste) {
		this.introducereTipPeste = introducereTipPeste;
	}

	public JButton getInapoiFuraj() {
		return inapoiFuraj;
	}

	public void setInapoiFuraj(JButton inapoiFuraj) {
		this.inapoiFuraj = inapoiFuraj;
	}

	public JLabel getTipFurajTXT() {
		return tipFurajTXT;
	}

	public void setTipFurajTXT(JLabel tipFurajTXT) {
		this.tipFurajTXT = tipFurajTXT;
	}

	public JLabel getCantitateFurajIntrodusaTXT() {
		return cantitateFurajIntrodusaTXT;
	}

	public void setCantitateFurajIntrodusaTXT(JLabel cantitateFurajIntrodusaTXT) {
		this.cantitateFurajIntrodusaTXT = cantitateFurajIntrodusaTXT;
	}

	public JLabel getIntroducereTipPesteTXT() {
		return introducereTipPesteTXT;
	}

	public void setIntroducereTipPesteTXT(JLabel introducereTipPesteTXT) {
		this.introducereTipPesteTXT = introducereTipPesteTXT;
	}

	public int getNrTipuriFuraje() {
		return nrTipuriFuraje;
	}

	public void setNrTipuriFuraje(int nrTipuriFuraje) {
		this.nrTipuriFuraje = nrTipuriFuraje;
	}

	public JLabel[] getTipFuraj() {
		return tipFuraj;
	}

	public void setTipFuraj(String[] tipFuraj) {
		this.tipFurajSTR=tipFuraj;
		this.tipFuraj = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.tipFuraj[i]= new JLabel("                    ");
		}
		int i=0;
		for (String string : tipFuraj) {
			this.tipFuraj[i].setText(string);
			i++;
		}
	}

	public JLabel[] getCantitateFurajIntrodusa() {
		return cantitateFurajIntrodusa;
	}
	
	public void setCantitateFurajIntrodusa(String[] cantitateFurajIntrodusa) {
		this.cantitateFurajIntrodusa = new JLabel[100];
		for(int i=0; i<100; i++) {
			this.cantitateFurajIntrodusa[i]= new JLabel("                    ");
		}
		int i=0;
		for (String string : cantitateFurajIntrodusa) {
			this.cantitateFurajIntrodusa[i].setText(string);
			i++;
		}
	}

	public JTextField getIntroducereTipPesteNR() {
		return introducereTipPesteNR;
	}

	public void setIntroducereTipPesteNR(JTextField introducereTipPesteNR) {
		this.introducereTipPesteNR = introducereTipPesteNR;
	}

	public JPanel getPanouAdaugareTipFuraj() {
		return panouAdaugareTipFuraj;
	}

	public void setPanouAdaugareTipFuraj(JPanel panouAdaugareTipFuraj) {
		this.panouAdaugareTipFuraj = panouAdaugareTipFuraj;
	}

	public GridBagConstraints getcAdaugareTipFuraj() {
		return cAdaugareTipFuraj;
	}

	public void setcAdaugareTipFuraj(GridBagConstraints cAdaugareTipFuraj) {
		this.cAdaugareTipFuraj = cAdaugareTipFuraj;
	}

	public void setTipFuraj(JLabel[] tipFuraj) {
		this.tipFuraj = tipFuraj;
	}

	public void setCantitateFurajIntrodusa(JLabel[] cantitateFurajIntrodusa) {
		this.cantitateFurajIntrodusa = cantitateFurajIntrodusa;
	}
	
	public JButton getAdaugaFuraj() {
		return adaugaFuraj;
	}

	public void setAdaugaFuraj(JButton adaugaFuraj) {
		this.adaugaFuraj = adaugaFuraj;
	}

	public JButton getIntroducereTipFuraj() {
		return introducereTipFuraj;
	}

	public void setIntroducereTipFuraj(JButton introducereTipFuraj) {
		this.introducereTipFuraj = introducereTipFuraj;
	}

	public JButton getInapoiAdaugareTipFuraj() {
		return inapoiAdaugareTipFuraj;
	}

	public void setInapoiAdaugareTipFuraj(JButton inapoiAdaugareTipFuraj) {
		this.inapoiAdaugareTipFuraj = inapoiAdaugareTipFuraj;
	}

	public String[] getTipPesteSTR() {
		return tipPesteSTR;
	}

	public void setTipPesteSTR(String[] tipPesteSTR) {
		this.tipPesteSTR = tipPesteSTR;
	}

	public String[] getTipFurajSTR() {
		return tipFurajSTR;
	}

	public void setTipFurajSTR(String[] tipFurajSTR) {
		this.tipFurajSTR = tipFurajSTR;
	}

	public JComboBox getFurajMeniu() {
		return furajMeniu;
	}

	public void setFurajMeniu(JComboBox furajMeniu) {
		this.furajMeniu = furajMeniu;
	}

	public JTextField getCantitateDeFurajAdaugata() {
		return cantitateDeFurajAdaugata;
	}

	public void setCantitateDeFurajAdaugata(JTextField cantitateDeFurajAdaugata) {
		this.cantitateDeFurajAdaugata = cantitateDeFurajAdaugata;
	}

	public JTextField getIntroducereTipFurajNR() {
		return introducereTipFurajNR;
	}

	public void setIntroducereTipFurajNR(JTextField introducereTipFurajNR) {
		this.introducereTipFurajNR = introducereTipFurajNR;
	}

	public JLabel getIntroducereTipFurajTXT() {
		return introducereTipFurajTXT;
	}

	public void setIntroducereTipFurajTXT(JLabel introducereTipFurajTXT) {
		this.introducereTipFurajTXT = introducereTipFurajTXT;
	}
	
	public JLabel getDataPesteIstoricTXT() {
		return dataPesteIstoricTXT;
	}

	public void setDataPesteIstoricTXT(JLabel dataPesteIstoricTXT) {
		this.dataPesteIstoricTXT = dataPesteIstoricTXT;
	}

	public JLabel getTipOperatiunePesteIstoricTXT() {
		return tipOperatiunePesteIstoricTXT;
	}

	public void setTipOperatiunePesteIstoricTXT(JLabel tipOperatiunePesteIstoricTXT) {
		this.tipOperatiunePesteIstoricTXT = tipOperatiunePesteIstoricTXT;
	}

	public JLabel getCantitatePesteIntrodusaIstoricTXT() {
		return cantitatePesteIntrodusaIstoricTXT;
	}

	public void setCantitatePesteIntrodusaIstoricTXT(JLabel cantitatePesteIntrodusaIstoricTXT) {
		this.cantitatePesteIntrodusaIstoricTXT = cantitatePesteIntrodusaIstoricTXT;
	}
	
	public JPanel getPanouSelectareAn() {
		return panouSelectareAn;
	}

	public void setPanouSelectareAn(JPanel panouSelectareAn) {
		this.panouSelectareAn = panouSelectareAn;
	}

	public GridBagConstraints getcSelectareAn() {
		return cSelectareAn;
	}

	public void setcSelectareAn(GridBagConstraints cSelectareAn) {
		this.cSelectareAn = cSelectareAn;
	}

	public JButton getSelectareAn() {
		return selectareAn;
	}

	public void setSelectareAn(JButton selectareAn) {
		this.selectareAn = selectareAn;
	}

	public JButton getInapoiSelectareAn() {
		return inapoiSelectareAn;
	}

	public void setInapoiSelectareAn(JButton inapoiSelectareAn) {
		this.inapoiSelectareAn = inapoiSelectareAn;
	}

	public JLabel getTipPesteIsotricTXT() {
		return tipPesteIsotricTXT;
	}

	public void setTipPesteIsotricTXT(JLabel tipPesteIsotricTXT) {
		this.tipPesteIsotricTXT = tipPesteIsotricTXT;
	}

	public JLabel getSelectareAnTXT() {
		return selectareAnTXT;
	}

	public void setSelectareAnTXT(JLabel selectareAnTXT) {
		this.selectareAnTXT = selectareAnTXT;
	}

	public JComboBox getSelectareAnMeniu() {
		return selectareAnMeniu;
	}

	public void setSelectareAnMeniu(JComboBox selectareAnMeniu) {
		this.selectareAnMeniu = selectareAnMeniu;
	}
	
	public JPanel getPanouIstoric() {
		return panouIstoric;
	}

	public void setPanouIstoric(JPanel panouIstoric) {
		this.panouIstoric = panouIstoric;
	}

	public GridBagConstraints getcIstoric() {
		return cIstoric;
	}

	public void setcIstoric(GridBagConstraints cIstoric) {
		this.cIstoric = cIstoric;
	}

	public JButton getInapoiIstoric() {
		return inapoiIstoric;
	}

	public void setInapoiIstoric(JButton inapoiIstoric) {
		this.inapoiIstoric = inapoiIstoric;
	}

	
	public ArrayList<String> getListaIstoric() {
		return listaIstoric;
	}

	public void setListaIstoric(ArrayList<String> listaIstoric) {
		this.listaIstoric = listaIstoric;
	}
	
	public void addToListaIstoric(String listaIstoric) {
		this.listaIstoric.add(listaIstoric);
	}
	
	public void resetListaIstoric() {
		this.listaIstoric = new ArrayList<String>();
	}

	public JButton getPescuitDeProba() {
		return pescuitDeProba;
	}

	public void setPescuitDeProba(JButton pescuitDeProba) {
		this.pescuitDeProba = pescuitDeProba;
	}

	public JLabel getPescuitDeProbaTXT() {
		return pescuitDeProbaTXT;
	}

	public void setPescuitDeProbaTXT(JLabel pescuitDeProbaTXT) {
		this.pescuitDeProbaTXT = pescuitDeProbaTXT;
	}

	public JLabel getPescuitDeProbaNR() {
		return pescuitDeProbaNR;
	}

	public void setPescuitDeProbaNR(JLabel pescuitDeProbaNR) {
		this.pescuitDeProbaNR = pescuitDeProbaNR;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	

	public JPanel getPanouAdaugareUnic() {
		return panouAdaugareUnic;
	}

	public void setPanouAdaugareUnic(JPanel panouAdaugareUnic) {
		this.panouAdaugareUnic = panouAdaugareUnic;
	}

	public GridBagConstraints getcAdaugareUnic() {
		return cAdaugareUnic;
	}

	public void setcAdaugareUnic(GridBagConstraints cAdaugareUnic) {
		this.cAdaugareUnic = cAdaugareUnic;
	}

	public JButton getAdaugareUnicPeste() {
		return adaugareUnicPeste;
	}

	public void setAdaugareUnicPeste(JButton adaugareUnicPeste) {
		this.adaugareUnicPeste = adaugareUnicPeste;
	}

	public JButton getAdaugareUnicFuraj() {
		return adaugareUnicFuraj;
	}

	public void setAdaugareUnicFuraj(JButton adaugareUnicFuraj) {
		this.adaugareUnicFuraj = adaugareUnicFuraj;
	}

	public JButton getAdaugareUnicOxigen() {
		return adaugareUnicOxigen;
	}

	public void setAdaugareUnicOxigen(JButton adaugareUnicOxigen) {
		this.adaugareUnicOxigen = adaugareUnicOxigen;
	}

	public JButton getAdaugareUnicPh() {
		return adaugareUnicPh;
	}

	public void setAdaugareUnicPh(JButton adaugareUnicPh) {
		this.adaugareUnicPh = adaugareUnicPh;
	}

	public JButton getAdaugareUnicBalegar() {
		return adaugareUnicBalegar;
	}

	public void setAdaugareUnicBalegar(JButton adaugareUnicBalegar) {
		this.adaugareUnicBalegar = adaugareUnicBalegar;
	}

	public JButton getAdaugareUnicTemperatura() {
		return adaugareUnicTemperatura;
	}

	public void setAdaugareUnicTemperatura(JButton adaugareUnicTemperatura) {
		this.adaugareUnicTemperatura = adaugareUnicTemperatura;
	}

	public JButton getAdaugareUnicNivelApa() {
		return adaugareUnicNivelApa;
	}

	public void setAdaugareUnicNivelApa(JButton adaugareUnicNivelApa) {
		this.adaugareUnicNivelApa = adaugareUnicNivelApa;
	}

	public JButton getAdaugareUnicFitoplancton() {
		return adaugareUnicFitoplancton;
	}

	public void setAdaugareUnicFitoplancton(JButton adaugareUnicFitoplancton) {
		this.adaugareUnicFitoplancton = adaugareUnicFitoplancton;
	}

	public JButton getAdaugareUnicDezinfectie() {
		return adaugareUnicDezinfectie;
	}

	public void setAdaugareUnicDezinfectie(JButton adaugareUnicDezinfectie) {
		this.adaugareUnicDezinfectie = adaugareUnicDezinfectie;
	}

	public JButton getAdaugareUnicUmplere() {
		return adaugareUnicUmplere;
	}

	public void setAdaugareUnicUmplere(JButton adaugareUnicUmplere) {
		this.adaugareUnicUmplere = adaugareUnicUmplere;
	}

	public JButton getAdaugareUnicGolire() {
		return adaugareUnicGolire;
	}

	public void setAdaugareUnicGolire(JButton adaugareUnicGolire) {
		this.adaugareUnicGolire = adaugareUnicGolire;
	}

	public JButton getAdaugareUnicPescuitDeProba() {
		return adaugareUnicPescuitDeProba;
	}

	public void setAdaugareUnicPescuitDeProba(JButton adaugareUnicPescuitDeProba) {
		this.adaugareUnicPescuitDeProba = adaugareUnicPescuitDeProba;
	}

	public JButton getInapoiAdaugareUnic() {
		return inapoiAdaugareUnic;
	}

	public void setInapoiAdaugareUnic(JButton inapoiAdaugareUnic) {
		this.inapoiAdaugareUnic = inapoiAdaugareUnic;
	}

	public JComboBox getSelectareZiAdaugareUnic() {
		return selectareZiAdaugareUnic;
	}

	public void setSelectareZiAdaugareUnic(JComboBox selectareZiAdaugareUnic) {
		this.selectareZiAdaugareUnic = selectareZiAdaugareUnic;
	}

	public JComboBox getSelectareLunaAdaugareUnic() {
		return selectareLunaAdaugareUnic;
	}

	public void setSelectareLunaAdaugareUnic(JComboBox selectareLunaAdaugareUnic) {
		this.selectareLunaAdaugareUnic = selectareLunaAdaugareUnic;
	}

	public JComboBox getSelectareAnAdaugareUnic() {
		return selectareAnAdaugareUnic;
	}

	public void setSelectareAnAdaugareUnic(JComboBox selectareAnAdaugareUnic) {
		this.selectareAnAdaugareUnic = selectareAnAdaugareUnic;
	}
	
	public JButton getAdaugareUnic() {
		return adaugareUnic;
	}

	public void setAdaugareUnic(JButton adaugareUnic) {
		this.adaugareUnic = adaugareUnic;
	}

	public JLabel getAdaugareUnicTXT() {
		return adaugareUnicTXT;
	}

	public void setAdaugareUnicTXT(JLabel adaugareUnicTXT) {
		this.adaugareUnicTXT = adaugareUnicTXT;
	}
	
	public JTextField getAdaugareUnicNR() {
		return adaugareUnicNR;
	}

	public void setAdaugareUnicNR(JTextField adaugareUnicNR) {
		this.adaugareUnicNR = adaugareUnicNR;
	}

	public JButton getCautaBazin() {
		return cautaBazin;
	}

	public void setCautaBazin(JButton cautaBazin) {
		this.cautaBazin = cautaBazin;
	}

	public JComboBox getSelectareBazin() {
		return selectareBazin;
	}

	public void setSelectareBazin(JComboBox selectareBazin) {
		this.selectareBazin = selectareBazin;
	}
	
	public JButton getAdaugareTipPesteFinal() {
		return adaugareTipPesteFinal;
	}

	public void setAdaugareTipPesteFinal(JButton adaugareTipPesteFinal) {
		this.adaugareTipPesteFinal = adaugareTipPesteFinal;
	}

	public JButton getAdaugareTipFurajFinal() {
		return adaugareTipFurajFinal;
	}

	public void setAdaugareTipFurajFinal(JButton adaugareTipFurajFinal) {
		this.adaugareTipFurajFinal = adaugareTipFurajFinal;
	}
	
	public JLabel getAdaugareTipPesteFinalTXT() {
		return adaugareTipPesteFinalTXT;
	}

	public void setAdaugareTipPesteFinalTXT(JLabel adaugareTipPesteFinalTXT) {
		this.adaugareTipPesteFinalTXT = adaugareTipPesteFinalTXT;
	}

	public JLabel getAdaugareTipFurajFinalTXT() {
		return adaugareTipFurajFinalTXT;
	}

	public void setAdaugareTipFurajFinalTXT(JLabel adaugareTipFurajFinalTXT) {
		this.adaugareTipFurajFinalTXT = adaugareTipFurajFinalTXT;
	}

	public JTextField getAdaugareTipPesteFinalNr() {
		return adaugareTipPesteFinalNr;
	}

	public void setAdaugareTipPesteFinalNr(JTextField adaugareTipPesteFinalNr) {
		this.adaugareTipPesteFinalNr = adaugareTipPesteFinalNr;
	}

	public JTextField getAdaugareTipFurajFinalNr() {
		return adaugareTipFurajFinalNr;
	}

	public void setAdaugareTipFurajFinalNr(JTextField adaugareTipFurajFinalNr) {
		this.adaugareTipFurajFinalNr = adaugareTipFurajFinalNr;
	}
	
	
	
	public JComboBox getSelectareMasina() {
		return selectareMasina;
	}

	public void setSelectareMasina(JComboBox selectareMasina) {
		this.selectareMasina = selectareMasina;
	}

	
	
	public JButton getCautaMasina() {
		return cautaMasina;
	}

	public void setCautaMasina(JButton cautaMasina) {
		this.cautaMasina = cautaMasina;
	}

	public JButton getAdaugaMasina() {
		return adaugaMasina;
	}

	public void setAdaugaMasina(JButton adaugaMasina) {
		this.adaugaMasina = adaugaMasina;
	}

	public JPanel getPanouMasina() {
		return panouMasina;
	}

	public void setPanouMasina(JPanel panouMasina) {
		this.panouMasina = panouMasina;
	}


	public JButton getInapoiMasina() {
		return inapoiMasina;
	}

	public void setInapoiMasina(JButton inapoiMasina) {
		this.inapoiMasina = inapoiMasina;
	}

	public GridBagConstraints getcMasina() {
		return cMasina;
	}

	public void setcMasina(GridBagConstraints cMasina) {
		this.cMasina = cMasina;
	}

	public JButton getVeziIstoricCurse() {
		return veziIstoricCurse;
	}

	public void setVeziIstoricCurse(JButton veziIstoricCurse) {
		this.veziIstoricCurse = veziIstoricCurse;
	}

	public JButton getAdaugaCursa() {
		return adaugaCursa;
	}

	public void setAdaugaCursa(JButton adaugaCursa) {
		this.adaugaCursa = adaugaCursa;
	}

	public JButton getVeziIstoricCurseLunar() {
		return veziIstoricCurseLunar;
	}

	public void setVeziIstoricCurseLunar(JButton veziIstoricCurseLunar) {
		this.veziIstoricCurseLunar = veziIstoricCurseLunar;
	}

	public JButton getVeziIstoricRevizii() {
		return veziIstoricRevizii;
	}

	public void setVeziIstoricRevizii(JButton veziIstoricRevizii) {
		this.veziIstoricRevizii = veziIstoricRevizii;
	}

	public JButton getAduagaRevizie() {
		return aduagaRevizie;
	}

	public void setAduagaRevizie(JButton aduagaRevizie) {
		this.aduagaRevizie = aduagaRevizie;
	}

	public JButton getVeziIstoricReparatii() {
		return veziIstoricReparatii;
	}

	public void setVeziIstoricReparatii(JButton veziIstoricReparatii) {
		this.veziIstoricReparatii = veziIstoricReparatii;
	}

	public JButton getAduagaReparatie() {
		return aduagaReparatie;
	}

	public void setAduagaReparatie(JButton aduagaReparatie) {
		this.aduagaReparatie = aduagaReparatie;
	}

	public JLabel getDistantaParcursaTXT() {
		return distantaParcursaTXT;
	}

	public void setDistantaParcursaTXT(JLabel distantaParcursaTXT) {
		this.distantaParcursaTXT = distantaParcursaTXT;
	}

	public JLabel getConsumRealizatTXT() {
		return consumRealizatTXT;
	}

	public void setConsumRealizatTXT(JLabel consumRealizatTXT) {
		this.consumRealizatTXT = consumRealizatTXT;
	}

	public JLabel getDataRevizieTXT() {
		return dataRevizieTXT;
	}

	public void setDataRevizieTXT(JLabel dataRevizieTXT) {
		this.dataRevizieTXT = dataRevizieTXT;
	}

	public JLabel getDataExpirareRevizieTXT() {
		return dataExpirareRevizieTXT;
	}

	public void setDataExpirareRevizieTXT(JLabel dataExpirareRevizieTXT) {
		this.dataExpirareRevizieTXT = dataExpirareRevizieTXT;
	}

	public JLabel getDistantaParcursaNR() {
		return distantaParcursaNR;
	}

	public void setDistantaParcursaNR(JLabel distantaParcursaNR) {
		this.distantaParcursaNR = distantaParcursaNR;
	}

	public JLabel getConsumRealizatNR() {
		return consumRealizatNR;
	}

	public void setConsumRealizatNR(JLabel consumRealizatNR) {
		this.consumRealizatNR = consumRealizatNR;
	}

	public JLabel getDataRevizieNR() {
		return dataRevizieNR;
	}

	public void setDataRevizieNR(JLabel dataRevizieNR) {
		this.dataRevizieNR = dataRevizieNR;
	}

	public JLabel getDataExpirareRevizieNR() {
		return dataExpirareRevizieNR;
	}

	public void setDataExpirareRevizieNR(JLabel dataExpirareRevizieNR) {
		this.dataExpirareRevizieNR = dataExpirareRevizieNR;
	}

	public JLabel getSpatiu1() {
		return spatiu1;
	}

	public void setSpatiu1(JLabel spatiu1) {
		this.spatiu1 = spatiu1;
	}

	public JLabel getSpatiu2() {
		return spatiu2;
	}

	public void setSpatiu2(JLabel spatiu2) {
		this.spatiu2 = spatiu2;
	}
	
	public JPanel getPanouAdaugare() {
		return panouAdaugare;
	}

	public void setPanouAdaugare(JPanel panouAdaugare) {
		this.panouAdaugare = panouAdaugare;
	}

	public GridBagConstraints getcAdaugare() {
		return cAdaugare;
	}

	public void setcAdaugare(GridBagConstraints cAdaugare) {
		this.cAdaugare = cAdaugare;
	}

	public JButton getAdaugaBazin() {
		return adaugaBazin;
	}

	public void setAdaugaBazin(JButton adaugaBazin) {
		this.adaugaBazin = adaugaBazin;
	}

	public JButton getAdaugare() {
		return adaugare;
	}

	public void setAdaugare(JButton adaugare) {
		this.adaugare = adaugare;
	}

	public JButton getInapoiAdaugare() {
		return inapoiAdaugare;
	}

	public void setInapoiAdaugare(JButton inapoiAdaugare) {
		this.inapoiAdaugare = inapoiAdaugare;
	}

	public JLabel getAdaugareTXT() {
		return adaugareTXT;
	}

	public void setAdaugareTXT(JLabel adaugareTXT) {
		this.adaugareTXT = adaugareTXT;
	}

	public JTextField getAdaugareNR() {
		return adaugareNR;
	}

	public void setAdaugareNR(JTextField adaugareNR) {
		this.adaugareNR = adaugareNR;
	}

	
	public JPanel getPanouAdaugareCursa() {
		return panouAdaugareCursa;
	}

	public void setPanouAdaugareCursa(JPanel panouAdaugareCursa) {
		this.panouAdaugareCursa = panouAdaugareCursa;
	}

	public JPanel getPanouAdaugareRevizie() {
		return panouAdaugareRevizie;
	}

	public void setPanouAdaugareRevizie(JPanel panouAdaugareRevizie) {
		this.panouAdaugareRevizie = panouAdaugareRevizie;
	}

	public JPanel getPanouAdaugareReparatie() {
		return panouAdaugareReparatie;
	}

	public void setPanouAdaugareReparatie(JPanel panouAdaugareReparatie) {
		this.panouAdaugareReparatie = panouAdaugareReparatie;
	}

	public GridBagConstraints getcAdaugareCursa() {
		return cAdaugareCursa;
	}

	public void setcAdaugareCursa(GridBagConstraints cAdaugareCursa) {
		this.cAdaugareCursa = cAdaugareCursa;
	}

	public GridBagConstraints getcAdaugareRevizie() {
		return cAdaugareRevizie;
	}

	public void setcAdaugareRevizie(GridBagConstraints cAdaugareRevizie) {
		this.cAdaugareRevizie = cAdaugareRevizie;
	}

	public GridBagConstraints getcAdaugareReparatie() {
		return cAdaugareReparatie;
	}

	public void setcAdaugareReparatie(GridBagConstraints cAdaugareReparatie) {
		this.cAdaugareReparatie = cAdaugareReparatie;
	}

	public JButton getAdaugareCursa() {
		return adaugareCursa;
	}

	public void setAdaugareCursa(JButton adaugareCursa) {
		this.adaugareCursa = adaugareCursa;
	}

	public JButton getAdaugareRevizie() {
		return adaugareRevizie;
	}

	public void setAdaugareRevizie(JButton adaugareRevizie) {
		this.adaugareRevizie = adaugareRevizie;
	}

	public JButton getAdaugareReparatie() {
		return adaugareReparatie;
	}

	public void setAdaugareReparatie(JButton adaugareReparatie) {
		this.adaugareReparatie = adaugareReparatie;
	}

	public JButton getInapoiAdaugareCursa() {
		return inapoiAdaugareCursa;
	}

	public void setInapoiAdaugareCursa(JButton inapoiAdaugareCursa) {
		this.inapoiAdaugareCursa = inapoiAdaugareCursa;
	}

	public JButton getInapoiAdaugareRevizie() {
		return inapoiAdaugareRevizie;
	}

	public void setInapoiAdaugareRevizie(JButton inapoiAdaugareRevizie) {
		this.inapoiAdaugareRevizie = inapoiAdaugareRevizie;
	}

	public JButton getInapoiAdaugareReparatie() {
		return inapoiAdaugareReparatie;
	}

	public void setInapoiAdaugareReparatie(JButton inapoiAdaugareReparatie) {
		this.inapoiAdaugareReparatie = inapoiAdaugareReparatie;
	}

	public JLabel getAdaugareCursaSoferTXT() {
		return adaugareCursaSoferTXT;
	}

	public void setAdaugareCursaSoferTXT(JLabel adaugareCursaSoferTXT) {
		this.adaugareCursaSoferTXT = adaugareCursaSoferTXT;
	}

	public JLabel getAdaugareCursaDistantaTXT() {
		return adaugareCursaDistantaTXT;
	}

	public void setAdaugareCursaDistantaTXT(JLabel adaugareCursaDistantaTXT) {
		this.adaugareCursaDistantaTXT = adaugareCursaDistantaTXT;
	}

	public JLabel getAdaugareCursaConsumTXT() {
		return adaugareCursaConsumTXT;
	}

	public void setAdaugareCursaConsumTXT(JLabel adaugareCursaConsumTXT) {
		this.adaugareCursaConsumTXT = adaugareCursaConsumTXT;
	}

	public JLabel getAdaugareCursaDestinatieTXT() {
		return adaugareCursaDestinatieTXT;
	}

	public void setAdaugareCursaDestinatieTXT(JLabel adaugareCursaDestinatieTXT) {
		this.adaugareCursaDestinatieTXT = adaugareCursaDestinatieTXT;
	}

	public JLabel getAdaugareCursaDataTXT() {
		return adaugareCursaDataTXT;
	}

	public void setAdaugareCursaDataTXT(JLabel adaugareCursaDataTXT) {
		this.adaugareCursaDataTXT = adaugareCursaDataTXT;
	}

	public JLabel getAdaugareRevizieTXT() {
		return adaugareRevizieTXT;
	}

	public void setAdaugareRevizieTXT(JLabel adaugareRevizieTXT) {
		this.adaugareRevizieTXT = adaugareRevizieTXT;
	}

	public JLabel getAdaugareRevizieExpirareTXT() {
		return adaugareRevizieExpirareTXT;
	}

	public void setAdaugareRevizieExpirareTXT(JLabel adaugareRevizieExpirareTXT) {
		this.adaugareRevizieExpirareTXT = adaugareRevizieExpirareTXT;
	}

	public JLabel getAdaugareReparatieCostTXT() {
		return adaugareReparatieCostTXT;
	}

	public void setAdaugareReparatieCostTXT(JLabel adaugareReparatieCostTXT) {
		this.adaugareReparatieCostTXT = adaugareReparatieCostTXT;
	}

	public JLabel getAdaugareReparatieMecanicTXT() {
		return adaugareReparatieMecanicTXT;
	}

	public void setAdaugareReparatieMecanicTXT(JLabel adaugareReparatieMecanicTXT) {
		this.adaugareReparatieMecanicTXT = adaugareReparatieMecanicTXT;
	}

	public JLabel getAdaugareReparatieDataTXT() {
		return adaugareReparatieDataTXT;
	}

	public void setAdaugareReparatieDataTXT(JLabel adaugareReparatieDataTXT) {
		this.adaugareReparatieDataTXT = adaugareReparatieDataTXT;
	}

	public JLabel getAdaugareReparatieProblemeAparuteTXT() {
		return adaugareReparatieProblemeAparuteTXT;
	}

	public void setAdaugareReparatieProblemeAparuteTXT(JLabel adaugareReparatieProblemeAparuteTXT) {
		this.adaugareReparatieProblemeAparuteTXT = adaugareReparatieProblemeAparuteTXT;
	}


	public JComboBox getSelectareZiAdaugareRevizie() {
		return selectareZiAdaugareRevizie;
	}

	public void setSelectareZiAdaugareRevizie(JComboBox selectareZiAdaugareRevizie) {
		this.selectareZiAdaugareRevizie = selectareZiAdaugareRevizie;
	}

	public JComboBox getSelectareLunaAdaugareRevizie() {
		return selectareLunaAdaugareRevizie;
	}

	public void setSelectareLunaAdaugareRevizie(JComboBox selectareLunaAdaugareRevizie) {
		this.selectareLunaAdaugareRevizie = selectareLunaAdaugareRevizie;
	}

	public JComboBox getSelectareAnAdaugareRevizie() {
		return selectareAnAdaugareRevizie;
	}

	public void setSelectareAnAdaugareRevizie(JComboBox selectareAnAdaugareRevizie) {
		this.selectareAnAdaugareRevizie = selectareAnAdaugareRevizie;
	}

	public JComboBox getSelectareZiAdaugareRevizieExpirare() {
		return selectareZiAdaugareRevizieExpirare;
	}

	public void setSelectareZiAdaugareRevizieExpirare(JComboBox selectareZiAdaugareRevizieExpirare) {
		this.selectareZiAdaugareRevizieExpirare = selectareZiAdaugareRevizieExpirare;
	}

	public JComboBox getSelectareLunaAdaugareRevizieExpirare() {
		return selectareLunaAdaugareRevizieExpirare;
	}

	public void setSelectareLunaAdaugareRevizieExpirare(JComboBox selectareLunaAdaugareRevizieExpirare) {
		this.selectareLunaAdaugareRevizieExpirare = selectareLunaAdaugareRevizieExpirare;
	}

	public JComboBox getSelectareAnAdaugareRevizieExpirare() {
		return selectareAnAdaugareRevizieExpirare;
	}

	public void setSelectareAnAdaugareRevizieExpirare(JComboBox selectareAnAdaugareRevizieExpirare) {
		this.selectareAnAdaugareRevizieExpirare = selectareAnAdaugareRevizieExpirare;
	}

	public JComboBox getSelectareZiAdaugareReparatieData() {
		return selectareZiAdaugareReparatieData;
	}

	public void setSelectareZiAdaugareReparatieData(JComboBox selectareZiAdaugareReparatieData) {
		this.selectareZiAdaugareReparatieData = selectareZiAdaugareReparatieData;
	}

	public JComboBox getSelectareLunaAdaugareReparatieData() {
		return selectareLunaAdaugareReparatieData;
	}

	public void setSelectareLunaAdaugareReparatieData(JComboBox selectareLunaAdaugareReparatieData) {
		this.selectareLunaAdaugareReparatieData = selectareLunaAdaugareReparatieData;
	}

	public JComboBox getSelectareAnAdaugareReparatieData() {
		return selectareAnAdaugareReparatieData;
	}

	public void setSelectareAnAdaugareReparatieData(JComboBox selectareAnAdaugareReparatieData) {
		this.selectareAnAdaugareReparatieData = selectareAnAdaugareReparatieData;
	}

	public JTextField getAdaugareCursaSoferNR() {
		return adaugareCursaSoferNR;
	}

	public void setAdaugareCursaSoferNR(JTextField adaugareCursaSoferNR) {
		this.adaugareCursaSoferNR = adaugareCursaSoferNR;
	}

	public JTextField getAdaugareCursaDistantaNR() {
		return adaugareCursaDistantaNR;
	}

	public void setAdaugareCursaDistantaNR(JTextField adaugareCursaDistantaNR) {
		this.adaugareCursaDistantaNR = adaugareCursaDistantaNR;
	}

	public JTextField getAdaugareCursaConsumNR() {
		return adaugareCursaConsumNR;
	}

	public void setAdaugareCursaConsumNR(JTextField adaugareCursaConsumNR) {
		this.adaugareCursaConsumNR = adaugareCursaConsumNR;
	}

	public JTextField getAdaugareCursaDestinatieNR() {
		return adaugareCursaDestinatieNR;
	}

	public void setAdaugareCursaDestinatieNR(JTextField adaugareCursaDestinatieNR) {
		this.adaugareCursaDestinatieNR = adaugareCursaDestinatieNR;
	}

	public JTextField getAdaugareReparatieCostNR() {
		return adaugareReparatieCostNR;
	}

	public void setAdaugareReparatieCostNR(JTextField adaugareReparatieCostNR) {
		this.adaugareReparatieCostNR = adaugareReparatieCostNR;
	}

	public JTextField getAdaugareReparatieMecanicNR() {
		return adaugareReparatieMecanicNR;
	}

	public void setAdaugareReparatieMecanicNR(JTextField adaugareReparatieMecanicNR) {
		this.adaugareReparatieMecanicNR = adaugareReparatieMecanicNR;
	}

	public JTextField getAdaugareReparatieProblemeAparuteNR() {
		return adaugareReparatieProblemeAparuteNR;
	}

	public void setAdaugareReparatieProblemeAparuteNR(JTextField adaugareReparatieProblemeAparuteNR) {
		this.adaugareReparatieProblemeAparuteNR = adaugareReparatieProblemeAparuteNR;
	}

	public JComboBox getSelectareZiAdaugareCursa() {
		return selectareZiAdaugareCursa;
	}

	public void setSelectareZiAdaugareCursa(JComboBox selectareZiAdaugareCursa) {
		this.selectareZiAdaugareCursa = selectareZiAdaugareCursa;
	}

	public JComboBox getSelectareLunaAdaugareCursa() {
		return selectareLunaAdaugareCursa;
	}

	public void setSelectareLunaAdaugareCursa(JComboBox selectareLunaAdaugareCursa) {
		this.selectareLunaAdaugareCursa = selectareLunaAdaugareCursa;
	}

	public JComboBox getSelectareAnAdaugareCursa() {
		return selectareAnAdaugareCursa;
	}

	public void setSelectareAnAdaugareCursa(JComboBox selectareAnAdaugareCursa) {
		this.selectareAnAdaugareCursa = selectareAnAdaugareCursa;
	}

	public JLabel getCostFunctionareTXT() {
		return costFunctionareTXT;
	}

	public void setCostFunctionareTXT(JLabel costFunctionareTXT) {
		this.costFunctionareTXT = costFunctionareTXT;
	}

	public JLabel getCostFunctionareNR() {
		return costFunctionareNR;
	}

	public void setCostFunctionareNR(JLabel costFunctionareNR) {
		this.costFunctionareNR = costFunctionareNR;
	}

	public JLabel getAdaugareCursaPretPerLitruTXT() {
		return adaugareCursaPretPerLitruTXT;
	}

	public void setAdaugareCursaPretPerLitruTXT(JLabel adaugareCursaPretPerLitruTXT) {
		this.adaugareCursaPretPerLitruTXT = adaugareCursaPretPerLitruTXT;
	}

	public JTextField getAdaugareCursaPretPerLitruNR() {
		return adaugareCursaPretPerLitruNR;
	}

	public void setAdaugareCursaPretPerLitruNR(JTextField adaugareCursaPretPerLitruNR) {
		this.adaugareCursaPretPerLitruNR = adaugareCursaPretPerLitruNR;
	}
	
	public JLabel getAdaugareRevizieCostTXT() {
		return adaugareRevizieCostTXT;
	}

	public void setAdaugareRevizieCostTXT(JLabel adaugareRevizieCostTXT) {
		this.adaugareRevizieCostTXT = adaugareRevizieCostTXT;
	}
	
	public JLabel getAdaugareRevizieProblemeAparuteTXT() {
		return adaugareRevizieProblemeAparuteTXT;
	}

	public void setAdaugareRevizieProblemeAparuteTXT(JLabel adaugareRevizieProblemeAparuteTXT) {
		this.adaugareRevizieProblemeAparuteTXT = adaugareRevizieProblemeAparuteTXT;
	}

	public JTextField getAdaugareRevizieCostNR() {
		return adaugareRevizieCostNR;
	}

	public void setAdaugareRevizieCostNR(JTextField adaugareRevizieCostNR) {
		this.adaugareRevizieCostNR = adaugareRevizieCostNR;
	}

	public JTextField getAdaugareRevizieProblemeAparuteNR() {
		return adaugareRevizieProblemeAparuteNR;
	}

	public void setAdaugareRevizieProblemeAparuteNR(JTextField adaugareRevizieProblemeAparuteNR) {
		this.adaugareRevizieProblemeAparuteNR = adaugareRevizieProblemeAparuteNR;
	}

	public JButton getAdaugareAutorizatie() {
		return adaugareAutorizatie;
	}

	public void setAdaugareAutorizatie(JButton adaugareAutorizatie) {
		this.adaugareAutorizatie = adaugareAutorizatie;
	}
	
	public JButton getVeziIstoricAutorizatii() {
		return veziIstoricAutorizatii;
	}

	public void setVeziIstoricAutorizatii(JButton veziIstoricAutorizatii) {
		this.veziIstoricAutorizatii = veziIstoricAutorizatii;
	}

	public void fillBazine(Bazin bazin, ArrayList<DetaliiCantitatiPeste> detaliiCantitatiPeste, ArrayList<DetaliiCantitatiFuraje> detaliiCantitatiFuraje) {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		cantitatePesteNR.setText(Double.toString(bazin.getCantitatePeste()));
		cantitateFurajeNR.setText(Double.toString(bazin.getCantitateFuraj()));
		medieOxigenNR.setText(Double.toString(bazin.getMedieOxigen())); 
		mediePhNR.setText(Double.toString(bazin.getMediePh())); 
		cantitateBalegarNR.setText(Double.toString(bazin.getCantitateBalegar()));  
		medieTemperaturaNR.setText(Double.toString(bazin.getMedieTemperatura()));  
		medieNivelApaNR.setText(Double.toString(bazin.getMedieNivelApa())); 
		cantitateFitoplanctonNR.setText(Double.toString(bazin.getCantitateFitoplancton()));  
		dezinfectieNR.setText(df.format(bazin.getUltimaDezinfectare()));  
		umplereNR.setText(df.format(bazin.getUltimaUmplere()));  
		golireNR.setText(df.format(bazin.getUltimaGolire()));  
		pescuitDeProbaNR.setText(Double.toString(bazin.getGreutateMedie())+"    "+df.format(bazin.getDataPescuitProba())); 
		int i=1;
		String[] numePesteLista= new String[20];
		String[] cantitatePesteIntrodusa= new String[20];
		String[] cantitatePesteScoasa= new String[20];
		String[] cantitatePesteSiguraMinima= new String[20];
		for (DetaliiCantitatiPeste detaliiCantitatiPeste2 : detaliiCantitatiPeste) {
			numePesteLista[i]=detaliiCantitatiPeste2.getNumeTipPeste();
			cantitatePesteIntrodusa[i]=Double.toString(detaliiCantitatiPeste2.getCantitateIntrodusa());
			cantitatePesteScoasa[i]=Double.toString(detaliiCantitatiPeste2.getCantitateScoasa());
			cantitatePesteSiguraMinima[i]=Double.toString(detaliiCantitatiPeste2.getCantitateRamasa());
			i++;
		}
		
		this.nrTipuriPesti=i-1;
		this.setTipPeste(numePesteLista);
		this.setCantitatePesteIntrodusa(cantitatePesteIntrodusa);
		this.setCantitatePesteScoasa(cantitatePesteScoasa);
		this.setCantitatePesteSiguraMinima(cantitatePesteSiguraMinima);
		i=1;
		String[] tipFuraj= new String[20];
		String[] cantitateFurajIntrodus= new String[20];
		for (DetaliiCantitatiFuraje detaliiCantitatiFuraje2 : detaliiCantitatiFuraje) {
			
			tipFuraj[i]=detaliiCantitatiFuraje2.getNumeFuraj();
			cantitateFurajIntrodus[i]=Double.toString(detaliiCantitatiFuraje2.getCantitateIntrodusa());
			i++;
		}
		this.nrTipuriFuraje=i;
		this.setTipFuraj(tipFuraj);
		this.setCantitateFurajIntrodusa(cantitateFurajIntrodus);
		
		this.crearePanouPesteCantitati();
		this.crearePanouFurajeCantitati();

		
	}

	public void fillMasina(Masini masina, MasiniRevizii masiniRevizii) {
		
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		distantaParcursaNR.setText(Double.toString(masina.getKmParcursi()));
		consumRealizatNR.setText(Double.toString(masina.getConsum()));
		costFunctionareNR.setText(Double.toString(masina.getCost()));
		dataRevizieNR.setText(df.format(masiniRevizii.getDataRevizia()));  
		dataExpirareRevizieNR.setText(df.format(masiniRevizii.getExpirareRevizie()));  
		
	}

}