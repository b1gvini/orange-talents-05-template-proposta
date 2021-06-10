package br.com.zupacademy.vinicius.propostazup.cartao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

	Optional<Cartao> findByUuid(String uuid);

}
