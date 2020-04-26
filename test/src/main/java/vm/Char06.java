package vm;

public class Char06 {

    public static void main(String[] args) {
        try {
            mayThrowException();
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void mayThrowException() {

    }

}
