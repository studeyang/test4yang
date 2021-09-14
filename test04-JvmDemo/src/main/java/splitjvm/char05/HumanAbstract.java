package splitjvm.char05;

/**
 * @author yangll
 *
 * <p>测试方法内联</p>
 * Run with: java -XX:CompileCommand='dontinline,*. out' HumanAbstract
 */
public abstract class HumanAbstract {

    abstract void out();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        HumanAbstract chinese = new Chinese();
        HumanAbstract foreigner = new Foreigner();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
//            if (i % 100_000_000 == 0) {
//                long temp = System.currentTimeMillis();
//                System.out.println(temp - current);
//                current = temp;
//            }
            HumanAbstract people = (i < 1_000_000_000) ? chinese : foreigner;
//            Char06 c = 1_000_000_000 % i == 0 ? a : b;
            people.out();
        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }
}

class Chinese extends HumanAbstract {
    @Override
    void out() {
    }
}

class Foreigner extends HumanAbstract {
    @Override
    void out() {
    }
}


