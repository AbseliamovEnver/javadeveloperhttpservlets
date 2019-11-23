package com.enver.itcompany.controller;

import com.enver.itcompany.dao.CustomerDaoImpl;
import com.enver.itcompany.dao.ProjectDaoImpl;
import com.enver.itcompany.model.Customer;
import com.enver.itcompany.model.Project;
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
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ProjectServlet",
        urlPatterns = {"/insertProject", "/listProject", "/updateProject",
                "/editProject", "/deleteProject"})
public class ProjectServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ProjectServlet.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private ProjectDaoImpl projectDao;
    private CustomerDaoImpl customerDao;

    public ProjectServlet() {
    }

    public void init() {
        projectDao = new ProjectDaoImpl(Project.class.getSimpleName(), sessionFactory, Project.class);
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
                case "/insertProject":
                    insertProject(request, response);
                    break;
                case "/listProject":
                    listProject(request, response);
                    break;
                case "/updateProject":
                    updateProject(request, response);
                    break;
                case "/editProject":
                    editProject(request, response);
                    break;
                case "/deleteProject":
                    deleteProject(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            logger.error("ServletException a doPost method in ProjectServlet class ", e);
        } catch (IOException e) {
            logger.error("IOException a doPost method in ProjectServlet class ", e);
        }
    }

    private void insertProject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        BigDecimal budget = BigDecimal.valueOf(Double.parseDouble(request.getParameter("budget")));
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        Customer customer = customerDao.getById(customerId);
        Project project = new Project(name, budget, customer);
        projectDao.add(project);
        response.sendRedirect("listProject");
    }

    private void listProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Project> listProject = projectDao.getAll().stream()
                .sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
        request.setAttribute("listProject", listProject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("project-list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long projectId = Long.parseLong(request.getParameter("project_id"));
        String name = request.getParameter("name");
        BigDecimal budget = BigDecimal.valueOf(Double.parseDouble(request.getParameter("budget")));
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        Customer customer = customerDao.getById(customerId);
        Project project = new Project(projectId, name, budget, customer);
        projectDao.update(project);
        response.sendRedirect("listProject");
    }

    private void editProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long projectId = Long.parseLong(request.getParameter("project_id"));
        Project project = projectDao.getById(projectId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("project-form.jsp");
        request.setAttribute("project", project);
        dispatcher.forward(request, response);
    }

    private void deleteProject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long projectId = Long.parseLong(request.getParameter("project_id"));
        projectDao.remove(projectId);
        response.sendRedirect("listProject");
    }
}
