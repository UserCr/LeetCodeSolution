/**
找频数大于n/2的众数的常见思路是存hashmap。这种方法速度还可以，但是对空间有一定要求。

第二种思路是考虑到参与运算的数全部都是整形，因此每遍历一遍数组，就可以得知数组中某一位出现的0多还是1多，从而确定结果的这一位。
这种思路遍历次数与结果的位数有关，当然用辅助数组也可以实现一趟遍历得到结果。

第三种思路是最大投票算法，不是很容易理解，这里解释一下算法主要思想。
算法的核心思想是每次从数组里挑出一对不同的数扔掉，最后剩下来的就是majority。因为majority频数大于n/2，所以即便每次都扔掉一个majority，
也能保证最后剩下的一定是majority。如果某对数里没有majority，最后只会剩下更多的majority。
不妨假设拿出来的第一个数就是majority，用count记录已经拿出来的majority数量。
当遇到majority时，自然要count++，如果遇到和majority不同的数，就count--扔掉一个majority,然后i++扔掉当前的数。
当第一次遇到count==0时，意味着已经扔掉的数里有一个数占了一半，一堆乱七八糟的其他数占了另一半。因为问题一定是有解的，所以只需要考察剩下的数，
等于说问题又回到了一开始的状态，之前的工作只是在不影响结果的基础上去除了数组中的一些数而已。

参考文章：
https://segmentfault.com/a/1190000004905350
http://www.cs.utexas.edu/users/moore/best-ideas/mjrty/index.html
**/

int majorityElement(int* nums, int numsSize) {
    int count = 1, majority = nums[0];
    for(int i = 1; i < numsSize; ++i) {
        if(0 == count) {
            majority = nums[i];
            count = 1;
        } else if(nums[i] == majority) {
            count++;
        } else {
            count--;
        }
    }
    return majority;
}
