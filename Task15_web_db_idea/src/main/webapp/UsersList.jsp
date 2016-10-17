<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>users list</title>
    <link type="text/css" rel="stylesheet" href="user-list.css">
</head>
<body>


<div id="user-container">
    <form action="<c:url value="/users"/>" method="POST" accept-charset="utf-8">
        <h2> List of users </h2>
        <table id="users-table">
            <tr>
                <th></th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone number</th>
                <th>E-mail</th>
            </tr>

            <c:forEach var="user" items="${users}" varStatus="st">

                <c:choose>
                    <c:when test="${st.index %2 == 0}">
                        <c:set var="res" value="even"/>
                    </c:when>

                    <c:otherwise>
                        <c:set var="res" value="odd"/>
                    </c:otherwise>
                </c:choose>


                <tr class="${res}">
                    <td><input type="radio" name="userId" value="${user.id}"></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.phone}"/></td>
                    <td><c:out value="${user.email}"/></td>
                </tr>
            </c:forEach>
        </table>

        <table>
            <tr>
                <td><input type="submit" value="Add" name="command"/></td>
                <td><input type="submit" value="Edit" name="command"/></td>
                <td><input type="submit" value="Delete" name="command"/></td>

            </tr>
        </table>
    </form>

    <%@ include file="_FilterForm.jsp" %>
</div>


</body>
</html>