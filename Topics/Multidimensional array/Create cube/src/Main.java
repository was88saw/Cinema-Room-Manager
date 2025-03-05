class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here
    int count = 0;
        int[][][] tmp = new int[3][3][3];
        for(int i = 0; i < tmp.length; i++){
            for(int j = 0; j < tmp[i].length; j++){
                for(int k = 0; k < tmp[i][j].length; k++){
                    tmp[i][j][k] = count++;
                }
            }count = 0;
        }
        return tmp;
    }
}