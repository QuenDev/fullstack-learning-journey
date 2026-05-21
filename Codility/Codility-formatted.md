# Codility Core Problems 

## BinaryGap

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

```java
int solution(int[] A) {
    int xor = 0;
    for (int num : A) xor ^= num;
    return xor;
}
```

---

## FrogJmp

```java
int solution(int X, int Y, int D) {
    return (int) Math.ceil((double)(Y - X) / D);
}
```

---

## PermMissingElem

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

```java
int solution(int A, int B, int K) {
    return B / K - (A - 1) / K;
}
```

---

## GenomicRangeQuery

**Pattern:** Prefix sums per nucleotide (A, C, G, T). Build arrays, then query ranges.

---

## MinAvgTwoSlice

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

```java
int solution(int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int num : A) set.add(num);
    return set.size();
}
```

---

## MaxProductOfThree

```java
int solution(int[] A) {
    Arrays.sort(A);
    int n = A.length;
    return Math.max(A[n-1]*A[n-2]*A[n-3], A[0]*A[1]*A[n-1]);
}
```

---

## Triangle

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

**Pattern:** Loop up to √N, count both i and N/i.

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

**Pattern:** Greedy placement on peaks.

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

**Pattern:** Stack tracks skyline heights.

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

**Pattern:** Track min price, max difference.

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

**Pattern:** Leader left vs right.

```java
int solution(int[] A) {
    // Step 1: find leader candidate using stack method
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

**Pattern:** Greedy accumulation until ≥K.

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

# Dynamic Programming

## NumberSolitaire

**Pattern:** Max sum path with dice rolls (state = index, transition = last 6 steps).

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

**Pattern:** Subset sum variation: minimize absolute sum using DP over possible totals.

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

**Pattern:** Frog jumps with Fibonacci distances → DP/BFS to find minimum jumps.

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

**Pattern:** Ways to climb ladder steps → Fibonacci DP with modulo.

```java
int[] solution(int[] A, int[] B) {
    int maxN = Arrays.stream(A).max().getAsInt();
    int[] fib = new int[maxN+2];
    fib[0] = 0; fib[1] = 1;
    for (int i = 2; i <= maxN+1; i++) {
        fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30); // large modulus
    }

    int[] result = new int[A.length];
    for (int i = 0; i < A.length; i++) {
        result[i] = fib[A[i]+1] % (1 << B[i]);
    }
    return result;
}
```
