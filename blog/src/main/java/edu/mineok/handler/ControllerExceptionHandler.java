package edu.mineok.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// 拦截标注@Controller的类
@ControllerAdvice
public class ControllerExceptionHandler {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 标注这是一个处理异常的方法
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL :{},Exception:{}", request.getRequestURL(), e);
        // 如果有标注了该注解@ResponseStatus(HttpStatus.NOT_FOUND)的类,不进行拦截,直接返回异常
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
