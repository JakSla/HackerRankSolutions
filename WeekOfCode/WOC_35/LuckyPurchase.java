package WeekOfCode.WOC_35;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LuckyPurchase {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        //String regex = "^[47]*$"; can be done easier with regex

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        for (int a = 0; a < i; a++) {
            String s = in.next();
            int n = in.nextInt();

            String nString = String.valueOf(n);

            if (nString.contains("7") && nString.contains("4")) {
                if (!nString.contains("1") && !nString.contains("2") && !nString.contains("3") && !nString.contains("5") && !nString.contains("6") && !nString.contains("8") && !nString.contains("9") && !nString.contains("0"))
                    if ((nString.length() - nString.replace("4", "").length()) == (nString.length() - nString.replace("7", "").length())) {
                        map.put(s, n);
                    }
            }
        }
        in.close();

        if (!map.isEmpty()) {
            Integer min = Collections.min(map.values());

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == min) {
                    System.out.print(e.getKey());
                    return;
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}
