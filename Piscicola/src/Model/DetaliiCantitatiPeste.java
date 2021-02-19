package Model;

public class DetaliiCantitatiPeste {
	private int idDetaliiCantitatiPeste;
	private int idBazin;
	private int idTipPeste;
	private String NumeTipPeste;
	private float cantitateIntrodusa;
	private float cantitateScoasa;
	private float cantitateRamasa;
	public DetaliiCantitatiPeste(String NumeTipPeste, float cantitateIntrodusa,
		     					 float cantitateScoasa, float cantitateRamasa) {
		super();
		this.NumeTipPeste = NumeTipPeste;
		this.cantitateIntrodusa = cantitateIntrodusa;
		this.cantitateScoasa = cantitateScoasa;
		this.cantitateRamasa = cantitateRamasa;
	}
	
	public DetaliiCantitatiPeste(int idDetaliiCantitatiPeste, int idBazin, int idTipPeste, float cantitateIntrodusa,
			 float cantitateScoasa, float cantitateRamasa) {
		super();
		this.idDetaliiCantitatiPeste = idDetaliiCantitatiPeste;
		this.idBazin = idBazin;
		this.idTipPeste = idTipPeste;
		this.cantitateIntrodusa = cantitateIntrodusa;
		this.cantitateScoasa = cantitateScoasa;
		this.cantitateRamasa = cantitateRamasa;
	}

	public int getIdDetaliiCantitatiPeste() {
		return idDetaliiCantitatiPeste;
	}
	public void setIdDetaliiCantitatiPeste(int idDetaliiCantitatiPeste) {
		this.idDetaliiCantitatiPeste = idDetaliiCantitatiPeste;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public int getIdTipPeste() {
		return idTipPeste;
	}
	public void setIdTipPeste(int idTipPeste) {
		this.idTipPeste = idTipPeste;
	}
	public float getCantitateIntrodusa() {
		return cantitateIntrodusa;
	}
	public void setCantitateIntrodusa(float cantitateIntrodusa) {
		this.cantitateIntrodusa = cantitateIntrodusa;
	}
	public float getCantitateScoasa() {
		return cantitateScoasa;
	}
	public void setCantitateScoasa(float cantitateScoasa) {
		this.cantitateScoasa = cantitateScoasa;
	}
	public float getCantitateRamasa() {
		return cantitateRamasa;
	}
	public void setCantitateRamasa(float cantitateRamasa) {
		this.cantitateRamasa = cantitateRamasa;
	}

	public String getNumeTipPeste() {
		return NumeTipPeste;
	}

	public void setNumeTipPeste(String numeTipPeste) {
		NumeTipPeste = numeTipPeste;
	}

	@Override
	public String toString() {
		return "DetaliiCantitatiPeste [NumeTipPeste=" + NumeTipPeste + ", cantitateIntrodusa=" + cantitateIntrodusa
				+ ", cantitateScoasa=" + cantitateScoasa + ", cantitateRamasa=" + cantitateRamasa + "]";
	}
	 
	 
}
