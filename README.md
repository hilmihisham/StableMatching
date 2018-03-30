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

## Output
Yes (if matching is stable) or No and an ordered pair representing an instability (if matching is instable)
