<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
<link rel="stylesheet" type="text/css" media="screen, projector, print" href="css/pizza.css"/>
<!-- Arquivos Javascript -->

<script type="text/javascript" src="js/a.js"></script>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/snap.svg.js"></script>
<script type="text/javascript" src="js/pizza.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script>
   $(document).ready(
		function(){
			 $(window).load(function() {
			      Pizza.init();
			      $(document).foundation();
			    });
		}	   		
   );
  </script>

</head>
<body>

<a href="index2.jsp" >AAAAAAAAAAAAA</a>

<div class="container">
	<div class="row">
	</div>
    <div class="row">
        <div class="col-md-10">
    	<h2>Lanšamento por Periodo</h2>
          <ul data-pie-id="svg">
            <li data-value="60">Water Buffalo (60)</li>
            <li data-value="20">Bison (20)</li>
            <li data-value="12">Sheep (12)</li>
            <li data-value="32">Goat (32)</li>
            <li data-value="50">Shetland Pony (50)</li>
          </ul>
        </div>
        <div class="col-md-5">
          <div id="svg"></div>
        </div>
     </div>



</body>
</html>