package clock;
/*
* 1.clock内创建三个Display对象，他们本身不知道对方的存在，没有进行直接交互;
* 2.时，分，秒的交互逻辑代码写在clock内，即让他们间接交互。
* */
public class Clock {

    private Display hour;
    private Display minute;

    public Clock() {
        hour = new Display(24);
        minute = new Display(60);
    }

    public void start(){
        while (true){
            minute.increase();
            if (minute.getValue() == 0) {
                hour.increase();
            }

            System.out.printf("%02d:%02d\n",hour.getValue(),minute.getValue());
        }
    }
}
