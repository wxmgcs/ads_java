package cn.diyai.hashtable;

//哈希查找之JAVA实现
// http://www.cnblogs.com/jingmoxukong/p/4332252.html
class HashTable {
    public int key = 0; // 关键字
    public int data = 0; // 数值
    public int count = 0; // 探查次数
}

public class HashSearch {

    private final static int MAXSIZE = 20;
    private final static int NULLKEY = 1;
    private final static int DELKEY = 2;
    private final static int SUCCESS = 0; 
    private final static int FAILED = 0xFFFFFFFF;

    /**
     * 查找哈希表
     * 构造哈希表采用除留取余法，即f(key) = key mod p (p ≤ size)
     * 解决冲突采用开放定址法，即f2(key) = (f(key) + i) mod p (1 ≤ i ≤ size-1)
     * ha为哈希表，p为模，size为哈希表大小，key为要查找的关键字
     */
    public int searchHashTable(HashTable[] ha, int p, int size, int key) {
        int addr = key % p; // 采用除留取余法找哈希地址

        // 若发生冲突，用开放定址法找下一个哈希地址
        while (ha[addr].key != NULLKEY && ha[addr].key != key) {
            addr = (addr + 1) % size;
        }

        if (ha[addr].key == key) {
            return addr; // 查找成功
        } else {
            return FAILED; // 查找失败
        }
    }

    /**
     * 删除哈希表中关键字为key的记录
     * 找到要删除的记录，将关键字置为删除标记DELKEY
     */
    public int deleteHashTable(HashTable[] ha, int p, int size, int key) {
        int addr = 0;
        addr = searchHashTable(ha, p, size, key);
        if (FAILED != addr) { // 找到记录
            ha[addr].key = DELKEY; // 将该位置的关键字置为DELKEY
            return SUCCESS;
        } else {
            return NULLKEY; // 查找不到记录，直接返回NULLKEY
        }
    }

    /**
     * 将待插入的关键字key插入哈希表
     * 先调用查找算法，若在表中找到待插入的关键字，则插入失败；
     * 若在表中找到一个开放地址，则将待插入的结点插入到其中，则插入成功。
     */
    public void insertHashTable(HashTable[] ha, int p, int size, int key) {
        int i = 1;
        int addr = 0;
        addr = key % p; // 通过哈希函数获取哈希地址
        if (ha[addr].key == NULLKEY || ha[addr].key == DELKEY) { // 如果没有冲突，直接插入
            ha[addr].key = key;
            ha[addr].count = 1;
        } else { // 如果有冲突，使用开放定址法处理冲突
            do {
                addr = (addr + 1) % size; // 寻找下一个哈希地址
                i++;
            } while (ha[addr].key != NULLKEY && ha[addr].key != DELKEY);

            ha[addr].key = key;
            ha[addr].count = i;
        }
    }

    /**
     * 创建哈希表
     * 先将哈希表中各关键字清空，使其地址为开放的，然后调用插入算法将给定的关键字序列依次插入。
     */
    public void createHashTable(HashTable[] ha, int[] list, int p, int size) {
        int i = 0;
        
        // 将哈希表中的所有关键字清空
        for (i = 0; i < ha.length; i++) {
            ha[i].key = NULLKEY;
            ha[i].count = 0;
        }

        // 将关键字序列依次插入哈希表中
        for (i = 0; i < list.length; i++) {
            this.insertHashTable(ha, p, size, list[i]);
        }
    }

    /**
     * 输出哈希表
     */
    public void displayHashTable(HashTable[] ha) {
        int i = 0;
        System.out.format("pos:\t", "pos");
        for (i = 0; i < ha.length; i++) {
            System.out.format("%4d", i);
        }
        System.out.println();

        System.out.format("key:\t");
        for (i = 0; i < ha.length; i++) {
            if (ha[i].key != NULLKEY) {
                System.out.format("%4d", ha[i].key);
            } else {
                System.out.format("    ");
            }
        }
        System.out.println();

        System.out.format("count:\t");
        for (i = 0; i < ha.length; i++) {
            if (0 != ha[i].count) {
                System.out.format("%4d", ha[i].count);
            } else {
                System.out.format("    ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] list = { 3, 112, 245, 27, 44, 19, 76, 29, 90 };
        HashTable[] ha = new HashTable[MAXSIZE];
        for (int i = 0; i < ha.length; i++) {
            ha[i] = new HashTable();
        }

        HashSearch search = new HashSearch();
        search.createHashTable(ha, list, 19, MAXSIZE);
        search.displayHashTable(ha);

    }

}

