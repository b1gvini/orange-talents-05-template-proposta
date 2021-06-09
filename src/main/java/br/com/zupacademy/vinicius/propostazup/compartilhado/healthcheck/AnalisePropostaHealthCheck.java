package br.com.zupacademy.vinicius.propostazup.compartilhado.healthcheck;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AnalisePropostaHealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		Map<String, String> details = new HashMap<>();
		details.put("Api Externa", "API Análise de Propostas");
		details.put("URL", "http://localhost:9999/api/solicitacao");
		try (Socket socket = new Socket(new java.net.URL("http://localhost/api/solicitacao").getHost(), 9999)) {
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
        return Health.up().withDetails(details).build();
    }
}

