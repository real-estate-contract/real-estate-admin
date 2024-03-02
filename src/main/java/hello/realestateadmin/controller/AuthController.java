package hello.realestateadmin.controller;

import hello.realestateadmin.dto.request.RequestSignupDto;
import hello.realestateadmin.service.AdminService;
import hello.realestateadmin.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AdminService adminService;

    //관리자에게 권한 요청하기
    @PostMapping("/api/signUp")
    public ResponseEntity<Long> signUp(@RequestBody RequestSignupDto requestSignupDto) throws Exception {
        authService.signUp(requestSignupDto);
        return ResponseEntity.ok().build();
    }
}
