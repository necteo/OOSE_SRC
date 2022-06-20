package sogongimms.persistent.dto;

import java.sql.Date;

public class LectureDateDTO {
    private int lectureCode;
    private Date date;
    private String startTime;
    private String endTime;

    public int getLectureCode() { return lectureCode; }
    public Date getDate() { return date; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    public void setLectureCode(int lectureCode) { this.lectureCode = lectureCode; }
    public void setDate(Date date) { this.date = date; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}
