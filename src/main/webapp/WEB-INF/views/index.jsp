<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Automatic Apply</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f7fa;
}

.sidebar{
    height:100vh;
    background:#212529;
    color:white;
    padding:20px;
}

.sidebar a{
    display:block;
    color:white;
    text-decoration:none;
    margin:15px 0;
}

.card-box{
    padding:20px;
    border-radius:10px;
    background:white;
    box-shadow:0px 0px 10px rgba(0,0,0,0.1);
}

</style>

</head>

<body>

<div class="container-fluid">

<div class="row">

    <!-- Sidebar -->
    <div class="col-md-2 sidebar">

        <h3><a href="/">Auto Apply</a></h3>

        <a href="/">Dashboard</a> 

        <a href="/jobs">Jobs</a>

        <a href="/applied-jobs">Applied Jobs</a>

        <a href="/upload-resume">Upload Resume</a>
		
    </div>

    <!-- Main Content -->
    <div class="col-md-10 p-4">

        <h2>Dashboard</h2>

        <div class="row mt-4">

            <div class="col-md-4">

                <div class="card-box">

                    <h4>Total Jobs</h4>

                    <h2>${totalJobs}</h2>

                </div>

            </div>

            <div class="col-md-4">

                <div class="card-box">

                    <h4>Applied Jobs</h4>

                    <h2>${appliedJobs}</h2>

                </div>

            </div>

            <div class="col-md-4">

                <div class="card-box">

                    <h4>Matched Jobs</h4>

                    <h2>${matchedJobs}</h2>

                </div>

            </div>

        </div>

    </div>

</div>

</div>

</body>
</html>