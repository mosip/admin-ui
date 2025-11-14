# Base image: Java 21 JRE on Alpine
FROM eclipse-temurin:21-jre-alpine

# Install dependencies: bash, curl, wget, unzip, Chromium + ChromeDriver, Xvfb, fonts, and common libs
USER root
RUN apk add --no-cache \
      bash \
      curl \
      wget \
      unzip \
      ca-certificates \
      # Headless browser bits
      chromium \
      chromium-chromedriver \
      xorg-server-xvfb \
      # Useful runtime libs for Chromium
      nss \
      freetype \
      harfbuzz \
      libxi \
      # Fonts to avoid tofu/missing glyphs
      ttf-freefont \
      font-noto

# Install kubectl (latest stable)
RUN curl -L -s https://dl.k8s.io/release/stable.txt -o /tmp/kver && \
    curl -LO "https://dl.k8s.io/release/$(cat /tmp/kver)/bin/linux/amd64/kubectl" && \
    chmod +x kubectl && \
    mv kubectl /usr/local/bin/kubectl && \
    rm -f /tmp/kver

# Build-time args and labels
ARG SOURCE
ARG COMMIT_HASH
ARG COMMIT_ID
ARG BUILD_TIME

LABEL source=${SOURCE}
LABEL commit_hash=${COMMIT_HASH}
LABEL commit_id=${COMMIT_ID}
LABEL build_time=${BUILD_TIME}

# Build-time args for user/group
ARG container_user=mosip
ARG container_user_group=mosip
ARG container_user_uid=1001
ARG container_user_gid=1001

# Working dir
ENV work_dir=/home/${container_user}/

# Create non-root user and home
RUN addgroup -g ${container_user_gid} ${container_user_group} && \
    adduser -D -u ${container_user_uid} -G ${container_user_group} -s /bin/bash -h ${work_dir} ${container_user} && \
    chown -R ${container_user}:${container_user_group} ${work_dir}

# Switch to app user
USER ${container_user_uid}:${container_user_gid}

# Copy application files
COPY --chown=${container_user_uid}:${container_user_gid} --chmod=771 ./entrypoint.sh ${work_dir}/entrypoint.sh
COPY --chown=${container_user}:${container_user_group} ./src/main/resources/ ${work_dir}/resources/
COPY --chown=${container_user_uid}:${container_user_gid} ./target/*.jar ${work_dir}

# Set working directory
WORKDIR /home/${container_user}/

# Entrypoint
ENTRYPOINT ["/bin/bash", "-c", "./entrypoint.sh"]
