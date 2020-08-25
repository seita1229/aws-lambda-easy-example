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
