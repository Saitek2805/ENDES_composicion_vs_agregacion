package com.endes.casa;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa una casa que contiene habitaciones.
 */
class Casa {
    private String direccion;
    private List<Habitacion> habitaciones;

    /**
     * Crea una casa con una dirección dada y un número específico de habitaciones.
     * @param direccion La dirección de la casa.
     * @param numeroDeHabitaciones La cantidad de habitaciones para crear.
     */
    public Casa(String direccion, int numeroDeHabitaciones) {
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
        for (int i = 0; i < numeroDeHabitaciones; i++) {
            this.habitaciones.add(new Habitacion(i + 1));
        }
    }

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
     * Elimina una habitación de la casa.
     * @param habitacion La habitación a eliminar.
     */
    public void removeHabitacion(Habitacion habitacion) {
        this.habitaciones.remove(habitacion);
    }

	public void addHabitacion(Habitacion habitacion) {
		 this.habitaciones.add(habitacion);
		
	}

}
