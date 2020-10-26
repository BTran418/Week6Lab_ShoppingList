/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BTran
 */
public class ShoppingListServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
	
	if (request.getAttribute("username") != null) {
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("items", items);
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);      
	} 
        else 
	    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	
	if (request.getParameter("action").equals("logout")) {
	    session.removeAttribute("username");
	    session.invalidate();
//            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
	ArrayList<String> items = (ArrayList) session.getAttribute("items");
	
        if (request.getParameter("action").equals("register") && (!request.getParameter("username").equals("") || request.getParameter("username") != null)) {
	    String username = request.getParameter("username");
	    session.setAttribute("username", username);
	    request.setAttribute("message", session.getAttribute("username"));
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
	} 
        else if (request.getParameter("action").equals("register")){
	    request.setAttribute("message", "A username must be entered.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
	
	if (request.getParameter("action").equals("add")) {
            
	    String item = request.getParameter("item");
            items.add(item);
	    session.setAttribute("items", items);
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
	}
	
	if (request.getParameter("action").equals("delete")) {
	    String item = request.getParameter("item");
	    items.remove(item);
	    session.setAttribute("items", items);
	    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
	}
    }

}
