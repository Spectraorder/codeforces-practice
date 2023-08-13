package Solutions.FromZeroToY;

import java.util.Scanner;

/**
 * 2023/8/11
 *
 * @author Daniel Atlas
 */
public class FromZeroToY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int ops = 0;
            while(y>=x){
                int tens = x;
                while(tens*10<y){
                    tens *= 10;
                }
                y -= tens;
                ops++;
            }
            System.out.println(ops+y);
        }
    }
}
