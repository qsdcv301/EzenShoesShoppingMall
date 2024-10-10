/*********************************************************************************/
/**********************        헤더 페이지 스크립트         ************************/
/*********************************************************************************/

//메뉴를 나타나게 하는 스크립트
$(document).ready(function () {
    // 각 메인 메뉴에 대응하는 소메뉴 내용
    const submenuContents = {
        nike: `<div class="row justify-content-center">
                    <div class="col-8 d-flex mx-4 px-4 justify-content-center">
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="nike" data-subcategory="lifestyle">NIKE LifeStyle</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="nike" data-subcategory="lifestyle" data-item="시리즈 1">시리즈 1</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="lifestyle" data-item="시리즈 2">시리즈 2</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="lifestyle" data-item="시리즈 3">시리즈 3</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="lifestyle" data-item="시리즈 4">시리즈 4</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="lifestyle" data-item="시리즈 5">시리즈 5</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="nike" data-subcategory="running">Running</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="nike" data-subcategory="running" data-item="시리즈 1">시리즈 1</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="running" data-item="시리즈 2">시리즈 2</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="running" data-item="시리즈 3">시리즈 3</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="running" data-item="시리즈 4">시리즈 4</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="running" data-item="시리즈 5">시리즈 5</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="nike" data-subcategory="activity">Activity</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="nike" data-subcategory="activity" data-item="시리즈 1">시리즈 1</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="activity" data-item="시리즈 2">시리즈 2</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="activity" data-item="시리즈 3">시리즈 3</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="activity" data-item="시리즈 4">시리즈 4</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="activity" data-item="시리즈 5">시리즈 5</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="nike" data-subcategory="etc">ETC</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="nike" data-subcategory="etc" data-item="시리즈 1">시리즈 1</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="etc" data-item="시리즈 2">시리즈 2</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="etc" data-item="시리즈 3">시리즈 3</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="etc" data-item="시리즈 4">시리즈 4</a></li>
                                <li><a href="#" data-category="nike" data-subcategory="etc" data-item="시리즈 5">시리즈 5</a></li>
                            </ul>
                        </div>
                    </div>
                </div>`,
        //하단부분도 위와 같이 수정 요망 data-category만 각 회사에 맞게 수정하면 됨                
        adidas: `<div class="row justify-content-center">
                    <div class="col-8 d-flex mx-4 px-4 justify-content-center">
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="adidas" data-subcategory="lifestyle">Adidas LifeStyle</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="adidas" data-subcategory="lifestyle" data-item="시리즈 1">시리즈 1</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="adidas" data-subcategory="running">Running</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="adidas" data-subcategory="running" data-item="시리즈 1">시리즈 1</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="adidas" data-subcategory="activity">Activity</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="adidas" data-subcategory="activity" data-item="시리즈 1">시리즈 1</a></li>
                            </ul>
                        </div>
                    </div>
                </div>`,
        newbalance: `<div class="row justify-content-center">
                        <div class="col-8 d-flex mx-4 px-4 justify-content-center">
                            <div class="col-3">
                                <h5>
                                    <a href="#" class="text-decoration-none" data-category="newbalance" data-subcategory="lifestyle">NewBalance LifeStyle</a>
                                </h5>
                                <ul class="list-unstyled">
                                    <li><a href="#" data-category="newbalance" data-subcategory="lifestyle" data-item="시리즈 1">시리즈 1</a></li>
                                </ul>
                            </div>
                            <div class="col-3">
                                <h5>
                                    <a href="#" class="text-decoration-none" data-category="newbalance" data-subcategory="running">Running</a>
                                </h5>
                                <ul class="list-unstyled">
                                    <li><a href="#" data-category="newbalance" data-subcategory="running" data-item="시리즈 1">시리즈 1</a></li>
                                </ul>
                            </div>
                            <div class="col-3">
                                <h5>
                                    <a href="#" class="text-decoration-none" data-category="newbalance" data-subcategory="activity">Activity</a>
                                </h5>
                                <ul class="list-unstyled">
                                    <li><a href="#" data-category="newbalance" data-subcategory="activity" data-item="시리즈 1">시리즈 1</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>`,
        etc: `<div class="row justify-content-center">
                    <div class="col-8 d-flex mx-4 px-4 justify-content-center">
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="etc" data-subcategory="lifestyle">ETC LifeStyle</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="etc" data-subcategory="lifestyle" data-item="시리즈 1">시리즈 1</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="etc" data-subcategory="running">Running</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="etc" data-subcategory="running" data-item="시리즈 1">시리즈 1</a></li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <h5>
                                <a href="#" class="text-decoration-none" data-category="etc" data-subcategory="activity">Activity</a>
                            </h5>
                            <ul class="list-unstyled">
                                <li><a href="#" data-category="etc" data-subcategory="activity" data-item="시리즈 1">시리즈 1</a></li>
                            </ul>
                        </div>
                    </div>
                </div>`
    };


    // 메인 메뉴 항목에 마우스를 올렸을 때 소메뉴 내용을 표시
    $('.nav-item').hover(
        function () {
            const submenuType = $(this).data('submenu');
            $('.header-menu')
                .html(submenuContents[submenuType])  // 해당 메뉴에 맞는 내용으로 변경
                .stop()
                .show();  // 소메뉴를 바로 표시
        },
        function () {
            // 마우스를 메뉴 항목에서 벗어날 때는 소메뉴가 바로 사라지지 않도록
            // .header-menu로 마우스가 이동했는지를 확인
        }
    );

    // .header-menu에도 마우스 이벤트를 추가하여 유지되도록 설정
    $('.header-menu').hover(
        function () {
            $(this).stop().show();
        },
        function () {
            $(this).stop().hide();  // 마우스를 벗어나면 바로 숨김
        }
    );

    // 전체 헤더 영역에서 마우스를 벗어나면 소메뉴를 숨김
    $('header').mouseleave(function () {
        $('.header-menu').stop().hide();  // 슬라이드 없이 바로 숨김
    });

    // 동적 링크 설정: 클릭 시 URL에 데이터를 추가
    $(document).on('click', 'a[data-category]', function (event) {
        event.preventDefault(); // 기본 링크 동작 방지

        const category = $(this).data('category');
        const subcategory = $(this).data('subcategory');
        const item = $(this).data('item');

        // 동적 URL 생성
        let newUrl = `/products?category=${category}&subcategory=${subcategory}`;
        if (item) {
            newUrl += `&item=${encodeURIComponent(item)}`;
        }

        // URL 리디렉션
        window.location.href = newUrl;
    });
});


/*********************************************************************************/
/**********************       헤더 페이지 스크립트 끝       ************************/
/*********************************************************************************/

//메인페이지 상품 데크(5개 가로배열 돼 있는 곳) 버튼 누르면 이동


/*********************************************************************************/
/**********************      상품 페이지 스크립트 시작      ************************/
/*********************************************************************************/


/*********************************************************************************/
/**********************       상품 페이지 스크립트 끝       ************************/
/*********************************************************************************/


/*********************************************************************************/
/**********************    상품 장바구니 페이지 스크립트    ************************/
/*********************************************************************************/

$(document).ready(function () {
    // 가격 정보를 저장할 변수
    var deliveryFee = 3000; // 기본 배송비 3000원
    var freeDeliveryThreshold = 50000; // 5만원 이상 무료 배송

    // 선택한 상품 가격 계산 함수
    function calculatePrices() {
        var totalPrice = 0;

        // 체크된 상품들의 가격을 합산
        $('.cart_checkbox:checked').each(function () {
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
            $('.cart_delivery_fee').text('0원'); // 배송비를 0원으로 표시
        } else {
            $('.cart_delivery_fee').text(deliveryFee + '원'); // 배송비 표시
        }

        // 최종 합계 계산 (배송비 추가)
        var finalTotal = totalPrice >= freeDeliveryThreshold ? totalPrice : totalPrice + deliveryFee;
        $('.cart_final_total').text(finalTotal + '원');
    }

    // 전체 선택/해제
    $('#selectAll').on('change', function () {
        $('.cart_checkbox').prop('checked', this.checked);
        calculatePrices(); // 전체 선택/해제 후 가격 재계산
    });

    // 체크박스를 선택할 때마다 가격 계산
    $('.cart_checkbox').on('change', function () {
        calculatePrices();
    });

    // 선택된 항목 삭제
    $('.cart_delete').on('click', function () {
        $('.cart_checkbox:checked').each(function () {
            $(this).closest('.cart_item').remove();  // 해당 상품을 DOM에서 제거
        });
        calculatePrices(); // 선택된 항목 삭제 후 가격 재계산
    });

    // 초기 계산 (페이지 로드 시)
    calculatePrices();
});

/*********************************************************************************/
/**********************  상품 장바구니 페이지 스크립트 끝   ************************/
/*********************************************************************************/