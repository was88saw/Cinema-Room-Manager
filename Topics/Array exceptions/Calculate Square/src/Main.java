class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        try {
            System.out.println(array[index] * array[index]);
        }catch (Exception e){
            System.out.println("Exception!");
        }
    }
}