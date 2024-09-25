FROM openjdk:17-jdk-slim

ENV IS_USING_DOCKER=true

# Install dependencies required for Gradle
RUN apt-get update \
    && apt-get install -y wget default-jre-headless \
    && rm -rf /var/lib/apt/lists/*

# Set environment variables
ENV ALLURE_VERSION=2.30.0
ENV DEB_FILE=allure_${ALLURE_VERSION}-1_all.deb

# Install allure and resolve dependencies
RUN wget https://github.com/allure-framework/allure2/releases/download/${ALLURE_VERSION}/${DEB_FILE} \
    && dpkg -i ${DEB_FILE} \
    && rm -f ${DEB_FILE}

WORKDIR /app

CMD ["bash"]
