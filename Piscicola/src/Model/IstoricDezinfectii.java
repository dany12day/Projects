package Model;

import java.sql.Date;

public class IstoricDezinfectii {
	private int idIstoricDezinfectii;
	private int idBazin;
	private Date dataDezinfectare;
	private int actualitate;
	public IstoricDezinfectii(int idIstoricDezinfectii, int idBazin, Date dataDezinfectare, int actualitate) {
		super();
		this.idIstoricDezinfectii = idIstoricDezinfectii;
		this.idBazin = idBazin;
		this.dataDezinfectare = dataDezinfectare;
		this.actualitate = actualitate;
	}
	public int getIdIstoricDezinfectii() {
		return idIstoricDezinfectii;
	}
	public void setIdIstoricDezinfectii(int idIstoricDezinfectii) {
		this.idIstoricDezinfectii = idIstoricDezinfectii;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public Date getDataDezinfectare() {
		return dataDezinfectare;
	}
	public void setDataDezinfectare(Date dataDezinfectare) {
		this.dataDezinfectare = dataDezinfectare;
	}
	public int getActualitate() {
		return actualitate;
	}
	public void setActualitate(int actualitate) {
		this.actualitate = actualitate;
	}
	
	
}
