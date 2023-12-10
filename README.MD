# 마드라스체크 사전 과제 REST API 문서
<br>

## Table of Contents
- [개요](#개요)
- [Skill](#Skill)
- [Installation](#Installation)
- [Running Tests](#running-tests)
- [API Reference](#api-reference)
- [프로젝트 진행 및 이슈 관리](#프로젝트-진행-및-이슈-관리)
- [ERD](#ERD)

<br>

## 개요
어떤 파일들은 첨부시 보안에 문제가 될 수 있다. 특히 exe, sh 등의 실행파일이 존재할 경우 서버에
올려서 실행이 될 수 있는 위험이 있어 파일 확장자 차단을 기획하게 됨.

`주요기능`
> 1. 운영자는 금지할 파일 확장자를 설정한다.
> 2. 파일 확장자는 기본 확장자 유저가 지정하는 확장자 두개로 나눠진다
> 3. 파일 확장자를 금지시킬 수 있고 다시 허용시킬 수 있다.

<br>

## Skill
<div align="center">
<img src="https://img.shields.io/badge/Java 17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring Boot 3-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring Data JPA-gray?style=for-the-badge&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Junit-25A162?style=for-the-badge&logo=JUnit5&logoColor=white"/></a>
</div>
<div align="center">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/></a>
<img src="https://img.shields.io/static/v1?style=for-the-badge&message=Amazon+EC2&color=222222&logo=Amazon+EC2&logoColor=FF9900&label=" alt="Amazon EC2">
<img src="https://img.shields.io/static/v1?style=for-the-badge&message=Amazon+RDS&color=527FFF&logo=Amazon+RDS&logoColor=FFFFFF&label=" alt="Amazon RDS">
</div>
<div align="center">
<img src="https://img.shields.io/badge/asciidoctor-E40046?style=for-the-badge&logo=asciidoctor&logoColor=white"/></a>
</div>

## Installation

```bash
./gradlew bootjar
./gradlew bootrun
```

## Running Tests
```bash
  ./gradlew test
```

> ![Static Badge](https://img.shields.io/badge/Test_Passed-6/6-green)<br>
> ![coverage](src/main/resources/static/image/test.png)

## API Reference
> [![POST_MAN](https://img.shields.io/badge/asciidoctor_-CLICK🖱-%23000000.svg?style=for-the-badge&logo=asciidoctor&logoColor=E40046)](https://madrascheck.u-jinlee.dev/docs/index.html)<br>
> ![Project_](src/main/resources/static/image/api_reference.png)

## 프로젝트 진행 및 이슈 관리

> [![Notion](https://img.shields.io/badge/Github_project_-CLICK🖱-%23000000.svg?style=for-the-badge&logo=Github&logoColor=white)](https://github.com/users/U-jinLee/projects/3/views/1)<br>
> ![Project_](src/main/resources/static/image/project.png)


## ERD
> ![Project_](src/main/resources/static/image/erd.png)
> - 파일확장자의 상태는 DEFAULT, CUSTOM 두 가지로 나눠진다

