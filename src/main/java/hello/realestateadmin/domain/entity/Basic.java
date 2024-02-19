package hello.realestateadmin.domain.entity;

import com.sun.istack.NotNull;
import hello.realestateadmin.domain.constant.SpeculativeArea;

import hello.realestateadmin.dto.request.RequestBasicDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "basic")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Basic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basic_id")
    private Long basicId;


    //==권리관계==//
    // 소유권에 관한 사항
    @Column(name = "ownership_land")
    @NotNull
    private String ownershipLand; //소유권 토지

    @Column(name = "no_ownership_land")
    @NotNull
    private String noOwnershipLand; //비소유권 토지

    // 소유권 외의 권리 사항
    @Column(name = "ownership_building")
    @NotNull
    private String ownershipBuilding; //소유권 건축물

    @Column(name = "no_ownership_building")
    @NotNull
    private String noOwnershipBuilding; //비소유권 건축물

    // 민간 임대 등록 여부
    //등록

    //미등록

    //계약갱신 요구권 행사 여부

    //다가구주택확인서류 제출 여부

    //==토지이용계획==//
    @Column(name = "use_area")
    @NotNull
    private String useArea; //용도지역

    @Column(name = "use_district")
    @NotNull
    private String useDistrict; //용도지구

    @Column(name = "use_section")
    @NotNull
    private String useSection; //용도구역

    @Column(name = "plan_facility")
    @NotNull
    private String planFacility; //도시,군 계획시설

    @Column(name = "permitted_area")
    @NotNull
    private boolean permittedArea; //허가, 신고 구역 여부

    @Enumerated(EnumType.STRING)
    @Column(name = "speculative_area")
    @NotNull
    private SpeculativeArea speculativeArea; //투기지역여부

    @Column(name = "plan")
    @NotNull
    private String plan; //지구단위계획구역, 도시 군 관리계획

    @Column(name = "etc")
    @NotNull
    private String etc; //그 밖의 이용제한 및 거래 규제사항

    //==취득 시 부담한 조세의 종류 및 세율==//
    @Column(name = "acquisition_tax")
    @NotNull
    private Integer acquisitionTax; //취득세

    @Column(name = "fram_tax")
    @NotNull
    private Integer framTax; //농어촌특별세

    @Column(name = "local_tax")
    @NotNull
    private Integer localTax; //지방교육세

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @NotNull
    @LastModifiedDate
    private LocalDateTime updatedAt;


    @Builder
    public Basic(Long basicId, String ownershipLand, String noOwnershipLand, String ownershipBuilding, String noOwnershipBuilding,
                 String useArea, String useDistrict, String useSection, String planFacility, boolean permittedArea,
                 SpeculativeArea speculativeArea, String plan, String etc, Integer acquisitionTax, Integer framTax, Integer localTax) {
        this.basicId = basicId;
        this.ownershipLand = ownershipLand;
        this.noOwnershipLand = noOwnershipLand;
        this.ownershipBuilding = ownershipBuilding;
        this.noOwnershipBuilding = noOwnershipBuilding;
        this.useArea = useArea;
        this.useDistrict = useDistrict;
        this.useSection = useSection;
        this.planFacility = planFacility;
        this.permittedArea = permittedArea;
        this.speculativeArea = speculativeArea;
        this.plan = plan;
        this.etc = etc;
        this.acquisitionTax = acquisitionTax;
        this.framTax = framTax;
        this.localTax = localTax;
    }

    // 다음과 같이 of 메서드 추가
    public static Basic of(RequestBasicDto requestBasicDto) {
        return Basic.builder()
                .ownershipLand(requestBasicDto.getOwnershipLand())
                .noOwnershipLand(requestBasicDto.getNoOwnershipLand())
                .ownershipBuilding(requestBasicDto.getOwnershipBuilding())
                .noOwnershipBuilding(requestBasicDto.getNoOwnershipBuilding())
                .useArea(requestBasicDto.getUseArea())
                .useDistrict(requestBasicDto.getUseDistrict())
                .useSection(requestBasicDto.getUseSection())
                .planFacility(requestBasicDto.getPlanFacility())
                .permittedArea(requestBasicDto.isPermittedArea())
                .speculativeArea(requestBasicDto.getSpeculativeArea())
                .plan(requestBasicDto.getPlan())
                .etc(requestBasicDto.getEtc())
                .acquisitionTax(requestBasicDto.getAcquisitionTax())
                .framTax(requestBasicDto.getFramTax())
                .localTax(requestBasicDto.getLocalTax())
                .build();
    }


}
