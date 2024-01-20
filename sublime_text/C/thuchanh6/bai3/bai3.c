#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <stdbool.h>
#include <math.h>

int num;
void *tinhTong(void *arg)
{
    int sum = 0;
    int tmp = num;
    while (tmp > 0)
    {
        /* code */
        sum += tmp % 10;
        tmp /= 10;
    }
    printf("tổng các chữ số là: %d\n", sum);
}
bool kiemTraSoNguyenTo(int n)
{
    if(n < 2)
    {
        return false;
    }
    for(int i = 2; i <= sqrt(n); i++)
    {
        if(n % i == 0)
        {
            return false;
        }
    }
    return true;
}
void *inSoNguyenTo(void *arg)
{
    for (int i = 0; i < num; ++i)
    {
        if(kiemTraSoNguyenTo(i))
        {
            printf("số nguyên tố bé hơn n: %d\n", i);
        }
    }
}
int main(int argc, char const *argv[])
{
    num = atoi(argv[1]);
    pthread_t tid1, tid2;
    pthread_create(&tid1, NULL, tinhTong, NULL);
    pthread_create(&tid2, NULL, inSoNguyenTo, NULL);
    pthread_join(tid1, NULL);
    pthread_join(tid2, NULL);
    return 0;
}