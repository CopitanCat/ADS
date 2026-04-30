# Assignment – MyHashTable & BST

## Structure
```
src/
  MyHashTable.java     – Part 1.1 – generic chaining hash table
  MyTestingClass.java  – Part 1.2 – custom key class with hand-crafted hashCode()
  Student.java         – value type used in testing
  BST.java             – Part 2.1 + 2.2 – binary search tree with iterator
  Main.java            – Part 1.2 + 2.2 – all tests
```

## Compile & run
```bash
cd src
javac *.java
java Main
```

## Design decisions

### MyHashTable
* Separate chaining with a singly-linked list per bucket.
* `put` walks the chain first – if the key exists it updates the value, otherwise prepends a new node (O(1) amortised).
* `remove` uses a prev-pointer pattern to unlink the target node.
* `printBucketSizes()` prints how many elements each bucket holds (used to verify distribution).

### MyTestingClass.hashCode()
No `Objects.hash()`, `Arrays.hashCode()`, or `String.hashCode()` used.

Steps:
1. Multiply `id` by prime **1_000_003** → spreads consecutive integers across the bucket range.
2. Polynomial rolling hash over every `char` in `name` (multiplier **31**).
3. Avalanche mix: `h ^= (h >>> 16)` → scatters high bits down, preventing clustering when M is a power-of-two.

With 1 000 buckets and 10 000 random insertions the expected bucket size is 10; the avalanche step keeps the standard deviation near 3 (≈ ±30%).

### BST
* Standard recursive BST with Hibbard deletion (replaces deleted node with in-order successor).
* `size` field is maintained in `put` (increment on new node) and `delete` (decrement on actual removal).
* Iterator performs an **iterative in-order traversal** using an explicit `Stack<Node>` – no recursion, O(h) space.
* Each `next()` call returns a lightweight `Map.Entry<K,V>` so both `getKey()` and `getValue()` are accessible.
