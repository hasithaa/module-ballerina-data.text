// Copyright (c) 2025, WSO2 LLC. (https://www.wso2.com).
//
// WSO2 LLC. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied. See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/jballerina.java;

# Represents the options for text parsing and transformation operations.
#
# + delimiter - The delimiter to use when parsing text
# + textEnclosure - The character used to enclose text fields
# + headerRows - The number of header rows to skip
# + customHeaders - Custom headers to use for parsing
# + enableConstraintValidation - Whether to enable constraint validation
# + allowDataProjection - Whether to allow data projection
# + nilAsOptionalField - Whether to treat nil as optional field
# + absentAsNilableType - Whether to treat absent as nilable type
# + outputWithHeaders - Whether to output with headers
# + skipLines - Lines to skip during parsing
# + locale - The locale to use for parsing
# + comment - The comment character
# + nilValue - The value to use for nil
# + stringConversion - Whether to perform string conversion
public type ParseOptions record {|
    string delimiter = ",";
    string textEnclosure = "\"";
    int headerRows = 0;
    string[]? customHeaders = ();
    boolean enableConstraintValidation = false;
    boolean allowDataProjection = true;
    boolean nilAsOptionalField = false;
    boolean absentAsNilableType = false;
    boolean outputWithHeaders = false;
    int[]? skipLines = ();
    string locale = "en_US";
    string comment = "#";
    string? nilValue = ();
    boolean stringConversion = false;
|};

# Represents the options for text transformation operations.
#
# + headerOrder - The order of headers in the output
# + outputWithHeaders - Whether to output with headers
# + allowDataProjection - Whether to allow data projection
# + nilAsOptionalField - Whether to treat nil as optional field
# + absentAsNilableType - Whether to treat absent as nilable type
# + enableConstraintValidation - Whether to enable constraint validation
# + skipLines - Lines to skip during transformation
# + locale - The locale to use for transformation
# + nilValue - The value to use for nil
# + stringConversion - Whether to perform string conversion
public type TransformOptions record {|
    string[]? headerOrder = ();
    boolean outputWithHeaders = false;
    boolean allowDataProjection = true;
    boolean nilAsOptionalField = false;
    boolean absentAsNilableType = false;
    boolean enableConstraintValidation = false;
    int[]? skipLines = ();
    string locale = "en_US";
    string? nilValue = ();
    boolean stringConversion = false;
|};

# Represents an error that occurs during text data operations.
public type Error distinct error;

# Parses a text string into a record array or anydata array.
#
# + textString - The text string to parse
# + options - Options for parsing
# + return - The parsed data as a record array or anydata array, or an error
public isolated function parseString(string textString, ParseOptions options = {}) returns anydata[]|Error = @java:Method {
    'class: "io.ballerina.lib.data.textdata.text.TextParser"
} external;

# Parses a stream of text data into a record array or anydata array.
#
# + textStream - The stream of text data to parse
# + options - Options for parsing
# + return - The parsed data as a record array or anydata array, or an error
public isolated function parseStream(stream<byte[], error?> textStream, ParseOptions options = {}) returns anydata[]|Error = @java:Method {
    'class: "io.ballerina.lib.data.textdata.text.TextParser"
} external;

# Parses a byte array containing text data into a record array or anydata array.
#
# + textBytes - The byte array containing text data
# + options - Options for parsing
# + return - The parsed data as a record array or anydata array, or an error
public isolated function parseBytes(byte[] textBytes, ParseOptions options = {}) returns anydata[]|Error = @java:Method {
    'class: "io.ballerina.lib.data.textdata.text.TextParser"
} external;

# Parses a list of string arrays into a record array or anydata array.
#
# + textList - The list of string arrays to parse
# + options - Options for parsing
# + return - The parsed data as a record array or anydata array, or an error
public isolated function parseList(string[][] textList, ParseOptions options = {}) returns anydata[]|Error = @java:Method {
    'class: "io.ballerina.lib.data.textdata.text.TextParser"
} external;

# Transforms record arrays or anydata arrays into a different format.
#
# + sourceData - The source data to transform
# + options - Options for transformation
# + return - The transformed data, or an error
public isolated function transform(anydata[] sourceData, TransformOptions options = {}) returns anydata[]|Error = @java:Method {
    'class: "io.ballerina.lib.data.textdata.text.TextTransformer"
} external;
