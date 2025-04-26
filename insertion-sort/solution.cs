// Definition for a pair
// public class Pair {
//     public int Key;
//     public string Value;
//
//     public Pair(int key, string value) {
//         Key = key;
//         Value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> InsertionSort(List<Pair> pairs) {
        var ret = new List<List<Pair>>();
        if (pairs.Count < 1) {
            return ret;
        }
        ret.Add(new List<Pair>(pairs));

        for (int i = 1; i < pairs.Count; i++) {
            int j = i - 1;
            while (j >= 0 && pairs[j + 1].Key < pairs[j].Key) {
                var tmp = pairs[j + 1];
                pairs[j + 1] = pairs[j];
                pairs[j] = tmp;
                j--;
            }
            ret.Add(new List<Pair>(pairs));
        }

        return ret;
    }
}

