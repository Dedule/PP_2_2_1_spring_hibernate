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

      User user1 = new User("User1", "Lastname2", "user2@mail.ru");
      User user2 = new User("User2", "Lastname3", "user3@mail.ru");
      Car car1 = new Car("car1", 123);
      Car car2 = new Car("car2", 456);
      car1.setUser(user1);
      user1.setCar(car1);
      car2.setUser(user2);
      user2.setCar(car2);


      userService.add(user1);
      userService.add(user2);
      System.out.println(userService.getUserByCarModelAndSeries("car1",123));
      System.out.println(userService.getUserByCarModelAndSeries("car2",456));

      context.close();
   }
}
