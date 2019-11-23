package com.enver.itcompany.controller;

import com.enver.itcompany.dao.SkillDaoImpl;
import com.enver.itcompany.model.Skill;
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

@WebServlet(name = "SkillServlet",
        urlPatterns = {"/insertSkill", "/listSkill", "/updateSkill", "/editSkill", "/deleteSkill"})
public class SkillServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(SkillServlet.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private SkillDaoImpl skillDao;

    public SkillServlet() {
    }

    public void init() {
        skillDao = new SkillDaoImpl(Skill.class.getSimpleName(), sessionFactory, Skill.class);
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
                case "/insertSkill":
                    insertSkill(request, response);
                    break;
                case "/listSkill":
                    listSkill(request, response);
                    break;
                case "/updateSkill":
                    updateSkill(request, response);
                    break;
                case "/editSkill":
                    skillEditForm(request, response);
                    break;
                case "/deleteSkill":
                    deleteSkill(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
            logger.error("ServletException a doPost method in SkillServlet class ", e);
        } catch (IOException e) {
            logger.error("IOException a doPost method in SkillServlet class ", e);
        }
    }

    private void insertSkill(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        Skill skill = new Skill(name);
        skillDao.add(skill);
        response.sendRedirect("listSkill");
    }

    private void listSkill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Skill> listSkill = skillDao.getAll().stream()
                .sorted(Comparator.comparing(Skill::getId)).collect(Collectors.toList());
        request.setAttribute("listSkill", listSkill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("skill-list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateSkill(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long skillId = Long.parseLong(request.getParameter("skill_id"));
        String name = request.getParameter("name");
        Skill skill = new Skill(skillId, name);
        skillDao.update(skill);
        response.sendRedirect("listSkill");
    }

    private void skillEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long skillId = Long.parseLong(request.getParameter("skill_id"));
        Skill skill = skillDao.getById(skillId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("skill-form.jsp");
        request.setAttribute("skill", skill);
        dispatcher.forward(request, response);
    }

    private void deleteSkill(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long skillId = Long.parseLong(request.getParameter("skill_id"));
        skillDao.remove(skillId);
        response.sendRedirect("listSkill");
    }
}
