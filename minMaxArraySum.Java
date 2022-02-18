import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        //used long to avoid ovrerflow
    long totalSum = 0; 
    long min, max; 
    long[] sumArr = new long[5];
    
    for(int i = 0; i < arr.size(); i++){
        totalSum += arr.get(i); 
    }  
    
    for(int i = 0; i < arr.size(); i++){
        sumArr[i] = totalSum - arr.get(i);
    }

    min = sumArr[0];
    max = sumArr[0];

    for(int i = 1; i < sumArr.length; i++){
        if(min > sumArr[i]){
            min = sumArr[i];
        }
        if(max < sumArr[i]){
            max = sumArr[i];
        }
    
    }
    System.out.print(min + " " + max);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
