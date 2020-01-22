package dev.hotel.entite;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chambre extends BaseEntite {

	private String numero;
	private Float surfaceEnM2;
	@ManyToOne
	@JoinColumn(name = "hotel_uid")
	private Hotel hotel;

	public Chambre() {
	}

	public Chambre(String uuid) {
		this.setUuid(UUID.fromString(uuid));
	}

	public Chambre(String numero, Float surfaceEnM2, Hotel hotel) {

		this.numero = numero;
		this.surfaceEnM2 = surfaceEnM2;
		this.hotel = hotel;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Float getSurfaceEnM2() {
		return surfaceEnM2;
	}

	public void setSurfaceEnM2(Float surfaceEnM2) {
		this.surfaceEnM2 = surfaceEnM2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chambre [uuid=" + this.getUuid() + ", numero=" + numero + ", surfaceEnM2=" + surfaceEnM2 + "]";
	}
}
