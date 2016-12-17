/*
 * Copyright 2016 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file exceptin compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.confluent.connect.storage.format.avro;

import org.apache.kafka.common.config.AbstractConfig;

import io.confluent.connect.avro.AvroData;
import io.confluent.connect.storage.format.Format;
import io.confluent.connect.storage.format.RecordWriterProvider;
import io.confluent.connect.storage.format.SchemaFileReader;
import io.confluent.connect.storage.hive.HiveMetaStore;
import io.confluent.connect.storage.hive.HiveUtil;

public class AvroFormat<T extends AbstractConfig, U extends HiveMetaStore> implements Format<T, AvroData, U> {

  public RecordWriterProvider getRecordWriterProvider() {
    return new AvroRecordWriterProvider();
  }

  public SchemaFileReader getSchemaFileReader(AvroData avroData) {
    return new AvroFileReader(avroData);
  }

  public HiveUtil getHiveUtil(T config, AvroData avroData, U hiveMetaStore) {
    return new AvroHiveUtil(config, avroData, hiveMetaStore);
  }
}