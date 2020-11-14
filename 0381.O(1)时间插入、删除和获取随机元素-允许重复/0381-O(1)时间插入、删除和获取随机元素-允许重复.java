/**
 * O(1)ʱ��Ҫʵ�ֵĹ����У�
 * 1. �򼯺��в���Ԫ��val�������������ʹ��listʵ�֣�ֱ�Ӳ��뵽β��
 * 2. ��val����ʱ���Ӽ������Ƴ�һ��val����ô��Ҫ��鼯�����Ƿ���Ԫ�أ���O(1)����
 * ʵ�ָù��ܵ���list(ArrayListͨ����������)�Լ�HashMap(index, val)���������ڼ����ǿ��ظ���
 * ���������޷���֪Ҫ����Ԫ�ص������������ҪArrayList+HashMap(val, index)��
 *
 * list��ɾ��Ԫ��ֻ��ɾ��βԪ��ʱʱ�临�ӶȲ���O(1)��˽�ɾ��Ԫ�غ�βԪ�ػ�����ɾ��
 *
 * ���ǵ������е�Ԫ���ǿ��ظ��ģ����һ��ֵ���ܶ�Ӧ�������index����˿���ǰ���ɾ���ͽ�������ʱ
 * Ҳ��Ը��������в�������˲���set�洢val��Ӧ��index
 *
 * 3. �����Ը��������ȡһ��Ԫ�ء���list.get(Math.Random()*list.size())����
 */

class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //1.�б����valԪ��
        list.add(val);
        //2.��val��Ӧ��������������ǰlist���һλ��ӵ�Set��
        Set<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
        set.add(list.size() - 1);
        map.put(val, set);
        //3.���set��size������1����˵�������ظ�Ԫ�أ��򷵻�false������true
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //1. ����ɾ��Ԫ�غ�list���һλԪ��
        Set setOfVal = map.get(val);
        Set setOfLast = map.get(list.get(list.size() - 1));
        int indexOfVal = (int) setOfVal.iterator().next();
        int indexOfLast = list.size() - 1;
        swap(list, indexOfVal, indexOfLast);

        //2.listɾ���ѻ�λ�����һλԪ��
        list.remove(list.size() - 1);

        //3.setOfValɾ��indexOfVal��setOfLast��indexOfVal�滻indexOfLast
        setOfVal.remove(indexOfVal);
        if(setOfVal.size() == 0){
            map.remove(val);//��ͼ��ɾ��
        }
        setOfLast.add(indexOfVal);
        setOfLast.remove(indexOfLast);
        return true;
    }

    private void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, tmp);
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */