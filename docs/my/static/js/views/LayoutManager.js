define([
    'views/MainHeaderView',
    'views/MainActionsView',
    'views/pages/HomePageView',
    'views/pages/ProfilePageView',
    'views/pages/RecentGamesPageView',
    'views/pages/GameCollectionPageView',
    'views/pages/GameGroupsPageView',
    'views/pages/RankingsPageView',
    'backbone'
], function(MainHeaderView, MainActionsView, HomePageView, ProfilePageView, RecentGamesPageView, GameCollectionPageView, GameGroupsPageView, RankingsPageView, Backbone) {
    return Backbone.View.extend({
        el: $('body'),
        initialize: function() {
            _.bindAll(this, 'doneLoading');
            
            this.$progress = $('.progress-bar .completed', this.$el);
        },
        events: {
            
        },
        renderHeader: function() {
            var header = new MainHeaderView();
            this.registerSubView(header);
        },
        renderMainActions: function() {
            var mainActions = new MainActionsView();
            this.registerSubView(mainActions);
        },
        loadView: function(viewName) {
            var thisView = this;
            
            var PageView;
            switch(viewName) {
                case 'PROFILE': PageView = ProfilePageView; break;
                case 'RECENT_GAMES': PageView = RecentGamesPageView; break;
                case 'GAME_COLLECTION': PageView = GameCollectionPageView; break;
                case 'GAME_GROUPS': PageView = GameGroupsPageView; break;
                case 'RANKINGS': PageView = RankingsPageView; break;
                case 'HOME':
                default: PageView = HomePageView;
            }
            
            this.newPageView = new PageView();
            // Page loading animation
            this.$progress.show();
            var progress = 0;
            this.progressInterval && clearInterval(this.progressInterval);
            this.progressInterval = setInterval(function() {
                progress += 10;
                progress >= 90 && (progress = 90);
                thisView.$progress.css({ width: progress + '%' });
            }, 3000/10);
            this.newPageView.load(this.doneLoading);
        },
        doneLoading: function() {
            clearInterval(this.progressInterval);
            this.$progress.one($.support.transition.end, function () {
                $(this).hide().css({ width: '0%' });
            });
            this.$progress.css({ width: '100%' });
            this.hideCurrentView();
            this.currentPageView = this.newPageView;
            this.newPageView = undefined;
            this.showCurrentView();
        },
        hideCurrentView: function() {
            if(this.currentPageView) {
                this.currentPageView.close();
            }
        },
        showCurrentView: function() {
            var thisView = this;
            
            $('#page-content', this.$el).append(this.currentPageView.$el);
            this.currentPageView.render();
            _.defer(function() { thisView.currentPageView.$el.addClass('shown'); });
        },
        render: function() {
            this.renderHeader();
            this.renderMainActions();
            
            return this;
        }
    });
});