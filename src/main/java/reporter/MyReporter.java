package reporter;

import com.aventstack.extentreports.ExtentTest;

/**
 *  报告上下文引用
 */
public class MyReporter {
    /**
     *  报告上下文ExtentTest引用
     */
    public static ExtentTest report;

    /**
     *  设置当前执行用例的报告详情，用于数据驱动的参数显示
     * @param description
     */
    public static void setDescription(String description){
        com.aventstack.extentreports.model.Test last = report.getModel().getNodeContext().getLast();
        last.setDescription(description);
    }
}
