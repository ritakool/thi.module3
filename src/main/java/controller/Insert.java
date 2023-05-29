package controller;


import Dao.DAOStaff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String sName = req.getParameter("name");
        String sEmail = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        int salary = Integer.parseInt(req.getParameter("salary"));
        int department = Integer.parseInt(req.getParameter("department"));

        DAOStaff daoStaff = new DAOStaff();
        daoStaff.addStaff(sName, sEmail, address, phoneNumber, salary, department);

        resp.sendRedirect("list.jsp");
    }
}
