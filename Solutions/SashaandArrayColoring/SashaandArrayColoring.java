package Solutions.SashaandArrayColoring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2023/7/21
 *
 * @author Daniel Atlas
 */
public class SashaandArrayColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-->0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            while(n-->0){
                nums[nums.length-n-1] = sc.nextInt();
            }
            Arrays.sort(nums);
            int res = 0;
            for(int i=0;i<nums.length/2;i++){
                res += nums[nums.length-i-1] - nums[i];
            }
            System.out.println(res);
        }
        sc.close();
    }
}
