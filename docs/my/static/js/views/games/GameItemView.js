define([
    'hbs!templates/games/game-item',
    'backbone'
], function(gameItemTemplate, Backbone) {
    return Backbone.View.extend({
        render: function() {
            this.$el.empty();
            this.$el.append(gameItemTemplate(this.model.toJSON()));
            
            return this;
        }
    });
});