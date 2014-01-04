<%@ include file="include/header-signed-in.jsp" %>
    
    <section id="main-actions" class="grid-container grid-parent">
        <div class="grid-25 push-75 mobile-grid-50 mobile-push-50 action-right">
            <a class="play button large">I Want To Play</a>
        </div>
        <div class="grid-25 pull-25 mobile-grid-50 mobile-pull-50 action-left">
            <a class="play button large">My Calendar</a>
        </div>
    </section>
    
    <div class="grid-container grid-parent">
        <nav class="grid-25 hide-on-mobile">
            <ul class="side-actions small-icons">
                <li class="icon dice action">Gamer Profile</li>
                <li class="icon clock action">Recent Games</li>
                <li class="icon library action">Game Collection</li>
                <li class="icon group action">Play Groups</li>
                <li class="icon trophy action">Rankings</li>
            </ul>
        </nav>
        
        <section class="grid-75">
            <div class="content">Content</div>
        </section>
    </div>

<c:set var="mainJsFileLocation" value="main/home-main" />
<%@ include file="include/footer-signed-in.jsp" %>