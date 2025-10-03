package 栈内存溢出案例;

/**
 * <p>
 * 功能描述: 栈内存溢出案例 StackOverflowError
 * 可以通过-Xss256k设置栈内存大小
 * </p>
 *
 * @author Hanxuewei
 * @since 2025/10/2
 */
public class Demo1 {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
