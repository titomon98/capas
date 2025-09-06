package arquitectura.capas.repositories;

import arquitectura.capas.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface roleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByType(String type);
}
