package Model;

public class Bazine {
	private int idBazin;
	private String numeBazin;
	public Bazine(int idBazin, String numeBazin) {
		super();
		this.idBazin = idBazin;
		this.numeBazin = numeBazin;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public String getNumeBazin() {
		return numeBazin;
	}
	public void setNumeBazin(String numeBazin) {
		this.numeBazin = numeBazin;
	}
	@Override
	public String toString() {
		return "Bazine [idBazin=" + idBazin + ", numeBazin=" + numeBazin + "]";
	}
	
	
}
