package seevice;

import entity.User;
import model.UserModel;

import java.util.List;

public interface UserService {
	void saveUser(UserModel userModel);
	
User findUserByEmail(String email);

List<UserModel> findAllUsers();


}
