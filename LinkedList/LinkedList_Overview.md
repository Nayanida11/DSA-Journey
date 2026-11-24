# Linked List – Data Structures and Algorithms

## 1. Introduction

A **Linked List** is a linear data structure in which elements are stored in individual nodes. Each node contains data and one or more links (references) that connect it to other nodes.

Unlike arrays, linked list elements are not stored in contiguous memory locations. Memory is allocated dynamically as nodes are created.

### Structure of a Node

A node generally consists of:

- **Data:** Stores the actual value.
- **Link/Pointer:** Stores the reference to the next or previous node.

### Advantages
- Dynamic memory allocation.
- Efficient insertion and deletion.
- Does not require contiguous memory locations.
- Size can grow or shrink dynamically.

### Disadvantages
- Extra memory is required for storing links.
- No direct/random access to elements.
- Traversal is required to access a particular position.
- More complex implementation compared to arrays.

---

# 2. Types of Linked Lists

There are four major types of linked lists:

1. Singly Linked List (SLL)
2. Doubly Linked List (DLL)
3. Circular Singly Linked List (SCLL)
4. Circular Doubly Linked List (DCLL)

---

# 3. Singly Linked List (SLL)

### Definition

A Singly Linked List is a linear data structure in which each node contains data and a reference to the next node.

The last node points to `NULL`, indicating the end of the list.

### Node Structure

```java
private class Node {
    private int data;
    private Node next;
}
```

### Representation

`HEAD → 10 → 20 → 30 → 40 → NULL`

### Characteristics

- Each node contains data and one next reference.
- Traversal is possible only in the forward direction.
- The last node points to NULL.
- Requires less memory compared to DLL.

### Operations

| Operation | Description |
|---|---|
| Insert First | Adds a node at the beginning. |
| Insert Last | Adds a node at the end. |
| Insert at Position | Adds a node at a specified position. |
| Delete First | Removes the first node. |
| Delete Last | Removes the last node. |
| Delete at Position | Removes a node from a specified position. |
| Delete by Data | Searches and removes a node containing a given value. |
| Search | Finds whether a particular element exists. |
| Reverse | Reverses the direction of links. |
| Display | Traverses and displays all elements. |

### Real-Life Applications

1. **Music Playlist:** A basic playlist where songs are played in a fixed forward sequence.
2. **Image Slideshow:** Moving from one image to the next.
3. **Hash Table Chaining:** Handling collisions using linked lists.
4. **Dynamic Memory Management:** Maintaining lists of available memory blocks.

### When to Use SLL?

- When forward traversal is sufficient.
- When memory usage needs to be minimized.
- When frequent insertion and deletion at the beginning are required.

---

# 4. Doubly Linked List (DLL)

### Definition

A Doubly Linked List is a linear data structure in which each node contains data, a reference to the next node and a reference to the previous node.

The first node's previous reference and the last node's next reference point to NULL.

### Node Structure

```java
private class Node {
    private int data;
    private Node next;
    private Node prev;
}
```

### Representation

`NULL ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → NULL`

### Characteristics

- Each node contains three components: data, next and prev.
- Traversal is possible in both forward and backward directions.
- The first node's prev is NULL.
- The last node's next is NULL.
- Requires additional memory for the previous reference.

### Operations

| Operation | Description |
|---|---|
| Insert First | Adds a node at the beginning. |
| Insert Last | Adds a node at the end. |
| Insert at Position | Adds a node at a specified position. |
| Delete First | Removes the first node. |
| Delete Last | Removes the last node. |
| Delete at Position | Removes a node from a specified position. |
| Delete by Data | Removes a node containing a particular value. |
| Reverse | Reverses the links of the list. |
| Display Forward | Traverses from head to tail. |
| Display Backward | Traverses from tail to head. |

### Real-Life Applications

1. **Browser Navigation:** Moving between previously visited and next webpages.
2. **Undo and Redo Operations:** Moving backward and forward through editing actions.
3. **Music Player:** Moving to the previous or next song.
4. **Image Gallery:** Navigating between previous and next images.
5. **LRU Cache:** Efficiently managing recently used elements along with a hash map.

### When to Use DLL?

- When traversal in both directions is required.
- When frequent insertion and deletion at both ends are needed.
- When previous and next navigation is important.

---

# 5. Circular Singly Linked List (SCLL / CSLL)

### Definition

A Circular Singly Linked List is a variation of a singly linked list in which the last node points back to the first node instead of pointing to NULL.

This creates a circular structure.

### Node Structure

```java
private class Node {
    private int data;
    private Node next;
}
```

### Representation

`HEAD → 10 → 20 → 30 → 40`

` ↑_________________________|`

The last node points back to the head.

### Characteristics

- Each node contains data and a next reference.
- Traversal is possible only in the forward direction.
- The last node points back to the first node.
- There is no NULL link at the end.
- A tail reference allows insertion at the end in O(1) time.

### Operations

| Operation | Description |
|---|---|
| Insert First | Adds a node at the beginning and updates the tail link. |
| Insert Last | Adds a node at the end and connects it to the head. |
| Insert at Position | Adds a node at a specified position. |
| Delete First | Removes the first node and updates the tail link. |
| Delete Last | Removes the last node and updates the circular connection. |
| Delete at Position | Removes a node from a specified position. |
| Delete by Data | Searches and removes a node containing a particular value. |
| Reverse | Reverses the circular links. |
| Display | Traverses until the head is reached again. |

### Real-Life Applications

1. **Round Robin CPU Scheduling:** Processes receive CPU time in a circular order.
2. **Multiplayer Turn Systems:** Players get turns repeatedly in a fixed sequence.
3. **Circular Playlists:** Songs repeat automatically after the last song.
4. **Traffic Light Systems:** Signals change repeatedly in a fixed cycle.
5. **Token Ring Networks:** Devices communicate by passing a token in a circular sequence.

### When to Use SCLL?

- When repeated circular traversal is required.
- When the last element must connect to the first.
- When implementing round-robin scheduling.
- When forward traversal is sufficient.

---

# 6. Circular Doubly Linked List (DCLL)

### Definition

A Circular Doubly Linked List is a linked list in which each node contains data, a next reference and a previous reference.

The last node points to the first node, and the first node points back to the last node.

### Node Structure

```java
private class Node {
    private int data;
    private Node next;
    private Node prev;
}
```

### Representation

`10 ⇄ 20 ⇄ 30 ⇄ 40`

- `tail.next = head`
- `head.prev = tail`

Both forward and backward connections are circular.

### Characteristics

- Each node contains data, next and prev.
- Traversal is possible in both directions.
- The last node connects to the first node.
- The first node connects back to the last node.
- No NULL references are present in a non-empty circular list.

### Operations

| Operation | Description |
|---|---|
| Insert First | Adds a node at the beginning and updates circular links. |
| Insert Last | Adds a node at the end and updates circular links. |
| Insert at Position | Adds a node at a specified position. |
| Delete First | Removes the first node and updates head and tail connections. |
| Delete Last | Removes the last node and updates tail and head connections. |
| Delete at Position | Removes a node from a specified position. |
| Delete by Data | Removes a node containing a particular value. |
| Reverse | Reverses both next and previous links. |
| Display Forward | Traverses from head to tail and returns to head. |
| Display Backward | Traverses from tail to head and returns to tail. |

### Real-Life Applications

1. **Music Players:** Moving continuously between previous and next songs.
2. **Carousel Systems:** Navigating continuously in both directions.
3. **Multiplayer Games:** Players take turns in a circular order, with forward and backward navigation.
4. **Operating Systems:** Circular task scheduling with navigation between processes.
5. **Navigation Systems:** Moving through elements in both directions without reaching a NULL boundary.

### When to Use DCLL?

- When circular traversal in both directions is required.
- When continuous forward and backward navigation is needed.
- When insertion and deletion at both ends should be efficient.

---

# 7. Time and Space Complexity Comparison

Assumptions:
- SLL uses only a head reference.
- DLL maintains head and tail.
- SCLL maintains head and tail.
- DCLL maintains head and tail.
- Position-based operations use traversal.
- Space complexity represents auxiliary space, excluding the nodes stored in the list.

| Operation | SLL | DLL | SCLL | DCLL |
|---|---:|---:|---:|---:|
| Insert First | O(1) | O(1) | O(1) | O(1) |
| Insert Last | O(n) | O(1) | O(1) | O(1) |
| Insert Position | O(n) | O(n) | O(n) | O(n) |
| Delete First | O(1) | O(1) | O(1) | O(1) |
| Delete Last | O(n) | O(1) | O(n) | O(1) |
| Delete Position | O(n) | O(n) | O(n) | O(n) |
| Delete by Data | O(n) | O(n) | O(n) | O(n) |
| Search | O(n) | O(n) | O(n) | O(n) |
| Reverse | O(n) | O(n) | O(n) | O(n) |
| Display | O(n) | O(n) | O(n) | O(n) |

### Space Complexity

| Linked List | Space Per Node | Auxiliary Space for Reverse |
|---|---|---|
| SLL | O(1) | O(1) |
| DLL | O(1) | O(1) |
| SCLL | O(1) | O(1) |
| DCLL | O(1) | O(1) |

**Note:** Although the space complexity per node is O(1), DLL and DCLL require an additional reference per node compared to SLL and SCLL.

---

# 8. Comparison of All Four Linked Lists

| Feature | SLL | DLL | SCLL | DCLL |
|---|---|---|---|---|
| Number of links | 1 | 2 | 1 | 2 |
| Traversal | Forward | Both directions | Forward | Both directions |
| Last node points to | NULL | NULL | Head | Head |
| First node prev | Not present | NULL | Not present | Tail |
| Extra memory | Low | Higher | Low | Higher |
| Circular structure | No | No | Yes | Yes |
| Backward traversal | No | Yes | No | Yes |

---

# 9. Which Linked List Should Be Used?

| Scenario | Suitable Linked List | Reason |
|---|---|---|
| Simple forward traversal | SLL | Only one link is required. |
| Browser back and forward navigation | DLL | Supports traversal in both directions. |
| Round Robin CPU scheduling | SCLL | Repeated circular traversal. |
| Continuous music navigation | DCLL | Supports circular forward and backward navigation. |
| Memory-efficient linked list | SLL | Requires only one link per node. |
| Frequent insertion/deletion at both ends | DLL | Head and tail allow O(1) operations. |
| Circular turn-based systems | SCLL | Naturally represents repeated turns. |
| Circular navigation in both directions | DCLL | Supports two-way circular traversal. |

---

# 10. Important Points to Remember

1. SLL has one link per node and terminates with NULL.
2. DLL has two links per node and supports forward and backward traversal.
3. SCLL has one link per node, and the last node points to the head.
4. DCLL has two links per node, and both ends are connected circularly.
5. Insertion at the beginning takes O(1) in all four implementations.
6. Maintaining a tail reference makes insertion at the end O(1) in DLL, SCLL and DCLL.
7. Deletion at the end of SLL and SCLL takes O(n) because the previous node must be located.
8. Linked lists do not support direct indexing like arrays.
9. Position-based insertion and deletion generally require O(n) traversal.
10. Reversing a linked list can be performed in O(n) time and O(1) auxiliary space.

---

# 11. Conclusion

Linked Lists are important dynamic data structures that allow efficient insertion and deletion of elements.

Each type has its own advantages:

- **SLL:** Simple implementation and lower memory overhead.
- **DLL:** Supports forward and backward traversal.
- **SCLL:** Suitable for repeated circular traversal.
- **DCLL:** Supports continuous circular traversal in both directions.

The choice of linked list depends on the application's requirements, memory constraints and traversal needs.
```

