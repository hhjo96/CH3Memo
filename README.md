# CH3 일정 관리 앱 만들기

##A API 명세


## ERD
Table memos {  
id integer [primary key]  
title varchar [not null]  
body text [note: 'Content of the memos']  
user_id integer [not null]  
password varchar  
created_at timestamp [not null]  
modified_at timestamp  
}  

Table comments {  
id integer [primary key]  
memo_Id integer [not null]  
body text [note: 'Content of the comments']  
user_id integer [not null]  
password varchar  
created_at timestamp [not null]  
modified_at timestamp  
}  
Ref: "comments"."memo_Id" < "memos"."id"

![img_1.png](img_1.png)

## 주의사항
- 일정 작성, 수정, 조회 시 반환 받은 일정 정보에 `비밀번호`는 제외해야 합니다.
- 일정 수정, 삭제 시 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 가능합니다.
