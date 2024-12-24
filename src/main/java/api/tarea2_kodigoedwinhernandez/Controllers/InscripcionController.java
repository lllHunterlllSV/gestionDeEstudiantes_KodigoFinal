package api.tarea2_kodigoedwinhernandez.Controllers;

import api.tarea2_kodigoedwinhernandez.Models.Inscripcion;
import api.tarea2_kodigoedwinhernandez.Services.InscripcionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@Tag(name = "Inscripciones", description = "API para gestionar inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Operation(summary = "Obtener todas las inscripciones", description = "Este endpoint devuelve una lista de todas las inscripciones.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de inscripciones devuelta correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Inscripcion> listarTodas() {
        return inscripcionService.listarTodos();
    }

    @Operation(summary = "Obtener una inscripción por ID", description = "Este endpoint busca una inscripción específica por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Inscripción encontrada"),
            @ApiResponse(responseCode = "404", description = "Inscripción no encontrada")
    })
    @GetMapping("/{id}")
    public Inscripcion obtenerPorId(@PathVariable Integer id) {
        return inscripcionService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con ID: " + id));
    }

    @Operation(summary = "Guardar una nueva inscripción", description = "Este endpoint permite guardar una nueva inscripción.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Inscripción creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public Inscripcion guardar(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.guardar(inscripcion);
    }

    @Operation(summary = "Actualizar una inscripción", description = "Este endpoint permite actualizar una inscripción existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Inscripción actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Inscripción no encontrada")
    })
    @PutMapping("/{id}")
    public Inscripcion actualizar(@PathVariable Integer id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.obtenerPorId(id)
                .map(existingInscripcion -> {
                    inscripcion.setId(id); // Asegúrate de mantener el mismo ID
                    return inscripcionService.guardar(inscripcion);
                })
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con ID: " + id));
    }

    @Operation(summary = "Eliminar una inscripción", description = "Este endpoint permite eliminar una inscripción por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Inscripción eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Inscripción no encontrada")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        inscripcionService.eliminar(id);
    }
}
