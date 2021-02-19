package Model;

public class Masini {
	private int idMasina;
	private String numeMasini;
	private float kmParcursi;
	private float consum;
	private float cost;
	public Masini(int idMasina, String numeMasini, float kmParcursi, float consum, float cost) {
		super();
		this.idMasina = idMasina;
		this.numeMasini = numeMasini;
		this.kmParcursi = kmParcursi;
		this.consum = consum;
		this.cost = cost;
	}
	public Masini() {
		// TODO Auto-generated constructor stub
	}
	public int getIdMasina() {
		return idMasina;
	}
	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}
	public String getNumeMasini() {
		return numeMasini;
	}
	public void setNumeMasini(String numeMasini) {
		this.numeMasini = numeMasini;
	}
	public float getKmParcursi() {
		return kmParcursi;
	}
	public void setKmParcursi(float kmParcursi) {
		this.kmParcursi = kmParcursi;
	}
	public float getConsum() {
		return consum;
	}
	public void setConsum(float consum) {
		this.consum = consum;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
