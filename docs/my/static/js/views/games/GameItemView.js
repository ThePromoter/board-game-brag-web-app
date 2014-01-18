define([
    'hbs!templates/games/game-item',
    'backbone'
], function(gameItemTemplate, Backbone) {
    return Backbone.View.extend({
        tagName: 'li',
        events: {
            'click' : 'selectGame'
        },
        selectGame: function() {
            Backbone.history.navigate('game-library/' + this.model.id, true);
        },
        render: function() {
            this.$el.empty();
            this.$el.append(gameItemTemplate(this.model.toJSON()));
            
            return this;
        }
    });
});