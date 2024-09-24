# Parallel Mobile Automation Template Using Cucumber, Appium, and JUnit.

https://github.com/user-attachments/assets/8d8fa2f0-4fb2-46b9-b844-05807427f46b

This project is a Java test automation framework made using **Appium**, **Cucumber**, and **JUnit**. It uses the Page
Object Model (POM) design pattern for better test maintainability and readability.

For parallel testing capabilities, this repo leverages the help
of [CourgetteJVM](https://github.com/prashant-ramcharan/courgette-jvm) library
and [Appium Device Farm](https://devicefarm.org/) plugin for the Appium Server running separately.

This repo also has a DockerFile for setting up JDK 17 and Allure reporter.

For now only runs Android automation tests (iOS is planned for later).

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Reporting](#reporting)
- [License](#license)

## Prerequisites

Before setting up the project, ensure you have the following installed:

- [Node.js](https://nodejs.org/en/download/) (Required for Appium)
- [Appium](http://appium.io/docs/en/about-appium/getting-started/)
    - [UiAutomator2 driver](https://appium.io/docs/en/2.3/quickstart/uiauto2-driver/)
     ```bash
    appium driver install uiautomator2
    ```
    - [Device Farm plugin](https://devicefarm.org/setup/#installation-server)
      ```bash
      appium plugin install --source=npm appium-device-farm
      ```
- [Android SDK](https://developer.android.com/studio) (For Android testing)
    - Set up `ANDROID_HOME` environment variable to point to the directory where the Android SDK is installed.
- [Allure Reporter](https://allurereport.org/docs/install/)

### If using Docker:

- [Docker Engine](https://docs.docker.com/engine/install/)

### If not using Docker:

- [Java JDK 17 or higher](https://www.graalvm.org/release-notes/JDK_17/)
    - Set up `JAVA_HOME` environment variable to point to the JDK home directory
- [Gradle](https://docs.gradle.org/current/userguide/installation.html) (No need to install locally.)

## Project Structure

The project is structured as follows:

```
Parallel Automation
    ├── README.md                           # README file
    ├── LICENSE                             # License file
    ├── .env                                # Environment variables (make your own locally)
    ├── .env.example                        # Environment variables template
    ├── build.gradle                        # Build script for this Gradle project
    ├── build
    │   ├── allure-results/                 # Allure report
    │   └── cucumber.json                   # Cucumber JSON file
    │
    └── src
        └── test
            ├── java
            │   │
            │   ├── page_objects
            │   │   ├── BasePage.java       # Abstract class containing common page methods
            │   │   ├── pages/              # Contains page objects
            │   │   └── fragments/          # Contains page objects for smaller elements like widgets, components, etc.
            │   │
            │   ├── step_definitions/       # Contains Cucumber step definitions
            │   │
            │   └── utils
            │       ├── Constants.java      # List of fixed constants
            │       ├── Helpers.java        # List of helper methods
            │       ├── drivers/            # Contains Appium Drivers
            │       ├── hooks/              # Contains Cucumber Hooks
            │       └── runners/            # Contains Cucumber Test Runners
            │
            └── resources/
                ├── allure.properties       # Allure configs
                ├── .test_data              # Test data (make your own locally)
                ├── .test_data.example      # Test data template
                └── features/               # Contains Cucumber feature files
```

## Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```
2. **Wait for gradle to install its dependencies.**
3. **Environment and Test Data variables setup
    - There are 2 files named `.env.example` and `.test_data.example` (located in `src/test/resources/`)
    - Base both of your `.env` and `.test_data` files from here.
4. **Appium setup**:
    - Run Appium server with the proper plugins and flags as follows:
      ```bash
      appium server -pa /wd/hub/ --use-plugins=device-farm --plugin-device-farm-platform=android
      ```

### Docker setup (if you're running using Docker)

1. Turn on Docker Engine.
2. Open terminal, go to the root of your project
3. Build the docker image from the DockerFile by running:
    ```bash
    docker build -t <name_of_your_image> .
    ```
4. After the image is built, run:
    ```bash
    docker run -it --rm <name_of_your_image>
    ```
   This will open an interactive terminal inside your Docker container to run your tests from.

## Running Tests

To run the test on 1 parallel thread, run:

```bash
./gradlew runTest
```

To run the test on multiple parallel threads, run:

```bash
./gradlew runTest -Dcourgette.threads="<NUMBER_OF_THREADS>"
```

You can also set the number of threads in `src/test/java/utils/runners/CourgetteRunner.java`.

## Reporting

Test reports are automatically generated using Cucumber's built-in reporting. After test execution, you can find the
reports in the `build` directory. Allure report and `cucumber.json` file are stored here.

## License

Distributed under the MIT License. See LICENSE for more information.

---

© Bryan Ramaputra Purnama (2024). All rights reserved.
