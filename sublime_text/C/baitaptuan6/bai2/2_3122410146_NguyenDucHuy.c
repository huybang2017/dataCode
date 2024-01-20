#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/time.h>
#include <time.h>
void collatz(int n)
{
    int result = n;
    int tmp = 0;
    while (result != 1)
    {
        if (result % 2 == 0)
        {
            result /= 2;
        }
        else
        {
            result = 3 * result + 1;
        }
        if (tmp < result)
        {
            tmp = result;
        }
        printf("%d ", result);
    }
    printf("Max: %d\n", tmp);
}
int main(int argc, char const *argv[])
{
    struct timeval start_time, end_time;
    gettimeofday(&start_time, NULL);
    if (argc != 2)
    {
        printf("nhập sai định dạng\n");
        return 1;
    }
    int num = atoi(argv[1]);
    if (num <= 0)
    {
        printf("nhập số nguyên dương\n");
        return 1;
    }
    int pid = fork();
    if (pid == 0)
    {
        printf("tiến trình con\n");
        collatz(num);
    }
    else if (pid > 0)
    {
        wait(NULL);
        gettimeofday(&end_time, NULL);

        double elapsed_time = ((end_time.tv_sec - start_time.tv_sec) * 1000 + (end_time.tv_usec - start_time.tv_usec)) * 0.000001;
        printf("tiến trình cha\n");
        printf("tổng thời gian chạy chương trình: %fs\n", elapsed_time);
    }
    else
    {
        printf("lỗi tiến trình con\n");
    }
    printf("kết thúc chương trình\n");

    return 0;
}
