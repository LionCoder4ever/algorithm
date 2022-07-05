#include<queue>
/*
 * @lc app=leetcode.cn id=347 lang=cpp
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        struct cmp {
            bool operator() (pair<int, int>& p1, pair<int,int>& p2) {
                return p1.second > p2.second;
            }
        };

        priority_queue<pair<int,int>, vector<pair<int, int>>, cmp> q;
        unordered_map<int, int> map;
        for (auto i: nums) {
            map[i]++;
        }

        for(auto i: map) {
            if (q.size() < k) {
                q.emplace(make_pair(i.first, i.second));
            } else {
                if (q.top().second < i.second) {
                    q.pop();
                    q.emplace(make_pair(i.first, i.second));
                }
            }
        }

        vector<int> ans;
        while(q.size()) {
            ans.emplace(ans.begin(), q.top().first);
            q.pop();
        }
        return ans;
    }
};
// @lc code=end

