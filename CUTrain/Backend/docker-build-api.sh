#! /usr/bin/env bash
set -e

REGISTRY="registry.gitlab.com/softsquare_ssru/registry"
IMAGE_NAME="adm-api"
TAG_DATETIME=$(date +%Y%m%d)
COMMIT_SHORT_SHA="$(git rev-parse --short HEAD)"
DOCKER_BUILDKIT=1

docker build --rm -f "Dockerfile" -t ${IMAGE_NAME} \
-t ${IMAGE_NAME}:${COMMIT_SHORT_SHA} \
-t ${IMAGE_NAME}:${TAG_DATETIME} \
-t ${REGISTRY}/${IMAGE_NAME} \
-t ${REGISTRY}/${IMAGE_NAME}:${COMMIT_SHORT_SHA} \
-t ${REGISTRY}/${IMAGE_NAME}:${TAG_DATETIME} .
