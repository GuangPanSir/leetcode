### 解题思路
未使用双指针的方式，不过和双指针的方式有相同的点

1、排序数组
2、遍历数组O(n^2) 同时去重 对于同一个数只查找一次符合条件的值
```
int temp = nums[0] - 1, temp_1 = nums[1] - 1;
for(int i = 0; i < nums.length; i++){
            //去重
            if(temp == nums[i]) continue;
                temp = nums[i];
            for(int j = i + 1; j < nums.length; j++){
             if(temp_1 == nums[j]) continue;
                temp_1 = nums[j];
             //之和大于0 直接返回
             if(nums[i] + nums[j] > 0)  break;
```
3、通过二分查找 找到 a + b = -c 的符合条件的c
```
int postion = find(nums, -(nums[i] + nums[j]),j);
```
直接从[j, nums.length) 这个区间开始找

重点说说去重：
```
//因为数组是排过序的，我们取最小值 -1 作为temp的值 主要是处理第一个值
int temp = nums[0] - 1, temp_1 = nums[1] - 1;

//如果nums[i - 1] 的值 和nums[i] 的值相等 直接continue
//第一层循环 第二层循环一样的
if(temp == nums[i]) continue;
        temp = nums[i];
```



### 代码

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list_s = new ArrayList<>();
        if(nums.length == 0 || nums.length < 3) return list_s;
        int flag = 0;
        //排序
        Arrays.sort(nums);

        int temp = nums[0] - 1, temp_1 = nums[1] - 1;
        for(int i = 0; i < nums.length; i++){
            
            if(temp == nums[i]) continue;
            temp = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(temp_1 == nums[j]) continue;
                temp_1 = nums[j];
                if(nums[i] + nums[j] > 0)  break;
                int postion = find(nums, -(nums[i] + nums[j]),j);
                if(postion != -1){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[postion]);
                    list_s.add(list);
                }
            }

        }
        
        return list_s;
    }

    public int find(int[] nums, int value,int lowpos){
        int slow = lowpos+1, high = nums.length - 1;
        //二分查找
        int mid = 0;
        int i=1;
        while(slow <= high){
        
            mid = (slow + high) / 2;    
            if(value < nums[mid]){
                high = mid;
                high--;
            }else if(value > nums[mid]){
                slow = mid;
                slow++;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
```