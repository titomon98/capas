package arqui.broker.services;

import arqui.broker.models.Log;
import arqui.broker.repositories.logRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class logServiceImplementation implements logService {

    //Aqui va la logica de negocio
    private final logRepository logRepository;

    //Constructor de repositorio
    public logServiceImplementation(logRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> findAll() {
        return logRepository.findAll();
    }

    @Override
    public Optional<Log> getLogById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        Optional<Log> logValidado = logRepository.findById(id);
        return logValidado;
    }

    @Override
    public Log createLog(Log log) {
        //Broker solo registra request y response
        //Unicamente vamos a tener la request
        String request = log.getRequest();
        //Hasta que hacemos la llamada a la API Node, podemos maquetar la response
        String url = "http://localhost:3000/api/tipo-producto";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("tipo", request);

        //Llamada a la API
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(url, String.class);
        //Tomar los datos de respuesta para guardar aqui
        log.setResponse(responseEntity.getBody());
        log.setCode(responseEntity.getStatusCode().value());

        return logRepository.save(log);
    }
}
