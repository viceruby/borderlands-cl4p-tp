import java.io.BufferedReader; // Reads lines from .csv file
import java.io.BufferedWriter; // Writing and appending new lines
import java.io.FileReader; // Reads lines from .csv file
import java.io.FileWriter; // Writing and appending new lines
import java.io.IOException; // Handles file read/write errors
import java.io.PrintWriter; // Writing full lines of text
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // dtf
import java.util.ArrayList; // Memory storage
import java.util.List;
import java.util.Scanner; // User input from the console
import java.time.LocalDate; // dtf
import java.time.LocalTime; // dtf
import java.util.Comparator;

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

        String asciiArt22 = HackerTerminalFX.BRIGHT_YELLOW + "                           ██" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                        ▄▄▄▄  ▄    ▄" + HackerTerminalFX.RESET; System.out.println(asciiArt22);
        String asciiArt23 = HackerTerminalFX.BRIGHT_YELLOW + "                           ██" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                       ▄▀  ▀▄ █    █" + HackerTerminalFX.RESET; System.out.println(asciiArt23);
        String asciiArt24 = HackerTerminalFX.BRIGHT_YELLOW + "                           ██" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                       █    █ █▄▄▄▄█" + HackerTerminalFX.RESET; System.out.println(asciiArt24);
        String asciiArt25 = HackerTerminalFX.BRIGHT_YELLOW + "                           ██" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                       █    █ █    █" + HackerTerminalFX.RESET; System.out.println(asciiArt25);
        String asciiArt26 = HackerTerminalFX.BRIGHT_YELLOW + "                           ██" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                        █▄▄█  █    █   █" + HackerTerminalFX.RESET; System.out.println(asciiArt26);
        String asciiArt27 = HackerTerminalFX.BRIGHT_YELLOW + "              ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                         ▀" + HackerTerminalFX.RESET; System.out.println(asciiArt27);
        String asciiArt28 = HackerTerminalFX.BRIGHT_YELLOW + "              ▒▒▒▒▒▒▒▓▒▒▓▓▓▓▓▓▓▓▒▒▓▒▒▒▒▒▒▒" + HackerTerminalFX.RESET; System.out.println(asciiArt28);
        String asciiArt29 = HackerTerminalFX.BRIGHT_YELLOW + "              ▓▒▒▒▒▒▒▒▒██▓░░░░▒██▒▒▒▒▒▒▒▒▓" + HackerTerminalFX.RESET; System.out.println(asciiArt29);
        String asciiArt30 = HackerTerminalFX.BRIGHT_YELLOW + "              █▒▒▒▒▒▒▒▓█▓░░░░░░▓█▓▒▒▒▒▒▒▒█" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                    ▄▄▄  ▄        ▄▄   ▄▄▄▄▄ ▄▄▄▄▄▄▄ ▄▄▄▄▄    ▄▄   ▄▄▄▄▄" + HackerTerminalFX.RESET; System.out.println(asciiArt30);
        String asciiArt31 = HackerTerminalFX.BRIGHT_YELLOW + "             █▓▒░     ░▒▓▒▒▒▒▒▒▓▒░      ▒▓█" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                 ▄▀   ▀ █        ██   █   ▀█   █    █   ▀█   ██   █   ▀█" + HackerTerminalFX.RESET; System.out.println(asciiArt31);
        String asciiArt32 = HackerTerminalFX.BRIGHT_YELLOW + "            █▓▓▓░     ░▒▒▓▓▓▓▓▓▒▒░     ░▒▓▓█" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                █      █       █  █  █▄▄▄█▀   █    █▄▄▄▄▀  █  █  █▄▄▄█▀" + HackerTerminalFX.RESET; System.out.println(asciiArt32);
        String asciiArt33 = HackerTerminalFX.BRIGHT_YELLOW + "            ▓▓▓▓░     ░▒▓█▒▒▒▒█▓▒░     ░▓▓▓▓" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                █      █       █▄▄█  █        █    █   ▀▄  █▄▄█  █" + HackerTerminalFX.RESET; System.out.println(asciiArt33);
        String asciiArt34 = HackerTerminalFX.BRIGHT_YELLOW + "             █▓▓▒▒▒▒▒▒▒▒▓█▒▒▒▒█▓▒▒▒▒▒▒▒▒▓▓█" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                  ▀▄▄▄▀ █▄▄▄▄▄ █    █ █        █    █    ▀ █    █ █        █      █      █" + HackerTerminalFX.RESET; System.out.println(asciiArt34);
        String asciiArt35 = HackerTerminalFX.BRIGHT_YELLOW + "             ▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓█▒▒▒▒▒▒▒▒▓▓▓▓" + HackerTerminalFX.RESET; System.out.println(asciiArt35);
        String asciiArt36 = HackerTerminalFX.BRIGHT_YELLOW + "            ▓▓▒ █▒▒▒▒▒▒▓████████▓▒▒▒▒▒▒█ ▒▓▓" + HackerTerminalFX.RESET; System.out.println(asciiArt36);
        String asciiArt37 = HackerTerminalFX.BRIGHT_YELLOW + "           ▓▓▓▓  ▒▒▒▒▒██▓▓▓▓▓▓▓▓██▒▒▒▒▒  █▓▓▓" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "        ▄▄▄▄▄    ▄      ▄                     ▀                   ▄" + HackerTerminalFX.RESET; System.out.println(asciiArt37);
        String asciiArt38 = HackerTerminalFX.BRIGHT_YELLOW + "         █▓▓▓█   ▒▒▒▒▒██▒▒▒▒▒▒▒▒██▓▒▒▒▒   █▓▓▓█" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "        █    ▄▄█▄▄    █     ▄▄▄           ▄▄▄   ▄   ▄   ▄▄▄   ▄▄█▄▄         ▄   ▄   ▄▄▄   ▄   ▄" + HackerTerminalFX.RESET; System.out.println(asciiArt38);
        String asciiArt39 = HackerTerminalFX.BRIGHT_YELLOW + "        ▓▓▓▓█    ▓▒▒▒▓███▓████▓███▓▒▒▒▓    █▓▓▓▓" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "       █      █           █   ▀            █   █   █  █   ▀    █           ▀▄ ▄▀  █▀ ▀█  █   █" + HackerTerminalFX.RESET; System.out.println(asciiArt39);
        String asciiArt40 = HackerTerminalFX.BRIGHT_YELLOW + "        █▓▓█      ▒▒▓██████████████▓▒▒      █▓▓█" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "       █      █            ▀▀▀▄            █   █   █   ▀▀▀▄    █            █▄█   █   █  █   █" + HackerTerminalFX.RESET; System.out.println(asciiArt40);
        String asciiArt41 = HackerTerminalFX.BRIGHT_YELLOW + "                  ▓▒▓██████████████▓▒▓" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "               ▄▄█▄▄    ▀▄▄         ▀▄▄▄▀            █   ▀▄▄▀█  ▀▄▄▄▀    ▀▄▄          ▀█    ▀█▄█▀  ▀▄▄▀█    █" + HackerTerminalFX.RESET; System.out.println(asciiArt41);
        String asciiArt42 = HackerTerminalFX.BRIGHT_YELLOW + "                        ████████" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                           █                                ▄▀" + HackerTerminalFX.RESET; System.out.println(asciiArt42);
        String asciiArt43 = HackerTerminalFX.BRIGHT_YELLOW + "                        ████████" + HackerTerminalFX.RESET + HackerTerminalFX.YELLOW + "                                                         ▀▀                                ▀▀" + HackerTerminalFX.RESET; System.out.println(asciiArt43);
        String asciiArt44 = HackerTerminalFX.BRIGHT_YELLOW + "                        ████████                                      " + HackerTerminalFX.RESET; System.out.print(asciiArt44); String asciiArt44A = "IT'S UNFORTUNATE YOU'RE NOT DEAD YET... OH, WELL."; HackerTerminalFX.type(asciiArt44A + "\n", HackerTerminalFX.BOLD_RED, 50);

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
                Transactions transaction = new Transactions(parts[0], parts[1], parts[2], parts[3], amount); // *** TRANSACTIONS OBJECT ***
                transactions.add(transaction); // Generates simplified, clean code. No more souts!
                // SOUT TESTING PURPOSES ONLY:
                // System.out.println(t);
            }

            // CLOSING THE FILE
            reader.close();
            // Once you close the reader, the program can't read the file anymore.
            // The Home Menu does NOT need to read the file immediately;
            // it works with ArrayList<Transaction> previously made - our stored data.
            // The Home Menu can safely be after closing the reader in order of operations.
            // System.out.println("\n✅ Done reading the file!");

        } catch (IOException e) {
            System.out.println("❌ Oops! Could not read the file.");
            e.printStackTrace(); // *** DEBUGGING ***
        } // try

/* ----------------------
------- MAIN MENU -------
---------------------- */

// *** ------- MAIN MENU CONSOLE UI ------- *** //

        System.out.println(" ");
        System.out.println(" ");
        String asciiArt45 = HackerTerminalFX.CYAN + "        ░█▀▀░█▀█░█▀▄░░░█▀█░█▀▀░░░▀█▀░█░█░█▀▀░░░█░█░█▀█░█▀▄░█░░░█▀▄░░░░" + HackerTerminalFX.RESET; System.out.println(asciiArt45);
        String asciiArt46 = HackerTerminalFX.CYAN + "        ░█▀▀░█░█░█░█░░░█░█░█▀▀░░░░█░░█▀█░█▀▀░░░█▄█░█░█░█▀▄░█░░░█░█░░░░" + HackerTerminalFX.RESET; System.out.println(asciiArt46);
        String asciiArt47 = HackerTerminalFX.CYAN + "        ░▀▀▀░▀░▀░▀▀░░░░▀▀▀░▀░░░░░░▀░░▀░▀░▀▀▀░░░▀░▀░▀▀▀░▀░▀░▀▀▀░▀▀░░▄▀░" + HackerTerminalFX.RESET; System.out.println(asciiArt47);
        String asciiArt48 = HackerTerminalFX.CYAN + "        ░░░░░█▀▄░█░░░█▀█░░░█▀▄░█░░░█▀█░░░█▀▄░█░░░█▀█░░░" + HackerTerminalFX.RESET; System.out.println(asciiArt48);
        String asciiArt49 = HackerTerminalFX.CYAN + "        ░░░░░█▀▄░█░░░█▀█░░░█▀▄░█░░░█▀█░░░█▀▄░█░░░█▀█░░░" + HackerTerminalFX.RESET; System.out.println(asciiArt49);
        String asciiArt50 = HackerTerminalFX.CYAN + "        ░░░░░▀▀░░▀▀▀░▀░▀░░░▀▀░░▀▀▀░▀░▀░░░▀▀░░▀▀▀░▀░▀░▀░" + HackerTerminalFX.RESET; System.out.println(asciiArt50);
        System.out.println(" ");
        System.out.println("          I'VE HEARD IT ALL BEFORE.");
        System.out.println("          ALL I KNOW IS,");
        System.out.println(" ");
        String asciiArt51 = HackerTerminalFX.BRIGHT_GREEN + "        ░░░█░█░█▀█░█▀▄░░░▀█▀░█▀▀░░░█▀▀░█▀▄░█▀▀░█▀█░▀█▀" + HackerTerminalFX.RESET; System.out.println(asciiArt51);
        String asciiArt52 = HackerTerminalFX.BRIGHT_GREEN + "        ░░░█▄█░█▀█░█▀▄░░░░█░░▀▀█░░░█░█░█▀▄░█▀▀░█▀█░░█░" + HackerTerminalFX.RESET; System.out.println(asciiArt52);
        String asciiArt53 = HackerTerminalFX.BRIGHT_GREEN + "        ░░░▀░▀░▀░▀░▀░▀░░░▀▀▀░▀▀▀░░░▀▀▀░▀░▀░▀▀▀░▀░▀░░▀░" + HackerTerminalFX.RESET; System.out.println(asciiArt53);
        String asciiArt54 = HackerTerminalFX.BRIGHT_GREEN + "        ░█▀▀░█▀█░█▀▄░░░█▀▄░█░█░█▀▀░▀█▀░█▀█░█▀▀░█▀▀░█▀▀░░░" + HackerTerminalFX.RESET; System.out.println(asciiArt54);
        String asciiArt55 = HackerTerminalFX.BRIGHT_GREEN + "        ░█▀▀░█░█░█▀▄░░░█▀▄░█░█░▀▀█░░█░░█░█░█▀▀░▀▀█░▀▀█░░░" + HackerTerminalFX.RESET; System.out.println(asciiArt55);
        String asciiArt56 = HackerTerminalFX.BRIGHT_GREEN + "        ░▀░░░▀▀▀░▀░▀░░░▀▀░░▀▀▀░▀▀▀░▀▀▀░▀░▀░▀▀▀░▀▀▀░▀▀▀░▀░" + HackerTerminalFX.RESET; System.out.println(asciiArt56);

        boolean running = true; // "The program is currently running." Controlling the menu.

        while (running) { // while loop engages if the program IS running, which is true (above line).

            // *** AS SOON AS running BECOMES false, THE while loop STOPS AND PROGRAM EXITS ***

            // *** MENU ***

            System.out.println(" ");
            String asciiArt57 = HackerTerminalFX.RED + "╔╦╗╔═╗╔╦╗╔═╗╦  ╦ ╦ ╦  ╔╗╔╔═╗╔╦╗  ╔╗ ╦  ╔═╗╔═╗╔╦╗  ╔╦╗╔═╗╔╗╔╔═╗╦ ╦" + HackerTerminalFX.RESET; System.out.println(asciiArt57);
            String asciiArt58 = HackerTerminalFX.RED + " ║ ║ ║ ║ ╠═╣║  ║ ╚╦╝  ║║║║ ║ ║   ╠╩╗║  ║ ║║ ║ ║║  ║║║║ ║║║║║╣ ╚╦╝" + HackerTerminalFX.RESET; System.out.println(asciiArt58);
            String asciiArt59 = HackerTerminalFX.RED + " ╩ ╚═╝ ╩ ╩ ╩╩═╝╩═╝╩   ╝╚╝╚═╝ ╩   ╚═╝╩═╝╚═╝╚═╝═╩╝  ╩ ╩╚═╝╝╚╝╚═╝ ╩" + HackerTerminalFX.RESET; System.out.println(asciiArt59);
            System.out.println(" ");
            System.out.println("[D] DEPOSIT YOUR BLOOD MONEY");
            System.out.println("[P] PAYMENT... IN BLOOD MONEY");
            System.out.println("[L] CHECK OUT YOUR LEDGER... OF BLOOD MONEY");
            System.out.println("[X] EXIT. YOU DEFINITELY DID NOT KILL INNOCENTS, AND YOU DEFINITELY DID NOT PROFIT." + "\n");
            System.out.print("HOW CAN I HELP YOU, CLAPTRAP? ");

            // *** READS USER INPUT ***
            String choice = scanner.nextLine();

// *** ------- MAIN MENU OPTIONS (SWITCH CASES) ------- *** //

            switch (choice.toUpperCase()) { // Without '.toUpperCase()', it would be case sensitive.

// *** ------- MAIN MENU DEPOSIT ------- *** //

                case "D": // *** DEPOSIT ***
                    {System.out.print("COMRADE! A DEPOSIT! TELL ME WHY YOU'RE MAKING ME RICH: ");
                    String description = scanner.nextLine();

                    System.out.print("TELL ME WHO PLEASE: ");
                    String vendor = scanner.nextLine();

                    System.out.print("THE AMOUNT I'M DEFINITELY NOT STEALING FROM YOU: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now().withNano(0);

                    Transactions transactionsMainMenu = new Transactions(
                            date.toString(),
                            time.toString(),
                            description,
                            vendor,
                            amount
                    );

                    transactions.add(transactionsMainMenu);
                    System.out.println("\nDEPOSITED BLOOD MONEY SUCCESSFULLY. I PERSONALLY GUARANTEE ITS SAFETY, BUT DO READ THE FINE PRINT. NO REFUNDS.\n");
                    break;}

// *** ------- MAIN MENU PAYMENTS ------- *** //

                case "P": // *** PAYMENT ***
                    {System.out.print("I LOVE CAPITALISM! WHAT DID YOU BUY? ");
                    String paymentDescription = scanner.nextLine();

                    System.out.print("WHO DID YOU BUY FROM? ");
                    String paymentVendor = scanner.nextLine();

                    System.out.print("TELL ME THIS POSITIVE NUMBER. ");
                    double paymentAmount;
                    try {
                        paymentAmount = Double.parseDouble(scanner.nextLine().trim()); // PROVIDE NOTES HERE
                    } catch (NumberFormatException nfe) {
                        System.out.println("TOO MANY SYLLABLES! TRY AGAIN! APOLOGIZE!");
                        break; // *** EXITING AND RETURNING TO MENU ***
                    }

                    paymentAmount = -Math.abs(paymentAmount); // *** AMOUNT MUST BE NEGATIVE ***

                    // *** DATE AND TIME FORMATTING ***
                    String dateFormat = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE); // YYYY-MM-DD
                    String timeFormat = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")); // HH:mm:ss

                    // *** CREATING AND STORING THE TRANSACTION ***
                    Transactions payment = new Transactions(dateFormat, timeFormat, paymentDescription, paymentVendor, paymentAmount);
                    transactions.add(payment);

                    // *** APPENDING TO THE .CSV FILE ***
                    // Using try/catch so it doesn't break the program.

                    try (FileWriter fw = new FileWriter("transactions.csv", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw)) {

                        // *** FORMAT FOR DOLLAR VALUE ***
                        String dollarAmount = String.format("%.2f", paymentAmount);

                        // *** BUILD FOR MATCHING .CSV FILE FORMAT ***
                        String csvFileFormat = dateFormat + "|" + timeFormat + "|" + paymentDescription + "|" + paymentVendor + "|" + dollarAmount;

                        pw.println(csvFileFormat); // *** APPEND THE NEW TRANSACTION ***
                    } catch (IOException ioe) {
                        System.out.println("Error: unable to write transaction.");
                        ioe.printStackTrace();
                    }

                    System.out.println("KEEP PANDORA SAFE, SO I CAN KEEP MAKING IT DANGEROUS. CAPITALISM AGAINST THE GREATER GOOD RECEIVED: " + payment); // *** CONFIRMING ACTION ***
                    break;}

/* -------------------
------- LEDGER -------
------------------- */

                case "L": // *** LEDGER ***

                { boolean ledgerRunning = true;

// *** ------- LEDGER MENU CONSOLE UI ------- *** //

                    System.out.println(" ");
                    String asciiArt60 = "   MY BUSINESS HAS ONE SIMPLE RULE:"; System.out.println(asciiArt60);
                    System.out.println(" ");
                    String asciiArt61 = HackerTerminalFX.RED + "░█▀█░█▀█░░░█▀▄░█▀▀░█▀▀░█░█░█▀█░█▀▄░█▀▀" + HackerTerminalFX.RESET; System.out.println(asciiArt61);
                    String asciiArt62 = HackerTerminalFX.RED + "░█░█░█░█░░░█▀▄░█▀▀░█▀▀░█░█░█░█░█░█░▀▀█" + HackerTerminalFX.RESET; System.out.println(asciiArt62);
                    String asciiArt63 = HackerTerminalFX.RED + "░▀░▀░▀▀▀░░░▀░▀░▀▀▀░▀░░░▀▀▀░▀░▀░▀▀░░▀▀▀" + HackerTerminalFX.RESET; System.out.println(asciiArt63);
                    System.out.println(" ");

                    while (ledgerRunning) {
                        System.out.println("\nLEDGER");
                        System.out.println("A) ALL BLOOD MONEY");
                        System.out.println("D) DEPOSITS");
                        System.out.println("P) PAYMENTS");
                        System.out.println("R) REPORTS");
                        System.out.println("X) RETURN TO MAIN MENU");
                        System.out.print("\nWHEEL OF MURDER FORTUNE! CHOOSE A LETTER: ");

                        String ledgerChoice = scanner.nextLine();

// *** ------- LEDGER MENU OPTIONS (SWITCH CASES) ------- *** //

// *** ------- LEDGER TRANSACTIONS ------- *** //

                        // *** DESCENDING BY DATE ***
                        transactions.sort((t1, t2) -> {
                            LocalDate date1 = LocalDate.parse(t1.getDate());
                            LocalDate date2 = LocalDate.parse(t2.getDate());
                            int dateCompare = date2.compareTo(date1);
                            if (dateCompare != 0) return dateCompare;

                            // *** DESCENDING BY TIME ***
                            LocalTime time1 = LocalTime.parse(t1.getTime());
                            LocalTime time2 = LocalTime.parse(t2.getTime());
                            return time2.compareTo(time1);
                        });

                        switch (ledgerChoice.toUpperCase()) {
                            case "A":
                                {System.out.println("\nTHE THINGS YOU CAN AFFORD BY (THEORETICALLY) MURDERING INNOCENTS\n");

                                // CLEAN TABLE DISPLAY
                                System.out.printf("%-15s %-15s %-30s %-10s %15s%n", // %-LEFT ALIGN + SPACES + %RIGHT ALIGN
                                        "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");

                                transactions.stream()
                                        .sorted((t1, t2) -> {
                                                LocalDateTime dt1 = LocalDateTime.parse(t1.getDate() + "T" + t1.getTime());
                                                LocalDateTime dt2 = LocalDateTime.parse(t2.getDate() + "T" + t2.getTime());
                                                return dt2.compareTo(dt1); // DESCENDING: newest first
                                        })
                                        .forEach(t -> {
                                            // TRUNCATING TIME STAMPS SO IT DOESN'T BLEED
                                            String timeLedgerAll = t.getTime();
                                            if (timeLedgerAll.length() > 15) timeLedgerAll = timeLedgerAll.substring(0, 12);

                                            // TRUNCATING DESCRIPTION SO IT DOESN'T BLEED
                                            String descripLedgerAll = t.getDescription();
                                            if (descripLedgerAll.length() > 30) descripLedgerAll = descripLedgerAll.substring(0, 27) + "...";

                                            System.out.printf("%-15s %-15s %-30s %-10s %15.2f%n",
                                                    t.getDate(), timeLedgerAll, descripLedgerAll, t.getVendor(), t.getAmount());
                                        });

                                break;}

// *** ------- LEDGER DEPOSITS ------- *** //

                            case "D":
                                {System.out.println("\nNO THEFT HERE INVOLVED\n");

                                // CLEAN TABLE DISPLAY
                                System.out.printf("%-15s %-15s %-30s %-10s %15s%n", // %-LEFT ALIGN + SPACES + %RIGHT ALIGN
                                        "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");

                                transactions.stream()
                                        .filter(t -> t.getAmount() > 0)
                                        .sorted((t1, t2) -> {
                                            LocalDateTime dt1 = LocalDateTime.parse(t1.getDate() + "T" + t1.getTime());
                                            LocalDateTime dt2 = LocalDateTime.parse(t2.getDate() + "T" + t2.getTime());
                                            return dt2.compareTo(dt1);
                                        })
                                        .forEach(t -> {
                                        // TRUNCATING TIME STAMPS SO IT DOESN'T BLEED
                                        String timeLedgerDepo = t.getTime();
                                        if (timeLedgerDepo.length() > 15)
                                            timeLedgerDepo = timeLedgerDepo.substring(0, 12);

                                        // TRUNCATING DESCRIPTION SO IT DOESN'T BLEED
                                        String descripLedgerDepo = t.getDescription();
                                        if (descripLedgerDepo.length() > 30)
                                            descripLedgerDepo = descripLedgerDepo.substring(0, 27) + "...";

                                        System.out.printf("%-15s %-15s %-30s %-10s %15.2f%n",
                                                t.getDate(), timeLedgerDepo, descripLedgerDepo, t.getVendor(), t.getAmount());
                                    });

                                break;}

// *** ------- LEDGER PAYMENTS ------- *** //

                            case "P":
                                {System.out.println("\nI LOVE CAPITALISM\n");

                                // CLEAN TABLE DISPLAY
                                System.out.printf("%-15s %-15s %-30s %-10s %15s%n", // %-LEFT ALIGN + SPACES + %RIGHT ALIGN
                                        "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");

                                transactions.stream()
                                        .filter(t -> t.getAmount() < 0)
                                        .sorted((t1, t2) -> {
                                            LocalDateTime dt1 = LocalDateTime.parse(t1.getDate() + "T" + t1.getTime());
                                            LocalDateTime dt2 = LocalDateTime.parse(t2.getDate() + "T" + t2.getTime());
                                            return dt2.compareTo(dt1);
                                        })
                                        .forEach(t -> {
                                            // TRUNCATING TIME STAMPS SO IT DOESN'T BLEED
                                            String timeLedgerPayments = t.getTime();
                                            if (timeLedgerPayments.length() > 15)
                                                timeLedgerPayments = timeLedgerPayments.substring(0, 12);

                                            // TRUNCATING DESCRIPTION SO IT DOESN'T BLEED
                                            String descripLedgerPayments = t.getDescription();
                                            if (descripLedgerPayments.length() > 30)
                                                descripLedgerPayments = descripLedgerPayments.substring(0, 27) + "...";

                                        System.out.printf("%-15s %-15s %-30s %-10s %15.2f%n",
                                                t.getDate(), timeLedgerPayments, descripLedgerPayments, t.getVendor(), t.getAmount());
                                    });

                                break;}

/* ---------------------------
------- LEDGER REPORTS -------
--------------------------- */

                            case "R": // *** LEDGER REPORTS ***
                                {//System.out.println("\nREPORTS DIALOGUE HERE");

                                    boolean reportsRunning = true;

 // *** ------- LEDGER REPORTS MENU CONSOLE UI ------- *** //

                                    while (reportsRunning) {
                                        System.out.println("\n--- REPORTS MENU ---");
                                        System.out.println("1) MONTH TO DATE");
                                        System.out.println("2) PREVIOUS MONTH");
                                        System.out.println("3) YEAR TO DATE");
                                        System.out.println("4) PREVIOUS YEAR");
                                        System.out.println("5) SEARCH BY VENDOR");
                                        System.out.println("X) BACK TO LEDGER MENU");
                                        System.out.print("\nYOU KNOW LETTERS, YES? ");

                                        String reportsOptions = scanner.nextLine();

// *** ------- LEDGER REPORTS MENU OPTIONS (SWITCH CASES) ------- *** //

// *** ------- REPORTS BY MONTH TO DATE ------- *** //

                                        switch (reportsOptions.toUpperCase()) {
                                            case "1": {
                                                System.out.println("\nMONTH TO DATE REPORTS\n");

                                                LocalDate today = LocalDate.now(); // *** SYSTEM CLOCK ***
                                                int currentMonth = today.getMonthValue();
                                                int currentYear = today.getYear();

                                                printTransactionHeader();

                                                transactions.stream()
                                                        .filter(t -> {
                                                            LocalDate date = LocalDate.parse(t.getDate());
                                                            return date.getMonthValue() == currentMonth && date.getYear() == currentYear;
                                                        })
                                                        .sorted((t1, t2) -> LocalDateTime.parse(t2.getDate() + "T" + t2.getTime())
                                                                .compareTo(LocalDateTime.parse(t1.getDate() + "T" + t1.getTime())))
                                                        .forEach(t -> printTransactionRow(t));
                                                break;}

// *** ------- REPORTS BY PREVIOUS MONTH ------- *** //

                                            case "2":{
                                                System.out.println("\nPREVIOUS MONTH REPORTS\n");

                                                LocalDate today = LocalDate.now();
                                                LocalDate lastMonth = today.minusMonths(1); // *** REDUCES MONTH BY 1 ***
                                                int previousMonth = lastMonth.getMonthValue();
                                                int previousYear = lastMonth.getYear();

                                                printTransactionHeader();

                                                transactions.stream()
                                                        .filter(t -> {
                                                            LocalDate date = LocalDate.parse(t.getDate());
                                                            return date.getMonthValue() == previousMonth && date.getYear() == previousYear;
                                                        })
                                                        .sorted((t1, t2) -> LocalDateTime.parse(t2.getDate() + "T" + t2.getTime())
                                                                .compareTo(LocalDateTime.parse(t1.getDate() + "T" + t1.getTime())))
                                                        .forEach(t -> printTransactionRow(t));

                                                break;}

// *** ------- REPORTS BY YEAR TO DATE ------- *** //

                                            case "3": {
                                                System.out.println("\nYEAR TO DATE REPORTS\n");

                                                LocalDate today = LocalDate.now();
                                                LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);

                                                printTransactionHeader();

                                                transactions.stream()
                                                        .filter(t -> {
                                                            LocalDate date = LocalDate.parse(t.getDate());
                                                            return !date.isBefore(startOfYear) && !date.isAfter(today);
                                                        })
                                                        .sorted((t1, t2) -> LocalDateTime.parse(t2.getDate() + "T" + t2.getTime())
                                                                .compareTo(LocalDateTime.parse(t1.getDate() + "T" + t1.getTime())))
                                                        .forEach(t -> printTransactionRow(t));
                                                break;}

// *** ------- REPORTS BY PREVIOUS YEAR ------- *** //

                                            case "4":{
                                                System.out.println("\nPREVIOUS YEAR REPORT\n");

                                                LocalDate today = LocalDate.now();
                                                LocalDate startOfPreviousYear = LocalDate.of(today.getYear() - 1, 1, 1); // *** DEFINES START OF YEAR AS JAN 1 ***
                                                LocalDate endOfPreviousYear = LocalDate.of(today.getYear() - 1, 12, 31);// *** DEFINES END OF YEAR AS DEC 31 ***

                                                printTransactionHeader();

                                                transactions.stream()
                                                        .filter(t -> {
                                                            LocalDate date = LocalDate.parse(t.getDate());
                                                            return !date.isBefore(startOfPreviousYear) && !date.isAfter(endOfPreviousYear);
                                                        })
                                                        .sorted((t1, t2) -> LocalDateTime.parse(t2.getDate() + "T" + t2.getTime())
                                                                .compareTo(LocalDateTime.parse(t1.getDate() + "T" + t1.getTime())))
                                                        .forEach(t -> printTransactionRow(t));

                                                break;}

// *** ------- VENDOR SEARCH ------- *** //

                                            case "5":{
                                                System.out.print("\nTELL ME THE VENDOR: \n");
                                                String searchVendor = scanner.nextLine().toLowerCase();

                                                printTransactionHeader();

                                                transactions.stream()
                                                        .filter(t -> t.getVendor().toLowerCase().contains(searchVendor))
                                                        .sorted((t1, t2) -> LocalDateTime.parse(t2.getDate() + "T" + t2.getTime())
                                                                .compareTo(LocalDateTime.parse(t1.getDate() + "T" + t1.getTime())))
                                                        .forEach(t -> printTransactionRow(t));

                                                break;}

// *** ------- LEDGER REPORTS MENU EXIT ------- *** //

                                            case "X":{
                                                reportsRunning = false;
                                                break;}

                                            default:
                                                System.out.println("/nInvalid option. Try again!");
                                                break;
                                        }
                                    }

                                break;}

// *** ------- LEDGER EXIT ------- *** //

                            case "X":
                                {ledgerRunning = false; // *** EXITS LEDGER MENU ***
                                break;}

                            default:
                                System.out.println("Invalid option. Try again!");
                                break;
                        }
                    }
                    break;} // *** LEDGER LOOP STOPS ***

// *** ------- MAIN MENU EXIT ------- *** //

                case "X":
                    {running = false; // *** MAIN MENU LOOP STOPS ***
                    System.out.println("NOBODY DOES MONEY BETTER THAN MARCUS MUNITIONS. REMEMBER: NO REFUNDS!");
                    break;}

                default:
                    {System.out.println("Invalid option. Try again.");}
            } // *** MAIN MENU LOOP STOPS ***
        } // main while

// *** ------- CLOSING THE SCANNER ------- *** //

        scanner.close();

    } // main method

    private static void printTransactionHeader() {
        System.out.printf("%-15s %-15s %-30s %-10s %15s%n",
                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");
    }

    private static void printTransactionRow(Transactions t) {
        String description = t.getDescription();
        if (description.length() > 30) description = description.substring(0, 27) + "...";

        System.out.printf("%-15s %-15s %-30s %-10s %15.2f%n",
                t.getDate(),
                t.getTime(),
                description,
                t.getVendor(),
                t.getAmount());
    }

} // class
