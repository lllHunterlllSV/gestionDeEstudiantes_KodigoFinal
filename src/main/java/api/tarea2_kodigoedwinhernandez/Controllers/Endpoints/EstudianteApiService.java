package api.tarea2_kodigoedwinhernandez.Controllers.Endpoints;



import api.tarea2_kodigoedwinhernandez.Models.Estudiante;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EstudianteApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8080/api/estudiantes"; // URL base de la API

    public List<Estudiante> listarTodos() {
        return Arrays.asList(restTemplate.getForObject(baseUrl, Estudiante[].class));
    }

    public Estudiante obtenerPorId(Integer id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Estudiante.class);
    }

    public Estudiante obtenerPorCorreo(String correo) {
        return restTemplate.getForObject(baseUrl + "/buscar-por-correo/" + correo, Estudiante.class);
    }

    public Estudiante guardar(Estudiante estudiante) {
        return restTemplate.postForObject(baseUrl, estudiante, Estudiante.class);
    }

    public Estudiante actualizar(Integer id, Estudiante estudiante) {
        restTemplate.put(baseUrl + "/" + id, estudiante);
        return estudiante;
    }

    public void eliminar(Integer id) {
        restTemplate.delete(baseUrl + "/" + id);
    }
}
