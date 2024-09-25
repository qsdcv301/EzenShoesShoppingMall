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

