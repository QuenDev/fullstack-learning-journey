# Codility Problems — Complete Study Guide

---

## BinaryGap

**Difficulty:** Easy

**Description:** Find the longest sequence of zeros in binary representation of an integer.

**Approach & Pattern:**
- Convert integer to binary string
- Iterate through and count consecutive zeros
- Track maximum gap between ones

**What You'll Need:**
- String manipulation
- Array/String iteration
- Math utilities

```java
int solution(int N) {
    String bin = Integer.toBinaryString(N);
    int maxGap = 0, current = 0;
    for (char c : bin.toCharArray()) {
        if (c == '1') {
            maxGap = Math.max(maxGap, current);
            current = 0;
        } else {
            current++;
        }
    }
    return maxGap;
}
```

---

## CyclicRotation

**Difficulty:** Easy

**Description:** Rotate an array to the right by a given number of steps.

**Approach & Pattern:**
- Use modulo to handle rotation cycles
- Place each element at its target position directly
- Handle wrap-around with `(i + K) % n`

**What You'll Need:**
- Modulo arithmetic
- Array indexing
- Basic loop logic

```java
int[] solution(int[] A, int K) {
    int n = A.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[(i + K) % n] = A[i];
    }
    return result;
}
```

---

## OddOccurrencesInArray

**Difficulty:** Easy

**Description:** Find the value that occurs in an odd number of elements.

**Approach & Pattern:**
- XOR trick: `a ^ a = 0` and `a ^ 0 = a`
- All even-occurrence numbers cancel out
- Remaining is the odd-occurrence number

**What You'll Need:**
- Bitwise XOR operator
- Single pass through array
- Understanding of XOR properties

```java
int solution(int[] A) {
    int xor = 0;
    for (int num : A) xor ^= num;
    return xor;
}
```

---

## FrogJmp

**Difficulty:** Easy

**Description:** Count minimal number of jumps from position X to Y.

**Approach & Pattern:**
- Calculate distance: `Y - X`
- Divide by jump distance `D`
- Use ceiling division for minimum jumps

**What You'll Need:**
- Math ceiling function
- Type casting (double/int)
- Simple arithmetic

```java
int solution(int X, int Y, int D) {
    return (int) Math.ceil((double)(Y - X) / D);
}
```

---

## PermMissingElem

**Difficulty:** Easy

**Description:** Find the missing element in a given permutation (1 to n+1).

**Approach & Pattern:**
- Calculate expected sum: `(n+1) * (n+2) / 2`
- Calculate actual sum of given elements
- Missing = expected - actual

**What You'll Need:**
- Sum formula for arithmetic series
- Long type for large sums
- Basic arithmetic

```java
int solution(int[] A) {
    int n = A.length;
    long expected = (long)(n + 1) * (n + 2) / 2;
    long actual = 0;
    for (int num : A) actual += num;
    return (int)(expected - actual);
}
```

---

## TapeEquilibrium

**Difficulty:** Easy

**Description:** Minimize the value `|(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|`.

**Approach & Pattern:**
- Prefix sum technique: track left sum while iterating
- Right sum = total - left sum
- Find minimum difference at each split point

**What You'll Need:**
- Prefix sum pattern
- Min/Max tracking
- Absolute value calculation

```java
int solution(int[] A) {
    int total = 0;
    for (int num : A) total += num;
    int left = 0, minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < A.length - 1; i++) {
        left += A[i];
        int right = total - left;
        minDiff = Math.min(minDiff, Math.abs(left - right));
    }
    return minDiff;
}
```

---

## FrogRiverOne

**Difficulty:** Easy

**Description:** Find the earliest time when a frog can jump to the other side of a river.

**Approach & Pattern:**
- Track which positions have leaves (boolean array)
- Count covered positions
- Return index when all positions X are covered

**What You'll Need:**
- Boolean array for tracking
- Counter variable
- Single pass through array

```java
int solution(int X, int[] A) {
    boolean[] seen = new boolean[X+1];
    int filled = 0;
    for (int i = 0; i < A.length; i++) {
        if (!seen[A[i]]) {
            seen[A[i]] = true;
            filled++;
            if (filled == X) return i;
        }
    }
    return -1;
}
```

---

## PermCheck

**Difficulty:** Medium

**Description:** Check whether array A is a permutation (all numbers 1 to n present exactly once).

**Approach & Pattern:**
- Mark seen elements in boolean array
- Validate range: 1 ≤ element ≤ n
- Check no duplicates

**What You'll Need:**
- Boolean array for marking
- Range validation
- Early exit on invalid element

```java
int solution(int[] A) {
    int n = A.length;
    boolean[] seen = new boolean[n+1];
    for (int num : A) {
        if (num < 1 || num > n || seen[num]) return 0;
        seen[num] = true;
    }
    return 1;
}
```

---

## MaxCounters

**Difficulty:** Medium

**Description:** Calculate counter values after alternating operations: increase counter by 1 or set all to max.

**Approach & Pattern:**
- Track current max and base value
- Lazy update: use base for optimization (avoid O(n) full resets)
- Final pass to apply base value to all counters

**What You'll Need:**
- Array manipulation
- Lazy propagation concept
- Min/Max tracking

```java
int[] solution(int N, int[] A) {
    int[] counters = new int[N];
    int max = 0, base = 0;
    for (int op : A) {
        if (op >= 1 && op <= N) {
            int idx = op - 1;
            if (counters[idx] < base) counters[idx] = base;
            counters[idx]++;
            max = Math.max(max, counters[idx]);
        } else {
            base = max;
        }
    }
    for (int i = 0; i < N; i++) {
        if (counters[i] < base) counters[i] = base;
    }
    return counters;
}
```

---

## MissingInteger

**Difficulty:** Easy

**Description:** Find the smallest positive integer that does not occur in a given sequence.

**Approach & Pattern:**
- Store all positive numbers in HashSet
- Start from 1 and check consecutive integers
- Return first missing positive

**What You'll Need:**
- HashSet for O(1) lookup
- Filtering (only positive numbers)
- While loop with increment

```java
int solution(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int num : A) if (num > 0) set.add(num);
    int i = 1;
    while (set.contains(i)) i++;
    return i;
}
```

---

## PassingCars

**Difficulty:** Medium

**Description:** Count the number of passing cars on the road (0=going east, 1=going west).

**Approach & Pattern:**
- Count zeros (eastbound cars)
- For each one (westbound), add count of zeros before it
- Check for overflow (pairs > 1,000,000,000)

**What You'll Need:**
- Counter tracking
- Accumulation pattern
- Overflow checking

```java
int solution(int[] A) {
    int zeros = 0, pairs = 0;
    for (int car : A) {
        if (car == 0) zeros++;
        else pairs += zeros;
        if (pairs > 1000000000) return -1;
    }
    return pairs;
}
```

---

## CountDiv

**Difficulty:** Medium

**Description:** Compute number of integers divisible by K in range [A..B].

**Approach & Pattern:**
- Count multiples of K up to B: `B / K`
- Subtract multiples up to A-1: `(A-1) / K`
- Mathematical formula (no loop needed!)

**What You'll Need:**
- Integer division
- Math formula understanding
- No array iteration needed

```java
int solution(int A, int B, int K) {
    return B / K - (A - 1) / K;
}
```

---

## GenomicRangeQuery

**Difficulty:** Medium

**Description:** Find the minimal nucleotide from a range of sequence DNA (A, C, G, T have values 1-4).

**Approach & Pattern:**
- Prefix sums: build 4 arrays (one per nucleotide)
- For each query, check ranges in prefix arrays
- Return minimum nucleotide value

**What You'll Need:**
- Prefix sum array technique
- Multiple array tracking
- Range query optimization

```java
// Build prefix sums for each nucleotide
// Then answer range queries in O(1)
```

---

## MinAvgTwoSlice

**Difficulty:** Easy

**Description:** Find the minimal average of any slice containing at least two elements.

**Approach & Pattern:**
- Check all slices of size 2 and 3
- Minimal average in any longer slice contains a minimal 2 or 3 slice
- Track minimum and its index

**What You'll Need:**
- Slice iteration (2 and 3 size)
- Average calculation
- Index tracking

```java
int solution(int[] A) {
    int minIndex = 0;
    double minAvg = Double.MAX_VALUE;
    for (int i = 0; i < A.length - 1; i++) {
        double avg2 = (A[i] + A[i+1]) / 2.0;
        if (avg2 < minAvg) { minAvg = avg2; minIndex = i; }
        if (i < A.length - 2) {
            double avg3 = (A[i] + A[i+1] + A[i+2]) / 3.0;
            if (avg3 < minAvg) { minAvg = avg3; minIndex = i; }
        }
    }
    return minIndex;
}
```

---

## Distinct

**Difficulty:** Easy

**Description:** Compute number of distinct values in an array.

**Approach & Pattern:**
- Use HashSet to store unique values
- Return set size

**What You'll Need:**
- HashSet data structure
- Simple iteration
- Set size method

```java
int solution(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int num : A) set.add(num);
    return set.size();
}
```

---

## MaxProductOfThree

**Difficulty:** Easy

**Description:** Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).

**Approach & Pattern:**
- Sort array
- Max product is either: 3 largest OR 2 smallest (negatives) * 1 largest
- Check both possibilities

**What You'll Need:**
- Sorting
- Math.max for comparison
- Index arithmetic

```java
int solution(int[] A) {
    Arrays.sort(A);
    int n = A.length;
    return Math.max(A[n-1]*A[n-2]*A[n-3], A[0]*A[1]*A[n-1]);
}
```

---

## Triangle

**Difficulty:** Medium

**Description:** Determine whether a triangle can be built from a given set of edges.

**Approach & Pattern:**
- Sort edges
- For sorted array, check if `A[i] + A[i+1] > A[i+2]` for consecutive triplets
- If true for any triplet, return 1

**What You'll Need:**
- Sorting
- Triangle inequality check
- Long type for overflow prevention

```java
int solution(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length - 2; i++) {
        if ((long)A[i] + A[i+1] > A[i+2]) return 1;
    }
    return 0;
}
```

---

## Brackets

**Difficulty:** Easy

**Description:** Determine whether a given string of parentheses (multiple types) is properly nested.

**Approach & Pattern:**
- Use Stack for matching brackets
- Push opening brackets
- Pop and match closing brackets
- Stack must be empty at end

**What You'll Need:**
- Stack data structure
- Character matching logic
- Stack isEmpty/push/pop methods

```java
int solution(String S) {
    Stack<Character> stack = new Stack<>();
    for (char c : S.toCharArray()) {
        if (c=='('||c=='{'||c=='[') stack.push(c);
        else {
            if (stack.isEmpty()) return 0;
            char top = stack.pop();
            if ((c==')'&&top!='(')||(c=='}'&&top!='{')||(c==']'&&top!='[')) return 0;
        }
    }
    return stack.isEmpty() ? 1 : 0;
}
```

---

## Fish

**Difficulty:** Easy

**Description:** N voracious fish are moving along a river. Calculate how many fish are alive (0=moving upstream, 1=moving downstream).

**Approach & Pattern:**
- Stack for downstream fish (direction 1)
- When upstream fish appears: remove smaller downstream fish
- Count remaining fish

**What You'll Need:**
- Stack data structure
- Fish direction tracking
- Size comparison logic

```java
int solution(int[] A, int[] B) {
    Stack<Integer> stack = new Stack<>();
    int alive = 0;
    for (int i = 0; i < A.length; i++) {
        if (B[i] == 1) stack.push(A[i]);
        else {
            while (!stack.isEmpty() && stack.peek() < A[i]) stack.pop();
            if (stack.isEmpty()) alive++;
        }
    }
    return alive + stack.size();
}
```

---

## MaxSliceSum

**Difficulty:** Medium

**Description:** Find a maximum sum of a compact subsequence of array elements.

**Approach & Pattern:**
- Kadane's Algorithm: dynamic programming
- Track max ending at current position
- Update global maximum
- Handle negative numbers correctly

**What You'll Need:**
- Kadane's algorithm pattern
- Dynamic programming concept
- Max tracking

```java
int solution(int[] A) {
    int maxEnding = A[0], maxSlice = A[0];
    for (int i = 1; i < A.length; i++) {
        maxEnding = Math.max(A[i], maxEnding + A[i]);
        maxSlice = Math.max(maxSlice, maxEnding);
    }
    return maxSlice;
}
```

---

## CountFactors

**Difficulty:** Easy

**Description:** Count factors of given number N.

**Approach & Pattern:**
- Iterate up to √N only
- For each divisor i, count both i and N/i
- Avoid double-counting if i² = N

**What You'll Need:**
- Square root optimization
- Divisor checking
- Pair counting logic

```java
int solution(int N) {
    int count = 0;
    for (int i = 1; i * i <= N; i++) {
        if (N % i == 0) {
            count++;                 // factor i
            if (i != N / i) count++; // paired factor
        }
    }
    return count;
}
```

---

## Flags

**Difficulty:** Medium

**Description:** Find the maximum number of flags that can be set on mountain peaks.

**Approach & Pattern:**
- Find all peaks (local maxima)
- Binary search on number of flags K
- Greedy placement: place flag, skip K positions for next
- Check if we can place K flags

**What You'll Need:**
- Peak detection
- Greedy algorithm
- Binary search (or iteration)
- ArrayList for peaks

```java
int solution(int[] A) {
    List<Integer> peaks = new ArrayList<>();
    for (int i = 1; i < A.length - 1; i++) {
        if (A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
    }
    int maxFlags = 0;
    for (int k = 1; k <= peaks.size(); k++) {
        int used = 1, last = peaks.get(0);
        for (int j = 1; j < peaks.size() && used < k; j++) {
            if (peaks.get(j) - last >= k) {
                used++;
                last = peaks.get(j);
            }
        }
        maxFlags = Math.max(maxFlags, used);
    }
    return maxFlags;
}
```

---

## StoneWall

**Difficulty:** Medium

**Description:** Cover "Manhattan skyline" using the minimum number of rectangles.

**Approach & Pattern:**
- Stack-based approach: maintain skyline profile
- For each height: pop taller blocks, push new height
- Count new blocks added

**What You'll Need:**
- Stack data structure
- Skyline profile concept
- Height tracking

```java
int solution(int[] H) {
    Stack<Integer> stack = new Stack<>();
    int blocks = 0;
    for (int h : H) {
        while (!stack.isEmpty() && stack.peek() > h) stack.pop();
        if (stack.isEmpty() || stack.peek() < h) {
            stack.push(h);
            blocks++;
        }
    }
    return blocks;
}
```

---

## MaxProfit

**Difficulty:** Easy

**Description:** Given a log of stock prices compute the maximum possible earning.

**Approach & Pattern:**
- Track minimum price seen so far
- For each price, calculate profit if sold at current price
- Update maximum profit

**What You'll Need:**
- Min/Max tracking
- Single pass through array
- Subtraction for profit

```java
int solution(int[] A) {
    int minPrice = Integer.MAX_VALUE, maxProfit = 0;
    for (int price : A) {
        minPrice = Math.min(minPrice, price);
        maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
}
```

---

## EquiLeader

**Difficulty:** Medium

**Description:** Find the index S such that leaders of left part A[0..S] and right part A[S+1..N-1] are the same.

**Approach & Pattern:**
- Step 1: Find overall leader using Boyer-Moore algorithm
- Step 2: Verify it's actually a leader (occurs > n/2 times)
- Step 3: Count positions where it's leader on both sides

**What You'll Need:**
- Boyer-Moore leader finding
- Count verification
- Left/right side analysis

```java
int solution(int[] A) {
    // Step 1: find leader candidate
    int size = 0, value = 0;
    for (int num : A) {
        if (size == 0) { value = num; size++; }
        else if (value == num) size++;
        else size--;
    }
    // Step 2: verify leader
    int count = 0;
    for (int num : A) if (num == value) count++;
    if (count <= A.length/2) return 0;
    // Step 3: count equi leaders
    int equi = 0, leftCount = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] == value) leftCount++;
        if (leftCount > (i+1)/2 && (count-leftCount) > (A.length-i-1)/2) equi++;
    }
    return equi;
}
```

---

## TieRopes

**Difficulty:** Easy

**Description:** Tie adjacent ropes to achieve the maximum number of ropes of length ≥ K.

**Approach & Pattern:**
- Greedy accumulation: tie ropes together greedily
- When sum ≥ K, we have one rope
- Reset counter and continue

**What You'll Need:**
- Greedy algorithm pattern
- Accumulation/summation
- Counter management

```java
int solution(int K, int[] A) {
    int ropes = 0, length = 0;
    for (int rope : A) {
        length += rope;
        if (length >= K) {
            ropes++;
            length = 0;
        }
    }
    return ropes;
}
```

---

# Dynamic Programming Section

## NumberSolitaire

**Difficulty:** Hard

**Description:** In a given array, find the subset of maximal sum where distance between consecutive elements is at most 6.

**Approach & Pattern:**
- Dynamic Programming: `dp[i]` = max sum reaching position i
- Transition: `dp[i] = max(dp[i-1..i-6]) + A[i]`
- Check all possible jumps of 1-6 steps

**What You'll Need:**
- DP array
- Loop over last 6 positions
- Max tracking

```java
int solution(int[] A) {
    int n = A.length;
    int[] dp = new int[n];
    dp[0] = A[0];
    for (int i = 1; i < n; i++) {
        int best = Integer.MIN_VALUE;
        for (int dice = 1; dice <= 6; dice++) {
            if (i - dice >= 0) best = Math.max(best, dp[i - dice]);
        }
        dp[i] = best + A[i];
    }
    return dp[n-1];
}
```

---

## MinAbsSum

**Difficulty:** Hard

**Description:** Given array of integers, find the lowest absolute sum of elements.

**Approach & Pattern:**
- DP over possible sums (partition into two sets)
- `dp[s]` = whether sum s is achievable
- Find sum closest to half of total

**What You'll Need:**
- DP array with sum states
- Set theory (partition problem)
- Array copying and updating
- Math calculations

```java
int solution(int[] A) {
    int sum = 0;
    for (int i = 0; i < A.length; i++) A[i] = Math.abs(A[i]);
    for (int num : A) sum += num;

    int[] dp = new int[sum+1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (int num : A) {
        int[] next = Arrays.copyOf(dp, dp.length);
        for (int s = 0; s <= sum; s++) {
            if (dp[s] >= 0) {
                next[s] = num;
                if (s + num <= sum) next[s + num] = num;
            }
        }
        dp = next;
    }

    int result = sum;
    for (int s = 0; s <= sum/2; s++) {
        if (dp[s] >= 0) result = Math.min(result, sum - 2*s);
    }
    return result;
}
```

---

## FibFrog

**Difficulty:** Medium

**Description:** Count the minimum number of jumps required for a frog to get to the other side of a river.

**Approach & Pattern:**
- BFS/Shortest path: frog can jump Fibonacci distances
- Generate Fibonacci numbers up to N+1
- Use Queue to find minimum jumps
- Track visited positions

**What You'll Need:**
- Fibonacci generation
- BFS algorithm
- Queue data structure
- Visited array for memoization

```java
int solution(int[] A) {
    int n = A.length;
    List<Integer> fibs = new ArrayList<>();
    fibs.add(1); fibs.add(2);
    while (fibs.get(fibs.size()-1) <= n+1) {
        int size = fibs.size();
        fibs.add(fibs.get(size-1) + fibs.get(size-2));
    }

    Queue<int[]> q = new LinkedList<>();
    boolean[] visited = new boolean[n+1];
    q.add(new int[]{-1,0}); // position, jumps

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int pos = cur[0], jumps = cur[1];
        for (int f : fibs) {
            int next = pos + f;
            if (next == n) return jumps+1;
            if (next < n && next >= 0 && A[next]==1 && !visited[next]) {
                visited[next] = true;
                q.add(new int[]{next, jumps+1});
            }
        }
    }
    return -1;
}
```

---

## Ladder

**Difficulty:** Medium

**Description:** Count the number of different ways of climbing to the top of a ladder (N steps, up to 2 steps at a time).

**Approach & Pattern:**
- DP with Fibonacci pattern: `dp[i] = dp[i-1] + dp[i-2]`
- Modulo arithmetic: apply modulo `2^B[i]` to each result
- Pre-compute Fibonacci sequence

**What You'll Need:**
- DP array for Fibonacci
- Modulo operations
- Bit shifting (`1 << B` for 2^B)
- Stream.max() for finding max

```java
int[] solution(int[] A, int[] B) {
    int maxN = Arrays.stream(A).max().getAsInt();
    int[] fib = new int[maxN+2];
    fib[0] = 0; fib[1] = 1;
    for (int i = 2; i <= maxN+1; i++) {
        fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30);
    }

    int[] result = new int[A.length];
    for (int i = 0; i < A.length; i++) {
        result[i] = fib[A[i]+1] % (1 << B[i]);
    }
    return result;
}
```

---

## Study Tips for Exam

1. **Pattern Recognition is Key:** Most problems follow one of these patterns:
   - Prefix sums
   - Greedy algorithms
   - Stack-based solutions
   - Dynamic programming
   - Sorting + two-pointer

2. **Time Complexity Awareness:**
   - Easy problems: usually O(n) or O(n log n)
   - Medium problems: may need O(n²) but optimizable
   - Hard problems: often require clever DP or mathematical insight

3. **Common Data Structures:**
   - Arrays for storage
   - HashSet for uniqueness/quick lookup
   - Stack for bracket matching, skyline problems
   - Queue for BFS problems

4. **Edge Cases to Consider:**
   - Empty arrays
   - Single element
   - All same elements
   - Negative numbers
   - Overflow (use long when needed)

5. **Practice Approach:**
   - Read problem carefully
   - Identify the pattern/category
   - Check constraints (affects time complexity choice)
   - Code solution
   - Test with examples
   - Think of edge cases
