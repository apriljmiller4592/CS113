package edu.miracosta.cs113;

import java.util.Scanner;

/**
 * Author: April Miller
 *
 * DriverClass: Tests different solutions in order to check different theories
 * that will either be refuted or confirmed by Assistant Jack.
 */
public class DriverClass{

    /**
     * Checks checkAnswer() method 20 times in order to uncover one of the
     * three solution sets. Each is incremented up once every check and
     * duplicates are removed. If the solution is reached, the solution
     * and total amount of checks will be displayed. If not, a failure
     * message is shown.
     * @param args
     */
    public static void main(String[] args) {
    // DECLARATION + INITIALIZATION
        int answerSet, solution = 1, murder = 1, weapon = 1, location = 1;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome Detective Jill! Dr. Foo has been murdered and we need your help.");
        System.out.println("Which theory would you like to test?");
        System.out.println("1 \n2 \n3 ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        jack = new AssistantJack(answerSet);

        while (solution != 0) {

            solution = jack.checkAnswer(weapon, location, murder);
                switch (solution) {
                    case 1:
                        weapon++;
                        break;

                    case 2:
                        location++;
                        break;

                    case 3:
                        murder++;
                        break;
                }
        }
        answer = new Theory(weapon, location, murder);

        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("You have failed us, Detective! Back to the drawing board...");
        } else {
            System.out.println("You cracked the case! Case closed.");
        }
 }
}