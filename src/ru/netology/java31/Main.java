package ru.netology.java31;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);

        validateUser(user);


        System.out.println("Доступ предоставлен");

    }

    public static User[] getUsers() {
        User user1 = new User("Petya", "petya@gmail.com", "123", 25);
        User user2 = new User("Vasya", "vasya@gmail.com", "qwerty", 22);
        User user3 = new User("Vanya", "vanya@gmail.com", "8800", 13);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.password.equals(password) && user.login.equals(login)) {
                return user;
            }

        }
        throw new UserNotFoundException("User not found");
    }


    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < 18) {
            throw new AccessDeniedException("Ваш возраст менее 18 лет");
        }
    }
}
