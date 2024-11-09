import java.util.Scanner;

public class r {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        

        int count = 0;
        for(int i = 0; i < 4; i++) {
            if(num1.charAt(i) == num2.charAt(i)) {
                count = count + 1;
            }
        }
        count = 4 - count;
        System.out.println((int) Math.pow(2, count));

    }
}
