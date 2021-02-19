package Model;

import java.sql.Date;

public class IstoricPh {
	private int idIstoricPh;
	private int idBazin;
	private float procentPh;
	private Date dataOperatiune;
	private int actualitate;
	
	public IstoricPh(int idIstoricPh, int idBazin, float procentPh, Date dataOperatiune, int actualitate) {
		super();
		this.idIstoricPh = idIstoricPh;
		this.idBazin = idBazin;
		this.procentPh = procentPh;
		this.dataOperatiune = dataOperatiune;
		this.actualitate = actualitate;
	}

	
	
	public IstoricPh(float procentPh, Date dataOperatiune) {
		super();
		this.procentPh = procentPh;
		this.dataOperatiune = dataOperatiune;
	}



	public int getIdIstoricPh() {
		return idIstoricPh;
	}

	public void setIdIstoricPh(int idIstoricPh) {
		this.idIstoricPh = idIstoricPh;
	}

	public int getIdBazin() {
		return idBazin;
	}

	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}

	public float getProcentPh() {
		return procentPh;
	}

	public void setProcentPh(float procentPh) {
		this.procentPh = procentPh;
	}

	public Date getDataOperatiune() {
		return dataOperatiune;
	}

	public void setDataOperatiune(Date dataOperatiune) {
		this.dataOperatiune = dataOperatiune;
	}

	public int getActualitate() {
		return actualitate;
	}

	public void setActualitate(int actualitate) {
		this.actualitate = actualitate;
	}



	@Override
	public String toString() {
		return "IstoricPh [procentPh=" + procentPh + ", dataOperatiune=" + dataOperatiune + "]";
	}
	
	
}
