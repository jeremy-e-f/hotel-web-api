package dev.hotel.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation extends BaseEntite {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	@ManyToOne
	@JoinColumn(name = "client_uuid")
	private Client client;
	@ManyToMany
	@JoinTable(name = "reservation_chambre", joinColumns = @JoinColumn(name = "reservation_uid", referencedColumnName = "uuid"), inverseJoinColumns = @JoinColumn(name = "chambre_uid", referencedColumnName = "uuid"))
	private List<Chambre> chambres = new ArrayList<>();

	public Reservation() {
	}

	public Reservation(LocalDate dateDebut, LocalDate dateFin, Client client, List<Chambre> chambres) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.chambres = chambres;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reservation [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", client=" + client + ", chambres="
				+ chambres + "]";
	}
}
