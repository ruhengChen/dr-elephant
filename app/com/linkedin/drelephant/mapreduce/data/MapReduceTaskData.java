/*
 * Copyright 2015 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.linkedin.drelephant.mapreduce.data;


/**
 * This class manages the MapReduce Tasks
 */
public class MapReduceTaskData {
  private MapReduceCounterData _counterHolder;
  private long _totalTimeMs = 0;
  private long _shuffleTimeMs = 0;
  private long _sortTimeMs = 0;
  private boolean _timed = false;

  public MapReduceTaskData(MapReduceCounterData counterHolder, long[] time) {
    this._counterHolder = counterHolder;
    this._totalTimeMs = time[0];
    this._shuffleTimeMs = time[1];
    this._sortTimeMs = time[2];
    this._timed = true;
  }

  public MapReduceTaskData(MapReduceCounterData counterHolder) {
    this._counterHolder = counterHolder;
  }

  public MapReduceCounterData getCounters() {
    return _counterHolder;
  }

  public long getTotalRunTimeMs() {
    return _totalTimeMs;
  }

  public long getCodeExecutionTimeMs() {
    return _totalTimeMs - _shuffleTimeMs - _sortTimeMs;
  }

  public long getShuffleTimeMs() {
    return _shuffleTimeMs;
  }

  public long getSortTimeMs() {
    return _sortTimeMs;
  }

  public boolean timed() {
    return _timed;
  }
}