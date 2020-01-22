package dev.hotel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

	public List<Client> findClientByNom(String nom);

	public List<Client> findClientByNomAndPrenoms(String nom, String prenoms);

}
