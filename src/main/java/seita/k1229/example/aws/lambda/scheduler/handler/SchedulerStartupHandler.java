package seita.k1229.example.aws.lambda.scheduler.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import seita.k1229.example.aws.lambda.scheduler.main.SchedulerStartupMain;

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
