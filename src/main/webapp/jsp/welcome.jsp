<!-- Author: Amol Waghmare -->
<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<html>
   <head>
      <title>Welcome to Spring MVC</title>
   </head>
   
   <body>
   <!-- THe  MpdelMap attribute set in @Controller -> ${user} will be available for display only if the rExpression Language is  enabled for the JSP. 
   E.g. %@page isELIgnored = "false" %
   -->
      <h2>Welcome to Spring MVC  ${user}!</h2>
      
   </body>
</html>