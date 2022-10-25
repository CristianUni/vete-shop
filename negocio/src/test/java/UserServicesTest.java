import co.edu.uniquindio.proyecto.BusinessApplication;
import co.edu.uniquindio.proyecto.entidades.User;
import co.edu.uniquindio.proyecto.servicios.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BusinessApplication.class)
@Transactional
public class UserServicesTest {

    @Autowired
    private UserService userService;

    @Test
    public void registerUserTest() throws Exception {


        User user = new User("Pedro antonio", "3215708940", "298520741", "pedroAntonio@gmail.com", "123456", 2, "909041", LocalDateTime.now());
        User userCreated = userService.createUser(user);
        Assertions.assertNotNull(userCreated);
        System.out.println(userCreated);


    }

    @Test
    public void deleteUserTest() throws Exception {


        User user = new User("Pedro antonio", "3215708940", "298520741", "pedroAntonio@gmail.com", "123456", 2, "909041", LocalDateTime.now());
        User userCreated = userService.createUser(user);
        userService.deleteUser("pedroAntonio@gmail.com");
        User findUser = userService.findByEmail("pedroAntonio@gmail.com");
        Assertions.assertNull(findUser);
        System.out.println("se elimino");


    }

    @Test
    public void listUsersTest() throws Exception {

        User user = new User("Pedro antonio", "3215708940", "298520741", "pedroAntonio@gmail.com", "123456", 2, "909041", LocalDateTime.now());
        User user2 = new User("Maria Perez", "3225807894", "1115632870", "maria@gmail.com", "12345556", 1, "9090417", LocalDateTime.now());
        userService.createUser(user);
        userService.createUser(user2);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList = userService.listUsers();

        for (User myUsers : userList) {
            System.out.println(myUsers);
        }


    }

}
