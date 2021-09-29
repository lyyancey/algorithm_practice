class NestedIterator implements Iterator<Integer>{
    private Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList){
        List<Integer> res = new LinkedList<>();
        for(NestedInteger n : nestedList){
            traverse(n, res);
        }
        this.it = res.iterator();
    }
    @Override
    public Integer next(){
        return it.next();
    }
    @Override
    public boolean hasNext(){
        return it.hasNext();
    }
    private void traverse(NestedInteger ni, List<Integer> list){
        if(ni.isInteger()){
            list.add(ni.getInteger());
            return;
        }
        for(NestedInteger n : ni.getList()){
            traverse(n, list);
        }
    }
}
class LazyNestedIterator implements Iterator<Integer>{
    private LinkedList<NestedInteger> li;
    public LazyNestedIterator(List<NestedInteger> nestedList){
        this.li = new LinkedList<>(nestedList);
    }
    @Override
    public Integer next(){
        this.li.remove(0).getInteger();
    }
    @Override
    public boolean hasNext(){
        while(!li.isEmpty() && !li.get(0).isInteger()){
            List<NestedInteger> first = li.remove(0).getList();
            for(int i = first.size()-1; i>=0;i--){
                li.addFirst(first.get(i));
            }
        }
        return !li.isEmpty();
    }
}