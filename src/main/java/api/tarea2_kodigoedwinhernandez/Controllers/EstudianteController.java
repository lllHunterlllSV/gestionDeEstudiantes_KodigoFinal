package api.tarea2_kodigoedwinhernandez.Controllers;

import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import api.tarea2_kodigoedwinhernandez.Services.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "API para gestionar estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Operation(summary = "Obtener todos los estudiantes", description = "Este endpoint devuelve una lista de todos los estudiantes.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de estudiantes devuelta correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Estudiante> listarTodos() {
        return estudianteService.listarTodos();
    }



    @Operation(summary = "Obtener un estudiante por ID", description = "Este endpoint busca un estudiante específico por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}")
    public Estudiante obtenerPorId(@PathVariable Integer id) {
        return estudianteService.obtenerPorId(id);
    }



    @Operation(summary = "Obtener un estudiante por Correo", description = "Este endpoint busca un estudiante específico por su Correo.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/buscar-por-correo/{correo}")
    public Estudiante obtenerPorCorreo(@PathVariable String correo) {
        return estudianteService.obtenerPorCorreo(correo);
    }


    @Operation(summary = "Guardar un nuevo estudiante", description = "Este endpoint permite guardar un nuevo estudiante.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Estudiante creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        return estudianteService.guardar(estudiante);
    }

    @Operation(summary = "Actualizar un estudiante", description = "Este endpoint permite actualizar un estudiante existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        return estudianteService.actualizar(id, estudiante);
    }

    @Operation(summary = "Eliminar un estudiante", description = "Este endpoint permite eliminar un estudiante por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estudianteService.eliminar(id);
    }
}
