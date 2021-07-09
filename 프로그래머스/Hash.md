>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)
# 해시
### 해시는 Key-value쌍으로 데이터를 저장하는 자료구조
## [위키 - 해시 함수](https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98)
* 해시 함수는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수
* 해시 함수에 의해 얻어지는 값을 `해시 값, 해시 코드, 해시 체크섬, 해시` 라고 한다.
* 해시 값은 해시 테이블이라는 자료구조에서 빠른 데이터 검색을 위해 사용
* 큰 파일에서 중복되는 레코드를 찾을 수 있다.
* 사용 예시
  * DNS 시퀀스
  * 암호학
    * 매핑된 해시 값만으로는 원래 입력값을 알아내기 힘들다는 특징 이용)
  * 데이터의 무결성 확인
    * HMAC를 구성하는 블록
      * 메시지가 누구에게서 온 것인지 입증

# 문제 1. 완주하지 못한 선수(level 1)
## 문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.  

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
## 제한사항
* 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
* completion의 길이는 participant의 길이보다 1 작습니다.
* 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
* 참가자 중에는 동명이인이 있을 수 있습니다.
## 입출력 예
participant	|completion	|return
---|---|---
["leo", "kiki", "eden"]	|["eden", "kiki"]|	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	|["josipa", "filipa", "marina", "nikola"]	|"vinko"
["mislav", "stanko", "mislav", "ana"]	|["stanko", "ana", "mislav"]	|"mislav"
## 입출력 예 설명
### 예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

### 예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

### 예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

## 출처
> https://hsin.hr/coci/archive/2014_2015/contest2_tasks.pdf

## 알고리즘 풀이
## 풀이1
```java
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        int[] cnt= new int[participant.length];
        
        for(int i=0; i<participant.length; i++){
            for(int j=0; j<completion.length; j++){
                if(participant[i].equals(completion[j])){
                    cnt[i]++;
                }               
            }             
        }
        
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]==0){
                answer = participant[i];
            }
        }

        return answer;
    }
}
```
cnt[]배열을 이용해 참가자와 완주자를 무차별 대입해서 비교해 일치하는 값이 없으면 즉, cnt==0이면 해당 참가자를 반환하도록 하였다.
### 풀이1 실행결과
* 정확성  테스트  
테스트 1 〉	통과 (0.04ms, 51.8MB)  
테스트 2 〉	실패 (0.05ms, 55.8MB)  
테스트 3 〉	통과 (7.41ms, 52.4MB)  
테스트 4 〉	통과 (21.01ms, 53.4MB)  
테스트 5 〉	실패 (30.38ms, 53.8MB)  
* 효율성  테스트  
테스트 1 〉	실패 (시간 초과)  
테스트 2 〉	실패 (시간 초과)  
테스트 3 〉	실패 (시간 초과)  
테스트 4 〉	실패 (시간 초과)  
테스트 5 〉	실패 (시간 초과)  
* 채점 결과  
정확성: 30.0  
효율성: 0.0  
합계: 30.0 / 100.0  
### 풀이1 피드백
동명이인이 있는 케이스는 통과하지 못함.  
participant[]와 completion[]의 모든 인자를 비교하기 때문에 효율성이 떨어짐

## 풀이2
```java
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        int[] cnt= new int[participant.length];
        
        for(int i=0; i<participant.length; i++){
            for(int j=0; j<completion.length; j++){
                if(participant[i].equals(completion[j])){
                    cnt[i]++;
                    completion[j]="";
                    break;
                }               
            }             
        }
        
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]==0){
                answer = participant[i];
            }
        }

        return answer;
    }
}
```
참가자와 완주자가 일치할경우 cnt++ 뿐만 아니라 완주자의 이름을 공백으로 바꿔주고 break문을 사용해서 효율성을 올렸다.
### 풀이2 실행 결과
* 정확성  테스트  
테스트 1 〉	통과 (0.04ms, 52.6MB)  
테스트 2 〉	통과 (0.04ms, 52.2MB)  
테스트 3 〉	통과 (4.76ms, 52.9MB)  
테스트 4 〉	통과 (21.19ms, 53.6MB)  
테스트 5 〉	통과 (12.86ms, 54.3MB)  
* 효율성  테스트  
테스트 1 〉	실패 (시간 초과)  
테스트 2 〉	실패 (시간 초과)  
테스트 3 〉	실패 (시간 초과)  
테스트 4 〉	실패 (시간 초과)  
테스트 5 〉	실패 (시간 초과)  
* 채점 결과  
정확성: 50.0  
효율성: 0.0  
합계: 50.0 / 100.0  
### 풀이2 피드백
테스트는 5개 모두 통과했지만 효율성 테스트는 전혀 통과하지 못하였다.  
break문 사용만으로는 효율성 올리기가 부족하였다.  
전혀 다른 방식으로 풀어서 효율성을 올려야겠다.

## 풀이3
```java
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);   
        Arrays.sort(completion);    
        int i;
        for(i = 0; i<participant.length-1; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];    
                return answer;
            }
        }
        if(i == participant.length-1) {
            answer = participant[i];    
        }
        return answer;
    }
}
```
import가 가능하다는 것을 알고
Arrays.sort를 이용해 참가자와 완주자 배열을 각각 정렬하고 참가자와 완주자의 요소를 비교하여 일치하지 않을 경우 해당 참가자를 (answer변수 값으로 할당하여) 리턴하였다
### 풀이3 실행 결과
* 정확성  테스트  
테스트 1 〉	통과 (0.26ms, 52.7MB)  
테스트 2 〉	통과 (0.28ms, 52.9MB)  
테스트 3 〉	통과 (3.43ms, 53.4MB)  
테스트 4 〉	통과 (5.54ms, 53.5MB)  
테스트 5 〉	통과 (5.32ms, 53.8MB)  
* 효율성  테스트  
테스트 1 〉	통과 (98.28ms, 82MB)  
테스트 2 〉	통과 (207.29ms, 88.3MB)  
테스트 3 〉	통과 (254.13ms, 90.6MB)  
테스트 4 〉	통과 (309.56ms, 96.1MB)  
테스트 5 〉	통과 (278.85ms, 95.2MB)  
* 채점 결과  
정확성: 50.0  
효율성: 50.0  
합계: 100.0 / 100.0  
### 풀이3 피드백
해당 문제의 범주가 hash인만큼 hash를 이용하는 방법도 확인하자.
## 풀이4 (타인의 답)
```java
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
```
>> java.util.HashMap 클래스의 `put, getOrDefault, keySet, get` 메소드를 사용하였다.  
중요 : **getOrDefault 메소드**
### 풀이4 실행 결과 
* 정확성  테스트  
테스트 1 〉	통과 (0.08ms, 52.6MB)  
테스트 2 〉	통과 (0.07ms, 51.9MB)  
테스트 3 〉	통과 (0.75ms, 53.5MB)  
테스트 4 〉	통과 (1.53ms, 54.1MB)  
테스트 5 〉	통과 (1.43ms, 53MB)  
* 효율성  테스트  
테스트 1 〉	통과 (48.47ms, 83.1MB)  
테스트 2 〉	통과 (78.32ms, 90.5MB)  
테스트 3 〉	통과 (80.74ms, 94.4MB)  
테스트 4 〉	통과 (109.51ms, 97MB)  
테스트 5 〉	통과 (112.74ms, 95.4MB)  
* 채점 결과  
정확성: 50.0  
효율성: 50.0  
합계: 100.0 / 100.0  
>> Arrays.sort보다 확실히 정확성, 효율성테스트 속도가 빠르다.
## 풀이5 (타인의 답)
```java
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Long> participantMap = Arrays.asList(participant).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String name : completion) {

            Long value = participantMap.get(name) - 1L;

            if(value == 0L) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, value);
            }
        }

        return participantMap.keySet().iterator().next();
    }
}
```
>> 현대적인 문법의 섹시한 답안.  
깔끔한문법에 Map으로 풀어 호환성도 높다  
오토언박싱을 생각해 Long을 사용  
### 풀이5 실행 결과
* 정확성  테스트  
테스트 1 〉	통과 (5.26ms, 53.3MB)  
테스트 2 〉	통과 (5.46ms, 52.7MB)  
테스트 3 〉	통과 (7.51ms, 53.3MB)  
테스트 4 〉	통과 (10.30ms, 53.9MB)  
테스트 5 〉	통과 (9.47ms, 54.3MB)  
* 효율성  테스트  
테스트 1 〉	통과 (76.65ms, 84.8MB)  
테스트 2 〉	통과 (114.92ms, 88.1MB)  
테스트 3 〉	통과 (114.49ms, 93.4MB)  
테스트 4 〉	통과 (133.56ms, 95.7MB)  
테스트 5 〉	통과 (101.37ms, 96.6MB)  
* 채점 결과  
정확성: 50.0  
효율성: 50.0  
합계: 100.0 / 100.0  
>> HashMap보다 효율성을 부족하지만 다양한 메소드를 알아두면 좋을 것.

# 문제 2. 전화번호 목록(level 2)






# 문제 3. 위장(level 2)







# 문제 4. 베스트앨범(level 3)