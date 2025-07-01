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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        boolean isDigit = false;
        boolean isUpper = false;
        boolean isLower = false;
        boolean isSpcl = false;
        String str = "!@#$%^&*()-+";
        for(char ch : password.toCharArray()){
            if(Character.isDigit(ch)) isDigit=true;
            else if(Character.isUpperCase(ch)) isUpper = true;
            else if(Character.isLowerCase(ch)) isLower = true;
            else if(str.indexOf(ch)>=0) isSpcl = true;
        }
        int count=0;
        if(!isDigit) count++;
        if(!isLower) count++;
        if(!isSpcl) count++;
        if(!isUpper) count++;
        
        return Math.max(count,6-n);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
