/*
 * @lc app=leetcode.cn id=207 lang=cpp
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // bfs

        // key:课程号 value: 课程号出度指向的其他课程数组
        unordered_map<int, vector<int>> map;

        // 课程号的入度总数
        vector<int> indeg(numCourses);

        int ans = 0;
        for(int i=0;i<prerequisites.size();i++) {
            auto curse = prerequisites[i];
            map[curse[1]].push_back(curse[0]);
            indeg[curse[0]] += 1;
        }
        queue<int> q;

        // 先找出入度为0的作为开始
        for(int i=0;i<indeg.size();i++) {
            if(indeg[i] == 0) {
                q.push(i);
            }
        }
        while(q.size() !=0) {
            // 学完的课程
            int u = q.front();
            q.pop();
            ans ++;

            // 开始计算, 这门课出度指向的课程, 是否可以学完
            for (int i=0;i<map[u].size();i++) {
                int v = map[u][i];
                indeg[v]-=1;
                if (indeg[v] ==0) {
                    // 出度指向的课程如果也可以学完, 把这门课放入队列, 计算这门课出度指向的课程
                    q.push(v);
                }
            }
        }
        return ans == numCourses;
    }
};
// @lc code=end

