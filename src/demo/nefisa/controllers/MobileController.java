package demo.nefisa.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.nefisa.connections.ConnectionManager;


@WebServlet("/MobileController")
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MobileController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
			
			String userID = (String) request.getSession().getAttribute("sessionUserID");
			int userIDint = Integer.parseInt(userID);
			int personID = Integer.parseInt(request.getParameter("personID"));
			String mobile = request.getParameter("mobile");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE phonebook SET mobile = ? WHERE ID =  ? AND userID = ?";
			ResultSet rs = null;

			PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, mobile);
				stmt.setInt(2, personID);
				stmt.setInt(3,userIDint);
				int affected = stmt.executeUpdate();
				
				PrintWriter out = response.getWriter();
				
				if ( affected == 1) {
					out.println("Successfully updated mobile number." + "<br>");
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.include(request, response);
				} else {
					out.println("Something went wrong. Try again." + "<br>");
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.include(request, response);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
