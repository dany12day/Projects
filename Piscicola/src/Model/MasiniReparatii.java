package Model;

import java.sql.Date;

import org.w3c.dom.Text;

public class MasiniReparatii {
	private int idMasiniReparatii;
	private int idMasina;
	private float cost;
	private String mecanic;
	private String problemeAparute;
	private Date dataReparatie;
	public MasiniReparatii(int idMasiniReparatii, int idMasina, float cost, String mecanic, String problemeAparute,
			Date dataReparatie) {
		super();
		this.idMasiniReparatii = idMasiniReparatii;
		this.idMasina = idMasina;
		this.cost = cost;
		this.mecanic = mecanic;
		this.problemeAparute = problemeAparute;
		this.dataReparatie = dataReparatie;
	}
	
	public MasiniReparatii(float cost, String mecanic, String problemeAparute, Date dataReparatie) {
		super();
		this.cost = cost;
		this.mecanic = mecanic;
		this.problemeAparute = problemeAparute;
		this.dataReparatie = dataReparatie;
	}

	public int getIdMasiniReparatii() {
		return idMasiniReparatii;
	}
	public void setIdMasiniReparatii(int idMasiniReparatii) {
		this.idMasiniReparatii = idMasiniReparatii;
	}
	public int getIdMasina() {
		return idMasina;
	}
	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getMecanic() {
		return mecanic;
	}
	public void setMecanic(String mecanic) {
		this.mecanic = mecanic;
	}
	public String getProblemeAparute() {
		return problemeAparute;
	}
	public void setProblemeAparute(String problemeAparute) {
		this.problemeAparute = problemeAparute;
	}
	public Date getDataReparatie() {
		return dataReparatie;
	}
	public void setDataReparatie(Date dataReparatie) {
		this.dataReparatie = dataReparatie;
	}

	@Override
	public String toString() {
		return "MasiniReparatii [cost=" + cost + ", mecanic=" + mecanic + ", problemeAparute=" + problemeAparute
				+ ", dataReparatie=" + dataReparatie + "]";
	}
	
	
}
