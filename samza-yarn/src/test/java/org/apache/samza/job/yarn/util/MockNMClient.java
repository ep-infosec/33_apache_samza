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
package org.apache.samza.job.yarn.util;

import org.apache.hadoop.yarn.api.records.*;
import org.apache.hadoop.yarn.client.api.NMClient;
import org.apache.hadoop.yarn.exceptions.YarnException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class MockNMClient extends NMClient {
  public MockNMClient(String name) {
    super(name);
  }

  @Override
  public Map<String, ByteBuffer> startContainer(Container container, ContainerLaunchContext containerLaunchContext) throws YarnException, IOException {
    return new HashMap<>();
  }

  @Override
  public void stopContainer(ContainerId containerId, NodeId nodeId) throws YarnException, IOException { }

  @Override
  public ContainerStatus getContainerStatus(ContainerId containerId, NodeId nodeId) throws YarnException, IOException {
    return null;
  }

  @Override
  public void cleanupRunningContainersOnStop(boolean enabled) { }

  @Override
  public void commitLastReInitialization(ContainerId containerId) { }

  @Override
  public void rollbackLastReInitialization(ContainerId containerId) { }

  @Override
  public void restartContainer(ContainerId containerId) { }

  @Override
  public void increaseContainerResource(Container container) { }

  @Override
  public void updateContainerResource(Container container) { }

  @Override
  public void reInitializeContainer(ContainerId containerId, ContainerLaunchContext containerLaunchContext, boolean shouldAutoCommit) { }
}
