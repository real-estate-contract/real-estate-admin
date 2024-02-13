package hello.realestateadmin.controller;

import hello.realestateadmin.dto.response.Response;
import hello.realestateadmin.dto.response.ResponseApplyManagerRoleDto;
import hello.realestateadmin.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/api/admin/wait-list")
    public Response<List<ResponseApplyManagerRoleDto>> getApplyAdminRole() throws Exception {
        return adminService.getApplyAdminRole(false);
    }

    @PostMapping("/api/admin/approve")
    public void approveApply(@RequestBody List<Long> applyMembersId) throws Exception {
        adminService.approveApply(applyMembersId);
    }
    @DeleteMapping("/api/admin/refuse")
    public void refuseApply(@RequestBody List<Long> applyMembersId) throws Exception {
        adminService.refuseApply(applyMembersId);
    }

}
