import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";

        System.out.println("Rabin-Karp:");
        System.out.println(RabinKarpSearch.search(s2, s1));

        String largeS1 = generateRandomString(600_000);
        String largeS2 = "ABCDEF";

        System.out.println("\nRabin-Karp com strings grandes:");
        System.out.println(RabinKarpSearch.search(largeS2, largeS1));

        System.out.println("\\nKMP com string pequena:");
        System.out.println(KMPStringMatching.search("abc", "ababcabcab"));

        String longText = generateRandomString(600000);
        String longPattern = "ABCDE";

        System.out.println("\\nKMP com string grande:");
        System.out.println(KMPStringMatching.search(longPattern, longText));
    }

    public static String generateRandomString(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}
