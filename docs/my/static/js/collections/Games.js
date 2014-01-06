define([
    'models/Game',
    'backbone'
],
function(Game, Backbone) {
    return Backbone.Collection.extend({
        model: Game,
        url: function() {
            return ['api', 'game'].join('/');
        }
    });
});