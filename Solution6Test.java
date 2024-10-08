// -*- coding: utf-8 -*-

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 *
 *               给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i
 *               名用户收藏的公司清单（下标从 0 开始）。
 *
 *               请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 *
 *
 *               示例 1：
 *
 *               输入：favoriteCompanies =
 *               [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 *               输出：[0,1,4]
 *               解释：
 *               favoriteCompanies[2]=["google","facebook"] 是
 *               favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 *               favoriteCompanies[3]=["google"] 是
 *               favoriteCompanies[0]=["leetcode","google","facebook"] 和
 *               favoriteCompanies[1]=["google","microsoft"] 的子集。
 *               其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 *               示例 2：
 *
 *               输入：favoriteCompanies =
 *               [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 *               输出：[0,1]
 *               解释：favoriteCompanies[2]=["facebook","google"] 是
 *               favoriteCompanies[0]=["leetcode","google","facebook"]
 *               的子集，因此，答案为 [0,1] 。
 *               示例 3：
 *
 *               输入：favoriteCompanies =
 *               [["leetcode"],["google"],["facebook"],["amazon"]]
 *               输出：[0,1,2,3]
 *
 *
 *               提示：
 *
 *               1 <= favoriteCompanies.length <= 100
 *               1 <= favoriteCompanies[i].length <= 500
 *               1 <= favoriteCompanies[i][j].length <= 20
 *               favoriteCompanies[i] 中的所有字符串 各不相同 。
 *               用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] !=
 *               favoriteCompanies[j] 仍然成立。
 *               所有字符串仅包含小写英文字母。
 *
 */

class Solution6 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            boolean isSub = false;
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                if (isSubset(favoriteCompanies.get(i), favoriteCompanies.get(j))) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean isSubset(List<String> a, List<String> b) {
        Set<String> setA = new HashSet<>(a);
        for (String item : b) {
            if (!setA.contains(item)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution6Test {
    @Test
    public void testPeopleIndexes() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies1 = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon"));
        List<Integer> expected1 = Arrays.asList(0, 1, 4);
        assertEquals(expected1, solution.peopleIndexes(favoriteCompanies1));

        List<List<String>> favoriteCompanies2 = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "amazon"),
                Arrays.asList("facebook", "google"));
        List<Integer> expected2 = Arrays.asList(0, 1);
        assertEquals(expected2, solution.peopleIndexes(favoriteCompanies2));

        List<List<String>> favoriteCompanies3 = Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("google"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon"));
        List<Integer> expected3 = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected3, solution.peopleIndexes(favoriteCompanies3));
    }
}