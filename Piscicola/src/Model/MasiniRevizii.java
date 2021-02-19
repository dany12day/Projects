package Model;

import java.sql.Date;

public class MasiniRevizii {
	private int idMasiniRevizii;
	private int idMasina;
	private Date dataRevizia;
	private Date expirareRevizie;
	private float cost;
	private String pieseSchimbate;
	
	public MasiniRevizii(int idMasiniRevizii, int idMasina, Date dataRevizia, Date expirareRevizie) {
		super();
		this.idMasiniRevizii = idMasiniRevizii;
		this.idMasina = idMasina;
		this.dataRevizia = dataRevizia;
		this.expirareRevizie = expirareRevizie;
	}
	
	public MasiniRevizii(Date dataRevizia, Date expirareRevizie, float cost, String pieseSchimbate) {
		super();
		this.dataRevizia = dataRevizia;
		this.expirareRevizie = expirareRevizie;
		this.cost = cost;
		this.pieseSchimbate = pieseSchimbate;
	}

	public MasiniRevizii() {
		// TODO Auto-generated constructor stub
	}
	public int getIdMasiniRevizii() {
		return idMasiniRevizii;
	}
	public void setIdMasiniRevizii(int idMasiniRevizii) {
		this.idMasiniRevizii = idMasiniRevizii;
	}
	public int getIdMasina() {
		return idMasina;
	}
	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}
	public Date getDataRevizia() {
		return dataRevizia;
	}
	public void setDataRevizia(Date dataRevizia) {
		this.dataRevizia = dataRevizia;
	}
	public Date getExpirareRevizie() {
		return expirareRevizie;
	}
	public void setExpirareRevizie(Date expirareRevizie) {
		this.expirareRevizie = expirareRevizie;
	}
	
	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getPieseSchimbate() {
		return pieseSchimbate;
	}

	public void setPieseSchimbate(String pieseSchimbate) {
		this.pieseSchimbate = pieseSchimbate;
	}

	@Override
	public String toString() {
		return "MasiniRevizii [dataRevizia=" + dataRevizia + ", expirareRevizie=" + expirareRevizie + "]";
	}
	
}
