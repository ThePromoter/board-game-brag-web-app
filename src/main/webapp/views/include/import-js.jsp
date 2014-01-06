<script src="/my/static/js/lib/require/require-2.1.9.js"></script>

<script>
    require(['/my/static/js/config.js'], function() {
        require(['jquery-libs'], function() {
            require(['<c:out value="${mainJsFileLocation}" />']);
        });
    });       
</script>