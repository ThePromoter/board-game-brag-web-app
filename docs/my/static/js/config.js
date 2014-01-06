require.config({
    locale: 'en_us',
    
    // Specify the base JS directory
    baseUrl: '/my/static/js/',
    
    // Prevent caching while developing
//    urlArgs: 'bust=' + (new Date()).getTime(),
    
    // Set the amount of time allowed to load a script before an error is thrown (0 is unlimited)
    waitSeconds: 0,
    
    // Default plugin settings, listed here as a reference
    hbs: {
        templateExtension : 'hbs',
        disableI18n : false,
        disableHelpers: false,
        helperDirectory: 'templates/helpers/',
        i18nDirectory: 'templates/i18n/',
        debug: false
    },
    
    // Create aliases to commonly used modules
    paths: {
        // Libraries
        'backbone-lib'        : 'lib/backbone/backbone-1.1.0',
        'underscore'          : 'lib/underscore/underscore-1.5.2',
        'json2'               : 'lib/json2',
        
        // jQuery plugins
        'jquery'              : 'lib/jquery/jquery-2.0.3',
        'jquery-libs'         : 'lib/jquery/jquery-libs',
        
        // Backbone support
        'backbone'            : 'lib/backbone/backbone-plugin',
        
        // Templating
        'hbs'                 : 'lib/handlebars/hbs',
        'i18nprecompile'      : 'lib/handlebars/deps/i18nprecompile',
        'handlebars'          : 'lib/handlebars/handlebars-1.3.0'
    },
    
    // Define dependencies manually if the library doesn't support AMD
    shim: {
        'backbone-lib': {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        'jquery': {
            exports: '$'
        },
        'json2': {
            exports: 'JSON'
        },
        'handlebars': {
            exports: 'Handlebars'
        },
        'underscore': {
            exports: '_'
        }
    }
});
