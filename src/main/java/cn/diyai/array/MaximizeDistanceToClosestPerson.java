package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * <p>
 * Example 2:
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class MaximizeDistanceToClosestPerson {
    /**
     * 对于这道题，如果是在两个座位之间，则最近距离的最大值就是正中间的位置，也就是d/2。
     * 在依次遍历座位，对d进行累加，
     * 如果没有再遍历到1（即有人的位置），则最后取res和d的最大值。
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int res = -1, d = 0;
        for (int x : seats) {
            if (x == 1) {
                if (res == -1) {
                    //说明是开始的位置
                    res = Math.max(res, d);
                } else {
                    //说明后面的1，则是取中间位置
                    res = Math.max(res, d / 2);
                }
                d = 1;
            } else {
                d++;
            }

        }
        return Math.max(res, d - 1);
    }

    //方法2
    public int maxDistToClosest2(int[] seats) {
        int maxLen = -1;
        int bestStart = -1;
        int bestEnd = -1;
        int startIndex = -1;
        int curLen = 0;
        for (int i = 0; i < seats.length; i++){
            if (seats[i] == 0){
                curLen += 1;
            } else{
                if (startIndex == -1){
                    if (curLen > maxLen){
                        maxLen = curLen;
                        bestStart = 0;
                        bestEnd = i;
                    }
                }
                else if ((i - startIndex) / 2 > maxLen){
                    maxLen = (i - startIndex) / 2;
                    bestStart = startIndex;
                    bestEnd = i;
                }
                startIndex = i;
                curLen = 0;
            }
        }
        if (curLen > maxLen){
            return curLen;
        }

        return maxLen;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        Assert.assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0}));
    }
}
