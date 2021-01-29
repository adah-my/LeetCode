### 解题思路
思路：如果两个数不相等，那么就碰撞消亡吧，剩下的全部是同一个数，即答案。

### 代码

```java
class Solution {
    public int majorityElement(int[] nums) {
        int ans=nums[0],len=1;
        for(int i=1;i<nums.length;i++){
            //如果相等，就累计数量
            if(nums[i] == ans){
                len++;
            }else{
                //如果不等，就碰撞吧
                if(len>0)len--;
                else{
                    //当计数为零时，把下一个数暂时作为目标数
                    ans=nums[i];
                    len=1;
                }
            }
        }
        return ans;
    }
}
```