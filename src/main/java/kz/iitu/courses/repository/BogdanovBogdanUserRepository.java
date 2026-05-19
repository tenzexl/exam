package kz.iitu.courses.repository;

import kz.iitu.courses.model.BogdanovBogdanUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BogdanovBogdanUserRepository extends JpaRepository<BogdanovBogdanUser, Long> {
    Optional<BogdanovBogdanUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
