package sogongimms.persistent.dto;

public class LectureDTO {
    private int lectureCode;
    private String lectureName;
    private int capacity;
    private String teacherId;
    private String sports;
    private int gender;
    private int location;
    private String weeks;

    public int getLectureCode() { return lectureCode; }
    public String getLectureName() { return lectureName; }
    public int getCapacity() { return capacity; }
    public String getTeacherId() { return teacherId; }
    public String getSports() { return sports; }
    public int getGender() { return gender; }
    public int getLocation() { return location; }
    public String getWeeks() { return weeks; }

    public void setLectureCode(int lectureCode) { this.lectureCode = lectureCode; }
    public void setLectureName(String lectureName) { this.lectureName = lectureName; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
    public void setSports(String sports) { this.sports = sports; }
    public void setGender(int gender) { this.gender = gender; }
    public void setLocation(int location) { this.location = location; }
    public void setWeeks(String weeks) { this.weeks = weeks; }
}
