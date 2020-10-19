package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Leo","Messi", (byte) 34);
        userService.saveUser("Nikola","Tesla", (byte) 42);
        userService.saveUser("Mikhail","Lermontov", (byte) 26);
        userService.saveUser("Yuriy","Gagarin", (byte) 31);

        System.out.println();

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}