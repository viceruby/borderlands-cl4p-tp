import java.io.BufferedReader; // Reads lines from .csv file
import java.io.BufferedWriter; // Writing and appending new lines
import java.io.FileReader; // Reads lines from .csv file
import java.io.FileWriter; // Writing and appending new lines
import java.io.IOException; // Handles file read/write errors
import java.io.PrintWriter; // Writing full lines of text
import java.time.format.DateTimeFormatter; // dtf
import java.util.ArrayList; // Memory storage
import java.util.Scanner; // User input from the console
import java.time.LocalDate; // dtf
import java.time.LocalTime; // dtf

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
            System.out.println("\n✅ Done reading the file!"); // EDIT HERE!!!!!!!!!!!!!!!!!!!

        } catch (IOException e) {
            System.out.println("❌ Oops! Could not read the file.");
            e.printStackTrace(); // Shows error details, if any.
        } // try

/* ----------------------
------- MAIN MENU -------
---------------------- */

// *** ------- MAIN MENU CONSOLE UI ------- *** //

        boolean running = true; // "The program is currently running." Controlling the menu.

        while (running) { // while loop engages if the program IS running, which is true (above line).

            // *** AS SOON AS running BECOMES false, THE while loop STOPS AND PROGRAM EXITS ***

            // *** MENU ***
            System.out.println("\n--- HOME SCREEN ---");
            System.out.println("[D] DEPOSIT YOUR BLOOD MONEY");
            System.out.println("[P] Make Payment");
            System.out.println("[L] Ledger");
            System.out.println("[X] Exit" + "\n");
            System.out.print("Choose an option: ");

            // *** READS USER INPUT ***
            String choice = scanner.nextLine();

// *** ------- MAIN MENU OPTIONS (SWITCH CASES) ------- *** //

            switch (choice.toUpperCase()) { // Without '.toUpperCase()', it would be case sensitive.

// *** ------- MAIN MENU DEPOSIT ------- *** //

                case "D": // *** DEPOSIT ***
                    {System.out.print("Enter deposit description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter vendor: ");
                    String vendor = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();

                    Transactions transactionsMainMenu = new Transactions(
                            date.toString(),
                            time.toString(),
                            description,
                            vendor,
                            amount
                    );

                    transactions.add(transactionsMainMenu);
                    System.out.println("\nDEPOSITED BLOOD MONEY SUCCESSFULLY.\n");
                    break;}

// *** ------- MAIN MENU PAYMENTS ------- *** //

                case "P": // *** PAYMENT ***
                    {System.out.print("Enter payment description: ");
                    String paymentDescription = scanner.nextLine();

                    System.out.print("Enter vendor: ");
                    String paymentVendor = scanner.nextLine();

                    System.out.print("Enter amount (positive number): ");
                    double paymentAmount;
                    try {
                        paymentAmount = Double.parseDouble(scanner.nextLine().trim()); // PROVIDE NOTES HERE
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid number format. Payment cancelled.");
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

                    System.out.println("PAYMENT RECEIVED: " + payment); // *** CONFIRMING ACTION ***
                    break;}

/* -------------------
------- LEDGER -------
------------------- */

                case "L": // *** LEDGER ***

                { boolean ledgerRunning = true;

// *** ------- LEDGER MENU CONSOLE UI ------- *** //

                    while (ledgerRunning) {
                        System.out.println("\nLEDHER");
                        System.out.println("A) All Transactions");
                        System.out.println("D) Deposits");
                        System.out.println("P) Payments");
                        System.out.println("R) Reports");
                        System.out.println("X) Return to Main Menu");
                        System.out.print("\nINSERT HERE: ");

                        String ledgerChoice = scanner.nextLine();

// *** ------- LEDGER MENU OPTIONS (SWITCH CASES) ------- *** //

// *** ------- LEDGER TRANSACTIONS ------- *** //

                        switch (ledgerChoice.toUpperCase()) {
                            case "A":
                                {System.out.println("\nTRANSACTIONS DIALGOUE HERE\n");

                                // CLEAN TABLE DISPLAY
                                System.out.printf("%-15s %-15s %-30s %-10s %15s%n", // %-LEFT ALIGN + SPACES + %RIGHT ALIGN
                                        "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");

                                // ITERATION: NEWEST FIRST (LAST ADDED IS LISTED FIRST)
                                for (int i = transactions.size() - 1; i >= 0; i--) {
                                    Transactions transactionsLedger = transactions.get(i);

                                    // TRUNCATING TIME STAMPS SO IT DOESN'T BLEED
                                    String timeLedgerAll = transactionsLedger.getTime();
                                    if (timeLedgerAll.length() > 15) timeLedgerAll = timeLedgerAll.substring(0, 12);

                                    // TRUNCATING DESCRIPTION SO IT DOESN'T BLEED
                                    String descripLedgerAll = transactionsLedger.getDescription();
                                    if (descripLedgerAll.length() > 30) descripLedgerAll = descripLedgerAll.substring(0, 27) + "...";

                                    System.out.printf("%-15s %-15s %-30s %-10s %15s%n",
                                        transactionsLedger.getDate(),
                                        timeLedgerAll, // Not using a getter/setter because we created a new String to truncate length
                                        descripLedgerAll, // Not using a getter/setter because we created a new String to truncate length
                                        transactionsLedger.getVendor(),
                                        transactionsLedger.getAmount()
                                    );

                                }

                                break;}

// *** ------- LEDGER DEPOSITS ------- *** //

                            case "D":
                                {System.out.println("\nDEPOSITS DIALGOUE HERE\n");

                                // CLEAN TABLE DISPLAY
                                System.out.printf("%-15s %-15s %-30s %-10s %15s%n", // %-LEFT ALIGN + SPACES + %RIGHT ALIGN
                                        "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");

                                // ITERATION: NEWEST FIRST (LAST ADDED IS LISTED FIRST)
                                for (int i = transactions.size() - 1; i >= 0; i--) {
                                    Transactions transactionsLedger = transactions.get(i);
                                    if (transactionsLedger.getAmount() > 0) { // DEPOSIT = > POSITIVE!

                                        // TRUNCATING TIME STAMPS SO IT DOESN'T BLEED
                                        String timeLedgerDepo = transactionsLedger.getTime();
                                        if (timeLedgerDepo.length() > 15)
                                            timeLedgerDepo = timeLedgerDepo.substring(0, 12);

                                        // TRUNCATING DESCRIPTION SO IT DOESN'T BLEED
                                        String descripLedgerDepo = transactionsLedger.getDescription();
                                        if (descripLedgerDepo.length() > 30)
                                            descripLedgerDepo = descripLedgerDepo.substring(0, 27) + "...";

                                        System.out.printf("%-15s %-15s %-30s %-10s %15.2f%n", // %15.2f%n= RIGHT ALIGN FLOAT/DOUBLE WITH 2 DECIMAL PLACES + NEW LINE
                                                transactionsLedger.getDate(),
                                                timeLedgerDepo, // Not using a getter/setter because we created a new String to truncate length
                                                descripLedgerDepo, // Not using a getter/setter because we created a new String to truncate length
                                                transactionsLedger.getVendor(),
                                                transactionsLedger.getAmount());
                                    }

                                }

                                break;}

// *** ------- LEDGER PAYMENTS ------- *** //

                            case "P":
                                {System.out.println("\nPAYMENTS DIALGOUE HERE\n");

                                // CLEAN TABLE DISPLAY
                                System.out.printf("%-15s %-15s %-30s %-10s %15s%n", // %-LEFT ALIGN + SPACES + %RIGHT ALIGN
                                        "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT\n");

                                // ITERATION: NEWEST FIRST (LAST ADDED IS LISTED FIRST)
                                for (int i = transactions.size() - 1; i >= 0; i--) {
                                    Transactions transactionsLedger = transactions.get(i);
                                    if (transactionsLedger.getAmount() < 0) { // PAYMENTS = < NEGATIVE!

                                        // TRUNCATING TIME STAMPS SO IT DOESN'T BLEED
                                        String timeLedgerPayments = transactionsLedger.getTime();
                                        if (timeLedgerPayments.length() > 15)
                                            timeLedgerPayments = timeLedgerPayments.substring(0, 12);

                                        // TRUNCATING DESCRIPTION SO IT DOESN'T BLEED
                                        String descripLedgerPayments = transactionsLedger.getDescription();
                                        if (descripLedgerPayments.length() > 30)
                                            descripLedgerPayments = descripLedgerPayments.substring(0, 27) + "...";

                                        System.out.printf("%-15s %-15s %-30s %-10s %15.2f%n", // %15.2f%n= RIGHT ALIGN FLOAT/DOUBLE WITH 2 DECIMAL PLACES + NEW LINE
                                                transactionsLedger.getDate(),
                                                timeLedgerPayments, // Not using a getter/setter because we created a new String to truncate length
                                                descripLedgerPayments, // Not using a getter/setter because we created a new String to truncate length
                                                transactionsLedger.getVendor(),
                                                transactionsLedger.getAmount());
                                    }

                                }

                                break;}

// *** ------- LEDGER REPORTS ------- *** //

                            case "R":
                                {System.out.println("REPORTS DIALOGUE HERE");
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
                    System.out.println("Goodbye!");
                    break;}

                default:
                    {System.out.println("Invalid option. Try again.");}
            } // *** MAIN MENU LOOP STOPS ***
        } // main while

// *** ------- CLOSING THE SCANNER ------- *** //

        scanner.close();

    } // main method

} // class
