<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h3><a href="ListGames">Games</a> > <a href="DisplayReview?id=${game.id}">${game.title}</a> > Add Review</h3>

<form action="CreateReview" method="post">
<input type="hidden" value="${game.id}" name="g_id">
<table>
  <tr>
    <th>Your Name:</th>
    <td><input type="text" name="name" /></td>
  </tr>
  <tr>
    <th>Your Rating:</th>
    <td>
    1
    	<input type="radio" value="1" name="rating"/>
    	<input type="radio" value="2" name="rating"/>
    	<input type="radio" value="3" name="rating"/>
    	<input type="radio" value="4" name="rating"/>
    	<input type="radio" value="5" name="rating"/>
    	<input type="radio" value="6" name="rating"/>
    	<input type="radio" value="7" name="rating"/>
    	<input type="radio" value="8" name="rating"/>
    	<input type="radio" value="9" name="rating"/>
    	<input type="radio" value="10" name="rating"/>
    10
    </td>
  <tr>
  <tr>
    <td colspan="2"><textarea rows="5" cols="60" placeholder="Your Comment" name="review"></textarea></td>
  </tr>
  <tr>
    <td colspan="2">
      <input type="submit" name="add" value="Add" />
    </td>
  </tr>
</table>
</form>
</body>
</html>