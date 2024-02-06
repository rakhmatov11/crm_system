package it.city.crmsystem.repository;

import it.city.crmsystem.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
