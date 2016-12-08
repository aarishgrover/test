# Implements the simplest version of the quicksort algorithm by choosing as pivot:<br>
1. the last element<br>
2. the median (select algorithm) – extra points if use of median of medians<br>

The median of median verion of quicksort is the most effective form of quicksort and uses Order Statistics to obtain a close median to the dataset. The solution is implemented using the following algorithms.<br>
# Selection Algorithm<br>
function select(list, left, right, n)<br>
    loop<br>
        if left = right<br>
             return left<br>
        pivotIndex := pivot(list, left, right)<br>
        pivotIndex := partition(list, left, right, pivotIndex)<br>
        if n = pivotIndex<br>
            return n<br>
        else if n < pivotIndex<br>
            right := pivotIndex - 1<br>
        else<br>
            left := pivotIndex + 1<br>
            
# Partition Algorithm<br>

function partition(list, left, right, pivotIndex)<br>
     pivotValue := list[pivotIndex]<br>
     swap list[pivotIndex] and list[right]  // Move pivot to end<br>
     storeIndex := left<br>
     for i from left to right-1<br>
         if list[i] < pivotValue<br>
             swap list[storeIndex] and list[i]<br>
             increment storeIndex<br>
     swap list[right] and list[storeIndex]  // Move pivot to its final place<br>
     return storeIndex<br>
