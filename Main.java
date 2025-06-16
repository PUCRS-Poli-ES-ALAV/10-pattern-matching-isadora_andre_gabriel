import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Naive Pequeno
        long startNaiveSmall = System.nanoTime();
        Result naiveSmall = SubstringSearchNaive.findSubstringNaive("ababcabcab", "abc");
        long endNaiveSmall = System.nanoTime();
        long naiveSmallTime = (endNaiveSmall - startNaiveSmall) / 1_000_000;

        // Naive Grande
        long startNaiveLarge = System.nanoTime();
        Result naiveLarge = SubstringSearchNaive.findSubstringNaive(generateRandomString(600000), "ABCDE");
        long endNaiveLarge = System.nanoTime();
        long naiveLargeTime = (endNaiveLarge - startNaiveLarge) / 1_000_000;

        // Rabin-Karp Pequeno
        long startRKSmall = System.nanoTime();
        Result rkSmall = RabinKarpSearch.search("ADF", "ABCDCBDCBDACBDABDCBADF");
        long endRKSmall = System.nanoTime();
        long rkSmallTime = (endRKSmall - startRKSmall) / 1_000_000;

        // Rabin-Karp Grande
        long startRKLarge = System.nanoTime();
        Result rkLarge = RabinKarpSearch.search("ABCDE", generateRandomString(600000));
        long endRKLarge = System.nanoTime();
        long rkLargeTime = (endRKLarge - startRKLarge) / 1_000_000;

        // KMP Pequeno
        long startKMPSmall = System.nanoTime();
        Result kmpSmall = KMPStringMatching.search("abc", "ababcabcab");
        long endKMPSmall = System.nanoTime();
        long kmpSmallTime = (endKMPSmall - startKMPSmall) / 1_000_000;

        // KMP Grande
        long startKMPLarge = System.nanoTime();
        Result kmpLarge = KMPStringMatching.search("ABCDE", generateRandomString(600000));
        long endKMPLarge = System.nanoTime();
        long kmpLargeTime = (endKMPLarge - startKMPLarge) / 1_000_000;

        System.out.println("+---------------------------+-------------+------------+--------------+-------------+");
        System.out.printf("| %-25s | %-11s | %-10s | %-12s | %-11s |\n", "Algoritmo", "Posição", "Iterações",
                "Instruções", "Tempo (ms)");
        System.out.println("+---------------------------+-------------+------------+--------------+-------------+");

        System.out.printf("| %-25s | %-11d | %-10d | %-12d | %-11d |\n", "Naive Pequeno", naiveSmall.position,
                naiveSmall.iterations, naiveSmall.instructions, naiveSmallTime);
        System.out.printf("| %-25s | %-11d | %-10d | %-12d | %-11d |\n", "Naive Grande", naiveLarge.position,
                naiveLarge.iterations, naiveLarge.instructions, naiveLargeTime);

        System.out.printf("| %-25s | %-11d | %-10d | %-12d | %-11d |\n", "Rabin-Karp Pequeno", rkSmall.position,
                rkSmall.iterations, rkSmall.instructions, rkSmallTime);
        System.out.printf("| %-25s | %-11d | %-10d | %-12d | %-11d |\n", "Rabin-Karp Grande", rkLarge.position,
                rkLarge.iterations, rkLarge.instructions, rkLargeTime);

        System.out.printf("| %-25s | %-11d | %-10d | %-12d | %-11d |\n", "KMP Pequeno", kmpSmall.position,
                kmpSmall.iterations, kmpSmall.instructions, kmpSmallTime);
        System.out.printf("| %-25s | %-11d | %-10d | %-12d | %-11d |\n", "KMP Grande", kmpLarge.position,
                kmpLarge.iterations, kmpLarge.instructions, kmpLargeTime);

        System.out.println("+---------------------------+-------------+------------+--------------+-------------+");
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
