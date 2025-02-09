package repository;

import model.User;
import utils.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    private static UserRepository instance;
    private static List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
        User admin = new User("abcde", Role.ADMIN, "Admin", "admin", "admin");
        users.add(admin);
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void register(String fullName, String username, String password) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, Role.USER, fullName, username, password);
        users.add(user);
    }
}
