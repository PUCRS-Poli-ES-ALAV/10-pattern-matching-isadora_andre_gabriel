public class RabinKarpSearch {

    private static final int R = 256;
    private static final long Q = 1000003;

    public static Result search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
        int countIterations = 0;
        int countInstructions = 0;

        for (int i = 0; i <= N - M; i++) {
            countIterations++;

            String sub = txt.substring(i, i + M);
            long txtHash = hash(sub, M);
            countInstructions++;

            if (patHash == txtHash) {
                return new Result(i + 1, countIterations, countInstructions);
            }
        }
        return new Result(-1, countIterations, countInstructions);
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (h * R + s.charAt(j)) % Q;
        }
        return h;
    }
}
