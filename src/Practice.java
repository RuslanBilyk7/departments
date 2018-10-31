/**
 * Created by RUSLAN77 on  23.02.2018 in Ukraine
 */
class Practice {
    static int x;

    void increment() {
        ++x;
    }

    static class static_use {
        public static void main(String[] args) {
            Practice obj1 = new Practice();
            Practice obj2 = new Practice();
            obj1.x = 0;
            obj1.increment();
            obj2.increment();
            System.out.println(obj1.x + obj2.x);
        }
    }
}
