package cn.scientist123zl.test.leetcode;

/**
 * 5.29 岛屿的数量
 * BFS 广度优先搜索
 */
public class A200_numbers_of_islands {

    int dx[] = new int []{-1, 1, 0, 0};
    int dy[] = new int []{0, 0, -1, 1};
    char[][] g;

    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g[i].length; j++) {
                if(g[i][j] == '0') continue;
                islands += sink(i,j);
            }
        }
        return islands;
    }

    private int sink(int i, int j) {
        //terminator
        if(g[i][j] == '0') {
            return 0;
        }

        //i,j='1'
        g[i][j] = '0';

        for(int k = 0; k < dx.length; ++k) {
            int x = i + dx[k], y = j + dy[k];
            if(x >= 0 && x < g.length && y >= 0 && y <g[i].length) {
                if(g[x][y] == '0') continue;
                sink(x,y);
            }
        }
        return  1;
    }

    public static void main(String[] args) {
        A200_numbers_of_islands a = new A200_numbers_of_islands();
        char[][] grid = new char[][]{
                {'1','1','1','0','0'},
                {'1','0','1','0','0'},
                {'1','1','0','1','0'},
                {'0','0','0','1','0'},
                {'0','0','0','0','1'},
                };
        System.out.println(a.numIslands(grid));
    }
}
