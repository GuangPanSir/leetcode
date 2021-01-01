题目要求只输出不等于val的元素，无需考虑超出新长度后面的元素，且无需考虑输出元素的顺序。
根据题目要求，使用**双指针**方法能轻松解决问题，解题步骤如下：
定义**前指针i=0;后指针j=length-1**;
1、当数组没有元素时返回0;
2、while i <= j ：
    2.1、当前指针i（i<=j&&i<length）指向的当前元素不等与val，就往后移，即i++,否则停止移动；
    2.2、当后指针j（i<=j&&j>=0）当指向当前元素等于val，就往前移，即j--,否则停止移动；
    2.3、i<=j,使用 j指针指向的元素替换 i指针指向的元素，i指针往后移一步(i++)， j指针往前移一步(j--)，然后重复

以上步骤要保证前指针i<=后指针j

```
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        int j = nums.length-1;
        while (i <= j){
            while (i <= j && i < nums.length && nums[i] != val) {
                i++;
            }
            while (i <= j && j >= 0 && nums[j] == val) {
                j--;
            }
            if ( i <= j) {
                nums[i] = nums[j];
                i++;
                j--;
            }
        }
        return i;
    }
}
```

