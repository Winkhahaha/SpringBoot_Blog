package edu.mineok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() throws IOException {

            File file = new File("/Users/minggao/Ming Gao/SpringBoot_Blog/blog/1.txt");
            File file1 = new File("/Users/minggao/Ming Gao/SpringBoot_Blog/blog/2.txt");
            FileCopyUtils.copy(file, file1);
            System.out.println("finish");
        }


}
