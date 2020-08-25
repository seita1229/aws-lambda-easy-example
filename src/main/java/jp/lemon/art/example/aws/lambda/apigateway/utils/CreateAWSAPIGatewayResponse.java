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
package jp.lemon.art.example.aws.lambda.apigateway.utils;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

/**
 * APIGatewayProxyResponseEventを作成するユーティリティ
 * 
 * @author seita
 */
public class CreateAWSAPIGatewayResponse {
  private CreateAWSAPIGatewayResponse() {}

  private static final Gson gson = new Gson();

  /**
   * APIGatewayProxyResponseEvent を作成する。
   * 
   * @param <T> レスポンスボディクラス
   * @param statusCode HTTPステータスコード
   * @param body レスポンスボディ
   * @param bodyType レスポンスボディクラス
   * @return APIGatewayProxyResponseEvent
   */
  public static <T> APIGatewayProxyResponseEvent createResponse(int statusCode, Object body,
      Class<T> bodyType) {
    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
    response.setStatusCode(statusCode);
    response.setBody(gson.toJson(body, bodyType));
    return response;
  }

}
