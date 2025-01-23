package web.UserDAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.userconfig.User;

import java.util.List;

@Repository
public interface UserDAO {
    List<User> getAllUsers();
    User getUser(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
