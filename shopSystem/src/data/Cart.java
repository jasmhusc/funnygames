package data;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import goods.Goods;

public class Cart {
    private HashMap<String, Integer> cart;
    private Shop shop;

    public Cart(Shop shop) {
        cart = new HashMap<>();
        this.shop = shop;
    }

    public void add(String word, int num) {
        if (isExist(word)) {
            Integer origin = cart.get(word);
            num += origin;
        }
        cart.put(word, num);
    }

    public void showCart() throws IOException {
        System.out.println("---------------------------");
        System.out.println("\t\t欢迎光临");
        System.out.println("名称id\t\t售价\t\t数量\t\t金额");
        Set<String> keys = cart.keySet();
        int sum = 0;
        double money = 0;
        for (String key : keys) {
            Goods goods = shop.getById(key);
            int num = cart.get(key);
            if (goods != null) {
                String name = goods.getName();
                double price = goods.getPrice();
                double pay = num * price;
                System.out.println(name + "\t\t" + price + "\t" + num + "\t\t" + pay);
                sum += num;
                money += pay;
            }
        }
        System.out.println("---------------------------");
        System.out.println(cart.size() + "项商品");
        System.out.println("共计:" + sum + "件");
        System.out.println("共:" + money + "元");
        System.out.println("---------------------------");
    }

    public boolean isExist(String id) {
        boolean flag = false;
        if (id != null) {
            for (String goodsId : cart.keySet()) {
                if (id.equals(goodsId)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
