package com.example;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }


    /**
     * 요구사항
     * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
     * • 일급 컬렉션 사용
     */
    public double calculateGrade() {
        // (학점수×교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();

            // course.multiplyCreditAndCourseGrade();
            // 응집도가 높다 --> 변화가 생길때 한군데만 수정하면 된다.
            // getter로 정보를 가져와서 처리하는 것이 아닌 해당 데이터를 가진 객체에게 메세지를 줘서 작업을 처리하게 하면 변화에 유연한 코드를 짤 수 있다.

        }

        // 이수한 과목들의(courses) 수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
