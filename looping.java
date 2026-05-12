public class looping {
    public static void main(String[] args) {
       whileLoop();
        /**
         *      *
         *     ***
         *    *****
         *   *******
         *  *********
         * */
    }
    static void whileLoop (){
        int n = 1;
        while(n <= 5){
            int k = 1;
            while (k<=n){
                System.out.println("*");
                k++;
            }
            System.out.println();
            n++;
        }
    }
}
