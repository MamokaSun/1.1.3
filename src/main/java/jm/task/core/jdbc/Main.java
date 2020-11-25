package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("An", "Tar", (byte) 1);
        System.out.println("User с именем – An добавлен в базу данных");

        userService.saveUser("Durna", "Mandra", (byte) 13);
        System.out.println("User с именем – Durna добавлен в базу данных");

        userService.saveUser("Wardok", "Lizushi", (byte) 65);
        System.out.println("User с именем – Wardok добавлен в базу данных");

        userService.saveUser("Uldir", "Kamatr", (byte) 25);
        System.out.println("User с именем – Uldir добавлен в базу данных");

        List<User> arr = userService.getAllUsers();
        arr.stream().forEach(user -> System.out.println(user.toString()));

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
