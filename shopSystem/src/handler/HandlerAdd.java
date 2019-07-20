package handler;

import data.Shop;
import goods.Goods;

import java.io.IOException;

public class HandlerAdd extends Handler {
    public HandlerAdd(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() throws IOException {
        System.out.println("请输入要上架的新商品:");
        //定义商品编号
        String id = "";

        //判断编号是否重复，如果重复重新录入
        while (true) {
            System.out.print("商品id:");
            id = sc.nextLine();

            boolean flag = data.isExist(id); //如果返回true, 表示重复
            if (flag) {
                System.out.println("你要上架的商品已经在售，请选择最新商品");
            } else {
                break;
            }
        }
        System.out.print("商品名称:");
        String name = sc.nextLine();
        System.out.print("商品价格:");
        String price = sc.nextLine();
        System.out.print("商品单位:");
        String unit = sc.nextLine();
        Goods good = new Goods(id, name, Double.parseDouble(price), unit);
        data.add(good);
    }
}
