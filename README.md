# Infix2Postfix

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

Infix2Postfix is a Java application that converts expressions from infix notation to postfix notation using a stack-based approach.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [About the Use of this Project](#about-the-use-of-this-project)

## Description

Infix2Postfix is a command-line tool designed to assist in converting arithmetic expressions written in infix notation into postfix notation. This tool can handle basic arithmetic operators and respects operator precedence and parentheses.

## Features

- Converts infix expressions to postfix notation.
- Handles operator precedence and parentheses.
- Detects and reports errors in expressions (e.g., unbalanced parentheses).
- Simple and interactive CLI for user input.

## Requirements

- Java Development Kit (JDK) 8 or higher.
- An operating system compatible with Java.

## Installation

To install Infix2Postfix locally, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/Angcroft/Infix2Postfix.git
    ```

2. Navigate to the project directory:
    ```bash
    cd Infix2Postfix
    ```

3. Compile the source code:
    ```bash
    javac -d bin src/*.java
    ```

4. Run the application:
    ```bash
    java -cp bin CLI
    ```

## Usage

1. Start the application using the command above.
2. Enter an infix expression when prompted, and the tool will convert and display it in postfix notation.

### Example

```text
Enter an infix expression: a + b * c
Postfix expression: abc*+
```

## About the Use of this Project

This project is open-source under the MIT License, allowing you to use and modify the code for educational or personal purposes. Contributions and feedback are welcome!