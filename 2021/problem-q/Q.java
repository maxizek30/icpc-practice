import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            String currString = scanner.nextLine();
            System.out.println("Scanning: " + currString.length()   );
            boolean isFalse = false;
            for(int j = 0; j < currString.length(); j = j + 7) {
                Set<Character> compareSet = new HashSet<Character>();
                for(int k = 0; k < 7; k++) {
                
                    int index = j + k;
                    if(index < currString.length()){
                        if(compareSet.contains(currString.charAt(index))) {
                            isFalse = true;
                            break;
                        }
                        compareSet.add(currString.charAt(index));
                    }
                   
                }
                if(isFalse) {
                    break;
                }
               
        
            }
            if(isFalse) {
                System.out.println(0);
                break;
            } else {
                System.out.println(1);
            }
            
            
            
        }
    }
}