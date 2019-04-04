import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/4 15:55
 */
public class Test {
    public static void main(String[] args) {
        AtomicInteger onlineCount = new AtomicInteger();
        System.out.println(onlineCount);
        onlineCount.incrementAndGet();
        System.out.println(onlineCount);
        onlineCount.decrementAndGet();
        System.out.println(onlineCount);
    }
}
