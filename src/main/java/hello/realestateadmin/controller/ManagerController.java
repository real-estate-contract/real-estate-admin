package hello.realestateadmin.controller;

import hello.realestateadmin.service.admin.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;


}
