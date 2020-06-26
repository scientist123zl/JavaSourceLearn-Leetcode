package cn.scientist123zl.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.26 括号生成
 * 递归
 */
public class A22_generate_parentheses {

    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
        _generate(result, 0, 0, n, "");
        return result;
    }

    private void _generate(List<String> result, int left, int right, int n, String s) {
        //terminator
        if(left == n && right == n) {
            result.add(s);
            return ;
        }
        //drill down
        if(left < n) {
            _generate(result,left + 1, right, n,s + "(");
        }
        if(left > right) {
            _generate(result, left, right + 1, n, s + ")");
        }

        //reverse state
    }

    public static void main(String[] args) {
        A22_generate_parentheses test = new A22_generate_parentheses();
        System.out.println(test.generateParenthesis(3));
    }
}
