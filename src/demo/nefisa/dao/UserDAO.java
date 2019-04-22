package demo.nefisa.dao;

import demo.nefisa.dto.User;

public interface UserDAO {

	public User createUser(String firstName, String lastName, String password) throws Exception;

	public boolean checkLogin(int userID, String password) throws Exception;

}
