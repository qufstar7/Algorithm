>> 프로그래머스 코딩테스트 연습을 학습, 정리하였습니다. (https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit)

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