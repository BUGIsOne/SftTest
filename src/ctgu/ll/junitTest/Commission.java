package ctgu.ll.junitTest;

import java.util.Scanner;
public class Commission{
	public static void main(String[] args) {
		double lockprice=45;
		double stockprice=30;
		double barrelprice=25;
		double totallocks=0;
		double totalstocks=0;
		double totalbarrels=0;
		double commission;
  
		Scanner input=new Scanner(System.in);
		System.out.print("Input the locks,stocks and barrels:");
		int locks=input.nextInt();
 
		if(locks==-1){
			System.out.print("当月销售活动结束！\n");
		}
  
		if(locks!=-1) {
			int stocks=input.nextInt();
			int barrels=input.nextInt();
			totallocks=totallocks+locks;
			totalstocks=totalstocks+stocks;
			totalbarrels=totalbarrels+barrels;
   
			System.out.print("Locks sold:"+totallocks+"\nStocks sold:"+totalstocks+"\nbarrels sold:"+totalbarrels+"\n");
		}
  
		double locksales=lockprice*totallocks;
		double stocksales=stockprice*totalstocks;
		double barrelsales=barrelprice*totalbarrels;
		double sales=locksales+stocksales+barrelsales;
  
		System.out.print("total sales:"+sales);
  
		if(sales>1800.0)
		{
			commission=0.10*1000.0;
			commission=commission+0.15*800.0;
			commission=commission+0.20*(sales-1800);
		}
		else if(sales>1000.0)
		{
			commission=0.10*1000.0;
			commission=commission+0.15*(sales-1000.0);
		}
		else commission=0.10*sales;
  
		System.out.print("commission is $:"+commission);
	}

}