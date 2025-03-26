from itertools import combinations , product
from collections import Counter

# def custom_bisect_right(arr, x):
#     left, right = 0, len(arr)
    
#     while left < right :
#         mid = (left+right) // 2
        
#         if arr[mid] <= x:
#             left = mid + 1
#         else : 
#             right = mid
#     return left

def solution(dice):
    answer = {}
    
    # print(dice)
    
    # 들어온 dice index list 
    nums = list(i+1 for i in range(len(dice)))
    # print(nums)
    
    # 인덱스를 사용해 조합 만들기
    perm = list(combinations(nums, len(dice)//2))
    # print(perm)

    # A가 가져갈 주사위 조합
    a_perm_idx = perm[:len(perm)//2]
    
    # B가 가져갈 주사위 조합
    b_perm_idx = perm[len(perm)//2 : ]
    
    # print(a_perm_idx)
    # print(b_perm_idx)
    
    # A를 기준으로 비교해
    for i in range(len(a_perm_idx)):
        win_sc = 0
        lose_sc = 0

        # A 주사위 눈금의 합 조합   
        a_perm = list(dice[a-1] for a in a_perm_idx[i])
        a_sum_counts = Counter(sum(a) for a in product(*a_perm))
        
        # B 주사위 눈금의 합 조합
        b_perm = list(dice[b-1] for b in b_perm_idx[-(i+1)])
        b_sum_counts = Counter(sum(b) for b in product(*b_perm))
        b_sorted_sum = sorted(b_sum_counts.keys())
        
        
        for a_sum, a_count in a_sum_counts.items() :
            left, right = 0 , len(b_sorted_sum)
            while left < right :
                mid = (left + right ) // 2
                if b_sorted_sum[mid] < a_sum :
                    left = mid + 1
                else : 
                    right = mid
            
            win_cases = sum(b_sum_counts[b] for b in b_sorted_sum[:left])
            lose_cases = sum(b_sum_counts[b] for b in b_sorted_sum[left:] if b > a_sum)
            
            
            win_sc += win_cases * a_count
            lose_sc += lose_cases * a_count
        
    
        answer[",".join(map(str, a_perm_idx[i]))] = win_sc
        answer[",".join(map(str, b_perm_idx[-(i+1)]))]  = lose_sc
        
        
    max_key = max(answer, key=answer.get)
    
    print(answer)

    return list(map(int, max_key.split(","))) 