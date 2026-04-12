# Assignment 2 — ArrayList & LinkedList Data Structures

## Project Structure
 
```
src/
├── interfaces/
│   └── MyList.java          # Common interface for both physical structures
├── lists/
│   ├── MyArrayList.java     # Dynamic array implementation
│   └── MyLinkedList.java    # Doubly-linked list implementation
├── structures/
│   ├── MyStack.java         # LIFO stack   → backed by MyLinkedList
│   ├── MyQueue.java         # FIFO queue   → backed by MyLinkedList
│   └── MyMinHeap.java       # Min-Heap PQ  → backed by MyArrayList
└── Main.java                # All tests (55+ checks, PASS/FAIL output)
```

## How to Compile & Run
 
```bash
# From the project root
javac -d out src/interfaces/MyList.java \
             src/lists/MyArrayList.java \
             src/lists/MyLinkedList.java \
             src/structures/MyStack.java \
             src/structures/MyQueue.java \
             src/structures/MyMinHeap.java \
             src/Main.java
 
java -cp out Main
```

## Interface — MyList\<T\>
 
| Method | Description |
|--------|-------------|
| `add(T item)` | Append to end |
| `add(int index, T item)` | Insert at position |
| `set(int index, T item)` | Replace element |
| `get(int index)` | Retrieve element |
| `remove(int index)` | Remove by position |
| `size()` | Element count |
| `iterator()` | Forward iterator |

## Logical Structure APIs
 
### MyStack\<T\>
```java
void  push(T item)   // O(1)
T     pop()          // O(1) — throws EmptyStackException if empty
T     peek()         // O(1)
boolean isEmpty()
int   size()
```
 
### MyQueue\<T\>
```java
void  enqueue(T item)  // O(1)
T     dequeue()        // O(1) — throws NoSuchElementException if empty
T     peek()           // O(1)
boolean isEmpty()
int   size()
```
 
### MyMinHeap\<T extends Comparable\<T\>>
```java
void  insert(T item)    // O(log n)
T     getMin()          // O(1)
T     extractMin()      // O(log n)
boolean isEmpty()
int   size()
```
 
---
