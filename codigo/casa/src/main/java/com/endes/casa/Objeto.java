package com.endes.casa;

/**
 * Representa un objeto genérico dentro de una habitación.
 */
class Objeto {
    private String nombre;

    /**
     * Crea un nuevo objeto con un nombre dado.
     * @param nombre El nombre del objeto.
     */
    public Objeto(String nombre) {
        this.nombre = nombre;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
}

