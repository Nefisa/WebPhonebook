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

@WebServlet("/DisplayAllController")
public class DisplayAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayAllController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		String userID = (String) request.getSession().getAttribute("sessionUserID");
		int userIDint = Integer.parseInt(userID);
		ArrayList<String> list = new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = ConnectionManager.getInstance().getConnection();

		String sql = "SELECT * FROM phonebook WHERE userID = ?";
		ResultSet rs = null;

		PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userIDint);
			rs = stmt.executeQuery();
			while (rs.next()) {
				StringBuffer row = new StringBuffer();
				row.append(rs.getInt("ID") + " ");
				row.append(rs.getString("firstName") + " ");
				row.append(rs.getString("lastName") + " ");
				row.append(rs.getString("phone") + " ");
				row.append(rs.getString("mobile") + " ");
				row.append(rs.getInt("userID"));
				list.add(row.toString());
			}
			
			PrintWriter out = response.getWriter();
			
			
			if (list.size() != 0) {
				out.println("People in your phonebook are:<br>");
				for(String s: list)
					out.println(s + "<br>");
				
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.include(request, response);
				
			} else {
				out.println("No person was found in your phonebook.<br>");
				
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.include(request, response);
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
