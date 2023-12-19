<%--
  Created by IntelliJ IDEA.
  User: bunyakorngoko
  Date: 18/11/2023 AD
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Delete Office</title>
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
            background-color: #dc3545;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<div class="container">
    <form action="DeleteServlet" method="post">
        <label for="deletebyofficecode">Delete by Office Code:</label>
        <input type="text" class="form-control" id="deletebyofficecode" name="deletebyofficecode">

        <input type="submit" class="btn btn-danger" value="Submit">
    </form>
</div>

<!-- Include Bootstrap JS and Popper.js from CDN or your local copies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
