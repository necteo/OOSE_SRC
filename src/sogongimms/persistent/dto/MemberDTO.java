package sogongimms.persistent.dto;

public class MemberDTO {
    private String id;
    private String name;
    private String phone;
    private int gender;
    private String birth;
    private String email;

    public String getId() {
        return id;
    }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getGender() { return gender; }
    public String getBirth() { return birth; }
    public String getEmail() { return email; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setGender(int gender) { this.gender = gender; }
    public void setBirth(String birth) { this.birth = birth; }
    public void setEmail(String email) { this.email = email; }
}
