<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <title>Upload Resume</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body{
            background:#f5f7fa;
        }

        .upload-box{
            background:white;
            padding:30px;
            border-radius:10px;
            box-shadow:0px 0px 10px rgba(0,0,0,0.1);
        }

    </style>

</head>

<body>

<div class="container mt-5">

    <div class="upload-box">

        <div class="d-flex justify-content-between align-items-center mb-4">

            <h2>Upload Resume</h2>

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

        <!-- Error Message -->

        <c:if test="${not empty error}">

            <div class="alert alert-danger">

                ${error}

            </div>

        </c:if>

        <!-- Upload Form -->

        <form action="/upload-resume"
              method="post"
              enctype="multipart/form-data">

            <div class="mb-3">

                <label class="form-label">

                    Select Resume

                </label>

                <input type="file"
                       name="file"
                       class="form-control"
                       required>

            </div>

            <button type="submit"
                    class="btn btn-primary">

                Upload Resume

            </button>

        </form>

    </div>

</div>

</body>

</html>