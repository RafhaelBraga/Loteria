package com.braga.loteria.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "apostas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)

public class Aposta implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private Long id;
	
	@NotNull
	private String emailApostador;
	
	private int[] numeros;
	
    public String getEmailApostador() {
		return this.emailApostador;
	}

	public void setEmailApostador(String emailApostador) {
		this.emailApostador = emailApostador;
	}	
    
	public Long getId() {
		return id;
	}	

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}
	
    public int[] criaAposta(int n)
    {
    	Random rand = new Random();
    	int[] numeros = new int[n];
    	int vezes; 
    	Boolean ok = false;
    	while(ok == false)
    	{
    		ok = true;
	    	for (int i = 0; i < n; i++)
			{
				numeros[i] = rand.nextInt(61);
				
			}
	    	
	    	Arrays.sort(numeros);
	    	
	    	for (int i = 0; i < numeros.length; i++)
	    	{
	    		vezes = 0;
	    		for (int b = 0; b < numeros.length; b++)
	        	{
	    			if(numeros[i] == numeros[b])
	    				vezes++;
	    			if(numeros[i] == 0)
	    				vezes = 2;
	        	}
	    		if(vezes > 1)
	    			ok = false;
	    	}
	    }
    	return numeros;
    }
}
