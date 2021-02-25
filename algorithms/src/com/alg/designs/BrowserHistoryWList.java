package com.alg.designs;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BrowserHistoryWList {
    private List<String> history = new ArrayList();
    int pos = -1;

    public BrowserHistoryWList(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        history.subList(pos + 1, history.size()).clear();
        history.add(url);
        pos++;
    }

    public String back(int steps) {
        pos = Math.max(pos - steps, 0);
        return history.get(pos);
    }

    /**
     * This version of code cannot pass leetcode. I don';'t have a damn clue about why
     * @param steps
     * @return
     */
    public String backB(int steps) {
        if(steps > pos) {
            pos = 0;
            return history.get(pos);
        }
        pos = pos - steps;
        return history.get(pos);
    }

    public String forward(int steps) {
        pos = Math.min(pos + steps, history.size()-1);
        return history.get(pos);
    }

    public static void main(String[] args) {
        BrowserHistoryWList browser = new BrowserHistoryWList("a.com");
        browser.visit("b.com");
        System.out.println(browser.back(9));
        System.out.println(browser.back(6));
        System.out.println(browser.forward(7));
        System.out.println(browser.forward(5));
        browser.visit("c.com");
        browser.visit("d");
        browser.visit("e");
        browser.visit("f");
        System.out.println(browser.back(3));
        browser.visit("g.com");
        System.out.println(browser.forward(9));
        System.out.println(browser.back(6));
        System.out.println(browser.back(4));
        System.out.println(browser.forward(2));

        System.out.println("-------------");
        browser.pos= 3;
        System.out.println(" BackA: " +browser.back(5) + " pos:" + browser.pos);
        browser.pos= 3;
        System.out.println(" BackB: " +browser.backB(5) + " pos:" + browser.pos);

        browser.pos= 5;
        System.out.println(" BackA: " +browser.back(5) + " pos:" + browser.pos);
        browser.pos= 5;
        System.out.println(" BackB: " +browser.backB(5) + " pos:" + browser.pos);

        browser.pos= 7;
        System.out.println(" BackA: " +browser.back(5) + " pos:" + browser.pos);
        browser.pos= 7;
        System.out.println(" BackB: " +browser.backB(5) + " pos:" + browser.pos);
    }
}
