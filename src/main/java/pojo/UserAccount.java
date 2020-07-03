package pojo;

public class UserAccount {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private boolean shouldLogin; //bandera que indica si el usuario deberia o no loguearse

    // si solo se usa para parsear de json a pojo no requiere constructor
    public UserAccount(String _email, String _password, boolean _shouldLogin, String _firstName, String _lastName, String _telephone){
        this.setEmail(_email);
        this.setPassword(_password);
        this.setShouldLogin(_shouldLogin);
        this.setFirstName(_firstName);
        this.setLastName(_lastName);
        this.setTelephone(_telephone);

    }

    public String getTelephone() { return telephone; }

    private void setTelephone(String telephone) { this.telephone = telephone;}

    public String getLastName() { return lastName; }

    private void setLastName(String lastName) { this.lastName = lastName;}

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) { this.firstName = firstName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isShouldLogin() {
        return shouldLogin;
    }

    public void setShouldLogin(boolean shouldLogin) {
        this.shouldLogin = shouldLogin;
    }

    @Override
    public String toString(){
        return (String.format("Email: %s and password: %s", email,password));
    }
}
