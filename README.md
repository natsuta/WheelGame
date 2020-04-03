# WheelGame
For Further Programming (formerly Software Architecture: Design and Implementation) Semester 1 2019  
Code checked April 2020

# Background
There are two parts to this project; the first was to code the logic for a roulette wheel and the second was to implement a GUI interface around it using AWT/Swing, showing the status of the wheel and player bets.

Starter code and Javadocs were provided for the interfaces and enumeration types.

# How to use
- Import the repo to Eclipse as a project.
- To run the wheel in the console, run any of the clients in `WheelGame`.
- To run the GUI, run `GUITestClient.java` in `WheelGameGUI`.

# Notes
- Bets on green (zeroes) are 18 to 1, whereas bets on red or black are 1 to 1.
- A `Validator.jar` was included in `WheelGame` for the purposes of checking the code to ensure that all the required methods were implemented. If the `Validator.validate(true);` line is not commented out or removed, then the program will not proceed if any methods are missing or not defined correctly (that is if they are changed).