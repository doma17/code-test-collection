#include <string>
#include <vector>
#include <sstream>
#include <iostream>
using namespace std;

vector<string> solution(vector<string> commands) {
    
    vector<string> answer;
    vector<vector<string>> exel(51, vector<string>(51, "EMPTY"));
    vector<vector<vector<int>>> link(51, vector<vector<int>>(51, vector<int>(2, 0)));
    
    // 링크의 기초 값은 자기 자신을 가르킨다.
    for(int i = 1; i < 51; i++) {
        for(int j = 1; j < 51; j++) { 
            link[i][j][0] = i;
            link[i][j][1] = j;
        }
    }
    
    for(auto str : commands) {
        vector<string> words;
        stringstream ss(str);
        string word;
        
        while(getline(ss, word, ' '))
            words.push_back(word);
        
        if(words[0] == "UPDATE") {
            int a = words.size();
            if(a == 3) { // "UPDATE value1 value2"
                // 같은 값을 가지는 모든 노드 변경
                for(int i = 1; i < 51; i++) {
                    for(int j = 1; j < 51; j++) {
                        if(exel[i][j] == words[1]) exel[i][j] = words[2];
                    }
                }
            }
            if(a == 4) { // "UPDATE r c value"
                // 부모의 값을 출력
                int r = stoi(words[1]), c = stoi(words[2]); 
                exel[link[r][c][0]][link[r][c][1]] = words[3];
            }
        }
        else if(words[0] == "MERGE") { // "MERGE r1 c1 r2 c2"
            int r1 = stoi(words[1]), c1 = stoi(words[2]);
            int r2 = stoi(words[3]), c2 = stoi(words[4]);
            int parent_r1 = link[r1][c1][0], parent_r2 = link[r2][c2][0];
            int parent_c1 = link[r1][c1][1], parent_c2 = link[r2][c2][1];
            
            if(link[r1][c1] != link[r2][c2]) { // 부모가 다르면 첫번째 값으로 부모설정
                for(int i = 1; i < 51; i++) {
                    for(int j = 1; j < 51; j++) {
                        if(link[i][j][0] == parent_r2 && link[i][j][1] == parent_c2) {
                            link[i][j][0] = parent_r1;
                            link[i][j][1] = parent_c1;
                        }
                    }
                }
                
                // str1이 비었고, str2가 값이 있다면 str2로 병합
                string str1 = exel[parent_r1][parent_c1], str2 = exel[parent_r2][parent_c2];
                if(str1 == "EMPTY" && str2 != "EMPTY")
                    exel[parent_r1][parent_c1] = exel[parent_r2][parent_c2];
                else
                    exel[parent_r2][parent_c2] = exel[parent_r1][parent_c1];
            }
        }
        else if(words[0] == "UNMERGE") { // "UNMERGE r c"
            int r = stoi(words[1]), c = stoi(words[2]);
            int parent_r = link[r][c][0], parent_c = link[r][c][1];
            string str = exel[parent_r][parent_c];
            
            // 부모의 값과 같은 모든 노드들을 빈칸으로 초기화
            for(int i = 1; i < 51; i++) {
                for(int j = 1; j < 51; j++) {
                    if(link[i][j][0] == parent_r && link[i][j][1] == parent_c) {
                        link[i][j][0] = i;
                        link[i][j][1] = j;
                        exel[i][j] = "EMPTY";
                    }
                }
            }
            exel[r][c] = str; // UNMERGE한 좌표에 기존 값을 다시 입력
        }
        else if(words[0] == "PRINT") { 
            // 부모 노드를 출력
            int r = stoi(words[1]), c = stoi(words[2]);
            answer.push_back(exel[link[r][c][0]][link[r][c][1]]);
        }
    }
    
    return answer;
}