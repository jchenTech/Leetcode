class Solution {
    /*
     * �ֵ��еĵ��ʺͿ�ʼ�������ʿ��Գ���Ϊͼ�еĽڵ㣬����֮����Ըı�һ����ĸ
     * ����ת��Ŀ�����ͼ�н������ߣ���ʱ��Ŀ����ת��Ϊ��ͼ�п�ʼ���ʵ��������ʵ����·��
     * ͨ��������Ƚ�������Ѱ�����·��
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // �� 1 �����Ƚ� wordList �ŵ���ϣ��������ж�ĳ�������Ƿ��� wordList ��
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // �� 2 ����ͼ�Ĺ�����ȱ���������ʹ�ö��кͱ�ʾ�Ƿ���ʹ��� visited ��ϣ��
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // �� 3 ������ʼ������ȱ�����������㣬��˳�ʼ����ʱ����Ϊ 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++) {
                // ���α�����ǰ�����еĵ���
                String currentWord = queue.poll();
                // ��� currentWord �ܹ��޸� 1 ���ַ��� endWord ��ͬ���򷵻� step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }


    /*
     * ���Զ� currentWord �޸�ÿһ���ַ��������ǲ������� endWord ƥ��
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                            Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            //�ȱ��棬Ȼ��ָ�
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }

                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // ע�⣺��ӵ������Ժ󣬱������ϱ��Ϊ�Ѿ�����
                        visited.add(nextWord);
                    }
                }
            }
            //�ָ�
            charArray[i] = originChar;
        }
        return false;
    }
}