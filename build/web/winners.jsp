<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Indy Winners</title>
</head>
<body>
    <h1>List of Indy Winners</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Year</th>
        </tr>
        <!-- Iterate over the 'winners' list set by the servlet -->
        <c:forEach var="winner" items="${winners}">
            <tr>
                <td>${winner.id}</td>
                <td>${winner.name}</td>
                <td>${winner.year}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
