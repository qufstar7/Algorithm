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


## 문제 설명
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

* 구조대 : 119
* 박준영 : 97 674 223
* 지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

## 제한 사항
* phone_book의 길이는 1 이상 1,000,000 이하입니다.
  * 각 전화번호의 길이는 1 이상 20 이하입니다.
  * 같은 전화번호가 중복해서 들어있지 않습니다.
## 입출력 예제
|phone_book|	return|
|---|---|
|["119", "97674223", "1195524421"]|	false|
|["123","456","789"]|	true|
|["12","123","1235","567","88"]|	false|
## 입출력 예 설명
### 입출력 예 #1
앞에서 설명한 예와 같습니다.

### 입출력 예 #2
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

### 입출력 예 #3
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

> 출처 : https://nordic.icpc.io/

## 알고리즘 풀이
## 풀이 1
```py
def solution(phone_book):
    phone_book = sorted(phone_book)

    for p1, p2 in zip(phone_book, phone_book[1:]):
        if p2.startswith(p1):
            return False
    return True
```
* `sorted()`를 이용해 phone_book을 오름차순 정렬
* `zip()`과 `startswith()`을 이용해 phone_book과 phone_book[1:]을 (phone_book 배열의 2번째 요소부터 슬라이싱한 것)을 비교한다. 
  * 예시
    ```
    print(phone_book)    
    print(phone_book[1:])
    ['12', '123', '1235', '567', '88']
    ['123', '1235', '567', '88']
    ```
    * phone_book과 phone_book[1:0]을 비교했을때 123은 12로 시작하므로 false
* hash를 사용하지 않았지만 매우 문자 길이 상관없이 문자열 정렬 후 접두사를 비교하되 비교시 나머지 전화번호와 비교하는 것이 아닌 다음 전화번호와 비교하는 면에서 매우 간단하고 효율적이다.

## 풀이 2
```py
def solution(phone_book):
    answer = True
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
    for phone_number in phone_book:
        temp = ""
        for number in phone_number:
            temp += number
            if temp in hash_map and temp != phone_number:
                answer = False
    return answer
```
* hash를 사용한 풀이 코드
* 해시는 쉽게 말해 key 값을 해시 함수에 입력해서 해시 값을 리턴받은 뒤 해시 값을 주소로 하는 저장공간을 찾아 그 저장공간에 있는 값을 찾아 읽는 것이다.
* 데이터를 아주 빠르게 삽입하거나 검색할 때 사용하는 기법으로 최소값이나 최댓값을 찾을 때(전체자료검색)는 효율이 떨어진다.
* 파이썬의 딕셔너리는 해시테이블로 구현되어 있다
* hash_map이라는 딕셔너리를 선언한다. `hash_map = {}`
* phone_book 리스트의 요소를 phone_number로 hash_map[phone_number]를 1로 모두 초기화 한다. 즉 phone_number를 key 값으로 해시 결과 값은 1로 한다.
* 그리고 중첩반복문을 통해 temp와 hash_map을 비교해 접두사가 같은 번호를 찾는다.
* 예시 phone_book 과정에 따른 변수 변화.
  ```
  ["119", "97674223", "1195524421"]
  phone_number= 119, temp = 119
  number = 1, 1, 9
  temp = 1, 11, 119
  temp in hash_map (119 in hash_map) and temp != phone_number (119 != 119)
  ```

## 풀이 3
* 해쉬를 사용하지 않았지만 풀이 2와 비슷한 방법
```py
def solution(phone_book) :
    for phone in phone_book : 
        temp = ''
        for num in phone :
            temp += num
            if temp in phone_book and temp != phone : 
                return False
    return True
```
* 해쉬를 사용하지 않아 입력 데이터의 양이 적을 경우 더 효율적이다.

## 자바
## 알고리즘
* 앞에서 부터 차례로 비교대상(a)으로 삼는다.
* a가 바로 뒷 번호(b)로 시작하는지, 즉 b가 a의 접두어인지 확인한다.
* 모든 요소를 비교하면서 접두어가 있으면 false를 return한다.
## 풀이 1
### 중첩 반복문을 이용한 상호 비교
* 중첩 for문을 사용해서 모든 요소를 비교한다.
* 2개의 조건문을 통해 a의 접두어가 b인지 b가 a의 접두어인지 교차비교한다.
* 입출력 테스트를 위해 replaceAll()에 정규표현식을 활용해 입력값을 정리하였다.
* 정리한 입력값의 앞에 " "공백이 있어 strip()을 활용하였다. (trim()도 가능하다.)
#### strip() vs trim()
* trim() - '\u0020' 이하의 공백들만 제거.
* strip() - 유니코드의 공백들을 모두 제거.
* trim()은 '\u2003' (EM SPACE)라는 공백을 제거할 수 없지만 strip()은 가능.
* strip()에는 stripLeading(), stripTrailing()이라는 메서드도 있다.(java 11 이상)
```java
package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneNumberList { // hash '전화번호 목록'
	
		public static String[] phone_book;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		String intStr = str.replaceAll("[\"\\[\\]]", "");
		phone_book = intStr.split(",");

		for (int i = 0; i < phone_book.length; i++) {
			phone_book[i] = phone_book[i].strip();
		}		

		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {	
		// 하나씩 전체와 비교(중첩 for문)
		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				// 비교대상 b가 a의 접두어 인지 확인
				if (phone_book[i].startsWith(phone_book[j])) {
					return false;
				}
				// a가 b의 접두어 인지 확인
				if (phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}

		return true;
	}
}
```
## 풀이 2
### 모든 번호를 hashing하고 접두어를 찾는 방식.
```java
package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList2 { // hash '전화번호 목록'

	public static String[] phone_book;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String intStr = str.replaceAll("[\"\\[\\]]", "");
		phone_book = intStr.split(",");

		for (int i = 0; i < phone_book.length; i++) {
			phone_book[i] = phone_book[i].strip();
		}

		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phoneBook) { // 1. HashMap을 선언한다.
		Map<String, Integer> map = new HashMap<>();

		// 2. 모든 전화번호를 HashMap에 넣는다.
		for (int i = 0; i < phoneBook.length; i++)
			map.put(phoneBook[i], i);

		// 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
		for (int i = 0; i < phoneBook.length; i++) {
			for (int j = 0; j < phoneBook[i].length(); j++) {
				if (map.containsKey(phoneBook[i].substring(0, j))) {
					return false;
                }
			}
		}
		return true;
	}
}

```
* Map타입의 map 참조변수에 HashMap 객체를 대입하여 사용.
* 모든 전화번호를 map에 put()
  * map에 `phoneBook[i]` 를 key로서 `i`를 value로서 넣는다. 
* 중첩for문을 사용하여 모든 전화번호의 substring이 map에 존재하는지 확인.


# 문제 3. 위장(level 2)
## 문제 설명
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

|종류|	이름|
|---|---|
|얼굴|	동그란 안경, 검정 선글라스|
|상의|	파란색 티셔츠|
|하의|	청바지|
|겉옷|	긴 코트|

스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

## 제한사항
* clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
* 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
* 같은 이름을 가진 의상은 존재하지 않습니다.
* clothes의 모든 원소는 문자열로 이루어져 있습니다.
* 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
* 스파이는 하루에 최소 한 개의 의상은 입습니다.
## 입출력 예
clothes|	return
---|----
[["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]|	5
[["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]|	3

## 입출력 예 설명
### 예제 #1
headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
```
1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses
```
### 예제 #2
face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
```
1. crow_mask
2. blue_sunglasses
3. smoky_makeup
```

> 출처 http://2013.bapc.eu/


## 알고리즘 풀이
```
```



# 문제 4. 베스트앨범(level 3)