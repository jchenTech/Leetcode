/** ����������������ķ������ַ���ͷ���������ĸ�������еݹ�����
* ��Խ����ַ���ƥ��ʱ������ʧ�ܣ����ɹ��ѵ����ַ����ַ����������ʱ������ȷ��
* �ڴ˹����У����ѷ��ʹ����ַ��޸ı����ظ����ʣ��ڵݹ���ٸĻ���
*/
class Solution {
    int m; //��������
    int n; //��������
    int length; //�����ַ�������
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        char[] words = word.toCharArray();
        length = words.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //��ѭ�������ҵ����ַ������ַ�ƥ�䣬�������������
                if (board[i][j] == words[0] && dfs(board, words, i, j, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int x, int y, int index) {
        //��ǰԪ�ص���������Ԫ������ʧ��������1.������������ 2.û����words����һ���ַ�ƥ��
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || board[x][y] != words[index]) {
            return false;
        }
        
        //�������ַ����е��ַ���������ɺ󣬷�����ȷ
        if (index == length -1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '#'; //��ʾ�ѷ��ʹ����ַ�

        boolean ans = dfs(board, words, x + 1, y, index + 1) ||  //��
        dfs(board, words, x, y + 1, index + 1) ||                //��
        dfs(board, words, x - 1, y, index + 1) ||               //��
        dfs(board, words, x, y - 1, index + 1);                 //��

        board[x][y] = temp;

        return ans;
    }
}