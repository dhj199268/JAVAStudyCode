package com.tool.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private DateUtil() {
	};

	/**
	 * ��ȡ�����0��ʱ��
	 * 
	 * @user coding�� 2014��7��12��
	 */
	public static Date getTodayStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * ��ʽ �����ڣ����ط��ϸ�ʽ���ַ���
	 * 
	 * @param date
	 * @param formater
	 *            ��:yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 */
	private static String getDateStrCompact(Date date, String formater) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		String str = format.format(date);
		return str;
	}

	/**
	 * ��ʽ �����ڣ����ط��ϸ�ʽ���ַ���
	 * 
	 * @param date
	 * @param formater
	 *            Ĭ�� yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateToString(Date date, String formatStr) {
		if (formatStr == null || "".equals(formatStr.trim())) {
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		return getDateStrCompact(date, formatStr);
	}

	/**
	 * ��ʽ�������ַ��������ط��ϸ�ʽ��date
	 * 
	 * @param dateStr
	 * @param formater
	 *            ��:yyyy-MM-dd HH:mm:ss
	 * @return
	 * 
	 */
	public static Date StringToDate(String dateStr, String formater) {
		Date date = null;
		if (formater == null || "".equals(formater.trim())) {
			formater = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formater);
		if (!StringUtil.isNotBlank(dateStr)) {
			return date;
		}
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * ���������� n ��
	 * 
	 * @param date
	 *            ��������,���Ϊnull��ȡ��ǰ����
	 * @param days
	 *            ���������� (Ϊ���������ӣ�Ϊ���������)
	 * @return Date
	 */
	public static Date addDate(Date date, int days) {
		return addDate(date, days, Calendar.DATE);
	}

	/**
	 * ȡĳһ�������� n ֵ�������, n �� dateField �������ꡢ�¡��� ��������or���ٵ�ʱ��õ��µ�����
	 * 
	 * @param date
	 *            ��������
	 * @param counts
	 *            ��������ֵ
	 * @param dateField
	 *            int ������������ֶ�, ȡֵ��Χ���� Calendar.YEAY �� Calendar.MONTH ��
	 *            Calendar.DATE �� .... Calendar.SECOND ��
	 * @return Date
	 */
	private static Date addDate(Date date, int counts, int dateField) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateField, counts);
		return calendar.getTime();
	}

	public static long getTimeInMillis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}
}
