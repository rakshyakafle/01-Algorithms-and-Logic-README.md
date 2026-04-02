// RakshyaKafle 
// OCCC - Advance Java 
// Magic8ball

import java.util.Scanner;
import java.util.Random; 

public class Magic8Ball {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int questionCount = 0;

        String[] responses = {
        	"Yes, definitely!",
                "It is certain.",
                "Without a doubt.",
                "Signs point to yes.",
                "Ask again later.",
                "Better not tell you now.",
                "Cannot predict now.",
                "Don't count on it.",
                "My sources say no.",
                "Very doubtful.",
                "No way. ",
        };

        System.out.println("The Magic 8 Ball will answer all of your questions!");

        while (true) {
            System.out.print("Ask the Magic 8 Ball a question ");
            String question = scanner.nextLine();

            if (question.isEmpty()) { 
                System.out.println("\nWell, that might not be the answer you were looking for… so try again!");
                System.out.println("Questions answered: " + questionCount);
                break; 
            } else {
                int randomIndex = random.nextInt(responses.length);
                System.out.println(responses[randomIndex]);
                System.out.println(); 
                
                questionCount++;
            }
        } 
        
        scanner.close(); 
    } 
} 