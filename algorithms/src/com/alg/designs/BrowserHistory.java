package com.alg.designs;

import com.java.se.inheritancePolymorphism.question9.B;

import java.util.Stack;

class BrowserHistory {

    private Stack<String> backwardHistory;
    private Stack<String> forwardHistory;
    String currentUrl;

    public BrowserHistory(String homepage) {
        backwardHistory = new Stack();
        forwardHistory = new Stack();
        backwardHistory.push(homepage);
        currentUrl = homepage;
    }

    public void visit(String url) {
        backwardHistory.push(currentUrl);
        currentUrl = url;
        forwardHistory.clear();
    }

    public String back(int steps) {
        String previousUrl = "";
        if(backwardHistory.isEmpty()) return "";
        while (steps > 0 && !backwardHistory.isEmpty()) {
            previousUrl = backwardHistory.pop();
            forwardHistory.push(currentUrl);
            currentUrl = previousUrl;
            steps--;
        }

        return previousUrl;
    }

    public String forward(int steps) {
        String previousUrl = "";
        if(forwardHistory.isEmpty()) return currentUrl;
        while (steps > 0 && !forwardHistory.isEmpty()) {
            previousUrl = forwardHistory.pop();
            backwardHistory.push(currentUrl);
            currentUrl = previousUrl;
            steps--;
        }
        return previousUrl;
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("leetcode.com");
        browser.visit("google");
        browser.visit("facebook");
        browser.visit("youtube");
        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));
        browser.visit("linkedin");
        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.back(7));
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
