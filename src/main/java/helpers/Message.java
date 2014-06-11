package helpers;

public class Message {
    public String login;
    public String loginMessage;
    public String passMessage;

    public Message(){ }
    
    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getPassMessage() {
        return passMessage;
    }

    public void setPassMessage(String passMessage) {
        this.passMessage = passMessage;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
