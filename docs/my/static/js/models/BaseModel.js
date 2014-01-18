define([
    'backbone'
],
function(Backbone) {
    return Backbone.Model.extend({
        baseUrl: '/api'
    });
});