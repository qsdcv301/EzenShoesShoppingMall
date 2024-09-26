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