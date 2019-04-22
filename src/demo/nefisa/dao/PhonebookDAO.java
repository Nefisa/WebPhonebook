package demo.nefisa.dao;

import java.util.ArrayList;

import demo.nefisa.dto.PersonPB;
import demo.nefisa.dto.User;

public interface PhonebookDAO {
		
		public void displayAllRows(User user) throws Exception;
		
		public boolean deletePerson(int number, User user);
		
		public PersonPB insertPerson(String firstName, String lastName, String phone, String mobile, User user) throws Exception;
		
		public boolean updateFirstName(int personID, String firstName, User user) throws Exception;
		
		public boolean updateLastName(int personID, String lastName, User user) throws Exception;
		
		public boolean updatePhoneNumber(int personID, String phoneNumber, User user) throws Exception;
		
		public boolean updateMobileNumber(int personID, String mobileNumber, User user) throws Exception;
		
		public ArrayList<String> searchByFirstName(String firstName, User user) throws Exception;
		
		public ArrayList<PersonPB> searchByLastName(String lastName, User user) throws Exception;

	}
