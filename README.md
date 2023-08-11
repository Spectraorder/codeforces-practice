# CodeForces Practice
**Problems are shown in time order:**

[2023/7/16](#2023/7/16) [2023/7/23](#2023/7/23) [2023/7/30](#2023/7/30) [2023/8/6](#2023/8/6) [2023/8/13](#2023/8/13) 

## 2023/8/13<a id="2023/8/13"></a>

### [1701E Text Editor](https://codeforces.com/problemset/problem/1701/E): [IDEA Project](Solutions/TextEditor)

The key ideas:

- We are given two strings s and t, and want to convert s to t with minimum moves
- Can use left, right, home, end, backspace buttons

Input:

- Read number of test cases T
- For each case, read lengths n and m of s and t
- Read strings s and t

Preprocessing:

- Use greedy approach to populate lpos[] and rpos[] arrays with valid leftmost and rightmost match positions for suffixes of t in s

Z-algorithm:

- For each pos, reverse s[0..pos] and concat with reversed t after #
- Call zf() to get Z values - longest prefix/suffix match lengths
- z[i] stores LCP length of reversed strings

Dynamic Programming:

- Try all pos and suf lengths
- Cost is prefix transform cost + suffix transform cost
- Prefix cost uses LCP values from Z array
- Minimize overall cost

Output:

- Print minimum number of moves
- Or -1 if not possible

Optimizations:

- Greedy lpos[] and rpos[] allow quick pruning of invalid pos/suf pairs
- Z-algorithm gives LCP values in O(N) time

Time Complexity:

- O(N^2) evaluating all pos and suf pairs
- O(N) for Z array per test case
- Total O(T*N^2)

Space Complexity:

- O(N) for lpos[], rpos[]
- O(N) for Z array
- O(N) per test case
- O(T*N) total

In summary, we use Z algorithm and DP with greedy preprocessing to minimize moves needed to transform s to t efficiently.

## 2023/8/6<a id="2023/8/6"></a>

### [1782E Rectangle Shrinking](https://codeforces.com/contest/1782/problem/E): [IDEA Project](Solutions/RectangleShrinking)

The key ideas:

- We are given a grid with n rectangles placed on it.
- We want to replace/remove rectangles to maximize area covered without overlaps.

Input:

- Read in number of test cases t.
- For each test case, read number of rectangles n.
- Read rectangle corners r1, c1, r2, c2 for each rectangle.

Sorting:

- Sort rectangles by left x coordinate c1.

Dynamic Programming:

- Use treeset s to track rightmost x coord of rectangles seen.
- Iterate rectangles in sorted order.
- Update ans with area gained by shrinking/removing.
- Update p1, p2 to track vertical constraints.
- Add rectangle right x coord to s if keeping rectangle.

Output:

- Print out maximum area ans.
- Print final rectangle coordinates after modifications.

Optimizations:

- Sorting by x coord allows incremental tracking of area.
- Treeset gives logN remove and add.

Time Complexity:

- O(N log N) for sorting rectangles
- O(N log N) for treeset operations
- Overall O(N log N)

Space Complexity:

- O(N) for rectangle coordinate arrays
- O(N) for treeset
- O(N) overall

In summary, we sort, use DP with a treeset to optimize rectangles left to right, maximizing area covered. This gives an overall O(N log N) solution.

### [1817C Similar Polynomials](https://codeforces.com/problemset/problem/1817/C): [IDEA Project](Solutions/SimilarPolynomials)

The key ideas:

- We are given two polynomials A(x) and B(x) of degree d.
- We want to find integer shift s such that B(x) = A(x+s) modulo 1000000007.

Input:

- Read in degree d.
- Read coefficients of A(x) from degree 0 to d.
- Read coefficients of B(x) from degree 0 to d.

Preprocessing:

- Define Modular class for modulo arithmetic.
- Precompute factorials F[] and reversed factorials RF[].

Lagrange Interpolation:

- Compute coefficients c_i for x^d and x^(d-1) terms of A(x) and B(x).
- Find leading coefficient k from x^d terms.
- Compute shift s from x^(d-1) terms and leading coefficient k.

Output:

- Print the computed shift s.

Optimizations:

- Modular class allows easy modulo operations.
- Precomputed factorials give O(1) access.

Time Complexity:

- O(d) to compute s from coefficients.

Space Complexity:

- O(d) for F[], RF[] arrays.
- O(1) extra space needed.

In summary, we use Lagrange interpolation with modulo arithmetic to find the polynomial shift in linear time and constant space. Precomputing factorials optimizes modular inverse operations.

## 2023/7/30<a id="2023/7/30"></a> [1809E Two Tanks](https://codeforces.com/problemset/problem/1809/E): [IDEA Project](Solutions/TwoTanks)

The key ideas:

- We want to find the maximum volume of water in tank 1 after performing all pouring operations, for all possible starting volumes.
- We simulate pouring operations to calculate final volume for each starting configuration.
- We store the final volumes in a 2D array ans[][] indexed by starting volumes.

Initializing:

- We take input n, a, b for number of operations, and tank capacities.
- We initialize `ans[a+1][b+1]` to store final volumes for each starting c, d.

Simulating:

- We loop through each possible total starting volume cd from 0 to a+b.
- For each cd, we calculate possible starting range l to r in tank 1.
- We apply all pouring operations vi to simulate pouring.
- We update `ans[c][d]` with final volume after pouring.

Optimization:

- By simulating the pouring, we directly calculate the final volume for each case.
- We avoid unnecessary work by precomputing for all starting points.

Time Complexity:

- O(AB) to simulate all starting volumes.

Space Complexity:

- O(AB) for the ans array.

In summary, we simulate pouring for all starting volumes and record the final volumes in ans[][] for querying later. This avoids re-simulating and gives us O(1) lookup.

## 2023/7/23<a id="2023/7/23"></a> [1837F Editorial for Two](https://codeforces.com/problemset/problem/1837/F): [IDEA Project](Solutions/EditorialforTwo)

The key ideas:

* We want to find the minimum maximum time needed to partition the array into 2 groups of size k. 
* To do this, we find the k smallest elements using a PriorityQueue.
* We store these k elements in minK[]. 
* We try all partitions of minK[] into 2 groups and take the min of the max times.

Initializing:

* We take input n, k, and array a[].
* We call getMinK() to find the k smallest elements in a[] using a PriorityQueue.
* This returns minK[], containing the k smallest elements of a[].

Sweeping: 

* We try all possible partitions of minK[] into 2 groups of sizes i and k-i.
* We compute the total time pTime for the first group of size i. 
* We compute the total time mTime for the second group of size k-i.
* We take the max of pTime and mTime.
* We minimize over all possible partitions. 

Optimization:

* By using a PriorityQueue, we find the k smallest elements in O(N) time. This is faster than sorting the entire array.

Time Complexity:  

* O(N + k^2)

  Finding k smallest elements is O(N) using PriorityQueue. Checking partitions is O(k^2).

Space Complexity:

* O(N)

  PriorityQueue and minK[] use O(N) space.

In summary, we use a PriorityQueue to find the k smallest elements, and efficiently partition them to minimize the maximum time needed. The full implementation handles all cases.

## 2023/7/16<a id="2023/7/16"></a> [1710E Two Array](https://codeforces.com/problemset/problem/1710/E): [IDEA Project](Solutions/TwoArray)

The key ideas:

- We want to find the maximum possible number of intersecting line segments between two sets of points.
- To do this, we sweep a vertical line from left to right, tracking the intersections.
- We use two auxiliary arrays db[] and da[] to track which points can intersect the current vertical line.

Initializing:

- We read in the two arrays of points a[] and b[].
- We sort a[] and b[] in increasing order.
- va and vb store the original first points.
- We binary search to find the new sorted positions of va and vb.

Sweeping:

- We sweep a vertical line from left to right, represented by the x value.
- db[j] tells us the furthest point in a[] that can intersect line b[j].
- da[i] tells us the furthest point in b[] that can intersect line a[i].
- We increment db[j] and da[i] as we sweep.
- sm tracks the current number of intersections.
- We compute f1 and f2, the max intersections with and without va-vb.

Optimization:

- As we sweep, we can decrement j and adjust sm when db[j] no longer intersects.
- This optimizes the number of steps rather than checking every pair.

Time Complexity:

* O(NlogN + MlogM)

Space Complexity:

* O(N + M)

In summary, we sweep vertically while tracking da[] and db[] to incrementally compute the optimal f1 and f2 values. The full implementation handles all the edge cases.

[d]: 
