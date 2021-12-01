class Problem37{
    boolean[][] line = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;
    public void solveSudoku(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    spaces.add(new int[]{i, j});
                }else{
                    int digit = board[i][j] - '1';
                    line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                }
            }
        }
        backtrack(board, 0);
    }
    private void backtrack(char[][] board, int pos){
        if(pos == spaces.size()){
            valid = true;
            return ;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for(int digit=0; digit<9 && !valid; digit++){
            if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                board[i][j] = (char)(digit+'1');
                backtrack(board, pos+1);
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
            }
        }
    }
}