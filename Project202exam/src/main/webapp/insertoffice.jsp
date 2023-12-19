<%--
  Created by IntelliJ IDEA.
  User: bunyakorngoko
  Date: 18/11/2023 AD
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Insert Office</title>
  <!-- Include Bootstrap CSS from CDN or your local copy -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      padding-top: 5rem;
    }

    form {
      margin-left: auto;
      margin-right: auto;
      max-width: 400px;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin-top: 20vh;
    }

    label {
      display: block;
      margin-bottom: 10px;
      font-weight: bold;
    }

    input[type="text"] {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #4caf50;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

<div class="container">
  <form action="InsertServlet" method="post">
    <label for="officeCode">Office Code:</label>
    <input type="text" class="form-control" id="officeCode" name="officeCode">

    <label for="addressLine1">Address Line 1:</label>
    <input type="text" class="form-control" id="addressLine1" name="addressLine1">

    <label for="addressLine2">Address Line 2:</label>
    <input type="text" class="form-control" id="addressLine2" name="addressLine2">

    <label for="city">City:</label>
    <input type="text" class="form-control" id="city" name="city">

    <label for="state">State:</label>
    <input type="text" class="form-control" id="state" name="state">

    <label for="country">Country:</label>
    <input type="text" class="form-control" id="country" name="country">

    <label for="postalCode">Postal Code:</label>
    <input type="text" class="form-control" id="postalCode" name="postalCode">

    <label for="phone">Phone:</label>
    <input type="text" class="form-control" id="phone" name="phone">

    <label for="territory">Territory:</label>
    <input type="text" class="form-control" id="territory" name="territory">

    <input type="submit" class="btn btn-primary" value="Submit" >
  </form>
</div>

<!-- Include Bootstrap JS and Popper.js from CDN or your local copies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

