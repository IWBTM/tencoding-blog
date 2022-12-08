package com.tencoding.blog.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import com.tencoding.blog.model.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// mysql server 실행
// 테이블 생성
// 제약 추가
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString

//@ColumnDefault를 사용하기 위해선 선언해야 한다. 
// null 필드가 들어오면 무시해 ! -> 그럼 디폴트 값이 적용된다.
@DynamicInsert 
public class User {

	@Id // PK 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB 넘버링 전략을 따라간다.
	private int id;

	@Column(nullable = false, length = 30)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 50)
	private String email;

//	@ColumnDefault("'user'") // 문자열이라는 것을 알려줘야한다. -> (' ')
	@Enumerated(EnumType.STRING) // DB에게 문자열이라는 것을 알려주자.
	private RoleType role; // Enum 타입으로 변경

	@CreationTimestamp // 시간이 자동으로 입력 된다..?
	private Timestamp createDate;
}
