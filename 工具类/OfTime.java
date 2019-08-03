package com.sm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


/**
 * ����ʱ��ķ���
 * @author Administrator
 *
 */
public class OfTime {
	
	public static final String DATA_FORMAT_STR = "yyyy-MM-dd";
	
	
	
	public static String getLongTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		return df.format(new Date());
	}
	
	
	
	public static String getLongTimeWu(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//�������ڸ�ʽ
		return df.format(new Date());
	}
	
	
	public static String getShortTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		return df.format(new Date());
	}
	
	
	public static String getShortTime2(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");//�������ڸ�ʽ
		return df.format(new Date());
	}
	
	/**
	 * ʱ������
	 * @param time ʱ��
	 * @param type �꣬�£��գ���
	 * @param num Ҫ���ӵ���
	 * @return
	 * @throws ParseException
	 */
	public static String increaseTheTime(String time,String type,int num) throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(time);
	    Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
	    switch (type) {
		case "year":
			calendar.add(calendar.YEAR, num);//�������������һ��.���������,������ǰ�ƶ�
			break;
		case "month":
			calendar.add(calendar.MONTH, num);//�������������һ����.���������,������ǰ�ƶ�
			break;
		case "date":
			calendar.add(calendar.DATE,num);//�������������һ��.���������,������ǰ�ƶ� 
			break;
		case "week":
			calendar.add(calendar.WEEK_OF_MONTH, num);//���ʱ��������������һ��Ľ�� 
			break;
		default:
			break;
		}
	    date=calendar.getTime();   
	    String dateStr=sdf.format(date);
		return dateStr;
	}
	/**
	 * �Ƚ�ʱ���С
	 * @param time1 ʱ��1
	 * @param time2 ʱ��2
	 * @return ʱ��1����ʱ��2 ���أ�1 ʱ��1С��ʱ��2 ���أ�-1
	 */
	public static int comparisonTime(String time1, String time2){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(time1);
            Date dt2 = df.parse(time2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
	}
	
	/**
	 * ���ղ���format�ĸ�ʽ������ת�ַ�
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
	/**
	 * ��������ʱ���Ѿ����ˣ�-X����û�й�X��
	 * @param time Ҫ�����ʱ��
	 * @return
	 * @throws ParseException 
	 */
	public static int timeDifference(String time) throws ParseException{
		String a = "2018-1-1 14:10:42";
		Date a1 = new SimpleDateFormat("yyyy-MM-dd").parse(a);
		Date b1 = new SimpleDateFormat("yyyy-MM-dd").parse(OfTime.getLongTime());
		//��ȡ���������
		int day = (int) ((a1.getTime()-b1.getTime())/(24*60*60*1000));
		return day;
	}
	/** 
     * ��ȡ���µ� ���� 
     */  
    public static int getCurrentMonthDay() {  

        Calendar a = Calendar.getInstance();  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  

    /** 
     * ����� �� ��ȡ��Ӧ���·� ���� 
     */  
    public static int getDaysByYearMonth(int year, int month) {  

        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  

    /** 
     * ������� �ҵ���Ӧ���ڵ� ���� 
     */  
    public static String getDayOfWeekByDate(String date) {  
        String dayOfweek = "-1";  
        try {  
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
            Date myDate = myFormatter.parse(date);  
            SimpleDateFormat formatter = new SimpleDateFormat("E");  
            String str = formatter.format(myDate);  
            dayOfweek = str;  

        } catch (Exception e) {  
            System.out.println("����!");  
        }  
        return dayOfweek;  
    }  
    
    /**
     * 
     * ͨ��ʱ����������ж�����ʱ��ļ��
     * @param date1
     * @param date2
     * @return
     * @throws ParseException 
     */
    public static int differentDaysByMillisecond(String time1,String time2) throws ParseException
    {
    	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 Date date1 = df.parse(time1);
         Date date2 = df.parse(time2);
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
    
    
    public static int differentDaysByMillisecond2(String time1,String time2) throws ParseException
    {
    	 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 Date date1 = df.parse(time1);
         Date date2 = df.parse(time2);
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600));
        return days;
    }
    
    //���ص�ǰ������  
    public static String getNowDate()  
    {  
        Date date = new Date();  
        String nowDate = new SimpleDateFormat("yyyy��MM��dd��").format(date);  
        return nowDate;  
    }  
  
    //���ص�ǰ���  
    public static int getYear()  
    {  
        Date date = new Date();  
        String year = new SimpleDateFormat("yyyy").format(date);  
        return Integer.parseInt(year);  
    }  
  
    //���ص�ǰ�·�  
    public static int getMonth()  
    {  
        Date date = new Date();  
        String month = new SimpleDateFormat("MM").format(date);  
        return Integer.parseInt(month);  
    }  
  
    //�ж�����  
    public static boolean isLeap(int year)  
    {  
        if (((year % 100 == 0) && year % 400 == 0) || ((year % 100 != 0) && year % 4 == 0))  
            return true;  
        else  
            return false;  
    }  
  
    //���ص�������  
    public static int getDays(int year, int month)  
    {  
        int days;  
        int FebDay = 28;  
        if (isLeap(year))  
            FebDay = 29;  
        switch (month)  
        {  
            case 1:  
            case 3:  
            case 5:  
            case 7:  
            case 8:  
            case 10:  
            case 12:  
                days = 31;  
                break;  
            case 4:  
            case 6:  
            case 9:  
            case 11:  
                days = 30;  
                break;  
            case 2:  
                days = FebDay;  
                break;  
            default:  
                days = 0;  
                break;  
        }  
        return days;  
    }  
  
    //���ص�����������  
    public  static int getSundays(int year, int month)  
    {  
        int sundays = 0;  
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");  
        Calendar setDate = Calendar.getInstance();  
        //�ӵ�һ�쿪ʼ  
        int day;  
        for (day = 1; day <= getDays(year, month); day++)  
        {  
            setDate.set(Calendar.DATE, day);  
            String str = sdf.format(setDate.getTime());  
            if (str.equals("������"))  
            {  
                sundays++;  
            }  
        }  
        return sundays;  
    }
    
    
    
    /** 
    * 获得该月第一天 
    * @param year 
    * @param month 
    * @return 
    */  
    public static String getFirstDayOfMonth(int year,int month){  
        Calendar cal = Calendar.getInstance();  
        //设置年份  
        cal.set(Calendar.YEAR,year);  
        //设置月份  
        cal.set(Calendar.MONTH, month-1);  
        //获取某月最小天数  
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);  
        //设置日历中月份的最小天数  
        cal.set(Calendar.DAY_OF_MONTH, firstDay);  
        //格式化日期  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");  
        String firstDayOfMonth = sdf.format(cal.getTime());  
        return firstDayOfMonth;  
    }
    
    
    /** 
    * 获得该月最后一天 
    * @param year 
    * @param month 
    * @return 
    */  
    public static String getLastDayOfMonth(int year,int month){  
            Calendar cal = Calendar.getInstance();  
            //设置年份  
            cal.set(Calendar.YEAR,year);  
            //设置月份  
            cal.set(Calendar.MONTH, month-1);  
            //获取某月最大天数  
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
            //设置日历中月份的最大天数  
            cal.set(Calendar.DAY_OF_MONTH, lastDay);  
            //格式化日期  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");  
            String lastDayOfMonth = sdf.format(cal.getTime());  
            return lastDayOfMonth;  
        } 
    
   
    
    
    
    
    
    /**
     * 判断time是否在from，to之内
     *
     * @param time 指定日期
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    public static Date stringToDate(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    
    
    /**
     * 判断时间是不是今天
     * @param date
     * @return    是返回true，不是返回false
     */
    public static boolean isNow(Date date) {
        //当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        //获取今天的日期
        String nowDay = sf.format(now);
         
         
        //对比的时间
        String day = sf.format(date);
         
        return day.equals(nowDay);
         
         
         
    }
    
    
    /**
     * 返回二个时间相差的分分钟数,如果一个为空，返回为0；
     * @param startDate，比如08：09
     * @param endDate，如18：09
     * @return
     */
    public static int getMinutesDiff(String startDate,String endDate){
         int ret=0;
         
             String startDateStr[]=startDate.split(":");
             String endDateStr[]=endDate.split(":");
             if(startDateStr[0].startsWith("0")){
                 startDateStr[0]=startDateStr[0].substring(1); 
             }
             if(startDateStr[1].startsWith("0")){
                 startDateStr[1]=startDateStr[1].substring(1); 
             }
             if(endDateStr[0].startsWith("0")){
                 endDateStr[0]=endDateStr[0].substring(1); 
             }
             if(endDateStr[1].startsWith("0")){
                 endDateStr[1]=endDateStr[1].substring(1); 
             }
             int s=Integer.parseInt(startDateStr[0])*60+Integer.parseInt(startDateStr[1]);
             int e=Integer.parseInt(endDateStr[0])*60+Integer.parseInt(endDateStr[1]);
             ret=e-s;
         
         return ret;
         
    }
    
    
    public static long getDatePoor(Date endDate, Date nowDate) {
    	 
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return min;
    }
    
    /**
	 * 长整形时间转时间字符串
	 */
	public static String formatTime(long input, String simpleformat) {
		if (StringUtils.isBlank(simpleformat)) {
			simpleformat = DATA_FORMAT_STR;
		}
		SimpleDateFormat formate = new SimpleDateFormat(simpleformat);
		return formate.format(input);
	}

	/**
	 * 时间转字符串
	 */
	public static String formatTime(Date input, String simpleformat) {
		if (StringUtils.isBlank(simpleformat)) {
			simpleformat = DATA_FORMAT_STR;
		}
		SimpleDateFormat formate = new SimpleDateFormat(simpleformat);
		return formate.format(input);
	}
    
    public static void main(String[] args,HttpServletRequest request) throws ParseException  
    {  
       OfTime du = new OfTime();
       long min = du.getDatePoor(du.stringToDate(OfTime.getLongTime()),du.stringToDate("2018-06-30 09:35:32"));
       System.out.println(min);
    }  
    
    
    
    
    /**
     * 获取当前时间戳，单位秒
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis()/1000;
    }

    /**
     * 获取当前时间戳，单位毫秒
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }

    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
    
    
    
}  
    

