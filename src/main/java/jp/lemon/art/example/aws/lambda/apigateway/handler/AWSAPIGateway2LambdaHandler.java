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
package jp.lemon.art.example.aws.lambda.apigateway.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import jp.lemon.art.example.aws.lambda.apigateway.main.AWSAPIGateway2LambdaMain;

/**
 * AWS Lambda Handle.<br>
 * AWS APIGateway example
 * 
 * @author seita
 */
public class AWSAPIGateway2LambdaHandler
    implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
  /**
   * AWS Lambda Handle Request.
   *
   * @param request APIGatewayProxyRequestEvent
   * @param context context
   * @return APIGatewayProxyResponseEvent
   */
  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request,
      Context context) {

    // メインロジック実行
    APIGatewayProxyResponseEvent respons = new AWSAPIGateway2LambdaMain()
        .execute(request.getQueryStringParameters(), request.getPathParameters());

    return respons;
  }
}
