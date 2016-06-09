<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<!-- Arquivos de folha de estilo CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
<!-- Arquivos Javascript -->
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/a.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/snap.svg/0.1.0/snap.svg-min.js"></script>

</head>
<body>


<script type="text/javascript" src="//cdn.jsdelivr.net/snap.svg/0.1.0/snap.svg-min.js"></script>

<div class="container">
	<div class="row">
        <div class="col-md-12">
            <h2>Create your snippet's HTML, CSS and Javascript in the editor tabs</h2>
        </div>
	</div>
    <div class="row">
        <div class="col-md-3">
          <ul data-pie-id="svg">
            <li data-value="60">Water Buffalo (60)</li>
            <li data-value="20">Bison (20)</li>
            <li data-value="12">Sheep (12)</li>
            <li data-value="32">Goat (32)</li>
            <li data-value="50">Shetland Pony (50)</li>
          </ul>
        </div>
        <div class="col-md-3">
          <div id="svg"></div>
        </div>
        <div class="col-md-3">
          <ul data-pie-id="my-cool-chart" data-options='{"donut": "true"}'>
              <li data-value="36">Pepperoni</li>
              <li data-value="14">Sausage</li>
              <li data-value="8">Cheese</li>
              <li data-value="11">Mushrooms</li>
              <li data-value="7">Chicken</li>
              <li data-value="24">Other</li>
            </ul>
            
        </div>
        <div class="col-md-3">
            <div id="my-cool-chart"></div>
        </div>
    </div>
</div>

</body>
</html>