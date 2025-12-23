package com.example.demo.common.init;

import com.example.demo.user.domain.*;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {

        // 이미 데이터 있으면 중복 삽입 방지
        if (userRepository.count() > 0) {
            return;
        }

        // 기준 유저 (나)
        userRepository.save(
                User.builder()
                        .gender(Gender.MALE)
                        .name("이지우")
                        .birthYear(2002)
                        .kakaoId("kakao_jiwoo")
                        .mbti(Mbti.INTJ)
                        .smoker(false)
                        .sleepTime(1)
                        .wakeTime(8)
                        .snoring(false)
                        .cleaningCycle(CleaningCycle.DAILY)
                        .drinkingStyle(DrinkingStyle.RARELY)
                        .bugKiller(true)
                        .hobby("독서")
                        .selfDescription("조용하고 계획적인 성격입니다.")
                        .roommateDescription("생활 패턴이 비슷한 분이면 좋겠습니다.")
                        .build()
        );

        // 후보자 1
        userRepository.save(
                User.builder()
                        .gender(Gender.MALE)
                        .name("후보자1")
                        .birthYear(2001)
                        .kakaoId("kakao_1")
                        .mbti(Mbti.INFP)
                        .smoker(false)
                        .sleepTime(2)
                        .wakeTime(9)
                        .snoring(false)
                        .cleaningCycle(CleaningCycle.WEEKLY)
                        .drinkingStyle(DrinkingStyle.RARELY)
                        .bugKiller(false)
                        .hobby("음악감상")
                        .selfDescription("혼자 있는 시간을 좋아합니다.")
                        .roommateDescription("서로 배려했으면 합니다.")
                        .build()
        );

        // 후보자 2
        userRepository.save(
                User.builder()
                        .gender(Gender.MALE)
                        .name("후보자2")
                        .birthYear(1999)
                        .kakaoId("kakao_2")
                        .mbti(Mbti.ENTJ)
                        .smoker(true)
                        .sleepTime(0)
                        .wakeTime(7)
                        .snoring(true)
                        .cleaningCycle(CleaningCycle.NEVER)
                        .drinkingStyle(DrinkingStyle.FREQUENTLY)
                        .bugKiller(true)
                        .hobby("헬스")
                        .selfDescription("활동적인 성격입니다.")
                        .roommateDescription("서로 터치 없이 지냈으면 좋겠습니다.")
                        .build()
        );

        // 후보자 3
        userRepository.save(
                User.builder()
                        .gender(Gender.MALE)
                        .name("후보자3")
                        .birthYear(2003)
                        .kakaoId("kakao_3")
                        .mbti(Mbti.ISFJ)
                        .smoker(false)
                        .sleepTime(3)
                        .wakeTime(10)
                        .snoring(false)
                        .cleaningCycle(CleaningCycle.DAILY)
                        .drinkingStyle(DrinkingStyle.DAILY)
                        .bugKiller(true)
                        .hobby("요리")
                        .selfDescription("정리정돈을 중요하게 생각합니다.")
                        .roommateDescription("청결한 분이면 좋겠습니다.")
                        .build()
        );
    }
}