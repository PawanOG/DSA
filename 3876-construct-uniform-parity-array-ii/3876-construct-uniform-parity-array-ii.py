class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        min_val = float('inf')
        hasodd = False
        haseven = False

        for val in nums1:
            min_val = min(val,min_val)
            if val % 2 == 0:
                haseven = True
            else:
                hasodd = True

        if not hasodd or not haseven:
            return True

        return min_val % 2!=0  