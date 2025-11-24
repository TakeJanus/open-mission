from fastapi import FastAPI
import uvicorn

app = FastAPI()

# 1. API 엔드포인트 정의
@app.get("/recommendations")
def get_recommendations():
    # 실제 AI 로직 대신 하드코딩된 데이터 리턴
    return {
        "popular_tags": ["Python", "Microservices", "AI Trend"],
        "algorithm_version": "v1.0"
    }

# 2. 서버 실행 설정 (포트 8082)
if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8082)