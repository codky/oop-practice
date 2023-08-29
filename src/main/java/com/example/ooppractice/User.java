package com.example.ooppractice;

public class User {
    private String password;

    /**
     * 초기화
     */
    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is
        // 내부에서 생성하는 경우는 강한 결합: 해당 부분에 많은 영향을 받는다. -> 테스트하기 어렵다.
        // RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be
        // 인터페이스를 주입받아서 RandomPasswordGenerator에 의존하지 않는다. -> 테스트하기 쉽다.
        // 테스트 코드 작성 이유중에 '4. 테스트하기 쉬운 코드를 작성하다보면 더 낮은 결합도를 가진 설계를 얻을 수 있음' 에 해당(느슨한 결합을 가진 설계)
        String randomPassword = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }
    }

    public String getPassword() {
        return password;
    }
}
