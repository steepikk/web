<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style.css">
    <style>
        body {
            background-image: url('images/bg.jpg');
            background-size: cover; 
            background-position: center; 
        }
    </style>
    <title>Results</title>
</head>

<body>

    <section class="container">

        <div class="header">
            <h1>Verification results</h1>
            <hr class="hr-shadow">
        </div>

        <div class="main">
            <p>X Coordinate: ${x}</p>
            <p>Y Coordinate: ${y}</p>
            <p>R Coordinate: ${r}</p>
            <p>Result: ${isInside}</p>
            <p>Current time: ${currentTime}</p>

            <button class="back">
                <a href="index.jsp">Go back</a>
            </button>
        </div>

        <div id="result-table">
            <jsp:useBean id="resultBean" scope="session" class="ru.itmo.web.ResultBean" />
            <c:if test="${not empty resultBean.results}">
                <table>
                    <tr>
                        <th>X</th>
                        <th>Y</th>
                        <th>R</th>
                        <th>Result</th>
                        <th>Current Time</th>
                    </tr>
                    <c:forEach var="result" items="${resultBean.results}">
                        <tr>
                            <td>${result.x}</td>
                            <td>${result.y}</td>
                            <td>${result.r}</td>
                            <td>${result.isInside}</td>
                            <td>${result.currentTime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${empty resultBean.results}">
                <p>There are no results</p>
            </c:if>
        </div>

    </section>

</body>
</html>
