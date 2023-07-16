#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    vector<int> answer;
    
    for(auto cur : balls) {
        int dist = 0;
        int x = cur[0];
        int y = cur[1];
        
        if(x == startX) {
            int a = pow(2 * x, 2) + pow(startY - y, 2);
            int b = pow(2 * (m - x), 2) + pow(startY - y, 2);
            int c = startY < y ? pow(startY + y, 2) : pow(2 * n - startY - y, 2);
            dist = min(a, min(b, c));
        }
        else if(y == startY) {
            int a = pow(2 * y, 2) + pow(startX - x, 2);
            int b = pow(2 * (n - y), 2) + pow(startX - x, 2);
            int c = startX < x ? pow(startX + x, 2): pow(2 * m - startX - x, 2);
            dist = min(a, min(b, c));
        }
        else {
            int a = pow(startX - x, 2) + pow(startY + y, 2);
            int b = pow(startX + x, 2) + pow(startY - y, 2);
            int c = pow(2 * m - x - startX, 2) + pow(startY - y, 2);
            int d = pow(2 * n - y - startY, 2) + pow(startX - x, 2);
            dist = min(a, min(b, min(c, d)));
        }
        answer.push_back(dist);
    }
    
    return answer;
}