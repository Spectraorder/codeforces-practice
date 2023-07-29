package Solutions.EmailfromPolycarp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2023/7/28
 *
 * @author Daniel Atlas
 */
public class EmailfromPolycarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String s = sc.next();
            String t = sc.next();
            List<List<Object>> sa = split(s);
            List<List<Object>> ta = split(t);
            boolean isValid=sa.size()==ta.size();
            if(isValid){
                for(int j=0;j<sa.size();j++){
                    if(sa.get(j).get(0)!=ta.get(j).get(0)||(Integer)sa.get(j).get(1)>(Integer)ta.get(j).get(1)) {
                        isValid = false;
                        break;
                    }
                }
            }
            System.out.println(isValid ? "YES" : "NO");
        }
    }

    public static List<List<Object>> split(String s) {
        char c = s.charAt(0);
        int cnt = 1;
        List<List<Object>> result = new ArrayList<>();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=c){
                List<Object> pair = new ArrayList<>();
                pair.add(c);
                pair.add(cnt);
                result.add(pair);
                c = s.charAt(i);
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        List<Object> pair = new ArrayList<>();
        pair.add(c);
        pair.add(cnt);
        result.add(pair);
        return result;
    }
}
