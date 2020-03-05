package vn.edumall.java8.apis.tasks.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CheckNumber {
    // https://www.hackerrank.com/challenges/java-lambda-expressions/problem
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        List<String[]> strArr = new ArrayList<>();
        IntStream.range(0, size).forEach(i -> {
            String str = sc.nextLine();
            String[] numStrs = str.split("\\s+");
            strArr.add(numStrs);
        });

        long start = System.currentTimeMillis();
        strArr.stream().forEach(i -> {
            String result = "";
            switch (Integer.parseInt(i[0])) {
                case 1:
                    result = isOdd(Integer.parseInt(i[1]));
                    break;
                case 2:
                    result = isPrime(Integer.parseInt(i[1]));
                    break;
                case 3:
                    result = isPalindrome(Integer.parseInt(i[1]));
                    break;
            }
            System.out.println(result);
        });
        System.out.println("duration = "+(System.currentTimeMillis()-start));
    }

    private static String isOdd(int num) {
        if( num %2==0) return "EVEN";
        else return "ODD";
    }

    private static String isPrime(int num) {
        if(num == 0 || num == 1 || num == 2) return "PRIME";
        else {
            for (int i = 2; i <= num / 2; i++) {
                if(num%i==0) return "COMPOSITE";
            }
            return "PRIME";
        }
    }

    private static String isPalindrome(int num) {
        String numTxt = String.valueOf(num);
        char[] chars = numTxt.toCharArray();
        if(numTxt.length() == 1) return "PALINDROME";
        else{
            StringBuffer newNumTxt = new StringBuffer();
            IntStream.range(0, chars.length).mapToObj(i -> chars[chars.length - 1 - i]).forEach(newNumTxt::append);
            if(newNumTxt.toString().equals(numTxt)) return "PALINDROME";
            else return "NOT PALINDROME";
        }
    }
}
