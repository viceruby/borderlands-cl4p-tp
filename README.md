# borderlands-cl4p-tp
CAPSTONE 1: Accounting Ledger Application (Borderlands Themed)

💻 Hacker Ledger FX

A stylish console ledger app built in Java with a hacker-terminal aesthetic. Tracks your transactions in real time and displays ASCII art, colorful text, and typing effects for a futuristic terminal experience.

Features

🟢 Transaction Tracking:
Create and view transactions with date, time, description, vendor, and amount.

🎨 Colorful Console Output:
ANSI-colored text and backgrounds, including bold and bright effects.

⌨️ Hacker Terminal Typing Effect:
Type out messages, transactions, and ASCII art letter-by-letter for dramatic flair.

🖼️ ASCII Art Branding:
Multiple preloaded logos and titles for a sleek terminal aesthetic.

Sample Transactions
Date	Time	Description	Vendor	Amount
2023-04-15	10:13:25	Ergonomic Keyboard	Amazon	-$89.50
2023-04-15	11:15:00	Invoice 1001 Paid	Joe	$1500.00
2024-09-28	20:00:00	Bubble Tea	Vice	-$10.00
2025-10-20	00:00:01	Birthday Gift	Vice	$666.00

💡 Tip: Screenshots of your console with green hacker-style text make this README pop!

Screenshots

Main Terminal Screen:
Insert screenshot of terminal launching with your ASCII art logo here.

Transaction Display:
Insert screenshot showing a list of transactions in colorful console output.

Typing Effect Demo:
Insert GIF or screenshot of the typing effect in action.

Usage
// Example usage
HackerTerminalFX.type("Welcome to Hacker Ledger FX!\n", HackerTerminalFX.GREEN, 10);

// Print transactions
Transactions t1 = new Transactions("2023-04-15", "10:13:25", "Keyboard", "Amazon", -89.50);
System.out.println(t1);

Credits

ASCII Art & Terminal Styling: Inspired by CL4PTP hacker aesthetic

Developed by: Chelsea Ruiz
