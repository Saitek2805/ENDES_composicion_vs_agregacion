package com.endes.casa;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una habitación dentro de una casa.
 */
class Habitacion {
    private int numero;
    private List<Objeto> objetos;

    /**
     * Crea una habitación con un número asignado.
     * @param numero El número de identificación de la habitación.
     */
    public Habitacion(int numero) {
        this.numero = numero;
        this.objetos = new ArrayList<>();
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}

	public void addObjeto(Objeto objeto) {
	    if (objeto == null) {
	        throw new IllegalArgumentException("No se puede agregar un objeto nulo");
	    }
	    this.objetos.add(objeto);
	}
}

