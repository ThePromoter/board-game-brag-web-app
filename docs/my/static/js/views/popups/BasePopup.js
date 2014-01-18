define([
    'hbs!templates/popups/base-popup',
    'hbs!templates/popups/default-header',
    'backbone'
], function(basePopupTemplate, defaultHeaderTemplate, Backbone) {
    return Backbone.View.extend({
        container: '#page-container',
        headerTemplate: defaultHeaderTemplate,
        initialize: function() {
            _.bindAll(this, 'show', 'hide', 'windowResized', 'closePopup');
            
            $(this.container).append(basePopupTemplate({
                id: this.popupId,
                noAnimation: this.noAnimation,
                hasBackground: this.hasBackground
            }));
            this.setElement($('#' + this.popupId));
            this.header = $('.modal-header', this.$el);
            this.body = $('.modal-body', this.$el);
            this.actions = $('.modal-actions', this.$el);
            
            if(this.onEnter) {
                this.addFunctionality('ON_ENTER', this.onEnter);
            }
            
            $(window).on('resize', this.windowResized);
        },
        events: function() {
            return {
                'pointerup .dismiss'            : 'closePopup',
                'shown'                         : 'popupIsVisible',
                'hidden'                        : 'popupIsHidden',
                'heightchange .error-container' : 'adjustBodyHeight'
            };
        },
        closePopup: function(cb) {
            this.hide(cb);
        },
        show: function(cb) {
            var thisView = this;
            if(this.noAnimation) {
                this.$el.trigger('shown');
                cb && cb();
            } else {
                this.$el.one($.support.transition.end, function () {
                    thisView.$el.trigger('shown');
                    cb && cb();
                });
            }
            this.$el.removeClass('hide');
            
            $('input, textarea', this.$el).prop('disabled', true).addClass('no-disabled-style');
        },
        hide: function(cb) {
            var thisView = this;
            this.$el.one($.support.transition.end, function () {
                thisView.$el.trigger('hidden');
                cb && cb();
            });
            this.$el.addClass('hide');
        },
        popupIsVisible: function() {
            this.adjustBodyHeight();
            this.actions.removeClass('hide');
            
            $('input, textarea', this.$el).prop('disabled', false).removeClass('no-disabled-style');
        },
        windowResized: function() {
            this.adjustBodyHeight();
            // If there's an input that is currently focused, scroll to it
            var $focusedInput = $('input:focus', this.$el);
            if($focusedInput && $focusedInput.length > 0) {
                this.body[0].scrollTop = $focusedInput[0].offsetTop - this.body[0].offsetTop - 30;
            }
        },
        adjustBodyHeight: _.throttle(function() {
            var totalHeight = $(window).height(),
                $errorContainer = $('.error-container', this.$el),
                headerHeight = this.header.is(':visible') ? this.header.outerHeight() : 0,
                errorHeight = $errorContainer.is(':visible') ? $errorContainer.outerHeight() : 0,
                actionsHeight = this.actions.outerHeight() || 0;
            
//            this.body.css({
//                height: totalHeight - headerHeight - actionsHeight - errorHeight
//            });
        }, 100),
        popupIsHidden: function() {
            this.close();
            $('#modal-backdrop', this.$el).remove();
        },
        render: function() {
            if(this.headerTemplate !== undefined) {
                this.header.empty();
                this.header.append(this.headerTemplate({
                    title: this.title
                }));
            } else {
                this.header.remove();
            }
            
            if(this.bodyTemplate !== undefined) {
                this.body.empty();
                this.body.append(this.bodyTemplate({}));
            }
            
            if(this.actionsTemplate !== undefined) {
                this.actions.empty();
                this.actions.append(this.actionsTemplate({}));
            }
            
            _.defer(this.show);
            
            return this;
        },
        afterClose: function() {
            $(window).off('resize', this.windowResized);
        }
    });
});