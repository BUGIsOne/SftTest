package ctgu.ll.junitTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class NextDate {

	public static void main(String[] args) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入一个日期：格式为（xxxx-xx-xx）,退出请输入exit");
				String str = sc.nextLine();
				if (str.equals("exit")) {
					System.exit(1);
				}
				str.trim();
				String str1 = str.replaceAll(" ", "");// 去除字符串中的空格
				// System.out.println(str1);
				String[] date = str1.split("-");
				/*
				 * for (String i : date) { System.out.println(i); }
				 */
 
				if (date.length < 3) {
					System.out.println("抱歉，你输入的日期不完整，请按照例：2018-11-20");
					continue;
				}
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < date.length; i++) {
					list.add(Integer.parseInt(date[i]));
				}
				int year = list.get(0);
				int month = list.get(1);
				int day = list.get(2);
 
				if (year < 1) {
					System.out.println("抱歉,您输入的年份有误!");
					continue;
				}
 
				if (month < 1 || month > 12) {
					System.out.println("抱歉，您输入的月份有误！");
					continue;
				}
 
				if (month == 12 && day == 31) {
					System.out.println("NextDay:" + (year + 1) + "-1-1");
					continue;
				}
 
				// 判断输入的年份是平年还是闰年,来判断当输入2月时天数是否有误
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {// 该年是闰年,2月有29天
					if (month == 2) {
						if (day > 29) {
							System.out.println("抱歉," + year + "是闰年,2月只有29天!");
							continue;
						} else if (day < 1) {
							System.out.println("抱歉,您输入的日期有误!");
							continue;
						} else {
							if (day == 29) {
								System.out.println("NextDay:" + year + "-" + 3 + "-" + 1);
								continue;
							} else {
								day += 1;
							}
						}
 
					}
				} else {// 该年是平年,2月有28天
					if (month == 2) {
						if (day > 28) {
							System.out.println("抱歉,今年是闰年,2月只有28天!");
							continue;
						} else if (day < 1) {
							System.out.println("抱歉,您输入的日期有误!");
							continue;
						} else {
							if (day == 28) {
								System.out.println("NextDay:" + year + "-" + 3 + "-" + 1);
								continue;
							} else {
								day += 1;
							}
						}
					}
				}
 
				// 判断4 6 9 11 月的天数输入
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					if (day > 30) {
						System.out.println("抱歉," + month + "月只有30天!");
						continue;
					} else if (day < 1) {
						System.out.println("抱歉,您输入的日期有误!");
						continue;
					} else {
						if (day == 30) {
							month += 1;
							day = 1;
						} else {
							day += 1;
						}
					}
				} else if (month != 2) { // 判断1 3 5 7 8 10 12月的天数输入
					if (day > 31) {
						System.out.println("抱歉," + month + "月只有31天");
						continue;
					} else if (day < 1) {
						System.out.println("抱歉,您输入的日期有误!");
						continue;
					} else {
						if (day == 31) {
							month += 1;
							day = 1;
						} else {
							day += 1;
						}
					}
				}
 
				System.out.println("NextDay:" + year + "-" + month + "-" + day);
 
			} catch (NumberFormatException e) {
				System.out.println("抱歉，您的输入有误，不要输入数字以外的字符！");
			}
		}
	}
}

