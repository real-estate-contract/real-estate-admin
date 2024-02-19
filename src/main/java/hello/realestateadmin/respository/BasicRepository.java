package hello.realestateadmin.respository;

import hello.realestateadmin.domain.entity.Basic;
import hello.realestateadmin.domain.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BasicRepository  extends JpaRepository<Basic, Long> {
    Optional<Basic> findById(Long basicId);
}
