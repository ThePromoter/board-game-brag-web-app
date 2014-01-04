<script>
    function destroyLessCache(pathToCss) {
        /* e.g. '/style/' or '/stylesheets/' */
        if (!window.localStorage || less.env !== 'development') {
            return;
        }

        var host = window.location.host;
        var protocol = window.location.protocol;
        var keyPrefix = protocol + '//' + host + pathToCss;
        
        if(window.localStorage) {
            for (var key in window.localStorage) {
                if (key.indexOf(keyPrefix) === 0) {
                    try {
                        window.localStorage.clear()
                        delete window.localStorage[key];
                    } catch (e) {}
                }
            }
        }
    }
    less = {};
    less.env = 'development';
    destroyLessCache('/');
</script>

<script src="/my/static/js/lib/less/less-1.6.0.js" type="text/javascript"></script>
<script src="/my/static/js/lib/require/require-2.1.9.js"></script>

<script>
    require(['/my/static/js/config.js'], function() {
        require(['<c:out value="${mainJsFileLocation}" />']);
    });       
</script>