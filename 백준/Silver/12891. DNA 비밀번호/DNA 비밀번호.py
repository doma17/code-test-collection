S, P = map(int, input().split())
text = input()
A, C, G, T = map(int, input().split())
# {A, C, G, T}

dp = [0] * 4
cnt = 0
for i in range(P):
    if text[i] == 'A':
        dp[0] += 1
    elif text[i] == 'C':
        dp[1] += 1
    elif text[i] == 'G':
        dp[2] += 1
    else:
        dp[3] += 1

for i in range(P, S):
    if dp[0] >= A and dp[1] >= C and dp[2] >= G and dp[3] >= T:
        cnt += 1

    t = text[i]
    if t == 'A':
        dp[0] += 1
    elif t == 'C':
        dp[1] += 1
    elif t == 'G':
        dp[2] += 1
    else:
        dp[3] += 1

    j = i - P
    if text[j] == 'A':
        dp[0] -= 1
    elif text[j] == 'C':
        dp[1] -= 1
    elif text[j] == 'G':
        dp[2] -= 1
    else:
        dp[3] -= 1

if dp[0] >= A and dp[1] >= C and dp[2] >= G and dp[3] >= T:
    cnt += 1
print(cnt)