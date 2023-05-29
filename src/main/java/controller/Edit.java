package controller;

import Dao.DAOStaff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "EditController",value = "/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        int salary = Integer.parseInt(req.getParameter("salary"));
        int department_id = Integer.parseInt(req.getParameter("department_id"));
        DAOStaff dao = new DAOStaff();

        dao.updateStaffByID(id,name,email,address,phoneNumber,salary,department_id);
        resp.sendRedirect("/list.jsp");
    }
}