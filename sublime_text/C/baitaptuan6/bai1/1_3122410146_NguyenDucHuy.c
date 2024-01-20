#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>
int tinhTongCacChuSo(int arr[], int size)
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        sum += arr[i];
    }

    return sum;
}

void daoNguocChuoi(char *str)
{
    int len = strlen(str);
    char temp;
    char *start = str;
    char *end = str + len - 1;

    while (start < end)
    {
        temp = *start;
        *start = *end;
        *end = temp;
        start++;
        end--;
    }
}

int main(int argc, char const *argv[])
{
    if (argc != 2)
    {
        printf("chỉ truyền 2 tham số\n");
        return 1;
    }
    const char *numStr = argv[1];
    int len = strlen(numStr); // lấy độ dài của tham số
    char numCopy[len];
    strcpy(numCopy, numStr);
    printf("%s\n", numCopy);
    if (numCopy <= 0)
    {
        printf("nhập số nguyên dương");
        return 1;
    }
    printf("bắt đầu chương trình\n");
    int pid = fork();
    if (pid > 0) // tiến trình cha
    {
        wait(NULL);
        printf("tiến trình cha chạy:\n");

        FILE *out1;
        out1 = fopen("out1.txt", "r");

        if (out1 == NULL)
        {
            printf("Không thể mở tệp tin.\n");
            return 1;
        }

        int data[40];
        int count = 0;
        while (fscanf(out1, "%d", &data[count]) != EOF)
        {
            count++;
            if (count >= 40)
            {
                printf("Mảng số nguyên đã đầy.\n");
                break;
            }
        }
        fclose(out1);
        int size = sizeof(data) / sizeof(data[0]);
        printf("tổng các chữ số: %d\n", tinhTongCacChuSo(data, size));
    }
    // tiến trinh con
    else if (pid == 0)
    {
        printf("tiến trình con chạy:\n");
        daoNguocChuoi(numCopy);
        printf("Chuỗi đảo ngược: %s\n", numCopy);

        FILE *out1;
        out1 = fopen("out1.txt", "w");
        if (out1 == NULL)
        {
            printf("Không thể mở tệp tin.\n");
            return 1;
        }
        for (int i = 0; i < strlen(numCopy); i++)
        {
            fprintf(out1, "%c\n", numCopy[i]);
        }

        fclose;
    }
    else
    {
        printf("lỗi tiến trình con\n");
    }
    printf("kết thúc chương trình\n");
    return 0;
}
