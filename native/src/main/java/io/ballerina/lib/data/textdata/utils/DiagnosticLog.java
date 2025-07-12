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

import io.ballerina.runtime.api.creators.ErrorCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BError;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Diagnostic log for text data module.
 *
 * @since 0.1.0
 */
public final class DiagnosticLog {
    private static final String ERROR_PREFIX = "error";
    private static final String TEXT_CONVERSION_ERROR = "Error";
    private static final String UNSUPPORTED_OPERATION_ERROR = "Error";
    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("text_error", Locale.getDefault());

    private DiagnosticLog() {
    }

    public static BError error(DiagnosticErrorCode code, Object... args) {
        String msg = formatMessage(code, args);
        return getTextError(msg);
    }

    private static String formatMessage(DiagnosticErrorCode code, Object[] args) {
        String msgKey = MESSAGES.getString(ERROR_PREFIX + "." + code.messageKey());
        return MessageFormat.format(msgKey, args);
    }

    public static BError getTextError(String message, String errorType) {
        return ErrorCreator.createError(ModuleUtils.getModule(),
                errorType, StringUtils.fromString(message), null, null);
    }

    public static BError getTextError(String message) {
        return getTextError(message, TEXT_CONVERSION_ERROR);
    }
}
