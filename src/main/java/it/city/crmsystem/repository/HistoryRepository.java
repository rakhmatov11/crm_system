package it.city.crmsystem.repository;

import it.city.crmsystem.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository extends JpaRepository<History, UUID> {
    List<History> findAllByLeadIdEquals(UUID leadId);
}
