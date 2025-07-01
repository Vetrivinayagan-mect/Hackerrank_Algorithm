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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
     public static boolean isValid(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)) return false;
        }
        return true;
     }

    public static int alternate(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength =0;
        for(char c: s.toCharArray()){
            set.add(c);
        }
        List<Character> list = new ArrayList<>(set);
       
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                char a=list.get(i);
                char b=list.get(j);
                StringBuilder result = new StringBuilder();
                for(char ch:s.toCharArray()){
                    if(ch==a||ch==b){
                        result.append(ch);
                    }
                }
                if(isValid(result.toString())){
                    maxLength= Math.max(maxLength,result.length());
                }
                
            }
            
        }
        return maxLength;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
