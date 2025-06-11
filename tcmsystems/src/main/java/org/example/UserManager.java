package org.example;

import java.util.*;

public class UserManager {
    private static class User {
        String username;
        String password;
        Role role;
        User(String u, String p, Role r) { username = u; password = p; role = r; }
    }
    private Map<String, User> users = new HashMap<>();
    private Set<String> loggedInUsers = new HashSet<>();

    public UserManager() {
        // 示例用户
        users.put("admin", new User("admin", "admin123", Role.ADMIN));
        users.put("user", new User("user", "user123", Role.USER));
    }

    public boolean login(String username, String password) {
        User u = users.get(username);
        if (u != null && u.password.equals(password)) {
            loggedInUsers.add(username);
            return true;
        }
        return false;
    }

    public Role getUserRole(String username) {
        User u = users.get(username);
        return u == null ? null : u.role;
    }

    public boolean isLoggedIn(String username) {
        return loggedInUsers.contains(username);
    }
}