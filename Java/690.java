import java.util.*;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
class Problem690{
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Employee> queue = new LinkedList<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        int num=0;
        Employee e = map.get(id);
        queue.offer(e);
        while(!queue.isEmpty()){
            Employee em = queue.poll();
            num+=em.importance;
            for(Integer emId : em.subordinates){
                queue.offer(map.get(emId));
            }
        }
        return num;

    }
}
