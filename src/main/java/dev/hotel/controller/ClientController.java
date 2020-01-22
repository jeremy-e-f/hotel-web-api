package dev.hotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@RestController
public class ClientController {

	private ClientRepository clientRepo;

	ClientController(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "clients")
	// @ResponseBody
	public List<Client> retourneClients() {
		return clientRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "clients", params = "nom")
	// @ResponseBody
	public List<Client> retourneClientsByName(String nom) {
		List<Client> listeClients = clientRepo.findClientByNom(nom);
		return listeClients;
	}

	@RequestMapping(method = RequestMethod.POST, path = "clients")
	// @ResponseBody
	public ResponseEntity<String> post(@RequestBody Client clientRecu) {
		if (!clientRepo.findClientByNomAndPrenoms(clientRecu.getNom(), clientRecu.getPrenoms()).isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le client existe déjà!");
		} else {
			this.clientRepo.save(clientRecu);
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body("Le client " + clientRecu + " a été créé avec succès!");
		}
	}

}
