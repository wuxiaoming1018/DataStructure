/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */

/**
 * 根据交易次数，扩展成一般规律
 */
public class Shares {
    public static void main(String[] args) {
        int[] data = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("--------交易一次利益------");
        System.out.println(maxProfit(data));

    }

    /**
     * 只允许交易一次  获取最大收益
     *
     * @param prices 价格数组
     * @return 最大收益
     * <p>
     * 分析：动态规划思想
     * f(i)表示前i天的最大收益
     * p(i)表示第i天的报价
     * minValue表示前i-1天的最低价格(买入价格)
     * f(i) = max(f(i-1),p(i)-minValue)
     * <p>
     * 关键：只交易一次
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxValue = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxValue = Math.max(prices[i] - minValue, maxValue);
            minValue = Math.min(prices[i], minValue);
        }
        return maxValue;
    }
}
