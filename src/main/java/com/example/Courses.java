package com.example;

import java.util.List;

// 일급 컬렉션 -> 여러개의 Course 정보를 가진 클래스(List, set 형태 등)
// Course 의 정보로 처리할 수 있는 책임들이 해당 일급 컬렉션 클래스 밑으로 모두 이동
// 수정사항이 생겼을 때 이 클래스 안에서 메서드만 수정하면 된다.
public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream() // 이수한 과목들을 전체 돌면서 과목들의 학점수*성적정보를 모두 sum()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream() //  이수한 과목들을 전체 돌면서 해당하는 학점들을 모두 sum()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
