/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.admin.cluster.snapshots.status;

import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.test.AbstractXContentTestCase;

import java.io.IOException;

public class SnapshotStatsTests extends AbstractXContentTestCase<SnapshotStats> {

    @Override
    protected SnapshotStats createTestInstance() {
        long startTime = randomNonNegativeLong();
        long time = randomLongBetween(0, Long.MAX_VALUE - startTime);
        int incrementalFileCount = randomIntBetween(0, Integer.MAX_VALUE);
        int totalFileCount = randomIntBetween(0, Integer.MAX_VALUE);
        int processedFileCount = randomIntBetween(0, Integer.MAX_VALUE);
        long incrementalSize = ((long)randomIntBetween(0, Integer.MAX_VALUE)) * 2;
        long totalSize = ((long)randomIntBetween(0, Integer.MAX_VALUE)) * 2;
        long processedSize = ((long)randomIntBetween(0, Integer.MAX_VALUE)) * 2;
        return new SnapshotStats(startTime, time, incrementalFileCount, totalFileCount,
            processedFileCount, incrementalSize, totalSize, processedSize);
    }

    @Override
    protected SnapshotStats doParseInstance(XContentParser parser) throws IOException {
        return SnapshotStats.fromXContent(parser);
    }

    @Override
    protected boolean supportsUnknownFields() {
        return true;
    }
}
