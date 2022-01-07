<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<p><a href="AddGame">Add Game</a></p>
<table border="1">
<tr><th>Game</th><th>Rating</th><th>   </th></tr>
<c:forEach items="${games}" var="game">
  <tr>
  		<td><a href=DisplayReview?id=${game.id}>${game.title}</a></td><td>${game.getAvg()}</td><td><a href="CreateReview?id=${game.id}">Review</a></td>
  </tr>
</c:forEach>
</table>
</body>
</html>