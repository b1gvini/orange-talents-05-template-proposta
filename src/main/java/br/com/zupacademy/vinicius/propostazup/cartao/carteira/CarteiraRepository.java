package br.com.zupacademy.vinicius.propostazup.cartao.carteira;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long>{

	Optional<Carteira> findByCarteiraAndCartaoId(TipoCarteira carteira, String id);

}
