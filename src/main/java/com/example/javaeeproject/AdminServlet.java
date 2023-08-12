package com.example.javaeeproject;//package com.example.javaeeproject;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * Servlet implementation class AdminServlet
// */
//@WebServlet("/")
//public class AdminServlet extends HttpServlet {
//    private userImpl userImpl;
//    private static final long serialVersionUID = 1L;
//    public void init() throws ServletException {
//        userImpl=new userImpl();
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getServletPath();
//
//        switch (action) {
//            case "/login":
//                loginUser(request, response);
//                break;
////                case "admin/new":
////                    showNewForm(request, response);
////                    break;
////                case "admin/insert":
////                    insertUser(request, response);
////                    break;
////                case "admin/delete":
////                    deleteUser(request, response);
////                    break;
////                case "admin/edit":
////                    showEditForm(request, response);
////                    break;
////                case "admin/update":
////                    updateUser(request, response);
////                    break;
//                default:
//                    try {
//                        listUser(request, response);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
////            }
//        }
//    }
//
//    private void loginUser(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
////        String username = request.getParameter("username");
//        String password = request.getParameter("userpsw");
//        String email = request.getParameter("useremail");
////        int number = Integer.parseInt(request.getParameter("number"));
//        String submitType = request.getParameter("submit");
//        user c = userImpl.getuser(email, password);
//
//
//        if (submitType.equals("Enter")) {
//            if (c != null && c.getUsername() != null) {
//                HttpSession session = request.getSession();
//                session.setAttribute("username", c.getUsername());
//            }
//
////            response.sendRedirect("home");
//
//        } else if (submitType.equals("Register")) {
//            request.setCharacterEncoding("UTF-8");
//
//            c.setEmail(email);
//            c.setNumber(Integer.parseInt(request.getParameter("number")));
//            c.setPassword(password);
//            c.setUsername(request.getParameter("username"));
//            c.setIduser(5);
//            user p=userImpl.adduser(c);
//            request.setAttribute("user", p);
//            response.getWriter().write("error" + c);
//
//        }}
//
//
//    private void listUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List < user > listUser = userImpl.selectALLUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//        dispatcher.forward(request, response);
//    }
////    private void searchUser(HttpServletRequest request, HttpServletResponse response)
////            throws SQLException, IOException, ServletException {
////        String key=request.getParameter("key");
////        List < user > listUser =    userImpl.getuserParMotCle(key);
////        request.setAttribute("listUser", listUser);
////        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
////        dispatcher.forward(request, response);
////    }
////    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
////        dispatcher.forward(request, response);
////    }
////
////    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
////            throws SQLException, ServletException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////        user existingUser = userImpl.getuser(id);
////        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
////        request.setAttribute("user", existingUser);
////        dispatcher.forward(request, response);
////
////    }
////
////    private void insertUser(HttpServletRequest request, HttpServletResponse response)
////            throws SQLException, IOException {
////        String username =request.getParameter("username");
////        String password =request.getParameter("userpsw");
////        String email =request .getParameter("useremail");
////        int number = Integer.parseInt(request .getParameter("number"));
////        user newUser= new user(username,  password,  email, number);
////        userImpl.adduser(newUser);
////        response.sendRedirect("list");
////    }
////
////    private void updateUser(HttpServletRequest request, HttpServletResponse response)
////            throws SQLException, IOException {
////        Long id = Long.parseLong(request.getParameter("id"));
////        String username =request.getParameter("username");
////        String password =request.getParameter("userpsw");
////        String email =request.getParameter("useremail");
////        int number = Integer.parseInt(request.getParameter("number"));
////        user user= new  user(username,  password,  email, number);;
////        userImpl.updateuser(user);
////        response.sendRedirect("list");
////    }
////
////    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
////            throws SQLException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////        userImpl.deleteuser(id);
////        response.sendRedirect("list");
////    }
//    }

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.javaeeproject.user;
import com.example.javaeeproject.userImpl;


@WebServlet("/")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userImpl userDAO;

    public void init() {
        userDAO = new userImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/search":
                   searchUser(request, response);
                    break;
                case"/login":
                   loginForm(request, response);
                    break;
                case"/register":
                    registerForm(request, response);
                    break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String motCle=request.getParameter("motCle");
        List<user> listUser = userDAO.getuserParMotCle(motCle);
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp").forward(request,response);

    }

    private void loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("useremail");
        String password = request.getParameter("userpsw");
        user c = userDAO.getuser(email, password);
        if ( c!= null ) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
    }

    private void registerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username =request.getParameter("username");
        String password =request.getParameter("userpsw");
        String email =request.getParameter("useremail");
        int number = Integer.parseInt(request.getParameter("number"));
        user p = userDAO.adduser(new user(username,  password,  email, number));
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <user> listUser = userDAO.selectALLUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        user existingUser = userDAO.getuser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username =request.getParameter("username");
        String password =request.getParameter("userpsw");
        String email =request.getParameter("useremail");
        int number = Integer.parseInt(request.getParameter("number"));
        user p = userDAO.adduser(new user(username,  password,  email, number));
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nom=request.getParameter("username");
        String password =request.getParameter("userpsw");
        String email =request.getParameter("useremail");
        int number = Integer.parseInt(request.getParameter("number"));
        user p = new user();
        p.setIduser(id);
        p.setUsername( nom);
        p.setPassword(password);
        p.setEmail(email);
        p.setNumber(number);
        userDAO.updateuser(p);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteuser(id);
        response.sendRedirect("list");

    }
}