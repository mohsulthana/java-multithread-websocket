
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sulthan
 */
public class CodingTesting {
    public static String reverseString(String str) {
        
        byte[] strAsByteArray = str.getBytes();
        
        byte[] result = new byte[strAsByteArray.length];
        
        for (int i = 0; i < strAsByteArray.length; i++) {
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        return new String(result);
    }
    
    public static void evenOdd(int number) {
        String result = null;
        if (number % 2 == 0) {
            result = "Genap";
        } else {
            result = "Ganjil";
        }
        System.out.println(result);
    }
    
    public static int[] bubbleSort(int[] number) {
        boolean sorted = false;
        
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < number.length - 1; i++) {
                if (number[i] > number[i + 1]) {
                    int temp = number[i];
                    number[i] = number[i + 1];
                    number[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return number;
    }
    
    static void printArray(int arr[]) {
        int len = arr.length;
        
        for (int i = 0; i < len; i++)
            System.out.println(arr[i] + " ");
    }
    
    public static void main(String args[]) {
        int arr[] = {3, 64, 28, 4, 78, 398, 57, 345};
        bubbleSort(arr);
        printArray(arr);
    }
}
