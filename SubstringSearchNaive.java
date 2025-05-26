public class SubstringSearchNaive {
    public static Result findSubstringNaive(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int countIterations = 0;
        int countInstructions = 0;

        for (int i = 0; i <= n - m; i++) {
            countIterations++;
            boolean match = true;
            for (int j = 0; j < m; j++) {
                countInstructions++;
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return new Result(i + 1, countIterations, countInstructions);
            }
        }
        return new Result(-1, countIterations, countInstructions);
    }
}
