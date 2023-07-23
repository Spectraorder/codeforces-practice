package Solutions.DoubleCola;

import java.util.Scanner;

/**
 * 2023/7/22
 *
 * @author Daniel Atlas
 */
public class DoubleCola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = 5;
        while(n>total){
            n -= total;
            total *= 2;
        }
        int index = (n-1)/(total/5);
        String name = switch (index) {
            case 0 -> "Sheldon";
            case 1 -> "Leonard";
            case 2 -> "Penny";
            case 3 -> "Rajesh";
            default -> "Howard";
        };
        System.out.println(name);
    }
}
