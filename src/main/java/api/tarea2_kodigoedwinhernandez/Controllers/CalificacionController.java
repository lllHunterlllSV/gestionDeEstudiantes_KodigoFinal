package api.tarea2_kodigoedwinhernandez.Controllers;

import api.tarea2_kodigoedwinhernandez.Models.Calificacion;
import api.tarea2_kodigoedwinhernandez.Services.CalificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
@Tag(name = "Calificaciones", description = "API para gestionar calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @Operation(summary = "Obtener todas las calificaciones", description = "Este endpoint devuelve una lista de todas las calificaciones.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de calificaciones devuelta correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Calificacion> listarTodas() {
        return calificacionService.listarTodas();
    }

    @Operation(summary = "Obtener una calificación por ID", description = "Este endpoint busca una calificación específica por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calificación encontrada"),
            @ApiResponse(responseCode = "404", description = "Calificación no encontrada")
    })
    @GetMapping("/{id}")
    public Calificacion obtenerPorId(@PathVariable Integer id) {
        return calificacionService.obtenerPorId(id);
    }

    @Operation(summary = "Guardar una nueva calificación", description = "Este endpoint permite guardar una nueva calificación.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Calificación creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public Calificacion guardar(@RequestBody Calificacion calificacion) {
        return calificacionService.guardar(calificacion);
    }

    @Operation(summary = "Actualizar una calificación", description = "Este endpoint permite actualizar una calificación existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calificación actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Calificación no encontrada")
    })
    @PutMapping("/{id}")
    public Calificacion actualizar(@PathVariable Integer id, @RequestBody Calificacion calificacion) {
        return calificacionService.actualizar(id, calificacion);
    }

    @Operation(summary = "Eliminar una calificación", description = "Este endpoint permite eliminar una calificación por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Calificación eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Calificación no encontrada")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        calificacionService.eliminar(id);
    }
}
