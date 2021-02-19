package Model;

import java.sql.Date;

public class IstoricFuraj {
	private int idIstoricFuraj;
	private int idBazin;
	private int idTipFuraj;
	private String tipFuraj;
	private float cantitateOperatiune;
	private Date dataOperatiune;
	public IstoricFuraj(int idIstoricFuraj, int idBazin, int idTipFuraj, float cantitateOperatiune,
			Date dataOperatiune) {
		super();
		this.idIstoricFuraj = idIstoricFuraj;
		this.idBazin = idBazin;
		this.idTipFuraj = idTipFuraj;
		this.cantitateOperatiune = cantitateOperatiune;
		this.dataOperatiune = dataOperatiune;
	}
	
	public IstoricFuraj(String tipFuraj, float cantitateOperatiune, Date dataOperatiune) {
		super();
		this.tipFuraj = tipFuraj;
		this.cantitateOperatiune = cantitateOperatiune;
		this.dataOperatiune = dataOperatiune;
	}
	public int getIdIstoricFuraj() {
		return idIstoricFuraj;
	}
	public void setIdIstoricFuraj(int idIstoricFuraj) {
		this.idIstoricFuraj = idIstoricFuraj;
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
	public float getCantitateOperatiune() {
		return cantitateOperatiune;
	}
	public void setCantitateOperatiune(float cantitateOperatiune) {
		this.cantitateOperatiune = cantitateOperatiune;
	}
	public Date getDataOperatiune() {
		return dataOperatiune;
	}
	public void setDataOperatiune(Date dataOperatiune) {
		this.dataOperatiune = dataOperatiune;
	}

	public String getTipFuraj() {
		return tipFuraj;
	}

	public void setTipFuraj(String tipFuraj) {
		this.tipFuraj = tipFuraj;
	}

	@Override
	public String toString() {
		return "IstoricFuraj [tipFuraj=" + tipFuraj + ", cantitateOperatiune=" + cantitateOperatiune
				+ ", dataOperatiune=" + dataOperatiune + "]";
	}
	
}
