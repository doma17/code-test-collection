#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    int ans = 0;
    
    queue<int> q1;
    queue<int> q2;
    long long sum1 = 0, sum2 = 0;
    
    for(int i = 0; i < queue1.size(); i++) {
        sum1 += queue1[i];
        q1.push(queue1[i]);
    }
    for(int i = 0; i < queue2.size(); i++) {
        sum2 += queue2[i];
        q2.push(queue2[i]);
    }
        
    
    if((sum1 + sum2) % 2 != 0) // 전체 합이 짝수가 아니면 불가능
        return -1;
    
    while (true) {
        if (ans == 6 * queue1.size()) // q1의 크기보다 4배 이상 iter가 반복될때 종료
            return -1;
        
        if(sum1 > sum2) {
            int v = q1.front(); q1.pop();
            q2.push(v);
            sum1 -= v;
            sum2 += v;
        }
        else if(sum1 < sum2) {
            int v = q2.front(); q2.pop();
            q1.push(v);
            sum1 += v;
            sum2 -= v;
        }
        else // sum1과 sum2가 같을 때
            return ans;
        ans++;
    }
    
    return ans;
}