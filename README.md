# Android Repository Pattern

![69021c8142d29198_1920](https://user-images.githubusercontent.com/26853549/225842574-69c69464-21fa-4162-b2f4-7dd28d5e2566.png){: width="100" height="100"}

- Data Layer로 분리 즉, Model, DataSource ... 등이 타 레이어와의 의존성을 줄일 수 있다.
- LocalData or RemoteData에 동일한 인터페이스로 접근되며 viewModel은 Repository으로만 
접근이 가능하게되어 DataSource의 캡슐화가 가능하다.
- 의존성 분리로 인해 Data추가에 용이하며 사이드이펙트를 줄일 수 있다.
- 인터페이스를 통한 요청을 하므로 Test 검증에 용이 하다.

### But,

- interface, usecase 각 dataSource, 관심사별 class와 code 가 늘어난다.

![9e528301efd49aea_1920](https://user-images.githubusercontent.com/26853549/225842598-fe3bfadf-f34b-496a-a87c-6dbba6dc2cc8.png)
