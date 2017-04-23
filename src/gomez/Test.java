package gomez;
import static gomez.NSALoginController.hashUserPassword;
import static gomez.NSALoginController.verifyPassword;
import static gomez.NSALoginController.verifyPasswordLengthAndDigit;
import java.util.Scanner;

/**
 * Created by fernandogomez on 4/22/17.
 */
public class Test {

    private static final Scanner _scanner = new Scanner( System.in );

    public static void main(String[] args) throws WeakPasswordException {

        Test test = new Test();
        Boolean prompt = true;

        String p = test.promptPassword();
        User newUser = new User(p);

        // this will prompt the user for a password if it doesn't contain 8 characters and one digit at least.
        while (prompt) {

            prompt = false;

            try {
               verifyPasswordLengthAndDigit(newUser);

            } catch (WeakPasswordException e) {
               System.out.println(e.getMessage() + "\n");
                prompt = true;
                p = test.promptPassword();
                newUser.setPassword(p);
            }
        }

        System.out.println("\n" + "**** Here are your current credentials ****" + "\n");
        test.displayCredentials(newUser);

            try {
                hashUserPassword(newUser);
                System.out.println("**** New Credentials After Creating Hash and Salt ****" + "\n");
                test.displayCredentials(newUser);
            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("**** Type your orginal password to test the hash! ****" + "\n");
        String testPassword = test.promptPassword();
        newUser.setPassword(testPassword);

        try {
            if (verifyPassword(newUser)) {
                System.out.println("Success! Your password is correct.");
            } else {
                System.out.println("Sorry! Passwords don't match.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String promptPassword() {

        // Using print() instead of println() here, because we don't
        // want an end line.
        System.out.print("Enter your Password: ");

        // Read a string from the console input
        String password = _scanner.nextLine();

        return password;
    }

    private void displayCredentials(User newUser) {

        System.out.println("Password: " + newUser.getPassword() + "\n" + "Salt: " + newUser.getSalt() + "\n" + "Password Hash: " + newUser.getHashedPassword() + "\n");

    }

}