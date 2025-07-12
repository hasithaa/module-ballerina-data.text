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

package io.ballerina.lib.data.textdata.compiler;

/**
 * Constants for TextData's compiler plugin.
 *
 * @since 0.1.0
 */
public final class Constants {
    public static final String PACKAGE_NAME = "data.text";
    public static final String PACKAGE_ORG = "ballerina";
    public static final String PARSE_STRING = "parseString";
    public static final String PARSE_STREAM = "parseStream";
    public static final String PARSE_BYTES = "parseBytes";
    public static final String PARSE_LIST = "parseList";
    public static final String TRANSFORM = "transform";

    static class UserConfigurations {
        private UserConfigurations() {
        }

        static final String OUTPUT_WITH_HEADERS = "outputWithHeaders";
        static final String HEADERS_ORDER = "headerOrder";
        static final String HEADER_ROWS = "headerRows";
        static final String CUSTOM_HEADERS = "customHeaders";
        static final String DELIMITER = "delimiter";
        static final String TEXT_ENCLOSURE = "textEnclosure";
        static final String ENABLE_CONSTRAINT_VALIDATION = "enableConstraintValidation";
        static final String ALLOW_DATA_PROJECTION = "allowDataProjection";
        static final String NIL_AS_OPTIONAL_FIELD = "nilAsOptionalField";
        static final String ABSENT_AS_NILABLE_TYPE = "absentAsNilableType";
        static final String SKIP_LINES = "skipLines";
        static final String LOCALE = "locale";
        static final String COMMENT = "comment";
        static final String NIL_VALUE = "nilValue";
        static final String STRING_CONVERSION = "stringConversion";
    }

    private Constants() {
    }
}
