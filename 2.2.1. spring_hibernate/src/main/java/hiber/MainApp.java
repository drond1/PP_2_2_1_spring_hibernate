package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

        User user1 = new User("Name1", "lastName1", "email1@mail.ru");
        User user2 = new User("Name2", "lastName2", "email2@mail.ru");

        user1.setCar(new Car("Car1", 1, user1));
        user2.setCar(new Car("Car2", 2, user2));

        userService.add(user1);
        userService.add(user2);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println("--------------------------------------");
        }
        System.out.println(userService.userCar("Car1", 1));
        System.out.println(userService.userCar("Car2", 2));
        context.close();
    }
}