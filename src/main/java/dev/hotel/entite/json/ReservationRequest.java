package dev.hotel.entite.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Permet de récupérer une réservation sous forme de JSON
 * 
 * @author Diginamik
 *
 */
public class ReservationRequest {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String clientId;
	private List<String> chambres = new ArrayList<>();

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the chambres
	 */
	public List<String> getChambres() {
		return chambres;
	}

	/**
	 * @param chambres
	 *            the chambres to set
	 */
	public void setChambres(List<String> chambres) {
		this.chambres = chambres;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReservationRequest [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", clientId=" + clientId
				+ ", chambres=" + chambres + "]";
	}

}
