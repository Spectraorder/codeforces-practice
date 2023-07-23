package Solutions.TearItApart;

import java.util.Scanner;

/**
 * 2023/7/23
 *
 * @author Daniel Atlas
 */
public class TearItApart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            char charSep = 'a';
            int minAns = Integer.MAX_VALUE;
            for(int i=0;i<26;i++){
                charSep = (char) (i+'a');
                int maxBlock = 0;
                int curBlock = 0;
                for(char cur : s.toCharArray()){
                    if(cur!=charSep){
                        curBlock++;
                    }
                    else{
                        maxBlock = Math.max(maxBlock, curBlock);
                        curBlock = 0;
                    }
                }
                maxBlock = Math.max(maxBlock, curBlock);
                int times = 1;
                int ops = 0;
                while(times<=maxBlock){
                    times *= 2;
                    ops++;
                }
                minAns = Math.min(minAns, ops);
            }
            System.out.println(minAns);
        }
    }

}
