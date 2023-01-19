package seeviceImpl;

import entity.Role;
import entity.User;
import model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import repo.UserRepository;
import repo.RoleRepository;

import org.springframework.stereotype.Service;
import seevice.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.security.crypto.password.PasswordEncoder.*;

@Service
public class UserServiceImpl implements UserService {

private UserRepository userRepository;
private RoleRepository roleRepository;
private PasswordRepository passwordRepository;
public UserServiceImpl(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordRepository passwordRepository) {
    this.userRepository = userRepository;
    this.roleRepository =roleRepository;
    this.passwordRepository =passwordRepository;
}
    @Override
    public void saveUser(UserModel userModel)

    {
    	User user= new User();
    	user.setName(userModel.getFirstName() + "" + userModel.getLastName());
    	user.setEmail(userModel.getEmail());
        user.setPasword(encoder(userModel.getPassword()));
        Role role = roleRepository.findByName("Role_Admin");
        if (role == null){
            role = checkRoleExist();
        }
        user.setRole(Arrays.asList(role));
        userRepository.save(user);

    }

    private Role checkRoleExist() {
    Role role = new Role();
    role.setName("Role_Admin");
    return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserModel> findAllUsers() {
    	List<User> users = userRepository.findAll();
    	return users.stream()
    			.map((user)->mapToUserModel(user))
    			.collect(Collectors.toList());
        
    }
    
private UserModel mapToUserModel(User user) {
 UserModel usermodel =new UserModel();

 String [] str = user.getName().split("");
 
usermodel.setFirstName(str[0]);

usermodel.setLastName(str[1]);

usermodel.setEmail(user.getEmail());
return usermodel;

}
}
