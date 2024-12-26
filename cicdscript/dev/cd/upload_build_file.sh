cd /var/lib/jenkins/workspace/CI-dev/build/libs
zip -r money-gate.zip money-gate-0.0.1-SNAPSHOT.jar
aws --endpoint-url=https://kr.object.ncloudstorage.com s3 cp money-gate.zip s3://money-gate-bucket/money-gate.zip