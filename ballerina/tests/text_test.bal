import ballerina/test;
import ballerina/io;

@test:Config
function testParseString() {
    string textData = "line1\nline2\nline3";
    anydata[] result = check parseString(textData);
    test:assertEquals(result.length(), 3);
}

@test:Config
function testParseStringWithOptions() {
    string textData = "name,age\nJohn,30\nJane,25";
    anydata[] result = check parseString(textData, {delimiter: ","});
    test:assertEquals(result.length(), 2);
}

@test:Config
function testParseEmptyString() {
    string textData = "";
    anydata[] result = check parseString(textData);
    test:assertEquals(result.length(), 0);
}

@test:Config
function testParseList() {
    string[][] textList = [["John", "30"], ["Jane", "25"]];
    anydata[] result = check parseList(textList);
    test:assertEquals(result.length(), 2);
}

@test:Config
function testTransform() {
    anydata[] sourceData = [{"name": "John", "age": 30}, {"name": "Jane", "age": 25}];
    anydata[] result = check transform(sourceData);
    test:assertEquals(result.length(), 2);
}
