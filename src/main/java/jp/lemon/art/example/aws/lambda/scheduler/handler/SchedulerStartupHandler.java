/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package jp.lemon.art.example.aws.lambda.scheduler.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import jp.lemon.art.example.aws.lambda.scheduler.main.SchedulerStartupMain;

/**
 * AWS Lambda Handle.<br>
 * スケジューラー起動<br>
 * Amazon CloudWatch Eventsなど
 * 
 * @author seita
 */
public class SchedulerStartupHandler implements RequestHandler<Object, Object> {
  /**
   * AWS Lambda Handle Request.
   *
   * @param in Input
   * @param context context
   */
  @Override
  public Object handleRequest(Object in, Context context) {

    // メインロジック実行
    new SchedulerStartupMain().execute();

    return new Object();
  }

}
