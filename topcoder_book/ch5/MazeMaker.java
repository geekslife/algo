import java.util.*;

public class MazeMaker {
    int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int max = -1;
        for( int r=0; r<maze.length; r++) {
            for (int c=0;c<maze[0].length(); c++) {
                max = Math.max(max,findPath(maze,startRow,startCol,moveRow,moveCol,r,c));
            }
        }

        return max;
    }

    int findPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol, 
int endRow, int endCol) {
        System.out.println("exit:("+endRow+","+endCol+")");
        boolean[][] visited = new boolean[maze.length][maze[0].length()];
        for( int r=0; r<visited.length; r++ ) {
            for( int c=0; c<visited[0].length; c++) {
                if (maze[r].charAt(c) == 'X') visited[r][c]=false;
            }
        }

        List<Node> queue = new ArrayList<>();
        queue.add(new Node(startRow, startCol,1));
        while( !queue.isEmpty() ) {
            Node node = queue.remove(0);
            System.out.println("pop node:"+node);
            if (node.row == endRow && node.col==endCol) {
                System.out.println("exit!");
                return node.level;
            }
            visited[node.row][node.col] = true;
            for( int r=0; r<moveRow.length; r++) {
                int nextRow = node.row+moveRow[r];
                int nextCol = node.col+moveCol[r];
                if (nextRow >= visited.length ||
                    nextCol >= visited[0].length ||
                    nextRow < 0 || nextCol < 0 )
                    continue;
                if(maze[nextRow].charAt(nextCol) == '.' &&
                    visited[nextRow][nextCol]==false) {
                    visited[nextRow][nextCol]=true;
                    Node n = new Node(nextRow,nextCol,node.level+1);
                    System.out.println("add new node:"+n);
                    queue.add(n);
                }
            }
        }

        System.out.println("fail!");
        return -1;
    }

    class Node {
        int row;
        int col;
        int level;
        Node(int r, int c, int level) {
            this.row=r;
            this.col=c;
            this.level = level;
        }
        @Override
        public String toString() {
            return "N("+row+","+col+") ["+level+"]";
        }
    }

    public static void main(String[] args) {
        String[] maze = { "...","...","..."};
        int startRow = 0;
        int startCol = 1;
        int[] moveRow = {1,0,-1,0};
        int[] moveCol = {0,1,0,-1};
        MazeMaker mm = new MazeMaker();
        //System.out.println("expect:3,run="+mm.longestPath(maze,startRow,startCol,moveRow,moveCol));
        maze =new String[] {"X.X","...","XXX","X.X"};
        startRow=0; startCol=1;moveRow=new int[]{1,0,-1,0};moveCol=new int[]{0,1,0,-1};
        System.out.println("expect:-1,run="+mm.longestPath(maze,startRow,startCol,moveRow,moveCol));
    }
}
