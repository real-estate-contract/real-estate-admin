$(document).ready(function() {
    $('#basicForm').submit(function(event) {
        event.preventDefault();

        // 각 입력 필드의 값을 가져와서 formData 객체에 할당
        var formData = {
            basicId: $('#basicId').val(),
            ownershipLand: $('#ownershipLand').val(),
            noOwnershipLand: $('#noOwnershipLand').val(),
            ownershipBuilding: $('#ownershipBuilding').val(),
            noOwnershipBuilding: $('#noOwnershipBuilding').val(),
            // (이하 생략)
            useArea: $('#useArea').val(),
            useDistrict: $('#useDistrict').val(),
            useSection: $('#useSection').val(),
            planFacility: $('#planFacility').val(),
            permittedArea: $('#permittedArea').prop('checked'),
            speculativeArea: $('#speculativeArea').val(),
            plan: $('#plan').val(),
            etc: $('#etc').val(),
            acquisitionTax: $('#acquisitionTax').val(),
            framTax: $('#framTax').val(),
            localTax: $('#localTax').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/manager/basic',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(data) {
                console.log('성공:', data);
                // 성공 시 추가적인 작업 수행
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log('오류:', errorThrown);
                // 오류 시 추가적인 작업 수행
            }
        });
    });
});
