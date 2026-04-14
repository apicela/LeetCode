public class ContainerWithMostWater {
    public int maxArea(int[] nums) {
        int resultado = 0;
        int l = 0, r = nums.length -1;
        while(l < r){
             int newRes = calculateResult(l, r, nums[l], nums[r]);
             if(newRes > resultado) resultado = newRes;
             if(nums[r] > nums[l]){
                l++;
             } else r--;
        }
        return resultado;
    
    }  
        public int calculateResult(int leftIndex, int rightIndex, int leftHeight, int rightHeight){
        int range = rightIndex - leftIndex;
        return range * Math.min(leftHeight, rightHeight);
    }
}
