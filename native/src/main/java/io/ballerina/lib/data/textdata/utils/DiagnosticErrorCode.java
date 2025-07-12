/*
 * Copyright (c) 2025, WSO2 LLC. (https://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.lib.data.textdata.utils;

/**
 * Diagnostic error codes for text data module.
 *
 * @since 0.1.0
 */
public enum DiagnosticErrorCode {
    INVALID_VALUE_FOR_ARRAY_TYPE("invalid.value.for.array.type"),
    INVALID_FIELD_IN_TEXT("invalid.field.in.text"),
    INVALID_CUSTOM_HEADER_LENGTH("invalid.custom.header.length"),
    NO_CUSTOM_HEADER_PROVIDED("no.custom.header.provided"),
    DUPLICATE_FIELD("duplicate.field"),
    INVALID_CAST("invalid.cast"),
    PARSING_ERROR("parsing.error"),
    TRANSFORMATION_ERROR("transformation.error"),
    UNSUPPORTED_TYPE("unsupported.type"),
    INVALID_CONFIGURATION("invalid.configuration");

    private final String messageKey;

    DiagnosticErrorCode(String messageKey) {
        this.messageKey = messageKey;
    }

    public String messageKey() {
        return messageKey;
    }
}
