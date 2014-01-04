<%@ include file="include/header-signed-in.jsp" %>
    
    <section id="main-actions" class="grid-container grid-parent">
        <div class="grid-30 push-70 action-right">
            <a class="play button large mobile-grid-100">I Want To Play</a>
        </div>
        <div class="grid-30 pull-30 action-left">
            <a class="play button large mobile-grid-100">My Game Schedule</a>
        </div>
    </section>
    
    <div class="grid-container grid-parent">
        <nav class="grid-30 hide-on-mobile">
            <ul class="side small-icons">
                <li>Gamer Profile</li>
                <li>Recent Games</li>
                <li>Game Collection</li>
                <li>Play Groups</li>
                <li>Rankings</li>
            </ul>
        </nav>
        
        <section class="prefix-10 grid-60">
            <div class="content">Content</div>
        </section>
    </div>

<c:set var="mainJsFileLocation" value="main/home-main" />
<%@ include file="include/footer-signed-in.jsp" %>