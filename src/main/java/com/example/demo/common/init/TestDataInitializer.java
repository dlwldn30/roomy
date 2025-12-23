package com.example.demo.common.init;

import com.example.demo.repair.domain.*;
import com.example.demo.repair.repository.RepairReportRepository;
import com.example.demo.user.domain.*;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RepairReportRepository repairReportRepository;

    @Override
    public void run(String... args) {

        // =========================
        // USER 더미 데이터
        // =========================
        if (userRepository.count() == 0) {

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
                            .drinkingStyle(DrinkingStyle.RARELY)
                            .bugKiller(true)
                            .hobby("요리")
                            .selfDescription("정리정돈을 중요하게 생각합니다.")
                            .roommateDescription("청결한 분이면 좋겠습니다.")
                            .build()
            );
        }

        // =========================
        // REPAIR REPORT 더미 데이터
        // =========================
        if (repairReportRepository.count() == 0) {

            repairReportRepository.save(
                    RepairReport.builder()
                            .floor("3")
                            .roomNumber("305")
                            .item("화장실")
                            .issue("막힘")
                            .severity(Severity.MEDIUM)
                            .priorityScore(5)
                            .description("물이 내려가지 않고 역류합니다.")
                            .imageUrl("storage/images/repair/report_1.jpg")
                            .reporterId(1L)
                            .status(RepairStatus.PENDING)
                            .createdAt(LocalDateTime.now().minusHours(2))
                            .build()
            );

            repairReportRepository.save(
                    RepairReport.builder()
                            .floor("2")
                            .roomNumber("210")
                            .item("싱크대")
                            .issue("누수")
                            .severity(Severity.HIGH)
                            .priorityScore(8)
                            .description("세면대 아래에서 물이 계속 샙니다.")
                            .imageUrl("storage/images/repair/report_2.jpg")
                            .reporterId(1L)
                            .status(RepairStatus.IN_PROGRESS)
                            .createdAt(LocalDateTime.now().minusHours(5))
                            .build()
            );

            repairReportRepository.save(
                    RepairReport.builder()
                            .floor("1")
                            .roomNumber(null)
                            .item("전등")
                            .issue("오작동")
                            .severity(Severity.LOW)
                            .priorityScore(3)
                            .description("복도 조명이 켜지지 않습니다.")
                            .imageUrl("storage/images/repair/report_3.jpg")
                            .reporterId(1L)
                            .status(RepairStatus.DONE)
                            .createdAt(LocalDateTime.now().minusDays(1))
                            .build()
            );

            repairReportRepository.save(
                    RepairReport.builder()
                            .floor("4")
                            .roomNumber("418")
                            .item("문")
                            .issue("파손")
                            .severity(Severity.CRITICAL)
                            .priorityScore(10)
                            .description("문이 잠기지 않아 외부 출입이 가능합니다.")
                            .imageUrl("storage/images/repair/report_4.jpg")
                            .reporterId(1L)
                            .status(RepairStatus.PENDING)
                            .createdAt(LocalDateTime.now().minusMinutes(30))
                            .build()
            );
        }
    }
}