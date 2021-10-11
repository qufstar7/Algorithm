>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)

# 스택/큐

## 스택
* 제한적으로 접근할 수 있는 나열 구조
* 그 접근 방법은 언제나 목록의 끝에서만 발생
* 끝먼저내기 목록(Pushdown list)이라고도 한다.
* 스택은 한 쪽 끝에서만 자료를 넣거나 뺄 수 있는 선형 구조(LIFO - Last In First Out)으로 되어 있다.
* 자료를 넣는 것을 '밀어넣는다' 하여 푸쉬(push)라고 하고 반대로 넣어둔 자료를 꺼내는 것을 팝(pop)이라고 한다.
* 컴퓨터에서 포인터라고 하는 자료의 위치 표시자와 넣고 빼는 명령어를 사용해서 스택을 이용한다. 
* 주로 함수를 호출할 때 인수의 전달 등에 이용된다. 
* LIFO의 특징을 이용하여 역폴란드 표기법을 이용한 프로그래밍 언어인 포스(Forth) 등에서도 이용된다.
### 스택 연산 예시
* S.top(): 스택의 가장 윗 데이터를 반환한다. 만약 스택이 비었다면 이 연산은 정의불가 상태이다.
* S.pop(): 스택의 가장 윗 데이터를 삭제한다. 스택이 비었다면 연산 정의불가 상태.
* S.push(): 스택의 가장 윗 데이터로 top이 가리키는 자리 위에(top = top + 1) 메모리를 생성, 데이터 x를 넣는다.
* S.empty(): 스택이 비었다면 1을 반환하고,그렇지 않다면 0을 반환한다.

### 스택 예제
```C
/* Stack Example */

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

int Stack[10];
int top=-1;

int push(int dat);
int pop(void);
int printstack(void);

int main(void) {
	int inval, innum;
	printf(" - Algorithm Stack - \n");
	printf("Made by POM(lovebeen04@gmail.com)\n");
	printf("=================================\n");
	printf("1. Push Value\n");
	printf("2. Pop Value\n");
	printf("3. Print Stack\n");
	printf("4. Exit\n");
	printf("=================================\n");
	printf("> Enter Number: ");
	scanf("%d", &inval);

	switch(inval) {
		case 1:
			system("cls");
			printf("> Enter Number: ");
			scanf("%d", &innum);
			push(innum);
			break;
		case 2:
			pop();
			break;
		case 3:
			printstack();
			break;
		case 4:
			system("pause");
			break;
		default:
			system("cls");
			printf(" Error\n");
			break;
	}

	return 0;
}

int push(int dat) {
	if(top >= 9) {
		system("cls");
		printf("Stack Overflow\n");
		getch();
		system("cls");
		main();
	} else {
		top++;
		Stack[top] = dat;
		system("cls");
		printf("Push %d\n", dat);
		getch();
		system("cls");
		main();
	}
}

int pop(void) {
	system("cls");
	if(top <= -1) {
		system("cls");
		printf("Stack Downflow\n");
		getch();
		system("cls");
		main();
	} else {
		Stack[top] = 0;
		top--;
		main();
	}
}
int printstack(void) {
	int a;
	system("cls");
	printf("=================================\n");
	for(a=9; a>=0; a--) printf("%d\n", Stack[a]);
	printf("=================================\n");
	getch();
	system("cls");
	main();
}
```

### LIFO
* Last In First Out
* 후입 선출
* 한 쪽 끝에서만 자료를 넣고 뺄 수 있는 자료구조
* 어떠한 종류의 데이터 구조에 저장되어 있는 항목들이 처리되는 것
* 작은 문을 가진 좁고 둘러싸인 승강기
* 승강기가 도착지에 다다를 때, 마지막에 탄 사람은 먼저 내려야 한다.

### push & pop
* 스택에 데이터를 넣는 것 = push
  * 스택에 데이터가 가득 찼는지 확인 후 push
* 스택에서 값을 빼는 것 = pop
  * 스택에 데이터가 있는지 확인후 pop


## 큐
* 컴퓨터의 기본적인 자료 구조의 한가지
* 먼저 집어 넣은 데이터가 먼저 나오는 FIFO(First In First Out)구조로 저장하는 형식을 말한다.
* 영어 단어 queue는 표를 사러 일렬로 늘어선 사람들로 이루어진 줄을 말하기도 하며, 먼저 줄을 선 사람이 먼저 나갈 수 있는 상황과 같다.
* 나중에 집어 넣은 데이터가 먼저 나오는 스택과는 반대되는 개념
* 프린터의 출력 처리나 윈도 시스템의 메시지 처리기, 프로세스 관리 등 데이터가 입력된 시간 순서대로 처리해야 할 필요가 있는 상황에 이용
* 큐에는 선형과 환형이 있다.

### put & get
* 큐는 put(insert)와 get(delete)을 이용하여 구현
* put는 큐에 자료를 넣는 것
* get은 큐에서 자료를 꺼내는 것
* front(head)와 rear(tail)는 데이터의 위치
  * front는 데이터를 get할 수 있는 위치
  * rear은 데이터를 put할 수 있는 위치를 의미한다. 
* 큐가 꽉 차서 더 이상 자료를 넣을 수 없는 경우(put 할 수 없는 경우)를 오버플로우(Overflow)
* 큐가 비어 있어 자료를 꺼낼 수 없는 경우(get 할 수 없는 경우)를 언더플로우(Underflow)라고 한다.
  * 선형 큐 : 막대 모양으로 된 큐, 크기가 제한되어 있고 빈 공간을 사용하려면 모든 자료를 꺼내거나 자료를 한 칸씩 옮겨야 한다는 단점이 있다.
  * 환형 큐 : 선형 큐의 문제점(배열로 큐를 선언할시 큐의 삭제와 생성이 계속 일어났을때, 마지막 배열에 도달후 실제로는 데이터공간이 남아있지만 오버플로우가 발생)을 보완한 것이 환형 큐,  front가 큐의 끝에 닿으면 큐의 맨 앞으로 자료를 보내어 원형으로 연결 하는 방식

### FIFO
* First In First Out
* 선입 선출
* 시간과 우선 순위와 관련된 데이터를 정리하고 이용하는 방식을 줄여 말하는 것
  * 선입선처리 행위에 따라 순서대로 처리함으로써 기술을 처리하거나 수요 충돌을 관리하는 대기의 원칙
  * FCFS, First-Come First-Served는 먼저 들어온 업무를 먼저 처리하는 방식을 말하며 선입선출과 거의 비슷한 뜻으로 혼용된다.
  * 주로 선입선출은 자료 또는 물건에 대한 성격이 강하고, 선입선처리는 작업에 대한 성격이 강하다.
* 먼저 온 것은 먼저 처리되고, 처리가 끝날 때까지 다음 것은 대기
* 대기하고 있는 각 항목은 대기열의 데이터 구조에 저장된다.
* 대기열에 추가된 첫 데이터는 제거될 첫 데이터가 되고, 그 다음의 이어지는 항목들 또한 이와 같은 순서가 되풀이되며 처리된다. 

### FIFO 자료구조
```c++
  struct fifo_node {
    struct fifo_node *next;
    value_type value;
  };

  class fifo
  {
    fifo_node *front;
    fifo_node *back;
    fifo_node *dequeue(void)
    {
      fifo_node *tmp = front;
      front = front->next;
      return tmp;
    }
    queue(value)
    {
      fifo_node *tempNode = new fifo_node;
      tempNode->value = value;
      back->next = tempNode;
      back = tempNode;
    }
  }

```

### linked queue
* 연결 리스트로 구현한 큐
* 연결 리스트로 구현한 큐는 연결 리스트를 사용한 것으로써, 큐의 길이를 쉽게 늘릴 수 있어 오버플로우가 발생하지 않는 것이 특징이다. 
* 필요에 따라 환형으로 만들 수도 있으며, 환형으로 만들지 않아도 삽입과 삭제가 제한되지 않아 편리하다.
