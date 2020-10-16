public class A2 {

    public static void main(String[] args) {

        int i = -1;
        byte b = (byte) i;
        char c = (char) b;
        int fin = (int) c;

        System.out.println("Int: " + x);
        System.out.println("Byte: " + b);
        System.out.println("Char: " + c);
        System.out.println("Int: " + fin);

        if (x == fin) {
            System.out.println("Initial and final integers are equal");
        } 
        else {
            System.out.println("Initial and final integers are not Equal");
        }
    }
}