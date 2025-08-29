package com.example.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public @ResponseBody String root() {
		return "Hello, World!";
	}

	@RequestMapping("/Anderson")
	public @ResponseBody String greetingAnderson() {
		return "Hello, Anderson!";
	}

	// Novo endpoint 1: Soma sem parametros
    	@GetMapping("/soma")
		public @ResponseBody int soma() {
    		return 42; // valor fixo só pra teste
	}

    	// Novo endpoint 2: Boas-vindas genérica
    	@RequestMapping("/boasvindas")
    	public @ResponseBody String boasVindas(String nome) {
        	return "Bem-vindo(a), " + nome + "!";
        }

	// Endpoint 3 (copia): Saudacao
	@RequestMapping("/saudacao")
	public @ResponseBody String saudacao(String nome) {
    		java.time.LocalTime hora = java.time.LocalTime.now();
    		String msg = (hora.isBefore(java.time.LocalTime.NOON)) ? "Bom dia" :
                 	     (hora.isBefore(java.time.LocalTime.of(18,0))) ? "Boa tarde" : "Boa noite";
    		return msg + ", " + nome + "!";
	}

	// Novo endpoint 4: sobre
	@RequestMapping("/sobre")
	public @ResponseBody String sobre() {
    		return "Projeto GCMS - Prática 03";
	}

	// Endpoint 6: Hotfix main
	@RequestMapping("/hotfix")
	public @ResponseBody String hotfixEndpoint() {
    		return "Hotfix (merge main & hotfix)!";
	}

}
