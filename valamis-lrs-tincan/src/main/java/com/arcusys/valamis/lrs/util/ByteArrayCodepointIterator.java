package com.arcusys.valamis.lrs.util;

/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  The ASF licenses this file to You
* under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.  For additional information regarding
* copyright in this work, please see the NOTICE file in the top level
* directory of this distribution.
*/

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Iterate over Unicode codepoints decoded from an array of bytes
 */
public class ByteArrayCodepointIterator
        extends CharArrayCodepointIterator {

    public ByteArrayCodepointIterator(byte[] bytes) {
        this(bytes, Charset.defaultCharset());
    }

    public ByteArrayCodepointIterator(byte[] bytes, String charset) {
        this(bytes, Charset.forName(charset));
    }

    public ByteArrayCodepointIterator(byte[] bytes, Charset charset) {
        CharBuffer cb = charset.decode(ByteBuffer.wrap(bytes));
        buffer = cb.array();
        position = cb.position();
        limit = cb.limit();
    }

}