/*
 * Copyright Terracotta, Inc.
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

package org.ehcache.spi.loaderwriter;

import org.ehcache.spi.service.ServiceConfiguration;

/**
 * WriteBehindConfiguration
 */
public interface WriteBehindConfiguration extends ServiceConfiguration<WriteBehindDecoratorLoaderWriterProvider> {
  /**
   * The minimum number of seconds to wait before writing behind.
   *
   * Lower than or equal to {@see getMaxWriteDelay}.
   *
   * @return Retrieves the minimum number of seconds to wait before writing behind
   */
  int getMinWriteDelay();

  /**
   * The maximum number of seconds to wait before writing behind.
   *
   * Greater than or equal to {@see getMinWriteDelay}
   *
   * @return Retrieves the maximum number of seconds to wait before writing behind
   */
  int getMaxWriteDelay();

  /**
   * Whether write operations can be coalesced.
   *
   * @return Retrieves the write coalescing behavior is enabled or not
   */
  boolean isWriteCoalescing();

  /**
   * The recommended size of a batch of operations.
   *
   * Only positive values are legal. A value of 1 indicates that no batching should happen.
   *
   * Real batch size will be influenced by arrival frequency of operations and max write delay.
   *
   * @return Retrieves the size of the batch operation.
   */
  int getWriteBatchSize();

  /**
   * A number of bucket/thread pairs configured for this cache's write behind.
   *
   * @return Retrieves the amount of bucket/thread pairs configured for this cache's write behind
   */
  int getWriteBehindConcurrency();

  /**
   * The maximum number of operations allowed on the write behind queue.
   *
   * Only positive values are legal.
   *
   * @return Retrieves the maximum amount of operations allowed on the write behind queue
   */
  int getWriteBehindMaxQueueSize();
}
