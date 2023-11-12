# WAMulator
This is a program to calculate the WAM and GPA of a UoN degree based off provided course data.

To run the program, a file containing all your relavent course data (see format below) must be passed in via command line arguments. After compilation using `javac App.java`, the program can be run using `java App input.txt`. (the name/path of the input file can be changed)

If using VS Code, the project can simply be run from the debugger. As a pre-requsuite for this, the course data file should be placed into a folder called `dat`, with the name `input.txt` (i.e., `dat/input.txt`)

## Course Data Format
The data required for each course will be:
 - _**CODE**_: How the course is identified (e.g., SENG4211, COMP2050, INFT3960 etc.)
 - _**UNITS**_: How many units the course contributed to your degree
 - _**MARK**_: The final mark recieved for the course

Each course should be placed on a new line of the file in the form of "CODE UNITS MARK" (i.e., data is space delimeted)

## Example Data File
```
ENGG1003 10 97
SENG2050 10 88
SENG3150 10 82
SENG4500 10 83
SENG4211 20 89
...
```
