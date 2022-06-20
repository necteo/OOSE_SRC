package sogongimms.persistent.dto;

public class NoticeTitleDTO {
    private int noticeNum;
    private String title;
    private String userId;

    public int getNoticeNum() {
        return noticeNum;
    }
    public String getTitle() {
        return title;
    }
    public String getUserId() { return userId; }

    public void setNoticeNum(int noticeNum) { this.noticeNum = noticeNum; }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
