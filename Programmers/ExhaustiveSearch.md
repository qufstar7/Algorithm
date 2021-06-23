>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)
# 완전탐색
출제 빈도 높음  
평균 점수 낮음
## brute force
브루트포스 라고도 한다  
가능한 모든 경우의 수를 다 확인해 답을 찾는 방법을 의미
* 직관적이고 이해하기 쉽고
* 문제의 정확한 결과값을 얻어낼 수 있는
* 확실하면서도 기초적인 방법
* 효율성의 문제 때문에 사용이 기피될 수 있다.
## 활용법
### 고려사항
1. 경우의 수 대략적 파악
2. 모든 방법 고려(브루트포스를 이용하기 위한 알고리즘 기법)
   1. 단순 브루트 포스(반복/조건문을 활용해 모두 테스트)
   2. 순열 - n개중 r개를 중복 허용없이 나열
   3. 재귀 호출
   4. 비트마스크 - 2진수 표현 기법 활용
   5. BFS, DFS 활용
3. 적용해 실제 답 도출 가능성 확인


# 문제 1. 모의고사(level1)
## 문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...  
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...  
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...  

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한 조건
* 시험은 최대 10,000 문제로 구성되어있습니다.
* 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
* 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
### 입출력 예
answers|	return
---|---
[1,2,3,4,5]|	[1]
[1,3,2,4,2]|	[1,2,3]
### 입출력 예 설명
### 입출력 예 #1
* 수포자 1은 모든 문제를 맞혔습니다.
* 수포자 2는 모든 문제를 틀렸습니다.
* 수포자 3은 모든 문제를 틀렸습니다.  

따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
### 입출력 예 #2
* 모든 사람이 2문제씩을 맞췄습니다.

## 풀이1
```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] score = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (person1[i % 5] == answers[i]) {
				score[0]++;
			}
			if (person2[i % 8] == answers[i]) {
				score[1]++;
			}
			if (person3[i % 10] == answers[i]) {
				score[2]++;
			}
		}
        
		ArrayList<Integer> list = new ArrayList<Integer>();		
		int max = 0;
		for (int i = 0; i < score.length; i++) {
			if (max <= score[i]) {
				max = score[i];
			}
		}
        
		for (int i = 0; i < score.length; i++) {
			if (max == score[i]) {
				list.add(i);
			}
		}
        
		int[] ans = new int[list.size()];		
		for (int i = 0; i < list.size(); i++) {
			ans[i]=list.get(i)+1;
		}	
        
		System.out.println(Arrays.toString(ans));
        return ans;
        
    }
}
```
* 각 수포자의 패턴을 배열로 저장
* 맞힌 갯수(점수)를 저장할 score 배열 선언
* 각 수포자의 패턴 배열을 각 패턴 갯수로 나눈 나머지 값을 이용해 각 수포자의 점수를 계산하고 score배열에 저장
* 최고 점수를 확인하고 max에 저장
* ArrayList 라이브러리를 이용
  * 동일 점수를 받은 사람이 있는지 확인
  * ArrayList list에 수포자 번호 삽입
  * list를 값에 1을 더해 ans배열에 저장 후 return
## 실행결과
* 정확성  테스트  
테스트 1 〉	통과 (0.22ms, 52.2MB)  
테스트 2 〉	통과 (0.25ms, 52.9MB)  
테스트 3 〉	통과 (0.20ms, 52.2MB)  
테스트 4 〉	통과 (0.20ms, 52.1MB)  
테스트 5 〉	통과 (0.26ms, 53.8MB)  
테스트 6 〉	통과 (0.62ms, 52.4MB)  
테스트 7 〉	통과 (0.70ms, 51.9MB)  
테스트 10 〉	통과 (0.65ms, 52.4MB)  
테스트 11 〉	통과 (1.15ms, 53.7MB)  
테스트 12 〉	통과 (0.98ms, 53.5MB)  
테스트 13 〉	통과 (0.70ms, 53.2MB)  
테스트 14 〉	통과 (1.17ms, 53.4MB)  
* 채점 결과  
정확성: 100.0  
합계: 100.0 / 100.0  

## 풀이 2 (타인의 답)
>>https://programmers.co.kr/learn/courses/30/lessons/42840/solution_groups?language=java

```java
import java.util.*;

class Solution {
    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
}
```
>> 2차원 배열에 패턴을 저장하고  
중첩 반복문을 사용해 정답 여부를 확인하였다.  
향상된 for문을 사용해 1등 배열을 구성한 것도 눈에 띈다.