# rag-release-helper-api

**2025-1 졸업프로젝트**  
RAG 기반 오픈소스 질의응답 시스템의 API 서버입니다.

---

## 🧩 개요

이 서버는 전체 RAG 시스템의 중앙 API 역할을 수행합니다.  
다음과 같은 서버들이 동작 중일 때 API가 정상적으로 작동합니다:

- **[LLM 서버](https://github.com/yuseunggeun/rag-release-helper-llm)**  
  사용자 질의에 대한 응답을 생성하는 LangChain 기반 서버
- **[Batch 서버](https://github.com/yuseunggeun/rag-release-helper-batch)**  
  GitHub 문서를 수집하고 벡터DB에 저장하는 배치 서버

---
## ⚙️ 스케줄링 안내

- 현재 **Batch 서버의 자동 스케줄링은 비활성화**되어 있습니다.
- `/api/batch/schedule` 엔드포인트를 호출하여 수동으로 스케줄링을 트리거할 수 있습니다.

---

## 💡 참고 사항

- LLM 서버와 Batch 서버가 구동 중이라면, **API 서버 없이도** 다음 주소에서 웹 브라우저로 질의응답을 직접 수행할 수 있습니다:

```
{Batch 서버 url}/chat/playground
```


