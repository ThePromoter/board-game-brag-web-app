define([
    'backbone'
], function(Backbone) {
    return Backbone.View.extend({
        el: $('header'),
        initialize: function() {
            
        },
        events: {
            'click .profile'    : 'loadProfilePage',
            'click .history'    : 'loadHistoryPage',
            'click .collection' : 'loadGameCollectionPage',
            'click .groups'     : 'loadGameGroupsPage',
            'click .rankings'   : 'loadRankingsPage'
        },
        selectPage: function(selector) {
            $('.action', this.$el).removeClass('active');
            $(selector).addClass('active');
        },
        loadProfilePage: function() {
            Backbone.history.navigate('profile', true);
            this.selectPage('.profile');
        },
        loadHistoryPage: function() {
            Backbone.history.navigate('history', true);
            this.selectPage('.history');
        },
        loadGameCollectionPage: function() {
            Backbone.history.navigate('game-library', true);
            this.selectPage('.collection');
        },
        loadGameGroupsPage: function() {
            Backbone.history.navigate('game-groups', true);
            this.selectPage('.groups');
        },
        loadRankingsPage: function() {
            Backbone.history.navigate('rankings', true);
            this.selectPage('.rankings');
        },
        render: function() {
            return this;
        }
    });
});