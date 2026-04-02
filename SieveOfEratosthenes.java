//Rakshya Kafle
//OCCC- Advance Java
// SieveOfEratosthenes

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        System.out.println("Welcome to the Sieve of Eratosthenes Program!");

        int start;
        int stop;

        // Check command line arguments
        if (args.length >= 2) {
            start = Integer.parseInt(args[0]);
            stop = Integer.parseInt(args[1]);
        } else {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter start value (>1): ");
            start = input.nextInt();

            System.out.print("Enter stop value: ");
            stop = input.nextInt();

            input.close();
        }

        if (start <= 1 || stop <= start) {
            System.out.println("Invalid input.");
            return;
        }

        long beginTime = System.nanoTime();

        boolean[] prime = new boolean[stop + 1];

        for (int i = 2; i <= stop; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= stop; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= stop; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = start; i <= stop; i++) {
            if (prime[i]) {
                count++;
            }
        }

        long endTime = System.nanoTime();
        double seconds = (endTime - beginTime) / 1_000_000_000.0;

        System.out.println("Total primes between " + start + " and " + stop + ": " + count);
        System.out.println("Execution time: " + seconds + " seconds");
    }
}
