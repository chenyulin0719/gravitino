/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.gravitino.catalog.doris;

import static org.apache.gravitino.connector.PropertyEntry.stringReservedPropertyEntry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import org.apache.gravitino.connector.BasePropertiesMetadata;
import org.apache.gravitino.connector.PropertyEntry;

public class DorisTablePartitionPropertiesMetadata extends BasePropertiesMetadata {
  public static final String NAME = "PartitionName";
  public static final String VALUES_RANGE = "Range";
  public static final String ID = "PartitionId";
  public static final String KEY = "PartitionKey";
  public static final String VISIBLE_VERSION = "VisibleVersion";
  public static final String VISIBLE_VERSION_TIME = "VisibleVersionTime";
  public static final String STATE = "State";
  public static final String DATA_SIZE = "DataSize";
  public static final String IS_IN_MEMORY = "IsInMemory";
  private static final Map<String, PropertyEntry<?>> PROPERTIES_METADATA;

  static {
    List<PropertyEntry<?>> propertyEntries =
        ImmutableList.of(
            stringReservedPropertyEntry(NAME, "name of the partition", false),
            stringReservedPropertyEntry(VALUES_RANGE, "value range of the partition", false),
            stringReservedPropertyEntry(ID, "id of the partition", false),
            stringReservedPropertyEntry(KEY, "partition column of the partition", false),
            stringReservedPropertyEntry(VISIBLE_VERSION, "visible version of the partition", false),
            stringReservedPropertyEntry(
                VISIBLE_VERSION_TIME, "visible version time of the partition", false),
            stringReservedPropertyEntry(STATE, "state of the partition", false),
            stringReservedPropertyEntry(DATA_SIZE, "data size of the partition", false),
            stringReservedPropertyEntry(
                IS_IN_MEMORY, "whether data of the partition is stored in memory", false));

    PROPERTIES_METADATA = Maps.uniqueIndex(propertyEntries, PropertyEntry::getName);
  }

  @Override
  protected Map<String, PropertyEntry<?>> specificPropertyEntries() {
    return PROPERTIES_METADATA;
  }
}