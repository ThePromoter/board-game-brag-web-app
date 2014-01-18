define([
    'models/Game',
    'collections/BaseCollection'
],
function(Game, BaseCollection) {
    return BaseCollection.extend({
        model: Game,
        url: function() {
            return [this.baseUrl, 'game'].join('/');
        }
    });
});