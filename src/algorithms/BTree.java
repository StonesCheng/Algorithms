package algorithms;

import java.util.List;

public class BTree {
    private BTNode root;//Btree的根节点
    private int sizeOfKeys;//Btree中关键字的个数

    /**
     * 默认情况下只有一个节点且为叶子节点
     */
    private BTree(){
        root=new BTNode(null);
    }

    private static BTree instance=new BTree();

    /**
     * 创建Btree
     * @return Btree
     */
    public static BTree newInstance(){
        return instance;
    }

    /**
     * 向BTree中插入关键字
     * 从根节点开始寻找最佳的插入结点,若为叶子结点,则先插入key然后判断是否需要分裂;
     * 若为非叶子结点,则从上到下寻找最佳的叶子结点,然后重复上面叶子结点的情况
     * @param key Integer
     * @return boolean 是否插入成功
     */
    public boolean insertKey(Integer key){
        BTNode node=root;
        while (node!=null){
            if(node.sizeOfChildren()==0){
                node.addKey(key);
                if(node.sizeOfKeys()<=Constants.MAX_KEY_SIZE){
                    break;
                }else {
                    splitNode(node);
                    break;
                }
            }else {
                Integer lesser=node.getKey(0);
                if(key.compareTo(lesser)<0){
                    node=node.getChild(0);
                    continue;
                }
                int size=node.sizeOfKeys();
                int last=size-1;
                Integer greater=node.getKey(last);
                if (key.compareTo(greater)>0){
                    node=node.getChild(size);
                    continue;
                }
            }

            for (int i = 1; i < node.sizeOfKeys(); i++)
            {
                Integer prev = node.getKey(i - 1);
                Integer next = node.getKey(i);
                if (key.compareTo(prev) > 0 && key.compareTo(next) < 0)
                {
                    node = node.getChild(i);
                    break;
                }
            }
        }
        sizeOfKeys++;
        return true;
    }

    public boolean removeKey(Integer key)
    {
        //先找到关键字在哪个结点中,如果没有找到此结点则直接返回false
        BTNode node = this.findNode(key);
        if(node == null)
            return false;

        int index = node.getKeys().indexOf(key);//获取此key的索引
        node.getKeys().remove(key);//删除此key

        if(node.sizeOfChildren() != 0)//非叶子结点
        {
            BTNode left = node.getChild(index);//左孩子
            BTNode greatest = this.getGreatestNode(left);

            //获取并删除左孩子最大结点中的最大的元素
            Integer replaceValue = greatest.getKeys().remove(greatest.sizeOfKeys() - 1);
            //将此元素添加到删除关键字key的结点中
            node.addKey(replaceValue);

            //如果删除关键字后导致下溢,则需要合并结点
            if(greatest.sizeOfKeys() < Constants.MIN_KEY_SIZE)
            {
                this.combined(greatest);    //greatest为叶子结点
            }

        }else{//叶子结点
            //分为四种情况:
            //1)既是叶子结点又是根节点且 node.sizeOfKeys() < Constants.MIN_KEY_SIZE
            //2)叶子结点但非根结点且node.sizeOfKeys() < Constants.MIN_KEY_SIZE ----->只有这一种需要合并
            //3)既是叶子结点又是根节点且node.sizeOfKeys() > Constants.MIN_KEY_SIZE
            //4)叶子结点但非根结点且node.sizeOfKeys() > Constants.MIN_KEY_SIZE
            if(node.getParentNode() != null && node.sizeOfKeys() < Constants.MIN_KEY_SIZE)
            {
                this.combined(node);
            }else if(node.getParentNode() == null && node.sizeOfKeys() == 0)
            {
                //删除的是最后一个元素
                root = null;
            }

        }
        sizeOfKeys --;
        return true;
    }

    private BTNode getGreatestNode(BTNode node)
    {
        while(node.sizeOfChildren() != 0)
        {
            node = node.getChild(node.sizeOfChildren() - 1);
        }
        return node;
    }

    private void combined(BTNode node)
    {
        //先获取此结点的父节点
        BTNode parentNode = node.getParentNode();
        //获取此结点是其父节点中的索引，即第几个孩子
        int index = parentNode.getChildNodes().indexOf(node);
        int indexOfLeftNeighbor = index - 1;
        int indexOfRightNeighbor = index + 1;

        BTNode rightNeighbor = null;
        int rightNeighborSize = 0;//???
        if(indexOfRightNeighbor < parentNode.sizeOfChildren())//右邻居存在
        {
            rightNeighbor = parentNode.getChild(indexOfRightNeighbor);
            rightNeighborSize = rightNeighbor.sizeOfKeys();
        }

        //右邻居存在且其关键字个数大于最小值
        if(rightNeighbor != null && rightNeighborSize > Constants.MIN_KEY_SIZE)
        {
            //相当于左旋
            Integer removeValue = rightNeighbor.getKeys().remove(0);
            int prev = getIndexOfPreviousValue(parentNode, removeValue);
            Integer parentValue = parentNode.getKeys().remove(prev);
            node.addKey(parentValue);
            parentNode.addKey(removeValue);

            if(rightNeighbor.sizeOfChildren() > 0)//如果右邻居的孩子结点存在，则需要把右邻居的第一个孩子结点删除并添加到node结点中
            {
                node.addChild(rightNeighbor.getChildNodes().remove(0));
            }
        }else{
            BTNode leftNeighbor = null;
            int leftNeighborSize = 0;//???
            if(indexOfLeftNeighbor >= 0)//左邻居存在
            {
                leftNeighbor = parentNode.getChild(indexOfLeftNeighbor);
                leftNeighborSize = leftNeighbor.sizeOfKeys();
            }

            //左邻居存在且其关键字个数大于最小值
            if(leftNeighbor != null && leftNeighborSize > Constants.MIN_KEY_SIZE)//左邻居存在且其关键字个数大于最小值
            {
                //相当于右旋
                Integer removeValue = leftNeighbor.getKeys().remove(leftNeighbor.sizeOfKeys() - 1);
                int next = getIndexOfNextValue(parentNode, removeValue);
                Integer parentValue = parentNode.getKeys().remove(next);
                node.addKey(parentValue);
                parentNode.addKey(removeValue);

                if(leftNeighbor.sizeOfChildren() > 0)//如果左邻居的孩子结点存在，则需要把右邻居的最后一个孩子结点删除并添加到node结点中
                {
                    node.addChild(leftNeighbor.getChildNodes().remove(leftNeighbor.sizeOfChildren() - 1));
                }

            }else if(rightNeighbor != null && parentNode.sizeOfKeys() > 0)//右邻居存在且父节点关键字个数大于0
            {
                Integer rightValue = rightNeighbor.getKey(0);//获取右邻居结点中最左边的关键字
                int prev = getIndexOfPreviousValue(parentNode, rightValue);//获取rightValue关键字的父节点中不大于但最接近此关键字的索引
                Integer parentKey = parentNode.getKeys().remove(prev);//在父节点中删除此索引对应的关键字
                parentNode.removeChild(rightNeighbor);////在父节点中删除此索引对应的孩子结点
                node.addKey(parentKey);//将删除的关键字添加到关键字下溢的结点中

                //将右邻居中的关键字添加进去
                for(int i = 0 ; i < rightNeighbor.sizeOfKeys(); i ++)
                {
                    node.addKey(rightNeighbor.getKey(i));
                }

                //将右邻居中的孩子结点也添加进去
                for(int i = 0 ; i < rightNeighbor.sizeOfChildren(); i ++)
                {
                    node.addChild(rightNeighbor.getChild(i));
                }

                if(parentNode.getParentNode() != null && parentNode.sizeOfKeys() < Constants.MIN_KEY_SIZE)//还没到达根节点
                {
                    this.combined(parentNode);

                }else if(parentNode.sizeOfKeys() == 0){
                    //父节点中没有关键字了，则降低树的高度
                    node.setParentNode(null);//注意：树的高度降低一层，此结点就变为根节点，一定要设置其父节点为null
                    parentNode = null;
                    root = node;
                }

            }else if(leftNeighbor != null && parentNode.sizeOfKeys() > 0)    //左邻居存在且父节点关键字个数大于0
            {
                Integer leftValue = leftNeighbor.getKey(leftNeighbor.sizeOfKeys() - 1);//获取左邻居结点中最右边的关键字
                int next = getIndexOfNextValue(parentNode, leftValue);//获取leftValue关键字的父节点中不小于但最接近此关键字的索引
                Integer parentKey = parentNode.getKeys().remove(next);//在父节点中删除此索引对应的关键字
                parentNode.removeChild(leftNeighbor);////在父节点中删除此索引对应的孩子结点
                node.addKey(parentKey);//将删除的关键字添加到关键字下溢的结点中

                //将左邻居中的关键字添加进去
                for(int i = 0 ; i < leftNeighbor.sizeOfKeys(); i ++)
                {
                    node.addKey(leftNeighbor.getKey(i));
                }

                //将左邻居中的孩子结点也添加进去
                for(int i = 0 ; i < leftNeighbor.sizeOfChildren(); i ++)
                {
                    node.addChild(leftNeighbor.getChild(i));
                }

                if(parentNode.getParentNode() != null && parentNode.sizeOfKeys() < Constants.MIN_KEY_SIZE)//还没到达根节点
                {
                    this.combined(parentNode);
                }else if(parentNode.sizeOfKeys() == 0){
                    //父节点中没有关键字了，则降低树的高度
                    node.setParentNode(null);//注意：树的高度降低一层，此结点就变为根节点，一定要设置其父节点为null
                    parentNode = null;
                    root = node;
                }
            }
        }//end else
    }

    private int getIndexOfPreviousValue(BTNode node, Integer value)
    {
        for (int i = 1; i < node.sizeOfKeys(); i++)
        {
            Integer t = node.getKey(i);
            if (t.compareTo(value) >= 0)
                return i - 1;
        }
        return node.sizeOfKeys() - 1;
    }

    private int getIndexOfNextValue(BTNode node, Integer value)
    {
        for(int i = 0 ; i < node.sizeOfKeys(); i ++)
        {
            Integer t = node.getKey(i);

            if(t.compareTo(value) >= 0)
            {
                return i;
            }
        }
        return node.sizeOfKeys() - 1;
    }

    public BTNode findNode(Integer key)
    {
        BTNode node = root;

        while(node != null)
        {
            if(node.sizeOfChildren() == 0)//叶子结点
            {
                if(node.getKeys().contains(key))
                {
                    return node;
                }
                return null;

            }else{//非叶子结点
                if(key.compareTo(node.getKey(0)) < 0)//比最小的小
                {
                    node = node.getChild(0);
                    continue;
                }

                if(key.compareTo(node.getKey(node.sizeOfKeys() - 1)) > 0)//比最大的还大
                {
                    node = node.getChild(node.sizeOfKeys());
                    continue;
                }

                //中间情况
                for(int i = 1 ;i < node.sizeOfKeys(); i ++)
                {
                    if(key.compareTo(node.getKey(i)) == 0)
                    {
                        return node;
                    }else if(key.compareTo(node.getKey(i - 1)) > 0 && key.compareTo(node.getKey(i)) < 0)
                    {
                        node = node.getChild(i);
                        break;
                    }
                }

            }
        }
        return null;
    }

    public int sizeOfKeys()
    {
        return sizeOfKeys;
    }

    private void splitNode(BTNode node)
    {
        //分裂位置发生在size/2,分裂成两个结点
        int splitIndex = node.sizeOfKeys() / 2;
        //需要上移的关键字
        Integer splitKey = node.getKeys().get(splitIndex);

        //      List<Integer> copy1 = new ArrayList<>(node.getKeys().subList(0, splitIndex));//---2
        //      List<Integer> copy2 = new ArrayList<>(node.getKeys().subList(splitIndex + 1, node.getKeys().size()));//----2

        //生成新的结点
        BTNode left = new BTNode(null);
//      left.setKeys(node.getKeys().subList(0, splitIndex));
//      left.setKeys(copy1);    //-----2
        for(int i = 0 ; i < splitIndex; i ++)
        {
            left.addKey(node.getKey(i));
        }
        if(node.sizeOfChildren() > 0)
        {
            left.addChildren(node.getChildNodes().subList(0, splitIndex + 1));//这里索引需要注意
        }

        BTNode right = new BTNode(null);
//      right.setKeys(node.getKeys().subList(splitIndex + 1, node.getKeys().size()));
//      right.setKeys(copy2);   //----2
        for(int i = splitIndex + 1; i < node.sizeOfKeys(); i ++)
        {
            right.addKey(node.getKey(i));
        }
        if(node.sizeOfChildren() > 0)
        {
            right.addChildren(node.getChildNodes().subList(splitIndex + 1, node.sizeOfChildren()));
        }

        if(node.getParentNode() != null)//有父节点
        {
            BTNode parent = node.getParentNode();//取得其父节点
            parent.addKey(splitKey);
            parent.removeChild(node);
            parent.addChild(left);
            parent.addChild(right);

            if(parent.sizeOfKeys() > Constants.MAX_KEY_SIZE)
            {
                splitNode(parent);
            }

        }else{//没有父节点,即到达根节点
            BTNode newRoot = new BTNode(null);
            newRoot.getKeys().add(splitKey);
            root = newRoot;
            newRoot.addChild(left);
            newRoot.addChild(right);
        }
    }

    public boolean insertKeys(Integer[] keys)
    {
        boolean isInsert ;
        for(int i = 0 ; i < keys.length; i ++)
        {
            isInsert = insertKey(keys[i]);
            if(! isInsert)
            {
                return false;
            }
        }
        return true;
    }

    public boolean insertKeys(List<Integer> keys)
    {
        Integer[] keysArray  = (Integer[]) keys.toArray();
        return insertKeys(keysArray);
    }

    private static class TreePrinter
    {

        public static  String getString(BTree tree)
        {
            if (tree.root == null) return "Tree has no nodes.";
            return getString(tree.root, "", true);
        }

        private static String getString(BTNode node, String prefix, boolean isTail)
        {
            StringBuilder builder = new StringBuilder();

            builder.append(prefix).append((isTail ? "└── " : "├── "));
            for (int i = 0; i < node.sizeOfKeys(); i++) {
                Integer value = node.getKey(i);
                builder.append(value);
                if (i < node.sizeOfKeys() - 1) builder.append(", ");
            }
            builder.append("\n");

            if (node.getChildNodes() != null) {
                for (int i = 0; i < node.sizeOfChildren() - 1; i++) {
                    BTNode obj = node.getChild(i);
                    builder.append(getString(obj, prefix + (isTail ? "    " : "│   "), false));
                }
                if (node.sizeOfChildren() >= 1) {
                    BTNode obj = node.getChild(node.sizeOfChildren() - 1);
                    builder.append(getString(obj, prefix + (isTail ? "    " : "│   "), true));
                }
            }

            return builder.toString();
        }
    }

    public static void main(String[] args)
    {
        BTree bTree = BTree.newInstance();

        for(int i = 1 ; i <= 10; i ++)
        {
            bTree.insertKey(i);
            System.out.println(TreePrinter.getString(bTree));
        }
        for(int i = 10 ; i > 0; i --)
        {
            bTree.removeKey(i);
            System.out.println(TreePrinter.getString(bTree));
        }

    }
}
