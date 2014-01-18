/**
 * If photoUrl is null
 * Display the default profile imga
 * Otherwise display the photo of the profile
 * 
 *  profile_image imageUrls type="type" defaultStyle="filled"
 *   
 **/

define(['handlebars'], function (Handlebars) {
    function getImageUrl(imageUrls, type) {
        var hasHdScreen = window.devicePixelRatio > 1.5;
        return imageUrls && (hasHdScreen ? (imageUrls[type + '_HD'] || imageUrls[type]) : imageUrls[type]);
    }
    
    Handlebars.registerHelper('image', function(imageUrls, options) {
        var imageUrl = getImageUrl(imageUrls, options.hash.type);
        options.hash.defaultStyle = options.hash.defaultStyle || '';
        return new Handlebars.SafeString('<img class="' + options.hash.type + '" src="' + imageUrl + '"/>');
//        if(imageUrl) {
//            // An imageUrl for this profile photo was able to be generated, use it
//            return new Handlebars.SafeString('<div class="profile-image has-image ' + options.hash.type + ' ' + options.hash.defaultStyle + '" style="background-image: url(' + imageUrl + ')"></div>');
//        } else if(options.hash.defaultStyle) {
//            return new Handlebars.SafeString('<div class="profile-image ' + options.hash.defaultStyle + ' ' + options.hash.type + '"></div>');
//        } else {
//            return new Handlebars.SafeString('<div class="profile-image ' + options.hash.type + '"></div>');
//        }
    });
});