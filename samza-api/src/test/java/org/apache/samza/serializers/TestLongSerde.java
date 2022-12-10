/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.samza.serializers;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class TestLongSerde {
  @Test
  public void testLongSerde() {
    LongSerde serde = new LongSerde();
    assertNull(serde.toBytes(null));
    assertNull(serde.fromBytes(null));

    Long fooBar = 1234123412341234L;
    byte[] fooBarBytes = serde.toBytes(fooBar);
    assertArrayEquals(new byte[]{0, 4, 98, 109, -65, -102, 1, -14}, fooBarBytes);
    assertEquals(fooBar, serde.fromBytes(fooBarBytes));
  }
}
