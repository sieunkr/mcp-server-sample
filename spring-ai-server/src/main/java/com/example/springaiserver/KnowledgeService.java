package com.example.springaiserver;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KnowledgeService {

    public static class KnowledgeDocument {
        public String title;
        public String summary;
        public List<String> tags;
        public String author;
        public LocalDate createdDate;
        public String department;

        public KnowledgeDocument(String title, String summary, List<String> tags,
                                 String author, LocalDate createdDate, String department) {
            this.title = title;
            this.summary = summary;
            this.tags = tags;
            this.author = author;
            this.createdDate = createdDate;
            this.department = department;
        }
    }

    @Tool(description = "Get a list of internal technical documents for knowledge clustering")
    public List<KnowledgeDocument> getCompanyKnowledgeDocuments() {

        // MCP 개념을 학습하고 실험해보기 위한 샘플 데이터 반환
        // 실제 구현 시에는 실시간 사내 지식 데이터와 연동하는 방식으로 확장 가능
        return List.of(
                new KnowledgeDocument(
                        "Spring Boot Kafka 소비자 안정화 전략",
                        "Kafka consumer group rebalance 문제를 해결하기 위한 설정값과 모니터링 전략을 설명합니다.",
                        List.of("Kafka", "Consumer", "Rebalance", "Spring Boot"),
                        "minji.kim",
                        LocalDate.of(2024, 12, 12),
                        "backend"
                ),
                new KnowledgeDocument(
                        "QueryDSL vs JPA Criteria 비교",
                        "QueryDSL이 실무에서 더 유용한 이유와 프로젝트 적용시 발생할 수 있는 문제점들을 비교 분석합니다.",
                        List.of("JPA", "QueryDSL", "ORM"),
                        "jaehyun.lee",
                        LocalDate.of(2023, 1, 20),
                        "backend"
                ),
                new KnowledgeDocument(
                        "Redis를 이용한 게임 랭킹 캐싱 구조",
                        "게임 랭킹 정보를 캐싱하여 응답 속도를 개선하고 DB 부하를 줄이는 설계 방안을 다룹니다.",
                        List.of("Redis", "Game", "Cache", "Ranking"),
                        "jisu.park",
                        LocalDate.of(2025, 2, 5),
                        "game-server"
                ),
                new KnowledgeDocument(
                        "비동기 처리에서의 트랜잭션 관리 전략",
                        "Spring @Transactional이 비동기 메서드에서 어떻게 동작하는지와 그 대안들에 대해 설명합니다.",
                        List.of("Transaction", "Async", "Spring"),
                        "sungho.cho",
                        LocalDate.of(2025, 3, 12),
                        "platform"
                ),
                new KnowledgeDocument(
                        "OAuth2 인증 흐름 이해 및 내부 도입 사례",
                        "OAuth2 인증 흐름의 기본 개념과 사내 서비스에 적용한 구조를 설명합니다.",
                        List.of("OAuth2", "Security", "Authorization", "SSO"),
                        "eunseo.ryu",
                        LocalDate.of(2025, 1, 5),
                        "platform"
                ),
                new KnowledgeDocument(
                        "Terraform을 활용한 인프라 코드 관리 전략",
                        "IaC를 도입하면서 발생한 이슈들과 모듈화 전략을 공유합니다.",
                        List.of("Terraform", "DevOps", "IaC"),
                        "daehyun.jo",
                        LocalDate.of(2024, 11, 10),
                        "infra"
                ),
                new KnowledgeDocument(
                        "게임 매치메이킹 로직 개선 제안서",
                        "유저 레벨과 승률 기반의 매칭 알고리즘 개선안을 제안합니다.",
                        List.of("Game", "Matchmaking", "Algorithm"),
                        "hyejin.kang",
                        LocalDate.of(2025, 3, 3),
                        "game-design"
                ),
                new KnowledgeDocument(
                        "Kafka Consumer Lag 모니터링 구축기",
                        "Prometheus와 Grafana를 이용해 Kafka lag을 시각화한 방법을 공유합니다.",
                        List.of("Kafka", "Monitoring", "Prometheus", "Grafana"),
                        "wonho.kim",
                        LocalDate.of(2025, 4, 20),
                        "backend"
                ),
                new KnowledgeDocument(
                        "React 앱 초기 로딩 개선 전략",
                        "코드 스플리팅과 lazy loading을 적용하여 퍼포먼스를 개선한 사례입니다.",
                        List.of("React", "Performance", "Code Splitting", "Frontend"),
                        "yuna.choi",
                        LocalDate.of(2025, 4, 24),
                        "frontend"
                )
        );
    }
}
