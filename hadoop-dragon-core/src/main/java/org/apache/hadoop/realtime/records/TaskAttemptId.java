/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.realtime.records;

import com.google.common.base.Splitter;
import org.apache.hadoop.realtime.records.impl.pb.JobIdPBImpl;
import org.apache.hadoop.realtime.records.impl.pb.TaskAttemptIdPBImpl;
import org.apache.hadoop.realtime.records.impl.pb.TaskIdPBImpl;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.impl.pb.ApplicationIdPBImpl;
import org.apache.hadoop.yarn.util.BuilderUtils;
import org.apache.hadoop.yarn.util.Records;

import java.util.Iterator;

/**
 * <p>
 * <code>TaskAttemptId</code> represents the unique identifier for a task
 * attempt. Each task attempt is one particular instance of a Map or Reduce Task
 * identified by its TaskId.
 * </p>
 * 
 * <p>
 * TaskAttemptId consists of 2 parts. First part is the <code>TaskId</code>,
 * that this <code>TaskAttemptId</code> belongs to. Second part is the task
 * attempt number.
 * </p>
 */
public abstract class TaskAttemptId implements Comparable<TaskAttemptId> {
  /**
   * @return the associated TaskId.
   */
  public abstract TaskId getTaskId();

  /**
   * @return the attempt id.
   */
  public abstract int getId();

  public abstract void setTaskId(TaskId taskId);

  public abstract void setId(int id);

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + getId();
    result =
        prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TaskAttemptId other = (TaskAttemptId) obj;
    if (getId() != other.getId())
      return false;
    if (!getTaskId().equals(other.getTaskId()))
      return false;
    return true;
  }

  @Override
  public int compareTo(TaskAttemptId other) {
    int taskIdComp = this.getTaskId().compareTo(other.getTaskId());
    if (taskIdComp == 0) {
      return this.getId() - other.getId();
    } else {
      return taskIdComp;
    }
  }
}