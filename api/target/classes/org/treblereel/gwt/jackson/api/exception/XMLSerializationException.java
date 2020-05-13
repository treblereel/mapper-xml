/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.jackson.api.exception;

/**
 * Base exception for serialization process
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class XMLSerializationException extends XMLMappingException {

    /**
     * <p>Constructor for XMLSerializationException.</p>
     */
    public XMLSerializationException() {
    }

    /**
     * <p>Constructor for XMLSerializationException.</p>
     *
     * @param message a {@link String} object.
     */
    public XMLSerializationException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for XMLSerializationException.</p>
     *
     * @param message a {@link String} object.
     * @param cause   a {@link Throwable} object.
     */
    public XMLSerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * <p>Constructor for XMLSerializationException.</p>
     *
     * @param cause a {@link Throwable} object.
     */
    public XMLSerializationException(Throwable cause) {
        super(cause);
    }
}
