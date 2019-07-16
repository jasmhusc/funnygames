package clock;
/*
* 时钟的小时，分钟，秒都是不停增加;
* 当到达一定界限时则归零，重置为初始状态;
* 三种事物可以抽象为display类
* 此处只实现时，分
* */
public class Display {

    private int value = 0;
    private int limit;

    public Display() {
    }

    public Display(int limit) {
        this.limit = limit;
    }

    public int getValue(){
        return value;
    }

    public void increase(){
        value++;
        if (value == limit)
            value = 0;
    }
}
