package Model;

public class DetaliiCantitatiFuraje {
	private int idDetaliiCantitatiFuraje;
	private int idBazin;
	private int idTipFuraj;
	private String numeFuraj;
	private float cantitateIntrodusa;
	
	public DetaliiCantitatiFuraje(int idDetaliiCantitatiFuraje, int idBazin, int idTipFuraj, float cantitateIntrodusa) {
		super();
		this.idDetaliiCantitatiFuraje = idDetaliiCantitatiFuraje;
		this.idBazin = idBazin;
		this.idTipFuraj = idTipFuraj;
		this.cantitateIntrodusa = cantitateIntrodusa;
	}
	public DetaliiCantitatiFuraje(String numeFuraj, float cantitateIntrodusa) {
		super();
		this.numeFuraj = numeFuraj;
		this.cantitateIntrodusa = cantitateIntrodusa;
	}
	public DetaliiCantitatiFuraje() {
		// TODO Auto-generated constructor stub
	}
	public int getIdDetaliiCantitatiFuraje() {
		return idDetaliiCantitatiFuraje;
	}
	public void setIdDetaliiCantitatiFuraje(int idDetaliiCantitatiFuraje) {
		this.idDetaliiCantitatiFuraje = idDetaliiCantitatiFuraje;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public int getIdTipFuraj() {
		return idTipFuraj;
	}
	public void setIdTipFuraj(int idTipFuraj) {
		this.idTipFuraj = idTipFuraj;
	}
	public float getCantitateIntrodusa() {
		return cantitateIntrodusa;
	}
	public void setCantitateIntrodusa(float cantitateIntrodusa) {
		this.cantitateIntrodusa = cantitateIntrodusa;
	}
	public String getNumeFuraj() {
		return numeFuraj;
	}
	public void setNumeFuraj(String numeFuraj) {
		this.numeFuraj = numeFuraj;
	}
	@Override
	public String toString() {
		return "DetaliiCantitatiFuraje [numeFuraj=" + numeFuraj + ", cantitateIntrodusa=" + cantitateIntrodusa + "]";
	}
	
	
}
