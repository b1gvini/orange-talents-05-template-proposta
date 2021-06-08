package br.com.zupacademy.vinicius.propostazup.proposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{
	
	Optional<Proposta> findByDocumento(String documento);

	@Query(value = "select * from proposta where status = 'ELEGIVEL' and cartao_id is null", nativeQuery = true)
	List<Proposta> findTodasElegiveis();

	Optional<Proposta> findByUuid(String uuid);
}
