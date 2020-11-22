

/**
 * 根据交易次数，扩展成一般规律
 */
public class Shares {
    public static void main(String[] args) {
        int times = 2;
        int[] data = new int[]{2,25,9,8,67,45,25,90,70,13};
        System.out.println("--------交易一次利益------");
        System.out.println(maxProfit(data));
        System.out.println("--------交易尽可能多次数----");
        System.out.println(maxProfit2(data));
        System.out.println("--------交易两次---------");
        System.out.println(maxProfit3(data));
        System.out.println("-------交易" + times + "次-----");
        System.out.println(maxProfit(data,times));
    }

    /**
     * 题目：
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
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
     * <p>
     * <p>
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

    /**
     * 题目：
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * <p>
     * <p>
     * 尽可能多次操作  获取最大收益
     *
     * @param prices 价格数组
     * @return 最大收益
     * <p>
     * <p>
     * 分析：动态规划思想
     * f(i) = f(i-2)+max(p(i)-p(i-1),0)
     * <p>
     * 关键字：尽可能多次操作
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            maxValue += Math.max(prices[i] - prices[i - 1], 0);
        }
        return maxValue;
    }

    /**
     * 题目：
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * <p>
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices 价格数组
     * @return 两次交易最大利益
     * <p>
     * 分析：动态规划
     * 一共处于五种状态：
     * 1：初始化状态  2：买入状态  3：卖出状态  4：买入状态  5：卖出状态
     * 对应收益状态正负关系：
     * 1：0   2：-   3：+   4：-   5：+
     * <p>
     * f(i,n) -->前i天的利益最大值
     * f(i,0)  初始化
     * f(i,1) 第一次买入
     * f(i,2) 第一次卖出
     * f(i,3) 第二次买入
     * f(i,4) 第二次卖出  end
     * <p>
     * 状态方程：
     * 第一次买入：
     * f(i,1) = max(f(i-1,1),f(i-1,0)-p(i))
     * 第一次卖出：
     * f(i,2) = max(f(i-1,2),f(i-1,1)+p(i))
     * 第二次买入：
     * f(i,3) = max(f(i-1,3),f(i-1,2)-p(i))
     * 第二次卖出：
     * f(i,4) = max(f(i-1,4),f(i-1,3)+p(i))
     * <p>
     * 关键字：两次交易
     */
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < length; i++) {
            //初始化状态
            dp[i][0] = dp[i - 1][0];
            //第一次买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //第一次卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //第二次买入
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //第二次卖出
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return Math.max(Math.max(Math.max(dp[length - 1][0], dp[length - 1][1]), Math.max(dp[length - 1][2], dp[length - 1][3])), dp[length - 1][4]);
    }


    /**
     * 扩展功能  执行times次获取到的最大利益
     *
     * @param prices 价格列表
     * @param times  交易次数
     * @return 最大收益值
     * <p>
     * 分析：动态规划思想
     * <p>
     * 根据上一个交易两次的状态方程
     * 交易times次，共有 times*2+1种状态
     *
     * 关键字：n次交易的最大收益
     */
    public static int maxProfit(int[] prices, int times) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        if (times > (prices.length / 2)) {
            throw new ArrayIndexOutOfBoundsException("the times : " + times + " is out of the mast times : " + (prices.length / 2));
        }
        int maxValue = 0;
        int length = prices.length;
        int count = 2 * times + 1;
        int[][] dp = new int[length][count];
        dp[0][0] = 0;
        for (int i = 1; i < count; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = -prices[0];
            }
        }
        for (int i = 1; i < length; i++) {
            for (int k = 0; k < count - 1; k++) {
                if (k == 0) {
                    dp[i][k] = dp[i - 1][k];
                } else {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - 1] + ((k % 2 == 0) ? prices[i] : -prices[i]));
                    dp[i][k + 1] = Math.max(dp[i - 1][k + 1], dp[i - 1][k] + ((k + 1) % 2 == 0 ? prices[i] : -prices[i]));
                    k++;
                }
                maxValue = Math.max(maxValue, dp[i][k]);
            }
        }
        return maxValue;
    }
}
