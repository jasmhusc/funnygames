package shopsystem;

import data.Shop;
import handler.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ManageSysPro {
    private Shop data = new Shop();
    private HashMap<String, Handler> handlers = new HashMap<>();

    public ManageSysPro() {
        handlers.put("add", new HandlerAdd(data));
        handlers.put("modify", new HandlerModify(data));
        handlers.put("drop", new HandlerDrop(data));
        handlers.put("query", new HandlerQuery(data));
        handlers.put("list", new HandlerList(data));
        handlers.put("clear", new HandlerClear(data));
        handlers.put("bye", new HandlerBye(data));
        handlers.put("help", new HandlerHelp(data));
    }

    public static void main(String[] args) throws IOException {
        ManageSysPro sysPro = new ManageSysPro();
        sysPro.showWelcome();
        sysPro.Run();
        System.out.println("感谢您对我们的支持，欢迎再次到访。");
    }

    private void Run() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 接收用户输入命令
            ShowPromt();
            String words;
            words = sc.nextLine();
            Handler handler = handlers.get(words);
            if (handler != null) {
                if (handler.isBye()) {
                    handler.doCmd();
                    break;
                }
                handler.doCmd();
            }
        }
    }

    private void showWelcome() {
        System.out.println("欢迎光临！");
        System.out.println("商品货物管理系统真诚为您服务!\r\n");
        System.out.println("请输入命令，如：add--添加商品信息 !");
        System.out.println("如需要帮助，请输入：help");
        System.out.println("\r\n");
    }

    private void ShowPromt() {
        System.out.println("等待命令...");
    }
}
