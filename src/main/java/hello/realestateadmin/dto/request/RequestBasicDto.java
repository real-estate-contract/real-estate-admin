package hello.realestateadmin.dto.request;

import hello.realestateadmin.domain.constant.SpeculativeArea;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestBasicDto {
    private Long basicId;
    private String ownershipLand;
    private String noOwnershipLand;
    private String ownershipBuilding;
    private String noOwnershipBuilding;
    private String useArea; //용도지역
    private String useDistrict; //용도지구
    private String useSection; //용도구역
    private String planFacility; //도시,군 계획시설
    private boolean permittedArea; //허가, 신고 구역 여부
    private SpeculativeArea speculativeArea; //투기지역여부
    private String plan; //지구단위계획구역, 도시 군 관리계획
    private String etc; //그 밖의 이용제한 및 거래 규제사항
    private Integer acquisitionTax; //취득세
    private Integer framTax; //농어촌특별세
    private Integer localTax; //지방교육세
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
