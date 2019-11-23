package com.enver.itcompany.controller;

import com.enver.itcompany.dao.SpecialtyDaoImpl;
import com.enver.itcompany.model.Specialty;
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

@WebServlet(name = "SpecialtyServlet",
        urlPatterns = {"/insertSpecialty", "/listSpecialty", "/updateSpecialty",
                "/editSpecialty", "/deleteSpecialty"})
public class SpecialtyServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(SpecialtyServlet.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private SpecialtyDaoImpl specialtyDao;

    public SpecialtyServlet() {
    }

    public void init() {
        specialtyDao = new SpecialtyDaoImpl(Specialty.class.getSimpleName(), sessionFactory, Specialty.class);
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
                case "/insertSpecialty":
                    insertSpecialty(request, response);
                    break;
                case "/listSpecialty":
                    listSpecialty(request, response);
                    break;
                case "/updateSpecialty":
                    updateSpecialty(request, response);
                    break;
                case "/editSpecialty":
                    specialtyEditForm(request, response);
                    break;
                case "/deleteSpecialty":
                    deleteSpecialty(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            logger.error("ServletException a doPost method in SpecialtyServlet class ", e);
        } catch (IOException e) {
            logger.error("IOException a doPost method in SpecialtyServlet class ", e);
        }
    }

    private void insertSpecialty(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("specialty");
        Specialty specialty = new Specialty(name);
        specialtyDao.add(specialty);
        response.sendRedirect("listSpecialty");
    }

    private void listSpecialty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Specialty> listSpecialty = specialtyDao.getAll().stream()
                .sorted(Comparator.comparing(Specialty::getId)).collect(Collectors.toList());
        request.setAttribute("listSpecialty", listSpecialty);
        RequestDispatcher dispatcher = request.getRequestDispatcher("specialty-list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateSpecialty(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long specialtyId = Long.parseLong(request.getParameter("specialty_id"));
        String name = request.getParameter("specialty");
        Specialty specialty = new Specialty(specialtyId, name);
        specialtyDao.update(specialty);
        response.sendRedirect("listSpecialty");
    }

    private void specialtyEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long specialtyId = Long.parseLong(request.getParameter("specialty_id"));
        Specialty specialty = specialtyDao.getById(specialtyId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("specialty-form.jsp");
        request.setAttribute("specialty", specialty);
        dispatcher.forward(request, response);
    }

    private void deleteSpecialty(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long specialtyId = Long.parseLong(request.getParameter("specialty_id"));
        specialtyDao.remove(specialtyId);
        response.sendRedirect("listSpecialty");
    }
}
