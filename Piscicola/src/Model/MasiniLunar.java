package Model;

import java.sql.Date;

public class MasiniLunar {
	private int idMasiniLunar;
	private int idMasina;
	
	private float kmParcursi;
	private float consum;
	private Date luna;
	private float cost;
	
	public MasiniLunar(int idMasiniLunar, int idMasina, float kmParcursi, float consum, Date luna) {
		super();
		this.idMasiniLunar = idMasiniLunar;
		this.idMasina = idMasina;
		this.kmParcursi = kmParcursi;
		this.consum = consum;
		this.luna = luna;
	}
	
	
	
	public MasiniLunar(float kmParcursi, float consum, Date luna, float cost) {
		super();
		this.kmParcursi = kmParcursi;
		this.consum = consum;
		this.luna = luna;
		this.cost = cost;
	}



	public int getIdMasiniLunar() {
		return idMasiniLunar;
	}
	public void setIdMasiniLunar(int idMasiniLunar) {
		this.idMasiniLunar = idMasiniLunar;
	}
	public int getIdMasina() {
		return idMasina;
	}
	public void setIdMasina(int idMasina) {
		this.idMasina = idMasina;
	}
	public float getKmParcursi() {
		return kmParcursi;
	}
	public void setKmParcursi(float kmParcursi) {
		this.kmParcursi = kmParcursi;
	}
	public float getConsum() {
		return consum;
	}
	public void setConsum(float consum) {
		this.consum = consum;
	}
	public Date getLuna() {
		return luna;
	}
	public void setLuna(Date luna) {
		this.luna = luna;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	
}
