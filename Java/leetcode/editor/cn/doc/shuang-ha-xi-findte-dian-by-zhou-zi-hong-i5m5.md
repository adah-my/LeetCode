### 解题思路
此处撰写解题思路
```
//对应下标
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.size()!=t.size())return false;
        unordered_map<char,char>mp1,mp2;
        for(int i=0;i<s.size();i++){
            if(!mp1[s[i]])mp1[s[i]]=i+1;
            if(!mp2[t[i]])mp2[t[i]]=i+1;
            if(mp1[s[i]]!=mp2[t[i]])return false;
        }
        return true;
    }
};
```

### 代码
```
//双向映射，只有单向不行是因为aabc，ccde，两个a都映射c，则可能是cdde而不是ccde
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.size()!=t.size())return false;
        unordered_map<char,char>mp1,mp2;
        for(int i=0;i<s.size();i++){
            if(!mp1[s[i]])mp1[s[i]]=t[i];
            else if(mp1[s[i]]!=t[i])return false;
            if(!mp2[t[i]])mp2[t[i]]=s[i];
            else if(mp2[t[i]]!=s[i])return false;
        }
        return true;
    }
};
```

```cpp
class Solution {
public:
    bool isIsomorphic(string s, string t) 
    {
        if(s.empty()&&t.empty())
            return true;
        if(s.empty()||t.empty())
            return false;
        if(s.size()!=t.size())
            return false;       
        for(int i=0;i<s.size();i++)
        {
          if( s.find(s[i])!=t.find(t[i]))//哈希思想，如果abb第二次找b时返回1而不会返回2，相当于keyb的value是1
          return false;
        }
        return true;
       
    }
};
```