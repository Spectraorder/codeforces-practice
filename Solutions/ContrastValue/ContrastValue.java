package Solutions.ContrastValue;

import java.util.Scanner;

/**
 * 2023/8/5
 *
 * @author Daniel Atlas
 */
public class ContrastValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            if(n==1){
                System.out.println(1);
            }
            else{
                int prev = arr[0];
                int ascend = 0;
                int element = 1;
                int pos = 1;
                while(pos<n){
                    if(ascend==0){
                        if(arr[pos]>prev){
                            ascend = 1;
                            element++;
                        }
                        else if(arr[pos]<prev){
                            ascend = -1;
                            element++;
                        }
                    }
                    else{
                        if(arr[pos]>prev&&ascend<0){
                            ascend = 1;
                            element++;
                        }
                        else if(arr[pos]<prev&&ascend>0){
                            ascend = -1;
                            element++;
                        }
                    }
                    prev = arr[pos];
                    pos++;
                }
                System.out.println(element);
            }
        }
    }
}
