package sogongimms.persistent.dto;

import java.util.Date;

public class SalesDTO {
    private int paymentNum;
    private String lectureName;
    private int paymentAccount;
    private Date paymentDate;
    private String paymentMethod;
    private String memberId;

    public int getPaymentNum() {
        return paymentNum;
    }
    public String getLectureName() { return lectureName; }
    public int getPaymentAccount() {
        return paymentAccount;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public String getMemberId() {
        return memberId;
    }

    public void setPaymentNum(int paymentNum) {
        this.paymentNum = paymentNum;
    }
    public void setLectureName(String lectureName) { this.lectureName = lectureName; }
    public void setPaymentAccount(int paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
