package dev.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Hotel;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.HotelRepository;

@Component
public class Startup {

	private HotelRepository hotelRepo;
	private ChambreRepository chambreRepo;
	private ClientRepository clientRepo;

	public Startup(HotelRepository hotelRepo, ChambreRepository chambreRepo, ClientRepository clientRepo) {
		super();
		this.hotelRepo = hotelRepo;
		this.chambreRepo = chambreRepo;
		this.clientRepo = clientRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		if (this.hotelRepo.count() == 0) {
			Hotel hotel = new Hotel("Hostel", 3);
			this.hotelRepo.save(hotel);

			List<Chambre> listeChambres = new ArrayList<Chambre>();
			listeChambres.add(new Chambre("1", 30F, hotel));
			listeChambres.add(new Chambre("2", 35F, hotel));
			listeChambres.add(new Chambre("3", 45F, hotel));

			for (Chambre chambre : listeChambres) {
				this.chambreRepo.save(chambre);
			}
		}

		if (this.clientRepo.count() == 0) {
			List<Client> listeClients = new ArrayList<Client>();
			listeClients.add(new Client("FROMINVILLE", "Jérémy"));
			listeClients.add(new Client("PIERRE", "Jean"));
			listeClients.add(new Client("ALBERT", "Dimitri"));

			for (Client client : listeClients) {
				this.clientRepo.save(client);
			}
		}

	}

}
