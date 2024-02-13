package hello.realestateadmin.service.Manager;

import hello.realestateadmin.domain.constant.Role;
import hello.realestateadmin.domain.entity.Admin;
import hello.realestateadmin.dto.response.Response;
import hello.realestateadmin.dto.response.ResponseApplyAdminRoleDto;
import hello.realestateadmin.respository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final AdminRepository adminRepository;
    public Response<List<ResponseApplyAdminRoleDto>> getApplyAdminRole(boolean isApproved) throws Exception {
        try {
            return Response.success(adminRepository.findByIsApproved(isApproved).stream().map(ResponseApplyAdminRoleDto::of).toList());
        }
        catch (Exception e){
            throw new Exception("관리자 권한을 요청한 명단을 불러올 수 없습니다.");
        }
    }

    @Transactional
    public Response<String> approveApply(List<Long> applyMembersId) throws Exception {
        try {
            List<Admin> list = applyMembersId.stream().map(adminRepository::findById)
                    .map(Optional::orElseThrow)
                    .toList();
            for (Admin admin : list) {
                admin.updateRole(Role.ADMIN, true);
            }
        }
        catch (Exception e){
            throw new Exception("관리자 권한 요청을 승인할 수 없습니다.");
        }
        return Response.success("요청 성공");
    }
    @Transactional
    public Response<String> refuseApply(List<Long> applyMembersId) throws Exception {
        try{
            for(long i: applyMembersId)
                adminRepository.deleteById(i);
        }
        catch (Exception e){
            throw new Exception("관리자 권한 요청을 거절할 수 없습니다.");
        }
        return Response.success("요청 성공");
    }
}
