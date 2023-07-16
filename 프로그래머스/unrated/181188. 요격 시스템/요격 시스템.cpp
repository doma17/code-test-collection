#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> targets) {
    int answer = 0, index = 0;
    
    sort(targets.begin(), targets.end());
    
    while(index < targets.size()) {
        int e = targets[index][1];
        index++;
        answer++;
        
        while(e > targets[index][0] && index < targets.size()) {
            if(e > targets[index][1])
                e = targets[index][1];
            index++;
        }
    }
    
    return answer;
}