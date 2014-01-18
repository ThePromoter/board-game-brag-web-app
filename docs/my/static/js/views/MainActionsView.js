define([
    'models/GameSession',
    'views/popups/ScheduleGamePopupView',
    'backbone'
], function(GameSession, ScheduleGamePopupView, Backbone) {
    return Backbone.View.extend({
        el: $('#main-actions'),
        events: {
            'click .play'     : 'showPlayPopup',
            'click .calendar' : 'showCalendar'
        },
        showPlayPopup: function() {
            var gameSession = new GameSession();
            
            var scheduleGamePopup = new ScheduleGamePopupView({
                model: gameSession
            });
            scheduleGamePopup.render();
        },
        showCalendar: function() {
            
        },
        render: function() {
            return this;
        }
    });
});