import java.util.Scanner;

public class n {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int amount = scanner.nextInt();
            arr[i] = amount * y / x;
        }
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}