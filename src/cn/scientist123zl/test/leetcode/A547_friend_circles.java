package cn.scientist123zl.test.leetcode;

/**
 * 547 朋友圈
 * dfs
 */
public class A547_friend_circles {
//    public int findCircleNum(int[][] M) {
//        int[] visited = new int[M.length];
//        int count = 0;
//        for(int i = 0; i < M.length; i++) {
//            if(visited[i]==0) {
//                dfs(M, visited, i);
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public void dfs(int[][] M, int[] visited, int i) {
//
//        //DFS 转换为岛屿问题200
//        //并查集 disjoint set
//        //a N-->各自独立集合
//        //b.遍历好友矩阵M： M[i][j] -->合并
//        //c.看有多少孤立的集合
//        for(int j = 0; j < M.length; j++) {
//            if(M[i][j] == 1 && visited[j] == 0) {
//                visited[j] = 1;
//                dfs(M, visited, j);
//            }
//        }
//    }
    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;  //初始自己指向自己
                size[i] = 1;    //每一个树大小为1
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.count();
    }

    public static void main(String[] args) {
        A547_friend_circles  a = new A547_friend_circles();
        int[][] freinds = new int [][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}

        };
        System.out.println(a.findCircleNum(freinds));
    }
}
