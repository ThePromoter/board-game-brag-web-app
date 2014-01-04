require([
    'views/LayoutManager'
],
function(LayoutManager) {
    var Page = LayoutManager.extend({
        render: function() {
            this._super('render');
            
            return this;
        }
    });
    
    (new Page()).render();
});