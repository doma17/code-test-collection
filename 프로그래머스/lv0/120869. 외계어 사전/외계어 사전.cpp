#include <string>
#include <vector>
#include <string.h>
#include <iostream>

using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    int ans = 0;
    bool loop_end = false;
    
    vector<int> v; // v 초기화
    for(int i = 0; i < spell.size(); i++) {
        v.push_back(0);
    }
    
    
    for(int i = 0; i < dic.size(); i++) {
        for(int i = 0; i < spell.size(); i++) // v 초기화
            v[i] = 0;
            
        for(int j = 0; j < dic[i].length(); j++) { // spell 보유수 측정
            for(int k = 0; k < spell.size(); k++)
                if(spell[k][0] == dic[i][j])
                    v[k]++;
        }
        
        for(auto x : v)
            cout << x << " ";
        cout << "\n";
        
        for(int k = 0; k < spell.size(); k++) { // spell이 모두 각각 1일 때만 정답
            if(v[k] == 1) {
                loop_end = true;
                ans = 1;
            }
            else {
                loop_end = false;
                ans = 2;
                break;
            }
        }
        
        if(loop_end) break;
    }
    
    if(ans == 1) return 1;
    return 2;
}