package com.alg.designs;

import com.java.se.inheritancePolymorphism.question9.B;

import java.util.Stack;
/*
It is easy to simply implement it with IDE and debug tools, but what is important here is, you need to
have show interviewer on what edge cases need to be handled, and how each function interact with each
other, and what is the design in the bigger picture. If I simply go ahead and implement it without

First, this is a stateful object. Each action will result the object in a different state.
back() and forward() functions are supposed to keep track on the state of the object to a certain extent.
The user will generate a list of historical urls, and with those functions we can go back/forth in this
 linear list of urls: a - b - c - d ... on both directions. The transition in BOTH directions and careful
 management of state is the key point og this problem. My approach is to keep a 'current' url, a 'left/past'
 url stack and a 'right/ahead' url stack as additional data structure to store those states.

 Second, these functions can go multiple steps at a time based on input integer. If input is more than
 the length of historical urls, simply return the last url in the list in given direction.

 Additional notes: if user visit() another url after back(), all history in previous 'ahead' stack will
 be wiped out.
 The initialization of browser should populate 'current' url.
 */


class BrowserHistory {
    private Stack<String> backwardHistory;
    private Stack<String> forwardHistory;
    String currentUrl;

    public BrowserHistory(String homepage) {
        backwardHistory = new Stack();
        forwardHistory = new Stack();
        currentUrl = homepage;
    }

    public void visit(String url) {
        backwardHistory.push(currentUrl);
        currentUrl = url;
        forwardHistory.clear();
    }

    public String back(int steps) {
        if(backwardHistory.isEmpty()) return currentUrl;
        String previousUrl = "";
        while (steps > 0 && !backwardHistory.isEmpty()) {
            previousUrl = backwardHistory.pop();
            forwardHistory.push(currentUrl);
            currentUrl = previousUrl;
            steps--;
        }
        return previousUrl;
    }

    public String forward(int steps) {
        if(forwardHistory.isEmpty()) return currentUrl;
        String previousUrl = "";
        while (steps > 0 && !forwardHistory.isEmpty()) {
            previousUrl = forwardHistory.pop();
            backwardHistory.push(currentUrl);
            currentUrl = previousUrl;
            steps--;
        }
        return previousUrl;
    }

    public static void main(String[] args) {
//        BrowserHistory browser = new BrowserHistory("leetcode.com");
//        browser.visit("google");
//        browser.visit("facebook");
//        browser.visit("youtube");
//        System.out.println(browser.back(1));
//        System.out.println(browser.back(1));
//        System.out.println(browser.forward(1));
//        browser.visit("linkedin");
//        System.out.println(browser.forward(2));
//        System.out.println(browser.back(2));
//        System.out.println(browser.back(7));

//        BrowserHistory browser = new BrowserHistory("vvlf.com");
//        browser.visit("rwrjffk.com");
//        System.out.println(browser.back(9));
//        System.out.println(browser.back(6));
//        System.out.println(browser.forward(7));
//        System.out.println(browser.forward(5));
//        browser.visit("af.com");
//        browser.visit("jjuulz");
//        browser.visit("vq");
//        browser.visit("viw");
//        System.out.println(browser.back(3));
//        browser.visit("wg.com");
//        System.out.println(browser.forward(9));
//        System.out.println(browser.back(6));
//        System.out.println(browser.back(4));
//        System.out.println(browser.forward(2));

        BrowserHistory browser = new BrowserHistory("a.com");
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
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
