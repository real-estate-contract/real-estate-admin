package hello.realestateadmin.dto.response;

import hello.realestateadmin.domain.entity.Manager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseApplyManagerRoleDto {
    private final long id;
    private final String name;
    private final String department;
    public static ResponseApplyManagerRoleDto of(Manager admin) {
        return new ResponseApplyManagerRoleDto(admin.getId(), admin.getName(), admin.getDepartment());
    }
}
