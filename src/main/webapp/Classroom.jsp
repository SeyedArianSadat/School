<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Classes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body { background-color: #f8f9fa; }
    .container-box {
      background: white;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    table td { margin-right: 10px; }
    .delete-text { color: red; font-weight: bold; }
  </style>
</head>
<body>

<div class="container mt-5">
  <div class="container-box">

    <h2>Student Classes</h2>
    <p>List of grades, subjects, and Zoom links.</p>

    <input class="form-control mb-3" placeholder="Search by grade or class name">

    <table class="table">
      <thead class="table-light">
      <tr>
        <th>ID</th>
        <th>Grade</th>
        <th>Subject</th>
        <th>Zoom Link</th>
        <th>Action</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach var="c" items="${classList}">
        <tr>
          <td>${c.classroomId}</td>
          <td>${c.grade}</td>
          <td>${c.classSubject}</td>
          <td>${c.zoomLink}</td>
          <td>
            <a href="classrooms?action=delete&id=${c.classroomId}" class="delete-text">Delete</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>

    </table>
  </div>
</div>

</body>
</html>


