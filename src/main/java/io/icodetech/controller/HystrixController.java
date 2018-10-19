package io.icodetech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.icodetech.service.CepService;

@RestController
@RequestMapping("/")
public class HystrixController {
	
	@Autowired
	private CepService service;

	@GetMapping("cep")
	public String viaCep(@RequestParam("q") String cep) {
		return service.findByCep(cep);
	}
}