<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Three Way Picks</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">

    <!-- Le styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"
          type="text/css"/>
    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap-responsive.min.css"
          type="text/css"/>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->


    <%--ToDo: scripts on footer!--%>
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jQuery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jsHelper.js"></script>
</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a href="${pageContext.request.contextPath}" class="brand">Three Way Picks</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li><a href="${pageContext.request.contextPath}/bets">Bets</a></li>
                    <li><a href="#Previews">Previews</a></li>
                    <li><a href="#contact">Tipsters</a></li>
                    <li><a href="#Statistics">Statistics</a></li>
                    <li><a href="#About">About</a></li>
                </ul>
                <ul class="nav pull-right">
                    <li><a href="#">Log In</a></li>
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/bets/betForm">Place Bet</a></li>
                            <li><a href="${pageContext.request.contextPath}/bets">Update Bets</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Log out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <tiles:insertAttribute name="body"/>
    <hr>
    <footer>
        <p>&copy; Three Way Picks 2012</p>
    </footer>

</div>


<!-- /container -->

<!-- Le javascript
================================================== -->
</body>
</html>

