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
 * Constants used in the text data module.
 *
 * @since 0.1.0
 */
public final class Constants {
    public static final class ConfigConstants {
        public static final String DELIMITER = "delimiter";
        public static final String TEXT_ENCLOSURE = "textEnclosure";
        public static final String HEADER_ROWS = "headerRows";
        public static final String CUSTOM_HEADERS = "customHeaders";
        public static final String ENABLE_CONSTRAINT_VALIDATION = "enableConstraintValidation";
        public static final String ALLOW_DATA_PROJECTION = "allowDataProjection";
        public static final String NIL_AS_OPTIONAL = "nilAsOptionalField";
        public static final String ABSENT_AS_NILABLE = "absentAsNilableType";
        public static final String OUTPUT_WITH_HEADERS = "outputWithHeaders";
        public static final String SKIP_LINES = "skipLines";
        public static final String LOCALE = "locale";
        public static final String COMMENT = "comment";
        public static final String NIL_VALUE = "nilValue";
        public static final String STRING_CONVERSION = "stringConversion";
        public static final String HEADER_ORDER = "headerOrder";

        private ConfigConstants() {
        }
    }

    public static final class Values {
        public static final String NULL = "null";
        public static final String EMPTY_STRING = "";
        public static final String DEFAULT_DELIMITER = ",";
        public static final String DEFAULT_TEXT_ENCLOSURE = "\"";
        public static final String DEFAULT_LOCALE = "en_US";
        public static final String DEFAULT_COMMENT = "#";

        private Values() {
        }
    }

    public static final String UNDERSCORE = "_";
    public static final String FIELD = "$field$.";
    public static final String NAME = "Name";

    private Constants() {
    }
}
