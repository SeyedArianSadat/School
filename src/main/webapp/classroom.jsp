<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Classes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body { background:#f5f6f8 }
    .box {
      background:white;
      padding:25px;
      border-radius:10px;
      box-shadow:0 2px 10px rgba(0,0,0,.1)
    }
    .delete { color:red; font-weight:bold }
  </style>
</head>
<body>

<div class="container mt-5">
  <div class="box">

    <h4>Student classes</h4>
    <small class="text-muted">
      List of grades, subjects and Zoom links.
    </small>

    <input class="form-control my-3"
           placeholder="Search by grade or class name"
           disabled>

    <table class="table table-hover">
      <thead class="table-light">
      <tr>
        <th>ID</th>
        <th>Grade</th>
        <th>Class name</th>
        <th>Zoom link</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="c" items="${classList}">
        <tr>
          <td>${c.classroomId}</td>
          <td>${c.grade}</td>
          <td>${c.classSubject}</td>
          <td>
            <a href="${c.zoomLink}" target="_blank">
                ${c.zoomLink}
            </a>
          </td>
          <td>
            <a href="classrooms?action=delete&id=${c.classroomId}"
               class="delete">
              Delete
            </a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

    <!-- ADD CLASS -->
    <form action="classrooms" method="post" class="row g-2 mt-3">
      <div class="col-md-2">
        <input name="grade" type="number"
               class="form-control"
               placeholder="Grade" required>
      </div>
      <div class="col-md-4">
        <input name="subject"
               class="form-control"
               placeholder="Class name" required>
      </div>
      <div class="col-md-4">
        <input name="zoomLink"
               class="form-control"
               placeholder="https://zoom.us/..." required>
      </div>
      <div class="col-md-2">
        <button class="btn btn-primary w-100">
          Add
        </button>
      </div>
    </form>

  </div>
</div>

</body>
</html>

