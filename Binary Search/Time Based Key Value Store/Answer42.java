import java.util.*;

public class Answer42 {
    static class TimeMap {
        private final Map<String, List<Pair>> map;

        private static class Pair {
            int timestamp;
            String value;

            Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
           if (!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Pair> values = map.get(key);
            if (values == null || values.isEmpty()) {
                return "";
            }

            int left = 0;
            int right = values.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (values.get(mid).timestamp <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (right < 0) {
                return "";
            }

            return values.get(right).value;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("alice", "happy", 1);
        System.out.println(timeMap.get("alice", 1)); // happy
        System.out.println(timeMap.get("alice", 2)); // happy

        timeMap.set("alice", "sad", 3);
        System.out.println(timeMap.get("alice", 3)); // sad
        System.out.println(timeMap.get("alice", 2)); // happy
        System.out.println(timeMap.get("bob", 1)); // ""
    }
}