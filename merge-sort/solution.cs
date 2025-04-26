// Definition for a pair.
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
    public List<Pair> MergeSort(List<Pair> pairs) {
        if (pairs == null || pairs.Count < 1)
            return pairs;

        return Divide(pairs, 0, pairs.Count-1);
    }

    public List<Pair> Divide(List<Pair> pairs, int low, int high) {
        if (low > high)
            return null;
        if (low == high)
            return new List<Pair>() {pairs[low]};

        int mid = (high + low) / 2;
        var left = Divide(pairs, low, mid);
        var right = Divide(pairs, mid+1, high);

        return Merge(left, right);
    }

    public List<Pair> Merge(List<Pair> left, List<Pair> right) {
        var merged = new List<Pair>();
        var i = 0;
        var j = 0;

        while (i < left.Count || j < right.Count) {
            if (i == left.Count) {
                merged.Add(right[j]);
                j++;
                continue;
            }

            if (j == right.Count) {
                merged.Add(left[i]);
                i++;
                continue;
            }

            var l = left[i];
            var r = right[j];
            if (l.Key <= r.Key) {
                merged.Add(l);
                i++;
            } else {
                merged.Add(r);
                j++;
            }
        }
        
        return merged;
    }
}

