package exceptions;

public class InvaildAction extends RuntimeException {
    public InvaildAction() {
        super("Thats not a valid action!");
    }
}