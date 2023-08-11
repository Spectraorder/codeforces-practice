package Solutions.MaximumsandMinimums;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 2023/8/11
 *
 * @author Daniel Atlas
 */
public class MaximumsandMinimums {
    static final int N = 500_000 + 13;
    static final int A = 1_000_000 + 13;

    static ArrayList<Integer>[] divs = new ArrayList[A];
    static int[] a = new int[N];

    static int[] grLf = new int[N];
    static int[] grRg = new int[N];
    static int[] lessLf = new int[N];
    static int[] lessRg = new int[N];

    static ArrayList<Integer>[] pos = new ArrayList[A];
    static int[] ind = new int[A];
    public static void main(String[] args) {
        for(int i = 0; i < A; i++) {
            divs[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < A; i++) {
            for(int j = i; j < A; j += i) {
                divs[j].add(i);
            }
        }
        for(int i = 0; i < A; i++) {
            pos[i] = new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                pos[a[i]].add(i);
            }
            {
                Stack<Integer> st = new Stack<>();
                for(int i = 0; i < n; i++) {
                    while(!st.isEmpty() && a[st.peek()] < a[i]) {
                        st.pop();
                    }

                    grLf[i] = st.isEmpty() ? -1 : st.peek();
                    st.push(i);
                }
            }
            {
                Stack<Integer> st = new Stack<>();
                for(int i = n - 1; i >= 0; i--) {
                    while(!st.isEmpty() && a[st.peek()] <= a[i]) {
                        st.pop();
                    }

                    grRg[i] = st.isEmpty() ? n : st.peek();
                    st.push(i);
                }
            }
            {
                Stack<Integer> st = new Stack<>();
                for(int i = 0; i < n; i++) {
                    while(!st.isEmpty() && a[st.peek()] >= a[i]) {
                        st.pop();
                    }

                    lessLf[i] = st.isEmpty() ? -1 : st.peek();
                    st.push(i);
                }
            }
            {
                Stack<Integer> st = new Stack<>();
                for(int i = n - 1; i >= 0; i--) {
                    while(!st.isEmpty() && a[st.peek()] >= a[i]) {
                        st.pop();
                    }
                    lessRg[i] = st.isEmpty() ? n : st.peek();
                    st.push(i);
                }
            }
            long ans = 0;
            for(int i = 0; i < n; i++) {
                for(int x : divs[a[i]]) {
                    if(ind[x] >= 1) {
                        int j = pos[x].get(ind[x] - 1);
                        if(j > grLf[i] && lessRg[j] > i) {
                            ans += (long) (j - Math.max(grLf[i], lessLf[j]))
                                    * (Math.min(grRg[i], lessRg[j]) - i);
                        }
                    }
                    if(ind[x] < pos[x].size()) {
                        int j = pos[x].get(ind[x]);
                        if(j < grRg[i] && lessLf[j] < i) {
                            ans += (long) (i - Math.max(Math.max(grLf[i], lessLf[j]),
                                    ind[x] >= 1 ? pos[x].get(ind[x] - 1) : -1))
                                    * (Math.min(grRg[i], lessRg[j]) - j);
                        }
                    }
                }
                ind[a[i]]++;
            }
            System.out.println(ans);
            for(int i=0;i<n;i++) {
                pos[a[i]].clear();
                grLf[i] = grRg[i] = lessLf[i] = lessRg[i] = 0;
                ind[a[i]] = 0;
            }
        }
    }
}
