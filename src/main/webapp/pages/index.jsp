<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<%@include file="Head.jsp"%>

<body class="bg-light">

	<div class="container mt-4">
		<h3 class="display-5 text-center">Welcome to TODO Application.</h3>

		<div class="row mt-3">
			<div class="col-md-2">
				<div class="list-group">
					<a href="<c:url value="/home"/>"
						class="list-group-item list-group-item-action  <c:if test="${page=='home'}"><c:out value="active"/></c:if>"
						aria-current="true"> Home </a> <a
						href="<c:out value="/hibernate/add"/>"
						class="list-group-item list-group-item-action <c:if test="${page=='add'}"><c:out value="active"/></c:if>">Add
						TODO</a> <a class="list-group-item list-group-item-action">View
						TODO</a>
				</div>
			</div>
			<div class="col-md-10">
				<c:if test="${page=='home'}">
					<ul class="list-group">
						<c:forEach var="todo" items="${todos}">
							<li class="list-group-item">
								<h3><c:out value="${todo.getTitle()}"/></h3>
								<small><c:out value="${todo.getDate()}"/></small>
								<hr/>
								
								<p><c:out value="${todo.getContent()}"/></p>
							</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${page=='add'}">
					<form class="card p-5" action="/hibernate/saveTodo" method="post">
						<div class="my-2">
							<label for="title">Title : </label> <input type="text"
								name="title" class="form-control" id="title" />
						</div>
						<div class="my-2">
							<label for="content">Content: </label>
							<textarea name="content" class="form-control" rows="5"></textarea>
						</div>
						<div class="my-2">
							<button class="btn btn-primary form-control" type="submit">Add Todo</button>
						</div>
					</form>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>