package com.back.end;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.back.end.entity.User;
import com.back.end.repository.UserRepository;
import com.back.end.service.UserService;

@SpringBootTest
public class CreateEntityTest {

    @Autowired
    private UserService us;

    @MockBean
    private UserRepository usRepo;
    
    @Test
    public void addUserPositive(){
        User user = new User();

        user.setNumber("+375325367478");
        user.setPass("dsafsdgsa");

        try {
            User isUserAdded = us.addUser(user);
            
            assert(isUserAdded.getNumber() == "+375325367478");
            assert(isUserAdded.getPass() == "dsafsdgsa");

        } catch(Exception e){
            return;
        }
    }

    @Test
    public void addUserNegative(){
        User user = new User();

        user.setNumber("+375292857664");
        user.setPass("jsgjdsfas");

        Boolean flag = false;

        try {
            User isUserAdded = us.addUser(user);
            flag = true;
            
            assert(isUserAdded.getNumber() == "+375325367478");
            assert(isUserAdded.getPass() == "dsafsdgsa");

        } catch(Exception e){
            assert(e.getMessage() != null && flag == false);
        }
    }
}
