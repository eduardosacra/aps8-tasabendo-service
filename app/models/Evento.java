package models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evento {
	private static int countId = 1;//Temporario
	
	@Id
	private int id;
	@Column
	private String categoria;
	@Column
	private double longitude;
	@Column
	private double latitude;
	
	private Date create_at;
	
	public Evento() {
		setCreate_at();
	}
	//private String foto;//Nao sera implementado nessa versao
	
	
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at() {
		this.create_at = null;//setado quando instanciado
	}
	public void setCreate_at(LocalDate date) {
		this.create_at = null;//setado quando instanciado
	}
	public int getId() {
		return id;
	}
	public void setId() {
		
		this.id = countId;//Temporario para simular o id sendo criado pelo banco
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
//	public String getFoto() {
//		return foto;
//	}
//	public void setFoto(String foto) {
//		this.foto = foto;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
