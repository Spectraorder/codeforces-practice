package Solutions.CombinatoricsHomework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2023/8/5
 *
 * @author Daniel Atlas
 */
public class CombinatoricsHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            int[] abc = {a, b, c};
            Arrays.sort(abc);
            a = abc[0];
            b = abc[1];
            c = abc[2];
            if (c-a-b-1<=m&&m<=a+b+c-3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
