class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        f = len(flowerbed)

        for i in range(f):
            left = i == 0 or flowerbed[i-1]==0
            right = i == f-1 or flowerbed[i+1]==0

            if left and right and flowerbed[i]==0:
                flowerbed[i]=1
                n -=1


        return n <= 0    