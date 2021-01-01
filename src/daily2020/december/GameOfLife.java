package daily2020.december;

/**
 * 
 * @author shermanmarshall
 * 
 *         According to Wikipedia's article: "The Game of Life, also known
 *         simply as Life, is a cellular automaton devised by the British
 *         mathematician John Horton Conway in 1970."
 * 
 *         The board is made up of an m x n grid of cells, where each cell has
 *         an initial state: live (represented by a 1) or dead (represented by a
 *         0). Each cell interacts with its eight neighbors (horizontal,
 *         vertical, diagonal) using the following four rules (taken from the
 *         above Wikipedia article):
 * 
 *         Any live cell with fewer than two live neighbors dies as if caused by
 *         under-population. Any live cell with two or three live neighbors
 *         lives on to the next generation. Any live cell with more than three
 *         live neighbors dies, as if by over-population. Any dead cell with
 *         exactly three live neighbors becomes a live cell, as if by
 *         reproduction.
 * 
 *         The next state is created by applying the above rules simultaneously
 *         to every cell in the current state, where births and deaths occur
 *         simultaneously. Given the current state of the m x n grid board,
 *         return the next state.
 * 
 *         eg: Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]] Output:
 *         [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 
 *         In: 010 001 111 000
 * 
 *         Out: 000 101 011 010
 * 
 */
public class GameOfLife {

	public static boolean isLivingState(int[][] world, int row, int column) {
		int numNeighbors = 0;

		boolean isColumnLeftBounded = column - 1 < 0;
		boolean isColumnRightBounded = column + 1 >= world[row].length;
		boolean isRowBoundedAbove = row - 1 < 0;
		boolean isRowBoundedBelow = row + 1 >= world.length;

		if (!isColumnLeftBounded) {
			numNeighbors += world[row][column - 1];
		}
		if (!isColumnRightBounded) {
			numNeighbors += world[row][column + 1];
		}
		if (!isRowBoundedAbove) {
			numNeighbors += world[row - 1][column];
		}
		if (!isRowBoundedBelow) {
			numNeighbors += world[row + 1][column];
		}
		if (!isColumnLeftBounded && !isRowBoundedAbove) {
			numNeighbors += world[row - 1][column - 1];
		}
		if (!isColumnLeftBounded && !isRowBoundedBelow) {
			numNeighbors += world[row + 1][column - 1];
		}
		if (!isColumnRightBounded && !isRowBoundedAbove) {
			numNeighbors += world[row - 1][column + 1];
		}
		if (!isColumnRightBounded && !isRowBoundedBelow) {
			numNeighbors += world[row + 1][column + 1];
		}

		return numNeighbors == 3 || (world[row][column] == 1 && numNeighbors == 2);
	}

	private static int[][] fromState(int[][] world, boolean isNewState) {
		int[][] newState = new int[world.length][world[0].length];

		for (int y = 0; y < world.length; y++) {
			for (int x = 0; x < world[y].length; x++) {
				newState[y][x] = isLivingState(world, y, x) ? 1 : 0;
			}
		}

		if (!isNewState) {
			for (int y = 0; y < world.length; y++) {
				for (int x = 0; x < world[y].length; x++) {
					world[y][x] = newState[y][x];
				}
			}
		}

		return newState;
	}

	public static void nStates(int numStates, int[][] world) {
		for (int x = 0; x < numStates; x++) {
			fromState(world, false);
		}
	}

	public static void main(String[] args) {
		int[][] world = fromState(new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } }, false);

		for (int[] row : world) {
			for (int col : row) {
				System.out.print(col + ", ");
			}
			System.out.println();
		}
	}

}
