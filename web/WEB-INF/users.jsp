<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Management System</title>
        <link type="text/css" rel="stylesheet" href="css/stylesheet.css">
    </head>
    <body>
        <table class="table_border, center">
            <tr class="table_header">
                <th class="table_padding">Add User</th>
                <th class="table_padding">Manage Users</th>
                <c:if test="${editUser != null}">
                <th class="table_padding">Edit User</th>
                </c:if>
            </tr>
            <td>
                <form action="user" method="post">
                    <input type="text" name="email" placeholder="Email" value="${email}"><br>
                    Active: <input type="checkbox" name="active" placeholder="Active" value="true"><br>
                    <input type="text" name="fname" placeholder="Firstname" value="${firstName}"><br>
                    <input type="text" name="lname" placeholder="Lastname" value="${lastName}"><br>
                    <input type="text" name="password" placeholder="Password" value="${password}"><br>
                    <select name="role">
                        <c:forEach items="${roles}" var="role">
                            <option value ="${role.roleId}">${role.roleName}</option>
                        </c:forEach>
                    </select><br>
                    <input type="hidden" name="action" value="add">
                    <input class="add" type="submit" value="Add">
                </form>
            </td>

            <td>
                <table>
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Active</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            
                            <c:forEach items="${roles}" var="role">
                                <c:if test = "${user.role.roleId eq role.roleId}">
                                    <td>${role.roleName}</td>
                                </c:if>
                            </c:forEach>
                                    
                            <c:if test="${user.active}">
                                <td>
                                    <input type="checkbox" disabled checked>
                                </td>
                            </c:if>
                            <c:if test="${!user.active}">
                                <td>
                                    <input type="checkbox" disabled>
                                </td>
                            </c:if>
                            <td><a href="user?action=view&amp;email=${user.email}">Edit</a><br></td>
                            <td>
                                <a href="user?action=delete&amp;email=${user.email}">Delete</a><br></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td>
                <form action="user" method="post">
                    <c:if test="${editUser != null}">
                        <input type="hidden" name="editEmail" value="${editUser.email}"><br>
                        <label>Active User:</label> <input type="checkbox" name="editActive" value="true" <c:if test="${editUser.active}">checked</c:if>><br>
                        <input type="text" name="editFname" value="${editUser.firstName}"><br>
                        <input type="text" name="editLname" value="${editUser.lastName}"><br>
                        <input type="text" name="editPassword" value="${editUser.password}"><br>
                        <select name="editRole">
                            <c:forEach items="${roles}" var="role">
                                <c:if test = "${role.roleId eq editUser.role.roleId}">
                                     <option selected value ="${role.roleId}">${role.roleName}</option>
                                </c:if>
                                     
                                <c:if test = "${role.roleId ne editUser.role.roleId}">
                                    <option value ="${role.roleId}">${role.roleName}</option>
                                </c:if>
                                    
                            </c:forEach>
                        </select>
                        <br>
                        <input type="hidden" name="action" value="save">
                        <input class="save" type="submit" value="Save">
                        <br>
                        <a href="user"><input class="cancel" type="button" value="Cancel" href="user"></a>
                    </c:if>
                </form>
            </td>
        </table>
    </body>
</html>
