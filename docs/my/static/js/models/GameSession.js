define([
    'collections/Games',
    'models/BaseModel'
],
function(Games, BaseModel) {
    return BaseModel.extend({
        idAttribute: 'sessionId',
        initialize: function() {
            this.activeGames = new Games();
        },
        urlRoot: function() {
            return [this.baseUrl, 'game-session'].join('/');
        },
        addGame: function(game) {
            if(!_.some(this.activeGames.models, function(activeGame) { return activeGame.id === game.id; })) {
                game.set({ active: true });
                this.activeGames.add(game);
            }
        },
        removeGame: function(game) {
            this.activeGames.remove(game);
        },
        toJSON: function() {
            var json = BaseModel.prototype.toJSON.apply(this);
            json.gameIds = this.activeGames.pluck('gameId');
            return json;
        }
    });
});