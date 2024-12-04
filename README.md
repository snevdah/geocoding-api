# Geolocation Utility

This project is a command-line utility that uses the [OpenWeather Geocoding API](https://openweathermap.org/api/geocoding-api) to retrieve latitude, longitude, and place names based on given inputs (city/state or postal code).

## Description

The `geocoding-api` repository provides a Java-based tool to fetch geolocation details for cities, states, or postal codes. It supports:
- Multiple location inputs.
- Two API endpoints:
    - City/State.
    - Postal code.
- Comprehensive error handling and clear responses.

The utility is designed for developers who need precise geolocation data for integration into their applications. It’s also equipped with integration tests to ensure reliability and correctness.

With its simplicity and flexibility, this project is ideal for beginners learning API usage or experienced developers integrating geolocation data into their solutions.

---

## Features

- Supports input in the form of city and state (`Madison, WI`) or postal code (`12345`).
- Utilizes two API endpoints:
    - **Coordinates by location name** (city/state).
    - **Coordinates by zip/post code** (postal code).
- Handles errors and empty responses gracefully.
- Supports multiple location inputs.

---

## Requirements

- **Java** version 14 or later.
- **Maven** for dependency management.

---

## Installation

1. Check Java version:
   ```bash
   java -version

2. Check Maven version:
   ```bash
   mvn -version
   
## If Java and Maven not installed then run commands (for mac / homebrew)

1. Install jdk:
   ```bash
   brew install openjdk
 
2. Install maven:
   ```bash  
   brew install maven

3. Clone the repository:
   ```bash
   git clone https://github.com/snevdah/geocoding-api.git
   
4. Ensure all dependencies are installed:
   ```bash  
   mvn clean install

## Running in IntelliJ IDEA

1. Run the application by providing one or more locations:
   ```bash  
   mvn exec:java -Dexec.mainClass="GeoLocUtil" -Dexec.args="Madison, WI 12345"

2. Example output:
   ```bash  
   Location: Madison, WI, Latitude: 43.0748, Longitude: -89.3838, Name: Madison
   Location: 12345, Latitude: 42.8142, Longitude: -73.9396, Name: Schenectady, Country: US

## Testing
1. Run tests to ensure the utility works correctly:
   ```bash  
   mvn test

## Project Structure

```bash 
geocoding-api/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── GeoLocUtil.java       # Main utility
│   ├── test/
│       └── java/
│           └── GeoLocTest.java       # Tests
├── pom.xml                           # Maven configuration
└── README.md                         # Project description
```

## API Key
This project uses the following API key to access OpenWeather API:
```bash 
API_KEY = f897a99d971b5eef57be6fafa0d83239
```
If you wish to use your own key:
Replace the API_KEY value in the ***GeolocUtil.java*** file, ***line 12***

## Common Errors
- **"No data found for location"** — The API could not find the specified city/state or postal code.
- **"Error: API returned status code 400"** — Invalid input format (e.g., an empty query).
- **"Error: Unable to fetch data"** — Connection issues or an invalid API key.

## License
This project is available under the MIT License. 

MIT License

Copyright (c) 2024 Sergio Nevdah

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Problems?

> Have you tried clean?

No luck yet?

> Restart your machine. You'd be surprised.

STILL not working?

> Feel free to text me

STILL NOT WORKING AND GETTING ANGRY?

![Napping Kitten](https://i.giphy.com/media/jtd0edYJgAWS3ntcXc/giphy.webp)

Here is a picture of a kitten trying to stay awake to help you stay positive
