package net.gestao.gestaoprodutos.repository;

import net.gestao.gestaoprodutos.modal.Entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {

}
