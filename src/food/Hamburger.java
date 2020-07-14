package food;

import java.util.Scanner;
import static java.lang.System.*;

public class Hamburger {

    private final String nameOfBurger;
    private final String breadType;
    private final String meat;
    private final int price;
    private int countAdditions;
    private int priceAdditions;
    private boolean exiting = false;
    private final String[] options = new String[4];
    private final String[] type = {"lettuce", "tomatoes", "carrots", "pickles"};
    private final int[] pricesNum = {2,3,4,4};
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";


    public Hamburger(final String nameOfBurger, final String breadType, final String meat, final int price) {
        this.nameOfBurger = nameOfBurger;
        this.breadType = breadType;
        this.meat = meat;
        this.price = price;
    }

    public void introToHamburger(String msg) {
        out.print("|");
        for (int i = 0; i < msg.length(); i++) {
            out.print("-");
        }
        out.print("|");
        out.println("\n" + "|" + GREEN + msg + RESET + "|");
        out.print("|");

        for (int j = 0; j < msg.length(); j++) {
            out.print("-");
        }
        out.print("|");
        out.println();
    }

    public void addIngredient() {
        Scanner input = new Scanner(in);
        int j = 0;
        int counter = 0;
        int diffCount;
        while (!exiting && countAdditions < 4) {
            out.print("[" + (j+1) + "]" + " " + "*Which type of ingredient you want to add: Lettuce, Tomatoes, Carrots, Pickles, final ? - ");
            boolean check = input.hasNextLine();
            if (check) {
                String option = input.nextLine().toLowerCase();
                for (int i = 0; i < type.length; i++) {
                    if (option.equals(type[i])) {
                        options[j] = option;
                        this.countAdditions++;
                        out.println(GREEN + "--" + type[i].toUpperCase().charAt(0) + type[i].substring(1) + " added." + RESET);
                        String message = "------------------------------------";
                        out.println(message);
                        getPricePerAdditionAdded(option);
                        if (options[0] != null && counter == 0) {
                            getInitialPrice();
                            counter++;
                        }
                        for (int t = 0; t < pricesNum.length; t++) {
                            if (type[i].equals(options[t])) {
                                this.priceAdditions += pricesNum[i];
                                break;
                            }
                        }
                        getFinalPrice();
                        out.println(message);
                        j++;
                    } else if (option.equals("final")) {
                        exiting = true;
                        out.println(RED + "**Exiting..." + RESET);
                        out.println("-----------------------");
                        break;
                    }
                }
                diffCount = 0;
                for (int b = 0; b < type.length; b++) {
                    if (!option.equals(type[b])) {
                        diffCount++;
                    } else if (countAdditions == 4) {
                        exiting = true;
                    }
                }
                if (diffCount == 4 && !option.equals("final")) {
                    out.println("------------------------------------------");
                    out.println(RED + "|***You need to enter your choice again..." + RESET);
                    out.println("------------------------------------------");
                }
            }
        }
    }

    public void typeOfIngredientsAdded() {
        out.print(GREEN + "|" + RESET + "-We have the following additions in the burger: ");
        for (int i = 0; i < options.length; i++) {
            if (i > 0 && i <= options.length - 1 && options[i] != null) {
                out.print(", ");
            } else if (options[i] == null) {
                continue;
            }
            out.print(options[i].toUpperCase().charAt(0) + options[i].substring(1));
            if (i == countAdditions - 1) {
                out.print(".");
            }
        }
        if (countAdditions == type.length) {
            out.print("\n" + GREEN + "|" + RESET + GREEN + "**" + RESET + "All available ingredients were added to the burger.");
        }
    }

    public void getPricePerAdditionAdded(String choice) {
        for (int i = 0; i < type.length; i++) {
            for (int k = 0; k < pricesNum.length; k++) {
                if (type[i].equals(choice) && i == k) {
                    out.println(GREEN + "|" + RESET + "-Price of " + choice + "s: " + pricesNum[k] + "$");
                }
            }
        }
    }

    public void getPriceOfAdditions() {
        out.println(GREEN +"|" + RESET + "-Price for all additions included in the base burger: " + priceAdditions + "$");
    }

    public void getFinalPrice() {
        int pricing = price + priceAdditions;
        out.println(GREEN +"|" + RESET + RED + "-TOTAL: " + RESET + GREEN + pricing + "$" + RESET);
    }

    public void numberOfAdds() {
        out.println(GREEN + "|" + RESET + "-Number of additions: " + countAdditions);
    }

    public void getInitialPrice() {
        out.println(GREEN + "|" + RESET + "-Initial price of the burger: " + price + "$");
    }

}
