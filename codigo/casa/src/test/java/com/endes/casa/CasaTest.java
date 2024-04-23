package com.endes.casa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de pruebas para Casa y Habitación con JUnit 5.
 */
class CasaTest {

    Casa casa;

    @BeforeEach
    void setUp() {
        // Se inicializa una casa con una dirección y un número específico de habitaciones antes de cada prueba.
        casa = new Casa("123 Calle Ficticia", 3);
    }

    @Test
    @DisplayName("Crear una casa con un número específico de habitaciones")
    void testCrearCasaConHabitaciones() {
        assertEquals(3, casa.getHabitaciones().size(), "La casa debe ser creada con 3 habitaciones.");
    }

    @Test
    @DisplayName("Agregar objetos a una habitación y verificar que estén presentes")
    void testAgregarYObtenerObjetosDeHabitacion() {
        Habitacion habitacion = casa.getHabitaciones().get(0);
        Objeto objeto1 = new Objeto("Lámpara");
        Objeto objeto2 = new Objeto("Cama");
        habitacion.addObjeto(objeto1);
        habitacion.addObjeto(objeto2);
        assertAll("Los objetos deben ser agregados a la habitación",
            () -> assertTrue(habitacion.getObjetos().contains(objeto1), "La habitación debe contener una lámpara"),
            () -> assertTrue(habitacion.getObjetos().contains(objeto2), "La habitación debe contener una cama")
        );
    }

    @Test
    @DisplayName("Verificar la dirección de la casa")
    void testDireccionCasa() {
        assertEquals("123 Calle Ficticia", casa.getDireccion(), "La dirección de la casa debe coincidir con la proporcionada en el constructor.");
    }

    @Test
    @DisplayName("La lista de objetos debe contener todos los elementos agregados.")
    void testObtenerObjetosHabitacion() {
        Habitacion habitacion = new Habitacion(1);
        Objeto lampara = new Objeto("Lámpara");
        Objeto cama = new Objeto("Cama");
        habitacion.addObjeto(lampara);
        habitacion.addObjeto(cama);

        assertTrue(habitacion.getObjetos().contains(lampara) && habitacion.getObjetos().contains(cama),
                   "La lista de objetos debe contener todos los elementos agregados.");
    }
    
    @Test
    @DisplayName("Asegurar que la eliminación de una habitación también elimina sus objetos")
    void testEliminarHabitacionYObjetos() {
        Habitacion habitacion = casa.getHabitaciones().get(0);
        Objeto objeto = new Objeto("Silla");
        habitacion.addObjeto(objeto);
        casa.removeHabitacion(habitacion);
        assertFalse(casa.getHabitaciones().contains(habitacion), "La habitación debe ser eliminada de la casa");
    }
    
     @Test
    @DisplayName("Comprobar que no se pueden agregar objetos nulos a la habitación")
    void testAgregarObjetosNulos() {
        Habitacion habitacion = casa.getHabitaciones().get(0);
        assertThrows(IllegalArgumentException.class, () -> habitacion.addObjeto(null), "Debería lanzar una excepción al intentar agregar un objeto nulo");
    }

    @Test
    @DisplayName("Asegurar que al eliminar una habitación, los objetos no se eliminan si pertenecen a más habitaciones")
    void testEliminarHabitacionSinEliminarObjetosCompartidos() {
        Habitacion habitacion1 = casa.getHabitaciones().get(0);
        Habitacion habitacion2 = casa.getHabitaciones().get(1);
        Objeto objetoCompartido = new Objeto("Espejo");
        habitacion1.addObjeto(objetoCompartido);
        habitacion2.addObjeto(objetoCompartido);
        casa.removeHabitacion(habitacion1);
        assertTrue(habitacion2.getObjetos().contains(objetoCompartido), "El objeto compartido no debe ser eliminado si pertenece a otra habitación");
    }

    @Test
    @DisplayName("Verificar que la eliminación de una habitación realmente elimina solo esa habitación")
    void testEliminarHabitacionEspecifica() {
        Habitacion habitacion = new Habitacion(999); // Crear una habitación con un número único.
        casa.addHabitacion(habitacion); // Agregar manualmente la nueva habitación.
        int totalHabitacionesAntes = casa.getHabitaciones().size();
        casa.removeHabitacion(habitacion);
        int totalHabitacionesDespues = casa.getHabitaciones().size();
        assertAll(
            () -> assertEquals(totalHabitacionesAntes - 1, totalHabitacionesDespues, "El total de habitaciones después de eliminar una debe disminuir en uno."),
            () -> assertFalse(casa.getHabitaciones().contains(habitacion), "La habitación eliminada no debe estar presente en la lista de habitaciones.")
        );
    }
    
    @Test
    @DisplayName("Validar la capacidad de cambiar la dirección de una casa")
    void testCambiarDireccionCasa() {
        String nuevaDireccion = "456 Otra Calle";
        casa.setDireccion(nuevaDireccion);
        assertEquals(nuevaDireccion, casa.getDireccion(), "La dirección de la casa debe actualizarse con el nuevo valor.");
    }
}

