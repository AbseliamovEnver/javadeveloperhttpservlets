package com.enver.itcompany.controller;

import com.enver.itcompany.dao.ProjectDaoImpl;
import com.enver.itcompany.dao.TeamDaoImpl;
import com.enver.itcompany.model.Project;
import com.enver.itcompany.model.Team;
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

@WebServlet(name = "TeamServlet",
        urlPatterns = {"/insertTeam", "/listTeam", "/updateTeam", "/editTeam", "/deleteTeam"})
public class TeamServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(TeamServlet.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private TeamDaoImpl teamDao;
    private ProjectDaoImpl projectDao;

    public TeamServlet() {
    }

    public void init() {
        teamDao = new TeamDaoImpl(Team.class.getSimpleName(), sessionFactory, Team.class);
        projectDao = new ProjectDaoImpl(Project.class.getSimpleName(), sessionFactory, Project.class);
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
                case "/insertTeam":
                    insertTeam(request, response);
                    break;
                case "/listTeam":
                    listTeam(request, response);
                    break;
                case "/updateTeam":
                    updateTeam(request, response);
                    break;
                case "/editTeam":
                    editTeam(request, response);
                    break;
                case "/deleteTeam":
                    deleteTeam(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            logger.error("ServletException a doPost method in TeamServlet class ", e);
        } catch (IOException e) {
            logger.error("IOException a doPost method in TeamServlet class ", e);
        }
    }

    private void insertTeam(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        long projectId = Long.parseLong(request.getParameter("project_id"));
        Project project = projectDao.getById(projectId);
        Team team = new Team(name, project);
        teamDao.add(team);
        response.sendRedirect("listTeam");
    }

    private void listTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Team> listTeam = teamDao.getAll().stream()
                .sorted(Comparator.comparing(Team::getId)).collect(Collectors.toList());
        request.setAttribute("listTeam", listTeam);
        RequestDispatcher dispatcher = request.getRequestDispatcher("team-list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateTeam(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long teamId = Long.parseLong(request.getParameter("team_id"));
        String name = request.getParameter("name");
        long projectId = Long.parseLong(request.getParameter("project_id"));
        Project project = projectDao.getById(projectId);
        Team team = new Team(teamId, name, project);
        teamDao.update(team);
        response.sendRedirect("listTeam");
    }

    private void editTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long teamId = Long.parseLong(request.getParameter("team_id"));
        Team team = teamDao.getById(teamId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("team-form.jsp");
        request.setAttribute("team", team);
        dispatcher.forward(request, response);
    }

    private void deleteTeam(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long teamId = Long.parseLong(request.getParameter("team_id"));
        teamDao.remove(teamId);
        response.sendRedirect("listTeam");
    }
}
