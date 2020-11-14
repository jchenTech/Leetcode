class Solution {
public:
    bool isValid(string s) {
        if(s.length()%2!=0) return false;//һ��������˵��������Ч������
        map<char,char> wordbook;//������ϣ��
        wordbook.insert(map<char,char>::value_type(')','('));
        wordbook.insert(map<char,char>::value_type(']','['));
        wordbook.insert(map<char,char>::value_type('}','{'));
        stack<char> mystack;//����ջ
        for(int i=0;i<s.length();i++)
        {
            if(s[i]=='['||s[i]=='{'||s[i]=='(')//ƥ�䵽������
                mystack.push(s[i]);//����ջ��
            else if(s[i]==']'||s[i]=='}'||s[i]==')')//ƥ�䵽������
            {
                if(mystack.empty()) return false;
                //ƥ�䵽�����ţ�ջ��Ӧ�ô��������š����������Ч������
                if(wordbook[s[i]]==mystack.top())//��ջ��Ԫ�ؽ���ƥ��
                {
                    mystack.pop();//ƥ��ɹ�ɾ��ջ��Ԫ��
                    continue;
                }
                else return false;
            }
        }
        if(mystack.empty()) return true;//��Ч�����ŵ���������ջ��Ӧû��Ԫ��
        else return false;
    }
};