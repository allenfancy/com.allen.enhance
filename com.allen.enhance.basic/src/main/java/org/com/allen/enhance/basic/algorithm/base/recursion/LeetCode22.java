package org.com.allen.enhance.basic.algorithm.base.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author allen
 */
public class LeetCode22 {
    private List<String> res = new ArrayList<>();

    private List<String> generateParenthesis(int n) {
        bracketsGenerate(0, 0, n, "");
        return res;
    }

    private void bracketsGenerate(int left, int rigth, int n, String s) {
        if (left == n && rigth == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            bracketsGenerate(left + 1, rigth, n, s + "(");
        }
        if (left > rigth) {
            bracketsGenerate(left, rigth + 1, n, s + ")");
        }
    }


    public static void main(String[] args) {
        LeetCode22 lc = new LeetCode22();
        lc.generateParenthesis(3);
    }
}
