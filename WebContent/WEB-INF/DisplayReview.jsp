<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h3><a href="ListGames">Games</a> > ${game.title} </h3>

<c:forEach items="${game.getReviews()}" var="review">

  		 ${review.author} (${review.rating}): ${review.review} <br>
 
</c:forEach>

</body>
</html>