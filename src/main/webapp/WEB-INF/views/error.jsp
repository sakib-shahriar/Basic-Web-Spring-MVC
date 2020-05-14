<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href='<spring:url value="css/bootstrap/bootstrap.min.css"/>' rel="stylesheet" />
    <link href='<spring:url value="css/style.css"/>' rel="stylesheet" />
    <script src='<spring:url value="javascript/bootstrap/bootstrap.min.js"/>'></script>
    <title>Error</title>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a href="#" class="navbar-brand">Home</a>
    <form class="form-inline">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login" role="button">Log in</a>
    </form>
</nav>
<div class="alert alert-danger" role="alert">${message}</div>

</body>
</html>