func rob(nums []int) int {
    if len(nums) < 1 {
        return 0
    }

    cache := make(map[int]int)
    return dfs(0, nums, cache)
}

func dfs(idx int, nums []int, cache map[int]int) int {
    if idx >= len(nums) {
        return 0
    }

    if num, ok := cache[idx]; ok {
        return num
    }

    cache[idx] = Max(nums[idx] + dfs(idx + 2, nums, cache), dfs(idx + 1, nums, cache))
    return cache[idx]
}

func Max(x, y int) int {
    if x < y {
        return y
    }
    return x
}
