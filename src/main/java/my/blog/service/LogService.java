package my.blog.service;

import my.blog.domain.SysLog;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    public void log(SysLog sysLog){
        System.out.println(sysLog.getUserID()+" log in at "+sysLog.getOperationDate());
    }
}
