from itertools import combinations

# DP 방식으로 눈금 합의 조합 구하기
def dice_sum_by_dp(dice_group) :
    # dp 초기 상태 : 합이 0인 경우 1개 
    dp = { 0 : 1 } 
    
    for dice in dice_group:
        # 새로운 dp 선언
        new_dp = {}
        for face in dice:
            for sum_val, count in dp.items():
                new_sum = sum_val + face
                if new_sum in new_dp :
                    new_dp[new_sum] += count
                else :
                    new_dp[new_sum] = count
        dp = new_dp
    
    return dp
    

def solution(dice):
    answer = {}
    
    # 들어온 dice index list 
    nums = list(i+1 for i in range(len(dice)))
    
    # 인덱스를 사용해 조합 만들기
    perm = list(combinations(nums, len(dice)//2))

    # A가 가져갈 주사위 조합
    a_perm_idx = perm[:len(perm)//2]
    
    # B가 가져갈 주사위 조합
    b_perm_idx = perm[len(perm)//2 : ]
    
    # A를 기준으로 비교해
    for i in range(len(a_perm_idx)):
        win_sc = 0
        lose_sc = 0

        # A 주사위 눈금의 합 조합   
        ## 기존 : product 와 Counter 방식을 활용
        # a_perm = list(dice[a-1] for a in a_perm_idx[i])
        # a_sum_counts = Counter(sum(a) for a in product(*a_perm))
        # dp 활용하여 눈금의 합 조합 구하기
        a_sum_counts = dice_sum_by_dp([dice[a-1] for a in a_perm_idx[i]])
        
        
        # B 주사위 눈금의 합 조합
        # b_perm = list(dice[b-1] for b in b_perm_idx[-(i+1)])
        # b_sum_counts = Counter(sum(b) for b in product(*b_perm))
        b_sum_counts = dice_sum_by_dp([dice[b-1] for b in b_perm_idx[-(i+1)]])
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
    

    return list(map(int, max_key.split(","))) 


# ## 방법 1 : counter & 이진탐색으로 풀이하기
# ## 메모리 : 10.5MB, 시간 : 1785.48ms
# from itertools import combinations , product
# from collections import Counter


# def solution(dice):
#     answer = {}
    
#     # 들어온 dice index list 
#     nums = list(i+1 for i in range(len(dice)))
    
#     # 인덱스를 사용해 조합 만들기
#     # 예시 : 1번 케이스
#     # [(1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4)]
#     perm = list(combinations(nums, len(dice)//2))

#     # A가 가져갈 주사위 조합 (앞에 반절) -> [(1, 2), (1, 3), (1, 4)]
#     a_perm_idx = perm[:len(perm)//2]
    
#     # B가 가져갈 주사위 조합 (뒤에 반절) -> [(2, 3), (2, 4), (3, 4)]
#     b_perm_idx = perm[len(perm)//2 : ]
    
#     # A를 기준으로 비교해
#     for i in range(len(a_perm_idx)):
#         win_sc = 0
#         lose_sc = 0

#         # A 주사위 눈금의 합 조합   
#         # (1,2) => Counter({5: 6, 6: 6, 7: 6, 8: 6, 9: 6, 4: 4, 10: 2})
#         # (1,3) => Counter({5: 6, 6: 6, 7: 6, 8: 5, 9: 5, 4: 3, 10: 3, 2: 1, 3: 1})
#         # (1,4) => Counter({6: 6, 7: 6, 5: 4, 8: 4, 9: 4, 10: 4, 2: 2, 3: 2, 4: 2, 11: 2})
#         a_perm = list(dice[a-1] for a in a_perm_idx[i])
#         a_sum_counts = Counter(sum(a) for a in product(*a_perm))
        
#         # B 주사위 눈금의 합 조합
#         b_perm = list(dice[b-1] for b in b_perm_idx[-(i+1)])
#         b_sum_counts = Counter(sum(b) for b in product(*b_perm))
#         # 이진탐색을 위해 눈금합만 오름차순 정렬
    
#         b_sorted_sum = sorted(b_sum_counts.keys())
#         print(b_sorted_sum)
        
        
#         for a_sum, a_count in a_sum_counts.items() :
#             left, right = 0 , len(b_sorted_sum)
#             while left < right :
#                 mid = (left + right ) // 2
#                 if b_sorted_sum[mid] < a_sum :
#                     left = mid + 1
#                 else : 
#                     right = mid
            
#             win_cases = sum(b_sum_counts[b] for b in b_sorted_sum[:left])
#             lose_cases = sum(b_sum_counts[b] for b in b_sorted_sum[left:] if b > a_sum)
            
            
#             win_sc += win_cases * a_count
#             lose_sc += lose_cases * a_count
        
    
#         answer[",".join(map(str, a_perm_idx[i]))] = win_sc
#         answer[",".join(map(str, b_perm_idx[-(i+1)]))]  = lose_sc
        
        
#     max_key = max(answer, key=answer.get)

#     return list(map(int, max_key.split(","))) 