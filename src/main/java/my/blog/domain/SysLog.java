package my.blog.domain;

import java.util.Date;

public class SysLog {
    private Date operationDate;
    private int userID;

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public SysLog(Date operationDate, int userID){
        this.operationDate = operationDate;
        this.userID = userID;
    }
}
