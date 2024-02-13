package hello.realestateadmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    @RequestMapping("/main")
    public String main(Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(
                a -> a.getAuthority().equals("ROLE_ADMIN")
        )) {
            return "forward:/admin/index";
        } else if (authentication.getAuthorities().stream().anyMatch(
                a -> a.getAuthority().equals("ROLE_MANAGER")
        )) {
            return "forward:/manager/index";
        }
        return "main";  // 접근 거부 페이지로
    }
}
