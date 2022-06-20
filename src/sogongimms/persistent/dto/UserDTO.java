package sogongimms.persistent.dto;

public class UserDTO {
    private String id;
    private String password;
    private int type;

    public String getId() { return id; }
    public String getPassword() { return password; }
    public int getType() { return type; }

    public void setId(String id) { this.id = id; }
    public void setPassword(String password) { this.password = password; }
    public void setType(int type) { this.type = type; }
}
