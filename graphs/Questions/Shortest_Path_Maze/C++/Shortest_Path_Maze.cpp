// Question Link: https://www.codechef.com/problems/DAY4P2

#include <bits/stdc++.h>
using namespace std;
//To check if the location to traverse is valid
bool IsValid(int curr_x, int curr_y, int dist[][1001], 
	         char mat[][1001], int m,int n){
	return curr_x >= 0 && curr_x < m      //To make sure the coordinates
        && curr_y >= 0 && curr_y < n      //are not out of bounds
        && dist[curr_x][curr_y] == -1     //To check if the location has been visited or not
        && mat[curr_x][curr_y] != '#';    //To check if the location is a wall
}
int main() {
    int m, n, i, j, x, y;
    //Storing distances to a particular point
    int dist[1001][1001];
    char mat[1001][1001];
    //Set all distances to -1
    memset(dist, -1, sizeof(dist[0][0]) * 1001 * 1001);
    int srcx, srcy, exitx, exity;
    //To get the four adjacent cells
    int ci[] = {-1, 0, 0, 1}; 
    int cj[] = {0, -1, 1, 0};
    cin >> m >> n;
    for (i=0; i<m; i++) {
        string str; cin >> str;
        for (j=0; j<n; j++) {
            mat[i][j] = str[j];
            if (str[j] == 'S') {
                srcx = i; srcy = j;
            } 
            else if (str[j] == 'E') {
                exitx = i; exity = j;
            }
        }
    }
	dist[srcx][srcy] = 0;
    queue< pair<int, int> > Q;
    Q.push({srcx, srcy});
    while (!Q.empty()) {
        x = Q.front().first;
        y = Q.front().second;
        //If we have found the path to end cell
        if(x==exitx&&y==exity){
        	break;
        }
        Q.pop();
        //To check all 4 combinations
        for (int i=0; i<4; i++) {
            int curr_x = x+ci[i];
            int curr_y = y+cj[i];
            if (IsValid(curr_x, curr_y, dist, mat, m, n)) {
                //For pushing valid paths into queue and
                //Incrementing distance
                Q.push({curr_x, curr_y});
                dist[curr_x][curr_y] = dist[x][y] + 1;
            }
        }
    }

    cout << dist[exitx][exity] << endl;

    return 0;
}
