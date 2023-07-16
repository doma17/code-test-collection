#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    vector<long long> v(1001, 0);
    
    for(auto x : weights)
        v[x]++;
    
    long long tmp = 0;
    for(auto x : weights) {
        if(x % 2 == 0) {
            tmp = (x / 2) * 3;
            if(tmp <= 1000) answer += v[tmp];
        }
        if(x % 3 == 0) {
            tmp = (x / 3) * 4;
            if(tmp <= 1000) answer += v[tmp];
        }
        tmp = x * 2;
        if(tmp <= 1000) answer += v[tmp];
    }
    
    for(int i = 100; i <= 1000; i++) {
        if(v[i] >= 2)
            answer += (v[i] * (v[i] - 1)) / 2;
    }
    
    return answer;
}