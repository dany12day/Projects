package Model;

import java.sql.Date;

public class MasiniCurse {
	private int idMasiniCurse;
	private int idMasina;
	private String numeMasina;
	private String sofer;
	private float consum;
	private float cost;
	private float kmParcursi;
	private String destinatie;
	private Date dataCursa;
	public MasiniCurse(int idMasiniCurse, int idMasina, String sofer, float consum, float kmParcursi, String destinatie, Date dataCursa) {
		super();
		this.idMasiniCurse = idMasiniCurse;
		this.idMasina = idMasina;
		this.sofer = sofer;
		this.consum = consum;
		this.kmParcursi = kmParcursi;
		this.destinatie=destinatie;
		this.dataCursa = dataCursa;
	}
	
	public MasiniCurse(String numeMasina, String sofer, float consum, float cost, float kmParcursi, String destinatie, Date dataCursa) {
		super();
		this.numeMasina = numeMasina;
		this.sofer = sofer;
		this.consum = consum;
		this.cost = cost;
		this.kmParcursi = kmParcursi;
		this.destinatie=destinatie;
		this.dataCursa = dataCursa;
	}

	public int getIdMasiniCurse() {
		return idMasiniCurse;
	}
	public void setIdMasiniCurse(int idMasiniCurse) {
		this.idMasiniCurse = idMasiniCurse;
	}
	public int getIdMasina() {
		return idMasina;
	}
	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}
	public String getSofer() {
		return sofer;
	}
	public void setSofer(String sofer) {
		this.sofer = sofer;
	}
	public float getConsum() {
		return consum;
	}
	public void setConsum(float consum) {
		this.consum = consum;
	}
	public float getKmParcursi() {
		return kmParcursi;
	}
	public void setKmParcursi(float kmParcursi) {
		this.kmParcursi = kmParcursi;
	}
	public Date getDataCursa() {
		return dataCursa;
	}
	public void setDataCursa(Date dataCursa) {
		this.dataCursa = dataCursa;
	}

	public String getNumeMasina() {
		return numeMasina;
	}

	public void setNumeMasina(String numeMasina) {
		this.numeMasina = numeMasina;
	}

	public String getDestinatie() {
		return destinatie;
	}

	public void setDestinatie(String destinatie) {
		this.destinatie = destinatie;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
}
