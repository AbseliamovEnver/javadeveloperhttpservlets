package com.enver.itcompany.controller;

import com.enver.itcompany.dao.CustomerDaoImpl;
import com.enver.itcompany.model.Customer;
import com.enver.itcompany.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServletList", urlPatterns = "/listCustomers")
public class CustomerServletList extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CustomerServletList.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        listCustomers(request, response);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        CustomerDaoImpl customerDao = new CustomerDaoImpl(
                Customer.class.getSimpleName(), sessionFactory, Customer.class);
        try {
            List<Customer> listCustomers = customerDao.getAll();
            request.setAttribute("listCustomers", listCustomers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("project-edit-form.jsp");
            dispatcher.forward(request, response);
        } catch (IOException e) {
            logger.error("IOException a doPost method in CustomerServletList class ", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        request.setAttribute("customer_id", customerId);
        listCustomers(request, response);
    }
}
