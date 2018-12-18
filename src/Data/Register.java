package Data;

public class Register {
    private String username;
    private String password;
    private String re_password;
    private String email;
    private String re_email;
    
    public void Register() {
        username = "";
        password = "";
        re_password = "";
        email = "";
        re_email = "";
    }
    
    public void setUsername(String user) {
        username = user;
    }
    public void setPassword(String pass) {
        password = pass;
    }
    public void setRePassword(String repass) {
        re_password = repass;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setReEmail(String reemail) {
        re_email = reemail;
    }
    
     public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRePassword() {
        return re_password;
    }
    public String getEmail() {
        return email;
    }
    public String getReEmail() {
        return re_email;
    }
}