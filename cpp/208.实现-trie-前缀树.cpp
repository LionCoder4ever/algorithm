/*
 * @lc app=leetcode.cn id=208 lang=cpp
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
public:
    Trie(): root_(new TrieNode()) {}
    
    void insert(const string word) {
        TrieNode *p = root_.get();
        for (char c: word) {
            if (!p->children[c-'a']) {
                p->children[c-'a'] = new TrieNode();
            }
            p = p->children[c-'a'];
        }
        p->is_word = true;
    }
    
    bool search(string word) {
        TrieNode *p = find(word);
        return p && p->is_word;

    }
    
    bool startsWith(string prefix) {
        return find(prefix) != NULL;
    }


private:
    struct TrieNode
    {
        TrieNode(): is_word(false), children(26, NULL){};

        ~TrieNode() {
            for(TrieNode* child: children) {
                if (child) delete child;
            }
        }
        // 是否是完整单词
        bool is_word;
        vector<TrieNode*> children;
    };

    TrieNode* find(const string& prefix) {
        TrieNode *p = root_.get();
        for(const char c: prefix) {
            p = p->children[c-'a'];
            if (p == NULL) break;
        }
        return p;
    }

    std::unique_ptr<TrieNode> root_;
};


/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
// @lc code=end

