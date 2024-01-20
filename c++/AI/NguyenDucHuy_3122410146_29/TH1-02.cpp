#include <bits/stdc++.h>
using namespace std;
bool checkSoNguyenTo(int num)
{
    if (num == 0 || num == 1)
    {
        return false;
    }
    for (int i = 2; i < num; i++)
    {
        if (num % i == 0)
        {
            return false;
        }
    }
    return true;
}
int main(int argc, char const *argv[])
{
    FILE *array2;
    array2 = fopen("/mnt/d/huycode/c++/AI/file/array2.txt", "r");
    int m, n;
    int count = 0;
    if (array2 == NULL)
    {
        cout << "không thể mở file" << endl;
        return 1;
    }

    if (fscanf(array2, "%d %d", &m, &n) != 2)
    {
        cout << "không thể đọc vào dòng đâu tiên" << endl;
        fclose(array2);
        return 1;
    }

    int array[m][n];
    int arrTotalRow[m]; // mảng lưu các giá trị tổng trên các dòng
    int arrTotalCol[n]; // mảng lưu các giá trị tổng trên các cột
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            fscanf(array2, "%d", &array[i][j]);
        }
    }

    for (int i = 0; i < m; ++i)
    {
        int flagTotalRow = 0; // cờ tính tổng cứ xong 1 dòng thì lại reset về 0 bài này em tự làm chỉ có dùng gpt làm công cụ search syntax
        for (int j = 0; j < n; ++j)
        {
            if (checkSoNguyenTo(array[i][j]) == true)
            {
                count++;
            }

            flagTotalRow += array[i][j];
        }
        arrTotalRow[i] = flagTotalRow;
    }

    for (int i = 0; i < n; i++)
    {
        int flagTotalCol = 0;
        for (int j = 0; j < m; j++)
        {
            flagTotalCol += array[j][i];
        }
        arrTotalCol[i] = flagTotalCol;
    }
    fclose(array2);

    FILE *array1;
    array1 = fopen("/mnt/d/huycode/c++/AI/file/array2.out", "w");
    fprintf(array1, "%d %s", count, "\n");

    for (int i = 0; i < m; i++)
    {
        fprintf(array1, "%d %s", arrTotalRow[i], " ");
    }
    fprintf(array1, "%s", "\n");
    for (int i = 0; i < n; i++)
    {
        fprintf(array1, "%d %s", arrTotalCol[i], " ");
    }
    fclose(array1);
    return 0;
}
