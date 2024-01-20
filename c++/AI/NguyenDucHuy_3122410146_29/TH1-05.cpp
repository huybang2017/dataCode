#include <bits/stdc++.h>
using namespace std;

void createNum(int n, int arr[])
{
    for (int i = 0; i < n; i++)
    {
        int num = rand() % (n * n) + 1;
        bool flag = false;
        while (!flag)
        {
            flag = true;
            for (int j = 0; j < i; j++)
            {
                if (arr[j] == num)
                {
                    num = rand() % (n * n) + 1;
                    flag = false;
                    break;
                }
            }
        }
        arr[i] = num;
    }
}

int main(int argc, char const *argv[])
{
    int n;
    cout << "Nhập n: ";
    cin >> n;

    srand(time(NULL));
    int arr[n];

    createNum(n, arr);

    FILE *taci;
    taci = fopen("/mnt/d/huycode/c++/AI/file/taci.txt", "w");

    for (int i = 0; i < n; i++)
    {
        fprintf(taci, "%d %s", arr[i], " ");
    }

    fclose(taci);
    return 0;
}
