define([
    'backbone'
],
function(Backbone) {
    return Backbone.Model.extend({
        urlRoot: function() {
            return ['api', 'game'].join('/');
        }
    });
});