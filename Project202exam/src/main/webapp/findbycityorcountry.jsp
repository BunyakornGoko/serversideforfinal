<%--
  Created by IntelliJ IDEA.
  User: bunyakorngoko
  Date: 18/11/2023 AD
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Find by City or Country</title>
    <!-- Include Bootstrap CSS from CDN or your local copy -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 5rem;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="FindbycityorcountryServlet" method="post">
                <div class="form-group">
                    <label for="findcitycountry">Find by city or country:</label>
                    <input type="text" class="form-control" id="findcitycountry" name="findcitycountry">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>

    <c:if test="${input != null}">
        <div class="row mt-4">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Office Code</th>
                        <th>Address Line 1</th>
                        <th>Address Line 2</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Country</th>
                        <th>Postal Code</th>
                        <th>Phone</th>
                        <th>Territory</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${officelist}" var="office">
                        <tr>
                            <td>${office.officeCode}</td>
                            <td>${office.addressLine1}</td>
                            <td>${office.addressLine2}</td>
                            <td>${office.city}</td>
                            <td>${office.state}</td>
                            <td>${office.country}</td>
                            <td>${office.postalCode}</td>
                            <td>${office.phone}</td>
                            <td>${office.territory}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>
</div>

<!-- Include Bootstrap JS and Popper.js from CDN or your local copies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
