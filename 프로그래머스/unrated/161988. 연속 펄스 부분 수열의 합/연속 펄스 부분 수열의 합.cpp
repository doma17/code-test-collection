#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long solution(vector<int> sequence) {
    // 완탐형식 -> dp ??
    
    vector<int> odd;
    vector<int> even;
    int pulse = 1;
    for(int i = 0; i < sequence.size(); i++) {
        odd.push_back(sequence[i] * pulse);
        even.push_back(sequence[i] * -pulse);
        pulse *= -1;
    }

    long long answer = 0;
    long long min_odd = 0, min_even = 0;
    long long sum_odd = 0, sum_even = 0;
	for(int i = 0; i < sequence.size(); i++){
        sum_odd += odd[i];
        sum_even += even[i];
        
        answer = max(answer, max(sum_odd - min_odd, sum_even - min_even));
        
        min_odd = min(min_odd, sum_odd);
        min_even = min(min_even, sum_even);
	}
    return answer;
}