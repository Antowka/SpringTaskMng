<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 4/22/15
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Spring Task Manager</title>
  <script src="js/libs/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>

<body ng-app="springTaskManager">

    <div class="container" ng-controller="loginController">
       <form ng-submit="login()" class="col-md-3 col-md-offset-4 login-form">
          <input ng-model="signin.login" class="form-control" type="text" placeholder="Login" value="antowka">
          <input ng-model="signin.password" class="form-control" type="password" placeholder="Password" value="qty901">
          <button type="submit" class="btn btn-primary">Login</button>
       </form>
    </div>

  <footer>
    <script src="js/libs/bootstrap.min.js"></script>
    <script src="js/libs/angular.min.js"></script>
    <script src="js/controllers/loginController.js"></script>
    <script src="js/services/socketService.js"></script>
    <script src="js/app.js"></script>
  </footer>

</body>
</html>
