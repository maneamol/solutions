public class Test {

    public void test(int x) {
        System.out.println(x%10);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test(-123);
    }
}
