import java.util.HashSet;
public class Hash {
        public static void main(String[] args) {
            HashSet<String> s = new HashSet<>();
            s.add("关羽");
            s.add("张飞");
            s.add("马超");
            s.add("黄忠");
            s.add("赵云");
            s.add("马超");
            s.add("赵云");
            System.out.println(s);
        }
}
