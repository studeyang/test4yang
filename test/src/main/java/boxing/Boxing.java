package boxing;

import javax.swing.*;

public class Boxing {

    public static void main(String[] args) {
        Integer x = 5;
        int y = 5;
        if (x == y) {
            System.out.println("yes");
        }


        System.out.println(new Boxing().hashCode());
    }

}
