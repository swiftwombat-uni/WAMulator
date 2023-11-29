# WAMulator
This is a program to calculate the *Weighted Average Mark* (WAM) and *Grade Point Average* (GPA) of a University of Newcaslte (UoN) bachelors degree based off provided course data.

To run the program, a file containing all your relavent course data (see format below) must be passed in via command line arguments. After compilation using `javac App.java`, the program can be run using `java App input.txt`. (the name/path of the input file can be changed)

If using VS Code, the project can simply be run from the debugger. As a pre-requsuite for this, the course data file should be placed into a folder called `dat`, with the name `input.txt` (i.e., `dat/input.txt`).

## Input Data Format
The data required for each course will be:
 - _**CODE**_: How the course is identified (e.g., SENG4211, COMP2050, INFT3960 etc.)
 - _**UNITS**_: How many units the course contributed to your degree
 - _**MARK**_: The final mark recieved for the course

Each course should be placed on a new line of the file in the form of "CODE UNITS MARK" (i.e., data is space delimeted). An example data file would look as follows:
```
ENGG1003 10 97
SENG2050 10 88
SENG3150 10 82
SENG4500 10 83
SENG4211 20 89
...
```

## WAM Formula
WAM is calculated by following the instructions of the [UoN's WAM calcuiation guideline](https://policies.newcastle.edu.au/document/view-current.php?id=3). Mathamatically, it can be summerised by the following formula and definitions:\
\
WAM = $\frac{\sum(M \times V \times W)}{\sum(V \times W)}$\
where:\
_**M**_ := course mark (with a minimum value of 44);\
_**V**_ := unit value of the course concerned; and\
_**W**_ := weighting of the course concerned.

## GPA Formula
GPA is calculated by following the instructions of the [UoN's GPA calcuiation guideline](https://policies.newcastle.edu.au/document/view-current.php?id=157#:~:text=(1)%20A%20grade%20point%20average,unit%20values%20for%20all%20grades.). It is calculated by giving each course a grade point (see table below) in a range of 0 - 7 and averaging them with the courses unit value. Mathematically, the formula is as follows:\
\
GPA = $\frac{\sum(V \times P)}{\sum(P)}$\
where:\
_**V**_ := unit value of the course concerned; and\
_**P**_ := grade point of the recieved course mark (given by the table below).

<table style="width:100%">
  <tr>
    <th>Mark</th>
    <td>HD</td>
    <td>D</td>
    <td>C</td>
    <td>P</td>
    <td>FF</td>
  </tr>
  <tr>
    <th>Grade Point</th>
    <td>7</td>
    <td>6</td>
    <td>5</td>
    <td>4</td>
    <td>0</td>
  </tr>
</table>
