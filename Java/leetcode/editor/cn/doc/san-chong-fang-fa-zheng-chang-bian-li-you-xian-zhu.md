

### 前言
正常做完此题之后，我猜想可能解法会有有限状态机，更让我想不到的是还有正则；因为之前不知道在那里看到过解决字符串模拟题的三个常规方法就包含有限状态机和正则表达式（...还有一个我忘记了，不知道是不是kmp）
所以希望借此题目，入有限状态机和正则的门，

**解法一.正常遍历**
根据题目思路，我们先去掉空格，然后判断是否有正负号，利用flag标记，最后开始匹配数字并将数字记录在ans里面，并结合flag返回值；时间复杂度O（n），空间复杂度O（1）
这里关于ans衍生出一个问题，如何处理越界问题：
1.如果ans可以是long型，比较temp-1>INT_MAX即可，如同我在C++和python语言所体现的
2.如果ans只能是int型，以结果为整数为列：如果有ans=ans*10+pop，则比较ans*10+pop>INT_MAX这里两边都不能溢出，**乘10累计都可能溢出，我们需要反向思考变除变减比较**，移项有
ans>(INT_MAX-pop)/10，但这个式子应该只在python中适用，因为他的除法是正常的，其他会向下取整，所以对于其他语言，可以对INT_MAX/10,再把pop单独拿出来讨论即可，如同我在java中体现的
```c++ []
class Solution {
public:
    int myAtoi(string str) {
        long  temp=0;
        int k=0;
        while(k<str.size()&&str[k]==' ')k++;
        int flag=1;
        if(str[k]=='-'){
            flag=-1;
            k++;
        }
       else if(str[k]=='+')k++;
        if('9'<str[k]||str[k]<'0')return 0;
        while(k<str.size()&&('0'<=str[k]&&str[k]<='9')){
            temp=temp*10+str[k]-'0';
           if(temp-1>INT_MAX)break;
//两个作用一是简单判断是否越界提前终止，二是可能测试数据会有大于long 型的数据
            k++;
        }
         temp=flag*temp;
         if(temp>INT_MAX)return INT_MAX;
         if(temp<INT_MIN)return INT_MIN;
       return temp;
        
    }
};
```
```python []
class Solution:
    def myAtoi(self, str: str) -> int:
        i=0
        n=len(str)
        while i<n and str[i]==' ':
            i=i+1
        if n==0 or i==n:
            return 0
        flag=1
        if str[i]=='-':
            flag=-1
        if str[i]=='+' or str[i]=='-':
            i=i+1
        INT_MAX=2**31-1
        INT_MIN=-2**31
        ans=0
        while i<n and '0'<=str[i]<='9':
            ans=ans*10+int(str[i])-int('0')
            i+=1
            if(ans-1>INT_MAX):
                break

        ans=ans*flag
        if ans>INT_MAX:
            return INT_MAX
        return INT_MIN if ans<INT_MIN else ans
```
```java []
class Solution {
    public int myAtoi(String str) {
        int i=0,n=str.length();
        while(i<n&&str.charAt(i)==' ')i++;
        if(i==n)return 0;
        int flag=1;
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            if(str.charAt(i)=='-')flag=-1;
            i++;
            }
        int ans=0;
        while(i<n&&Character.isDigit(str.charAt(i))) {
            int temp=str.charAt(i)-'0';
             if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7)))
                return Integer.MAX_VALUE ;
                //以正数为列，考虑稳大于和加temp才大于的情况
            if (flag == -1 && (ans > -(Integer.MIN_VALUE / 10) || (ans == -(Integer.MIN_VALUE / 10) && temp > 8)))
                return Integer.MIN_VALUE;
            ans=ans*10+temp;
            i++;
        }
          return ans*flag;
    }
}
```

**解法二.有限状态机**
在我理解正常遍历的方法只是适用于分支讨论较少的情况，不然代码就会显得很冗余，也很难思考。而有限状态机的关键在于我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题
在我理解看来，这种方法这要确定好了状态就可以解决复杂的字符串问题，无论是在题目改成要求找多组数字或者是加入其他判断条件
下面是官方图给的状态
![image.png](https://pic.leetcode-cn.com/509b1b235ec47cc6e25a145a759f834bb675c3f398ba4572fb2a6138fd78c001-image.png)
题目定义4中状态，每种状态遇到空格，符号，数字、其他又会转入不同的状态
![image.png](https://pic.leetcode-cn.com/5c5c950f9e2aa87bd2d8a50353470f7c3613d182b01bc7e0f22bd0cc2dce4f23-image.png)

集体代码实现我认为这个过程最好是看一遍代码，理解思想后自己实现我在c++中做了注释
其实这里的状态表定义可以不拘于形式，不一定是如官方那样清晰明了但耗费空间的定义，也可以是简单的一个二维数组（在java中可以看到），但是得写好注释，或者是其他方式。
```C++ []
class Automata{
        string state="start";
        unordered_map<string,vector<string>> table={
            {"start",{"start","sign","innum","end"}},
            {"sign",{"end","end","innum","end"}},
            {"innum",{"end","end","innum","end"}},
            {"end",{"end","end","end","end"}}
        };
        //定义状态表
        int get_s(char c){
            if(c==' ')return 0;
            if(c=='+'||c=='-')return 1;
            if(isdigit(c))return 2;
            return 3;
        }
        //将对应字符转化为数字，结合上一状态得到当前状态

        public:
        long long ans=0;
        int sign=1;

        void get(char c){
            state=table[state][get_s(c)];//根据当前状态的不同对数据进行处理
            if(state=="innum"){
                ans=ans*10+c-'0';
               ans= sign==1 ? min(ans,(long long)INT_MAX): min(ans,-(long long)INT_MIN);
            }
            else if(state=="sign"){
                if(c=='-')sign=-1;
            }
        }
};

class Solution {
public:
    int myAtoi(string str) {
        Automata dfa;
        for(char c:str)
        dfa.get(c);
        return dfa.sign*dfa.ans;     
    }
};
```
```python []
INT_MAX=2**31-1
INT_MIN=-2**31

class Automata:
    def _init_(self):
        self.state="start"
        self.ans=0
        self.sign=1
        self.table={
            "start":["start","sign","innum","end"],
            "sign":["end","end","innum","end"],
            "innum":["end","end","innum","end"],
            "end":["end","end","end","end"],
        }
    def get_s(self,c):
        if c.isspace():
            return 0
        if c=='+' or c=='-':
            return 1
        if c.isdigit():
            return 2
        return 3

    def get(self,c):
        self.state=self.table[self.state][self.get_s(c)]
        if self.state=="innum":
            self.ans=self.ans*10+int(c)
            self.ans= min(self.ans,INT_MAX) if self.sign==1 else min(self.ans,-INT_MIN)
        if self.state=="sign":
            if c=='-':
                sign=-1


class Solution:
    def myAtoi(self, str: str) -> int:
        Auto=Automata()
        for c in str:
            Auto.get(c)
        return Auto.ans*Auto.sign
```
```java []
class Automata{
    private int state=0;
    private int[][] table={{0,1,2,3},{3,3,2,3},{3,3,2,3},{3,3,3,3}};
    long ans=0;
    int sign=1;

    public int gets(char c){
        if(c==' ')return 0;
        if(c=='+'||c=='-')return 1;
        if(Character.isDigit(c))return 2;
        return 3;
    }

    public void get(char c){
        state=table[state][gets(c)];
        if(state==2){
            ans=ans*10+(c-'0');
            ans= sign==1 ? Math.min(ans,Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);
        }
        if(state==1&&c=='-')sign=-1;
    }

}

class Solution {
    public int myAtoi(String str) {
        Automata auto=new Automata();
        char[] temp=str.toCharArray();
        for(char c:temp)
        auto.get(c);

        return auto.sign*(int)auto.ans;
    }
}
```

**解法3.正则表达式**
正则表达式通常被用来测试字符串内的模式、替换那些符合某个模式的文本、基于模式匹配从字符串中提取子字符串。
对于本题，这里我们如果应用正则表达式把数字那一串提取出来再进行处理就简单多了
下面是关于正则表达式的学习网站
[https://www.runoob.com/regexp/regexp-tutorial.html](https://www.runoob.com/regexp/regexp-tutorial.html)
由于我学习之后在这个网站没有找到C++的正则应用，就容我偷个赖，日后有机会再补充吧
这里的学习以理解思路，多练习为好

```java []
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;
class Solution {
    public int myAtoi(String str) {
        String pattern = "^\\s*([+-]?\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        if (!m.find( ))  return 0;
        
        BigInteger ans = new BigInteger(m.group(1));
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0){
            return Integer.MIN_VALUE;
        }
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0){
            return Integer.MAX_VALUE;
        }
        return ans.intValue();
        
    }
}
```
```python []
class Solution:
    def myAtoi(self, str: str) -> int:
        import re
        mathes=re.match('[ ]*([+-]?\d+)',str)
        if not mathes:
            return 0
        ans=int(mathes.group(1))
        return min(max(ans,-2**31),2**31-1)
```
```c++待补充 []
puts 'Hello world!'
```




总结：感觉这道题还是很有收获的，特别是关于有限状态机和正则的学习，算是为我打开了大门