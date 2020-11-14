/**
 * O(1)时间要实现的功能有：
 * 1. 向集合中插入元素val，插入操作可以使用list实现，直接插入到尾部
 * 2. 当val存在时，从集合中移除一个val，那么就要检查集合中是否含有元素，在O(1)内能
 * 实现该功能的有list(ArrayList通过索引查找)以及HashMap(index, val)，但是由于集合是可重复的
 * 并且我们无法得知要查找元素的索引，因此需要ArrayList+HashMap(val, index)。
 *
 * list中删除元素只有删除尾元素时时间复杂度才是O(1)因此将删除元素和尾元素互换再删除
 *
 * 考虑到集合中的元素是可重复的，因此一个值可能对应多个索引index，因此考虑前面的删除和交换操作时
 * 也会对该索引进行操作，因此采用set存储val对应的index
 *
 * 3. 以线性概率随机获取一个元素。用list.get(Math.Random()*list.size())方法
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
        //1.列表添加val元素
        list.add(val);
        //2.将val对应的索引——即当前list最后一位添加到Set中
        Set<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
        set.add(list.size() - 1);
        map.put(val, set);
        //3.如果set的size不等于1，则说明存在重复元素，则返回false，否则true
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //1. 交换删除元素和list最后一位元素
        Set setOfVal = map.get(val);
        Set setOfLast = map.get(list.get(list.size() - 1));
        int indexOfVal = (int) setOfVal.iterator().next();
        int indexOfLast = list.size() - 1;
        swap(list, indexOfVal, indexOfLast);

        //2.list删除已换位的最后一位元素
        list.remove(list.size() - 1);

        //3.setOfVal删除indexOfVal，setOfLast用indexOfVal替换indexOfLast
        setOfVal.remove(indexOfVal);
        if(setOfVal.size() == 0){
            map.remove(val);//在图中删除
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