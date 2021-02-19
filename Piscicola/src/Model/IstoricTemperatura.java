package Model;

import java.sql.Date;

public class IstoricTemperatura {
	private int idIstoricTemperatura;
	private int idBazin;
	private float temperatura;
	private Date dataOperatiune;
	private int actualitate;
	public IstoricTemperatura(int idIstoricTemperatura, int idBazin, float temperatura, Date dataOperatiune,
			int actualitate) {
		super();
		this.idIstoricTemperatura = idIstoricTemperatura;
		this.idBazin = idBazin;
		this.temperatura = temperatura;
		this.dataOperatiune = dataOperatiune;
		this.actualitate = actualitate;
	}
	
	public IstoricTemperatura(float temperatura, Date dataOperatiune) {
		super();
		this.temperatura = temperatura;
		this.dataOperatiune = dataOperatiune;
	}

	public int getIdIstoricTemperatura() {
		return idIstoricTemperatura;
	}
	public void setIdIstoricTemperatura(int idIstoricTemperatura) {
		this.idIstoricTemperatura = idIstoricTemperatura;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
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
		return "IstoricTemperatura [temperatura=" + temperatura + ", dataOperatiune=" + dataOperatiune + "]";
	}
	
	
}
