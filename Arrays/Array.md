# Array Data Structure

## 1. Introduction

An array is a linear data structure that stores a collection of elements of the same data type in contiguous memory locations.

Each element is accessed using an index. In Java, array indexing starts from `0`.

### Example

```java
int arr[] = {10, 20, 30, 40, 50};
```

| Index | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| Element | 10 | 20 | 30 | 40 | 50 |

### Characteristics

- Stores elements of the same data type.
- Elements are accessed using indices.
- Fixed size after creation.
- Allows random access.
- Insertion and deletion may require shifting elements.
- Efficient access to elements using an index.

---

# 2. Array Operations

## 2.1 Insertion

### Definition

Insertion is the operation of adding a new element to an array at a specified position.

### Working

1. Check whether the position is valid.
2. Shift elements to the right starting from the last element.
3. Insert the new element at the required position.

### Example

Before insertion:

`10 20 30 40`

Insert `25` at index `2`.

After insertion:

`10 20 25 30 40`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

Best case occurs when inserting at the end.

Worst case occurs when inserting at the beginning because all existing elements must be shifted.

### Space Complexity

O(1) auxiliary space.

---

## 2.2 Deletion by Position

### Definition

Deletion by position removes an element from a specified index in the array.

### Working

1. Check whether the position is valid.
2. Shift all subsequent elements one position to the left.
3. Clear the last occupied position.

### Example

Before deletion:

`10 20 30 40 50`

Delete the element at index `2`.

After deletion:

`10 20 40 50`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

Best case occurs when deleting the last element.

Worst case occurs when deleting the first element.

### Space Complexity

O(1) auxiliary space.

---

## 2.3 Deletion by Data

### Definition

Deletion by data removes a particular element by first searching for its value and then deleting it.

### Working

1. Search for the required element using Linear Search.
2. If found, delete it using deletion by position.
3. If not found, display an appropriate message.

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

### Space Complexity

O(1) auxiliary space.

---

# 3. Searching Algorithms

## 3.1 Linear Search

### Definition

Linear Search is a searching algorithm that sequentially checks each element until the required element is found or the array ends.

### Working

1. Start from the first element.
2. Compare the current element with the target.
3. If equal, return its index.
4. Otherwise, move to the next element.
5. If the target is not found, return `-1`.

### Example

Array:

`10 20 30 40 50`

Search for `40`.

Comparisons:

- 10 ≠ 40
- 20 ≠ 40
- 30 ≠ 40
- 40 = 40

Result: Element found at index `3`.

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(n) |
| Worst Case | O(n) |

### Space Complexity

O(1).

### When to Use

- When the array is unsorted.
- When the array contains only a few elements.
- When simplicity is more important than search efficiency.
- When searching through a collection that cannot be sorted.

### Advantages

- Simple to implement.
- Works on both sorted and unsorted arrays.
- Requires no additional memory.

### Disadvantages

- Slow for large datasets.
- May require checking every element.

---

## 3.2 Binary Search

### Definition

Binary Search is an efficient searching algorithm that repeatedly divides the search interval into two halves to locate an element.

**The array must be sorted before performing Binary Search.**

### Working

1. Set `low = 0` and `high = size - 1`.
2. Calculate the middle index.
3. Compare the middle element with the target.
4. If equal, return the index.
5. If the target is greater, search the right half.
6. If the target is smaller, search the left half.
7. Repeat until the element is found or the search interval becomes empty.

### Example

Sorted array:

`10 20 30 40 50 60 70`

Search for `60`.

| Step | Low | High | Mid | Element |
|---|---|---|---|---|
| 1 | 0 | 6 | 3 | 40 |
| 2 | 4 | 6 | 5 | 60 |

Result: Element found at index `5`.

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(1) |
| Average Case | O(log n) |
| Worst Case | O(log n) |

### Space Complexity

O(1) for iterative Binary Search.

### When to Use

- When the array is sorted.
- When searching large datasets.
- When repeated searches are performed on the same sorted data.
- When search speed is important.

### Advantages

- Much faster than Linear Search for large sorted arrays.
- Reduces the search space by half in each iteration.

### Disadvantages

- Requires sorted data.
- Sorting an unsorted array may introduce additional cost.

---

# 4. Sorting Algorithms

Sorting is the process of arranging elements in a particular order, usually ascending or descending.

The following algorithms arrange elements in ascending order.

---

## 4.1 Bubble Sort

### Definition

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

After each pass, the largest unsorted element moves to its correct position.

### Working

1. Compare adjacent elements.
2. Swap them if the left element is greater than the right element.
3. Continue until the end of the array.
4. Repeat for the remaining unsorted elements.

### Example

Initial array:

`5 3 8 2`

Pass 1:

`3 5 2 8`

Pass 2:

`3 2 5 8`

Pass 3:

`2 3 5 8`

Sorted array:

`2 3 5 8`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

*The implementation without a swap-check optimization has O(n²) best-case time complexity.*

### Space Complexity

O(1).

### When to Use

- For very small datasets.
- When teaching basic sorting concepts.
- When simplicity is more important than performance.
- When the number of elements is small and implementation needs to be straightforward.

### Advantages

- Simple to understand and implement.
- In-place sorting.
- Stable sorting algorithm.

### Disadvantages

- Inefficient for large datasets.
- Performs many unnecessary comparisons.

---

## 4.2 Selection Sort

### Definition

Selection Sort repeatedly selects the smallest element from the unsorted portion and places it at the beginning of that portion.

### Working

1. Assume the first element is the minimum.
2. Search the remaining array for the actual minimum.
3. Swap the minimum element with the first unsorted element.
4. Move the boundary of the sorted portion forward.
5. Repeat.

### Example

Initial array:

`64 25 12 22 11`

Pass 1:

`11 25 12 22 64`

Pass 2:

`11 12 25 22 64`

Pass 3:

`11 12 22 25 64`

Pass 4:

`11 12 22 25 64`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

### Space Complexity

O(1).

### When to Use

- When the dataset is small.
- When memory usage must be minimal.
- When minimizing the number of swaps is important.
- When the cost of writing/swapping data is more significant than the cost of comparisons.

### Advantages

- Simple implementation.
- In-place sorting.
- Performs at most O(n) swaps.

### Disadvantages

- Always performs O(n²) comparisons.
- Not suitable for large datasets.
- Generally unstable.

---

## 4.3 Insertion Sort

### Definition

Insertion Sort builds a sorted portion of the array one element at a time by inserting each new element into its correct position.

### Working

1. Assume the first element is sorted.
2. Select the next element as the key.
3. Compare the key with elements in the sorted portion.
4. Shift larger elements to the right.
5. Insert the key at the correct position.
6. Repeat.

### Example

Initial array:

`5 3 4 1`

Pass 1:

`3 5 4 1`

Pass 2:

`3 4 5 1`

Pass 3:

`1 3 4 5`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

### Space Complexity

O(1).

### When to Use

- For small datasets.
- When the array is already sorted or nearly sorted.
- When elements arrive one at a time and must be maintained in sorted order.
- When a simple, stable, in-place sorting algorithm is required.

### Advantages

- Efficient for small arrays.
- Very efficient for nearly sorted arrays.
- Stable.
- In-place.
- Online algorithm: can sort elements as they arrive.

### Disadvantages

- Inefficient for large datasets.
- Requires many shifts in reverse-sorted arrays.

---

## 4.4 Merge Sort

### Definition

Merge Sort is a divide-and-conquer sorting algorithm that divides the array into smaller subarrays, sorts them recursively, and merges the sorted subarrays.

### Working

1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves.
4. Continue until the entire array is sorted.

### Example

Initial array:

`38 27 43 3`

Divide:

`38 27` | `43 3`

Divide further:

`38` | `27` | `43` | `3`

Merge:

`27 38` | `3 43`

Final merge:

`3 27 38 43`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n log n) |

### Space Complexity

O(n) auxiliary space.

### When to Use

- For large datasets.
- When guaranteed O(n log n) performance is required.
- When stability is important.
- When sorting linked lists.
- When additional memory is available.
- When predictable performance is preferred over average-case speed.

### Advantages

- Guaranteed O(n log n) time complexity.
- Stable sorting algorithm.
- Performs well on large datasets.
- Suitable for external sorting when data cannot fit entirely in memory.

### Disadvantages

- Requires additional memory.
- More complex than Bubble, Selection, and Insertion Sort.
- For small arrays, overhead may make simpler algorithms faster.

---

## 4.5 Quick Sort

### Definition

Quick Sort is a divide-and-conquer sorting algorithm that selects a pivot element and partitions the array into elements smaller than or equal to the pivot and elements greater than the pivot.

The partitions are then sorted recursively.

### Pivot Selection

In this implementation, the **last element is selected as the pivot**.

### Working

1. Select the last element as pivot.
2. Rearrange the array so that:
   - Elements less than or equal to the pivot are on the left.
   - Elements greater than the pivot are on the right.
3. Place the pivot in its correct position.
4. Recursively sort the left and right partitions.

### Example

Initial array:

`5 3 8 4 2`

Pivot:

`2`

After partitioning:

`2 3 8 4 5`

The pivot is now in its correct position.

The remaining right portion is sorted recursively.

Final array:

`2 3 4 5 8`

### Time Complexity

| Case | Complexity |
|---|---|
| Best Case | O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n²) |

### Space Complexity

- Average recursion space: O(log n).
- Worst-case recursion space: O(n).

### When to Use

- For large datasets stored in memory.
- When average-case performance is important.
- When in-place sorting is preferred.
- When additional memory requirements should be relatively low.
- When a fast general-purpose sorting algorithm is required.

### Advantages

- Very fast in practice for many datasets.
- Average-case O(n log n).
- In-place partitioning.
- Usually requires less additional memory than Merge Sort.

### Disadvantages

- Worst-case O(n²).
- Not stable.
- Performance depends on pivot selection.
- Choosing the last element as pivot can perform poorly on already sorted or reverse-sorted arrays.

---

# 5. Sorting Algorithm Comparison

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable? | In-Place? |
|---|---|---|---|---|---|---|
| Bubble Sort | O(n²) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | No |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n)* | No | Yes |

*Quick Sort recursion space is O(log n) on average and O(n) in the worst case.*

---

# 6. Which Sorting Algorithm Should Be Used?

| Scenario | Recommended Algorithm | Reason |
|---|---|---|
| Very small dataset | Insertion Sort | Simple and efficient for small inputs |
| Already sorted or nearly sorted data | Insertion Sort | Best case is O(n) |
| Educational demonstration | Bubble Sort | Easy to understand and visualize |
| Minimizing swaps | Selection Sort | Performs at most O(n) swaps |
| Large dataset with guaranteed performance | Merge Sort | Guaranteed O(n log n) |
| Stability is required | Merge Sort or Insertion Sort | Maintains relative order of equal elements |
| Large in-memory dataset | Quick Sort | Excellent average-case performance |
| Memory is limited | Quick Sort | Usually requires less auxiliary memory than Merge Sort |
| Data arrives one element at a time | Insertion Sort | Can insert each new element into the sorted portion |
| Data is stored in linked lists | Merge Sort | Efficient merging without random access |
| Worst-case performance must be predictable | Merge Sort | Worst-case O(n log n) |
| Small dataset and minimal implementation complexity | Bubble or Selection Sort | Simple implementation |

---

# 7. Reverse

### Definition

Reversing an array means rearranging its elements in the opposite order.

### Working

1. Initialize two pointers:
   - `start = 0`
   - `end = size - 1`
2. Swap the elements at both positions.
3. Increment `start`.
4. Decrement `end`.
5. Repeat until `start >= end`.

### Example

Before:

`10 20 30 40 50`

After:

`50 40 30 20 10`

### Time Complexity

O(n).

### Space Complexity

O(1).

---

# 8. Overall Complexity Summary

| Operation | Time Complexity | Auxiliary Space |
|---|---|---|
| Insertion | O(n) | O(1) |
| Deletion by Position | O(n) | O(1) |
| Deletion by Data | O(n) | O(1) |
| Linear Search | O(n) | O(1) |
| Binary Search | O(log n) | O(1) |
| Bubble Sort | O(n²) | O(1) |
| Selection Sort | O(n²) | O(1) |
| Insertion Sort | O(n²) | O(1) |
| Merge Sort | O(n log n) | O(n) |
| Quick Sort | O(n log n) average | O(log n) average |
| Reverse | O(n) | O(1) |
| Display | O(n) | O(1) |

---

# 9. Conclusion

Arrays provide efficient random access to elements using indices. However, insertion and deletion operations require shifting elements, making them less efficient than some other data structures for frequent modifications.

Searching and sorting algorithms improve the efficiency of data processing:

- Linear Search is suitable for unsorted data.
- Binary Search is efficient for sorted data.
- Insertion Sort works well for small or nearly sorted arrays.
- Bubble Sort and Selection Sort are useful for understanding basic sorting techniques.
- Merge Sort provides guaranteed O(n log n) performance but requires additional memory.
- Quick Sort provides excellent average-case performance and is commonly used for in-memory sorting.

Choosing the appropriate algorithm depends on dataset size, memory availability, whether the data is already sorted, stability requirements, and worst-case performance requirements.
