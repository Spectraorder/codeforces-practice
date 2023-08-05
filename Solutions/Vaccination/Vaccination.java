package Solutions.Vaccination;

import java.util.Scanner;

/**
 * 2023/8/4
 *
 * @author Daniel Atlas
 */
public class Vaccination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            int[] patient = new int[n];
            for(int i=0;i<n;i++){
                patient[i] = sc.nextInt();
            }
            int pack = 0;
            int pos = 0;
            while(pos<n){
                int dose = 1;
                int start = patient[pos];
                pos++;
                while(dose<k&&pos<n){
                    if(patient[pos]<=start+d+w){
                        dose++;
                        pos++;
                    }
                    else{
                        break;
                    }
                }
                pack++;
            }
            System.out.println(pack);
        }
    }
}
