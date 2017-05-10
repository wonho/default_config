<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Example ...........................</title>
    </head>
    <body>
        <div th:if="${param.error}">
            Invalid username and password.
        </div>
        <div th:if="${param.logout}">
            You have been logged out.
        </div>
        
<!--         <form th:action="@{/auth/main.do}" method="post"> -->

<!-- 
        <form action="loginProcess.do?${_csrf.parameterName}=${_csrf.token}"  method="POST"> 
 -->
        <form action="loginProcess.do"  method="POST">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
            <!-- 
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
             -->
        </form>
    </body>
</html>