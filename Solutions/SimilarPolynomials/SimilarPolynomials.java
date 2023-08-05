package Solutions.SimilarPolynomials;

import java.util.Scanner;

/**
 * 2023/8/4
 *
 * @author Daniel Atlas
 */
public class SimilarPolynomials {
    static final int mod = 1000000007;

    static class Modular {
        int r;

        Modular() {
            r = 0;
        }

        Modular(long rr) {
            r = (int)(rr % mod);
            if(r < 0) {
                r += mod;
            }
        }

        Modular inv() {
            return pow(this, mod - 2);
        }

        Modular neg() {
            if(r == 0) {
                return new Modular(0);
            }
            return new Modular(mod - r);
        }

        Modular mul(Modular other) {
            return new Modular((long)r * other.r % mod);
        }

        Modular div(Modular other) {
            return mul(other.inv());
        }

        Modular add(Modular other) {
            Modular res = new Modular();
            res.r = r + other.r;
            if(res.r >= mod) {
                res.r -= mod;
            }
            return res;
        }

        Modular sub(Modular other) {
            Modular res = new Modular();
            res.r = r - other.r;
            if(res.r < 0) {
                res.r += mod;
            }
            return res;
        }

    }

    static Modular pow(Modular x, long n) {
        if(n == 0) {
            return new Modular(1);
        } else {
            Modular t = pow(x, n / 2);
            t = t.mul(t);
            if(n % 2 == 1) {
                t = t.mul(x);
            }
            return t;
        }
    }

    static Modular[] F = new Modular[300001];
    static Modular[] RF = new Modular[300001];

    static Modular fact(int n) {
        if(F[0] == null) {
            F[0] = new Modular(1);
            for(int i = 1; i < F.length; i++) {
                F[i] = F[i-1].mul(new Modular(i));
            }
        }
        return F[n];
    }

    static Modular rfact(int n) {
        if(RF[F.length-1] == null) {
            RF[F.length-1] = fact(F.length-1).inv();
            for(int i = F.length-2; i >= 0; i--) {
                RF[i] = RF[i+1].mul(new Modular(i+1));
            }
        }
        return RF[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        Modular[] A = new Modular[d+1];
        Modular[] B = new Modular[d+1];

        for(int i = 0; i <= d; i++) {
            A[i] = new Modular(sc.nextLong());
        }
        for(int i = 0; i <= d; i++) {
            B[i] = new Modular(sc.nextLong());
        }

        Modular s = new Modular(0);
        Modular k2 = new Modular(0);

        for(int i = 0; i <= d; i++) {
            Modular coef = new Modular((d - i) % 2 == 0 ? 1 : -1);
            coef = coef.mul(rfact(i));
            coef = coef.mul(rfact(d - i));

            s = s.add((A[i].sub(B[i])).mul(coef).mul(new Modular((long) d * (d + 1) / 2 - i)));
            k2 = k2.add((A[i].add(B[i])).mul(coef));
        }

        s = s.mul(new Modular(2)).div(k2.mul(new Modular(d)));

        System.out.println(s.r);

    }
}
