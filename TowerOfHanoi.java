/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Darien Ramirez Hennessey
* @version 1.0
* @since   2021-12-12
*/

import java.util.Scanner;

final class TowerOfHanoi {
    private TowerOfHanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        //
        throw new IllegalStateException("Cannot be instantiated");
    }


    static void hanoi(final int nOfDisks, final int STARTPEG,
                             final int ENDPEG) {

        // This function calculates where the disks should be placed in
        // Reducible YouTube Channel : Towers of Hanoi: A Complete Recursive Visualization viewed to provide detailed explanation.

        final int PEG_NUMBER = 6;  //Use the sum of the rods (6) to calc new STARTPEG  and ENDPEG
        if (nOfDisks == 1){
            System.out.println("Move disk 1 from peg " + STARTPEG + " to peg "
                               + ENDPEG);
        } else {

           hanoi(nOfDisks - 1, STARTPEG, PEG_NUMBER - STARTPEG - ENDPEG);
           System.out.println("Move disk " + nOfDisks + " from peg "
                               + STARTPEG + " to peg " + ENDPEG);
           hanoi(nOfDisks - 1, PEG_NUMBER - STARTPEG - ENDPEG, ENDPEG);
        }
    }

    public static void main(final String[] args) {

        final int STARTPEG = 1;      //constants changed to capitals
        final int ENDPEG = 3;

        System.out.println("Tower of Hanoi");

        // input
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                hanoi(nOfDisks, STARTPEG, ENDPEG);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (Exception ex) {
            System.err.print("\nThis is not an integer");
        }
    }
}