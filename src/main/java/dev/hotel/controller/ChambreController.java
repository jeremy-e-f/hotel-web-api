package dev.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;

@RestController
public class ChambreController {

	private ChambreRepository chambreRepo;

	ChambreController(ChambreRepository chambreRepo) {
		this.chambreRepo = chambreRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "chambres")
	// @ResponseBody
	public List<Chambre> retourneChambres() {
		return chambreRepo.findAll();
	}

}
