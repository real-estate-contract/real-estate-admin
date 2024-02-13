package hello.realestateadmin.respository;

import hello.realestateadmin.domain.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
        Optional<Manager> findByName(String username);
        List<Manager> findByIsApproved(Boolean isApproved);

}
