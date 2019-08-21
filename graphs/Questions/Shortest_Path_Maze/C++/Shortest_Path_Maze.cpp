#include <bits/stdc++.h>
#define ll long long
#define vi vector<int>
using namespace std;
bool IsValid(int curr_x, int curr_y, int dist[][1001], char mat[][1001], int m,int n){
	return (curr_x >= 0 && curr_x < m) && (curr_y >= 0 && curr_y < n) && dist[curr_x][curr_y] == -1 &&
                    mat[curr_x][curr_y] != '#';
}
int main() {
    int m, n, i, j, x, y;
    //Storing distances to a particular point
    int dist[1001][1001];
    char mat[1001][1001];
    //Set all distances to -1
    memset(dist, -1, sizeof(dist[0][0]) * 1001 * 1001);
    cin >> m >> n;
    int srcx, srcy, exitx, exity;
    //To get the four adjacent cells
    int ci[] = {-1, 0, 0, 1}, 
        cj[] = {0, -1, 1, 0};

    for (i=0; i<m; i++) {
        string str; 
        cin >> str;
        for (j=0; j<n; j++) {
            mat[i][j] = str[j];
            dist[i][j] = -1;
            if (str[j] == 'S') {
                srcx = i; srcy = j;
            } 
            else if (str[j] == 'E') {
                exitx = i; exity = j;
            }
        }
    }
	
    queue< pair<int, int> > Q;
    dist[srcx][srcy] = 0;
    Q.push({srcx, srcy});
    while (!Q.empty()) {
        x = Q.front().first;
        y = Q.front().second;
        if(x==exitx&&y==exity){
        	break;
        }
        Q.pop();
        for (int i=0; i<4; i++) {
            int curr_x = x+ci[i];
            int curr_y = y+cj[i];
            if (IsValid(curr_x, curr_y, dist, mat, m, n)) {
                Q.push({curr_x, curr_y});
                dist[curr_x][curr_y] = dist[x][y] + 1;
               
            }
        }
    }

    cout << dist[exitx][exity] << endl;

    return 0;
}
