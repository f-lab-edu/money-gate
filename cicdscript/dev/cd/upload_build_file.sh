# 환경변수에서 API 키를 가져옵니다
export AWS_ACCESS_KEY_ID=${API_ACCESS_KEY}
export AWS_SECRET_ACCESS_KEY=${API_SECRET_KEY}
cd /var/lib/jenkins/workspace/deploy-server-dev/build/libs
zip -r money-gate.zip money-gate-0.0.1-SNAPSHOT.jar
aws --endpoint-url=https://kr.object.ncloudstorage.com s3 cp money-gate.zip s3://money-gate-bucket/money-gate.zip