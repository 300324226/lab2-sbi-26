<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Process Model Entry Form</h1>
		<form method="POST" action="ValidationController">
			<div class="form-row">
				<div class="form-group col-6">
					<label for="modelName">Process Model Name</label> <input
						type="text" id="modelName" name="modelName" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="prosList">Pros:</label>
						<textarea class="form-control" id="prosList" name="prosList"
							rows="15"></textarea>
					</div>
				</div>
				<div class="col-6">
					<div class="form-group">
						<label for="consList">Cons:</label>
						<textarea class="form-control" id="consList" name="consList"
							rows="15"></textarea>
					</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-1">
					<button type="submit" class="btn btn-primary">Send</button>
				</div>
				<div class="col-3">
					<select class="form-control" id="outputType" name="outputType">
						<option value="html" selected>HTML</option>
						<option value="json">JSON</option>
						<option value="csv">CSV</option>
					</select>
				</div>
			</div>

		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>
