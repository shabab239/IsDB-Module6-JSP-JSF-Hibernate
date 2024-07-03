
<jsp:include page="header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title</title>
</head>
<body>
	<div class="container">
		<h1 class="mb-4 mt-2 text-center">Add Employee</h1>

		<form action="employeesave.jsp" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>

			<div class="form-group">
				<label for="address">Address:</label>
				<textarea class="form-control" id="address" name="address" rows="5"
					required></textarea>
			</div>

			<div class="text-center mt-4">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>

</body>
</html>
