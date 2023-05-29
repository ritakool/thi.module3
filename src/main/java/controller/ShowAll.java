package controller;

import Dao.DAOStaff;
import model.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOStaff daoStaff = new DAOStaff();
        List<Staff> staffList;
        try {
            staffList = daoStaff.getListStaff();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("staffList", staffList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, resp);
    }
}


