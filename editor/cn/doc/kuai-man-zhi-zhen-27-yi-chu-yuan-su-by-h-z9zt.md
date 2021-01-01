# 题目描述：

给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
<br>
## 示例:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素
<br>
# 思路分析
首先，定义慢指针slow，规定在区间[0,slow)中的元素都是值不等于val=3的元素。


![LeetCode-27修正版 .002.jpeg](https://pic.leetcode-cn.com/1608735490-pBKYRp-LeetCode-27%E4%BF%AE%E6%AD%A3%E7%89%88%20.002.jpeg)
<br>
接着，定义指针fast用于遍历整个数组。

![LeetCode-27修正版 .003.jpeg](https://pic.leetcode-cn.com/1608735519-cQyCbI-LeetCode-27%E4%BF%AE%E6%AD%A3%E7%89%88%20.003.jpeg)


<br>

对于每一个当前所考察的元素，将其值和val=3进行比较。比较的结果，有两种情况。一是，当前考察的元素值等于val=3；二是，当前考察的元素值不等于val=3。

对于第一种情况，如下图所示，当前考察的元素为指针fast指向的元素3，其值与val相等。

![LeetCode-27修正版 .003.jpeg](https://pic.leetcode-cn.com/1608735544-ZNhRif-LeetCode-27%E4%BF%AE%E6%AD%A3%E7%89%88%20.003.jpeg)


<br>

对于这种情况，由于题目要求是移除val等于3的元素，因此当前元素不需要放入区间[0,slow)中，接着要做的就是继续考察下一个元素，即指针fast向后移动一个位置。


 [fast右移.gif](https://pic.leetcode-cn.com/1608735567-bghuYg-fast%E5%8F%B3%E7%A7%BB.gif)
<br>
此时，指针fast指向的元素2不等于val=3，因此需要放入区间[0,slow]中，也就是说在这里快指针停止的条件的是当前考察的元素值与val=3不相等。


![LeetCode-27修正版 .004.jpeg](https://pic.leetcode-cn.com/1608735597-fgByCh-LeetCode-27%E4%BF%AE%E6%AD%A3%E7%89%88%20.004.jpeg)
<br>
对于这种情况，首先要做的是将快指针fast所指向的元素值赋予慢指针所指向的元素位置，即nums[slow]=nums[fast]。


 [fast赋值于slow.gif](https://pic.leetcode-cn.com/1608735618-xWMXzF-fast%E8%B5%8B%E5%80%BC%E4%BA%8Eslow.gif)
<br>
赋值完成之后，接着要做的是将慢指针slow向后移动一个位置，来保证区间[0,slow)中的元素都是值不等于val=3的元素。此时区间[0,slow)中的元素2就是值不等于val=3的元素。


![LeetCode-27修正版 .007.jpeg](https://pic.leetcode-cn.com/1608735639-dPIbXI-LeetCode-27%E4%BF%AE%E6%AD%A3%E7%89%88%20.007.jpeg)
<br>
对于数组nums中剩余的元素2和3，重复上述步骤，即可将所有数值等于val的元素移除。
<br>
## 动画演示
![LeetCode27移除元素.mov](7840490e-968c-4205-9616-95bf71c69d48)

<br>
# 代码实现

```java
    public int removeElement(int[] nums, int val) {
        // 慢指针slow 区间[0,slow)内的元素为值不等于val的元素
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            // 快指针fast所指向的元素值不等于val=3
            // 将其值赋值于慢指针所在位置
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                // 赋值完毕之后，慢指针右移一位，等待下一次赋值
                slow++;
            }
        }
        return slow;
    }
```
<br>
感谢您的阅读，觉得不错还请帮忙点个赞，在此谢过

如有错误欢迎留言指出

更多内容关注公众号「算法小课堂」查看