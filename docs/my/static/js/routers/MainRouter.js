define([
    'views/LayoutManager',
    'backbone'
],
function(LayoutManager, Backbone) {
    var MainRouter = Backbone.Router.extend({
        initialize: function() {
            this.layoutManager = new LayoutManager();
            this.layoutManager.render();
        },
        routes: {
            'profile(/*path)'      : 'profile',
            'history(/*path)'      : 'history',
            'game-library/:gameId' : 'gameDetails',
            'game-library(/*path)' : 'gameLibrary',
            'game-groups(/*path)'  : 'gameGroups',
            'rankings(/*path)'     : 'rankings',
            '*path'                : 'home'
        },
        home: function() {
            this.layoutManager.loadView('HOME');
        },
        profile: function() {
            this.layoutManager.loadView('PROFILE');
        },
        history: function() {
            this.layoutManager.loadView('RECENT_GAMES');
        },
        gameLibrary: function() {
            this.layoutManager.loadView('GAME_COLLECTION');
        },
        gameDetails: function(gameId) {
            this.layoutManager.loadView('GAME_DETAILS', {
                gameId: gameId
            });
        },
        gameGroups: function() {
            this.layoutManager.loadView('GAME_GROUPS');
        },
        rankings: function() {
            this.layoutManager.loadView('RANKINGS');
        }
    });
    
    var mainRouter = new MainRouter();
    Backbone.history.start({ pushState: true });
    
    return mainRouter;
});