//헤더 스크립트

//메뉴 나타나게
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