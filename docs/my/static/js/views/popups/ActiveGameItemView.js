define([
    'hbs!templates/popups/active-game-item',
    'backbone'
],
function(activeGameItemTemplate, Backbone) {
    return Backbone.View.extend({
        tagName: 'li',
        events: {
            'click' : 'disableGame'
        },
        disableGame: function() {
            this.model.set({ active: false });
            this.close();
        },
        render: function() {
            this.$el.empty();
            this.$el.append(activeGameItemTemplate(this.model.toJSON()));
            
            return this;
        }
    });
});