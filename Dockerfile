FROM openjdk:17-jdk-slim

# Install dependencies required for Gradle
RUN apt-get update && apt-get install -y wget unzip curl jq && rm -rf /var/lib/apt/lists/*

# Add Gradle to the PATH
ENV GRADLE_HOME=/opt/gradle
ENV PATH=$GRADLE_HOME/bin:$PATH

# Copy Gradle build files separately for Docker layer caching
COPY build.gradle settings.gradle /app/

WORKDIR /app

# Copy the rest of the application code
COPY . /app/

CMD ["bash"]
