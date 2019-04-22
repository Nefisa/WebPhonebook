package demo.nefisa.controllers;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.nefisa.connections.ConnectionManager;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
    public LoginController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionUserID", request.getParameter("userID"));
			
			String user = (request.getParameter("userID"));
			
			int userID = Integer.parseInt(user);
			String password = request.getParameter("password");
			String sql = "SELECT * FROM user WHERE userID=?";

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			
			ResultSet rs = stmt.executeQuery();

			PrintWriter out = response.getWriter();
			
			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
			
				} else {
					out.println("Something went wrong. Try again." + "<br>");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
					
					
				}
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
