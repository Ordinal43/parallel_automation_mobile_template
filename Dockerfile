FROM openjdk:17-jdk-slim

# Install dependencies required for Gradle
RUN apt-get update \
    && apt-get install -y wget default-jre-headless \
    && rm -rf /var/lib/apt/lists/*

# Add Gradle to the PATH
ENV GRADLE_HOME=/opt/gradle
ENV PATH=$GRADLE_HOME/bin:$PATH

# Copy Gradle build files separately for Docker layer caching
COPY build.gradle settings.gradle /app/

# Copy the rest of the application code
COPY . /app/

# Set environment variables
ENV ALLURE_VERSION=2.30.0
ENV DEB_FILE=allure_${ALLURE_VERSION}-1_all.deb

# Install allure and resolve dependencies
RUN wget https://github.com/allure-framework/allure2/releases/download/${ALLURE_VERSION}/${DEB_FILE} \
    && dpkg -i ${DEB_FILE} \
    && rm -f ${DEB_FILE}

WORKDIR /app

CMD ["bash"]
