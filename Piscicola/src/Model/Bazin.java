package Model;

import java.sql.Date;

import Interfata.View;

public class Bazin {
	private int idBazin;
	private float cantitatePeste;
	private float cantitateFuraj;
	private float medieOxigen;
	private float mediePh;
	private float medieTemperatura;
	private float cantitateBalegar;
	private float medieNivelApa;
	private float cantitateFitoplancton;
	private Date ultimaDezinfectare;
	private Date ultimaUmplere;
	private Date ultimaGolire;
	private Date dataPescuitProba;
	private float greutateMedie;
	public Bazin(int idBazin, float cantitatePeste, float cantitateFuraj, float medieOxigen, float mediePh,
			float medieTemperatura, float cantitateBalegar, float medieNivelApa, float cantitateFitoplancton,
			Date ultimaDezinfectare, Date ultimaUmplere, Date ultimaGolire, Date dataPescuitProba,
			float greutateMedie) {
		super();
		this.idBazin = idBazin;
		this.cantitatePeste = cantitatePeste;
		this.cantitateFuraj = cantitateFuraj;
		this.medieOxigen = medieOxigen;
		this.mediePh = mediePh;
		this.medieTemperatura = medieTemperatura;
		this.cantitateBalegar = cantitateBalegar;
		this.medieNivelApa = medieNivelApa;
		this.cantitateFitoplancton = cantitateFitoplancton;
		this.ultimaDezinfectare = ultimaDezinfectare;
		this.ultimaUmplere = ultimaUmplere;
		this.ultimaGolire = ultimaGolire;
		this.dataPescuitProba = dataPescuitProba;
		this.greutateMedie = greutateMedie;
	}
	
	public Bazin() {
		// TODO Auto-generated constructor stub
	}

	public int getIdBazin() {
		return idBazin;
	}
	public void setIdBazin(int idBazin) {
		this.idBazin = idBazin;
	}
	public float getCantitatePeste() {
		return cantitatePeste;
	}
	public void setCantitatePeste(float cantitatePeste) {
		this.cantitatePeste = cantitatePeste;
	}
	public float getCantitateFuraj() {
		return cantitateFuraj;
	}
	public void setCantitateFuraj(float cantitateFuraj) {
		this.cantitateFuraj = cantitateFuraj;
	}
	public float getMedieOxigen() {
		return medieOxigen;
	}
	public void setMedieOxigen(float medieOxigen) {
		this.medieOxigen = medieOxigen;
	}
	public float getMediePh() {
		return mediePh;
	}
	public void setMediePh(float mediePh) {
		this.mediePh = mediePh;
	}
	public float getMedieTemperatura() {
		return medieTemperatura;
	}
	public void setMedieTemperatura(float medieTemperatura) {
		this.medieTemperatura = medieTemperatura;
	}
	public float getCantitateBalegar() {
		return cantitateBalegar;
	}
	public void setCantitateBalegar(float cantitateBalegar) {
		this.cantitateBalegar = cantitateBalegar;
	}
	public float getMedieNivelApa() {
		return medieNivelApa;
	}
	public void setMedieNivelApa(float medieNivelApa) {
		this.medieNivelApa = medieNivelApa;
	}
	public float getCantitateFitoplancton() {
		return cantitateFitoplancton;
	}
	public void setCantitateFitoplancton(float cantitateFitoplancton) {
		this.cantitateFitoplancton = cantitateFitoplancton;
	}
	public Date getUltimaDezinfectare() {
		return ultimaDezinfectare;
	}
	public void setUltimaDezinfectare(Date ultimaDezinfectare) {
		this.ultimaDezinfectare = ultimaDezinfectare;
	}
	public Date getUltimaUmplere() {
		return ultimaUmplere;
	}
	public void setUltimaUmplere(Date ultimaUmplere) {
		this.ultimaUmplere = ultimaUmplere;
	}
	public Date getUltimaGolire() {
		return ultimaGolire;
	}
	public void setUltimaGolire(Date ultimaGolire) {
		this.ultimaGolire = ultimaGolire;
	}
	public Date getDataPescuitProba() {
		return dataPescuitProba;
	}
	public void setDataPescuitProba(Date dataPescuitProba) {
		this.dataPescuitProba = dataPescuitProba;
	}
	public float getGreutateMedie() {
		return greutateMedie;
	}
	public void setGreutateMedie(float greutateMedie) {
		this.greutateMedie = greutateMedie;
	}
	@Override
	public String toString() {
		return "Bazin [idBazin=" + idBazin + ", cantitatePeste=" + cantitatePeste + ", cantitateFuraj=" + cantitateFuraj
				+ ", medieOxigen=" + medieOxigen + ", mediePh=" + mediePh + ", medieTemperatura=" + medieTemperatura
				+ ", cantitateBalegar=" + cantitateBalegar + ", medieNivelApa=" + medieNivelApa
				+ ", cantitateFitoplancton=" + cantitateFitoplancton + ", ultimaDezinfectare=" + ultimaDezinfectare
				+ ", ultimaUmplere=" + ultimaUmplere + ", ultimaGolire=" + ultimaGolire + ", dataPescuitProba="
				+ dataPescuitProba + ", greutateMedie=" + greutateMedie + "]";
	}
	
	
}
