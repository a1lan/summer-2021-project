package com.afa.springserver.repositories;

import com.afa.config.TestJpaConfig;
import com.afa.model.CourseEntity;
import com.afa.repositories.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, TestJpaConfig.class})
public class CourseRepositoryTests {

    @Resource
    private CourseRepository studentRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        CourseEntity student = new CourseEntity("john");
        studentRepository.saveAndFlush(student);

        CourseEntity student2 = studentRepository.findByCourse("john");
        Assert.assertEquals(student, student2);
    }
}

//    @Test
//    public void testSave() throws Exception {
//        repo.saveAndFlush(new CourseEntity("TestSave"));
//    }
//
//    @Test
//    public void testRead() throws Exception {
//        CourseEntity course = new CourseEntity("TestRead");
//        repo.saveAndFlush(course);
//        CourseEntity response = repo.findByCourse("TestRead");
//        assertEquals(course, response);
//    }
//
//    @Test
//    public void testDrop() throws Exception {
//        CourseEntity course = new CourseEntity("TestRead");
//        repo.saveAndFlush(course);
//        repo.delete(course);
//        CourseEntity response = repo.findByCourse("TestRead");
//        assertNull(response);
//    }