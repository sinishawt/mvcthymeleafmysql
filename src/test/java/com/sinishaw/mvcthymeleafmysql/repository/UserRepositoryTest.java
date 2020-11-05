package com.sinishaw.mvcthymeleafmysql.repository;

import com.sinishaw.mvcthymeleafmysql.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByIdTest(){
        User aUser = new User();
        aUser.setId(1);
        aUser.setEmail("Test@gmail.com");
        aUser.setName("abebe");

        User newUser = userRepository.save(aUser);

        Optional<User> userFound = userRepository.findById(newUser.getId());

        assertEquals(aUser.getEmail(), userFound.get().getEmail());
    }

    @Test
    public void saveUserTest(){
        User aUser = new User();
        aUser.setId(1);
        aUser.setEmail("Test@gmail.com");
        aUser.setName("abebe");

        User newUser = userRepository.save(aUser);

        assertEquals(aUser.getName(), newUser.getName());
    }

    @Test
    public void deleteUserTest(){
        User aUser = new User();
        aUser.setId(1);
        aUser.setEmail("Test@gmail.com");
        aUser.setName("abebe");

        User newUser = userRepository.save(aUser);

        userRepository.deleteById(newUser.getId());

        Optional<User> checkUser = userRepository.findById(aUser.getId());

       // assertNull(checkUser.get().getId());
        assertThrows(NoSuchElementException.class, () -> {checkUser.get().getId();});
    }
}