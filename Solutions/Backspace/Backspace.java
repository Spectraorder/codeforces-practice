package Solutions.Backspace;

import java.util.Scanner;

/**
 * 2023/7/30
 *
 * @author Daniel Atlas
 */
public class Backspace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while(c-->0){
            String s = sc.next();
            String t = sc.next();
            if(t.length()>s.length()){
                System.out.println("NO");
            }
            else{
                int posS = s.length()-1;
                int posT = t.length()-1;
                while(posS>=0&&posT>=0){
                    if(s.charAt(posS)==t.charAt(posT)){
                        posS--;
                        posT--;
                    }
                    else{
                        posS -= 2;
                    }
                }
                if(posT==-1){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
