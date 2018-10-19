package io.icodetech.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CepService {
	
	private static final Map<String, String> response = Maps.newHashMap();

	@HystrixCommand(fallbackMethod = "findBy")
	public String findByCep(String cep) {
		RestTemplate client = new RestTemplate();
		String res = client.getForObject(String.format("https://viacep.com.br/ws/%s/json", cep), String.class);
		response.put(cep, res);
		
		return res;
	}
	
	public String findBy(String cep) {
		String result = "";
		Optional<String> value = Optional.ofNullable(response.get(cep));
		if(value.isPresent()) {
			result = value.get();
			return result;
		} else {
			result = "{\"status\": \"404\", \"messagem\": \"CEP não encontrado\"}";
		}
		return result;
	}
}