define([
    'hbs!templates/popups/schedule-game-body',
    'hbs!templates/popups/schedule-game-actions',
    'collections/Games',
    'views/popups/ActiveGameItemView',
    'views/popups/ChooseGameItemView',
    'ping',
    'views/popups/BasePopup',
    'datetimepicker'
],
function(scheduleGameBody, scheduleGameActions, Games, ActiveGameItemView, ChooseGameItemView, ping, BasePopup) {
    return BasePopup.extend({
        title: 'Schedule A Game',
        popupId: 'play-game-popup',
        actionsTemplate: scheduleGameActions,
        initialize: function() {
            this._super('initialize');
            
            this.collection = new Games();
            
            this.listenTo(this.collection, 'reset', this.gamesFetched);
            this.listenTo(this.collection, 'change:active', this.toggleActiveGame);
            this.listenTo(this.model.activeGames, 'add', this.renderActiveGame);
            this.listenTo(this.model.activeGames, 'remove', this.renderChooseGame);
            
            this.collection.fetch({ reset: true });
        },
        events: function() {
            return _.extend(this._super('events'), {
                'pointerup .schedule'  : 'scheduleGame',
                'change #scheduleDate' : 'updateScheduleDate'
            });
        },
        scheduleGame: function() {
            var thisView = this;
            
            this.model.save(null, {
                success: function() {
                    thisView.closePopup(function() {
                        ping.message('Game session created!');
                    });
                }
            });
        },
        gamesFetched: function() {
            // Now that the games are fetched, render them as options
            this.renderChooseGameList();
        },
        toggleActiveGame: function(game) {
            if(game.get('active')) {
                this.model.addGame(game);
            } else {
                this.model.removeGame(game);
            }
        },
        updateScheduleDate: function(e) {
            this.model.set({ scheduleDate: $(e.target).val() });
        },
        renderActiveGame: function(game) {
            var activeGameItemView = new ActiveGameItemView({
                model: game
            });
            this.registerSubView(activeGameItemView);
            $('.active-games', this.$el).append(activeGameItemView.el);
            activeGameItemView.render();
        },
        renderActiveGameList: function() {
            var thisView = this;
            $('.active-games', this.$el).empty();
            _.each(this.model.activeGames.models, function(activeGame) {
                thisView.renderActiveGame(activeGame);
            });
        },
        renderChooseGame: function(game) {
            var chooseGameItemView = new ChooseGameItemView({
                model: game
            });
            this.registerSubView(chooseGameItemView);
            $('.choose-game-list', this.$el).append(chooseGameItemView.el);
            chooseGameItemView.render();
        },
        renderChooseGameList: function() {
            var thisView = this;
            $('.choose-game-list', this.$el).empty();
            _.each(this.collection.models, function(game) {
                if(!thisView.model.activeGames.some(function(activeGame) { return activeGame.id === game.id; })) {
                    thisView.renderChooseGame(game);
                }
            });
        },
        render: function() {
            this._super('render');
            this.body.empty();
            this.body.append(scheduleGameBody(this.model.toJSON()));
            
            this.renderActiveGameList();
            
            $('#scheduleDate', this.$el).datetimepicker({
                inline: true,
                minDate: '0',
                formatTime:'g:iA',
                scrollMonth: false,
                onChangeDateTime:function(dp, $input) {
                    $input.change();
                }
            });
            
            return this;
        }
    });
});