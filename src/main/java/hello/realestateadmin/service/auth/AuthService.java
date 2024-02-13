package hello.realestateadmin.service.auth;

import hello.realestateadmin.domain.constant.Role;
import hello.realestateadmin.domain.entity.Manager;
import hello.realestateadmin.dto.request.RequestSignupDto;
import hello.realestateadmin.dto.response.Response;
import hello.realestateadmin.dto.response.ResponseAdminDto;
import hello.realestateadmin.respository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService{
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    //관리자에게 회원가입 요청 보내기
    public Response<String> signUp(RequestSignupDto requestSignupDto) throws Exception {
        try {
            Manager admin = Manager.builder()
                    .name(requestSignupDto.getName())
                    .password(passwordEncoder.encode(requestSignupDto.getPassword()))
                    .role(Role.UNAPPROVED)
                    .isApproved(false)
                    .department(requestSignupDto.getDepartment())
                    .build();
            adminRepository.save(admin);
        }
        catch (Exception e){
            throw new Exception("관리자 요청을 불러올 수 없습니다.");
        }
        return Response.success("요청 성공");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Manager admin = adminRepository.findByName(username).orElseThrow();
        return ResponseAdminDto.of(admin);
    }
}
