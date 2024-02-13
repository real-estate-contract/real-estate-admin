package hello.realestateadmin.dto.request;

import lombok.Data;

@Data
public class RequestSignupDto {
    private String name;
    private String password;
    private String department;
}

