### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) {
            if(nums2.length % 2 == 1){
                return nums2[nums2.length / 2];
            }else {
                return (double)(nums2[nums2.length / 2 -1] + nums2[nums2.length / 2]) / 2;
            }
        }
        if(nums2.length == 0) {
            if(nums1.length % 2 == 1){
                return nums1[nums1.length / 2];
            }else {
                return (double)(nums1[nums1.length / 2 -1] + nums1[nums1.length / 2]) / 2;
            }
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0 ,r = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                result[r] = nums1[i];
                r++;
                i++;
            } else{
                result[r] = nums2[j];
                r++;
                j++;
            }
        }
        if(i == m){
            while(j < n){
                result[r] = nums2[j];
                r++;
                j++;
            }
        }else{
            while(i < m){
                result[r] = nums1[i];
                i++;
                r++;
            }
        }

        if((m + n) % 2 == 0){
            return (double)(result[(m + n) / 2 - 1] + result[(m + n) / 2]) / 2;
        } else{
            return result[( m + n) / 2];
        }
    }
}
```