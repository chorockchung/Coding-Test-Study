# [Bronze II] 문자열 반복 - 2675 

[문제 링크](https://www.acmicpc.net/problem/2675) 

### 배운 것
- BufferedReader
 - read() : 한 문자만 개행문자 없이 읽음. readLine() : 한 문장을 개행문자 포함해 읽음.
 - read() : return 값이 int 이므로 형변환 필요, readLine() : string 반환
 - 한 줄에 여러개 입력 시, br.readLine().split(" ") 사용!
- String vs StringBuffer : immutable vs mutable -> StringBuffer가 메모리 최적화에 좋다
* StringBuffer : 동기화보장, StringBuilder : 동기화보장X --> 코테 환경은 단일스레드 이므로 Builder가 좋다


### 성능 요약

메모리: 14168 KB, 시간: 128 ms

### 분류

구현, 문자열

### 제출 일자

2024년 5월 14일 21:21:51

### 문제 설명

<p>문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.</p>

<p>QR Code "alphanumeric" 문자는 <code>0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:</code> 이다.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다. </p>

### 출력 

 <p>각 테스트 케이스에 대해 P를 출력한다.</p>

