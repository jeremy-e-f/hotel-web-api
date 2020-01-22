package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.entite.json.ReservationRequest;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;

@RestController
public class ReservationController {

	private static final Logger LOG = LoggerFactory.getLogger(dev.hotel.controller.ReservationController.class);

	private ClientRepository clientRepo;
	private ChambreRepository chambreRepo;
	private ReservationRepository reservRepo;

	ReservationController(ClientRepository clientRepo, ChambreRepository chambreRepo,
			ReservationRepository reservRepo) {
		this.clientRepo = clientRepo;
		this.chambreRepo = chambreRepo;
		this.reservRepo = reservRepo;
	}

	@RequestMapping(method = RequestMethod.POST, path = "reservationsOld")
	@Deprecated
	// @ResponseBody
	public ResponseEntity<String> postWithoutRequestObject(@RequestBody Reservation reservationRecue) {
		Optional<Client> clientOpt = clientRepo.findById(reservationRecue.getClient().getUuid());
		LOG.info("" + reservationRecue);
		if (!clientOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("client non trouvé");
		}
		Client client = clientOpt.get();

		List<Chambre> listeChambresRecues = reservationRecue.getChambres();
		List<Chambre> listeChambres = new ArrayList<Chambre>();
		for (Chambre chambre : listeChambresRecues) {
			Optional<Chambre> chambreOpt = chambreRepo.findById(chambre.getUuid());
			if (!chambreOpt.isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("la chambre " + chambre.getUuid() + " n’existe pas");
			}
			listeChambres.add(chambreOpt.get());
		}

		reservationRecue.setChambres(listeChambres);
		reservationRecue.setClient(client);
		reservRepo.save(reservationRecue);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("La réservation a été enregistrée avec succès!");
	}

	@RequestMapping(method = RequestMethod.POST, path = "reservations")
	// @ResponseBody
	public ResponseEntity<String> postJSON(@RequestBody ReservationRequest reservationRequest) {
		LOG.info("" + reservationRequest);
		Optional<Client> clientOpt = clientRepo.findById(UUID.fromString(reservationRequest.getClientId()));
		if (!clientOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("client non trouvé");
		}
		Client client = clientOpt.get();

		List<String> listeChambresUID = reservationRequest.getChambres();
		List<Chambre> listeChambres = new ArrayList<Chambre>();
		for (String chambreUID : listeChambresUID) {
			Optional<Chambre> chambreOpt = chambreRepo.findById(UUID.fromString(chambreUID));
			if (!chambreOpt.isPresent()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("la chambre " + chambreUID + " n’existe pas");
			}
			listeChambres.add(chambreOpt.get());
		}

		Reservation reservation = new Reservation(reservationRequest.getDateDebut(), reservationRequest.getDateFin(),
				client, listeChambres);
		reservRepo.save(reservation);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("La réservation a été enregistrée avec succès!");
	}

}
