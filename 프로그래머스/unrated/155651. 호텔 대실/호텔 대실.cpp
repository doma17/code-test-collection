#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<vector<string>> book_time) {
    int answer = 1;
    
    vector<vector<int>> v;
    for(int i = 0; i < book_time.size(); i++) {
        int start = ((book_time[i][0][0] - '0') * 10 + (book_time[i][0][1] - '0')) * 60; // 시간 단위 -> 분단위
        start += (book_time[i][0][3] - '0') * 10 + book_time[i][0][4] - '0';
        
        int end = ((book_time[i][1][0] - '0') * 10 + (book_time[i][1][1] - '0')) * 60; // 시간 단위 -> 분단위
        end += (book_time[i][1][3] - '0') * 10 + book_time[i][1][4] - '0' + 10;
        
        v.push_back({start, end});
    }
    
    sort(v.begin(), v.end());
    
    vector<vector<int>> filled;
    for(auto x : v) {
        int begin = x[0];
        int end = x[0];
        
        vector<vector<int>> tmp;
        for(auto y : filled) {
            // x의 입실시간 보다 y의 퇴실시간이 크면 방 개수가 더필요하다.
            if(y[1] > begin) { 
                tmp.push_back(y);
            }
        }
        
        filled = tmp;
        filled.push_back(x);
        // 위의 조건이 부합하는 방의 개수가 가장 많이 필요한 경우를 저장
        answer = max(answer, (int) filled.size());
    }
    
    return answer;
}