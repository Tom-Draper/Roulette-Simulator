# Roulette-Simulator

This fairly simple project has a purpose to introduce myself to GitHub. I will be using the GitHub Desktop GUI for this project and will eventually aim to learning Git on command line. The program will aim to highlight the bias of the roulette wheel when calculating large amounts of spins.

Project Aims:
Develop an understanding of how GitHub works.
View and quantify the bias of the roulette table.
Maintain and expand my knowledge of Java.
Work with and calculate statistics of the data generated.

What I Learned:
Creating repositories using GitHub Desktop.
Pushing to and pulling from a GitHub repository using GitHub Desktop.
Creating branches using GitHub Desktop.
Suitable ways to name a branch.

-------------------------------------------------------

How to Use

On start up the program will ask you to enter a bank account value. This is the only time you can enter this value. You can reset the bank back to the originial value you entered, but cannot modify.

After entering a bank value, you can then enter a single spin command that controls your chip size, board placement and then optional flags with their corresponding value can be entered. Each value must be separated by a single space.

The format of a spin command is as follows:

[chip] [placement] ([flag] ([flagValue]) [flag] ([flagValue])...)

Examples:
0.5 b -d -s 50   =   50p on black, double wager after each loss, spin 50 times.
5 3rd12 -s 100 -l 5000   =   £5 on the 3rd set of 12 and spin 100 times, repeat this command 5000 times.

After entering a bank value, the available chips will be displayed. They include 0.5 to 100 in value.

Available placements:

Black - b, B, black, Black
Red - r, R, red, Red
Even - e, E, even, Even
Odd - o, O, odd, Odd
First Twelve - 1st12
Second Twelve - 2nd12
Third Twelve - 3rd12
Column One - c1, col1, column1
Column Two - c2, col2, column2
Column Three -c3, col3, column3
One to Eighteen - 1to18
Nineteen to Thirty Six - 19to36

After each individual spin the result of that spin will be displayed. At the end a set of spins from a spin command, statistics for that set of spins will be displayed.

If during the spins of spin command, you attempt to place a chip that is greater than the amount in your bank, the program will tell you you are out of money and end the command, even if you had more spins left to complete.

Available Flags:

Spin flag - allows for repeated spins of the same command. The spin flag requires an integer value to follow stating the number of spins you want to take.
-s [numberOfSpins]

Double strategy flag - if you lose a spin, you repeat your placement and double your chip value. Entering the flag enables this strategy for all spins, or entering a decimal flag value after determines the total loss from consecutive losses you will take before the strategy resets back to your original chip value and continuing the double strategy from there. This strategy only works with multiple spins using the spin flag.
-d ([maxLoss])

Simulations flag - to repeat the entire command, including spins, enter the simulation flag, followed by the number of simulations required. This is good for building up spins for accurate statistics and finding what the average result of that particular spin command would be.
-l [numberOfSimulations]

Extra Commands:

To exit the program enter "exit" instead of a command.

To display spin statistics so far, enter "statistics" instead of a regular spin command.

To reset the spin statistics, enter "reset" rather than a regular spin command.

If help is needed, you can enter "help" instead of a regular spin command to display example spin commands and possible placements.

The command "flags" displays the possible flags you can enter in a spin command.

To display the frequency of spin lands, enter "frequency".
