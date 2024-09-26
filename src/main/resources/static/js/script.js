//헤더 스크립트

//메뉴를 나타나게 하는 스크립트
$(document).ready(function () {
    $('.navbar-nav').hover(
        function () {
            $('.header-menu').stop().show();
        },
        function () {
            $('.header-menu').stop().hide();
        }
    );

    $('.header-menu').hover(
        function () {
            $(this).stop().show();
        },
        function () {
            $(this).stop().hide();
        }
    );
});

//메인페이지 상품 데크(5개 가로배열 돼 있는 곳) 버튼 누르면 이동


//카트 목록 전체선택, 선택한 목록 삭제

$(document).ready(function() {
    // 전체 선택/해제
    $('#selectAll').on('change', function() {
        $('.cart_checkbox').prop('checked', this.checked);
    });

    // 선택된 항목 삭제
    $('.cart_delete').on('click', function() {
        $('.cart_checkbox:checked').each(function() {
            $(this).closest('.cart_item').remove();  // 해당 상품을 DOM에서 제거
        });
    });
});

//카트목록의 선택한 요소들의 요약창

$(document).ready(function() {
    // 가격 정보를 저장할 변수
    var deliveryFee = 3000; // 기본 배송비 3000원
    var freeDeliveryThreshold = 50000; // 5만원 이상 무료 배송

    // 선택한 상품 가격 계산 함수
    function calculatePrices() {
        var totalPrice = 0;

        // 체크된 상품들의 가격을 합산
        $('.cart_checkbox:checked').each(function() {
            // 가격에서 '원'이나 공백 제거 후 숫자로 변환
            var itemPrice = $(this).closest('.cart_item').find('.cart_item_price').text().replace(/[^0-9]/g, '');
            itemPrice = parseFloat(itemPrice); // 문자열을 숫자로 변환
            if (!isNaN(itemPrice)) {
                totalPrice += itemPrice;
            }
        });

        // 합산한 가격을 표시
        $('.cart_total_price').text(totalPrice + '원');

        // 배송비 처리
        if (totalPrice >= freeDeliveryThreshold) {
            $('.cart_delivery_fee_section').hide(); // 배송비 삭제
        } else {
            $('.cart_delivery_fee_section').show();
            $('.cart_delivery_fee').text(deliveryFee + '원'); // 배송비 표시
        }

        // 최종 합계 계산 (배송비 추가)
        var finalTotal = totalPrice >= freeDeliveryThreshold ? totalPrice : totalPrice + deliveryFee;
        $('.cart_final_total').text(finalTotal + '원');
    }

    // 체크박스를 선택할 때마다 가격 계산
    $('.cart_checkbox').on('change', function() {
        calculatePrices();
    });

    // 초기 계산 (페이지 로드 시)
    calculatePrices();
});