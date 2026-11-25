# QUEUE (Data Structure)

## 1. Definition

A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.

This means the element inserted first is the first element to be removed.

Insertion takes place at one end called **REAR**, and deletion takes place at the other end called **FRONT**.

### Example

Consider a queue of people waiting at a ticket counter:

- A person who arrives first gets served first.
- New people join at the rear.
- The person at the front leaves after receiving the service.

This follows the FIFO principle.

---

## 2. Basic Operations

| Operation | Description |
|---|---|
| ENQUEUE | Inserts an element at the rear of the queue. |
| DEQUEUE | Removes and returns the front element. |
| PEEK | Returns the front element without removing it. |
| DISPLAY | Displays all elements from front to rear. |
| isEmpty | Checks whether the queue is empty. |
| isFull | Checks whether the queue is full (array implementation). |

### Example

Initially:

```text
FRONT → NULL
REAR  → NULL
```

After ENQUEUE(10), ENQUEUE(20), ENQUEUE(30):

```text
FRONT                 REAR
  |                     |
  ↓                     ↓
 10  →  20  →  30  →  NULL
```

After DEQUEUE():

```text
FRONT          REAR
  |              |
  ↓              ↓
 20  →  30  →  NULL
```

PEEK() returns 20 without removing it.

---

## 3. Types of Queue

### A. Simple (Linear) Queue

- Follows FIFO.
- Insertion takes place at REAR.
- Deletion takes place at FRONT.
- In a basic array implementation, deleted positions may remain unused.
- Can suffer from false overflow when REAR reaches the last array index even though earlier positions are empty.

### B. Circular Queue

- The last position is connected logically to the first position.
- Reuses empty positions created after deletion.
- Uses the modulo (%) operator to achieve circular movement.
- Avoids the space wastage problem of a simple array queue.

**Important formula:**

Next insertion position:

```java
(rear + 1) % capacity
```

Next front position:

```java
(front + 1) % capacity
```

### C. Linked List-Based Queue

- Uses nodes to store elements.
- Each node contains data and a reference to the next node.
- Maintains FRONT and REAR references.
- Grows dynamically until available memory is exhausted.
- Does not require a fixed capacity.

### D. Priority Queue

- Elements are served according to their priority rather than simply their insertion order.
- Higher-priority elements are removed before lower-priority elements.
- Elements with equal priority may follow FIFO ordering, depending on the implementation.

Example: Patients with critical medical conditions are treated before less critical patients.

---

## 4. Operations and Time Complexity

### Array-Based Circular Queue

| Operation | Time Complexity |
|---|---|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek | O(1) |
| Display | O(n) |
| isEmpty | O(1) |
| isFull | O(1) |

### Linked List-Based Queue

Assuming both FRONT and REAR references are maintained:

| Operation | Time Complexity |
|---|---|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek | O(1) |
| Display | O(n) |
| isEmpty | O(1) |

**Important:** If only FRONT is maintained, ENQUEUE requires traversal to find the last node, making its time complexity O(n).

### Space Complexity

| Implementation | Space Complexity |
|---|---|
| Array Queue | O(n) |
| Linked List Queue | O(n) |

Here, n represents the number of elements stored (or the allocated capacity for an array).

---

## 5. Queue Overflow and Underflow

### Queue Overflow

Occurs when we try to insert an element into an already full fixed-capacity queue.

Example:

If capacity = 3:

```text
FRONT              REAR
  |                  |
  ↓                  ↓
 10  →  20  →  30
```

Trying ENQUEUE(40) results in Queue Overflow.

This applies to a fixed-capacity array queue.

### Queue Underflow

Occurs when we try to remove an element from an empty queue.

Example:

```text
FRONT → NULL
REAR  → NULL
```

Calling DEQUEUE() results in Queue Underflow.

---

## 6. Real-Life Applications of Queue

Queues are widely used in computer science and everyday situations.

| Application | How Queue Is Used |
|---|---|
| Ticket Counters | People are served in the order they arrive. |
| Printer Queue | Documents are generally printed in the order they are submitted. |
| CPU Scheduling | Processes wait in queues for CPU execution, depending on the scheduling algorithm. |
| Customer Support | Customer requests wait until an available agent handles them. |
| Network Data Transmission | Packets can be buffered and processed in arrival order. |
| Call Center Systems | Incoming calls wait until an agent becomes available. |
| Breadth First Search (BFS) | Uses a queue to visit nodes level by level. |
| Operating Systems | Queues manage processes waiting for resources or I/O operations. |
| Keyboard Buffer | Keystrokes can be temporarily stored and processed in order. |

### Practical Examples

**1. Printer Queue**

Suppose three documents are submitted:

```text
Document A → Document B → Document C
```

The printer processes Document A first, followed by B and C.

This follows FIFO.

**2. CPU Scheduling**

In First Come First Served (FCFS) scheduling, processes are executed in the order they arrive.

Example:

```text
P1 → P2 → P3
```

P1 gets CPU execution first, followed by P2 and P3.

**3. Customer Support**

When customers contact a support center:

- Their requests are placed in a queue.
- The first request is handled first.
- Other requests wait until an agent becomes available.

**4. Breadth First Search (BFS)**

BFS uses a queue to explore a graph level by level.

For example:

```text
        A
       / \
      B   C
     / \
    D   E
```

BFS traversal:

```text
A → B → C → D → E
```

The queue helps maintain the order of nodes to be visited.

---

## 7. When Should We Use a Queue?

Use a queue when:

1. Elements need to be processed in the order they arrive.
2. You need to implement FIFO scheduling.
3. You need to manage waiting tasks or requests.
4. You need to perform level-order traversal of trees.
5. You need to implement Breadth First Search (BFS).
6. You need to temporarily store data before processing it.

---

## 8. Array Queue vs Linked List Queue

| Feature | Array Queue | Linked List Queue |
|---|---|---|
| Storage | Array | Nodes |
| Memory allocation | Contiguous | Dynamic node allocation |
| Size | Fixed in basic implementation | Dynamic |
| Enqueue | O(1) | O(1) with FRONT and REAR |
| Dequeue | O(1) | O(1) |
| Memory overhead | No per-element link reference | Extra reference per node |
| Overflow | When array is full | When memory is exhausted |
| Implementation | Relatively simple | Requires node management |

---

## 9. Advantages and Disadvantages

### Advantages

- Simple and easy to implement.
- Maintains FIFO order.
- Efficient ENQUEUE and DEQUEUE operations.
- Useful in scheduling and resource management.
- Supports BFS and level-order traversal.
- Circular queues reuse available array positions.

### Disadvantages

- Basic queues do not allow direct access to middle elements.
- Searching for an element takes O(n) time.
- Fixed-size array queues have limited capacity.
- Linked list queues require additional memory for references.
- Priority-based processing requires a different queue implementation.

---

## 10. Key Points to Remember

- Queue follows FIFO (First In, First Out).
- Insertion is called ENQUEUE.
- Deletion is called DEQUEUE.
- FRONT indicates the first element.
- REAR indicates the last element.
- ENQUEUE happens at REAR.
- DEQUEUE happens at FRONT.
- Overflow occurs when inserting into a full fixed-capacity queue.
- Underflow occurs when deleting from an empty queue.
- ENQUEUE and DEQUEUE take O(1) time in a circular array queue and an appropriately implemented linked list queue.
- DISPLAY takes O(n) time.
- Queue can be implemented using arrays or linked lists.
- Circular queues help reuse empty array positions.
- Priority queues process elements according to priority.
