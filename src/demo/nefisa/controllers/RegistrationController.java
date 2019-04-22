package demo.nefisa.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.nefisa.connections.ConnectionManager;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public RegistrationController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String sql = "INSERT INTO user(firstName, lastName, password) VALUES(?,?,?)";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = ConnectionManager.getInstance().getConnection();
			ResultSet rs = null;
			PreparedStatement stmt = conn.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, password);
			
			int affected = stmt.executeUpdate();
			if (affected == 1) {
				rs = stmt.getGeneratedKeys();
				rs.next();
				int newKey = rs.getInt(1);
				request.getSession().setAttribute("sessionUserID", newKey);
				RequestDispatcher rd = request.getRequestDispatcher("registrationSucces.jsp");
				rd.forward(request, response);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
