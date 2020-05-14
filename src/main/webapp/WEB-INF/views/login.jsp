<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href='<spring:url value="css/bootstrap/bootstrap.min.css"/>' rel="stylesheet" />
    <link href='<spring:url value="css/style.css"/>' rel="stylesheet" />
    <script src='<spring:url value="javascript/bootstrap/bootstrap.min.js"/>'></script>
    <title>Logon</title>
</head>
<body>
<div class="container">
    <div class="form-container">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" id="password">
            </div>
            <button type="submit" value="Log in" class="btn btn-primary">Log in</button>
        </form>
    </div>
</div>
</body>
</html>