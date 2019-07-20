package handler;

import data.Shop;
import goods.Goods;

import java.io.IOException;

public class HandlerQuery extends Handler {
    public HandlerQuery(Shop data) {
        super(data);
    }

    @Override
    public void doCmd() throws IOException {
        if (data.getSize() > 0) {
            System.out.println("请输入商品id:");
            String sid = sc.nextLine();
            Goods good = data.getById(sid);
            if (good != null) {
                System.out.println("商品id\t名称\t\t\t单价\t\t\t计价单位");
                System.out.println(good);
            } else {
                System.out.println("ID为" + sid + "的商品还未上架！\r\n");
            }
        } else
            System.out.println("商店没有任何商品！\r\n");
    }
}
