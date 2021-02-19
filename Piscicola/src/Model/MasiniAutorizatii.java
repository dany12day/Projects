package Model;

import java.sql.Date;

public class MasiniAutorizatii {
	private int idMasiniAutorizatii;
	private int idMasina;
	private Date dataAutorizatie;
	private Date dataAutorizatieExpirare;
	private String numeAutorizatie;
	
	public MasiniAutorizatii(int idMasiniAutorizatii, int idMasina, Date dataAutorizatie, Date dataAutorizatieExpirare,
			String numeAutorizatie) {
		super();
		this.idMasiniAutorizatii = idMasiniAutorizatii;
		this.idMasina = idMasina;
		this.dataAutorizatie = dataAutorizatie;
		this.dataAutorizatieExpirare = dataAutorizatieExpirare;
		this.numeAutorizatie = numeAutorizatie;
	}
	
	public MasiniAutorizatii(Date dataAutorizatie, Date dataAutorizatieExpirare, String numeAutorizatie) {
		super();
		this.dataAutorizatie = dataAutorizatie;
		this.dataAutorizatieExpirare = dataAutorizatieExpirare;
		this.numeAutorizatie = numeAutorizatie;
	}

	public int getIdMasiniAutorizatii() {
		return idMasiniAutorizatii;
	}
	public void setIdMasiniAutorizatii(int idMasiniAutorizatii) {
		this.idMasiniAutorizatii = idMasiniAutorizatii;
	}
	public int getIdMasina() {
		return idMasina;
	}
	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}
	public Date getDataAutorizatie() {
		return dataAutorizatie;
	}
	public void setDataAutorizatie(Date dataAutorizatie) {
		this.dataAutorizatie = dataAutorizatie;
	}
	public Date getDataAutorizatieExpirare() {
		return dataAutorizatieExpirare;
	}
	public void setDataAutorizatieExpirare(Date dataAutorizatieExpirare) {
		this.dataAutorizatieExpirare = dataAutorizatieExpirare;
	}
	public String getNumeAutorizatie() {
		return numeAutorizatie;
	}
	public void setNumeAutorizatie(String numeAutorizatie) {
		this.numeAutorizatie = numeAutorizatie;
	}
	
	
}
