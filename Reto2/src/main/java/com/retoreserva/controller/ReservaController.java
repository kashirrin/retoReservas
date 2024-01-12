package main.java.com.retoreserva.controller;

import main.java.com.retoreserva.model.Reserva;
import main.java.com.retoreserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    // Inyección de dependencia del repositorio de reservas
    private ReservaRepository reservaRepository;

    // Endpoint para crear una reserva
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) {
        // Validar solapamiento de fechas
        if (FechasSolapadas(reserva)) {
            return ResponseEntity.badRequest().body("Las fechas de la reserva se solapan con otra reserva existente.");
        }

        // Lógica para crear la reserva y guardar en la base de datos
        return ResponseEntity.ok(reservaRepository.save(reserva));
    }

    // Método para verificar si las fechas de una nueva reserva se solapan con alguna existente
    private boolean FechasSolapadas(Reserva nuevaReserva) {
        // Obtener todas las reservas existentes en la base de datos
        List<Reserva> reservasExistente = reservaRepository.findAll();

        // Verifica solapamiento de fechas
        for (Reserva reservaExistente : reservasExistente) {
            if (nuevaReserva.getFechaInicio().isBefore(reservaExistente.getFechaFin()) &&
                nuevaReserva.getFechaFin().isAfter(reservaExistente.getFechaInicio())) {
                return true; // Solapamiento de fechas
            }
        }
        return false;
    }

    // Endpoint para obtener una reserva por su ID
    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable Long id) {
        // Implementa la lógica para obtener una reserva por ID
        return reservaRepository.findById(id).orElse(null);
    }

    // Endpoint para actualizar una reserva por su ID
    @PutMapping("/{id}")
    public Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reservaActualizada) {
        // Lógica para actualizar una reserva por ID
        Reserva reservaExistente = reservaRepository.findById(id).orElse(null);

        // Verificar si la reserva existe
        if (reservaExistente != null) {
            reservaExistente.setFechaInicio(reservaActualizada.getFechaInicio());

            return reservaRepository.save(reservaExistente);
        } else {
            return null;
        }
    }

    // Endpoint para eliminar una reserva por su ID
    @DeleteMapping("/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        // Lógica para eliminar una reserva por ID
        reservaRepository.deleteById(id);
        return "Reserva eliminada con éxito";
    }
}