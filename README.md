# StableMatching

## Idea
Given an instance of StableMatching and a match, determine whether the match is stable or not. If not, give one instability.

## Input Format
The input file will be called input1.txt and be in the same directory as the java and class files.
Line 0 will be a single integer n, the number of men (or women). 
Lines 1 to n will be the preferences of the n men where each line is a space seperated permutation of {1, 2, ..., n}.
Lines n + 1 to n + n will be the preferences of the n women where each line is a space seperated permutation of {1, 2, ..., n}.
Line 2n + 1 will be a permutation of {1, 2, ..., n} which represents a matching. 
In particular, the ith item in the permutation is the number of the woman with which man i is matched.

## Running the code
The code can simply be run with command `java Project1` and it will defaulting to use input1.txt. 

If command-line argument was provided, then the code will look for the specified file as input file (i.e. command `java Project1 2` will force the code to use input2.txt as input file instead).

The code will simply prints out error and exit if more than 1 command-line argument were given (i.e. `java Project1 3 2` will not work).

If the specified input file is not found, then the program will just throw `FileNotFoundException`.

## Output
Yes (if matching is stable) or No and an ordered pair representing an instability (if matching is instable).

I've also printed out the full path of input1.txt file along with number of men/women (from the first line of input1.txt file) for debugging purposes.

## input1.txt Example
```
Line 1 : 2     <- (Line 1: number of men (or women))
Line 2 : 1 2   <- (Line 2 & 3: both men prefer woman 1)
Line 3 : 1 2
Line 4 : 2 1   <- (Line 4 & 5: both women prefer men 1)
Line 5 : 2 1
Line 6 : 1 2   <- (Line 6: matching M1-W1, M2-W2)
```
For this example, the output will be `No. (2, 1)`.
