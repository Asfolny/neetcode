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
    public List<Pair> QuickSort(List<Pair> pairs) {
        return QuickSorting(pairs, 0, pairs.Count-1);
    }

    private List<Pair> QuickSorting(List<Pair> pairs, int s, int e) {
        if (e - s + 1 <= 1)
            return pairs;

        Pair pivot = pairs[e];
        int left = s;

        for (int i = s; i < e; i++) {
            if (pairs[i].Key < pivot.Key) {
                Pair tmp = pairs[left];
                pairs[left] = pairs[i];
                pairs[i] = tmp;
                left++;
            }
        }

        pairs[e] = pairs[left];
        pairs[left] = pivot;

        QuickSorting(pairs, s, left - 1);
        QuickSorting(pairs, left + 1, e);

        return pairs;
    }
}

