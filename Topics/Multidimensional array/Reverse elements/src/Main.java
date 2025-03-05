class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        // write your code here
        for( int i = 0; i < twoDimArray.length; i++){
            for(int j = 0; j < twoDimArray[i].length / 2; j++){
                int tmp = twoDimArray[i][j];
                twoDimArray[i][j] = twoDimArray[i][twoDimArray[i].length - j - 1];
                twoDimArray[i][twoDimArray[i].length - j - 1] = tmp;
            }
        }
    }
}