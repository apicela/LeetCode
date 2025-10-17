/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
*/
package arraysnhashing

import "fmt"

func ProductExceptSelf(nums []int) []int {
	arrSize := len(nums)
	response := make([]int, arrSize)
	left := make([]int, arrSize)
	right := make([]int, arrSize)

	left[0] = nums[0]
	right[arrSize-1] = nums[arrSize-1]
	for i := 1; i < arrSize; i++ {
		left[i] = left[i-1] * nums[i]
		right[arrSize-1-i] = right[arrSize-i] * nums[arrSize-i-1]
	}
	fmt.Println(left)
	fmt.Println(right)

	for i := 1; i < arrSize-1; i++ {
		response[i] = left[i-1] * right[i+1]
	}
	return response
}
