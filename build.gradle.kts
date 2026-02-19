plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.paradigma0621"
version = "0.0.1-SNAPSHOT"
description = "Report microservice"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

extra["springCloudVersion"] = "2023.0.6" // Spring Cloud Leyton (Boot 3.3.x) :contentReference[oaicite:1]{index=1}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

dependencies {
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-jdbc")
		implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

		runtimeOnly("org.postgresql:postgresql")

		compileOnly("org.projectlombok:lombok")

		annotationProcessor("org.projectlombok:lombok")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
