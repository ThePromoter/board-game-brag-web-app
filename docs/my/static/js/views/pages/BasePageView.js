define([
    'backbone'
], function(Backbone) {
    return Backbone.View.extend({
        className: 'content grid-100',
        load: function(afterLoad) {
            setTimeout(afterLoad, 1000);
        },
        render: function() {
            this.$el.append('Test');
            
            return this;
        }
    });
});