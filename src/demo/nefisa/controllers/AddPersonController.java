package demo.nefisa.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import demo.nefisa.dto.PersonPB;

/**
 * Servlet implementation class AddPersonController
 */
@WebServlet("/AddPersonController")
public class AddPersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddPersonController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			PersonPB person = new PersonPB();
			person.setFirstName(request.getParameter("firstName"));
			person.setLastName(request.getParameter("lastName"));
			person.setPhone(request.getParameter("phone"));
			person.setMobile(request.getParameter("mobile"));
			int sessionUserID = (int) request.getSession().getAttribute("sessionUserID");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = ConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO phonebook(firstName, lastName, phone, mobile, userID) VALUES(?,?,?,?,?)";
			ResultSet keys = null;

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getPhone());
			stmt.setString(4, person.getMobile());
			stmt.setInt(5, sessionUserID);

			PrintWriter out = response.getWriter();

			int affected = stmt.executeUpdate();
			if (affected == 1) {
				keys = stmt.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				person.setPhonebookID(newKey);
				out.println("Person successfully added to your phonebook list." + "<br>");
				out.println("PersonID: " + person.getPhonebookID() + ", person first name :" + person.getFirstName()
						+ "" + ", person's last name: " + person.getLastName() + " person's phone mumber "
						+ person.getPhone() + " person's mobile number " + person.getMobile() + "<br>");
				out.println();
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.include(request, response);
			} else {
				out.println("Something went wrong.Try again." + "<br>");
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.include(request, response);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
