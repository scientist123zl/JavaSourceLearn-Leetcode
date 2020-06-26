package cn.scientist123zl.test.leetcode;

import java.util.*;

/**
 * 5.30 单词接龙
 * DFS、双向BFS
 */
public class A127_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int count = 0;
        //Set<String> visited = new HashSet<>();
        //visited.add(beginWord);

        // visited修改为boolean数组
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);


        while (!queue.isEmpty()) {
            int size = queue.size();
            ++count;
//            for (int i = 0; i < size; ++i) {
//                String start = queue.poll();
//                for (String s : wordList) {
//                    // 已经遍历的不再重复遍历
//                    if (visited.contains(s)) {
//                        continue;
//                    }
//                    // 不能转换的直接跳过
//                    if (!canConvert(start, s)) {
//                        continue;
//                    }
//                    // 用于调试
//                    // System.out.println(count + ": " + start + "->" + s);
//                    // 可以转换，并且能转换成endWord，则返回count
//                    if (s.equals(endWord)) {
//                        return count + 1;
//                    }
//                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
//                    visited.add(s);
//                    queue.offer(s);
//                }
//            }
            while(size-- > 0) {
                String start = queue.poll();
                for(int i = 0; i < wordList.size(); ++i) {
                    // 通过index判断是否已经访问
                    if (visited[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        A127_word_ladder a = new A127_word_ladder();
        System.out.println(a.ladderLength("hit","cog",
                new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList__) {
        if (!wordList__.contains(endWord)) {
            return 0;
        }
        Set<String> wordList = new HashSet<String>(wordList__);
        Set<String> beginSet = new HashSet<String>(),
                endSet = new HashSet<String>();

        int len = 1;
        int strlen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for(String word : beginSet) {
                char[] chs = word.toCharArray();
                for(int i = 0; i < chs.length; i++) {
                    for(char c = 'a'; c<= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if(endSet.contains(target)) {
                            return len + 1;
                        }
                        if(!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
