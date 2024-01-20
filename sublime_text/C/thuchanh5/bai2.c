#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
int isPrime(int n){
	if(n<2)
		return 0;
	for(int i=2;i*i<=n;i++){
		if(n%i==0)
			return 0;
	}
	return 1;
}
int main(int argc, char *argv[]){
	if(argc!=2){
		printf("Vui long nhap dung 2 tham so!\n");
		return 1;
	}
	int n = atoi(argv[1]);
	printf("Khoi tao chuong trinh\n");
	int pid = fork();
	if(pid>0){
		int sum=0;
		srand(time(NULL)%getpid());
		sleep(rand()%3);
		printf("\nTien trinh cha: \n");
		for(int i=1;i<=n;i++)
			sum+=i;
		printf("Tong la: %d\n",sum);
	}
	else if(pid==0){
		srand(time(NULL)%getpid());
		sleep(rand()%3);
		printf("\nTien trinh con: \n");
		printf("Cac so nguyen to <= n la: ");
		for(int i=1;i<=n;i++){
			if(isPrime(i))
				printf("%d ",i);
		}
		printf("\n");
	}
	else{
		printf("Loi tao tien trinh con!\n");
		return 2;
	}
	printf("\nKet thuc chuong trinh\n");
	return 0;
}
