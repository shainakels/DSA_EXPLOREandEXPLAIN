//PINKACHU
import java.util.BitSet;

public class primeSieveEratosthenes {
    static final int MAX = 100;

    public static void main(String[] args) {
        sieveOfEratosthenes();
    }

    public static void sieveOfEratosthenes() {
        BitSet isPrime = new BitSet(MAX);
        isPrime.set(2);

        for (int i = 3; i < MAX; i += 2) {
            isPrime.set(i);
        }

        for (int p = 3; p * p < MAX; p += 2) {
            if (isPrime.get(p)) {

                for (int multiple = p * p; multiple < MAX; multiple += p * 2) {
                    isPrime.clear(multiple);
                }
            }
        }

        System.out.println("Prime numbers less than " + MAX + ":");
        System.out.print(2 + " "); 
        for (int i = 3; i < MAX; i += 2) {
            if (isPrime.get(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
