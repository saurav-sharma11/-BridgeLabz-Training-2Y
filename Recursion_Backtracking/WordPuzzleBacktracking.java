package Recursion_Backtracking;

/*
Problem 2: Backtracking Template Application

Scenario:
A mobile gaming company is developing a word puzzle game. Players must form words by
connecting adjacent letters in a 4×4 grid. Letters can be used only once per word, and movement
is allowed horizontally, vertically, and diagonally.

Grid:
C A T S
O R E A
D E A M
E L L S

Target Word: "DREAM"

--------------------------------------------------------------------
a) Backtracking Algorithm (Pseudocode)

State Representation:
- current position in grid (row, col)
- current index in word
- visited matrix to ensure each letter is used only once

Choices at each step:
- Move in 8 directions:
  up, down, left, right,
  diagonal up-left, up-right,
  diagonal down-left, down-right

Constraints:
- Position must be inside grid
- Cell must match current character
- Cell must not be visited already

Goal Condition:
- If index == word length → word found

Pseudocode:

function search(grid, word, row, col, index, visited):

    if index == length(word)
        return true

    if row < 0 OR col < 0 OR row >= rows OR col >= cols
        return false

    if visited[row][col] == true
        return false

    if grid[row][col] != word[index]
        return false

    mark visited[row][col] = true

    for each direction in 8 directions
        if search(nextRow, nextCol, index + 1)
            return true

    mark visited[row][col] = false   // backtrack
    return false

--------------------------------------------------------------------
b) Decision Tree for "DREAM"

Start at all cells containing 'D'

Possible start:
(2,0) = D

From D explore neighbors for 'R'

D(2,0)
 ├─ R(1,1)
 │   ├─ E(1,2)
 │   │   ├─ A(2,2)
 │   │   │   └─ M(2,3)  ← SUCCESS
 │   │   └─ other paths → backtrack
 │   └─ other paths → backtrack
 └─ other neighbors → fail

Successful path:
(2,0) → (1,1) → (1,2) → (2,2) → (2,3)

--------------------------------------------------------------------
c) Execution Trace

Step 1:
search(D at 2,0)

Step 2:
search(R at 1,1)

Step 3:
search(E at 1,2)

Step 4:
search(A at 2,2)

Step 5:
search(M at 2,3)

Word completed → return true

Backtracking occurs if:
- character mismatch
- cell already visited
- path does not lead to solution

State restoration:
visited[row][col] = false

--------------------------------------------------------------------
d) Worst-case Time Complexity

Let:
N = number of rows
M = number of columns
L = length of word

Each step explores up to 8 directions.

Worst-case complexity:

O(N × M × 8^L)

Explanation:
- Start search from each grid cell
- At each character we explore 8 possibilities

Backtracking reduces practical search space by pruning invalid paths.

--------------------------------------------------------------------
e) Finding ALL possible ways

Modify algorithm:

Instead of returning true immediately,
store each successful path.

Add data structure:

List<List<Cell>> solutions

Whenever goal condition reached:
add current path to solutions

Return all paths after search completes.

--------------------------------------------------------------------
*/

public class WordPuzzleBacktracking {

    static int[] rowDir = {-1,-1,-1,0,0,1,1,1};
    static int[] colDir = {-1,0,1,-1,1,-1,0,1};

    public static boolean search(char[][] grid, String word,
                                 int row, int col,
                                 int index, boolean[][] visited){

        if(index == word.length())
            return true;

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;

        if(visited[row][col])
            return false;

        if(grid[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        for(int d=0; d<8; d++){
            if(search(grid, word,
                    row + rowDir[d],
                    col + colDir[d],
                    index + 1,
                    visited))
                return true;
        }

        visited[row][col] = false; // backtrack
        return false;
    }

    public static boolean exists(char[][] grid, String word){

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(search(grid, word, i, j, 0, visited))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        char[][] grid = {
                {'C','A','T','S'},
                {'O','R','E','A'},
                {'D','E','A','M'},
                {'E','L','L','S'}
        };

        String word = "DREAM";

        if(exists(grid, word))
            System.out.println("Word Found");
        else
            System.out.println("Word Not Found");
    }
}