package br.com.zupacademy.vinicius.propostazup.metricas;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;

@Component
public class MetricasPropostas {
	
	 	private final MeterRegistry meterRegistry;
	    private Counter contadorPropostaCriada;

	    public MetricasPropostas(MeterRegistry meterRegistry) {
	        this.meterRegistry = meterRegistry;
	        this.initializeCounters();
	    }

	    private void initializeCounters() {
	        Collection<Tag> tags = new ArrayList<>();
	        tags.add(Tag.of("emissora", "vini-proposta-api"));
	        tags.add(Tag.of("banco", "zupacademy"));

	        this.contadorPropostaCriada = this.meterRegistry.counter("proposta_criada", tags);
	    }

	    public void incrementa() {
	        this.contadorPropostaCriada.increment();
	    }
}
