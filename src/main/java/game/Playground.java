package game;

import user.Player;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by knerushkin on 21/03/2017.
 */
public class Playground {
    public int num = 10000000;

    public static void main(String[] args) {
        int[] nums = new int[]{ 10, 100, 500};
        Playground pg = new Playground();
        int[] decresed = Arrays.stream(nums).map(pg::decreaseNum).toArray();

        Function<Integer, Integer> decreaseBYLambda = pg::decreaseNum;
        if(pg.num == 10000000) ;
        System.out.println(Arrays.toString(decresed));
        System.out.println(pg.num);
        Kid k = new Kid();
        Function<Kid, Integer> giveToKid = pg.give(999999);
        System.out.println(giveToKid.apply(k));
        if(k.num < 50) giveToKid.apply(k);
        System.out.println(k.num);
        System.out.println(pg.num);
    }

    public Function<Kid, Integer> give(int num) {
        this.decreaseNum(num);
        return k -> k.get(num);
    }

    public int decreaseNum(int num) {
        this.num -= num;
        return num;
    }
}

class Kid {

    public int num;

    int get(int num) {
        this.num += num;
        return num;
    }

}