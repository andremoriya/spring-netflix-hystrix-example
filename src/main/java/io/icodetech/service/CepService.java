package io.icodetech.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CepService {

	@HystrixCommand(fallbackMethod = "findBy")
	public String findByCep(String cep) {
		RestTemplate client = new RestTemplate();
		String response = client.getForObject(String.format("https://viacep.com.br/ws/%s/json", cep), String.class);
		
		return response;
	}
	
	public String findBy(String cep) {
		return cep;
	}
}