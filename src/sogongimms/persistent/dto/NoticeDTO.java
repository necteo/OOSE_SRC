package sogongimms.persistent.dto;

import java.util.Date;

public class NoticeDTO {
    private int noticeNum;
    private String title;
    private String content;
    private String uploadDate;
    private String userId;

    public int getNoticeNum() {
        return noticeNum;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getUploadDate() {
        return uploadDate;
    }
    public String getUserId() {
        return userId;
    }

    public void setNoticeNum(int noticeNum) {
        this.noticeNum = noticeNum;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
