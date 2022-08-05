package main;

import java.util.Scanner;

/**.
 * \n@author Aniket Tailor
 */
public class StdDev {
  /**.
    * \n@author Aniket Tailor
    * \n@param args
    */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = 0;
    do {
      try {
        System.out.print("Enter size of the array:");
        size = input.nextInt();
        if (size == 0 || size == 1) {
          System.out.println("Atleast two numbers are needed to find Standard deviation.");
        }
      } catch (Exception e) {
        input.next();
        System.out.println("Please enter valid input");
      }
    } while (size <= 1);
    System.out.println("Enter " + size + " elements:");
    double[] array = new double[size];
    for (int i = 0; i < size; i++)  {
      try {
        System.out.print("Enter element number " + (i + 1) + ": ");
        array[i] = input.nextDouble();
      } catch (Exception e) {
        input.next();
        System.out.println("Please Enter the numbers only");
        i--;
      }
    }
    boolean same = checkArrayValues(array);
    if (same) {
      System.out.println("Standard Deviation is: 0");
    } else {
      double sum = calculateSum(array);
      double mean = sum / size;
      double variance = calculateVariance(array, mean, size);
      double variance2 = calculateVariance(array, mean, size - 1);
      double populationStandardDeviation = squareRoot(variance);
      double sampleStandardDeviation = squareRoot(variance2);
      System.out.println("Population Standard Deviation is: " + populationStandardDeviation);
      System.out.println("Sample Standard Deviation is: " + sampleStandardDeviation);
    }
    input.close();
  }

  /**
   * This function calculates sum of all the elements in the array.
   *
   * @author Aniket Tailor.
   * @param a array of values for which sum is to be calculated.
   * @return temp.
   */
  public static double calculateSum(double []a) {
    double temp = 0;
    for (double i : a) {
      temp += i;
    }
    return temp;
  }

  /**
 * This method calculates power.
 *
 * @author Aniket Tailor.
 * @param x x
 * @param y y
 * @return result.
 */
  public static double power(double x, double y) { 
    double result = x; 
    for (int i = 1; i < y; i++) { 
      result *= x; 
    } 
    return result; 
  }

  /**
   * This method calculates Variance.
   *
   * @author Aniket Tailor
   * @param array parameter
   * @param mean parameter
   * @param size parameter
   * @return variance
   */
  public static double calculateVariance(double []array, double mean, int size) {
    double sd = 0;
    for (int i = 0; i < array.length; i++) {    
      sd = sd + power((array[i] - mean), 2);
    }
    double variance = sd / size; 
    return variance;
  }

  /**
   * This method finds square root of the given value.
   *
   * @author Aniket Tailor
   * @param number parameter
   * @return squareroot of the number
   */
  public static double squareRoot(double number) {
    double temp;
    double squareRoot = number / 2;
    do {
      temp = squareRoot;
      squareRoot = (temp + (number / temp)) / 2;
    } while ((temp - squareRoot) != 0);
    return temp;
  }

  /**
    * This method checks if the values in array are same or not.
    *
    * @author Aniket Tailor
    * @param array parameter
    * @return true of false
    */
  public static boolean checkArrayValues(double[] array) {
    if (array.length == 0) {
      return true;
    } else {
      double first = array[0];
      for (double element : array) {
        if (element != first) {
          return false;
        }
      }
      return true;
    }
  }
}
