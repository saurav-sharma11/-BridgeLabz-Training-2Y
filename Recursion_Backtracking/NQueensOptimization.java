package Recursion_Backtracking;

/*
Problem 3: N-Queens Optimization and Variants

Scenario:
A chess tutorial application demonstrates queen placement using the N-Queens problem.

---------------------------------------------------------------------

a) Search Space Analysis for 8-Queens

Brute Force (no constraints):
Each queen can be placed in any of 64 squares.

Search space:
64^8 = 281,474,976,710,656 possible placements

------------------------------------------------

With "One Queen per Row" Constraint:
We only choose columns for each row.

8 choices per row

Search space:
8^8 = 16,777,216

------------------------------------------------

Considering Column Constraints (Permutation):
Each row must use a unique column.

Number of permutations:
8! = 40,320

------------------------------------------------

Backtracking Exploration Estimate

Because diagonal constraints prune many states early,
the algorithm typically explores only a few thousand states.

Actual valid solutions for N=8:
92 solutions

Backtracking explores roughly:
~15,000 – 20,000 states depending on implementation.

---------------------------------------------------------------------

b) Optimized N-Queens using 1D Array

Instead of storing the whole board, we store:

board[row] = column position of queen

Example:
board = [1,3,0,2]

means:
row0 -> col1
row1 -> col3
row2 -> col0
row3 -> col2

We track conflicts using:

columns[]
diag1[]  (row - col + N - 1)
diag2[]  (row + col)

Pseudocode:

function solve(row):

    if row == N:
        print solution
        return

    for col from 0 to N-1:

        if column[col] or diag1[row-col+N-1] or diag2[row+col] occupied
            continue

        place queen

        mark column and diagonals

        solve(row+1)

        remove queen (backtrack)

------------------------------------------------

Advantages

Instead of scanning entire board:
O(N)

Conflict check becomes:
O(1)

So algorithm becomes much faster.

---------------------------------------------------------------------

c) Trace for N=4

Row 0:
try col0 → place

board = [0, -, -, -]

Row1:
col0 ❌ column conflict
col1 ❌ diagonal conflict
col2 ✅ place

board = [0,2,-,-]

Row2:
col0 ❌ column conflict
col1 ❌ diagonal conflict
col2 ❌ column conflict
col3 ❌ diagonal conflict

Backtrack

Row1:
try col3

board = [0,3,-,-]

Row2:
col1 ✅ place

board = [0,3,1,-]

Row3:
col2 ❌ diagonal
col3 ❌ column

Backtrack

Eventually first valid solution:

board = [1,3,0,2]

Board layout:

. Q . .
. . . Q
Q . . .
. . Q .

---------------------------------------------------------------------

d) Finding Only ONE Solution Quickly

Modification:

Stop recursion once first solution found.

Instead of exploring all branches,
return true immediately after first valid configuration.

Pseudo modification:

if solve(row+1) returns true
    return true

This prevents exploring unnecessary branches.

---------------------------------------------------------------------

e) N-Queens with Forbidden Squares

Add a matrix:

boolean forbidden[row][col]

Before placing queen check:

if forbidden[row][col] == true
    skip

Pseudocode addition:

if forbidden[row][col]
    continue

Impact on Complexity:

Worst-case complexity remains exponential,
but forbidden squares reduce search space.

If many squares are forbidden,
backtracking prunes more branches early.

---------------------------------------------------------------------
*/

public class NQueensOptimization {

    static int N = 8;

    static int[] board = new int[N];

    static boolean[] column = new boolean[N];
    static boolean[] diag1 = new boolean[2*N];
    static boolean[] diag2 = new boolean[2*N];

    public static boolean solve(int row){

        if(row == N){
            printBoard();
            return true; // stop after first solution
        }

        for(int col=0; col<N; col++){

            if(column[col] || diag1[row-col+N] || diag2[row+col])
                continue;

            board[row] = col;

            column[col] = true;
            diag1[row-col+N] = true;
            diag2[row+col] = true;

            if(solve(row+1))
                return true;

            column[col] = false;
            diag1[row-col+N] = false;
            diag2[row+col] = false;
        }

        return false;
    }

    public static void printBoard(){

        System.out.println("Solution:");

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(board[r] == c)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        solve(0);

    }
}