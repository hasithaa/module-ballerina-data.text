# Ballerina Text Data Library

The Ballerina Text Data Library is a comprehensive toolkit designed to facilitate the handling and manipulation of text data within Ballerina applications. It streamlines the process of converting text data to native Ballerina data types, enabling developers to work with text content seamlessly and efficiently.

## Features

- **Versatile Text Data Input**: Accept text data as a string, byte array, or a stream and convert it into a subtype of ballerina records or lists.
- **Text to anydata Value transformation**: Transform text data into expected type which is subtype of ballerina record arrays or anydata arrays.
- **Projection Support**: Perform selective conversion of text data subsets into ballerina record array or anydata array values through projection.

## Usage

### Converting text string to a record array

To convert a text string into a record array value, you can use the `parseString` function from the library. The following example demonstrates how to transform a text document into an array of records.

```ballerina
import ballerina/data.text;
import ballerina/io;

type Book record {
    string name;
    string author;
    int year;
};

public function main() returns error? {
    string textString = string `Clean Code,Robert C. Martin,2008
                               The Pragmatic Programmer,Andrew Hunt and David Thomas,1999`;

    Book[] books = check text:parseString(textString);
    foreach var book in books {
        io:println(book);
    }
}
```

### Converting external text document to a record value

For transforming text content from an external source, such as a file or service, into a record value, the `parseStream` function can be used. This is useful when working with large text files or streaming data.

```ballerina
import ballerina/data.text;
import ballerina/io;

type Book record {
    string name;
    string author;
    int year;
};

public function main() returns error? {
    stream<byte[], io:Error?> textStream = check io:fileReadBlocksAsStream("./files/books.txt", 1024);
    Book[] books = check text:parseStream(textStream);
    foreach var book in books {
        io:println(book);
    }
}
```

## Text to record array/anydata array of array representation

The Text Object can be represented as a value of type `record/map array` or `string array of array` in Ballerina, which facilitates a structured and type-safe approach to handling text data.
The conversion of text data to subtype of `record array` or `anydata array of array` representation is a fundamental feature of the library.

```ballerina
import ballerina/data.text;
import ballerina/io;

type Book record {
    string name;
    int year;
};

public function main() returns error? {
    string[][] bookArray = [["Clean Code","2008"],["Clean Architecture","2017"]];
    Book[] bookRecords = [{name: "Clean Code", year: 2008}, {name: "Clean Architecture", year: 2017}];

    // Parse and output a record array from a source of string array of arrays.
    Book[] books = check text:parseList(bookArray, {customHeaders: ["name", "year"]});
    io:println(books);

    // Parse and output a tuple array from a source of string array of arrays.
    [string, int][] books2 = check text:parseList(bookArray, {customHeaders: ["name", "year"]});
    io:println(books2);

    // Transform text records to a string array of arrays.
    [string, int][] books3 = check text:transform(bookRecords);
    io:println(books3);
}
```

### Controlling the text value to record array conversion

The library allows for selective conversion of text into closed record arrays. This is beneficial when the text data contains headers that are not necessary to be transformed into record fields.

```ballerina
import ballerina/data.text;
import ballerina/io;

type Book record {|
    string name;
    string author;
|};

public function main() returns error? {
    record {}[] textContent = [{
        "name": "Clean Code",
        "author": "Robert C. Martin",
        "year": 2008,
        "publisher": "Prentice Hall"
    }, {
        "name": "The Pragmatic Programmer",
        "author": "Andrew Hunt and David Thomas",
        "year": 1999,
        "publisher": "Addison-Wesley"
    }];

    // The text data above contains publisher and year fields which are not 
    // required to be converted into a record field.
    Book[] book = check text:transform(textContent);
    io:println(book);
}
```

## Issues and projects

Issues and Projects tabs are disabled for this repository as this is part of the Ballerina library. To report bugs, request new features, start new discussions, view project boards, etc. please visit Ballerina library [parent repository](https://github.com/ballerina-platform/ballerina-library).

This repository only contains the source code for the package.

## Building from the source

### Set up the prerequisites

1. Download and install Java SE Development Kit (JDK) version 21 (from one of the following locations).
    * [Oracle](https://www.oracle.com/java/technologies/downloads/)
    * [OpenJDK](https://adoptium.net/)

2. Export your GitHub personal access token with the read package permissions as follows.

        export packageUser=<Username>
        export packagePAT=<Personal access token>

### Building the source

Execute the commands below to build from source.

1. To build the library:

        ./gradlew clean build

2. Publish ZIP artifact to the local `.m2` repository:

        ./gradlew clean build publishToMavenLocal

3. Publish the generated artifacts to the local Ballerina central repository:

        ./gradlew clean build -PpublishToLocalCentral=true

4. Publish the generated artifacts to the Ballerina central repository:

        ./gradlew clean build -PpublishToCentral=true

## Contributing to Ballerina

As an open source project, Ballerina welcomes contributions from the community.

For more information, go to the [contribution guidelines](https://github.com/ballerina-platform/ballerina-lang/blob/master/CONTRIBUTING.md).

## Code of conduct

All contributors are encouraged to read the [Ballerina code of conduct](https://ballerina.io/code-of-conduct).

## Useful links

* Chat live with us via our [Discord server](https://discord.gg/ballerinalang).
* Post all technical questions on Stack Overflow with the [#ballerina](https://stackoverflow.com/questions/tagged/ballerina) tag.
