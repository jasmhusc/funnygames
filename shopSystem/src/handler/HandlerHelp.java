package handler;

import data.Shop;

public class HandlerHelp extends Handler {
    public HandlerHelp(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() {
        System.out.println("命令提示: add, modify, query, drop, list, clear, bye");
        System.out.println("\r\n");
    }
}
