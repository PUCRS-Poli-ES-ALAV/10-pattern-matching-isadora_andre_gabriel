public class KMPStringMatching {
    
    public static Result search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];
        int j = 0;
        int iterations = 0;
        int instructions = 0;

        computeLPSArray(pat, M, lps);

        int i = 0;
        while (i < N) {
            iterations++;

            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
                instructions += 2;
            }

            if (j == M) {
                return new Result(i - j + 1, iterations, instructions);
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                    instructions++;
                } else {
                    i++;
                    instructions++;
                }
            }
        }

        return new Result(-1, iterations, instructions);
    }

    private static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
