<!-- Author: Amol Waghmare -->
<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Student Information</h2>
      <!-- By default the command name is 'command', 
      the controller still need to mention it while returning ModelAndView object. 
      -->
      <form:form method = "POST" commandName="user" action = "/springmvc//login">
         <table>
            <tr>
               <td><form:label path = "userName">User Name:</form:label></td>
               <td><form:input path = "userName" /></td>
            </tr>
            <tr>
               <td><form:label path = "password">Password :</form:label></td>
               <td><form:input path = "password" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
   
</html>