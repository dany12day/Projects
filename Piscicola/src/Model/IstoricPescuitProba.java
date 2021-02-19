package Model;

import java.sql.Date;

public class IstoricPescuitProba {
	private int idIstoricPescuitProba;
	private int idBazin;
	private float greutateMedie;
	private Date dataPescuitProba;
	private int actualitate;
	public IstoricPescuitProba(int idIstoricPescuitProba, int idBazin, float greutateMedie, Date dataPescuitProba,
			int actualitate) {
		super();
		this.idIstoricPescuitProba = idIstoricPescuitProba;
		this.idBazin = idBazin;
		this.greutateMedie = greutateMedie;
		this.dataPescuitProba = dataPescuitProba;
		this.actualitate = actualitate;
	}
	
	public IstoricPescuitProba(float greutateMedie, Date dataPescuitProba) {
		super();
		this.greutateMedie = greutateMedie;
		this.dataPescuitProba = dataPescuitProba;
	}

	public int getIdIstoricPescuitProba() {
		return idIstoricPescuitProba;
	}
	public void setIdIstoricPescuitProba(int idIstoricPescuitProba) {
		this.idIstoricPescuitProba = idIstoricPescuitProba;
	}
	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public float getGreutateMedie() {
		return greutateMedie;
	}
	public void setGreutateMedie(float greutateMedie) {
		this.greutateMedie = greutateMedie;
	}
	public Date getDataPescuitProba() {
		return dataPescuitProba;
	}
	public void setDataPescuitProba(Date dataPescuitProba) {
		this.dataPescuitProba = dataPescuitProba;
	}
	public int getActualitate() {
		return actualitate;
	}
	public void setActualitate(int actualitate) {
		this.actualitate = actualitate;
	}

	@Override
	public String toString() {
		return "IstoricPescuitProba [greutateMedie=" + greutateMedie + ", dataPescuitProba=" + dataPescuitProba + "]";
	}
	
}
