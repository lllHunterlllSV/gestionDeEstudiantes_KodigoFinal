
package api.tarea2_kodigoedwinhernandez.Controllers.Endpoints;

import api.tarea2_kodigoedwinhernandez.Models.Profesor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProfesorApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8080/api/profesores"; // URL base de la API

    public List<Profesor> listarTodos() {
        return Arrays.asList(restTemplate.getForObject(baseUrl, Profesor[].class));
    }

    public Profesor obtenerPorId(Integer id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Profesor.class);
    }

    public Profesor obtenerPorCorreo(String correo) {
        return restTemplate.getForObject(baseUrl + "/buscar-por-correo/" + correo, Profesor.class);
    }

    public Profesor guardar(Profesor profesor) {
        return restTemplate.postForObject(baseUrl, profesor, Profesor.class);
    }

    public Profesor actualizar(Integer id, Profesor profesor) {
        restTemplate.put(baseUrl + "/" + id, profesor);
        return profesor;
    }

    public void eliminar(Integer id) {
        restTemplate.delete(baseUrl + "/" + id);
    }
}
