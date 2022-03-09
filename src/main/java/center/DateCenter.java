package center;

import lombok.extern.log4j.Log4j2;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/***
 *  用例数据读取工具类
 */
@Log4j2
public class DateCenter {

    /**
     * @param path 基于testData路径下的path,例如 testData/login/login.xls 取 login/login.xls
     * @return Object
     */
    public Object[][] testData(String path) {
        ArrayList<String> arrkey = new ArrayList<String>();
        Workbook workbook = getWorkbook(path);
        Sheet sheet = workbook.getSheetAt(0);
        // 获取总行数
        int rowTotalNum = sheet.getLastRowNum() + 1;
        // 总列数
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        HashMap<String, String>[][] map = new HashMap[rowTotalNum - 1][1];
        // 对数组中所有元素hashmap进行初始化
        if (rowTotalNum > 1) {
            for (int i = 0; i < rowTotalNum - 1; i++) {
                map[i][0] = new HashMap();
            }
        } else {
            log.error("测试的Excel:{}中没有数据", path);
        }
        // 获得首行的列名，作为hashmap的key值
        for (int c = 0; c < columns; c++) {
            String cellvalue = CellUnit.getCellValue(sheet, 0, c);
            arrkey.add(cellvalue);
        }
        // 遍历所有的单元格的值添加到hashmap中
        for (int r = 1; r < rowTotalNum; r++) {
            for (int c = 0; c < columns; c++) {
                String cellvalue = CellUnit.getCellValue(sheet, r, c);
                map[r - 1][0].put(arrkey.get(c), cellvalue);
            }
        }
        return map;

    }


    /**
     * 创建 workbook
     *
     * @param path excel相对路径
     * @return Workbook 对象
     * @throws IOException
     */
    public static Workbook getWorkbook(String path) {
        Workbook wb = null;
        String filepath = Workbook.class.getClassLoader().getResource("").getPath();
        log.debug("ClassLoader:"+filepath);
        String filepath2 = Workbook.class.getResource("").getPath();
        log.debug("class:"+filepath2);
        InputStream stream = null;

        stream = Workbook.class.getResourceAsStream("/"+path);
        try {
            if (path.endsWith(".xls")) {
                wb = new HSSFWorkbook(stream);
            } else if (path.endsWith(".xlsx") || path.endsWith(".xlsm")) {
                wb = new XSSFWorkbook(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    /**
     * 单元格处理内部类
     */
    private static class CellUnit {

        /**
         * 通过sheet 行号和列返回值
         *
         * @param sheet   sheet name
         * @param rowNum  行号
         * @param cellNum 列号
         * @return
         */
        public static String getCellValue(Sheet sheet, int rowNum, int cellNum) {
            String value;
            Cell cell = sheet.getRow(rowNum).getCell(cellNum);
            if (cell != null) {
                // 有值时，转换成字符串
                value = CellUnit.getCellValue2(cell);
            } else {
                // 当单元格没有值时，设为空串
                value = "";
            }
            return value;
        }


        /**
         * 把不同类型的单元格转换成字符串，并返回
         *
         * @param cell cell
         * @return 单个单元格值
         */
        public static String getCellValue2(Cell cell) {
            String value = "";
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    value = String.valueOf(cell.getRichStringCellValue());
                    return value;
                case NUMERIC:
                    // 处理数值类型自动转成科学计数法问题
                    DecimalFormat df = new DecimalFormat("0");
                    value = String.valueOf(df.format(cell.getNumericCellValue()));
                    return value;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    return value;

                case FORMULA:
                    value = String.valueOf(cell.getCellFormula());
                    return value;

                case ERROR:
                    value = String.valueOf(cell.getErrorCellValue());
                    return value;
                case BLANK:
                    return value;
                default:
                    log.error("单元格异常:{}", cell.toString());
                    return value;
            }
        }

    }
}
