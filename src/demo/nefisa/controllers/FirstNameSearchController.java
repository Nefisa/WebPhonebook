package demo.nefisa.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.nefisa.connections.ConnectionManager;

@WebServlet("/FirstNameSearchController")
public class FirstNameSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FirstNameSearchController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userID = (String) request.getSession().getAttribute("sessionUserID");
			int userIDint = Integer.parseInt(userID);
			String firstName = request.getParameter("firstName");
			ArrayList<String> list = new ArrayList<>();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT ID, firstName, lastName, phone, mobile FROM phonebook WHERE firstName = ? AND userID = ?";
			ResultSet rs = null;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, firstName);
				stmt.setInt(2, userIDint);
				rs = stmt.executeQuery();
				while (rs.next()) {
					StringBuffer row = new StringBuffer();
					row.append(rs.getInt("ID") + " ");
					row.append(rs.getString("firstName") + " ");
					row.append(rs.getString("lastName") + " ");
					row.append(rs.getString("phone") + " ");
					row.append(rs.getString("mobile"));
					list.add(row.toString());
				}
				
				PrintWriter out = response.getWriter();
				
				if (list.size() != 0) {
					out.println("ID FirstName LastName PhoneNo MobileNo" + "<br>");
					for (String s : list) {
						out.println(s  + "<br>");
					
					}
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.include(request, response);
				}
					else {
						out.println("No persons found." + "<br>");
						RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
						rd.include(request, response);
					}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
