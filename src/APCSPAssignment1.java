
public class APCSPAssignment1 {
    public static void main(String[] args) {
        KeyboardReader reader = new KeyboardReader();
        System.out.println("Hello World!");
        String text = reader.readLine("Enter a string: ");
        System.out.println("You typed: " + text);
    }
}
