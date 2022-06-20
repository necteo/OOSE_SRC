package sogongimms.persistent.dto;

public class LectureListDTO {
    String lectureName;
    int lectureCode;
    int capacity;
    String teacherName;
    String sports;
    int gender;
    int location;
    String weeks;
    String startTime;
    String endTime;

    public LectureListDTO(LectureDTO lectureDTO, String teacher, String[] time) {
        this.lectureName = lectureDTO.getLectureName();
        this.lectureCode = lectureDTO.getLectureCode();
        this.capacity = lectureDTO.getCapacity();
        this.teacherName = teacher;
        this.sports = lectureDTO.getSports();
        this.gender = lectureDTO.getGender();
        this.location = lectureDTO.getLocation();
        this.weeks = lectureDTO.getWeeks();
        this.startTime = time[0];
        this.endTime = time[1];
    }

    public String getLectureName() { return lectureName; }
    public int getLectureCode() { return lectureCode; }
    public int getCapacity() { return capacity; }
    public String getTeacherName() { return teacherName; }
    public String getSports() { return sports; }
    public int getGender() { return gender; }
    public int getLocation() { return location; }
    public String getWeeks() { return weeks; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    public void setLectureName(String lectureName) { this.lectureName = lectureName; }
    public void setLectureCode(int lectureCode) { this.lectureCode = lectureCode; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setTeacherName(String  teacherName) { this.teacherName = teacherName; }
    public void setSports(String sports) { this.sports = sports; }
    public void setGender(int gender) { this.gender = gender; }
    public void setLocation(int location) { this.location = location; }
    public void setWeeks(String weeks) { this.weeks = weeks; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}
