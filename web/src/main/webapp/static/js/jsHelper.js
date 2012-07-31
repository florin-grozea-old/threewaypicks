$(document).ready(function () {
    jsHelper.decorateControlGroupWithError();
});


jsHelper={};
jsHelper.decorateControlGroupWithError = function () {

    $('.help-inline').parents(".control-group").addClass('error');

    $("input[type=text], textarea").keyup(function () {
        $(this).parents(".control-group").removeClass("error");
        $(this).parents(".control-group").find("span.help-inline").remove();
    });
};