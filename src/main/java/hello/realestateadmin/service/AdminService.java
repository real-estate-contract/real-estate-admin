package hello.realestateadmin.service;

import hello.realestateadmin.domain.constant.Role;
import hello.realestateadmin.domain.entity.Manager;
import hello.realestateadmin.dto.response.Response;
import hello.realestateadmin.dto.response.ResponseApplyManagerRoleDto;
import hello.realestateadmin.respository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdminService {
    private final ManagerRepository managerRepository;
    public Response<List<ResponseApplyManagerRoleDto>> getApplyAdminRole(boolean isApproved) throws Exception {
        try {
            return Response.success(managerRepository.findByIsApproved(isApproved).stream().map(ResponseApplyManagerRoleDto::of).toList());
        }
        catch (Exception e){
            throw new Exception("관리자 권한을 요청한 명단을 불러올 수 없습니다.");
        }
    }

    @Transactional
    public Response<String> approveApply(List<Long> applyMembersId) throws Exception {
        try {
            List<Manager> list = applyMembersId.stream().map(managerRepository::findById)
                    .map(Optional::orElseThrow)
                    .toList();
            for (Manager manager : list) {
                manager.updateRole(Role.MANAGER, true);
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
                managerRepository.deleteById(i);
        }
        catch (Exception e){
            throw new Exception("관리자 권한 요청을 거절할 수 없습니다.");
        }
        return Response.success("요청 성공");
    }
}
