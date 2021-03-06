    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
     pageEncoding="ISO-8859-1"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <html>  
    <head>  
    <title>uPortal | User List</title>  
    <style>  
    body {  
     font-size: 20px;  
     color: teal;  
     font-family: Calibri;  
    }  
      
    td {  
     font-size: 15px;  
     color: black;  
     width: 100px;  
     height: 22px;  
     text-align: center;  
    }  
    .heading {  
     font-size: 18px;  
     color: white;  
     font: bold;  
     background-color: orange;  
     border: thick;  
    }  
    </style>  
    </head>  
    <body>  
     <center>  
        
       
       
     <b>User List | uPortal </b>  
       
      
         
        
      
      <table border="1">  
       <tr>  
        <td class="heading">User Id</td>  
        <td class="heading">First Name</td>  
        <td class="heading">Last Name</td>  
        <td class="heading">Email</td>  
        <td class="heading">Username</td>
        <td class="heading">Password</td>  
        <td class="heading">Edit</td>  
        <td class="heading">Delete</td>  
       </tr>  
       <c:forEach var="user" items="${userList}">  
        <tr>  
         <td>${user.userId}</td>  
         <td>${user.firstName}</td>  
         <td>${user.lastName}</td>  
         <td>${user.email}</td>  
         <td>${user.username}</td>  
         <td>${user.password}</td>
         <td><a href="edit?userid=${user.userId}">Edit</a></td>  
         <td><a href="delete?userid=${user.userId}">Delete</a></td>  
        </tr>  
       </c:forEach>  
       <tr><td colspan="7"><a href="register">Add New User</a></td></tr>  
      </table>  
      
     </center>  
    </body>  
    </html>  