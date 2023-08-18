package Solutions.KingdomofCriticism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 2023/8/18
 *
 * @author Daniel Atlas
 */
public class KingdomofCriticism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> buildings = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> location = new HashMap<>();
        for(int i=0;i<N;i++){
            int height = sc.nextInt();
            HashSet<Integer> cur = location.getOrDefault(height, new HashSet<>());
            cur.add(i);
            location.put(height, cur);
            buildings.add(height);
        }
        int q = sc.nextInt();
        while(q-->0){
            int query = sc.nextInt();
            switch (query) {
                case 1 -> {
                    int k = sc.nextInt()-1;
                    int w = sc.nextInt();
                    if(location.get(buildings.get(k)).size()==1){
                        location.remove(buildings.get(k));
                    }
                    else{
                        location.get(buildings.get(k)).remove(k);
                    }
                    HashSet<Integer> cur = location.getOrDefault(w, new HashSet<>());
                    cur.add(k);
                    location.put(w, cur);
                    buildings.set(k, w);
                }
                case 2 -> {
                    int k = sc.nextInt()-1;
                    System.out.println(buildings.get(k));
                }
                case 3 -> {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    for(int i=l;i<=r;i++){
                        if(location.get(i)!=null){
                            HashSet<Integer> cur = location.get(i);
                            location.remove(i);
                            int newHeight = i-l>r-i ? r+1 : l-1;
                            location.put(newHeight, cur);
                            for(int build : cur){
                                buildings.set(build, newHeight);
                            }
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
