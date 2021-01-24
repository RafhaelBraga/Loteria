package com.braga.loteria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.braga.loteria.model.Aposta;
import com.braga.loteria.repository.ApostasRepository;

@RestController
@RequestMapping("/lot")
public class ApostaController {
		
	@Autowired
	ApostasRepository apostasRepository;
	
	// Aposta: 6 números de 1 a 60
		@PostMapping("/apostas/criar")
		public int[] createAposta(@Validated @RequestBody String email) {
			
			Aposta novaAposta = new Aposta();
			List<Aposta> apostasFeitas;
			Boolean existe = false;
			
			//cria uma aposta de 6 números
			novaAposta.setNumeros(novaAposta.criaAposta(6));
			
			//Adiciona o email do apostador à aposta
			novaAposta.setEmailApostador(email);
				
			apostasFeitas = apostasRepository.findAll();
			
			for (int i = 0; i < apostasFeitas.size(); i++)
			{
				
				if(apostasFeitas.get(i).getNumeros().toString().equals(novaAposta.getNumeros().toString()) && apostasFeitas.get(i).getEmailApostador().equals(email))
				{
					existe = true;
				}
			}

			if(existe == false)
			{				
				apostasRepository.save(novaAposta);
				return novaAposta.getNumeros();
			}
			else
			{
				return this.createAposta(email);
			}			
		}
		
		@GetMapping("/Apostas/listar")
		public List<Aposta> getApostas(@Validated @RequestBody String email) {
			
		    List<Aposta> apostas = apostasRepository.findAll();
		    List<Aposta> apostasRetorno = new ArrayList<>();;
		    
		    for (int c = 0; c < apostas.size(); c++)
		    {
		    	
		    	if(apostas.get(c).getEmailApostador().equals(email))
		    	{
		    		apostasRetorno.add(apostas.get(c));			    	
		    	}
		    }
		    
			return apostasRetorno;
		}
	
}
