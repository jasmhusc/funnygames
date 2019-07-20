package handler;

import data.Shop;

public class HandlerClear extends Handler {
    public HandlerClear(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() {
        data.clear();
    }
}
