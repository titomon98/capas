package arqui.broker.services;

import arqui.broker.models.Log;

import java.util.List;
import java.util.Optional;

public interface logService {
    Optional<Log> getLogById(Integer id);
    Log createLog(Log log);
    List<Log> findAll();
}
