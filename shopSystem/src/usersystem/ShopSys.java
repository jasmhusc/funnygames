package usersystem;

import data.Cart;
import data.Shop;
import goods.Goods;

import java.io.IOException;
import java.util.Scanner;

public class ShopSys {

    private static Shop shop;
    private static Cart cart;
    private static Scanner sc;

    public ShopSys() throws IOException {
        shop = new Shop();
//        addGoods();
        cart = new Cart(shop);
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) throws IOException {
        ShopSys sys = new ShopSys();
        sys.showWelcome();
        sys.start();
    }

    private void start() throws IOException {
        LOOP:
        while (true) {
            showPrompt();
            String s = sc.nextLine();
            switch (s) {
                case "1":
                    shop.showGoods();
                    buyGoods();
                    break;
                case "2":
                    cart.showCart();
                    break;
                case "3":
                    System.out.println("感谢您使用超市购物系统，欢迎下次光临，拜拜！");
                    break LOOP;
                default:
                    System.out.println("错误命令，请重新输入：");
            }
        }
    }

    private void buyGoods() throws IOException {
        System.out.println("请输入你要购买的商品项(输入格式:商品id-购买数量)，输入end表示购买结束。");
        while (true) {
            String str = sc.nextLine();
            if ("end".equals(str))
                break;
            String[] words = str.split("-");
            if (words != null && words.length > 1) {
                String word = words[0];
                if (shop.isExist(word)) {
                    String s = words[1];
                    try {
                        Integer num = Integer.parseInt(s);
                        cart.add(word, num);
                    } catch (Exception e) {
                        System.out.println("数量格式错误(整数)，请再来一次！");
                    }
                } else {
                    System.out.println("你输入的商品id不存在，请重新输入！");
                }
            } else {
                System.out.println("你输入的购买姿势不对，请换个姿势再来一次(格式:商品id-购买数量)");
            }
        }
    }

    private void showWelcome() {
        System.out.println("\t\t欢迎使用超市购物系统");
    }

    private void showPrompt() {
        System.out.println("请输入你要进行的操作：");
        System.out.println("1:购买商品\t2:结算并打印小票\t3:退出系统");
    }
/*
    private void addGoods() throws IOException {
        shop.add(new Goods("001", "少林核桃", 15.5, "斤"));
        shop.add(new Goods("002", "尚康饼干", 14.5, "包"));
        shop.add(new Goods("003", "移动硬盘", 345.0, "个"));
        shop.add(new Goods("004", "高清无码", 199.0, "G"));
    }*/
}
