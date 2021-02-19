package Model;

import java.sql.Date;

public class IstoricUmpleri {
	private int idIstoricUmpleri;
	private int idBazin;
	private Date dataUmplere;
	private int actualitate;
	public IstoricUmpleri(int idIstoricUmpleri, int idBazin, Date dataUmplere, int actualitate) {
		super();
		this.idIstoricUmpleri = idIstoricUmpleri;
		this.idBazin = idBazin;
		this.dataUmplere = dataUmplere;
		this.actualitate = actualitate;
	}
	public int getIdIstoricUmpleri() {
		return idIstoricUmpleri;
	}
	public void setIdIstoricUmpleri(int idIstoricUmpleri) {
		this.idIstoricUmpleri = idIstoricUmpleri;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public Date getDataUmplere() {
		return dataUmplere;
	}
	public void setDataUmplere(Date dataUmplere) {
		this.dataUmplere = dataUmplere;
	}
	public int getActualitate() {
		return actualitate;
	}
	public void setActualitate(int actualitate) {
		this.actualitate = actualitate;
	}
	@Override
	public String toString() {
		return "IstoricUmpleri [dataUmplere=" + dataUmplere + "]";
	}
	
}
