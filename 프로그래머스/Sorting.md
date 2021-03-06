>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)
# 정렬
출제 빈도 높음  
평균 점수 높음
### 정렬 알고리즘(sorting algorithm)이란 원소들을 번호순이나 사전 순서와 같이 일정한 순서대로 열거하는 알고리즘
## 조건 2가지
1. 출력은 비 내림차순(각각의 원소가 전 순서 원소에 비해 이전의 원소보다 작지 않은 순서)이다;
2. 출력은 입력을 재배열하여 만든 순열이다.

# 문제 1. K번째 수(level 1)

## 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

## 제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
## 입출력 예
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
## 입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

## 출처
> https://neerc.ifmo.ru/subregions/northern.html

## 풀이 1
```java
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int [commands.length];      
        
        for(int x = 0; x < commands.length; x++){
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];          
            int[] newArr = new int[j-i+1];
            newArr = Arrays.copyOfRange(array, i-1, j);                
            Arrays.sort(newArr);
            answer[x]=newArr[k-1];
        }
        
        return answer;
    }
}
```
* 0~commands.length동안 반복하는 반복문 사용
* 반복문의 지역변수 i, j, k과 newArr[]을 선언
* 배열을 자르는 메소드인 copyOfRange를 사용  
* array[] 배열을 i-1부터 j까지 잘라서 newArr[]에 저장  
* Arrays.sort로 정렬
* newArr[k-1]을 answer[]에 저장 후 리턴
### 풀이 1 실행 결과
* 정확성  테스트  
테스트 1 〉	통과 (0.45ms, 52.2MB)  
테스트 2 〉	통과 (0.44ms, 53.1MB)  
테스트 3 〉	통과 (1.69ms, 52.4MB)  
테스트 4 〉	통과 (0.43ms, 52.2MB)  
테스트 5 〉	통과 (0.45ms, 52.6MB)  
테스트 6 〉	통과 (0.48ms, 53MB)  
테스트 7 〉	통과 (0.48ms, 52.1MB)  
* 채점 결과  
정확성: 100.0  
합계: 100.0 / 100.0  

## 풀이2 (타인의 답)
>https://programmers.co.kr/learn/courses/30/lessons/42748/solution_groups?language=java

```java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
```
>> i, j, k변수를 선언하지 않고 commands[][]를 이용하여 직접 범위, 조건 지정

## 풀이3 (타인의 답)
>https://programmers.co.kr/learn/courses/30/lessons/42748/solution_groups?language=java
```java
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
}
```
>>라이브러리를 사용하지 않고 직접 구현하였다.(코테 고득점 가능)  
>>퀵정렬 (분할정복, 순환호출) 사용해 i부터 j까지 범위의 배열을 빼내고 정렬하였다.

## 풀이1 - python3
```py
def solution(array, commands):
    answer = []       
    count = 0
    while count < len(commands) :        
        x = commands[count][0]
        y = commands[count][1]
        z = commands[count][2]        
        temp = array[x-1:y]
        temp.sort()
        answer.append(temp[z-1])        
        count += 1    
    return answer
```
## 풀이2 - python3
```py
def solution(array, commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))
```

# 퀵정렬
* 찰스 앤터니 리처드 호어가 개발한 **정렬 알고리즘**
* 다른 원소와의 비교만으로 정렬을 수행하는 **비교 정렬**에 속한다.
* 퀵 정렬은 n개의 데이터를 정렬할 때, 최악의 경우에는 **O(n²)번**의 비교를 수행하고, 평균적으로 **O(n log n)번**의 비교를 수행한다.
* 불안정 정렬에 속한다.
* 분할 정복 알고리즘의 하나로 평균적으로 매우 빠른 수행속도를 자랑한다
* 합병 정렬과 달리 퀵 정렬은 리스트를 비균등하게 분할한다.
### 분할 정복 방법
  * 문제를 작은 2개의 문제로 분리하고 각각 해결하고 결과를 모아 원래의 문제를 해결하는 전략
  * 대개 순환 호출을 이용
  * 순환 호출이 한번 진행되면 최소 하나의 원소는 최종적으로 위치가 정해지므로 퀵정렬 알고리즘은 반드시 끝난다.
* 과정 설명
  1. ***피벗*** 선택
     * 리스트안의 한 요소 선택(고른원소 : 피벗)
  2. ***분할*** - 피벗 기준 분할
     * 왼쪽은 피벗보다 작은 것, 오른쪽은 피벗보다 큰 것
  3. ***정복*** - 부분 배열 정렬
     * 분할된 부분 리스트에 대하여 **순환호출**을 이용하여 정렬 반복
     * 부분 리스트에서도 다시 피벗을 정하고 피벗을 기준으로 2개의 부분리스트로 나누는 과정 반복
     * 부분 리스트들이 더 이상 분할이 불가능할 때까지 반복(리스트의 크기가 0이나 1이 될 때까지)
  4. ***결합*** - 하나로 합병
     * 정렬된 부분 배열들을 하나의 배열에 합병


# 문제 2. 가장 큰 수 

## 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

## 제한 사항
* numbers의 길이는 1 이상 100,000 이하입니다.
* numbers의 원소는 0 이상 1,000 이하입니다.
* 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
## 입출력 예
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"

## 풀이
### 알고리즘 생각하기
1. 앞자리 비교
   * 리스트의 모든 원소의 맨 앞자리를 비교,
   * 같은 수일 경우 2 번째 자리를 비교..
   * 정렬 후 모두 이어 붙인 후 str?
   * str()후 정렬?
   * str()이 아닌가?
2. 앞자리 리스트 생성, 활용, sort()
   * 원소의 앞 자리로 이루어진 리스트를 만들고 sort()? reversesort()?
   * 자리수 별로 리스트를 만든다?
   * 앞자리 리스트 3,3,3,5,9
   * 2자리 리스트 N,0,4,N,N N=None
   * 안될듯

3. shuffle
   * shuffle? 모든 경우의 수 구하고 크기 정렬?
   * 너무 오래 걸린다. 
   * numbers의 길이가 100,000일 경우 O(100,000!)만큼 복잡.

4. 정렬후 shuffle
   * 짬뽕 앞자리로 정렬 후 shuffle이용해서 나열 후 크기 비교

5. 앞자리만 비교(정수)
   * 앞자리만 비교 10, 100, 1000 으로 나눈 몫
   * 102 / 100 = 1
6. 문자열 후 비교
   * 문자열화 먼저 한 후에 비교하자
   * 문자 1, 2도 < , > 비교연산자로 비교하면 숫자처럼 비교된다.
        ```
        >>> '1'>'2'
        False
        >>> '2'>'1' 
        True
        ```
7. 모든 요소를 4자리수로
   * 모든 요소를 4자리수로 만들어서 비교
   * 앞자리를 따로 떼어내어 비교하는 방식의 다른 생각
   * numbers의 모든 수에 접근, 비교정렬뒤 큰 수부터 차례대로 이어붙인다.
   * 4자리수가 될때까지 각 숫자에 10을 곱하는 것을 반복
   * 3, 30 을 4자리수로 만들면 똑같이 3000이지만 3이 우선순위를 가져야함
   * 121, 12의 경우 12112과 12121을 올바르게 비교하지 못함
8. 그 수를 반복시켜 4자리 만들기
    ```py
    def solution(numbers):
        numbers = list(map(str, numbers))
        numbers.sort(key=lambda x: x*3, reverse=True)
        return str(int(''.join(numbers)))
    ```
   * 그 수를 반복시켜 4자리 만들기
   * map활용 가능
   * list * 3
9.  sort()의 고차원 활용
    ```py
    def solution(numbers):
        numbers = sorted(list(map(str, numbers)), key=lambda x: x*5, reverse=True)
        return str(int(''.join(numbers)))
    ```
   * 각 배열을 문자열로 변경
   * 문자열 곱하기
   * 내림차순 정렬
   * [0, 0, 0, 0]과 같은 케이스대비 위해 `str(int())`사용


# H-Index
## 문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

## 제한사항
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

## 입출력 예
|citations|	return|
|---|---|
|[3, 0, 6, 1, 5]|	3|

## 입출력 예 설명
이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

## 풀이
* 1 <= n <= 1000
* 0 <= 논문별 인용 횟수 <= 10000

### 중간값 구하기
```py
def solution(citations):
    citations.sort()
    divLen = len(citations) / 2
    shareLen = len(citations) // 2 
    midIndex = 0
    
    if divLen == shareLen : 
        midIndex = shareLen - 1
    else : 
        midIndex = shareLen
    
    h = citations[midIndex]
            
    answer = h
    return answer
```
* 입출력 예시를 보고 위처럼 중간값을 구하는 식으로 풀어보았지만 틀렸다.
* is_integer()와 같은 함수도 있다는 것을 알게 됐다.

### H-Index 구하기 풀이
```py
def solution(citations):
    citations.sort()
    n = len(citations)
    while True :
        for i, value in enumerate(citations):
            if value >= n and len(citations[i:]) >= n :
                return n
            else :
                n -= 1
```
1. 정렬
2. n 정의
3. citations의 순서와 값을 구하는 반복문 사용
    * 조건문 : 만약 값이 n보다 크거나 같고 해당 값보다 더 큰 값을 가진 요소들의 개수들이 n 보다 크거나 같을 경우 n을 리턴
    * else n 에서 1 뺀다.

### 결과
테스트 1 〉	통과 (0.05ms, 10.2MB)  
테스트 2 〉	통과 (0.09ms, 10.2MB)  
테스트 3 〉	통과 (0.08ms, 10.3MB)  
테스트 4 〉	통과 (0.08ms, 10.2MB)  
테스트 5 〉	통과 (0.07ms, 10.2MB)  
테스트 6 〉	통과 (0.08ms, 10.2MB)  
테스트 7 〉	통과 (0.03ms, 10.3MB)  
테스트 8 〉	통과 (0.01ms, 10.2MB)  
테스트 9 〉	통과 (0.01ms, 10.2MB)  
테스트 10 〉	통과 (0.04ms, 10.2MB)  
테스트 11 〉	통과 (0.09ms, 10.2MB)  
테스트 12 〉	통과 (0.01ms, 10.2MB)  
테스트 13 〉	통과 (0.08ms, 10.2MB)  
테스트 14 〉	통과 (0.08ms, 10.2MB)  
테스트 15 〉	통과 (0.09ms, 10.3MB)  
테스트 16 〉	통과 (0.00ms, 10.2MB)  