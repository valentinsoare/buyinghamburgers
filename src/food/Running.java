package food;

import java.util.Scanner;
import static java.lang.System.out;

public class Running {

    private static final String ERROR_MESSAGE = "Invalid Value";
    private static final String space = "---------------------------------------------";

    public static void intro(String msg) {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        out.print("|");
        for (int i = 0; i < msg.length(); i++) {
            out.print("-");
        }
        out.print("|");
        out.println("\n" + "|" + RED + msg + RESET + "|");
        out.print("|");

        for (int j = 0; j < msg.length(); j++) {
            out.print("-");
        }
        out.print("|");
        out.println();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        intro("**---SECOND RUN OF EXERCISES**---");
        Hamburger base = new Hamburger("Miezul", "pufoasa", "vita", 12);
        base.introToHamburger("--BILL's HAMBURGER JOINT--");
        out.println();
        base.addIngredient();
        base.numberOfAdds();
        base.typeOfIngredientsAdded();
        out.println();
        base.getInitialPrice();
        base.getPriceOfAdditions();
        base.getFinalPrice();
        out.println(space);
    }
}
