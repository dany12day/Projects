package Model;

import java.sql.Date;

public class IstoricPeste {
	private int idIstoricPeste;
	private int idBazin;
	private int idTipPeste;
	private String tipPeste;
	private float cantitateOperatiune;
	private Date dataOperatiune;
	private String tipOperatiune;
	private int actualitate;
	public IstoricPeste(int idIstoricPeste, int idBazin, int idTipPeste, float cantitateOperatiune, Date dataOperatiune,
			String tipOperatiune, int actualitate) {
		super();
		this.idIstoricPeste = idIstoricPeste;
		this.idBazin = idBazin;
		this.idTipPeste = idTipPeste;
		this.cantitateOperatiune = cantitateOperatiune;
		this.dataOperatiune = dataOperatiune;
		this.tipOperatiune = tipOperatiune;
		this.actualitate = actualitate;
	}
	
	public IstoricPeste(String tipPeste, float cantitateOperatiune, Date dataOperatiune, String tipOperatiune) {
		super();
		this.tipPeste = tipPeste;
		this.cantitateOperatiune = cantitateOperatiune;
		this.dataOperatiune = dataOperatiune;
		this.tipOperatiune = tipOperatiune;
	}

	public int getIdIstoricPeste() {
		return idIstoricPeste;
	}
	public void setIdIstoricPeste(int idIstoricPeste) {
		this.idIstoricPeste = idIstoricPeste;
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
	public String getTipOperatiune() {
		return tipOperatiune;
	}
	public void setTipOperatiune(String tipOperatiune) {
		this.tipOperatiune = tipOperatiune;
	}
	public int getActualitate() {
		return actualitate;
	}
	public void setActualitate(int actualitate) {
		this.actualitate = actualitate;
	}

	@Override
	public String toString() {
		return "IstoricPeste [tipPeste=" + tipPeste + ", cantitateOperatiune=" + cantitateOperatiune
				+ ", dataOperatiune=" + dataOperatiune + ", tipOperatiune=" + tipOperatiune + "]";
	}

	public String getTipPeste() {
		return tipPeste;
	}

	public void setTipPeste(String tipPeste) {
		this.tipPeste = tipPeste;
	}
	
	
}
