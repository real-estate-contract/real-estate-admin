package hello.realestateadmin.controller;

import hello.realestateadmin.dto.request.RequestBasicDto;
import hello.realestateadmin.respository.BasicRepository;
import hello.realestateadmin.service.BasicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasicController {
    private final BasicRepository basicRepository;
    private final BasicService basicService;
    @PostMapping("/api/manager/basic")
    public ResponseEntity<Long> createBasic(@RequestBody RequestBasicDto requestBasicDto, Authentication authentication) throws Exception {
        basicService.createBasicInfo(requestBasicDto);
        return ResponseEntity.ok().build();
    }
}
