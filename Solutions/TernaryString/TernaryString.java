package Solutions.TernaryString;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2023/7/22
 *
 * @author Daniel Atlas
 */
public class TernaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            String str = sc.next();
            int minLen = Integer.MAX_VALUE;
            if(str.length()<3){
                System.out.println(0);
            }
            else{
                int start = 0, end = 3;
                while(end<=str.length()){
                    if(isValid(str.substring(start, end))){
                        minLen = Math.min(minLen, end-start);
                        if(end-start==3){
                            break;
                        }
                        start++;
                    }
                    else{
                        end++;
                    }
                }
                if(minLen==Integer.MAX_VALUE){
                    System.out.println(0);
                }
                else{
                    System.out.println(minLen);
                }
            }
        }
    }

    public static boolean isValid(String str){
        boolean has1 = false, has2 = false, has3 = false;
        for(char c : str.toCharArray()) {
            if(c == '1') {
                has1 = true;
            }
            if(c == '2') {
                has2 = true;
            }
            if(c == '3') {
                has3 = true;
            }
            if(has1 && has2 && has3) {
                return true;
            }
        }
        return false;
    }
}
