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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CustomerServlet",
        urlPatterns = {"/insertCustomer", "/listCustomer", "/updateCustomer",
                "/editCustomer", "/deleteCustomer"})
public class CustomerServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CustomerServlet.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CustomerDaoImpl customerDao;

    public CustomerServlet() {
    }

    public void init() {
        customerDao = new CustomerDaoImpl(Customer.class.getSimpleName(), sessionFactory, Customer.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/insertCustomer":
                    insertCustomer(request, response);
                    break;
                case "/listCustomer":
                    listCustomer(request, response);
                    break;
                case "/updateCustomer":
                    updateCustomer(request, response);
                    break;
                case "/editCustomer":
                    editCustomer(request, response);
                    break;
                case "/deleteCustomer":
                    deleteCustomer(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            logger.error("ServletException a doPost method in CustomerServlet class ", e);
        } catch (IOException e) {
            logger.error("IOException a doPost method in CustomerServlet class ", e);
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        Customer customer = new Customer(name);
        customerDao.add(customer);
        response.sendRedirect("listCustomer");
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> listCustomer = customerDao.getAll().stream()
                .sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        String name = request.getParameter("name");
        Customer customer = new Customer(customerId, name);
        customerDao.update(customer);
        response.sendRedirect("listCustomer");
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        Customer customer = customerDao.getById(customerId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        customerDao.remove(customerId);
        response.sendRedirect("listCustomer");
    }
}
