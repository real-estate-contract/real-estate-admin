package hello.realestateadmin.respository;

import hello.realestateadmin.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByName(String username);
    List<Admin> findByIsApproved(Boolean isApproved);
}
