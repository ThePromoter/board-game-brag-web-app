define([
    'views/pages/BasePageView'
], function(BasePageView) {
    return BasePageView.extend({
        load: function(afterLoad) {
            this._super('load', afterLoad);
        }
    });
});