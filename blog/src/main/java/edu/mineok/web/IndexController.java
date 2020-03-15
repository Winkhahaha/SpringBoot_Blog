package edu.mineok.web;

import edu.mineok.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        // int i = 9 / 0;
//        String blog = null;
//        if (blog == null){
//            throw new NotFoundException("博客不存在");
//        }
        System.out.println("index方法");
        return "index";
    }

    @GetMapping("/blog")
    @ResponseBody
    public String blog() {
        return "blog";
    }

}
