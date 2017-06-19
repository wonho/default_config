<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<c:set var="url" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Simple menu left</title>

<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${url}/resources/css/BootSideMenu.css"/>
    
    <!--[if lt IE 9]>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv-printshiv.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style type="text/css">
        .user {
            padding: 5px;
            margin-bottom: 5px;
            text-align: center;
        }
    </style>
</head>
<body>


<div class="container">

    <div id="m_header" style="width:100%;">            
    	<%@ include file="header.jsp"%>  
    </div>

		  <div class="col-md-10">
		  	<div class="row">
		  		<div class="col-md-6">
		  			<div class="content-box-large">
		  				<div class="panel-heading">
							<div class="panel-title">New vs Returning Visitors</div>
							
							<div class="panel-options">
								<a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
								<a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
							</div>
						</div>
		  				<div class="panel-body">
		  				
		  				
		  				<div class="row">
	 			<div class="col-sm-8">
	 				<dec:body />
		   		</div>
	 		</div>	 	
		  				
		  				
		  				</div>
		  			</div>
		  		</div>
		  		</div>
	</div>

</div>
            		    

<!-- 
    <div class="jumbotron">
        <h1>BootSideMenu</h1>

        <p>A jQuery plugin to easily create a sliding menu, working on a Bootstrap based application.</p>

        <p>
            <a class="btn btn-lg btn-warning" href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=DUNFGKA32BFGE" role="button"><span
                    class="fa fa-paypal"></span> Thanks</a>
        </p>
    </div>

    <div class="row">
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="fa fa-jsfiddle"></span> How to</div>
                <div class="panel-body">
                    <p class="lead">The menu will appear on the left.</p>
                <pre>$(document).ready(function () {
    $('#test').BootSideMenu({
        side: "left"
    });
});</pre>
                    <p class="lead"> By default it remembers its last opened status and push the body while it slide. To disable these features use the options:</p>
                    <pre>remember:false</pre>
                    <pre>pushBody:false</pre>

                    <p>Watch this changes in the <a href="2-simple-right.html">next example</a>.</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="fa fa-paypal"></span> A courtesy coffee?</div>
                <div class="panel-body">
                    <p class="lead">If you appreciate my work, and you are kind to offer a coffee, I will be very satisfied.</p>

                    <p class="text-center">
                        <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=DUNFGKA32BFGE" target="_blank"><img src="../img/paypal_coffee.png"
                                                                                                                                          style="border: 0"></a></p>

                    <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top" class="text-center">
                        <input type="hidden" name="cmd" value="_s-xclick">
                        <input type="hidden" name="hosted_button_id" value="DUNFGKA32BFGE">
                        <input type="image" src="https://www.paypalobjects.com/en_US/IT/i/btn/btn_donateCC_LG.gif" border="0" name="submit"
                               alt="PayPal 챔 il metodo rapido e sicuro per pagare e farsi pagare online.">
                        <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
 -->

<!--Test -->
<div id="test">
    <div class="user">
        <img src="../img/avatar.png" alt="Esempio" class="img-thumbnail"><br>
        <a href="http://www.lombardoandrea.com" target="_blank" class="navbar-link">Andrea Lombardo</a>
    </div>

    <div class="list-group">

        <a href="#item-1" class="list-group-item" data-toggle="collapse">Item 1</a>

        <div class="list-group collapse" id="item-1">
            <a href="#" class="list-group-item">Item 1 di 1</a>
            <a href="#" class="list-group-item">Item 2 di 1</a>
            <a href="#item-1-1" class="list-group-item" data-toggle="collapse">Item 3 di 1</a>

            <div class="list-group collapse" id="item-1-1">
                <a href="#" class="list-group-item">Item 1 di 1.3</a>
                <a href="#" class="list-group-item">Item 2 di 1.3</a>
                <a href="#" class="list-group-item">Item 3 di 1.3</a>
            </div>

        </div>

        <a href="#item-2" class="list-group-item" data-toggle="collapse">Item 2</a>

        <div class="list-group collapse" id="item-2">
            <a href="#" class="list-group-item">Item 1 di 2</a>
            <a href="#" class="list-group-item">Item 2 di 2</a>
            <a href="#" class="list-group-item">Item 3 di 2</a>
        </div>

        <a href="#item-3" class="list-group-item" data-toggle="collapse">Item 3</a>

        <div class="list-group collapse" id="item-3">
            <a href="#" class="list-group-item">Item 1 di 3</a>
            <a href="#" class="list-group-item">Item 2 di 3</a>
            <a href="#item-3-1" class="list-group-item" data-toggle="collapse">Item 3 di 3</a>

            <div class="list-group collapse" id="item-3-1">
                <a href="#" class="list-group-item">Item 1 di 3.3</a>
                <a href="#" class="list-group-item">Item 2 di 3.3</a>
                <a href="#" class="list-group-item">Item 3 di 3.3</a>
            </div>

        </div>

        <a href="#item-4" class="list-group-item" data-toggle="collapse">Item 4</a>

        <div class="list-group collapse" id="item-4">
            <a href="#" class="list-group-item">Item 1 di 4</a>
            <a href="#" class="list-group-item">Item 2 di 4</a>
            <a href="#" class="list-group-item">Item 3 di 4</a>
        </div>

    </div>

</div>
<!--/Test -->


	<script src="${url}/resources/js/jquery-3.2.1.min.js"></script>
	<script src="${url}/resources/js/bootstrap.min.js"></script>	
	<script src="${url}/resources/js/BootSideMenu.js"></script>	


<script type="text/javascript">
    $(document).ready(function () {
        $('#test').BootSideMenu({
            side: "left"
        });
    });
</script>
</body>
</html>