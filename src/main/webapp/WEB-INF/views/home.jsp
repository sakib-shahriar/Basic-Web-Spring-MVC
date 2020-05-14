<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href='<spring:url value="css/bootstrap/bootstrap.min.css"/>' rel="stylesheet" />
    <link href='<spring:url value="css/style.css"/>' rel="stylesheet" />
    <script src='<spring:url value="javascript/bootstrap/bootstrap.min.js"/>'></script>
    <title>Home</title>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a href="${pageContext.request.contextPath}/home" class="navbar-brand">Home</a>
    <form class="form-inline">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/logout" role="button">Log out</a>
    </form>
</nav>
<div class="alert alert-success" role="alert">${message}</div>
</body>
</html>