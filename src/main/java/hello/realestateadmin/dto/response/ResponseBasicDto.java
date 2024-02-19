package hello.realestateadmin.dto.response;

import hello.realestateadmin.domain.constant.SpeculativeArea;
import hello.realestateadmin.domain.entity.Basic;
import hello.realestateadmin.domain.entity.Manager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseBasicDto {
    private final long id;

    //==권리관계==//
    // 소유권에 관한 사항
    private final String ownershipLand;
    private final String noOwnershipLand;
    private final String ownershipBuilding;
    private final String noOwnershipBuilding;

    // 민간 임대 등록 여부
    //등록

    //미등록

    //계약갱신 요구권 행사 여부

    //다가구주택확인서류 제출 여부

    //==토지이용계획==//
    private final String useArea;
    private final String useDistrict;
    private final String useSection;
    private final String planFacility;
    private final boolean permittedArea;
    private final SpeculativeArea speculativeArea;
    private final String plan;
    private final String etc;

    //==취득 시 부담한 조세의 종류 및 세율==//
    private final Integer acquisitionTax;
    private final Integer framTax;
    private final Integer localTax;

    public static ResponseBasicDto from(Basic basic) {
        return new ResponseBasicDto( basic.getBasicId(),
                basic.getOwnershipLand(),
                basic.getNoOwnershipLand(),
                basic.getOwnershipBuilding(),
                basic.getNoOwnershipBuilding(),
                basic.getUseArea(),
                basic.getUseDistrict(),
                basic.getUseSection(),
                basic.getPlanFacility(),
                basic.isPermittedArea(),
                basic.getSpeculativeArea(),
                basic.getPlan(),
                basic.getEtc(),
                basic.getAcquisitionTax(),
                basic.getFramTax(),
                basic.getLocalTax());
    }
}
