<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>DB-Portfolio | Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/Db-style.css"/>"/>
<!-- Latest compiled and minified JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>

<header>
<div class="logo"></div>
</header>
<div class="container-fluid">
<div class="row">
<div class="col-md-2 m-t-1 grey tall">
<button id="get_tables"></button>
<div id="table-container" class="tables">

</div>
</div>
<div class="col-md-8 col-md-offset-1 m-t-1 white">
<div class="row">
<div class="col-md-12 grey m-t-1"><div class="half-screen">
<form id="sql-form" action="getResults" method="POST">
<textarea id="sql-query" name="sql-query" placeholder="Sql queries here"></textarea><div id="charactersLeft">180</div>
<input type="submit" class="send-sql" value="Send SQL">
</form></div></div>
<div class="col-md-12 grey m-t1"><div class="display-db-output screen-3">output goes here...</div></div>
</div>
</div>
</div>
</div>


<script src="<c:url value="/resources/js/GrabTables.js"/>"></script>
<script src="<c:url value="/resources/js/GetTableDetails.js"/>"></script>
<script src="<c:url value="/resources/js/SendQuery.js"/>"></script>
<script src="<c:url value="/resources/js/SendData.js"/>"></script>
</body>

</html>