package sogongimms.persistent.dto;

public class LockerDTO {
    private int lockerNo;
    private String memberId;
    private String registDate;
    private String dueDate;

    public int getLockerNo() {
        return lockerNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public String getRegistDate() {
        return registDate;
    }
    public String getDueDate() {
        return dueDate;
    }

    public void setLockerNo(int lockerNo) {
        this.lockerNo = lockerNo;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
