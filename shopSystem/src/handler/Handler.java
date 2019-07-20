package handler;

import data.Shop;

import java.io.IOException;
import java.util.Scanner;

public abstract class Handler {
    protected Scanner sc = new Scanner(System.in);
    protected Shop data;

    public Handler(Shop data) {
        this.data = data;
    }

    public void doCmd() throws IOException {
    }

    public boolean isBye() {
        return false;
    }
}
