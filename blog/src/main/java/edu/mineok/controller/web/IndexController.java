package edu.mineok.controller.web;

import edu.mineok.service.BlogService;
import edu.mineok.service.TagService;
import edu.mineok.service.TypeService;
import edu.mineok.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable
            , Model model) {
        // 拿到分页数据
        model.addAttribute("page", blogService.listBlog(pageable));
        // 首页展示的分类,按照分类下的博客数目进行倒序
        model.addAttribute("types", typeService.listTypeTop(6));
        // 首页展示的标签
        model.addAttribute("tags", tagService.listTagTop(10));
        // 首页展示勾选推荐的博客
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        return "index";
    }

    @GetMapping("/blog")
    @ResponseBody
    public String blog() {
        return "blog";
    }

}
