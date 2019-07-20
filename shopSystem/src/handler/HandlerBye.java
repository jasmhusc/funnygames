package handler;

import data.Shop;

public class HandlerBye extends Handler {
    public HandlerBye(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() {
        System.out.print("再见！");
    }

    @Override
    public boolean isBye() {
        return true;
    }
}
