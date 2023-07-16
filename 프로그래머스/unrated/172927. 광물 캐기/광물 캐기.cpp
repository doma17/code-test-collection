#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    // 곡갱이의 총개수
    int num = picks[0] + picks[1] + picks[2];
    
    // 돌 곡갱이로 캤을 때 가장 가중치가 큰 배열 찾기
    vector<vector<int>> greed;
    vector<int> v;
    int sum = 0;
    int j = 0;
    for(int i = 0; i < num * 5; i++) {
        if(i >= minerals.size()) {
            v.push_back(sum);
            v.push_back(j);
            greed.push_back(v);
            v.clear();
            break;
        }
            
        if(minerals[i] == ("diamond"))
            sum += 25;
        else if(minerals[i] == ("iron"))
            sum += 5;
        else
            sum += 1;
        
        if((i + 1) % 5 == 0) {
            v.push_back(sum);
            v.push_back(j);
            greed.push_back(v);
            v.clear();
            sum = 0;
            j++;
        }
    }
    sort(greed.begin(), greed.end(), greater<vector<int>>());
    
    for(int i = 0; i < greed.size(); i++) {
        int index = greed[i][1] * 5;
        int end = index + 5;
        int tool = -1;
        
        // 곡갱이 내구도 합보다 광물의 개수가 적을 때
        if(end >= minerals.size())
            end = minerals.size();
        
        // 곡갱이 선택
        for(int j = 0; j < 3; j++) {
            if(picks[j] > 0) {
                picks[j]--;
                tool = j;
                break;
            }
        }
        
        // 피로도 계산
        while(index < end) {
            if(minerals[index] == "stone") 
                answer += 1;
            else if(minerals[index] == "iron"){
                if(tool <= 1)
                    answer += 1;
                else
                    answer += 5;
            }
            else {
                if(tool == 0)
                    answer += 1;
                else if(tool == 1)
                    answer += 5;
                else
                    answer += 25;
            }
            index++;
        }
        cout << answer << " ";
    }
    
    return answer;
}