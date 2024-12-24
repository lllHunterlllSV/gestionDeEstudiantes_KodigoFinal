package api.tarea2_kodigoedwinhernandez.Controllers;

import api.tarea2_kodigoedwinhernandez.Models.Profesor;
import api.tarea2_kodigoedwinhernandez.Services.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@Tag(name = "Profesores", description = "API para gestionar profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Operation(summary = "Obtener todos los profesores", description = "Este endpoint devuelve una lista de todos los profesores.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de profesores devuelta correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Profesor> listarTodos() {
        return profesorService.listarTodos();
    }

    @Operation(summary = "Obtener un profesor por ID", description = "Este endpoint busca un profesor específico por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profesor encontrado"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @GetMapping("/{id}")
    public Profesor obtenerPorId(@PathVariable Integer id) {
        return profesorService.obtenerPorId(id);
    }


    @Operation(summary = "Obtener un profesor por Correo", description = "Este endpoint busca un profesor específico por su Correo.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profesor encontrado"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @GetMapping("/buscar-por-correo/{correo}")
    public Profesor obtenerPorCorreo(@PathVariable String correo) {
        return profesorService.obtenerPorCorreo(correo);
    }

    @Operation(summary = "Guardar un nuevo profesor", description = "Este endpoint permite guardar un nuevo profesor.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Profesor creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public Profesor guardar(@RequestBody Profesor profesor) {
        return profesorService.guardar(profesor);
    }

    @Operation(summary = "Actualizar un profesor", description = "Este endpoint permite actualizar un profesor existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profesor actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Integer id, @RequestBody Profesor profesor) {
        return profesorService.actualizar(id, profesor);
    }

    @Operation(summary = "Eliminar un profesor", description = "Este endpoint permite eliminar un profesor por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profesor eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        profesorService.eliminar(id);
    }
}
