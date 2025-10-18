package arraysnhashing

import (
	apicela_utils "apicela_leetcode/go_utils"
	"sort"
)

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]



Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

*/

func TopKFrequent(nums []int, k int) []int {
	pq := apicela_utils.NewPriorityQueue(apicela_utils.MinHeap)
	sort.Ints(nums)
	now := nums[0]
	count := 0
	for idx := 0; idx < len(nums); idx++ {
		if now != nums[idx] {
			pq.PushItem(now, count)
			now = nums[idx]
			count = 1
		}
		count++
	}
	if count > 0 {
		pq.PushItem(now, count)
	}
	response := make([]int, 0, k)
	for i := 0; i < k; i++ {
		response = append(response, pq.PopItem().Value.(int))
	}
	return response
}
