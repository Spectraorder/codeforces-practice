# CodeForces Practice
**Problems are shown in time order:**

[2023/7/16](#2023/7/16) [2023/7/23](#2023/7/23)[2023/7/30](#2023/7/30)

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
