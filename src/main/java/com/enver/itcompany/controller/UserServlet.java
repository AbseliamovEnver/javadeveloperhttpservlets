package com.enver.itcompany.controller;

import com.enver.itcompany.dao.TeamDaoImpl;
import com.enver.itcompany.dao.UserDaoImpl;
import com.enver.itcompany.model.Team;
import com.enver.itcompany.model.User;
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

@WebServlet(name = "UserServlet",
        urlPatterns = {"/insertUser", "/listUser", "/updateUser", "/editUser", "/deleteUser"})
public class UserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(UserServlet.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private UserDaoImpl userDao;
    private TeamDaoImpl teamDao;

    public UserServlet() {
    }

    public void init() {
        userDao = new UserDaoImpl(User.class.getSimpleName(), sessionFactory, User.class);
        teamDao = new TeamDaoImpl(Team.class.getSimpleName(), sessionFactory, Team.class);
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
                case "/insertUser":
                    insertUser(request, response);
                    break;
                case "/listUser":
                    listUser(request, response);
                    break;
                case "/updateUser":
                    updateUser(request, response);
                    break;
                case "/editUser":
                    editUser(request, response);
                    break;
                case "/deleteUser":
                    deleteUser(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            logger.error("ServletException a doPost method in UserServlet class ", e);
        } catch (IOException e) {
            logger.error("IOException a doPost method in UserServlet class ", e);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        long teamId = Long.parseLong(request.getParameter("team_id"));
        Team team = teamDao.getById(teamId);
        User user = new User(firstName, lastName, team);
        userDao.add(user);
        response.sendRedirect("listUser");
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> listUser = userDao.getAll().stream()
                .sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long userId = Long.parseLong(request.getParameter("user_id"));
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        long teamId = Long.parseLong(request.getParameter("team_id"));
        Team team = teamDao.getById(teamId);
        User user = new User(userId, firstName, lastName, team);
        userDao.update(user);
        response.sendRedirect("listUser");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long userId = Long.parseLong(request.getParameter("user_id"));
        User user = userDao.getById(userId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long userId = Long.parseLong(request.getParameter("user_id"));
        userDao.remove(userId);
        response.sendRedirect("listUser");
    }
}
