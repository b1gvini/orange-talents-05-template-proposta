package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.associacartao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zupacademy.vinicius.propostazup.cartao.Cartao;
import br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.ApiCartaoFeignClient;
import br.com.zupacademy.vinicius.propostazup.proposta.Proposta;
import br.com.zupacademy.vinicius.propostazup.proposta.PropostaRepository;
import feign.FeignException;

@Component
public class BuscaAgendadaCartao {
	
	@Autowired
	private ApiCartaoFeignClient associaCartao;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	Logger logger = LoggerFactory.getLogger(BuscaAgendadaCartao.class);

	@Scheduled(fixedDelayString = "${periodicidade.minha-tarefa}")
	public void associaCartao() {
		List<Proposta> propostasElegiveis = propostaRepository.findTodasElegiveis();
		for (Proposta proposta : propostasElegiveis) {
			try {
				AssociaCartaoFeignResponse cartaoResponse = associaCartao.consultaCartao(proposta.getUuid());
				Cartao cartao = cartaoResponse.toModel();
				proposta.setCartao(cartao);
				propostaRepository.save(proposta);
			} catch (FeignException ex) {
				logger.warn(ex.contentUTF8());
				logger.error(ex.getMessage());
			} catch (Exception e) {
				logger.error("Erro anormal aqui");
			}
		}
	}
}
