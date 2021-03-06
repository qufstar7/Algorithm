>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)

# 탐욕법
부분적인 최적해가 전체적인 최적해가 되는 방법
## 그리디 알고리즘
* 동적 프로그래밍 비효율성 보완
* 각 단계마다 최선의 방법을 선택하는 현재지향적 알고리즘
* 모든 경우에 통하지 않음
  * 대표 예시 : 마시멜로 실험
  *  시간이 지날 때마다 지수폭발적으로 얻는 결과값이 커진다면 최대한 기다렸다가 결과를 받는 것이 이득, 하지만 그리디 알고리즘방식을 사용하면 기다리지 않음.
  *  주로 해답을 찾는 과정에서 그리디로 구한 값을 비교값으로 사용
### 잘 통하는 경우
*  ***탐욕 선택 속성***
*  ***최적 부분 구조***
   *  위 특성을 가지는 문제들을 해결하는데 강점이 있다.
   *  한 번의 선택이 다음 선택에 전혀 무관한 값이어야 하고 매 순간의 최적해가 문제에 대한 최적해여야 한다.
*  ***최적 부분 구조***는 문제를 해결하는 최적의 방법이 부분 문제에 대한 최적의 해결 방법으로 구성되는 구조를 뜻한다.
## 대표문제 1. 활동 선택 문제
### 한 강의실에서 여러 개의 수업을 할 때 한 번에 가장 많은 수업을 할 수 있는 경우
* 직관적 풀이
  * 다른 활동들을 더 많이 선택하기 위해 첫 번째 활동을 최대한 일찍 끝낸다
## 대표문제 2. 분할 가능 문제
### 물건이 무거울 경우 쪼개서 넣을 수 있는 배낭 문제
* 직관적 풀이
  * 무게 대비 가치가 높은 것들을 먼저 넣는다


# 문제1. 체육복(level1)
## 문제 설명
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

### 제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
### 입출력 예
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
### 입출력 예 설명
### 예제 #1
1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

### 예제 #2
3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

### 출처
>http://hsin.hr/coci/archive/2009_2010/contest6_tasks.pdf

## 풀이1
* 그리디 알고리즘 방법으로 풀어보자
* 앞 번호 우선 - 여분의 체육복을 가진 학생의 앞, 뒤 번호의 학생 둘 다 체육복을 잃어버렸다면 앞 번호 먼저 준다.
```java
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        for(int i = 0; i < reserve.length; i++){
            for(int j = 0; j < lost.length; j++){
                if(reserve[i] - 1 == lost[j]){
                    System.out.println("reserve["+i+"] : "+reserve[i]+" matches with lost["+j+"] : "+lost[j]);
                    reserve[i]=0;
                    lost[j]=0;
                }
                if(reserve[i] + 1 == lost[j]){
                    System.out.println("reserve["+i+"] : "+reserve[i]+" matches with lost["+j+"] : "+lost[j]);
                    reserve[i]=0;
                    lost[j]=0;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < lost.length; i++){
            if(lost[i]!=0){
                cnt++;
            }
        }
        
        int answer = n-cnt;
        
        return answer;
        
    }
}
```
* 여분의 체육복을 가진 학생 번호 -1 또는 +1과 일치하는 번호의 체육복을 잃어버린 학생이 있다면 두 학생의 번호를 0으로 바꿨다.  (print로 중간 확인)
* 체육복을 잃어버린 학생들 중 번호가 0이 아닌 학생들의 수를 세서 cnt에 넣었다.  
* 그리고 n-cnt의 값을 return
###  풀이1 실행결과
* 정확성  테스트  
테스트 1 〉	실패 (16.83ms, 53.8MB)  
테스트 2 〉	통과 (21.35ms, 53.6MB)  
테스트 3 〉	통과 (20.30ms, 54.1MB)  
테스트 4 〉	실패 (17.61ms, 53.7MB)  
테스트 5 〉	실패 (16.49ms, 54MB)  
테스트 6 〉	통과 (17.83ms, 53.6MB)  
테스트 7 〉	실패 (17.16ms, 54.1MB)  
테스트 8 〉	통과 (51.25ms, 53MB)  
테스트 9 〉	통과 (20.19ms, 53.6MB)  
테스트 10 〉	통과 (16.36ms, 54MB)  
테스트 11 〉	통과 (15.95ms, 53.4MB)  
테스트 12 〉	실패 (19.18ms, 53.3MB)  
* 채점 결과  
정확성: 58.3  
합계: 58.3 / 100.0  
> 테스트 케이스에 따라서 최적의 해결방법이 아닐 수도 있다
> 예를 들어 lost[] = 1,2,3,4 이고 reserve[] = 
## 풀이 2 
* 여벌 학생이 도난 당했을 경우 자신의 여벌 옷을 입어야 하므로 그 경우를 추가했다.
```java
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
		// 여벌 가져온 학생이 도난 당했을 경우
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					reserve[i] = 0;
					lost[j] = 0;
				}
			}
		}
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				// 체육복 빌려주기 (앞 번호 부터)
				if (reserve[i] - 1 == lost[j]) {
					reserve[i] = 0;
					lost[j] = 0;
				}
				if (reserve[i] + 1 == lost[j]) {
					reserve[i] = 0;
					lost[j] = 0;
				}
			}
		}
        int cnt = 0;
		for (int i = 0; i < lost.length; i++) {
			if (lost[i] != 0) {
				cnt++;
			}
		}
		int answer = n - cnt;
		return answer;
    }
}
```
###  풀이2 실행결과
* 정확성  테스트
  * 테스트 1 〉	실패 (0.03ms, 52.8MB)
  * 테스트 2 〉	실패 (0.03ms, 52MB)
  * 테스트 3 〉	실패 (0.03ms, 53.9MB)
  * 테스트 4 〉	실패 (0.03ms, 52.6MB)
  * 테스트 5 〉	통과 (0.03ms, 53.2MB)
  * 테스트 6 〉	통과 (0.02ms, 51.6MB)
  * 테스트 7 〉	통과 (0.07ms, 52.5MB)
  * 테스트 8 〉	통과 (0.04ms, 52.1MB)
  * 테스트 9 〉	실패 (0.04ms, 52.3MB)
  * 테스트 10 〉	실패 (0.04ms, 52.1MB)
  * 테스트 11 〉	통과 (0.05ms, 52.3MB)
  * 테스트 12 〉	실패 (0.02ms, 52.7MB)
* 채점 결과
  * 정확성: 41.7
  * 합계: 41.7 / 100.0   
>> 이상하게 더 점수가 낮아졌다.   
>> 맞았던 것도 틀리고 틀렸던 것도 맞은게 있다.

## 풀이3
```java
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
		// 여벌 가져온 학생이 도난 당했을 경우
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					lost[j] = -1;
					reserve[i] = -1;
				}
			}
		}

		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				// 체육복 빌려주기
				if (reserve[i] - 1 == lost[j] || reserve[i] + 1 == lost[j]) {
					lost[j] = -1;
					reserve[i] = -1;
				}
			}
		}
        int cnt = 0;
		for (int i = 0; i < lost.length; i++) {
			if (lost[i] != -1) {
				cnt++;
			}
		}
		int answer = n - cnt; 
		return answer;
    }
}
```
>> 초기화를 0이 아닌 -1로 바꿨다.  
>> 학생의 번호가 0번일 수는 있어도 -1일수는 없다고 생각
## 풀이3 결과
* 정확성  테스트  
테스트 1 〉	통과 (0.02ms, 52.1MB)  
테스트 2 〉	통과 (0.03ms, 52.6MB)  
테스트 3 〉	통과 (0.03ms, 52.5MB)  
테스트 4 〉	통과 (0.05ms, 52.7MB)  
테스트 5 〉	통과 (0.05ms, 52.2MB)  
테스트 6 〉	통과 (0.02ms, 52MB)  
테스트 7 〉	통과 (0.05ms, 51.9MB)  
테스트 8 〉	통과 (0.01ms, 51.8MB)  
테스트 9 〉	통과 (0.02ms, 53.1MB)  
테스트 10 〉	통과 (0.05ms, 52.5MB)  
테스트 11 〉	통과 (0.02ms, 53.1MB)  
테스트 12 〉	통과 (0.02ms, 53.7MB)  
* 채점 결과  
정확성: 100.0  
합계: 100.0 / 100.0  
>> 전부 맞았다!!  
>> 결론적으로 테스트케이스를 정확히 알 수는 없지만 학생들의 번호가 0인 케이스가 있다.  
### 알고리즘 정리
1. 여벌 가져온 학생이 도난 당했을 경우 자신의 체육복을 입게 하고
2. 남은 학생들이 앞 또는 뒤 번호의 학생에게 체육복을 빌려준 뒤
3. 전체 학생 수에서 체육복이 없는(빌리지 못한) 학생 수를 빼주면 답을 구할 수 있다.

## 풀이4 (타인의 답)
```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
```
* people[]배열을 생성하고  
* lost[]과 reserve[]을 향상된 for문을 이용해 people배열에 1또는 -1을 넣고  
* people[]배열의 요소가 -1일 경우 즉, lost배열에 해당하는 상황에
  * people[i-1] ==1 이면( 앞사람이 체육복 여벌 o) 체육복을 빌려서, 줘서 people[i]++; people[i-1]--;  
  * 또는 answer--;
* 즉, 새로운 배열에 전체 학생들의 체육복 빌려주기 빌리기 여부를 넣고 빌리지 못한 경우 전체 학생 수 n에서 -1 해서 수업 가능한 학생 수를 구한다

# 문제2 : 조이스틱

## 문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.  
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.
```
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
```
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
```
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
```
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

## 제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.

## 입출력 예
name	return
"JEROEN"	56
"JAN"	23

> 출처 https://commissies.ch.tudelft.nl/chipcie/archief/2010/nwerc/nwerc2010.pdf

## 알고리즘 풀이  
알파벳 이름을 왼쪽 문자부터 작성하고 맨 처음에 A로만 이루어져 있다.

JAZ나 JAN과 같은 경우 J를 계산하고 ◀ 버튼을 누르면 3번째 문자로 커서가 이동한다.(맨 오른쪽 문자인 Z와 N) 3번째 문자를 계산하고 1번째 문자에서 3번째 문자로 커서를 이동시키기위해 누른 1번을 추가한다.

정리하자면 조작 횟수를 구하려면
1. 각 자리 문자를 설정하기 위한 조작 횟수를 더한다.
2. 커서 이동 횟수를 더한다.

* 알파벳에 각각 번호를 매기고 간단하지만 참고할 수 있게 정리
```
1~5  abcde
6~10  fghij
11~15 klmno
16~20 pqrst
21~25 uvwxy
26 z
```

입출력 예시를 보자

|name|return|
|---|---|
"JEROEN"|	56
"JAN"|	23

먼저 2번째 예제인 "JAN"을 계산해보자.

|순서|문자 또는 커서이동|조작횟수|
|---|---|---|
1|J|▲ x 9
2|J > N|◀ x 1
3|N|▼ x 13

이렇게 조작횟수는 26임을 알 수 있다.

여기서 주의해야 할 점은 첫번째로 N을 설정할 경우 ▲보다 ▼를 눌러 이동하는 것이 1회 더 적게 조작할 수 있다(▲은 14, ▼은 13)는 것과 두번째로 A는 기본값 그대로 놔두면 되므로 알파벳 설정과 커서 이동이 필요하지 않다는 것이다.

1번째 예제인 "JEROEN"을 계산해보자.

|순서|문자 또는 커서이동|조작횟수|
|---|---|---|
1|J|▲ x 9
2|J > E|▶ x 1
3|E|▲ x 4
4|E > R|▶ x 1
5|R|▼ x 9
6|R > O|▶ x 1
7|O|▼ x 12
8|O > E|▶ x 1
9|E|▲ x 4
10|E > N|▶ x 1
11|N|▼ x 13

조작횟수를 계산해보면 9+1+4+1+9+1+12+1+4+1+13=56임을 확인할 수 있다.

위에서 정리한 조작횟수를 구하는 방법(각 알파벳 이동횟수 + 커서 이동횟수)과 일치한다.

알고리즘을 짜기 위한 논리 일반화를 해보면
1. A가 아닌 알파벳의 설정횟수를 구한다
2. 총 문자의 수에서 -1 - A의 개수(총 커서 이동횟수)를 구한다.

## 풀이 1
위의 알고리즘 풀이에 기반하여 코드를 작성하였다.
1. 커서이동횟수를 CursorMoves변수에 len(name) - 1 과 len(name)-1 -name.count('A') 로 계산하였다.
2. 문자설정횟수를 ChrMoves 변수에 ord-65 과 13보다 클시 26 - (ord-65)으로 계산하였다.
```py
def solution(name):
    
    list(name)
    ChrMoves = 0
    for i in name:        
        ordNum = ord(i)-65
        if ordNum > 13 :
            ordNum = 26 - ordNum        
        ChrMoves += ordNum

    CursorMoves = len(name)-1
    if 'A' in name: 
        CursorMoves = len(name)-1 -name.count('A')    
    
    answer = CursorMoves + ChrMoves
    return answer
```

### 실행결과
![joystick-1](image/joystick-1.png)
위와같이 테스트케이스 2개는 성공하였다.

하지만 채점시 테스트케이스 3,4,5,7,11에서 실패하였다.

충분히 예상하였다. A가 여러개 들어있거나 복잡하게 섞여있을 경우 계산이 틀릴 것이라고 생각했었기 때문이다.

## 풀이 1-2
테스트 케이스를 몇 개 추가한 후 계산해보자.
* 테스트 케이스 3 : "AAA" 
  * A만 여러 개 있을 경우 조작 횟수의 최솟값은 당연히 0이다 하지만 위의 풀이1 코드에선 -1과 같은 음수가 나올 수 있다.
  * 따라서 코드를 추가하였다.
  ```py
      if CursorMoves < 0:
        CursorMoves = 0
  ```
* 테스트 케이스 4 : "JANA"
  * A가 2개 들어 있고 A 중간에 문자가 있을 경우이다.
  * 기댓값은 27이지만 결과는 23이 나왔다. 
  * A를 설정하지 않아도 되지만 커서 이동을 위한 횟수는 추가해야 되기 때문에 숫자가 작게 나온 것이다.

* 테스트 케이스 5 : "JAAN"

* 테스트 케이스 6 : "BBAAAABB"
  * A가 중간에 여러개 있을 경우
  * A가 나올때까지 계산후 왼쪽으로 조이스틱을 조작해야 한다.
  * 위의 기댓값은 8이다.

테스트케이스 4와 5를 통해 알게 된것은 A가 여러개 있을 경우 계산이 잘못 될 수 있다는 것이다.

또한 테스트케이스 6과 같은 경우 조이스틱 좌우 이동 계산시 크게 오차가 생긴다.

커서 이동 횟수(좌우이동)를 계산하는 코드를 수정해야 한다.

## 풀이 2
```py
def solution(name):
    answer = 0
    ChrMoves = 0
    CursorMoves = len(name) - 1
    next = 0
    
    for i, char in enumerate(name):
        ChrMoves += min(ord(char) - 65, ord('Z') - ord(char) + 1)
        
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
        
        PossibleMin = i + i + len(name) - next
        CursorMoves = min(CursorMoves, PossibleMin)

    answer = ChrMoves + CursorMoves
    return answer
```
* "BBAAAABB"로 확인해보자.
  * next = 2, next = 3 
  * next = 3, next = 4 
  * ... A가 4번 반복되므로 next = 6
  * PossibleMin = 1 + 1 + 8 - 6 = 4
  * CursorMoves = 7, 4중 최솟값이므로 4
  * answer = 4 + 4 = 8

### 수정사항
* enumerate(name)을 이용해 인텍스와 chr를 추출하여 하나의 코드로 계산하였다.
* min()을 이용하여 최소값을 사용하는 방식으로 코드를 간소화 하였다.
* next변수에 각 알파벳 인덱스 값을 1부터로 하는 값을 저장하여 테스트케이스 6과 같은 경우를 계산할 수 있도록 코드를 짯다.
  * 다음 문자가 A일 경우 next변수에 1을 더하고 A가 반복되는 만큼 반복한다.
  * PossibleMin변수에 i+i+len(name)-next으로 계산한 값을 저장한다.
  * 최솟값을 이용해 계산.

