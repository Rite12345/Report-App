<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<h3 class="mb-5 pt-3">Report Application</h3>



		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>

							<form:options items="${names}" />


						</form:select></td>


					<td>Plan Status:</td>
					<td><form:select path="planStatus">

							<form:option value="">-select-</form:option>
							<form:options items="${status}" />

						</form:select></td>


					<td>Gender:</td>
					<td><form:select path="gender">

							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>

							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date"
							data-date-formate="yyyy-mm-dd" /></td>
					<td>End Date:</td>
					<td><form:input type="date" path="endDate"
							data-date-format="yyyy-mm-dd" /></td>
				</tr>
				<tr>
				<td><a href="/" class="btn btn-secondary">Reset</a></td>
					<td><input type="submit" value="search"
						class="btn btn-primary" /></td>
				</tr>

			</table>
		</form:form>
		<hr />
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Holder Name</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					
				</tr>

			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						
                      </tr>
                </c:forEach>
                <tr>
                <c:if test="${empty plans }">
               <td colspan="10" style="text-align: center"> No Record Founds</td>
                </c:if>
                </tr>
			</tbody>
		</table>
		<hr />

		Export:<a href="excel">Excel</a> <a href="pdf">PDF</a>

	</div>





















	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>