define([
    'models/BaseModel'
],
function(BaseModel) {
    return BaseModel.extend({
        idAttribute: 'gameId',
        defaults: {
            active: false
        },
        urlRoot: function() {
            return [this.baseUrl, 'game'].join('/');
        }
    });
});