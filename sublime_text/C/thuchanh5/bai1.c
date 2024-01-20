#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
int main(int argc, char *argv[]){
	if(argc!=2){
		printf("Vui long nhap dung 2 tham so!\n");
		return 1;
	}
	int n = atoi(argv[1]);
	printf("Khoi tao chuong trinh\n");
	int pid = fork();
	if(pid>0){
		srand(time(NULL)%getpid());
		sleep(rand()%3);
		printf("\nTien trinh cha: \n");
		for(int i=1;i<=n;i++){
			if(i%2==0)
				printf("%d ",i);
		}
	}
	else if(pid==0){
		srand(time(NULL)%getpid());
		sleep(rand()%3);
		printf("\nTien trinh con: \n");
		for(int i=1;i<=n;i++){
			if(i%2==1)
				printf("%d ",i);
		}
	}
	else{
		printf("Loi tao tien trinh con!\n");
		return 2;
	}
	printf("\nKet thuc chuong trinh\n");
	return 0;
}
