//package com.afa.repositories;
//
//import com.afa.repositories.CourseRepository;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@SpringBootTest
//public class UserRepositoryTest {
//    @Autowired
//    private CourseRepository courseRepository;
//    @Before
//    public void setUp() throws Exception {
//        User user1= new User("Alice", 23);
//        User user2= new User("Bob", 38);
//        //save user, verify has ID value after save
//        assertNull(user1.getId());
//        assertNull(user2.getId());//null before save
//        this.userRepository.save(user1);
//        this.userRepository.save(user2);
//        assertNotNull(user1.getId());
//        assertNotNull(user2.getId());
//    }
//    @Test
//    public void testFetchData(){
//        /*Test data retrieval*/
//        User userA = userRepository.findByName("Bob");
//        assertNotNull(userA);
//        assertEquals(38, userA.getAge());
//        /*Get all products, list should only have two*/
//        Iterable<User> users = userRepository.findAll();
//        int count = 0;
//        for(User p : users){
//            count++;
//        }
//        assertEquals(count, 2);
//    }
//}