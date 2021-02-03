/* Gold 5, �̼����� �ȳ�! */

#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

int board[200][50];
int dx[] = { 0, -1, 0, 1 };
int dy[] = { -1, 0, 1, 0 };
int r, c, t;

void spread() {
	/*queue �����*/
	int temp[200][50] = { 0, };

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (board[i][j] > 0) {				//�̼����� �����ϸ�
				int particle = board[i][j] / 5;	// Ȯ�귮 ���
												//�����¿� ��ȿ���� ���̰� ����û���� �ƴϸ� Ȯ�귮 ���ϰ� �׸�ŭ �������� ����
				for (int n = 0; n < 4; n++) {
					int nx = i + dx[n];
					int ny = j + dy[n];

					if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
						if (board[nx][ny] != -1) {
							temp[nx][ny] += particle;
							temp[i][j] -= particle;
						}
					}

				}

			}
		}
	}

	//temp�� board�� ����
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			board[i][j] += temp[i][j];
		}
	}
	
}



void refresher() {

	//get refresher coord 
	vector<int> machine;
	for (int i = 0; i < r; i++) {
		if (board[i][0] == -1)	machine.push_back(i);
	}


	//  �Ʒ��ε���
	for (int i = machine[0] - 1; i > 0; i--)
	{
		board[i][0] = board[i - 1][0];
	}
	for (int i = 0; i < c - 1; i++)
	{
		board[0][i] = board[0][i + 1];
	}
	for (int i = 1; i <= machine[0]; i++)
	{
		board[i - 1][c - 1] = board[i][c - 1];
	}
	for (int i = c - 1; i > 1; i--)
	{
		board[machine[0]][i] = board[machine[0]][i - 1];
	}
	board[machine[0]][1] = 0;
		
	//�����ε���
	for (int i = machine[1] + 1; i < r - 1; i++)
	{
		board[i][0] = board[i + 1][0];
	}
	for (int i = 0; i < c - 1; i++)
	{
		board[r - 1][i] = board[r - 1][i + 1];
	}
	for (int i = r - 1; i >= machine[1]; i--)
	{
		board[i][c - 1] = board[i - 1][c - 1];
	}
	for (int i = c - 1; i > 1; i--)
	{
		board[machine[1]][i] = board[machine[1]][i - 1];
	}
	board[machine[1]][1] = 0;
		
}
	/*�ϵ��ڵ� ���..*/
	/*
	

	//1. �� ������ ���������صΰ� ��ĭ�� �б�
	int aright_1 = board[a][c-1], bright_1 = board[a][c-1];
	memmove(board[a] + 2, board[a] + 1, sizeof(int)*(c-1));
	board[a][1] = 0;
	memmove(board[b] + 2, board[b] + 1, sizeof(int)*(c - 1));
	board[b][1] = 0;

	//2,�� ������ �����صΰ� ���� ���Ʒ��� �а�,  [a-1][c-1]�� [b+1][c-1]�� last���� �־��ֱ� 
	int aright_2 = board[0][c - 1], bright_2 = board[r - 1][c - 1];
	memmove(board[0] + (c - 1), board[1] + (c - 1), sizeof(board[0])*(a-1));
	board[a-1][c - 1] = aright_1;

	//3. ��� ������.
	int aleft_1 = board[0][0], bleft_1 = board[r - 1][0];
	memmove(board[0], board[0] + 1, sizeof(int)* (c - 2));
	board[0][c - 2] = aright_2;
	*/


void printer() {

	cout << "\n";

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cout << board[i][j] << " ";
		}
		cout << "\n";
	}
	cout << "\n";
}

int main() {

	int answer = 0;

	//input
	cin >> r >> c >> t;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> board[i][j];
		}
	}
	
	while (t--) {
		spread();

		//printer();
		refresher();

		//printer();
	}

	//counter
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (board[i][j] > 0) answer += board[i][j];
		}
	}

	cout << answer;

	//system("pause");
	return 0;
}