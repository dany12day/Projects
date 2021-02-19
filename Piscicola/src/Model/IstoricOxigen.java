package Model;

import java.sql.Date;

public class IstoricOxigen {
	private int idIstoricOxigen;
	private int idBazin;
	private float procentOxigen;
	private Date dataOperatiune;
	private int actualitate;
	
	public IstoricOxigen(int idIstoricOxigen, int idBazin, float procentOxigen, Date dataOperatiune, int actualitate) {
		super();
		this.idIstoricOxigen = idIstoricOxigen;
		this.idBazin = idBazin;
		this.procentOxigen = procentOxigen;
		this.dataOperatiune = dataOperatiune;
		this.actualitate = actualitate;
	}
	
	
	
	public IstoricOxigen(float procentOxigen, Date dataOperatiune) {
		super();
		this.procentOxigen = procentOxigen;
		this.dataOperatiune = dataOperatiune;
	}



	public int getIdIstoricOxigen() {
		return idIstoricOxigen;
	}
	public void setIdIstoricOxigen(int idIstoricOxigen) {
		this.idIstoricOxigen = idIstoricOxigen;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public float getProcentOxigen() {
		return procentOxigen;
	}
	public void setProcentOxigen(float procentOxigen) {
		this.procentOxigen = procentOxigen;
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
		return "IstoricOxigen [procentOxigen=" + procentOxigen + ", dataOperatiune=" + dataOperatiune + "]";
	}
	
	
}
