import java.util.*;

public class Main {
  public static int isCross(int[][] matrix, int row, int col) {
      int count = 0;
      int length = matrix[0].length;
      int topLeftRow = row - 1;
      int topLeftCol = col - 1;
      int btmRightRow = row + 1;
      int btmRightCol = col + 1;
      while (topLeftRow >= 0 && topLeftCol >= 0 && btmRightRow < length && btmRightCol < length) {
    	  int squareLength = btmRightCol - topLeftCol + 1;
          int midpointCol = ((squareLength/2) + topLeftCol);
          int midpointRow = ((squareLength/2) + topLeftRow);
          for (int i = topLeftRow; i <= btmRightRow; i++) {
              for (int j = topLeftCol; j <= btmRightCol; j++) {
                  System.out.print(matrix[i][j]);
                  if ((i == midpointRow) || (j == midpointCol)) {
                	  System.out.println(matrix[i][j]);
                	  if (matrix[i][j] != 1) 
                		  return count;
                  } else {
                	  if (matrix[i][j] != 0)
                		  return count;
                  }
              }
              System.out.println("\n");
          }
          count++;
          topLeftRow = topLeftRow - 1;
          topLeftCol = topLeftCol - 1;
          btmRightRow = btmRightRow + 1;
          btmRightCol = btmRightCol + 1;
      }
      return count;
  }    
     
 public static void main(String [] args) {
      Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i<n; i++) {
            String input = scan.nextLine();
            for (int j = 0; j < input.length(); j++) {
            	matrix[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
            	count += isCross(matrix, row, col);
            }
        }
        System.out.println(count);
  }
}
