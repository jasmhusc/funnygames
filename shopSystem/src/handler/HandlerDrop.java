package handler;

import data.Shop;

import java.io.IOException;

public class HandlerDrop extends Handler {
    public HandlerDrop(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() throws IOException {
        if (data.getSize() > 0) {
            System.out.println("请输入要下架的商品:");
            System.out.println("商品id:");
            String sid3 = sc.nextLine();
            data.remove(sid3);
        } else
            System.out.println("商店没有商品！\r\n");

    }
}
