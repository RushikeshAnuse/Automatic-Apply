<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <title>Applied Jobs</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body{
            background:#f5f7fa;
        }

        .page-box{
            background:white;
            padding:30px;
            border-radius:10px;
            box-shadow:0px 0px 10px rgba(0,0,0,0.1);
        }

        .count-card{
            background:#198754;
            color:white;
            padding:20px;
            border-radius:10px;
            text-align:center;
            margin-bottom:25px;
        }

    </style>

</head>

<body>

<div class="container mt-5">

    <div class="page-box">

        <!-- Header -->

        <div class="d-flex justify-content-between align-items-center mb-4">

            <h2>Applied Jobs</h2>

            <a href="/"
               class="btn btn-dark">

                Dashboard

            </a>

        </div>

        <!-- Total Applied Jobs -->

        <div class="count-card">

            <h4>Total Applied Jobs</h4>

            <h1>${applications.size()}</h1>

        </div>

        <!-- Applications Table -->

        <table class="table table-bordered table-hover">

            <thead class="table-dark">

            <tr>

                <th>Application ID</th>

                <th>Job ID</th>

                <th>Status</th>

            </tr>

            </thead>

            <tbody>

            <c:forEach items="${applications}" var="app">

                <tr>

                    <td>${app.id}</td>

                    <td>${app.jobId}</td>

                    <td>

                        <span class="badge bg-success">

                            ${app.status}

                        </span>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>