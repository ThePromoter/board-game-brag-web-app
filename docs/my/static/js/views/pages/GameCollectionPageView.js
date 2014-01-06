define([
    'collections/Games',
    'views/games/GameItemView',
    'views/pages/BasePageView'
], function(Games, GameItemView, BasePageView) {
    return BasePageView.extend({
        initialize: function() {
            this.collection = new Games();
            
            this.listenTo(this.collection, 'reset', this.render);
        },
        load: function(afterLoad) {
            var loaded = _.after(1, afterLoad);
            
            this.collection.fetch({
                silent: true,
                success: loaded
            });
        },
        renderGame: function(game) {
            var gameItemView = new GameItemView({
                model: game
            });
            this.registerSubView(gameItemView);
            this.$el.append(gameItemView.$el);
            gameItemView.render();
        },
        render: function() {
            var thisView = this;
            
            _.each(this.collection.models, function(game) {
                thisView.renderGame(game);
            });
            
            return this;
        }
    });
});