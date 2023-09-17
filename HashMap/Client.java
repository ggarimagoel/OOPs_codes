package HashMap;

public class Client {
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<String, Integer>();

        map.put("A" , 1);
        map.put("B" , 2);
        map.put("C" , 3);
        map.put("D" , 4);
        map.remove("B");
        System.out.println(map.get("B"));
//        System.out.println(map.size());


    }
}
