package com.school.controller;

import com.school.model.entity.ClassRoom;
import com.school.model.service.ClassRoomService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classrooms")
public class ClassRoomServlet extends HttpServlet {

    private ClassRoomService classRoomService;

    @Override
    public void init() {
        this.classRoomService = new ClassRoomService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            Long id = Long.valueOf(req.getParameter("id"));
            try {
                classRoomService.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("classrooms");
            return;
        }

        try {
            List<ClassRoom> list = classRoomService.findAll();
            req.setAttribute("classList", list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/Classroom.jsp").forward(req, resp);
    }
}
