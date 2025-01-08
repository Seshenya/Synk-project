import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SampleAppWithBugs {

    public static void main(String[] args) {
        System.out.println("Welcome to Snyk Code Bug Testing!"); // Proper comment format

        // Potential hardcoded sensitive information (security flaw)
        String apiKey = "1234567890abcdef"; 

        // Bad formatting
        int number= 10; // No spaces around "="
        if(number > 5)
            System.out.println("Number is greater than 5"); // Missing braces violation
        
        try {
            // Resource not closed properly, potential resource leak
            FileInputStream fis = new FileInputStream("example.txt"); 
            byte[] data = new byte[100];
            fis.read(data);
            System.out.println("Read data: " + new String(data));
        } catch (IOException e) {
            e.printStackTrace(); // Insecure exception handling
        }

        SampleAppWithBugs example = new SampleAppWithBugs();
        example.methodWithoutSpace(); // Bad formatting
        
        example.insecureRandomGenerator(); // Poor cryptographic practice
    }

    // Improperly formatted method (to test a rule)
    public void methodWithoutSpace(){System.out.println("Improper formatting");}

    // Insecure random number generation (security flaw)
    public void insecureRandomGenerator() {
        int randomNumber = (int) (Math.random() * 100); // Use SecureRandom instead
        System.out.println("Random number: " + randomNumber);
    }
    
    // Hardcoded file path (potential portability and security issue)
    public void hardcodedFilePath() {
        File file = new File("C:\\Users\\Admin\\data.txt");
        System.out.println("File exists: " + file.exists());
    }
}
