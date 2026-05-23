<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <title>Jobs</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body{
            background:#f5f7fa;
        }

        .container-box{
            background:white;
            padding:30px;
            border-radius:10px;
            box-shadow:0px 0px 10px rgba(0,0,0,0.1);
        }

    </style>

</head>

<body>

<div class="container mt-5">

    <div class="container-box">

        <div class="d-flex justify-content-between align-items-center mb-4">

            <h2>Available Jobs</h2>

            <a href="/"
               class="btn btn-dark">

                Dashboard

            </a>

        </div>

        <!-- Success Message -->

        <c:if test="${not empty message}">

            <div class="alert alert-success">

                ${message}

            </div>

        </c:if>

        <!-- Jobs Table -->

        <table class="table table-bordered table-hover">

            <thead class="table-dark">

            <tr>

                <th>ID</th>

                <th>Title</th>

                <th>Company</th>

                <th>Location</th>

                <th>Skills</th>

                <th>Action</th>

            </tr>

            </thead>

            <tbody>

            <c:forEach items="${jobs}" var="job">

                <tr>

                    <td>${job.id}</td>

                    <td>${job.title}</td>

                    <td>${job.company}</td>

                    <td>${job.location}</td>

                    <td>${job.skillsRequired}</td>

                    <td>

                        <form action="/apply-job"
                              method="post">

                            <input type="hidden"
                                   name="jobId"
                                   value="${job.id}">

                            <button type="submit"
                                    class="btn btn-success btn-sm">

                                Apply

                            </button>

                        </form>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>