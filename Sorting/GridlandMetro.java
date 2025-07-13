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
     * Complete the 'gridlandMetro' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER k
     *  4. 2D_INTEGER_ARRAY track
     */

   public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
    Map<Integer, List<int[]>> rowTracks = new HashMap<>();

    // Group tracks by row
    for (List<Integer> t : track) {
        int r = t.get(0), c1 = t.get(1), c2 = t.get(2);
        rowTracks.computeIfAbsent(r, x -> new ArrayList<>()).add(new int[]{c1, c2});
    }

    long occupiedCells = 0;

    for (List<int[]> intervals : rowTracks.values()) {
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
            if (curr[0] > end) {
                occupiedCells += end - start + 1;
                start = curr[0];
                end = curr[1];
            } else {
                end = Math.max(end, curr[1]);
            }
        }

        occupiedCells += end - start + 1;
    }

    long totalCells = (long) n * m;
    return (totalCells - occupiedCells);
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> track = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                track.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
