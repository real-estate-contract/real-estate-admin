package hello.realestateadmin.service.admin;

import hello.realestateadmin.respository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;

}
