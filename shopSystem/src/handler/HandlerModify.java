package handler;

import data.Shop;

import java.io.IOException;

public class HandlerModify extends Handler {
    public HandlerModify(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() throws IOException {
        System.out.println("请输入要更新的商品id:");
        String id = sc.nextLine();
        if (data.getById(id) != null) {
            System.out.print("新名称:");
            String name = sc.nextLine();
            System.out.print("新价格:");
            String price = sc.nextLine();
            System.out.print("新单位:");
            String unit = sc.nextLine();
            data.set(id, name, Double.parseDouble(price), unit);
        } else
            System.out.println("货架上没有该商品！\r\n");

    }
}
