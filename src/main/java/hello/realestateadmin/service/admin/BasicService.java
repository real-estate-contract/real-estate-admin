package hello.realestateadmin.service.admin;

import hello.realestateadmin.domain.entity.Basic;
import hello.realestateadmin.dto.request.RequestBasicDto;
import hello.realestateadmin.exception.ApplicationException;
import hello.realestateadmin.exception.ErrorCode;
import hello.realestateadmin.respository.BasicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BasicService {
    private final BasicRepository basicRepository;

    @Transactional
    public void createBasicInfo(RequestBasicDto requestBasicDto) throws Exception {
        // basicId에 해당하는 Basic이 존재하는지 확인
        // basic = basicRepository.findById(basicId).orElseThrow(() -> new ApplicationException(ErrorCode.BASIC_NOT_FOUND, String.format("%s is not founded", basicId)));

        // Basic 엔티티에 필요한 데이터를 매핑

        // Basic 저장
        basicRepository.save(Basic.of(requestBasicDto));
    }


}
