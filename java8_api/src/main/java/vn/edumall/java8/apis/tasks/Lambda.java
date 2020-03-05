package vn.edumall.java8.apis.tasks.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

interface PerformOperation {
    boolean check(int a);
}

public class Lambda {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return (int num) -> num % 2 == 0;
    }

    public PerformOperation isPrime() {
        return MyMath::checkPrime;
    }

    private static boolean checkPrime(int num) {
        if (num == 0 || num == 1 || num == 2) return true;
        else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

    public PerformOperation isPalindrome() {
        return MyMath::checkPalindrome;
    }

    private static boolean checkPalindrome(int num) {
        String numTxt = String.valueOf(num);
        char[] chars = numTxt.toCharArray();
        if (numTxt.length() == 1) return true;
        else {
            StringBuilder newNumTxt = new StringBuilder();
            IntStream.range(0, chars.length).mapToObj(i -> chars[chars.length - 1 - i]).forEach(newNumTxt::append);
            if (newNumTxt.toString().equals(numTxt)) return true;
            else return false;
        }
    }
}

