#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(int r1, int r2) {
    long long answer = 0;
    
    for(int x = 1; x <= r2; x++) {        
        long big = (long) floor(sqrt(pow(r2, 2) - pow(x, 2)));
        long small = (long) ceil(sqrt(pow(r1, 2) - pow(x, 2)));
        
        answer += (big - small + 1);
    }
    return answer * 4;
}