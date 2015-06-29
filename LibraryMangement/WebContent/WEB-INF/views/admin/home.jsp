<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin-Home-Page</title>
</head>
<body>
	<h2>Admin Dashboard!!</h2>


	<form method="get" action="memberController">

		Action:<select name="dashboardAction">
			<option></option>
			<option value="memberDetails">Member</option>
			<option value="bookDetails">Book</option>
			<option value="transcationDetails">Transaction</option>
		</select> 
		
		<input type="submit" value="Submit" /> 
		
	</form>
<p>Total Books : 4563 <br>
 
Total Members : 1574 <br>
 
Books Lended: 1654 <br>
  
</p>
	<!-- HTML Code -->
	<table class="GeneratedTable" border="1">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Title</th>
				<th>Member</th>
				<th>Issue Date</th>
				<th>Due Date</th>
				<th>Over Due(Days)</th>
				<th>Fine</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1001</td>
				<td>Revolution2020</td>
				<td>Krishna</td>
				<td>15-06-2015</td>
				<td>21-06-2015</td>
				<td>3</td>
				<td>3</td>
			</tr>
			<tr>
				<td>1001</td>
				<td>2States</td>
				<td>kumar</td>
				<td>23-07-2015</td>
				<td>27-08-2015</td>
				<td>6</td>
				<td>6</td>
			</tr>
			
		</tbody>
	</table>


</body>
</html>

