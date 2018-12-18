package Data;

public class Login {
    private String username;
    private String password;
    
    public void Login() {
        username = ""; 
        password = "";
    }
    public String getUser() {
        return username;
    }
    public String getPass() {
        return password;
    }
    
    public void setUser(String u) {
        username = u;
    }
    public void setPass(String p) {
        password = p;
    }
}
