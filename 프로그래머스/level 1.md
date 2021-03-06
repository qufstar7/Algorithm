>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)

# 프로그래머스 알고리즘 level 1

- [프로그래머스 알고리즘 level 1](#프로그래머스-알고리즘-level-1)
- [1. 로또의 최고 순위와 최저 순위](#1-로또의-최고-순위와-최저-순위)
  - [문제 설명](#문제-설명)
  - [제한사항](#제한사항)
  - [입출력 예](#입출력-예)
  - [입출력 예 설명](#입출력-예-설명)
    - [입출력 예 #1](#입출력-예-1)
    - [입출력 예 #2](#입출력-예-2)
    - [입출력 예 #3](#입출력-예-3)
  - [주의사항](#주의사항)
  - [내 풀이 - python](#내-풀이---python)
  - [다른 사람의 풀이](#다른-사람의-풀이)
    - [풀이 비교, 정리](#풀이-비교-정리)
    - [핵심 정리](#핵심-정리)
    - [피드백](#피드백)
  - [내 풀이 2 - java](#내-풀이-2---java)
    - [파이썬 풀이와 비교](#파이썬-풀이와-비교)
  - [다른 사람의 풀이'](#다른-사람의-풀이-1)
- [2. 신규 아이디 추천](#2-신규-아이디-추천)
  - [문제 설명](#문제-설명-1)
  - [[문제]](#문제)
  - [[제한사항]](#제한사항-1)
    - [입출력 예 #1](#입출력-예-1-1)
    - [입출력 예 #2](#입출력-예-2-1)
    - [입출력 예 #3](#입출력-예-3-1)
    - [입출력 예 #4](#입출력-예-4)
    - [입출력 예 #5](#입출력-예-5)
  - [내 풀이 - python](#내-풀이---python-1)
    - [간략화 버전](#간략화-버전)
  - [내 풀이 2 - java](#내-풀이-2---java-1)
- [3. 숫자 문자열과 영단어](#3-숫자-문자열과-영단어)
  - [문제 설명](#문제-설명-2)
  - [제한사항](#제한사항-2)
    - [입출력 예](#입출력-예-1)
    - [입출력 예 설명](#입출력-예-설명-1)
    - [입출력 예 #1](#입출력-예-1-2)
    - [입출력 예 #2](#입출력-예-2-2)
    - [입출력 예 #3](#입출력-예-3-2)
    - [제한시간 안내](#제한시간-안내)
  - [내 풀이](#내-풀이)
    - [결과](#결과)
  - [다른 사람의 풀이 1](#다른-사람의-풀이-1)
    - [결과](#결과-1)
  - [다른 사람의 풀이 2](#다른-사람의-풀이-2)
    - [결과](#결과-2)
  - [다른 사람의 풀이 3](#다른-사람의-풀이-3)
    - [결과](#결과-3)
- [4. [카카오 인턴] 키패드 누르기](#4-카카오-인턴-키패드-누르기)
  - [문제 설명](#문제-설명-3)
  - [풀이](#풀이)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>


# 1. 로또의 최고 순위와 최저 순위

## 문제 설명
`로또 6/45`(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 아래는 로또의 순위를 정하는 방식입니다. 

|순위|	당첨 내용|
|---|---|
|1|	6개 번호가 모두 일치|
|2|	5개 번호가 일치|
|3|	4개 번호가 일치|
|4|	3개 번호가 일치|
|5|	2개 번호가 일치|
|6(낙첨)|	그 외|

로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.  
알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.  

|당첨 번호|	31|	10|	45|	1|	6|	19|	결과|
|---|---|---|---|---|---|---|---|
최고 순위 번호|	3|	0→10|	44|	1|	0→6|	25|	4개 번호 일치, 3등
최저 순위 번호|	31|	0→11|	44|	1|	0→7|	25|	2개 번호 일치, 5등

* 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
* 알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
  * 3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
* 알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
  * 5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.

민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

## 제한사항
* lottos는 길이 6인 정수 배열입니다.
* lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
  * 0은 알아볼 수 없는 숫자를 의미합니다.
  * 0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
  * lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
* win_nums은 길이 6인 정수 배열입니다.
* win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
  * win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
  * win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
  
## 입출력 예
lottos|	win_nums|	result
---|---|---
[44, 1, 0, 0, 31, 25]|	[31, 10, 45, 1, 6, 19]|	[3, 5]
[0, 0, 0, 0, 0, 0]|	[38, 19, 20, 40, 15, 25]|	[1, 6]
[45, 4, 35, 20, 3, 9]|	[20, 9, 3, 45, 4, 35]|	[1, 1]
## 입출력 예 설명
### 입출력 예 #1
문제 예시와 같습니다.

### 입출력 예 #2
알아볼 수 없는 번호들이 아래와 같았다면, 1등과 6등에 당첨될 수 있습니다.

당첨 번호|	38|	19|	20|	40|	15|	25|	결과
---|---|---|---|---|---|---|---|
최고 순위 번호|	0→38|	0→19|	0→20|	0→40|	0→15|	0→25|	6개 번호 일치, 1등
최저 순위 번호|	0→21|	0→22|	0→23|	0→24|	0→26|	0→27|	0개 번호 일치, 6등


### 입출력 예 #3
민우가 구매한 로또의 번호와 당첨 번호가 모두 일치하므로, 최고 순위와 최저 순위는 모두 1등입니다.

## 주의사항
실제로 사용되는 로또 순위의 결정 방식과는 약간 다르지만, 이 문제에서는 지문에 명시된 대로 로또 순위를 결정하도록 합니다.  ↩


## 내 풀이 - python
```py
def solution(lottos, win_nums):
    answer = [1,1]
    li = [] 
    rank = [6,6,5,4,3,2,1] # 순위를 정하기 위한 배열 맞힌 개수(인덱스)에 따라 등수를 정함. (맞힌 개수가 0,1개면 6등, 2개면 5등, ...)
    maximumValue = 0
    minimumValue = 0
    
    # 0이 아닌 추첨 번호를 당첨 번호와 비교
    # 비교위해 li에 일치하는 번호와 0을 저장
    for i, a  in enumerate(lottos):
        if a == 0 :
            li.append(0)
        for j, b in enumerate(win_nums):
            if a == b :
                li.append(a)
    
    # rank 리스트를 이용하여 최대 맞힌 개수와 최소 맞힌 개수를 구함.
    maximumValue = rank[len(li)]
    minimumValue = rank[len(li) - li.count(0)]
    
    answer = [maximumValue ,minimumValue]
    return answer
```

## 다른 사람의 풀이
```py
def solution(lottos, win_nums):

    rank=[6,6,5,4,3,2,1]

    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans],rank[ans]
```

### 풀이 비교, 정리
내 풀이와 다른 사람의 풀이를 비교하면 순위를 비교하기 위해 리스트 [6,6,5,4,3,2,1]을 사용한 것은 같다.  
하지만 훨씬 간소화되었다.
* for문은 중첩해서 사용할 필요 없이 win_nums리스트의 요소를 lottos와 비교하여 존재 여부를 확인하면 되므로 
  ```py
  for x in win_nums:
      if x in lottos:
          
  ```
  와 같은 코드로 간소화하여 비교 가능하다.
* 또한 최솟값을 구하기 위한 0의 개수(지워져 알수 없는 번호)를 알기만 하면 되므로 내가 만든 li리스트는 필요없다.
  
### 핵심 정리
1. 순위를 매기기용 리스트 `rank = [6,6,5,4,3,2,1]` 활용
2. 최댓값, 최솟값을 찾는 방법 - 일치하는 번호의 개수를 인덱스로 하는 리스트의 값(인덱스는 맞힌 번호 수, 값은 순위)
   * 최댓값 : 0의 개수 + 일치하는 번호 수
   * 최솟값 : 일치하는 번호 수
3. `return rank[cnt_0 + val], rank[val]` : 실행 결과는 `3 5` 와 같이 정수가 띄어쓰기로 구분되어 리턴,  기대값은 리스트 형식 (`[3, 5]`)이어도 테스트 통과

### 피드백 
못한 것: 
* enumerate는 필요없다 인덱스(추첨 또는 담첨 순서)는 필요하지 않기 때문
* 하나의 for문에서 in을 쓰면 자바에서 중첩 반복문을 사용한 것처럼 요소의 존재를 확인할 수 있다.

잘한 것:
* rank리스트를 생각해낸 것. 
  * 하다보니 구현할 수 있었다. 컨디션이 안좋았다면 활용할 생각이 나지 않았을 수도. 익숙해져야 한다. 
  * 리스트의 인덱스와 값이 서로를 가리키는 역할을 할 수 있다. 따라서 이것을 활용하여 값을 순위로 인덱스를 순위에 해당하는 원인(맞힌 개수와 같은 정수)일 경우 활용도가 높다.

## 내 풀이 2 - java
* 위에서 정리한 핵심 정리를 참고하여 자바로 빠르게 구현해보자.
```java
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // answer 변수선언, 일치 번호 수 변수(same) 선언, 0 개수 카운트 
        int[] answer = new int[2];
        int same = 0;
        int cnt_0 = 0;
        for(int k = 0; k < lottos.length; k ++){ 
            if (lottos[k] == 0) {
                cnt_0++;
            }
        }        
        
        // 1. rank list
        int[] rank = {6,6,5,4,3,2,1};
            
        // 2. max, min
        for(int i = 0; i < win_nums.length; i ++){ 
            for(int j = 0; j < lottos.length ; j ++){ 
                if (lottos[j] == win_nums[i]) {
                    same++;
                }
            }
        }
        
        // 3. return
        answer[0] = rank[cnt_0 + same];
        answer[1] = rank[same];
        return answer;
    }
}
```

### 파이썬 풀이와 비교
1. 파이썬에서 활용한 rank리스트를 자바에서 rank int array로 활용하였다.
   * 인덱스와 값은 맞힌 개수와 순위를 의미
2. 파이썬의 in과 같은 기능이 없어 중첩 반복문으로 두 배열을 비교하여 일치하는 번호의 수를 구하였다. (same에 저장)
3. 0의 개수 또한 for문과 if문을 사용하여 구하였다. (in의 부재)
4. return 또한 파이썬처럼 정수, 정수와 같이 간단히 리턴할 수 없어 answer배열을 이용하여 값을 저장후에 answer배열을 리턴하였다.
5. 그외 기본적인 알고리즘 풀이나 논리는 같다.

## 다른 사람의 풀이'
1. LongStream사용
    ```java
    import java.util.Arrays;
    import java.util.stream.LongStream;

    class Solution {
        public int[] solution(int[] lottos, int[] winNums) {
            return LongStream.of(
                    (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                    (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
            )
                    .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                    .toArray();
        }
    }
    ```
    가독성과 성능은 좋지 않지만 가장 간결한 코드. 2개의 클래스를 활용하였다.
    * java.util.Arrays, java.util.stream.LongStream 사용
    * `LongStream.of().mapToInt().toArray();` 클래스 틀(?)
    * `Arrays.stream().filter().anyMatch().count()`를 2번 사용하여 최댓값, 최솟값을 계산.
    * 람다식 활용. - 간결, 가독성 업 > 추가학습 필요.

2. HashMap, Map 사용
    ```java
    import java.util.HashMap;
    import java.util.Map;

    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
            int zeroCount = 0;

            for(int lotto : lottos) {
                if(lotto == 0) {
                    zeroCount++;
                    continue;
                }
                map.put(lotto, true);
            }


            int sameCount = 0;
            for(int winNum : win_nums) {
                if(map.containsKey(winNum)) sameCount++;
            }

            int maxRank = 7 - (sameCount + zeroCount);
            int minRank = 7 - sameCount;
            if(maxRank > 6) maxRank = 6;
            if(minRank > 6) minRank = 6;

            return new int[] {maxRank, minRank};
        }
    }
    ```
    HashMap과 Map을 사용하여 성능이 압도적이고 가독성 또한 좋다. Map 대신 Set을 사용해도 된다.
    * map에 일치하는 번호들을 저장하고 sameCount변수에 저장한다. 
    * for each 문 : `for(int winNum : win_nums) {}` 활용도가 높으니 연습이 필요하다.


# 2. 신규 아이디 추천
## 문제 설명
카카오에 입사한 신입 개발자 `네오`는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
다음은 카카오 아이디의 규칙입니다.

* 아이디의 길이는 3자 이상 15자 이하여야 합니다.
* 아이디는 알파벳 소문자, 숫자, 빼기(`-`), 밑줄(`_`), 마침표(`.`) 문자만 사용할 수 있습니다.
* 단, 마침표(`.`)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
신규 유저가 입력한 아이디가 `new_id` 라고 한다면,
```
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
```
예를 들어, new_id 값이 "...!@BaT#*..y.abcdefghijklm" 라면, 위 7단계를 거치고 나면 new_id는 아래와 같이 변경됩니다.

1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.  
`"...!@BaT#*..y.abcdefghijklm"` → `"...!@bat#*..y.abcdefghijklm"`

2단계 '!', '@', '#', '*' 문자가 제거되었습니다.  
`"...!@bat#*..y.abcdefghijklm"` → `"...bat..y.abcdefghijklm"`

3단계 '...'와 '..' 가 '.'로 바뀌었습니다.  
`"...bat..y.abcdefghijklm"` → `".bat.y.abcdefghijklm"`

4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.  
`".bat.y.abcdefghijklm"` → `"bat.y.abcdefghijklm"`

5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.  
`"bat.y.abcdefghijklm"` → `"bat.y.abcdefghijklm"`

6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.  
`"bat.y.abcdefghijklm"` → `"bat.y.abcdefghi"`

7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.  
`"bat.y.abcdefghi"` → `"bat.y.abcdefghi"`

따라서 신규 유저가 입력한 new_id가 "...!@BaT#*..y.abcdefghijklm"일 때, 네오의 프로그램이 추천하는 새로운 아이디는 "bat.y.abcdefghi" 입니다.

## [문제]
신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

## [제한사항]
* new_id는 길이 1 이상 1,000 이하인 문자열입니다.
* new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
* new_id에 나타날 수 있는 특수문자는 `-_.~!@#$%^&*()=+[{]}:?,<>/` 로 한정됩니다.

[입출력 예]
no|	new_id|	result
---|---|---
예1|	"...!@BaT#*..y.abcdefghijklm"|	"bat.y.abcdefghi"
예2|	"z-+.^."|	"z--"
예3|	"=.="|	"aaa"
예4|	"123_.def"|	"123_.def"
예5|	"abcdefghijklmn.p"|	"abcdefghijklmn"

입출력 예에 대한 설명
### 입출력 예 #1
문제의 예시와 같습니다.

### 입출력 예 #2
7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.

1단계 변화 없습니다.
2단계 `"z-+.^."` → `"z-.."`
3단계 `"z-.."` → `"z-."`
4단계 `"z-."` → `"z-"`
5단계 변화 없습니다.
6단계 변화 없습니다.
7단계 `"z-"` → `"z--"`

### 입출력 예 #3
7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.

1단계 변화 없습니다.
2단계 `"=.="` → `"."`
3단계 변화 없습니다.
4단계 `"."` → `""` (new_id가 빈 문자열이 되었습니다.)
5단계 `""` → `"a"`
6단계 변화 없습니다.
7단계 `"a"` → `"aaa"`

### 입출력 예 #4
1단계에서 7단계까지 거치는 동안 new_id("123_.def")는 변하지 않습니다. 즉, new_id가 처음부터 카카오의 아이디 규칙에 맞습니다.

### 입출력 예 #5
1단계 변화 없습니다.
2단계 변화 없습니다.
3단계 변화 없습니다.
4단계 변화 없습니다.
5단계 변화 없습니다.
6단계 `"abcdefghijklmn.p"` → `"abcdefghijklmn."` → `"abcdefghijklmn"`
7단계 변화 없습니다.

## 내 풀이 - python
```py
import re
def solution(new_id):
    
    step_1 = new_id.lower()
    print("step_1 : ", step_1)
    
    step_2 = re.sub('[^a-z0-9-_.]', '', step_1)
    print("step_2 : ", step_2)
    
    step_3 = re.sub('[.]{2,}', '.', step_2)
    print("step_3 : ", step_3)
    
    step_4 = re.sub('^[.]|[.]$', '', step_3)
    print("step_4 : ", step_4)

    step_5 = step_4
    if len(step_5) == 0:
        step_5 = 'a'    
    print("step_5 : ", step_5)
    
    step_6_1 = step_5
    if len(step_6_1) > 15:
        step_6_1 = step_6_1[:15]   
    print("step_6_1 : ", step_6_1)
    
    step_6_2 = re.sub('[.]$','', step_6_1)
    print("step_6_2 : ", step_6_2)

    step_7 = step_6_2
    if len(step_7) > 2 :
        step_7 = step_7
    else :
        for i in range(3 - len(step_6_2)):
            step_7 = step_7 + "".join(step_6_2[-1])
    print("step_7 : ", step_7)

    return step_7
```
* 정규식 검색, 학습 후 활용.
  * re 모듈사용
  * [^a-z0-9-_.] : 문자클래스[]안에 제외하지 않을(^) 조건 입력
    * (^)은 처음 문자를 의미하지만 []문자클래스 안에서는 반대라는 의미
  * (.) dot은 \n을 제외한 모든 문자와 매치하지만 []안에서는 .점 그대로의 의미
  * ($)는 마지막 문자 의미
  * [:15] : 인덱싱, 슬라이싱 활용해 길이 제한
  * join()을 활용해 부족한 문자 반복 추가
    * 함수의 모양
        ```
        ''.join(리스트)

        '구분자'.join(리스트)
        ```
    * 매개변수로 들어온 리스트에 있는 요소 하나하나를 합쳐서 하나의 문자열로 바꾸어 반환
    * 구분자를 넣으면 구분자를 넣어 하나의 문자열로 합쳐준다. (위의 코드에서 구분자 사용 x) 안넣으면 구분자가 공백이 되는 것과 같다.

### 간략화 버전
```py
import re
def solution(new_id):      
    n = new_id    
    n = n.lower()  
    n = re.sub('[^a-z0-9-_.]', '', n)   
    n = re.sub('[.]{2,}', '.', n)
    n = re.sub('^[.]|[.]$', '', n)
    n = 'a' if len(n) == 0 else n[:15]    
    n = re.sub('[.]$','', n)
    n = n if len(n) > 2 else n + "".join([n[-1] for i in range(3-len(n))])
    return n
```

## 내 풀이 2 - java
```java
class Solution {
    public String solution(String new_id) {
        String n = new_id.toLowerCase();
        n = n.replaceAll("[^-_.a-z0-9]", "");
        n = n.replaceAll("[.]{2,}", ".");
        n = n.replaceAll("^[.]|[.]$", "");
        if(n.equals(""))
            n = "a";
        if(n.length() >= 16){
            n = n.substring(0, 15);
            n = n.replaceAll("[.]$", "");
        }
        if(n.length() <= 2)
            while(n.length() < 3)
                n += n.charAt(n.length() - 1);
        return n;
    }
}
```
* replaceAll()로 정규표현식 사용
* substring으로 부분 분할(길이제한)
* charAt()으로 마지막 문자 추가


# 3. 숫자 문자열과 영단어
## 문제 설명
네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

* 1478 → "one4seveneight"
* 234567 → "23four5six7"
* 10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 `s`가 매개변수로 주어집니다. `s`가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

|숫자|	영단어|
|---|---|
0|	zero
1|	one
2|	two
3|	three
4|	four
5|	five
6|	six
7|	seven
8|	eight
9|	nine

## 제한사항
* 1 ≤ s의 길이 ≤ 50
* s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
* return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
### 입출력 예
s|	result
---|---
"one4seveneight"|	1478
"23four5six7"|  234567
"2three45sixseven"|	234567
"123"|	123

### 입출력 예 설명
### 입출력 예 #1

문제 예시와 같습니다.
### 입출력 예 #2

문제 예시와 같습니다.
### 입출력 예 #3

* "three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.
* 입출력 예 #2와 #3과 같이 같은 정답을 가리키는 문자열이 여러 가지가 나올 수 있습니다.
입출력 예 #4

* `s`에는 영단어로 바뀐 부분이 없습니다.

### 제한시간 안내
정확성 테스트 : 10초

## 내 풀이
```py
import re
def solution(s):
    answer = 0

    ans1 = re.sub('zero','0',s) 
    ans2 = re.sub('one','1',ans1) 
    ans3 = re.sub('two','2',ans2) 
    ans4 = re.sub('three','3',ans3) 
    ans5 = re.sub('four','4',ans4) 
    ans6 = re.sub('five','5',ans5) 
    ans7 = re.sub('six','6',ans6) 
    ans8 = re.sub('seven','7',ans7) 
    ans9 = re.sub('eight','8',ans8) 
    ans10 = re.sub('nine','9',ans9) 

    answer = int(ans10)
    return answer
```
* re.sub를 이용해 문자열 변경
* 각 알파벳 숫자마다 지정


### 결과
```
정확성  테스트
테스트 1 〉	통과 (0.28ms, 10.5MB)
테스트 2 〉	통과 (0.47ms, 10.5MB)
테스트 3 〉	통과 (0.29ms, 10.5MB)
테스트 4 〉	통과 (0.46ms, 10.4MB)
테스트 5 〉	통과 (0.51ms, 10.4MB)
테스트 6 〉	통과 (0.47ms, 10.4MB)
테스트 7 〉	통과 (0.46ms, 10.4MB)
테스트 8 〉	통과 (0.44ms, 10.4MB)
테스트 9 〉	통과 (0.31ms, 10.4MB)
테스트 10 〉	통과 (0.30ms, 10.4MB)
```
* 느리다

## 다른 사람의 풀이 1
```py
num_dic = {"zero":"0", "one":"1", "two":"2", "three":"3", "four":"4", "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}

def solution(s):
    
    for k, v in num_dic.items():
        s = s.replace(k, v)
    
    return int(s)
```
* 딕셔너리.items(), replace()를 사용하여 풀이
* 더 간략하고 쉽다.
* 정규식 사용하지 않고 풀이

### 결과
```
정확성  테스트
테스트 1 〉	통과 (0.02ms, 10.4MB)
테스트 2 〉	통과 (0.03ms, 10.5MB)
테스트 3 〉	통과 (0.02ms, 10.3MB)
테스트 4 〉	통과 (0.03ms, 10.3MB)
테스트 5 〉	통과 (0.03ms, 10.4MB)
테스트 6 〉	통과 (0.03ms, 10.5MB)
테스트 7 〉	통과 (0.03ms, 10.4MB)
테스트 8 〉	통과 (0.03ms, 10.4MB)
테스트 9 〉	통과 (0.03ms, 10.3MB)
테스트 10 〉	통과 (0.03ms, 10.4MB)
```
* 훨씬 빠르다.


## 다른 사람의 풀이 2
```py
def solution(s):
    words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    for i in range(len(words)):
        s = s.replace(words[i], str(i))

    return int(s)
```
* 리스트, replace()를 사용하여 풀이
* 좀 더 간략하고 쉽다.
* 정규식, 딕셔너리 사용하지 않고 풀이

### 결과
```
정확성  테스트
테스트 1 〉	통과 (0.03ms, 10.3MB)
테스트 2 〉	통과 (0.02ms, 10.4MB)
테스트 3 〉	통과 (0.02ms, 10.4MB)
테스트 4 〉	통과 (0.03ms, 10.4MB)
테스트 5 〉	통과 (0.03ms, 10.3MB)
테스트 6 〉	통과 (0.02ms, 10.4MB)
테스트 7 〉	통과 (0.02ms, 10.4MB)
테스트 8 〉	통과 (0.03ms, 10.4MB)
테스트 9 〉	통과 (0.02ms, 10.4MB)
테스트 10 〉	통과 (0.03ms, 10.3MB)
```
* 다른 사람의 풀이 1 과 비슷


## 다른 사람의 풀이 3
```py


def solution(s):

    eng = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    if s.isdigit():
        return int(s) # 바로리턴 

    # 숫자면 넘어가고 문자열이라면 다음 숫자가 나올때까지 단어를 완성한다. 
    # 문자열이 이어져있을수도 있으므로 한단어씩 문자열에 합칠때마다 eng배열에 존재하는지 확인하고 있으면 temp를 빈문자열로 초기화시킨다.

    answer = ''
    temp = ''
    for i in s:
        if i.isdigit():
            answer+=i
        # 문자열이면 
        else:
            temp += i
            if temp in eng:
                answer += str(eng.index(temp))
                temp = ''

    #print(answer)   
    return int(answer)
```
* 처음 구현하고자했던 로직
* 리스트와 조건문 반복문 사용
* 복잡하다
  
### 결과
```
정확성  테스트
테스트 1 〉	통과 (0.02ms, 10.3MB)
테스트 2 〉	통과 (0.03ms, 10.4MB)
테스트 3 〉	통과 (0.02ms, 10.4MB)
테스트 4 〉	통과 (0.02ms, 10.5MB)
테스트 5 〉	통과 (0.02ms, 10.4MB)
테스트 6 〉	통과 (0.03ms, 10.4MB)
테스트 7 〉	통과 (0.03ms, 10.3MB)
테스트 8 〉	통과 (0.04ms, 10.4MB)
테스트 9 〉	통과 (0.03ms, 10.4MB)
테스트 10 〉	통과 (0.02ms, 10.4MB)
```
* 시간 비슷


# 4. [카카오 인턴] 키패드 누르기
## 문제 설명
스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

![kakao_phone1](image/kakao_phone1.png)

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
5. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

*  [제한사항]
   * numbers 배열의 크기는 1 이상 1,000 이하입니다.
   * numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
   * hand는 "left" 또는 "right" 입니다.
   "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
   * 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
* 입출력 예
  
numbers|	hand|	result
---|---|---
[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]|	"right"|	"LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	|"left"|	"LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]|	"right"|	"LLRLLRLLRL"

## 풀이 
```py
def solution(numbers, hand):
    answer = ''
            
    L = [1,4,7,'*']
    R = [3,6,9,'#']    
    L_thumb = '*'
    R_thumb = '#'
    
    for i, n in enumerate(numbers) :
        print("왼손위치 :", type(L_thumb), L_thumb, "  오른손위치 :", type(R_thumb), R_thumb, "  눌러야할 숫자 :",n)
        if n in L :
            answer += 'L'
            L_thumb = n
        elif n in R :
            answer += 'R'
            R_thumb = n
        else :
            if n == 2 :
                if hand == "right" :
                    if L_thumb == 2 :
                        answer += 'L'
                        L_thumb = n
                        print("1왼손위치는 ", L_thumb,"이고 오른손위치는",R_thumb)
                    elif L_thumb == 1 or L_thumb == 5 and R_thumb != 2 or R_thumb != 3 or R_thumb != 5:
                        print("2-1왼손위치는 ", L_thumb,"이고 오른손위치는",R_thumb)
                        answer += 'L'
                        L_thumb = n
                        print("2-2왼손위치는 ", L_thumb,"이고 오른손위치는",R_thumb)
                    elif L_thumb == 4 or L_thumb == 8 :
                        if R_thumb == 9 or R_thumb == '#' or R_thumb == 0 :                       
                            answer += 'L'
                            L_thumb = n
                            print("3왼손위치는 ", L_thumb,"이고 오른손위치는",R_thumb)
                    elif L_thumb == 7 or L_thumb == 0 :
                        if R_thumb == '#':
                            answer += 'L'
                            L_thumb = n
                            print("4왼손위치는 ", L_thumb,"이고 오른손위치는",R_thumb)
                    else :
                        answer += 'R'
                        R_thumb = n 
                        print("5왼손위치는 ", L_thumb,"이고 오른손위치는",R_thumb)

                        
                elif hand == "left" :
                    if R_thumb == 2 :
                        answer += 'R'
                        R_thumb = n
                    elif R_thumb == 3 or R_thumb == 5 :
                        if  L_thumb != 2 or L_thumb != 1 or L_thumb != 5:
                            answer += 'R'
                            R_thumb = n
                    elif R_thumb == 6 or R_thumb == 8 :
                        if L_thumb == 7 or L_thumb == '*' or L_thumb == 0 :
                            answer += 'R'
                            R_thumb = n
                    elif R_thumb == 9 or R_thumb == 0 :
                        if L_thumb == '*':
                            answer += 'R'
                            R_thumb = n
                    else :
                        answer += 'L'
                        L_thumb = n

            elif n == 5 :
                
                if hand == "right" :
                    if L_thumb == 5 :
                        answer += 'L'
                        L_thumb = n
                    elif L_thumb == 2 or L_thumb == 4 or L_thumb == 8 :
                        if R_thumb != 5 or R_thumb != 2 or R_thumb != 6 or R_thumb != 8 :
                            answer += 'L'
                            L_thumb = n
                    elif L_thumb == 1 or L_thumb == 7 or L_thumb == 0 :
                        if R_thumb == '#' :
                            answer += 'L'
                            L_thumb = n
                    else :
                        answer += 'R'
                        R_thumb = n
                        
                elif hand == "left" :
                    if R_thumb == 5 :
                        answer += 'R'
                        R_thumb = n
                    elif R_thumb == 2 or R_thumb == 6 or R_thumb == 8 :
                        if L_thumb != 5 or L_thumb != 2 or L_thumb != 4 or L_thumb != 8 :
                            answer += 'R'
                            R_thumb = n
                    elif R_thumb == 3 or R_thumb == 9 or R_thumb == 0 :
                        if L_thumb == '*' :
                            answer += 'R'
                            R_thumb = n
                    else :
                        answer += 'L'
                        L_thumb = n
                
            elif n == 8 :
                
                if hand == "right" :
                    if L_thumb == 8 :
                        answer += 'L'
                        L_thumb = n
                    elif L_thumb == 0 or L_thumb == 7 or L_thumb == 5 :
                        if R_thumb != 8 or R_thumb != 0 or R_thumb != 9 or R_thumb != 5 :
                            answer += 'L'
                            L_thumb = n
                    elif L_thumb == '*' or L_thumb == 4 or L_thumb == 2 :
                        if R_thumb == 3 :
                            answer += 'L'
                            L_thumb = n
                    else :
                        answer += 'R'
                        R_thumb = n
                        
                elif hand == "left" :
                    if R_thumb == 8 :
                        answer += 'R'
                        R_thumb = n
                    elif R_thumb == 0 or R_thumb == 9 or R_thumb == 5 :
                        if L_thumb != 8 or L_thumb != 0 or L_thumb != 9 or L_thumb != 5 :
                            answer += 'R'
                            R_thumb = n
                    elif R_thumb == '#' or R_thumb == 6 or R_thumb == 2 :
                        if L_thumb == 1 :
                            answer += 'R'
                            R_thumb = n
                    else :
                        answer += 'L'
                        L_thumb = n
                
            elif n == 0 :
                
                if hand == "right" :
                    if L_thumb == 0 :
                        answer += 'L'
                        L_thumb = n
                    if L_thumb == '*' or L_thumb == 8 :
                        if R_thumb != 0 or R_thumb != 8 or R_thumb != '#' :
                            answer += 'L'
                            L_thumb = n
                    elif L_thumb == 7 or L_thumb == 5 :
                        if  R_thumb == 2 or R_thumb == 3 or R_thumb == 6:
                            answer += 'L'
                            L_thumb = n
                    elif L_thumb == 4 or L_thumb == 2 :
                        if R_thumb == 3 :
                            answer += 'L'
                            L_thumb = n
                    else :
                        answer += 'R'
                        R_thumb = n
                        
                elif hand == "left" :
                    if R_thumb == 0 :
                        answer += 'R'
                        R_thumb = n
                    if R_thumb == '#' or R_thumb == 8 :
                        if L_thumb != 0 or L_thumb != 8 or L_thumb != '*' :
                            answer += 'R'
                            R_thumb = n
                    elif R_thumb == 9 or R_thumb == 5 :
                        if L_thumb == 1 or L_thumb == 2 or L_thumb == 4 :
                            answer += 'R'
                            R_thumb = n
                    elif R_thumb == 6 or R_thumb == 2 :
                        if L_thumb == 1 :
                            answer += 'R'
                            R_thumb = n
                    else :
                        answer += 'L'
                        L_thumb = n

    return answer
```