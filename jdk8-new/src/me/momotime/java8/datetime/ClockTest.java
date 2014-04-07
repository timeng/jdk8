package me.momotime.java8.datetime;

import java.time.*;

/**
 * @author momo.
 */
public class ClockTest {
    public static void main(String arg[]) {
        //获取时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId + "  ZoneId.systemDefault");

        //获取时区
        ZoneId zoneIdoffSet = ZoneId.ofOffset("UTC",ZoneOffset.ofHours(8));
        System.out.println(zoneIdoffSet + "  zoneIdoffSet");

        Clock c1 = Clock.systemUTC(); //系统默认UTC时钟（当前瞬时时间 System.currentTimeMillis()）
        System.out.println(c1.instant()); //每次调用将返回当前瞬时时间（UTC）

        System.out.println(System.currentTimeMillis() + " System.currentTimeMillis() ");

        Clock c32 = Clock.system(ZoneId.of("Asia/Shanghai"));//上海时区
        System.out.println(c32.millis() + " Asia/Shanghai ");

        Clock c2 = Clock.systemDefaultZone(); //系统默认时区时钟（当前瞬时时间）
        System.out.println(c2.millis() + " systemDefaultZone");

        Clock c31 = Clock.system(ZoneId.of("Europe/Berlin")); //柏林
        System.out.println(c31.millis() + " Europe/Berlin"); //每次调用将返回当前瞬时时间（UTC）


        Clock c4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));//固定上海时区时钟
        System.out.println(c4.millis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c4.millis()); //不变 即时钟时钟在那一个点不动
        System.out.println(c31.millis() + " Europe/Berlin sleep 1s"); //每次调用将返回当前瞬时时间（UTC）

        Clock c5 = Clock.offset(c1, Duration.ofSeconds(2)); //相对于系统默认时钟两秒的时钟
        System.out.println(c5.millis());

        LocalDateTime shanghaiDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(shanghaiDateTime + " shanghaiDateTime");
        LocalDate date = LocalDate.now();
        System.out.printf("%s-%s-%s",
                date.getYear(), date.getMonthValue(), date.getDayOfMonth()
        );

        //Period p = Period.of;
        LocalTime time = LocalTime.now();
        LocalTime newTime;
      //  newTime = time.plus(5, HOURS);
// or
        newTime = time.plusHours(5);
// or
       // newTime = time.plus(p);
    }
}
