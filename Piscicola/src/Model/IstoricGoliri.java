package Model;

import java.sql.Date;

public class IstoricGoliri {
	private int idIstoricGoliri;
	private int idBazin;
	private Date dataGolire;
	private int actualitate;
	public IstoricGoliri(int idIstoricGoliri, int idBazin, Date dataGolire, int actualitate) {
		super();
		this.idIstoricGoliri = idIstoricGoliri;
		this.idBazin = idBazin;
		this.dataGolire = dataGolire;
		this.actualitate = actualitate;
	}
	public int getIdIstoricGoliri() {
		return idIstoricGoliri;
	}
	public void setIdIstoricGoliri(int idIstoricGoliri) {
		this.idIstoricGoliri = idIstoricGoliri;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public Date getDataGolire() {
		return dataGolire;
	}
	public void setDataGolire(Date dataGolire) {
		this.dataGolire = dataGolire;
	}
	public int getActualitate() {
		return actualitate;
	}
	public void setActualitate(int actualitate) {
		this.actualitate = actualitate;
	}
	
}
