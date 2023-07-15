# CodeForces Practice
**Problems are shown in time order:**

## 2023/7/16 [1710E Two Array](https://codeforces.com/problemset/problem/1710/E): [IDEA Project](Solutions/TwoArray)

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
