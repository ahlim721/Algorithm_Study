# GO

<br/>

### Go의 특징

1. 절차지향이며 객체지향 프로그래밍을 **지원**한다.
2. 컴파일 언어지만 속도가 빨라 인터프리터 언어처럼 사용할 수 있다.
3. 외부 의존성이 적어 실행이 쉽지만 **크로스 컴파일**을 해야한다.
4. 이 외의 여러가지 특징
   * 자료형에 형이 있고, 자바와 달리 항상 명시적 형변환을 해야함
   * 스레드와 비슷한 `고루틴` 이라는 개념이 있음.
   * 결과물에 `go runtime` 이 내장되어 `GC`와 비슷하게 메모리를 핸들링
   * 포인터는 존재하지만 포인터 연산은 없다.
5. 객체지향 프로그래밍을 주로 해오던 개발자라면 익숙한 `클래스`,`상속`,`생성자`,`final`,`제네릭 ` 은 존재하지 않는다.

<br/>

### Go의 자료형

> Go는 변수를 `:=` 로 할당하게 되면, 자동으로 자료형이 할당되지만 직접 자료형이나 비트의 크기를 줄 수 있다.

* 부울린(Boolean) 타입

  `bool` 로 선언하며 크기는 1byte

* 정수 타입

  `int` 로 선언하며 뒤에 비트를 적어 크기를 할당할 수 있다.

  > ` int8`, `int16`, `int32`, `int64` (양수인 경우, 앞에 `u` 를 붙혀서 사용한다.)

  * `uintptr` 은 포인터의 주소를 할달할 때 사용하는 자료형
  * 뒤에 크기를 할당하지 않을 경우, 시스템 사양에 따른다 (32비트 시스템에서는 int32)

* 실수 및 복소수 타입

  * 실수

    > `float32`, `float64`

  * 복소수

    > `complex64`, `complex128` 은 3+4i 같은 값을 선언할 수 있다.

* 문자열 타입

  `string` 으로 선언하며 크기는 16byte

  * "" 처럼 비어있을 수 있다.
  * immutable 타입이기 때문에 값을 수정하는 것이 불가능 하다.

* 기타

  * `byte` 은 `uint8` 과 같지만, 바이트 값 처리를 위해 사용.
  * `rune` 은 `int32` 와 같지만, 문자 값 처리를 위해 사용.
  * Go에서 null은 **nil** 로 사용.

<br/>

### Go의 문자열 표현

Go에서는 두 가지의 문자열 표현 방법이 있다.

* \` (Back Quote) 는 내부의 문자열을 그대로의 문자열(Raw String Literal) 로 취급한다.

  ```go
  var raw string = `Hello, \n world!`
  // Hello, \n world!
  ```

* \" 은 이스케이프 시퀀스를 받아들이는 문자열(Interpreterd String literal) 로 취급한다.

  ```go
  var inter string = "Hello, \n world!"
  // Hello,
  //  world!
  ```

<br/>

### Go의 명시적 형변환

Go에서는 묵시적 형변환을 지원하지 않는다. 따라서, 형변환을 꼭 명시해야만 에러가 나지 않는다.

```go
var num1, num2 int = 3, 4

// runtime error
// 나눈 결과값은 int인데, 저장하는 자료형이 float32 이기 때문에 error 가 발생함.
var result1 float32 = num1 / num2 

// success
var result2 float32 = (float32) (num1 / num2)
```

<br/>

### Go의 입출력

Go에서 입출력을 하기위해서 `"fmt"` 을 import하여 사용해야한다.

* Go의 출력

  ```go
  a := 1
  var b [5]int = [5]int{1,2,3,4,5}
  ```

  * fmt.Print() / fmt.Println() 는 포맷을 지정하지 않아도 그대로 출력이 가능하다.

    ```go
    fmt.Println("a는 ", a, "입니다.") 
    fmt.Print(b)
    
    // a는 1입니다.
    // [1 2 3 4 5]
    ```

  * fmt.Printf() 는 변수의 포맷을 지정해주어야 한다.

    ```go
    fmt.Printf("a는 %d입니다. \n")
    fmt.Printf("%d", b)
    
    // a는 1입니다.
    // [1 2 3 4 5]
    ```

* Go의 입력

  * fmt.Scan() / fmt.Scanln() 은 c언어와 마찬가지로 입력을 받으면 된다.

    ```go
    var name string
    var gen int
    
    fmt.Scan(&name, &gen)
    // name
    // gen
    fmt.Scanln(&name, &gen)
    // name gen
    ```

  * fmt.Scanf() 는 원하는 포맷을 지정하여 입력받을 수 있다. 

    ```go
    var first, second string
    
    fmt.Scanf("I'm %s, next one is %s", &first, &second)
    
    // I'm 1st, next one is 2nd
    // first = "1st", second = "2nd"
    ```

<br/>

### Go의 반복문

Go의 반복문은 다른 언어들과는 다르게 while 을 지원하지 않는다. 오직 `for` 만 사용한다.

```go
for i := 0; i < 10; i++ {
	fmt.Print(i)
}
// 0123456789
```

* `while` 처럼 사용하고 싶을 때는 이렇게

  ```go
  i := 0
  for i < 10 {
  	fmt.Print(i)
  }
  // 0123456789
  ```

* 무한루프는 이렇게

  ```go
  for {
  	fmt.Println("infinite")
  }
  // infinite
  // infinite
  // ...
  ```

* **for range 문**

  배열과 같은 컬렉션을 다룰 때, 사용된다.

  ```go
  var numbers [3]int = [3]{1, 2, 3}
  var fruits map[string]string = map[string]string {
  	"apple" : "red",
  	"banana" : "yellow"
  }
  
  // index 만 필요한 경우 => index
  // value 만 필요한 경우 => _, value
  for index, value := range numbers {
  	fmt.Printf("numbers[%d] is %d\n", index, value)
  }
  
  for key, val := range fruits {
  	fmt.Printf("%s's color is %s\n", key, val)
  }
  
  // numbers[0] is 1
  // numbers[1] is 2
  // numbers[2] is 3
  
  // apple's color is red
  // banana's color is yellow
  ```

<br/>

### Go의 조건문

Go의 조건문(`if`)은 다른 언어의 조건문과는 크게 다르지 않다. 그러나, 반드시 지켜야 하는 몇 가지 규칙이 있다.

1. 조건문의 소괄호는 생략 (생략하지 않아도 되지만 생략하는 것을 권장합니다.)

2. 중괄호는 필수

   한 줄 코딩을 할 때, 중괄호를 생략하는 사람들이 있지만 Go에서는 중괄호가 필수.

3. 중괄호의 시작은 `if` 의 조건식이 시작하는 줄에 같이 적어야 한다.

4. `else` 나  `else if` 가 오는 경우, 이 전의 중괄호의 끝에 붙혀서 사용한다.

```go
num := 1
if num == 1 {
	fmt.Print("hello")
} else {
	fmt.Print("false")
}
// hello
```

만약, 다음과 같이 적는 경우에 에러가 발생하게 됩니다.

```go
num := 1
if num == 1 // 조건식 뒤에 { 가 오지 않아서 error
{
	fmt.Print("hello")
} // }와 else가 같은 줄이 아니여서 error
else {
	fmt.Print("false")
}
```

Go의 조건식에는 간단한 문장을 실행할 수도 있습니다.

```go
num := 2
if val := num * 2; val == 4 {
	fmt.Print(val)
}
// 4 -- val은 해당 조건문 안에서만 사용 가능합니다.
```

<br/>

Go에도 역시 `switch` 문이 존재합니다. 다른 언어와 마찬가지로 다음과 같이 사용합니다.

```go
switch num % 2 {
case 0:
	fmt.Print("짝수")
case 1:
	fmt.Print("홀수")
default:
	fmt.Print("???")
}
```

`switch` 문을 `if-else` 문과 같이 사용할 수도 있습니다.

```go
switch {
case a > b :
	fmt.Print("a > b")
case a == b :
	fmt.Print("a == b")
case a < b :
	fmt.Print("a < b")
default :
	fmt.Print("???")
}
```

<br/>

### Go의 컬렉션

Go에는 두 개 이상의 변수를 모아 놓은 것을 `컬렉션` 이라고 한다. 컬렉션은 그 기능에 따라 세 가지 용법이 존재한다.

* #### 배열 [Array]

  Go언어에서의 배열은 정적이다. 그래서 한번 고정된 배열의 크기를 바꾸거나 부분을 자르는 기능은 없다.

  * **선언과 초기화**

    ```go
    // var 배열이름 [배열크기]타입
    var arr1 [3]int = [3]int{1, 2, 3}
    arr2 := [3]int{1, 2, 3}
    var arr3 = [...]int{1, 2, 3}
    
    fmt.Print(len(arr3)) // 3
    ```

    위와 같은 방식으로 선언하고 초기화할 수 있다.

    * `[...]` 를 사용하면 자동으로 배열의 크기를 설정한다.
    * `len()` 을 사용하면 해당 배열의 크기를 가져올 수 있다.

  * **다차원 배열의 선언과 초기화**

    ```go
    var a = [3][3]int{
    	{1, 2, 3},
    	{4, 5, 6},
    	{7, 8, 9}
    }
    ```

  배열은 선언과 동시에 크기가 결정나므로 그만큼의 메모리 공간을 할당받게 된다. 사실상 초기화하지 않고 선언만해도 int형은 0으로, string형은 ""로 초기화된다. 그렇기 때문에 a[0] = 1 로 바로 접근이 가능하다.

  그러나, 아래의 슬라이스는 조금 다르다.

* #### 슬라이스 [Slice]

  배열과 비슷한 컬렉션인 슬라이스는 **크기를 동적으로 변경**하고 **부분을 가져오는 것이 가능**하다. 하

  * **선언과 초기화**

    슬라이스는 선언을 하게 되면, 메모리에 공간이 생기는 것이 아닌 슬라이스의 정보만 생성이 된다. 따라서, 초기화되기 전까지 슬라이스는 `Nil silce` 이다.

    슬라이스는 배열의 위치를 가지는 `ptr`, 배열의 길이인 `len`, 전체 크기인 `cap`을 가진다.

    ```go
    // a를 선언만 한 상태. 아직 메모리에 할당 x
    // len(a) : 0, cap(a) : 0
    var a []int 
    a[0] = 10 // error!
    
    // 초기화되어 메모리에 할당.
    // len(a) : 3, cap(a) : 3, cap값을 지정하지 않으면 len과 동일.
    a = []int{1, 2, 3} 
    a[0] = 10 // [10, 2, 3]
    ```

    Go의 내장함수인 `make()` 를 사용하여 슬라이스를 생성할 수도 있다.

    `make()` 를 사용하면 슬라이스의 `len`, `cap` 을 지정하고 메모리에 할당할 수 있어 일반 배열과 같이 a[0] = 1 처럼 접근도 가능해진다.

    ```go
    // make(슬라이스 타입, 슬라이스 길이, 슬라이스 용량) 
    // 이 때, 슬라이스 용량은 생략이 가능합니다. (길이와 같아짐)
    var a = make([]int, 3)
    a[0] = 1
    
    fmt.Print(a) // [1 0 0]
    ```

  * **슬라이스에 요소 추가**

    만약, 지정된 len보다 더 많은 값을 넣게될 경우, cap은 cap만큼 커지게 된다. 또한, len보다 더 많은 값을 넣기 위해서는 `append()` 함수를 사용한다.

    ```go
    var a = make([]int, 0, 3)
    
    for i := 1; i <= 4; i++ {
      a = append(a, i)
    }
    
    fmt.Print(a, len(a), cap(a))
    // [1 2 3 4] 4 6
    ```

    물론, 슬라이스를 붙힐 수도 있습니다.

    ```go
    var b = []int{5, 6, 7}
    
    a = append(a, b...)
    
    fmt.Print(a) // [1 2 3 4 5 6 7]
    ```

    슬라이스 뒤에 `...` 를 입력하면 슬라이스의 모든 요소들의 집합을 의미한다. 사실상 슬라이스가 붙는 것이 아니라 요소들이 추가가 되는 것입니다.

  * **슬라이스 복사하기**

    슬라이스를 가져오는 방법은 두가지가 존재한다.

    * copy() 함수 사용

      슬라이스 B를 슬라이스 A에 복사하기 위해서 copy(A, B) 를 사용한다. 이 때, A의 len만큼 B에서 복사해온다.

    * [:] 사용

      슬라이스의 뜻 그대로, 슬라이스를 배열을 잘라서 사용할 수 있다.

      S[시작 인덱스 : 끝 인덱스 + 1] 를 하게 되면,  슬라이스 S의 시작부터 끝까지 가져오게 된다. 0부터 가져올 경우에는 시작 인덱스를 생략할 수 있다.

    ```go
    var a = []int{1, 2, 3}
    b := make([]int, len(a))
    
    copy(b, a)
    c := a[:3]
    
    fmt.Print(b, c) // [1 2 3] [1 2 3]
    
    a[1] = 10
    fmt.Print(a, b, c) // [1 10 3] [1 2 3] [1 10 3]
    ```

    위의 결과에서 보이는 것처럼 
    copy 는 다른 메모리 공간의 b에 내용물을 복사해서 넣어놓지만,
    [:] 는 기존 a의 메모리 공간의 시작부터 끝을 참조하도록 하는 방식이다.

  

* #### 맵 [Map]

  Java의 `HashMap`이나 Python의 `dictionary` 처럼 Go에도 `map`이라는 컬렉션이 존재하며, 마찬가지로 `key : value` 의 쌍으로 이루어져 있다.

  map 역시 슬라이스와 마찬가지로 참조 타입이므로, 선언만 하고 초기화하지 않으면 `Nil map` 이 된다. 

  * 선언과 초기화

    ```go
    var m map[string]string // [key]value 를 의미한다. m == nil
    
    m = map[string]string {
    	"apple" : "red",
    	"grape" : "purple"
    }
    ```

    map 역시 make() 를 사용해 생성하고 메모리에 할당할 수 있다.

    ```go
    var a = make(map[string]string)
    
    a["02"] = "서울특별시" // 메모리에 존재하므로 접근 가능
    ```

  * 삭제와 key, value 확인

    삭제는 delete() 함수를 사용하며, a[key] 는 value 와 key 존재 여부를 함께 반환하기 때문에 다음과 같이 사용하면 된다.

    ```go
    val, exist := a["02"]
    fmt.Print(val, exist) // 서울특별시 true
    
    val, exist = a["031"]
    fmt.Print(val, exist) //  false
    
    a["031"] = "경기도"
    val = a["031"] // value 만 저장.
    fmt.Print(val) // 경기도
    
    delete(a, "031")
    _, exist = a["031"] // key 존재 여부만 저장.
    fmt.Print(exist) // false
    ```

<br/>

### Go의 함수

Go의 함수는 **일급함수**입니다. 일급함수는 함수 자체를 기본 타입과 동일하게 사용할 수 있어서 함수 자체를 다른 함수의 매개변수로 전달하거나 다른 함수의 반환 값으로 사용할 수 있다는 것을 의미합니다.

따라서, 선언 함수 외에 익명 함수가 존재하는데 익명 함수는 뒤에서 다룰 것입니다.

* 함수의 선언

  ```go
  func method_name (param_name param_type) return_type {
    // function
  }
  ```

* 함수의 특징

  * `func` 키워드로 함수를 선언한다.

  * 함수의 **반환 값이 여러 개**일 수 있다.

  * 함수의 반환 값에 이름을 부여할 수 있다. (Named Return Parameter)

  * `{` 가 함수와 같은 줄에 있어야 한다.

  * 객체 지향 지원 언어이기 때문에 함수의 선언을 앞에 명시하지 않아도 된다.

  * 일급함수이기 때문에 매개변수로 함수를 받을 수도 있습니다.

    ```go
    func print(f func(int, int) int, a int, b int) {
    	fmt.Print(f(a, b))
    }
    
    func add(a int, b int) int {
    	return a + b
    }
    
    func main() {
    	print(add, 1, 2) // 3
    } 
    ```

* 가변 인자 함수

  > 전달하는 매개변수의 개수를 함수를 호출할 때마다 다르게 전달할 수 있도록 만든 함수.

  Go의 가변 인자 함수 특징

  * n개의 동일한 형의 매개변수 전달
  * 전달된 변수들은 슬라이스 형태 (함수 내부에서 슬라이스와 동일하게 다룸)

  ```go
  func addThings(numbers ...int) int {
  	result := 0
  	
  	for _, val := range numbers {
  		result += val
  	}
  	
  	return result
  } 
  
  func main() {
  	num1, num2 := 1, 2
  	nums := []int{3, 4}
    
    fmt.Println(addThings(num1, num2)) // 3
    fmt.Println(addThings(nums...)) // 7
  }
  ```

<br/>

### Go의 포인터

Go는 C/C++ 처럼 `포인터` 라는 개념이 존재하고, 핵심 개념만 사용하도록 제공한다.

* `&` : 주소

  > `&변수이름` 으로 해당 변수의 주소값에 접근할 수 있고, 전달할 수 있다.

* `*` : 직접 참조

  > `*변수이름` 으로 해당 변수를 직접 참조할 수 있다.

Call by Reference 방식을 사용하기 위해서 `포인터` 개념을 사용하는데, Go에서도 다음과 같이 사용 하면 된다. 

```go
func getDubble(a *int) {
	*a += *a
	fmt.Print(*a) // 8
}

func main() {
	a := 4 // 지역변수
	getDubble(&a) // 참조를 위해 a 주소값을 전달.
	fmt.Print(a) // 8
}
```

<br/>

### Go의 반환값

* Go의 함수는 반환값이 여러 개일 수 있다.
  * 2 개 이상의 반환값이 있을 경우, () 로 묶어서 표기한다.
  * 동일한 반환형이여도 모두 명시한다.

  ```go
  func add(num ...int) (int, int) {
  	result, count := 0, 0
  	
  	for _, val in range num {
  		result += val
  		count++
  	}
  	
  	return result, count
  }
  
  func main() {
  	num := []int{1, 2, 3}
  	
  	fmt.Print(add(num...)) // 6 3
  }
  ```

* Go의 함수의 반환값에 이름을 붙여 반환할 수 있다. 

  * (반환값이름 반환형) 으로 변수 자체를 선언하기 때문에, 함수 내부에서 선언할 경우 에러가 발생한다.
  * 반환값이름이 존재하기 때문에 반환값을 return 하지 않아도 되지만 return 을 꼭 명시해야한다.
  * 반환값이 하나여도 () 로 묶어서 표기한다.

  ```go
  // 입력받은 3개의 숫자를 nums slice 로 반환
  func inputNumber() (nums []int) {
  	fmt.Println("숫자를 입력하세요")
  	
  	for i := 0; i < 3; i++ {
  		var num int
  		fmt.Scanln(&num)
  		nums = append(nums, num)
  	}
  	
  	return
  }
  
  // 모두 다 더하는 함수
  func addAll(nums ...int) (result int, numbers []int) {
  	for i := 0; i < len(nums); i++ {
  		result += nums[i]
  		numbers = append(numbers, nums[i])
  	}
  	
  	return
  }
  
  func main() {
  	// slice를 반환하는 inputNumber()를 다음과 같이 addAll의 parameter로 넘김
  	result, numbers := addAll(inputNumber()...)
  	
  	fmt.Print(result, numbers)
  }
  ```

<br/>

### Go의 익명 함수

* 함수를 선언하면 프로그래밍 전역으로 메모리가 할당된다.
* 선언 함수를 사용할 때마다 함수를 찾고 실행되므로 시간이 소비된다.

위와 같은 이유로 선언 함수를 사용하면 프로그램의 속도가 저하된다. 따라서 함수화하는 것도 좋지만, 재사용성이 없거나 바로 실행될 함수들은 **익명 함수**로 함수의 기능을 사용할 수 있다.

```go
// ** 1 **
add := func(a int) int {
	return a + 1
}(3)
fmt.Print(add) // 4

// ** 2 **
mul := func(a int) int {
  return a * 2
}
fmt.Print(mul(3)) // 6
```

**1** 처럼 익명 함수 뒤에 ()로 변수를 넘겨 바로 실행할 수도 있고, **2** 처럼 익명 함수 자체를 변수에 저장하여 사용할 수 있다. **2** 처럼 사용할 경우, 일반 선언 함수와 마찬가지로 사용할 수 있다.

그렇다면 선언 함수와 **2** 처럼 익명 함수를 변수에 저장하는 것의 차이는 무엇일까?

```go
func test() {
	fmt.Print("선언 함수")
}

func main() {
	test := func() {
		fmt.Print("익명 함수")
	}
	test()
}

// 익명 함수
```

선언 함수는 프로그램 실행과 동시에 읽혀 전역으로 메모리가 할당되지만, 익명 함수는 사용되어지는 곳에서 읽힌다. 이는 선언 함수를 전역 변수, 익명 함수를 지역 변수라고 생각하면 쉽다. 즉, `선언 함수가 익명 함수보다 먼저 읽힌다.` 

<br/>

### Go의 type문

`type` 문을 사용하면, 미리 사용할 원형을 정의해놓을 수 있다.

* `type` 을 이용한 함수 원형 정의

  위에서 매개변수로 함수를 받을 때 다음과 같이 사용했는데,

  ```go
  func print(f func(int, int) int, a int , b int) {}
  ```

  만약, 매개변수로 넘길 함수의 개수가 많아진다면 코드의 길이가 너무 길어질 수 있다. 다음과 같이 `type` 을 사용하여 미리 함수의 원형을 정의할 수 있다.

  ```go
  type addFrame func(int, int) int
  
  func print(add addFrame, a int, b int) {
  	fmt.Print(add(a, b))
  }
  ```

* `type` 을 이용한 구조체 정의

  Go에서도 C처럼 미리 구조체를 만들어 사용할 수 있다. 

  ```go
  type person struct {
  	name string
  	age int
  	contact string
  }
  ```

<br/>

### Go의 클로저

클로저란?

> 함수 안에서 익명 함수를 정의해 바깥쪽 함수에 선언한 변수에도 접근할 수 있는 함수

```go
func next() func() int {
	i := 0
	return func() int {
		i += 1
		return i
	}
}
```

위의 `next()` 는 `int 를 반환하는 함수` 를 반환한다. 

```go
func main() {
	nextInt := next() // next() 는 i를 참조하는 익명 함수.
  
  // 익명 함수 실행값 출력
  fmt.Println(nextInt()) // 1
  fmt.Println(nextInt()) // 2
  
  newInt := next()
  fmt.Println(newInt()) // 1
}
```

`newInt` 는 새로운 `next` 를 호출했기 때문에 새로운 i 값을 할당받아 실행했을 때 1 이 출력된다.

<br/>

### Go의 구조체

```go
type person struct {
	name string
	age int
	contact string
}

// struct 의 사용
func main() {
  var p1 = person{} // 현재는 비어서 Zero value 이다. { 0 }
  p1.name = "kim"
  p1.age = 25
  p1.contact = "1234"
  // p1 = {kim 25 1234}
  
  p2 := person{"lee", 25, "5678"} // 순서대로 값 부여
  p3 := person{contact : "0123", name : "lim", age = 26} // 필드 이름 명시
}
```

역시 `구조체.필드명` 으로 값을 수정하거나, 개별로 접근하는 것도 가능하다.

* 구조체를 Call by Reference 방식으로 넘기는 두 가지 방법

  ```go
  func addByRef(a *person) { // Pass by reference
  	a.age += 4
  }
  // 함수 내부에서 다른 타입은 역참조를 위해 변수 앞에 *를 붙였지만,
  // 구조체는 자동 역참조이기 때문에 *를 붙이지 않는다.
  ```

  1. `new(구조체이름)` 으로 객체를 생성하기. (구조체 자체에 포인터가 생긴다.)

     ```go
     var p1 = new(person)
     p1.age = 25
     addByRef(p1) // &는 생략
     ```

  2. 구조체 이름 앞에 `&` 붙이기.

     ```go
     var p2 = person{}
     p2.age = 25
     addByRef(&p2) // &를 붙여 참조하도록 한다.
     ```

* 생성자 함수

  구조체 내부에 슬라이스나 맵처럼 초기화가 필요한 필드가 있을 때, 매번 구조체 생성과 동시에 초기화를 해야한다. 이러한 번거로운 과정을 `생성자 함수`를 만들어 해결할 수 있다.

  ```go
  type student struct {
  	name string
  	scores map[string]int
  }
  
  func constructor_pointer() *student {
  	s := student{} // 구조체 생성
  	s.scores = map[int]string{} // 맵 초기화
  	return &s
  }
  
  func constructor_basic() student {
  	s := student{} // 구조체 생성
  	s.scores = map[int]string{} // 맵 초기화
  	return s
  }
  
  func main() {
  	cp := constructor_pointer() // new 를 사용해 생성한 것과 같음.
  	cb := constructor_basic() // 포인터가 없는 구조체
  	
  	fmt.Print(cp, cb) // &{ map[]} { map[]}
  }
  ```

<br/>

### Go의 메소드 (Method)

> 구조체의 필드들을 이용해 특정 기능을 하는 특별한 함수

메소드를 사용하면, 해당 구조체에 대해서 특정 기능을 수행하는 함수를 쉽게 만들고 선언할 수 있다.

```go
func (s *triangle) triArea() float32 { // 구조체 triangle의 메소드 선언
	return s.width * s.height / 2
}

tri := triangle{3.0, 4.0}
triarea := tri.triArea() // 6.0
```

메소드 역시 `(s *triangle)` 을 하면, 포인터 객체로 받아 구조체 내부에 직접 접근할 수 있지만, `*` 를 붙이지 않고 `(s triangle)` 만하면 Pass by Value 로 동작한다.

> Go에는 Class 개념이 존재하지 않기 때문에 구조체 내부에 필드를 같이 두는 것이 아닌 일반 함수처럼 외부에 따로 선언을 한 뒤에 사용한다.
>
> 마치 Java 에서 Class 에서 필드와 메소드를 사용하는 것처럼 구조체와 메소드를 사용한다고 생각하면 쉽다.

* 인터페이스를 사용한 메소드의 집합

  > Dynamic type 으로 어떠한 타입도 담을 수 있는 컨테이너.

  필드들을 모아놓은 구조체가 있다면, 메소드들을 모아놓은 것도 필요하다. 각 다른 구조체에 대해 동일한 기능을 하는 메소드들을 인터페이스로 묶어서 사용할 수 있다.

  ```go
  type geometry interface {
  	area() float64 // float64를 반환하는 area() 라는 메소드
  }
  
  // 각기 다른 구조체 선언
  type Rect struct { 
  	width, height float64
  }
  
  type Circle struct {
  	radius float64 
  }
  
  // 각기 다른 구조체를 받는 메소드 선언
  func (r Rect) area() float64 {
  	return r.width * r.height
  }
  
  func (c Circle) area() float64 {
  	return math.Pi * c.radius * c.radius
  }
  
  func main() {
    r := Rect{10,20}
    c := Circle{10}
    
    printMeasure(r, c)
  }
  
  func printMeasure(m ...geometry) { // 인터페이스 가변 인자
    for _, val := range m {
      fmt.Println(val.area())
    }
  }
  ```

<br/>

### Go의 인터페이스

인터페이스는 Go의 하나의 타입이지만 `Dynamic type` 이기 때문에 어떤 타입도 담을 수 있다. 

* 인터페이스의 특징

  * 내용을 따로 선언하지 않아도 하나의 형(Type)으로 사용할 수 있다.
  * Type 이기 때문에 매개변수로 사용될 수 있다.
  * 어떠한 타입도 담을 수 있는 Dynamic Type, 컨테이너이다.

* 빈 인터페이스의 활용

  ```go
  func printValue(i interface{}) {
  	fmt.Println(i)
  }
  
  func main() {
  	var x interface{} // 빈 인터페이스 선언
  	
  	x = 1
  	printValue(x) // 1
  	
  	x = "test"
  	printValue(x) // test
  }
  ```

<br/>

### Go의 defer

Java를 사용하다 보면 `finally` 라는 키워드를 한번쯤은 마주치게 된다. Go에서도 함수가 종료되기 직전 실행하는 키워드 `defer` 가 있다.

`defer` 를 사용하면 예외 처리가 많은 구문이나 파일 클로즈와 같은 부분을 쉽게 처리할 수 있습니다.

```go
func world() {
  fmt.Println(" world")
}

func main() {
  defer world()
  fmt.Print("Hello ")
  
  for i := 1; i <= 3; i++ {
    defer fmt.Print(i)
  }
}

// Hello 321 world
```

<br/>

### Go의 panic

Go의 `panic`은 문법적으로는 오류가 없지만, 논리적으로 예외가 발생하는 경우를 의미한다. Java에서의 `exception`과 비슷하다.

```go
var num int = 10.5 // 문법적 오류

var a, b int = 10, 0 
fmt.Println(a / b) // 논리적 오류 - panic 발생
```

1. 같은 함수 내부에 defer가 있다면, panic 발생 시 defer 가 동작한 후 종료된다.

2. Java의 exception처럼 사용자가 직접 panic을 발생시킬 수 있다.

   ```go
   var zero int
   fmt.Scanln(&zero)
   
   if zero == 1 {
   	panic("opt은 1이 될 수 없습니다.")
   }
   ```

3. panic이 발생하더라도 프로그램을 종료하지 않기 위해서는 `recover()` 함수를 사용합니다.

   ```go
   func panicTest() {
   	defer func() {
   		r := recover() // 복구 및 에러 메세지 가져옴.
   		fmt.Println(r)
   	}
   	
   	panic("패닉에 빠졌다!")
   }
   
   func main() {
   	panicTest()
   	fmt.Println("Hello, world")
   }
   
   // 패닉에 빠졌다!
   // Hello, world
   ```

   * `recover()` 함수는 panic이 발생할 구간에서 사용되어야 한다.
   * panic으로 인해 프로그램이 종료되는 것을 막고 복구한다.
   * 프로그램 종료 전 실행되어야 하기 때문에 defer 로 선언된 함수 안에 쓰인다.
   * 에러 메세지를 반환하기 때문에, 출력도 가능하다.

<br/>

### Go의 error

일반적으로 아는 fmt 의 함수 들은 반환값을 가지고 있다. 예를 들어 fmt.Scan(&input) 함수는 (n int, err error) 를 반환한다. 이 때 error는 받아야 되는 n개의 변수를 받지 않으면 error에 반환한다.

* error 타입

  `error` 는 interface 형으로 다음과 같이 정의되어 있다.

  ```go
  type error interface {
  	Error() string
  }
  
  func (e *errorString) Error() string {
  	return e.s
  }
  
  type errorString struct {
  	s string
  }
  ```

따라서, 에러를 발생시키기 위해서는 포인터 구조체인 errorString를 초기화하면 된다. 초기화하는 함수는 패키지 `"errors"` 에 다음과 같이 정의되어 있다.

```go
func New(text string) error {
	return &errorString(text)
}
```

* 에러 발생시키기

  ```go
  func div(a int, b int) (result int, err error) {
  	if b == 0 {
  		return 0, errors.New("0으로 나눌 수 없습니다.")
  	}
  	result = a / b
  }
  
  func main() {
    result, err := div(4, 0)
    
    if err != nil {
      panic(err)
    }
    
    fmt.Print(result)
  }
  
  // 0으로 나눌 수 없습니다.
  ```

  error를 발생시키지 않으면 nil 이므로, 에러 발생 없이 div가 실행됩니다.

### <br/>Go의 log 패키지

* func Fatal(v ...interface{})

  > 에러 로그 출력 및 프로그램 종료

* func Panic(v ...interface{})

  > 시간, 에러 메세지 출력 및 패닉 발생, defer 구문이 없으면 런타임 패닉 발생 후 콜스택 출력

* func Print(v ...interface{})

  > 시간, 에러 메시지 출력 하지만 프로그램 종료하지 않음

<br/>

### Goroutine

> 고루틴이란 여러 함수를 동시에 실행할 수 있는 논리적 **가상** 스레드이다.

Java는 함수 호출 시 멀티 스레드를 사용하지만 Go언어에서는 스레드보다 훨씬 가벼운 비동기 동시 처리가 구현되어 스레드와 1대 1 대응하지 않고 훨씬 적은 스레드를 사용한다. 이는, 프로그램 성능과 고루틴 사용 개수는 상관이 없다는 의미가 된다.

* 고루틴의 사용

  ```go
  func hello() {
  	fmt.Println("hello world")
  }
  
  func main() {
  	go hello()	
  }
  ```

  `hello()` 가 비동기적으로 실행이 되고, 그전에 `main()` 이 끝나게 되면 fmt.Println("hello world") 가 실행이 되지 않고 프로그램이 종료될 수 있다.

  이런 상황을 막기 위해 `sync` 패키지의 `WaitGroup` 을 사용한다.

* sync 패키지

  > WaitGroup은 sync 패키지에 선언되어 있는 구조체로서 고루틴이 완료될 때까지 대기한다. 이를 변수로 선언해 메소드를 활용할 수 있다.

  * Add() : 기다릴 고루틴의 수 설정
  * Done() : 고루틴이 실행된 함수 내에서 호출, 함수가 끝나씀을 알림
  * Wait() : 고루틴이 모두 끝날 때까지 기다림

  ```go
  func hello(w *sync.WaitGroup) { // Call by Reference 방식으로 보냄.
  	defer w.Done()
  	fmt.Println("hello world")
  }
  
  func main() {
  	wait := new(sync.WaitGroup) // 포인터 구조체 생성
  	
  	wait.Add(1)
  	go hello(wait)
  	
  	wait.Wait() // 고루틴이 끝날때까지 대기
  }
  ```

<br/>

### Go의 Channel

고루틴을 사용하면 고루틴의 함수가 실행되기 전에 메인 함수가 종료될 수 있다. 그렇기 때문에 아래 두 가지 방법을 사용했었다.

1. 메인 함수 마지막에 fmt.Scanln() 함수를 사용
2. WaitGroup 사용으로 고루틴 종료 대기

그러나 위의 방법은 고루틴이 종료되는 것을 기다리게할 뿐, 고루틴 간의 순서나 그들 사이의 흐름을 제어하지 않는다. 

채널은 고루틴 사이의 값을 주고받는 통로 역할을 하고, 송/수신자가 서로를 기다리는 속성이 생겨 고루틴의 흐름을 제어한다. 채널의 데이터를 주고 받을 때까지 해당 고루틴을 종료하지 않아 별도의 lock을 하지 않아도 데이터를 동기화할 수 있다.

#### 채널의 특징

* `make(chan 데이터타입)` 형식으로 생성
* 채널의 데이터 송/수신은 `<-` 연산자를 사용
* 채널에 값을 보낼 때는 `채널 <- 데이터` 
* 채널에서 값을 받을 때는 `<- 채널` (`채널 데이터`, `채널 개폐 여부 반환`)
* 채널에서 값을 받을 때까지만 대기하고, 가져오면 바로 다음 코드를 실행

```go
func main() {
	var a, b = 10, 5
	var result int
	
	c := make(chan int) // 채널 생성
	
	go func() { // 익명 고루틴 실행
		c <- a + b // 데이터를 채널로 보냄
	}() 
	
	result = <- c // 해당 채널에서 값을 받음
	
	fmt.Print(result)
}

// 15
```

채널은 해당 데이터가 송/수신될 때까지만 기다린다. 그렇기 때문에 채널 통신 외의 다른 코드가 있다면 해당 고루틴이 종료되기 전에 main이 끝날 수 있다. 이런 점을 잘 주의해서 채널을 사용해야 한다.

채널의 특징을 잘 사용하면 sync.WaitGroup 처럼도 사용할 수 있다.

```go
func main() {
	var str = "hello, world"
	done := make(chan bool)
	
	go func() {
		fmt.Println(str)
		
		done <- true // 채널에 true를 송신
	}()
	
	<- done // 수신하면서 대기를 끝냄
}
```

<br/>

### Go의 비동기 채널 버퍼

채널은 고루틴이 없어도 사용할 수 있다. 그러나, 다음과 같은 코드에서는 **데드락** 이 발생한다.

```go
func main() {
	c := make(chan string)
	
	c <- "hello world" // 송신
	
	// <-c 를 기다리며 무한 대기 상태에 빠진다.
	fmt.Println(<-c)
}
```

데드락을 발생시키지 않게 하기 위해서 **비동기 채널 버퍼**를 사용한다. 송신 루틴에서 수신 루틴으로 데이터를 바로 전달하는 것이 아닌, 특정 개수의 버퍼를 만들어서 송신자는 버퍼로 데이터를 보내고, 수신자는 버퍼에서 데이터를 가져오게끔 한다. 

이 때, 송/수신 루틴에서는 자신들이 해야할 일들이 끝나면 사용할 때까지 대기 상태에 빠지지 않고 진행된다.

```go
func main() {
	c := make(chan string, 1) // 버퍼의 크기가 1
	
	c <- "hello world" // 송신 -> 일이 끝남
	
	fmt.Println(<-c) // 버퍼에 존재하기 때문에 실행
}
```

* 고루틴의 대기 조건
  * 송신 루틴 : 버퍼가 가득차면 대기
  * 수신 루틴 : 버퍼에 값이 없으면 대기

하지만, 이 또한 송/수신 루틴의 개수가 맞지않으면 데드락이 발생하기 때문에 주의해서 써야 한다.

#### 채널 닫기

수신이 명확하지 않은 데이터 송신은 무한 대기 상황을 발생시키고, 메인이라면 데드락에 빠지게 된다.

```go
func main() {
	c := make(chan string, 2) 
	
	c <- "Hello"
	c <- "world"
	
	fmt.Println(<-c)
	fmt.Println(<-c)
	fmt.Println(<-c) // 무한 대기 상황, 데드락 발생
}
```

채널에 데이터를 송신한 후 채널을 닫으면 송신은 더 이상 불가능하지만 채널이 닫힌 후에 계속 수신이 가능하다.

```go
func main() {
	c := make(chan string, 2) 
	
	c <- "Hello"
	c <- "world"
	
	close(c)
	
	fmt.Println(<-c)
	fmt.Println(<-c)
	fmt.Println(<-c) // nil 값 반환
}
```

* 채널을 닫은 후에 데이터를 송신하면 `send on closed channel` 패닉 발생
* 모두 수신한 후, 또 수신하면 nil 값 반환

<br/>

### Channel 의 특징

* 매개 변수로 활용이 가능하다.

  ```go
  func main() {
  	c := make(chan int)
  	go channel1(c)
  	fmt.Scanln()
  }
  
  func channel1(ch chan int) {
  	ch <- 1
  	fmt.Println(<-ch)
  }
  ```

* 매개 변수 전달/반환 시 채널의 역할을 지정할 수 있다.

  * 수신 전용 채널

    ```go
    receiveChannel(ch <-chan int) {
    	fmt.Println(<-ch)
    	// ch <- 3 은 오류 발생
    }
    ```

  * 송신 전용 채널

    ```go
    sendChannel(ch chan<- int) {
    	ch <- 3
    	// fmt.Println(<-ch) 은 오류 발생
    }
    ```

    
