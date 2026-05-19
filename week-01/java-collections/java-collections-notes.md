FULL COLLECTIONS MODULE SUMMARY

🔤 Key Vocabulary

| Term | Meaning |
|------|---------|
| Collection | Group of objects with common operations |
| List | Ordered collection, duplicates allowed |
| Set | Unique elements only, no duplicates |
| Map | Key-value pairs |
| ArrayList | Fast random access list |
| LinkedList | Fast insertion/deletion list |
| HashSet | Fast general purpose set |
| TreeSet | Sorted set |
| HashMap | Fast general purpose map |
| TreeMap | Sorted map by key |
| Iterator | Cursor to traverse collection safely |
| Generic type `<T>` | Specifies collection element type |
| Immutable | Cannot be changed after creation |
| Mutable | Can be changed |
| Unmodifiable | Read-only view of mutable collection |
| Stream | Pipeline for processing collections |

1️⃣ Collection Concepts

**Why Collections over Arrays:**

| | Arrays | Collections |
|---|--------|-------------|
| Size | Fixed size ❌ | Dynamic size ✅ |
| Methods | No built-in methods ❌ | Rich API ✅ |
| toString | No toString ❌ | Built-in toString ✅ |
| Removal | Hard to remove ❌ | Easy remove ✅ |

**Common Operations (ALL collections):**

```java
collection.add(item)        // add element
collection.remove(item)     // remove element
collection.contains(item)   // check exists
collection.size()           // count elements
collection.isEmpty()        // check if empty
collection.clear()          // remove all

// Bulk operations
collection.addAll(other)       // add all from other
collection.removeAll(other)    // remove all in other
collection.retainAll(other)    // keep only in other
collection.containsAll(other)  // check all exist
```

**Iterator (safe removal while looping):**

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    if (condition) it.remove(); // safe! ✅
}
```

2️⃣ Lists

**When to use:**
- Order matters + duplicates okay → List ✅

**ArrayList vs LinkedList:**
- ArrayList → fast get(index) → use 90% of time ✅
- LinkedList → fast add/remove middle → special cases

**Key Operations:**

```java
list.get(0)           // get by index
list.set(0, "new")    // replace by index
list.add(1, "insert") // insert at index
list.indexOf("item")  // find position
list.subList(0, 3)    // get portion
```

**Sorting:**

```java
Collections.sort(list)                        // ascending
Collections.sort(list, Collections.reverseOrder()) // descending
```

3️⃣ Maps

**When to use:**
- Key-value lookup needed → Map ✅
- "Give me X for Y"

**HashMap vs TreeMap:**
- HashMap → fast, no order → use most of time ✅
- TreeMap → sorted by key → when order needed

**Key Operations:**

```java
map.put(key, value)           // add/update
map.get(key)                  // retrieve
map.getOrDefault(key, 0)      // safe get
map.containsKey(key)          // check key exists
map.containsValue(val)        // check value exists
map.remove(key)               // delete

// Iterate
for (Map.Entry<K,V> entry : map.entrySet()) {
    entry.getKey();   // key
    entry.getValue(); // value
}
```

**Common Pattern — Word Frequency:**

```java
map.put(word, map.getOrDefault(word, 0) + 1);
```

**Immutable Keys Rule:**
- ALWAYS use immutable keys (String, Integer)
- NEVER mutate a key after putting in map!

4️⃣ Sets

**When to use:**
- Uniqueness matters → Set ✅
- No duplicates needed
- Fast existence check

**HashSet vs TreeSet:**
- HashSet → fast O(1) lookup → use most of time ✅
- TreeSet → sorted elements → when order needed

**Set Math Operations:**

```java
// Union - all elements from both
setA.addAll(setB);

// Intersection - common elements only
setA.retainAll(setB);

// Difference - in A but not B
setA.removeAll(setB);
```

**Codility Patterns:**

```java
// Check duplicates
Set<Integer> seen = new HashSet<>();
if (!seen.add(num)) { // duplicate! }

// Smallest missing positive
Set<Integer> set = new HashSet<>(Arrays.asList(arr));
int i = 1;
while (set.contains(i)) i++;
return i; // ✅
```

5️⃣ Collection Operations & Factories

**Factory Methods (Java 9+):**

```java
List.of("A", "B", "C")      // immutable list
Set.of("A", "B", "C")       // immutable set
Map.of("key", 1, "key2", 2) // immutable map
List.copyOf(existingList)    // independent copy
```

**Collections Utility:**

```java
Collections.sort(list)           // sort
Collections.shuffle(list)        // randomize
Collections.min(list) / Collections.max(list)  // find min/max
Collections.frequency(list, x)  // count occurrences
Collections.addAll(list, a,b,c) // add multiple
Collections.fill(list, value)   // fill with value
Collections.unmodifiableList(l) // read-only view
```

**Immutable vs Mutable vs Unmodifiable:**

| Type | Creation | Behavior |
|------|----------|----------|
| Immutable | `List.of()` | Cannot change ever |
| Mutable | `new ArrayList()` | Can change freely |
| Unmodifiable | `Collections.unmodifiableList()` | Read-only view, reflects original changes |

6️⃣ Streams (Quick Reference)

```java
list.stream()
    .filter(x -> x > 5)           // keep matching
    .map(x -> x * 2)              // transform
    .sorted()                      // sort
    .distinct()                    // remove duplicates
    .limit(5)                      // take first 5
    .collect(Collectors.toList())  // gather results
    .forEach(System.out::println)  // print each
    .reduce(0, Integer::sum)       // combine to one
```

🎯 When To Use Which Collection

```
┌─────────────────────────────────────┐
│ Do you need key-value pairs?        │
│ YES → Map (HashMap/TreeMap)         │
│                                     │
│ NO → Do you need unique elements?   │
│ YES → Set (HashSet/TreeSet)         │
│                                     │
│ NO → Use List (ArrayList)           │
└─────────────────────────────────────┘
```

🔥 Codility Cheat Sheet

```java
// Pattern 1: Find duplicates
Set<Integer> seen = new HashSet<>();
for (int n : arr) {
    if (!seen.add(n)) // duplicate found!
}

// Pattern 2: Count frequency
Map<Integer, Integer> freq = new HashMap<>();
for (int n : arr) {
    freq.put(n, freq.getOrDefault(n, 0) + 1);
}

// Pattern 3: Smallest missing positive
Set<Integer> set = new HashSet<>();
for (int n : arr) if (n > 0) set.add(n);
int i = 1;
while (set.contains(i)) i++;
return i;

// Pattern 4: Two sum
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    int complement = target - arr[i];
    if (map.containsKey(complement)) // found!
    map.put(arr[i], i);
}
```