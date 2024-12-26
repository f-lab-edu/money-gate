plugins {
    java
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    id("java-test-fixtures")
    id("jacoco")
}

group = "com.joonhee"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

jacoco {
    toolVersion = "0.8.12"

}

tasks.test{
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport{
    dependsOn(tasks.test)
}

tasks.jacocoTestReport {
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                counter = "LINE"
                minimum = BigDecimal("0.6")
            }
        }
    }
}

// https://docs.spring.io/spring-data/jdbc/docs/2.4.18/reference/html/#jdbc.query-methods.at-query
// Java 8 이상에서는 컴파일 시에 파라미터 이름을 유지하도록 설정 (@Param 어노테이션 사용하지 않아도 됨)
tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    implementation("org.projectlombok:lombok")

    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")


    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2")
    testAnnotationProcessor("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

tasks.withType<Test> {
    useJUnitPlatform()
}
