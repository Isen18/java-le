package jvm;

/**
 * @author Isen
 * @date 2019/2/28 10:15
 * @since 1.0
 */
public class DeadLoop {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
//        int i = 0;
//        while(true){
//            i++;
//        }
    }
}
