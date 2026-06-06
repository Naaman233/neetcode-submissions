class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count_frequency = {}
        for i in nums:
            count_frequency[i] = 1 + count_frequency.get(i, 0)
        
        heap = []
        for num in count_frequency.keys():
            heapq.heappush(heap, (count_frequency[num], num))
            if len(heap) > k:
                heapq.heappop(heap)

        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res