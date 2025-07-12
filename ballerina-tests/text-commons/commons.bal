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

# Generates error message for invalid cast operations.
#
# + value - The value that failed to cast
# + targetType - The target type for casting
# + return - The formatted error message
public isolated function generateErrorMessageForInvalidCast(anydata value, string targetType) returns string {
    return string `invalid cast: cannot cast '${value.toString()}' to type '${targetType}'`;
}

# Generates error message for invalid values in array type.
#
# + value - The invalid value
# + index - The index at which the invalid value was found
# + targetType - The expected type
# + return - The formatted error message
public isolated function generateErrorMessageForInvalidValueForArrayType(anydata value, string index, string targetType) returns string {
    return string `invalid value for array type: '${value.toString()}' at index '${index}' cannot be cast to type '${targetType}'`;
}

# Generates error message for missing required fields.
#
# + fieldName - The name of the missing field
# + return - The formatted error message
public isolated function generateErrorMessageForMissingRequiredField(string fieldName) returns string {
    return string `invalid field in text: field '${fieldName}' is required but not found`;
}

# Generates error message for duplicate fields.
#
# + fieldName - The name of the duplicate field
# + return - The formatted error message
public isolated function generateErrorMessageForDuplicateField(string fieldName) returns string {
    return string `duplicate field: field '${fieldName}' is already defined`;
}
