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
        classRoomService = new ClassRoomService();
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
            req.setAttribute("classList",
                    classRoomService.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/classroom.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int grade = Integer.parseInt(req.getParameter("grade"));
        String subject = req.getParameter("subject");
        String zoomLink = req.getParameter("zoomLink");

        ClassRoom classRoom = ClassRoom.builder()
                .grade(grade)
                .classSubject(subject)
                .zoomLink(zoomLink)
                .build();

        try {
            classRoomService.save(classRoom);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("classrooms");
    }
}