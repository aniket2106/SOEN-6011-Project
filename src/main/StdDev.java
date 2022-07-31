package main;
import java.util.Scanner;
public class StdDev {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size =0;
		do {
			try {
				System.out.print("Enter size of the array:");
				size = input.nextInt();
				if(size==0 || size==1)
				{
					System.out.println("Atleast two numbers are needed to find Standard deviation.");
				}
			}catch(Exception e) {
				input.next();
				System.out.println("Please enter valid input");
			}
		}while(size<=1);
		
		System.out.println("Enter "+size+" elements:");
		double[] array = new double[size];
		for(int i=0; i<size; i++)  
		{
			try {
				System.out.print("Enter element number "+(i+1)+": ");
				array[i]=input.nextDouble();
			}catch(Exception e) {
				input.next();
				System.out.println("Please Enter the numbers only");
				i--;
			}
		}
		
		double sum = CalculateSum(array);
		double mean = sum/size;
		double variance = calculateVariance(array,mean,size);
		double variance2 = calculateVariance(array,mean,size-1);
		double PopulationStandardDeviation = squareRoot(variance);
		double SampleStandardDeviation = squareRoot(variance2);
		
		System.out.println("Population Standard Deviation is: "+PopulationStandardDeviation);
		System.out.println("Sample Standard Deviation is: "+SampleStandardDeviation);
		System.out.println(variance2);
	}
	
	public static double CalculateSum(double a[])
	{
		double temp=0;
		for (double i : a)
		    temp += i;
		return temp;
	}
	
	public static double power(double x, double y)
	{ 
		double result = x; 
		for (int i = 1; i < y; i++) 
		{ 
			result *= x; 
		} 
		return result; 
	}
	
	public static double calculateVariance(double array[],double mean,int size)
	{
		double sd = 0;
		for (int i = 0; i < array.length; i++) 
		{    
            sd = sd + power((array[i] - mean), 2);
        }
		double variance = sd/size;
		return variance;
	}
	
	public static double squareRoot(double number) {
	    double temp;
	    double squareRoot = number / 2;
	    do 
	    {
	      temp = squareRoot;
	      squareRoot = (temp + (number / temp)) / 2;
	    } while ((temp - squareRoot) != 0);
	    return temp;
	  }
}
