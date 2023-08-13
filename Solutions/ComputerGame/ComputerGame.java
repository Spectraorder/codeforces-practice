package Solutions.ComputerGame;

import java.util.Scanner;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class ComputerGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long k = sc.nextInt();
            long n = sc.nextInt();
            long a = sc.nextInt();
            long b = sc.nextInt();
            if(k<=n*b){
                System.out.println(-1);
                continue;
            }
            k -= n*b;
            a -= b;
            System.out.println(Math.min(k%a==0 ? k/a-1 : k/a, n));
        }
    }
}
