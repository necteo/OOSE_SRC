package sogongimms.persistent.dto;

public class TakingLecturesDTO {
    private String memberId;
    private int lectureCode;

    public TakingLecturesDTO(String memberId, int lectureCode) {
        this.memberId = memberId;
        this.lectureCode = lectureCode;
    }

    public String getMemberId() { return memberId; }
    public int getLectureCode() { return lectureCode; }

    public void setMemberId(String memberId) { this.memberId = memberId; }
    public void setLectureCode(int lectureCode) { this.lectureCode = lectureCode; }
}
