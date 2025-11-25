class Solution {
    public boolean isAnagram(String s, String t) {
        var bucketS = new HashMap<Character, Integer>();
        s.chars().mapToObj(e->(char)e).forEach((c) -> {
            bucketS.putIfAbsent(c, 0);
            bucketS.put(c, bucketS.get(c) + 1);
        });

        var bucketT = new HashMap<Character, Integer>();
        t.chars().mapToObj(e->(char)e).forEach((c) -> {
            bucketT.putIfAbsent(c, 0);
            bucketT.put(c, bucketT.get(c) + 1);
        });

        if (bucketS.size() != bucketT.size()) {
            System.out.println("Unequal size");
            return false;
        }

        for (var keyS : bucketS.keySet()) {
            if (!bucketT.containsKey(keyS) ||
                !bucketS.get(keyS).equals(bucketT.get(keyS))) {
                return false;
            }
        }

        return true;
    }
}

