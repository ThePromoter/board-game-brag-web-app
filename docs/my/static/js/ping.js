define([
], function() {
    return {
        message: function(message) {
            var $message = $('<div/>').addClass('notification hide').text(message);
            $('#main-content').append($message);
            $message.removeClass('hide');
            $message.css({
                marginLeft: -$message.outerWidth() / 2
            });
            setTimeout(function() {
                $message.one($.support.transition.end, function () {
                    $message.remove();
                });
                $message.addClass('hide');
            }, 3000);
        }
    };
});