public class BruteForceSudoku {
    private BruteForcer forcer;

    public BruteForceSudoku(int[][] input){
        this.forcer = new BruteForcer(new Grid(input));

        System.out.println("Brute forcing:");
        System.out.println(this.forcer.getGrid());

        boolean solved = this.forcer.solve();
        if (solved){
            System.out.println("Solved:");
            System.out.println(this.forcer.getGrid());
        } else {
            System.out.println("IMPOSSIBRU :(");
        }
    }

    public static void main(String args[]) {
        int[][] test1 = new int[][]
                {
                        {0, 0, 7, 0, 6, 0, 4, 0, 0},
                        {5, 0, 0, 4, 0, 7, 0, 0, 8},
                        {0, 1, 0, 8, 0, 3, 0, 2, 0},
                        {0, 6, 2, 7, 0, 9, 3, 4, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 3, 9, 5, 0, 4, 2, 6, 0},
                        {0, 9, 0, 2, 0, 8, 0, 7, 0},
                        {2, 0, 0, 9, 0, 5, 0, 0, 6},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        int[][] test2 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        new BruteForceSudoku(test1);
    }
}
