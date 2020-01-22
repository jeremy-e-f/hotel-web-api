package dev.hotel.entite;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class Client extends BaseEntite {

	private String nom;

	private String prenoms;

	public Client() {
	}

	public Client(String uuid) {
		this.setUuid(UUID.fromString(uuid));
	}

	public Client(String nom, String prenoms) {
		this.nom = nom;
		this.prenoms = prenoms;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [uuid=" + this.getUuid() + ", nom=" + nom + ", prenoms=" + prenoms + "]";
	}
}
