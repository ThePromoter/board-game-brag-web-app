define([
    'backbone'
], function(Backbone) {
    return Backbone.View.extend({
        el: $('#main-actions'),
        events: {
            'click .play'     : 'showPlayPopup',
            'click .calendar' : 'showCalendar'
        },
        showPlayPopup: function() {
            
        },
        showCalendar: function() {
            
        },
        render: function() {
            return this;
        }
    });
});