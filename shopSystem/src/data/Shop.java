package data;

import goods.Goods;
import java.io.*;
import java.util.ArrayList;

public class Shop {
    private File fileName;
    private ArrayList<Goods> list;

    public Shop() {
        fileName = new File("goods.txt");
        list = new ArrayList<>();
    }

    public int getSize() {
        return list.size();
    }

    public boolean add(Goods g) throws IOException {
        boolean ret = false;
        if (g != null) {
            list.add(g);
            ret = true;
            System.out.println("添加成功!\r\n");
        }
        writreData();
        return ret;
    }

    public void remove(String id) throws IOException {
        Goods bn = getById(id);
        if (bn != null) {
            list.remove(bn);
            System.out.println("删除成功!\r\n");
            writreData();
        } else
            System.out.println("该商品不存在.\r\n");
    }

    public void set(String id, String name, double price, String unit) throws IOException {
        Goods bn = getById(id);
        if (bn != null) {
            bn.setId(id);
            bn.setName(name);
            bn.setPrice(price);
            bn.setUnit(unit);
            System.out.println("ID为" + id + "的商品信息已更新!\r\n");
            writreData();
        } else
            System.out.println("该商品不存在.\r\n");
    }

    public Goods getById(String id) throws IOException {
        list.clear();
        readData();
        Goods ret = null;
        for (Goods good : list) {
            String sid = good.getId();
            if (id.equals(sid))
                ret = good;
        }
        return ret;
    }

    public void showGoods() throws IOException {
        list.clear();
        // 先读一读
        readData();
        //判断集合中是否有数据，如果没有显示提示信息
        if (list == null || list.size() == 0) {
            System.out.println("无商品信息，请先添加再查询");
            //方法结束
            return;
        }

        //显示表头信息
        //\t其实是一个tab键的位置
        System.out.println("-----------------------------------");
        System.out.println("\t\t\t商品列表");
        System.out.println("商品id\t名称\t\t\t单价\t\t\t计价单位");
        for (Goods goods : list) {
            System.out.println(goods.getId() + "\t\t" + goods.getName() + "\t\t" + goods.getPrice() + "\t\t  " + goods.getUnit());
        }
        System.out.println("-----------------------------------");
    }

    public void clear() {
        list.clear();
        System.out.println("清仓成功!\r\n");
    }

    public boolean isExist(String id) throws IOException {
        if (getById(id) != null)
            return true;
        return false;
    }

    public void readData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            Goods s = new Goods(str[0], str[1], Double.parseDouble(str[2]), str[3]);
            list.add(s);
        }
        br.close();
    }

    public void writreData() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (Goods s : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getId()).append(",")
                    .append(s.getName()).append(",")
                    .append(s.getPrice()).append(",")
                    .append(s.getUnit());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
