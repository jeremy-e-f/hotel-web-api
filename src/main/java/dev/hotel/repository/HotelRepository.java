package dev.hotel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {

}
