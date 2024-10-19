$(document).ready(function () {
    /*********************************************************************************/
    /**********************        헤더 페이지 스크립트         ************************/
    /*********************************************************************************/
// 각 메인 메뉴에 대응하는 소메뉴 내용
    const submenuContents = {
        brand: `<div class="row justify-content-center">
                <div class="hd-navmenu col-4 d-flex mx-4 px-4 justify-content-center bg-white pt-4">
                    <div class="col-3">
                        <h5>
                            <a href="#" class="text-decoration-none pl-5" data-category="nike">NIKE</a>
                        </h5>
                        <ul class="list-unstyled pl-5">
                            <li><a href="#" data-category="nike" data-subcategory="lifestyle">LifeStyle</a></li>
                            <li><a href="#" data-category="nike" data-subcategory="running">Running</a></li>
                            <li><a href="#" data-category="nike" data-subcategory="activity">Activity</a></li>
                            <li><a href="#" data-category="nike" data-subcategory="etc">ETC</a></li>
                        </ul>
                    </div>
                    <div class="col-3">
                        <h5>
                            <a href="#" class="text-decoration-none  pl-5" data-category="adidas">ADIDAS</a>
                        </h5>
                        <ul class="list-unstyled pl-5">
                            <li><a href="#" data-category="adidas" data-subcategory="lifestyle">LifeStyle</a></li>
                            <li><a href="#" data-category="adidas" data-subcategory="running">Running</a></li>
                            <li><a href="#" data-category="adidas" data-subcategory="activity">Activity</a></li>
                            <li><a href="#" data-category="adidas" data-subcategory="etc">ETC</a></li>
                        </ul>
                    </div>
                    <div class="col-3">
                        <h5>
                            <a href="#" class="text-decoration-none pl-5" data-category="vans">VANS</a>
                        </h5>
                        <ul class="list-unstyled pl-5">
                            <li><a href="#" data-category="vans" data-subcategory="lifestyle">LifeStyle</a></li>
                            <li><a href="#" data-category="vans" data-subcategory="running">Running</a></li>
                            <li><a href="#" data-category="vans" data-subcategory="activity">Activity</a></li>
                            <li><a href="#" data-category="vans" data-subcategory="etc">ETC</a></li>
                        </ul>
                    </div>
                    <div class="col-3">
                        <h5>
                            <a href="#" class="text-decoration-none pl-5" data-category="etc">ETC</a>
                        </h5>
                        <ul class="list-unstyled pl-5">
                            <li><a href="#" data-category="etc" data-subcategory="lifestyle">LifeStyle</a></li>
                            <li><a href="#" data-category="etc" data-subcategory="running">Running</a></li>
                            <li><a href="#" data-category="etc" data-subcategory="activity">Activity</a></li>
                            <li><a href="#" data-category="etc" data-subcategory="etc">ETC</a></li>
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

// 동적 링크 설정: 메뉴 항목 클릭 시 URL에 데이터를 추가
    $('header').on('click', '[data-category]', function (event) {
        event.preventDefault(); // 기본 링크 동작 방지

        const category = $(this).data('category');
        const subcategory = $(this).data('subcategory');
        const item = $(this).data('item');

        // 카테고리 데이터가 존재하는지 확인
        if (!category) {
            console.warn('카테고리가 정의되지 않았습니다.');
            return;
        }

        // 동적 URL 생성
        let newUrl = `/products?category=${category}`;
        if (subcategory) {
            newUrl += `&subcategory=${encodeURIComponent(subcategory)}`;
        }
        if (item) {
            newUrl += `&item=${encodeURIComponent(item)}`;
        }

        // URL 리디렉션
        window.location.href = newUrl;
    });
    /*********************************************************************************/
    /**********************       헤더 페이지 스크립트 끝       ************************/
    /*********************************************************************************/


    /*********************************************************************************/
    /**********************       메인 페이지 스크립트 시작       ************************/
    /*********************************************************************************/

    //메인페이지 상품 데크(5개 가로배열 돼 있는 곳) 버튼 누르면 이동
    const visibleCount = 5; // 화면에 보일 이미지 개수
    const sliderItems = $('.slider-items');
    const cards = $('.slider-items .card');
    const totalItems = cards.length;

    // 초기 설정: 슬라이더 폭을 이미지 개수에 맞게 설정
    sliderItems.css('width', `${totalItems * 100 / visibleCount}%`);
    cards.css('width', `${100 / totalItems}%`);

    // 왼쪽 버튼 클릭 이벤트
    $('.left-btn').click(function () {
        sliderItems.prepend(sliderItems.children().last());
    });

    // 오른쪽 버튼 클릭 이벤트
    $('.right-btn').click(function () {
        sliderItems.append(sliderItems.children().first());
    });


    /*********************************************************************************/
    /**********************       메인 페이지 스크립트 끝       ************************/
    /*********************************************************************************/


    /*********************************************************************************/
    /**********************      상품 메인 페이지 스크립트 시작      ************************/
    /*********************************************************************************/

    // 현재 페이지의 URL에서 쿼리 파라미터를 가져옴
    const params = new URLSearchParams(window.location.search);

    // 'category'와 'subcategory' 파라미터 값 가져오기
    const category = params.get('category');
    const subcategory = params.get('subcategory');

    // 가져온 파라미터 값으로 페이지의 특정 요소를 업데이트하거나 버튼에 설정
    if (category) {
        console.log(`Category: ${category}`);
        $('#category-button').text(category);
    }

    if (subcategory) {
        console.log(`Subcategory: ${subcategory}`);
        $('#subcategory-button').text(subcategory);
    }

    // 동적 링크 설정: 카테고리 및 서브카테고리 버튼 클릭 시 URL에 데이터를 추가하고 리디렉트
    $(document).on('click', '#category-button, #subcategory-button', function (event) {
        event.preventDefault(); // 기본 링크 동작 방지

        const category = $(this).data('category');
        const subcategory = $(this).data('subcategory');

        // URL 생성 시 undefined 또는 렌더링되지 않은 변수가 있으면 제외
        let newUrl = `/products?category=${category}`;

        if (subcategory && subcategory !== "${subcategory}") {
            newUrl += `&subcategory=${encodeURIComponent(subcategory)}`;
        }

        // URL 리디렉션
        window.location.href = newUrl;
    });

    /*********************************************************************************/
    /**********************      상품 메인 페이지 스크립트 끝     ************************/
    /*********************************************************************************/

    /*********************************************************************************/
    /**********************      상품 디테일 페이지 스크립트 시작      ************************/
    /*********************************************************************************/

//클릭한 이미지로 이미지 변경
    $(".simg").on('click', function () {
        //클릭한 두 이미지의 src를 가져옴
        var mainImgSrc = $(".b-img img").attr('src');
        var subImgSrc = $(this).attr('src');

        //가져온 두 src값을 바꿈(이미지 이동)
        $('.b-img img').attr('src', subImgSrc);
        $(this).attr('src', mainImgSrc);
    });

    // 버튼 클릭 이벤트 처리
    $('#size-buttons .size-btn').on('click', function () {
        // 모든 버튼의 active와 faded 클래스를 초기화
        $('#size-buttons .size-btn').removeClass('active faded');

        // 클릭한 버튼에 active 클래스 추가
        $(this).addClass('active');

        // 클릭되지 않은 버튼들에 faded 클래스 추가
        $('#size-buttons .size-btn').not(this).addClass('faded');

        // 선택한 사이즈 값 가져오기
        const selectedSize = $(this).text();
        console.log('선택된 사이즈:', selectedSize);

        // 사이즈 가이드 링크에 선택한 사이즈 추가
        $('#size-guide-link').attr('href', '/size-guide?size=' + selectedSize);

        // 선택한 사이즈를 폼의 hidden input에 설정
        $('input[name="size"]').val(selectedSize);
    });

    $('form[name="addCart"]').on('submit', function (event) {
        event.preventDefault(); // 폼 제출을 막음

        // 폼 데이터를 객체로 변환
        var formData = {
            product_id: $(this).find('input[name="product_id"]').val(),
            size: $(this).find('input[name="size"]').val(),
            quantity: $(this).find('input[name="quantity"]').val()
        };

        // AJAX 요청 보내기
        $.ajax({
            url: '/addCart', // 요청을 보낼 URL
            type: 'POST', // 요청 방식
            contentType: 'application/json', // 요청 본문 형식
            data: JSON.stringify(formData), // 폼 데이터 JSON 형식으로 변환
            success: function (response) {
                alert('장바구니에 상품이 추가되었습니다!');
                // 성공 시 추가적인 동작을 여기에 추가할 수 있음
            },
            error: function (xhr, status, error) {
                alert('상품 추가에 실패했습니다: ' + xhr.responseText);
                // 실패 시 추가적인 동작을 여기에 추가할 수 있음
            }
        });
    });
    /*********************************************************************************/
    /**********************       상품 디테일 페이지 스크립트 끝       ************************/
    /*********************************************************************************/


    /*********************************************************************************/
    /**********************    회원가입 페이지 스크립트    ************************/
    /*********************************************************************************/

    // 아이디 중복 확인
    $('#checkUsername').click(function () {
        alert("아이디 중복 확인 기능은 서버 연동이 필요합니다.");
    });

    // 주소 검색
    $('#searchAddress').click(function () {
        new daum.Postcode({
            oncomplete: function (data) {
                var addr = '';
                var extraAddr = '';

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                if (data.userSelectedType === 'R') {
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    $('#addrl').val(extraAddr);
                } else {
                    $('#addrl').val('');
                }

                $('#addrf').val(data.zonecode);
                $('#addrs').val(addr);
                $('#addrt').focus();
            }
        }).open();
    });

    // 이메일 도메인 선택 또는 직접 입력
    $('#emailDomainSelect').change(function () {
        var domain = $(this).val();
        if (domain === 'direct') {
            $('#emailDomainDirect').show().val('').focus();
        } else {
            $('#emailDomainDirect').hide().val(domain);
        }
        combineEmail();
    });

    // 이메일 조합
    function combineEmail() {
        var emailId = $('#emailId').val();
        var emailDomain = $('#emailDomainDirect').val() || $('#emailDomainSelect').val();
        if (emailId && emailDomain) {
            $('#fullEmail').val(emailId + '@' + emailDomain);
        }
    }

    $('#emailId, #emailDomainDirect').on('input', combineEmail);

    // 생년월일 유효성 검사
    function validateBirthdate() {
        const birthdate = $('#birthdate').val();
        const regex = /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])$/;

        if (!regex.test(birthdate)) {
            alert("생년월일을 올바른 형식(YYYYMMDD)으로 입력해주세요.");
            $('#birthdate').val('');
            return false;
        }

        const year = parseInt(birthdate.substring(0, 4));
        const month = parseInt(birthdate.substring(4, 6));
        const day = parseInt(birthdate.substring(6, 8));
        const date = new Date(year, month - 1, day);

        if (date.getFullYear() !== year || date.getMonth() + 1 !== month || date.getDate() !== day) {
            alert("유효하지 않은 날짜입니다. 다시 확인해주세요.");
            $('#birthdate').val('');
            return false;
        }

        return true;
    }

    // 폼 제출
    $('#signupForm').submit(function (e) {
        e.preventDefault();
        combineEmail();
        var formData = {
            name: $('#name').val(),
            uid: $('#uid').val(),
            pw: $('#pw').val(),
            tel: $('#phone').val(),
            addrf: $('#addrf').val(),
            addrs: $('#addrs').val(),
            addrt: $('#addrt').val(),
            addrl: $('#addrl').val(),
            email: $('#fullEmail').val(),
            gender: $('input[name="gender"]:checked').val(),
            birthday: $('#birthdate').val()
        };
        if (validateBirthdate()) {
            $.ajax({
                url: '/register',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(formData),
                success: function (response) {
                    window.location.href = '/';
                },
                error: function (error) {
                    console.error(error);
                }
            });
        }
    });
    /*********************************************************************************/
    /**********************    회원가입  페이지 스크립트    ************************/
    /*********************************************************************************/

    /*********************************************************************************/
    /**********************    상품 장바구니 페이지 스크립트    ************************/
    /*********************************************************************************/

// 가격 정보를 저장할 변수
    var deliveryFee = 3000; // 기본 배송비 3000원
    var freeDeliveryThreshold = 50000; // 5만원 이상 무료 배송

// 선택한 상품 가격 계산 함수
    function calculatePrices() {
        var totalPrice = 0;
        var itemCount = 0;

        // 체크된 상품들의 가격을 합산
        $(".product-checkbox:checked").each(function () {
            var itemPrice = $(this)
                .closest(".product-card")
                .find(".card-text span")
                .text()
                .replace(/[^0-9]/g, ""); // 숫자 외의 문자 제거
            itemPrice = parseFloat(itemPrice); // 숫자 변환

            if (!isNaN(itemPrice)) {
                totalPrice += itemPrice;
                itemCount++;
            }
        });

        // 합산된 가격과 항목 수를 표시
        $("#item-count").text(itemCount);
        $("#total-amount").text(totalPrice.toLocaleString() + " 원");

        // 배송비 처리
        var shippingCost = totalPrice >= freeDeliveryThreshold ? 0 : deliveryFee;
        $("#shipping-cost").text(shippingCost.toLocaleString() + " 원");

        // 최종 합계 계산
        var finalTotal = totalPrice + shippingCost;
        $("#final-amount").text(finalTotal.toLocaleString() + " 원");
    }

// 전체 선택/해제 기능
    $("#select-all").on("click", function () {
        var allChecked = $(".product-checkbox:checked").length === $(".product-checkbox").length;
        $(".product-checkbox").prop("checked", !allChecked);
        calculatePrices(); // 가격 재계산
    });

// 선택된 항목 삭제
    $("#delete-selected").on("click", function () {
        var selectedProducts = [];

        $(".product-checkbox:checked").each(function () {
            var productId = $(this).closest(".product-card").find("input[name='product-id']").val();
            selectedProducts.push(productId); // 선택된 상품의 ID 저장
            $(this).closest(".product-card").remove(); // 선택된 상품 삭제
        });

        if (selectedProducts.length === 0) {
            alert("삭제할 상품을 선택해 주세요.");
            return;
        }

        // AJAX 요청으로 선택된 상품 삭제
        $.ajax({
            type: "POST",
            url: "/deleteCart",  // 서버에서 삭제 요청을 처리할 URL
            data: JSON.stringify({productIds: selectedProducts}),
            contentType: "application/json",
            success: function (response) {
                if (response.success) {
                    alert("선택된 상품이 삭제되었습니다.");
                    calculatePrices(); // 가격 재계산
                } else {
                    alert("상품 삭제에 실패했습니다.");
                }
            },
            error: function () {
                alert("서버에 오류가 발생했습니다.");
            }
        });
    });

// 체크박스 변경 시 가격 재계산
    $(".product-checkbox").on("change", function () {
        calculatePrices();
    });

// 초기 가격 계산 (페이지 로드 시)
    $(document).ready(function () {
        calculatePrices();
    });

    /*********************************************************************************/
    /**********************  상품 장바구니 페이지 스크립트 끝   ************************/
    /*********************************************************************************/

//     tou
    const allCheck = document.getElementById('allCheck');
    const termsCheck = document.getElementById('termsCheck');
    const privacyCheck = document.getElementById('privacyCheck');

    allCheck.addEventListener('change', function () {
        termsCheck.checked = this.checked;
        privacyCheck.checked = this.checked;
    });

    termsCheck.addEventListener('change', updateAllCheck);
    privacyCheck.addEventListener('change', updateAllCheck);

    function updateAllCheck() {
        allCheck.checked = termsCheck.checked && privacyCheck.checked;
    }

    document.getElementById('termsForm').addEventListener('submit', function (e) {
        e.preventDefault();
        if (termsCheck.checked && privacyCheck.checked) {
            alert('약관에 동의하셨습니다. 회원가입 페이지로 이동합니다.');
            window.location.href = '/registerOk';

        } else {
            alert('모든 약관에 동의해주세요.');
        }
    });

    /*********************************************************************************/
    /**********************  마이 페이지 스크립트   ************************/
    /*********************************************************************************/

    /********************************************************************************/
    /**********************  마이 페이지 스크립트 끝   ************************/
    /*********************************************************************************/

});
