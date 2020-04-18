package my.blog.aspect;

import my.blog.domain.SysLog;
import my.blog.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(my.blog.aspect.anno.SysLogAnno)")
    public void logPointCut(){}

    @After("logPointCut()")
    public void doAfter(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpSession session = (HttpSession)requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        int userID = (Integer)session.getAttribute("ID");
        SysLog sysLog = new SysLog(new Date(),userID);
        logService.log(sysLog);
    }
}
