package handler;

import data.Shop;

import java.io.IOException;

public class HandlerList extends Handler {
    public HandlerList(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() throws IOException {
        data.showGoods();
        System.out.println();  // 换行
    }
}
