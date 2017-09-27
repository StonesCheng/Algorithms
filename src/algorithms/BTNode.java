package algorithms;

import java.util.*;

public class BTNode {
    private List<Integer> keys;//关键字
    private List<BTNode> childNodes;//内节点的子节点
    private BTNode parent;//父节点

    public BTNode(){
        keys=new LinkedList<>();
        childNodes=new ArrayList<>();
    }

    public BTNode(BTNode parent){
        this();
        this.parent=parent;
    }

    public BTNode getParentNode(){
        return parent;
    }

    public void setParentNode(BTNode parentNode){
        this.parent=parentNode;
    }

    public List<Integer> getKeys(){
        return keys;
    }

    public Integer getKey(int index){
        return keys.get(index);
    }

    public void setKeys(List<Integer> keys) {
        this.keys = keys;
    }

    public void setChildNodes(List<BTNode> childNodes) {
        this.childNodes = childNodes;
    }

    public List<BTNode> getChildNodes() {
        return childNodes;
    }

    public BTNode getChild(int index){
        return childNodes.get(index);
    }

    public boolean addChildren(List<BTNode> children){
        for (BTNode node:children) {
            node.setParentNode(this);
        }
        children.addAll(children);
        Collections.sort(childNodes, new Comparator<BTNode>() {
            @Override
            public int compare(BTNode o1, BTNode o2) {
                return o1.getKeys().get(0).compareTo(o2.getKeys().get(0));
            }
        });
        return true;
    }

    public void addKey(Integer key){
        SearchResult searchResult = searchKey(this, key);
        this.getKeys().add(searchResult.getIndex(), key);
    }

    /**
     * 在结点node中搜索关键字key
     * @param node
     * @param key
     * @return SearchResult
     */
    public SearchResult searchKey(BTNode node, Integer key)
    {
        boolean result = false;
        int index;
        List<Integer> keys = node.getKeys();
        int low = 0 ;
        int high = keys.size() - 1;
        int mid = 0;
        while(low <= high)
        {
            mid = (low + high) >>> 1;
            Comparable<Integer> midVal = keys.get(mid);
            int cmp = midVal.compareTo(key);
            if(cmp < 0)
                low = mid + 1;
            else if(cmp > 0)
                high = mid - 1;
            else {
                break;
            }
        }
        if(low <= high){//查找成功
            result = true;
            index = mid;
        }else{
            index = low;
        }
        return new SearchResult(result, index);
    }

    /**
     * 设置父节点并添加孩子结点,添加后需要排序
     * @param child
     * @return boolean
     */
    public boolean addChild(BTNode child)
    {
        child.setParentNode(this);
        childNodes.add(child);
        Collections.sort(childNodes, new Comparator<BTNode>() {
            @Override
            public int compare(BTNode o1, BTNode o2)
            {
                return o1.getKeys().get(0).compareTo(o2.getKeys().get(0));
            }
        });
        return true;
    }

    /**
     * 删除孩子节点
     * @param childNode
     */
    public void removeChild(BTNode childNode)
    {
        childNodes.remove(childNode);
    }

    /**
     * @return 节点中关键字的个数
     */
    public int sizeOfKeys()
    {
        return keys.size();
    }

    /**
     * @return 孩子个数
     */
    public int sizeOfChildren()
    {
        return childNodes.size();
    }
}
