package br.com.fiap.gs.repository;

import br.com.fiap.gs.model.UsinaSolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsinaSolarRepository extends JpaRepository<UsinaSolar, Long> {
}
