package hello.realestateadmin.domain.entity;

import hello.realestateadmin.domain.constant.SpeculativeArea;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    private String ownershipLand;
    private String noOwnershipLand;

    // 소유권 외의 권리 사항
    private String ownershipBuilding;
    private String noOwnershipBuilding;

    // 민간 임대 등록 여부
    //등록

    //미등록

    //계약갱신 요구권 행사 여부

    //다가구주택확인서류 제출 여부

    //==토지이용계획==//
    private String useArea; //용도지역
    private String useDistrict; //용도지구
    private String useSection; //용도구역
    private String planFacility; //도시,군 계획시설
    private boolean permittedArea; //허가, 신고 구역 여부
    @Enumerated(EnumType.STRING)
    private SpeculativeArea speculativeArea; //투기지역여부
    private String plan; //지구단위계획구역, 도시 군 관리계획
    private String etc; //그 밖의 이용제한 및 거래 규제사항

    //==취득 시 부담한 조세의 종류 및 세율==//
    private Integer acquisitionTax; //취득세
    private Integer framTax; //농어촌특별세
    private Integer localTax; //지방교육세

}
