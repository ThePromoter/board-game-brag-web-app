define([
    'backbone'
], function(Backbone) {
    return Backbone.View.extend({
        el: $('header'),
        initialize: function() {
            
        },
        events: {
            'pointerup .profile'    : 'loadProfilePage',
            'pointerup .history'    : 'loadHistoryPage',
            'pointerup .collection' : 'loadGameCollectionPage',
            'pointerup .groups'     : 'loadGameGroupsPage',
            'pointerup .rankings'   : 'loadRankingsPage',
            'pointerup .toggle-nav' : 'toggleNavDrawer'
        },
        toggleNavDrawer: function() {
            $('#main-nav', this.$el).toggleClass('show');
        },
        selectPage: function(selector) {
            $('#main-nav', this.$el).removeClass('show');
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