package org.recipe.controllers;

import org.recipe.models.User;
import org.recipe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by LaunchCode
 */
public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    protected boolean isSessionActive(HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId != null;
    }

//    @ModelAttribute("userId")
//    public Integer getUserIdFromSession(HttpServletRequest request) {
//        return (Integer) request.getSession().getAttribute(userSessionKey);
//    }
}