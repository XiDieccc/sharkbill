package util;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static java.sql.Date util2sql(java.util.Date d){
        return  new java.sql.Date(d.getTime());
    }
	
	public static Date today() {
		Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
	}
	
	public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
          
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
          
        return c.getTime();
    }
	
	 public static Date monthEnd() {
	        Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.set(Calendar.HOUR, 0);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	          
	        c.set(Calendar.DATE, 1);
	        c.add(Calendar.MONTH, 1);
	        c.add(Calendar.DATE, -1);
	        return c.getTime();
	    }
	 
	//获取本月一共多少天
	    public static int monthTotalDay() {
	        Calendar c = Calendar.getInstance();
	        c.setTime(monthEnd());
	        return c.get(Calendar.DATE);
	    }
	    //获取本月还剩多少天
	    public static int monthLeftDay() {
	        Calendar c = Calendar.getInstance();
	        c.setTime(today());
	        int end = monthTotalDay();
	        int today = c.get(Calendar.DATE);
	        return end-today;
	    }
	    public static void main(String[] args) {
	        System.out.println(DateUtil.today());
	        System.out.println(DateUtil.monthBegin());
	        System.out.println(DateUtil.monthEnd());
	        System.out.println(DateUtil.monthTotalDay());
	        System.out.println(DateUtil.monthLeftDay());
	    }
}
