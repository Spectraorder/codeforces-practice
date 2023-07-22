package Solutions.MaximumStrength;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 2023/7/22
 *
 * @author Daniel Atlas
 */
public class MaximumStrength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            String L = sc.next();
            String R = sc.next();
            BigInteger bigL = new BigInteger(L);
            BigInteger bigR = new BigInteger(R);
            L = String.format("%0" + R.length() + "d", bigL);
            int k = 0;
            while (k < L.length() && L.charAt(k) == R.charAt(k)) {
                k++;
            }
            int ans = 0;
            if(k<L.length()){
                ans += Math.abs(L.charAt(k) - R.charAt(k));
                ans += 9 * (L.length()-k-1);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
