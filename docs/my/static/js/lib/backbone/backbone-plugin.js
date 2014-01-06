define([
    'backbone-lib'
], function(Backbone) {
    /* Provide a convenience method to call methods on parents
     * Will start with the supplied parent class and move up the inheritance chain until it finds the supplied method
     * i.e.  this._super('initialize');
     * or    this._super('set', [{ name:'Override' }, { silent: true }]);
     */
    var _super = function(methodName) {
        var method = this.constructor.__super__[methodName];
        if(method != null) return method.apply(this, _.rest(arguments));
        else console.error('Attempted to call method \'' + methodName + '\'. Method doesn\'t exist on parents');
    };
    
    Backbone.Model.prototype._super = _super;
    Backbone.Collection.prototype._super = _super;
    Backbone.View.prototype._super = _super;
    
    /*
     * This method should be called on a view if it's no longer in use and can be initialized again
     */
    Backbone.View.prototype.close = function() {
        this.remove();
        this.closeSubViews();
        Backbone.Validation && Backbone.Validation.unbind(this);
        if(this.timers !== undefined) {
            _.each(this.timers, function(timer) {
                clearInterval(timer);
            });
        }
        this.timers && (this.timers.length = 0);
        this.afterClose && this.afterClose();
    };
    
    /* 
     * Provide a series of methods for registering and cleaning up child views
     */
    Backbone.View.prototype.registerSubView = function(newSubView) {
        if(!this.subViews) { this.subViews = new Array(); }
        
        // Do a check to see if this sub view is already registered
        if(_.some(this.subViews, function(view) { return view.cid === newSubView.cid; }) === false) {
            // This view is not present in the current sub view array, go ahead and add it
            this.subViews.push(newSubView);
        }
    };
    
    /*
     * This method should be called on a view if it needs to cleanup the sub views
     */
    Backbone.View.prototype.closeSubViews = function() {
        if(this.subViews && this.subViews.length > 0) {
            // Call the close function on all subviews
            _.invoke(this.subViews, 'close');
            this.subViews.length = 0;
        }
    };
    
    /*
     * Override Backbone.sync to use the PUT HTTP method for PATCH requests when including { patch: true } as an option;
     */
    var originalSync = Backbone.sync;
    Backbone.sync = function(method, model, options) {
        if(method === 'patch') options.type = 'PUT';
        return originalSync(method, model, options);
    };
    
    return Backbone;
});