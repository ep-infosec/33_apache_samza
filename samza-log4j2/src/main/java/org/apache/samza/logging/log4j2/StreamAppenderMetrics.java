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
package org.apache.samza.logging.log4j2;

import org.apache.samza.metrics.Counter;
import org.apache.samza.metrics.Gauge;
import org.apache.samza.metrics.MetricsBase;
import org.apache.samza.metrics.MetricsRegistry;


public class StreamAppenderMetrics extends MetricsBase {
  /** The percentage of the log queue capacity that is currently filled with messages from 0 to 100. */
  public final Gauge<Integer> bufferFillPct;

  /** The number of log messages dropped e.g. because of buffer overflow. Does not include recursive calls. */
  public final Counter logMessagesDropped;

  /** The number of log messages cannot be sent out due to errors e.g. serialization errors, system producer send errors. */
  public final Counter logMessagesErrors;

  /** The size of log messages sent out to SystemProducer. */
  public final Counter logMessagesBytesSent;

  /** The number of log messages sent out to SystemProducer. */
  public final Counter logMessagesCountSent;

  public StreamAppenderMetrics(String prefix, MetricsRegistry registry) {
    super(prefix + "-", registry);
    bufferFillPct = newGauge("buffer-fill-percent", 0);
    logMessagesDropped = newCounter("log-messages-dropped");
    logMessagesErrors = newCounter("log-messages-errors");
    logMessagesBytesSent = newCounter("log-messages-bytes-sent");
    logMessagesCountSent = newCounter("log-messages-count-sent");
  }
}
