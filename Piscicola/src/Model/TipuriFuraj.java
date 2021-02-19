package Model;

public class TipuriFuraj {
	private int idTipFuraj;
	private String tipFuraj;
	private boolean disponibilitateTipFuraj;
	
	public TipuriFuraj(int idTipFuraj, String tipFuraj, boolean disponibilitateTipFuraj) {
		super();
		this.idTipFuraj = idTipFuraj;
		this.tipFuraj = tipFuraj;
		this.disponibilitateTipFuraj = disponibilitateTipFuraj;
	}
	public int getIdTipFuraj() {
		return idTipFuraj;
	}
	public void setIdTipFuraj(int idTipFuraj) {
		this.idTipFuraj = idTipFuraj;
	}
	public String getTipFuraj() {
		return tipFuraj;
	}
	public void setTipFuraj(String tipFuraj) {
		this.tipFuraj = tipFuraj;
	}
	public boolean isDisponibilitateTipFuraj() {
		return disponibilitateTipFuraj;
	}
	public void setDisponibilitateTipFuraj(boolean disponibilitateTipFuraj) {
		this.disponibilitateTipFuraj = disponibilitateTipFuraj;
	}
	
	
}
