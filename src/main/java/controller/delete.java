package controller;

import Dao.DAOStaff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("pid"));
        DAOStaff dao = new DAOStaff();
        try {
            dao.deleteStaffByID(id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/list.jsp");
    }

}
