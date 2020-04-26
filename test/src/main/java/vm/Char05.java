package vm;

// Run with: java -XX:CompileCommand='dontinline,*. out' Char06
public abstract class Char05 {
    abstract void out();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Char05 a = new Chinese();
        Char05 b = new Foregin();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
//            if (i % 100_000_000 == 0) {
//                long temp = System.currentTimeMillis();
//                System.out.println(temp - current);
//                current = temp;
//            }
            Char05 c = (i < 1_000_000_000) ? a : b;
//            Char06 c = 1_000_000_000 % i == 0 ? a : b;
            c.out();
        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }
}

class Chinese extends Char05 {
    @Override
    void out() {
    }
}

class Foregin extends Char05 {
    @Override
    void out() {
    }
}


