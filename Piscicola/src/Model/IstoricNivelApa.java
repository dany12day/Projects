package Model;

import java.sql.Date;

public class IstoricNivelApa {
	private int idIstoricNivelApa;
	private int idBazin;
	private float nivelApa;
	private Date dataOperatiune;
	private int actualitate;
	public IstoricNivelApa(int idIstoricNivelApa, int idBazin, float nivelApa, Date dataOperatiune, int actualitate) {
		super();
		this.idIstoricNivelApa = idIstoricNivelApa;
		this.idBazin = idBazin;
		this.nivelApa = nivelApa;
		this.dataOperatiune = dataOperatiune;
		this.actualitate = actualitate;
	}
	
	public IstoricNivelApa(float nivelApa, Date dataOperatiune) {
		super();
		this.nivelApa = nivelApa;
		this.dataOperatiune = dataOperatiune;
	}
	public int getIdIstoricNivelApa() {
		return idIstoricNivelApa;
	}
	public void setIdIstoricNivelApa(int idIstoricNivelApa) {
		this.idIstoricNivelApa = idIstoricNivelApa;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public float getNivelApa() {
		return nivelApa;
	}
	public void setNivelApa(float nivelApa) {
		this.nivelApa = nivelApa;
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
		return "IstoricNivelApa [nivelApa=" + nivelApa + ", dataOperatiune=" + dataOperatiune + "]";
	}
	
	
}
