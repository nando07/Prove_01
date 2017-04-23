package gomez;

public class User {

    // Add private member variables to the class to store the password, salt, and hash value. They should all be String variables.

    private String password;
    private String passwordHash;
    private String salt;

    // constructor
    public User(String startPassword) {

        password = startPassword;
        passwordHash = "Hash hasn't been created";
        salt = "Salt hasn't been created";
    }

    // getters

    public String getPassword() {

        return password;
    }

    public String getHashedPassword() {

        return passwordHash;
    }

    public String getSalt() {

        return salt;
    }

    // setters
    public void setPassword(String newValue) {

        password = newValue;
    }

    public void setHashedPassword(String newValue) {

        passwordHash = newValue;
    }

    public void setSalt(String newValue) {

        salt = newValue;
    }

    public static void main(String[] args) {
	// write your code here

    }
}
