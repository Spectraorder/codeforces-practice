package Solutions.KeepitBeautiful;

import java.util.Scanner;

/**
 * 2023/7/28
 *
 * @author Daniel Atlas
 */
public class KeepitBeautiful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            StringBuilder output = new StringBuilder();
            int start = 0, end = 0, prev = 0;
            boolean isSorted = true;
            for(int i=0;i<n;i++){
                if(i==0){
                    output.append("1");
                    start = sc.nextInt();
                    end = start;
                }
                else{
                    int cur = sc.nextInt();
                    if(isSorted&&cur>=end){
                        end = cur;
                        output.append("1");
                    }
                    else if(isSorted&&cur<=start){
                        isSorted = false;
                        prev = cur;
                        output.append("1");
                    }
                    else{
                        if(cur<=start&&cur>=prev){
                            prev = cur;
                            output.append("1");
                        }
                        else{
                            output.append("0");
                        }
                    }
                }
            }
            System.out.println(output);
        }
    }
}
