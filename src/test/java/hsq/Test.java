package hsq;

import java.util.Scanner;

public class Test {
	private static final double PI=3.1415;
    public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入圆的半径：");
		double r=scanner.nextDouble();
		double C=2*PI*r;
		double S=PI*r*r;
		System.out.println("圆的周长是："+C);
		System.out.println("圆的面积是："+S);
		
		
		for (int j = 0; j < 4; j++) {
			int  total=0;
			for(int i=0;i<4;i++  )
			{
				if(i==1) continue;
				if(i==2) break;
	            total+=i;
			}
			System.out.println("total====="+total);
		}
	

	}
}
