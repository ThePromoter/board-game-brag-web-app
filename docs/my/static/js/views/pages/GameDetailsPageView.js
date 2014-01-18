define([
    'hbs!templates/games/game-details',
    'models/Game',
    'models/GameSession',
    'views/popups/ScheduleGamePopupView',
    'views/pages/BasePageView'
], function(gameDetailsTemplate, Game, GameSession, ScheduleGamePopupView, BasePageView) {
    return BasePageView.extend({
        className: 'content',
        initialize: function(options) {
            this.model = new Game({
                gameId: options.gameId
            });
        },
        events: {
            'pointerup .back'            : 'goBack',
            'pointerup #game-image-main' : 'toggleImageBannerSize',
            'pointerup .play'            : 'playGame'
        },
        goBack: function() {
            Backbone.history.navigate('game-library' , true);
        },
        toggleImageBannerSize: function() {
            $('#game-image-main', this.$el).toggleClass('expand');
        },
        playGame: function() {
            var gameSession = new GameSession();
            gameSession.addGame(this.model);
            
            var scheduleGamePopup = new ScheduleGamePopupView({
                model: gameSession
            });
            scheduleGamePopup.render();
        },
        load: function(afterLoad) {
            var loaded = _.after(1, afterLoad);
            
            this.model.fetch({
                silent: true,
                success: loaded
            });
        },
        render: function() {
            this.$el.empty();
            this.$el.append(gameDetailsTemplate(this.model.toJSON()));
            
            return this;
        }
    });
});