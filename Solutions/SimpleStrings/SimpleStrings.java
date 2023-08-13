package Solutions.SimpleStrings;

import java.util.Scanner;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class SimpleStrings {
    static final int N = 200200;
    static int n;
    static char[] s = new char[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next().toCharArray();
        n = s.length;
        for(int i=0,j=0;i<n;i=j){
            while(j<n&&s[j]==s[i]){
                j++;
            }
            char c = 'a';
            while(c==s[i]||(i>0&&c==s[i-1])||(j<n&&c==s[j])){
                c++;
            }
            for(int k=i;k<j;k++){
                if((i+k)%2==1){
                    s[k] = c;
                }
            }
        }
        System.out.println(String.valueOf(s));
    }
}
