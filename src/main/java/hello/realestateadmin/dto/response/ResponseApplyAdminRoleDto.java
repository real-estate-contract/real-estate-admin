package hello.realestateadmin.dto.response;

import hello.realestateadmin.domain.entity.Admin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseApplyAdminRoleDto {
    private final long id;
    private final String name;
    private final String department;
    public static ResponseApplyAdminRoleDto of(Admin admin) {
        return new ResponseApplyAdminRoleDto(admin.getId(), admin.getName(), admin.getDepartment());
    }
}
