package model;

import utils.Role;

public class User {
    protected String id;
    protected Role role;
    protected String fullName;
    protected String username;
    protected String password;

    public User(String id, Role role, String fullName, String username, String password) {
        this.id = id;
        this.role = role;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    // ✅ Implementasi Inner Class
    public static class Session {
        private static User loggedInUser;

        public static User getLoggedInUser() {
            return loggedInUser;
        }

        public static boolean isLoggedIn() {
            return loggedInUser != null;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
