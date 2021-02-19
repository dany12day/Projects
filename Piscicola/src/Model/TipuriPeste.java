package Model;

public class TipuriPeste{
	private int idTipPeste;
	private String tipPeste;
	private boolean disponibilitateTipPeste;
	
	public TipuriPeste(int idTipPeste, String tipPeste, boolean disponibilitateTipPeste) {
		super();
		this.idTipPeste = idTipPeste;
		this.tipPeste = tipPeste;
		this.disponibilitateTipPeste = disponibilitateTipPeste;
	}
	public int getIdTipPeste() {
		return idTipPeste;
	}
	public void setIdTipPeste(int idTipPeste) {
		this.idTipPeste = idTipPeste;
	}
	
	public String getTipPeste() {
		return tipPeste;
	}
	public void setTipPeste(String tipPeste) {
		this.tipPeste = tipPeste;
	}
	public boolean isDisponibilitateTipPeste() {
		return disponibilitateTipPeste;
	}
	public void setDisponibilitateTipPeste(boolean disponibilitateTipPeste) {
		this.disponibilitateTipPeste = disponibilitateTipPeste;
	}
	
	
}
