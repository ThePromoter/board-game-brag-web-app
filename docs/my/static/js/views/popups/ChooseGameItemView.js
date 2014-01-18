define([
    'hbs!templates/popups/choose-game-item',
    'backbone'
],
function(chooseGameItemTemplate, Backbone) {
    return Backbone.View.extend({
        tagName: 'li',
        events: {
            'click' : 'enableGame'
        },
        enableGame: function() {
            this.model.set({ active: true });
            this.close();
        },
        render: function() {
            this.$el.empty();
            this.$el.append(chooseGameItemTemplate(this.model.toJSON()));
            
            return this;
        }
    });
});