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

package org.apache.hadoop.realtime.protocol.records.impl.pb;

import org.apache.hadoop.realtime.protocol.records.GetShuffleAddressRequest;
import org.apache.hadoop.yarn.api.records.ProtoBase;
import org.apache.hadoop.yarn.proto.DragonServiceProtos.GetShuffleAddressRequestProto;

public class GetShuffleAddressRequestPBImpl extends
    ProtoBase<GetShuffleAddressRequestProto> implements
    GetShuffleAddressRequest {

  GetShuffleAddressRequestProto proto = GetShuffleAddressRequestProto
      .getDefaultInstance();
  GetShuffleAddressRequestProto.Builder builder = null;
  boolean viaProto = false;

  public GetShuffleAddressRequestPBImpl(GetShuffleAddressRequestProto proto) {
    this.proto = proto;
    viaProto = true;
  }

  public GetShuffleAddressRequestPBImpl() {
    builder = GetShuffleAddressRequestProto.newBuilder();
  }

  @Override
  public GetShuffleAddressRequestProto getProto() {
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

}
