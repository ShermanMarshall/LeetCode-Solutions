package aprilchallenge.solutions.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSingleTransactionTradeProfit {

	public static class Trade {
		Integer start;
		Integer end;
		Integer value;

		public Trade(int _start, int _end, int _value) {
			start = _start;
			end = _end;
			value = _value;
		}

		public String toString() {
			return new StringBuilder().append(start).append(":").append(end).append(":").append(value).toString();
		}
	}

	public static int maxProfit(int[] prices) {
		List<Trade> trades = new ArrayList();
		for (int x = 0; x < prices.length; x++) {
			for (int y = x + 1; y < prices.length; y++) {
				if (prices[y] - prices[x] > 0) {
					trades.add(new Trade(x, y, prices[y] - prices[x]));
				}
			}
		}

		Collections.sort(trades, new Comparator<Trade>() {
			public int compare(Trade a, Trade b) {
				//return b.value.compareTo(a.value);
				return a.start.compareTo(b.start);
			}
		});
		
		Collections.reverse(trades);

		System.out.println(trades.toString());
		int idx = 0, maxProfit = 0;
		boolean isDouble = true;
		do {
			int start = -1, end = -1, total = 0;
			Trade currentTrade = null;
			
			for (int x = idx++; x < trades.size(); x++) {
				Trade trade = trades.get(x);
				
				if (currentTrade == null || trade.end < currentTrade.start) {
					currentTrade = trade;
					total += currentTrade.value;
				}
			}
			
			long i = Long.MAX_VALUE;
			
			maxProfit = total > maxProfit ? total : maxProfit;
			
			if( idx < trades.size()) {
				isDouble = !isDouble;
				idx = 0;
			}
			
			
		} while (isDouble == false && idx < trades.size());

		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(maxProfit(new int[] { 6, 1, 3, 2, 4, 7 }));
		System.out.println(maxProfit(new int[] { 3, 2, 6, 5, 0, 3 }));
	}

}
