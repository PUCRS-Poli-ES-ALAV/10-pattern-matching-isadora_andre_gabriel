public class Main {
    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";

        Result result = SubstringSearchNaive.findSubstringNaive(s1, s2);

        System.out.println(result);
    }
}
