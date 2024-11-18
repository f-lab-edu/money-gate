#!/bin/bash

# Naver Cloud Platform API 기본 설정
SOURCEDEPLOY_API_URL="https://vpcsourcedeploy.apigw.ntruss.com"
# 환경변수에서 API 키를 가져옵니다
API_ACCESS_KEY=${API_ACCESS_KEY}
API_SECRET_KEY=${API_SECRET_KEY}

## 배포 시작
echo "배포 시작 요청"

project_id=${project_id}
stage_id=${stage_id}
scenario_id=${scenario_id}
method="POST"
uri="/api/v1/project/${project_id}/stage/${stage_id}/scenario/${scenario_id}/deploy"

api_timestamp=$(perl -MTime::HiRes -e 'printf("%d\n", Time::HiRes::time()*1000)')

nl=$'\\n'
SIG="$method $uri$nl$api_timestamp$nl$API_ACCESS_KEY"
signature=$(echo -n -e "${SIG}"|iconv -t utf8 |openssl dgst -sha256 -hmac ${API_SECRET_KEY} -binary|openssl enc -base64)
echo $signature
response=$(curl -s -X POST "${SOURCEDEPLOY_API_URL}${uri}" \
          -H "x-ncp-apigw-timestamp: ${api_timestamp}" \
          -H "x-ncp-iam-access-key: ${API_ACCESS_KEY}" \
          -H "x-ncp-apigw-signature-v2: ${signature}")
echo "response: ${response}"