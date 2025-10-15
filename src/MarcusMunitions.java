import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MarcusMunitions {

    public static void main(String[] args) {

/* -------------------------
------- INTRO SCREEN -------
------------------------- */

        String asciiArt1 = HackerTerminalFX.GREEN + "              ░░▒██████████▒░" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "                           ███    ███  █████  ██████   ██████ ██    ██ ███████" + HackerTerminalFX.RESET; System.out.println(asciiArt1);
        String asciiArt2 = HackerTerminalFX.GREEN + "            ░█████▓▒█▓▓██████████▒" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "                      ████  ████ ██   ██ ██   ██ ██      ██    ██ ██" + HackerTerminalFX.RESET; System.out.println(asciiArt2);
        String asciiArt3 = HackerTerminalFX.GREEN + "         ░████▓▒██▓▒█▒░███████████▒" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "                     ██ ████ ██ ███████ ██████  ██      ██    ██ ███████" + HackerTerminalFX.RESET; System.out.println(asciiArt3);
        String asciiArt4 = HackerTerminalFX.GREEN + "         ▓████▓▒▓█▒▒░░▒▒▒▓▒▓█▓█████▒" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "                    ██  ██  ██ ██   ██ ██   ██ ██      ██    ██      ██" + HackerTerminalFX.RESET; System.out.println(asciiArt4);
        String asciiArt5 = HackerTerminalFX.GREEN + "        ░███▓██▓░░        ░░▓██▓▓▒▓█░" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "                   ██      ██ ██   ██ ██   ██  ██████  ██████  ███████" + HackerTerminalFX.RESET; System.out.println(asciiArt5);
        String asciiArt6 = HackerTerminalFX.GREEN + "         ░█░        ░░      ░█▓▓▒░▒█░" + HackerTerminalFX.RESET; System.out.println(asciiArt6);
        String asciiArt7 = HackerTerminalFX.GREEN + "         ░▓░     ░██████▒    ▒▒▒▓▒▒▒▒█░" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "      ███    ███ ██    ██ ███    ██ ██ ████████ ██  ██████  ███    ██ ███████" + HackerTerminalFX.RESET; System.out.println(asciiArt7);
        String asciiArt8 = HackerTerminalFX.GREEN + "         ▓▒░ ░▒▓██▒ ░   ░▓░  ░▒█▒▒██▓▒▒" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "      ████  ████ ██    ██ ████   ██ ██    ██    ██ ██    ██ ████   ██ ██" + HackerTerminalFX.RESET; System.out.println(asciiArt8);
        String asciiArt9 = HackerTerminalFX.GREEN + "        ▒████▒░░▒░▓▓█▓▒▒░░    ▓░   ░▒▒▒" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "      ██ ████ ██ ██    ██ ██ ██  ██ ██    ██    ██ ██    ██ ██ ██  ██ ███████" + HackerTerminalFX.RESET; System.out.println(asciiArt9);
        String asciiArt10 = HackerTerminalFX.GREEN + "        ░█▓▒▒█    ▓░               ▒░█░" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "      ██  ██  ██ ██    ██ ██  ██ ██ ██    ██    ██ ██    ██ ██  ██ ██      ██" + HackerTerminalFX.RESET; System.out.println(asciiArt10);
        String asciiArt11 = HackerTerminalFX.GREEN + "         ░██▓█                    ░▒█▒" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_YELLOW + "       ██      ██  ██████  ██   ████ ██    ██    ██  ██████  ██   ████ ███████" + HackerTerminalFX.RESET; System.out.println(asciiArt11);
        String asciiArt12 = HackerTerminalFX.GREEN + "        ░▓░░▓     ▓  ░         █░ ░█░" + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "  " + HackerTerminalFX.RESET; System.out.println(asciiArt12);
        String asciiArt13 = HackerTerminalFX.GREEN + "        ░▓ ░▓▒░▒███▓▒░░▒▓░    ░█   █░        " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "       ░█▀█░░░█▀▀░█▀█░█▀█░▀█▀░█▀█░█▀▀░▀█▀░▀█▀░█▀▀░░░█▀▄░█▀█░█░█░ " + HackerTerminalFX.RESET; System.out.println(asciiArt13);
        String asciiArt14 = HackerTerminalFX.GREEN + "         ▓▒▒██▓░▓▓█▓███░ ▒    ▒▓   █▒        " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "       ░█▀█░░░█▀▀░█▀█░█░█░░█░░█▀█░▀▀█░░█░░░█░░█░░░░░█░█░█▀█░░█░░ " + HackerTerminalFX.RESET; System.out.println(asciiArt14);
        String asciiArt15 = HackerTerminalFX.GREEN + "          ▓██▒▓▓▒░░░  ░▓ ▒    ▒   ▒▓         " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "       ░▀░▀░░░▀░░░▀░▀░▀░▀░░▀░░▀░▀░▀▀▀░░▀░░▀▀▀░▀▀▀░░░▀▀░░▀░▀░░▀░░ " + HackerTerminalFX.RESET; System.out.println(asciiArt15);
        String asciiArt16 = HackerTerminalFX.GREEN + "          ▒▒▓█       ▒▒          ▓▒          " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "  " + HackerTerminalFX.RESET; System.out.println(asciiArt16);
        String asciiArt17 = HackerTerminalFX.GREEN + "          ░█▒▓░░  ░▒ ▒█░       ░█▒           " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "       ░█▀▀░█▀█░█▀▄░░░█▀▀░█▀█░█▀█░▀█▀░▀█▀░█▀█░█░░░▀█▀░█▀▀░█▄█░█ " + HackerTerminalFX.RESET; System.out.println(asciiArt17);
        String asciiArt18 = HackerTerminalFX.GREEN + "           ░▓███████████░▓▒░▒▓▒░             " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "       ░█▀▀░█░█░█▀▄░░░█░░░█▀█░█▀▀░░█░░░█░░█▀█░█░░░░█░░▀▀█░█░█░▀ " + HackerTerminalFX.RESET; System.out.println(asciiArt18);
        String asciiArt19 = HackerTerminalFX.GREEN + "            ░████████████▓▒                  " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "       ░▀░░░▀▀▀░▀░▀░░░▀▀▀░▀░▀░▀░░░▀▀▀░░▀░░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░▀░▀ " + HackerTerminalFX.RESET; System.out.println(asciiArt19);
        String asciiArt20 = HackerTerminalFX.GREEN + "             ░██▓▓▓▓█▒█▓░                    " + HackerTerminalFX.RESET + HackerTerminalFX.BRIGHT_RED + "  " + HackerTerminalFX.RESET; System.out.println(asciiArt20);
        String asciiArt21 = HackerTerminalFX.GREEN + "                 ░▒░░                        " + HackerTerminalFX.RESET; String asciiArt21A = "       DONATE ORGANS IN THE RECEPTACLE BELOW."; String asciiArt21B = " NO QUESTIONS ASKED."; System.out.print(asciiArt21); HackerTerminalFX.type(asciiArt21A, HackerTerminalFX.BRIGHT_RED, 40); /* Subtitle Delay Effect */ HackerTerminalFX.type(asciiArt21B + "\n", HackerTerminalFX.BOLD_RED, 140);
        System.out.println("\n");
        System.out.println("Hello, world! \n"); // EDIT HERE!!!!!!!!!!!!!!!!!

/* -------------------------
------- TRANSACTIONS -------
------------------------- */

        ArrayList<Transactions> transactions = new ArrayList<>(); // *** STORING DATA WITH ArrayList ***
        Scanner scanner = new Scanner(System.in); // *** SCANNER FOR USER INPUT ***
        String fileName = "transactions.csv"; // *** ACCESSING TRANSACTIONS CLASS ***

        // *** TRY-CATCH ENSURES PROGRAM DOESN'T CRASH IF UNREADABLE ***
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName)); // *** ACCESSING .CSV FILE ***

            String line; // Reads the fine line by line...
            reader.readLine(); // ...but skips the first line since it's just the column names.

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Splits the line into pieces.
                double amount = Double.parseDouble(parts[4]); // 'parts[4]' is still a String.
                // This conversion to double is REQUIRED because the 'Transactions' constructor
                // is expecting a 'double' for the amount.
                Transactions t = new Transactions(parts[0], parts[1], parts[2], parts[3], amount); // *** TRANSACTIONS OBJECT ***
                transactions.add(t); // Generates simplified, clean code. No more souts!
                // SOUT TESTING PURPOSES ONLY:
                // System.out.println(t);
            }

            // CLOSING THE FILE
            reader.close();
            // Once you close the reader, the program can't read the file anymore.
            // The Home Menu does NOT need to read the file immediately;
            // it works with ArrayList<Transaction> previously made - our stored data.
            // The Home Menu can safely be after closing the reader in order of operations.
            System.out.println("\n✅ Done reading the file!"); // EDIT HERE!!!!!!!!!!!!!!!!!!!

        } catch (IOException e) {
            System.out.println("❌ Oops! Could not read the file.");
            e.printStackTrace(); // Shows error details, if any.
        } // try

/* ----------------------
------- MAIN MENU -------
---------------------- */

        boolean running = true; // "The program is currently running." Controlling the menu.

        while (running) { // while loop engages if the program IS running, which is true (above line).

            // *** AS SOON AS running BECOMES false, THE while loop STOPS AND PROGRAM EXITS ***

            // *** MENU ***
            System.out.println("\n--- HOME SCREEN ---");
            System.out.println("[D] DEPOSIT YOUR BLOOD MONEY");
            System.out.println("[P] Make Payment");
            System.out.println("[L] Ledger");
            System.out.println("[X] Exit");
            System.out.print("Choose an option: ");

            // *** READS USER INPUT ***
            String choice = scanner.nextLine();

            // *** OPTIONS (SWITCH CASE) ***
            switch (choice.toUpperCase()) { // Without '.toUpperCase()', it would be case sensitive.
                case "D":
                    // call addDeposit() method
                    break;
                case "P":
                    // call makePayment() method
                    break;
                case "L":
                    // call showLedger() method
                    break;
                case "X":
                    running = false; // *** HOW THE while loop STOPS ***
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } // while

        scanner.close();

    } // main

} // class
