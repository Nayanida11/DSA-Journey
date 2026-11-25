# STACK (Data Structure)

## 1. Definition

A **Stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

This means the element inserted last is the first element to be removed.

Insertion and deletion take place only at one end, called the **TOP**.

### Example

Consider a stack of plates:

- A plate is placed on top of the existing plates.
- The topmost plate is removed first.
- We cannot directly remove a plate from the middle without removing the plates above it.

This follows the LIFO principle.

---

## 2. Basic Operations

| Operation | Description |
|---|---|
| PUSH | Inserts an element at the top of the stack. |
| POP | Removes and returns the top element. |
| PEEK | Returns the top element without removing it. |
| DISPLAY | Displays all elements from top to bottom. |
| isEmpty | Checks whether the stack is empty. |
| isFull | Checks whether the stack is full (array implementation). |

### Example

Initially:

```text
TOP → NULL
```

After PUSH(10), PUSH(20), PUSH(30):

```text
      TOP
       |
     | 30 |
     | 20 |
     | 10 |
     ------
```

After POP():

```text
      TOP
       |
     | 20 |
     | 10 |
     ------
```

PEEK() returns 20 without modifying the stack.

---

## 3. Types of Stack Implementation

A stack can be implemented using two common approaches:

### A. Array-Based Stack

- Uses an array to store elements.
- Uses an integer variable `top` to track the index of the topmost element.
- Initially, `top = -1`.
- Has a fixed capacity in a basic array implementation.
- Overflow occurs when the array becomes full.
- Underflow occurs when POP is performed on an empty stack.

**Important conditions:**

| Condition | Meaning |
|---|---|
| top == -1 | Stack is empty |
| top == capacity - 1 | Stack is full |

### B. Linked List-Based Stack

- Uses nodes to store elements.
- Each node contains data and a reference to the next node.
- Uses a Node reference called `top`.
- Initially, `top = null`.
- Insertion and deletion take place at the beginning of the linked list.
- Grows dynamically until available memory is exhausted.

**Important conditions:**

| Condition | Meaning |
|---|---|
| top == null | Stack is empty |
| top != null | Stack contains elements |

---

## 4. Operations and Time Complexity

| Operation | Array Stack | Linked List Stack |
|---|---|---|
| PUSH | O(1) | O(1) |
| POP | O(1) | O(1) |
| PEEK | O(1) | O(1) |
| DISPLAY | O(n) | O(n) |
| isEmpty | O(1) | O(1) |
| isFull | O(1) | Not applicable |

**Explanation:**

- PUSH: Inserts an element at the top. No traversal is required.
- POP: Removes the topmost element. No traversal is required.
- PEEK: Accesses the topmost element directly.
- DISPLAY: Traverses all n elements.
- isEmpty: Checks whether the stack is empty.
- isFull: Checks whether the array has reached its maximum capacity.

### Space Complexity

| Implementation | Space Complexity |
|---|---|
| Array Stack | O(n) |
| Linked List Stack | O(n) |

Here, n represents the number of elements stored in the stack (or the allocated capacity for an array).

---

## 5. Stack Overflow and Underflow

### Stack Overflow

Occurs when we try to insert an element into an already full stack.

Example:

If array capacity = 3:

```text
TOP → 30
       20
       10
```

Trying to PUSH(40) results in Stack Overflow.

This applies to a fixed-capacity array stack.

### Stack Underflow

Occurs when we try to remove an element from an empty stack.

Example:

```text
TOP → NULL
```

Calling POP() results in Stack Underflow.

---

## 6. Real-Life Applications of Stack

Stacks are widely used in computer science and everyday applications.

| Application | How Stack Is Used |
|---|---|
| Undo and Redo | Stores previous actions so users can undo or redo operations. |
| Browser History | Maintains previously visited pages for back navigation (a simplified stack-based model). |
| Function Calls | Stores function calls and their execution information in the call stack. |
| Recursion | Maintains information about recursive function calls. |
| Expression Evaluation | Evaluates arithmetic expressions using operands and operators. |
| Parentheses Matching | Checks whether brackets are balanced in expressions and programs. |
| Reversing Strings | Stores characters and retrieves them in reverse order. |
| Backtracking | Stores previous states to return to an earlier state when needed. |
| Depth First Search (DFS) | Uses a stack to explore graph or tree nodes. |

### Practical Examples

**1. Undo Operation in Text Editors**

When typing in a document, each action can be stored in a stack.

- Type A → PUSH(A)
- Type B → PUSH(B)
- Type C → PUSH(C)

When the user presses Undo, the latest action is removed first.

**2. Browser Back Button**

Suppose you visit:

```text
Google → YouTube → GitHub
```

Pressing the Back button takes you to YouTube, then Google.

A stack is one way to implement this navigation behaviour.

**3. Function Calls**

Consider:

```java
void main() {
    display();
}

void display() {
    calculate();
}

void calculate() {
    System.out.println("Hello");
}
```

The function calls are managed using a call stack.

The `calculate()` function completes first, followed by `display()` and then `main()`.

**4. Balanced Parentheses**

Consider:

```text
{ ( A + B ) * C }
```

An opening bracket is pushed onto the stack. When a matching closing bracket appears, the corresponding opening bracket is popped.

If all brackets match and the stack becomes empty, the expression is balanced.

---

## 7. When Should We Use a Stack?

Use a stack when:

1. The most recently added element needs to be accessed first.
2. You need to maintain a history of operations.
3. You need to reverse elements or sequences.
4. You need to perform backtracking.
5. You need to manage nested function calls.
6. You need to evaluate expressions or check balanced brackets.

---

## 8. Array Stack vs Linked List Stack

| Feature | Array Stack | Linked List Stack |
|---|---|---|
| Memory allocation | Contiguous memory | Nodes allocated dynamically |
| Size | Fixed in basic implementation | Dynamic |
| TOP representation | Integer index | Node reference |
| PUSH | O(1) | O(1) |
| POP | O(1) | O(1) |
| Memory overhead | No per-element link reference | Extra reference per node |
| Overflow | When array is full | When memory is exhausted |
| Implementation | Simple | Requires node management |

---

## 9. Advantages and Disadvantages

### Advantages

- Simple and easy to implement.
- PUSH and POP take O(1) time.
- Useful for recursion and backtracking.
- Helps manage function calls.
- Efficient for LIFO-based problems.

### Disadvantages

- Only the topmost element can be directly accessed.
- Searching for an element takes O(n) time.
- Array implementation has a fixed capacity.
- Linked list implementation requires additional memory for references.

---

## 10. Key Points to Remember

- Stack follows LIFO (Last In, First Out).
- Insertion is called PUSH.
- Deletion is called POP.
- PEEK returns the top element without deleting it.
- TOP indicates the topmost element.
- Overflow occurs when inserting into a full fixed-capacity stack.
- Underflow occurs when deleting from an empty stack.
- PUSH, POP and PEEK take O(1) time.
- DISPLAY takes O(n) time
