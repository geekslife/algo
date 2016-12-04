public class CrazyBot {
    boolean[][] visited = new boolean[100][100];
    double PE,PW,PS,PN;

    public double getProbability(int n, int east, int west, int south, int north) {
        PE = east/100.0;
        PW = west/100.0;
        PS = south/100.0;
        PN = north/100.0;
        for( int i=0; i<100; i++)
            for (int j=0; j<100; j++)
                visited[i][j] = false;
        return dfs(50,50,n);
    }

    double dfs(int x,int y,int n) {
        if (visited[x][y] == true) return 0.0;
        if (n==0) return 1.0;
        // true 로 두어야 재귀식에서 계산시 반영이 된다.
        visited[x][y] = true;
        double result = PE*dfs(x+1,y,n-1)+
                PW*dfs(x-1,y,n-1)+
                PS*dfs(x,y-1,n-1)+
                PN*dfs(x,y+1,n-1);
        // 현재 위치에서의 계산이 끝났으면 false 로 두어야 옆에서 계산할 때 방해되지 않는다.
        visited[x][y] = false;
        return result;
    }

    public static void main(String[] args) {
        CrazyBot cb = new CrazyBot();
        System.out.println("expected:1.0 :"+cb.getProbability(1,25,25,25,25));
        System.out.println("expected:0.75 :"+cb.getProbability(2,25,25,25,25));
        System.out.println("expected:1.0 :"+cb.getProbability(7,50,0,0,50));
    }
}
