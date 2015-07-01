<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
 <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new Member</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

<table>
		<tr>
			<td>
				<form method="get" action="memberController">
					<button type="submit" value="memberDetails">Member</button>
				</form>
			</td>
			<td>
				<form method="get" action="bookController">
					<button type="submit" value="bookDetails">Book</button>
				</form>
			</td>
			<td>
				<form method="get" action="transactionController">
					<button type="submit" value="transactionDetails">Transaction</button>
				</form>
			</td>
			<td>
				<form method="get" action="logoutController">
					<button type="submit" value="logout">Logout</button>
				</form>
			</td>
		</tr>
	</table>
    <form method="POST" action='listMemberController' name="frmAddUser">
        User ID : <input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.userid}" />" /> <br /> 
        First Name : <input
            type="text" name="firstName"
            value="<c:out value="${user.firstName}" />" /> <br /> 
        Last Name : <input
            type="text" name="lastName"
            value="<c:out value="${user.lastName}" />" /> <br /> 
        DOB : <input
            type="text" name="dob"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br /> 
        Email : <input type="text" name="email"
            value="<c:out value="${user.email}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>