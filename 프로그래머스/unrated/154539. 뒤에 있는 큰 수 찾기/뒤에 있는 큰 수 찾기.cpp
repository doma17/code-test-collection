#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size(), -1);
    int big = numbers[numbers.size() - 1];
    
    // numbers의 마지막 인덱스는 항상 -1임
    for(int i = numbers.size() - 2; i >= 0; i--) {
        if(numbers[i] > big) { // 뒷수 중에 가장 큰 수보다 크면 -1
            big = numbers[i];
            answer[i] = -1;
        }
        else {
            for(int j = i + 1; j < numbers.size(); j++) {
                if(numbers[i] < numbers[j]) { // 현재 수보다 뒷수가 크면
                    answer[i] = numbers[j];
                    break;
                }
                else { // 현재 수보다 뒷수가 작으면
                    if(numbers[i] < answer[j]) { // 뒷수의 정답이 현재보다 큼
                        answer[i] = answer[j];
                        break;
                    }
                    else if(answer[j] == -1) { // 나보다 작은 뒷수의 정답이 -1
                        answer[i] = -1;
                        break;
                    } 
                }
            }
        }
    }

    return answer;
}