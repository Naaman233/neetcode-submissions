from collections import defaultdict
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        origin_point = "JFK"
        map = defaultdict(list)

        for ticket in tickets:
            map[ticket[0]].append(ticket[1])
        for key in map:
            map[key].sort(reverse=True)

        result , stack = [] , []
        stack.append(origin_point)
        while stack:
            current_point = stack[-1]
            if current_point in map and map[current_point]:
                stack.append(map[current_point].pop())
            else:
                result.append(stack.pop())

        return result[::-1]