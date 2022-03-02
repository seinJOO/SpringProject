package projectTest;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
			
		

		int[] date_today = new int[35];
		
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		
		//int startDay = cal.getMinimum(Calendar.DATE);	// 월초(1일)
		int endDay = cal.getMaximum(Calendar.DAY_OF_MONTH);	// 월말
		int start = cal.get(Calendar.DAY_OF_WEEK); // 시작 요일
		
		for (int i = 0 ; i < 35 ; i++) {
			if (i < start - 1) {
				date_today[i] = 0;
			} else if (i > endDay) {
				date_today[i] = 0;
			} else {
				for (int j = 1 ; j <= endDay ; j++) {
					date_today[i] = j;
				}
				i = endDay-1;
			}
		}		
		
		for (int i = 0 ; i < 35 ; i++) {
		}
		
	}
}
