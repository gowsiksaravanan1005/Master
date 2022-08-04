package Reusables;

import coreframework.ReadProperties;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExcelData {
    public static Properties prop;
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    protected static ReadProperties driver;
    Methods methods = new Methods();

    public ExcelData() throws IOException {
    }
    //static File resultFile = new File();

        public static Map<String,  Map<String, String>> setMapData() throws IOException {

            String path = "Samplesheet.xlsx";
            FileInputStream fis = new FileInputStream(path);

            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0);

            int lastRow = sheet.getLastRowNum();

            Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();

            Map<String, String> dataMap = new HashMap<String, String>();

            //Looping over entire row
            for(int i=0; i<=lastRow; i++){

                Row row = sheet.getRow(i);

                //1st Cell as Value
                Cell valueCell = row.getCell(1);
                //0th Cell as Key
                Cell keyCell = row.getCell(0);

                String value = valueCell.getStringCellValue().trim();
                String key = keyCell.getStringCellValue().trim();

                //Putting key & value in dataMap
                dataMap.put(key, value);

                //Putting dataMap to excelFileMap
                excelFileMap.put("ICICI", dataMap);
            }

            //Returning excelFileMap
            return excelFileMap;

        }

        //Method to retrieve value
        public static String getMapData(String key) throws IOException{

            Map<String, String> m = setMapData().get("ICICI");
            String value = m.get(key);

            return value;

        }


    public String[][] readFromExcel(String sheetName) throws IOException {
        FileInputStream myFile = new FileInputStream("Samplesheet.xlsx");
//        FileInputStream fis = new FileInputStream(resultFile);
        XSSFWorkbook wb = new XSSFWorkbook(myFile);
        XSSFSheet sh = wb.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();

        System.out.println(sh.getPhysicalNumberOfRows());
        System.out.println(sh.getRow(0).getPhysicalNumberOfCells());
        int RowNum = sh.getPhysicalNumberOfRows();
        int ColNum = sh.getRow(0).getPhysicalNumberOfCells();

        String[][] xlData = new String[RowNum - 1][ColNum];
        Map<String, Integer> numbers = new HashMap<>();
        for (int i = 0; i < RowNum - 1; i++) {
            XSSFRow row = sh.getRow(i + 1);
            for (int j = 0; j < ColNum; j++) {
                if (row == null) {
                    xlData[i][j] = "";
                    numbers.put("Amount", Integer.valueOf(xlData[i][j]));
                } else {
                    XSSFCell cell = row.getCell(j);
                    if (cell == null) {
                        xlData[i][j] = "";
                        numbers.put("Amount", Integer.valueOf(xlData[i][j]));
                    } else {
                        String value = formatter.formatCellValue(cell);
                        xlData[i][j] = value.trim();
                    }
                }
            }
        }
        return xlData;
    }

    public void readExcel(String tcName, String sheetName) throws FileNotFoundException {

        int flag = 0;
        //String dataFile= ExcelData.class.getClassLoader().getResource(prop.getProperty("Samplesheet.xlsx")).getFile();
        FileInputStream myFile = new FileInputStream("ExcelSheet/Samplesheet.xlsx");
        DataFormatter formatter = new DataFormatter();
        XSSFWorkbook wb;
        try {
            wb = new XSSFWorkbook(myFile);
            XSSFSheet ws = wb.getSheet(sheetName);
            int rowCount = ws.getLastRowNum();
            int rowNum = 0;
            String cellValue = "";
            for (rowNum = 0; rowNum <= rowCount; rowNum++) {
                XSSFRow rowValue = ws.getRow(rowNum);
                if (rowValue != null) {
                    XSSFCell value = ws.getRow(rowNum).getCell(0);
                    String colValue = value.getStringCellValue();
                    if (colValue.equalsIgnoreCase(tcName)) {
                        flag = 1;
                        for (int cellIndex = 0; cellIndex <= rowValue.getLastCellNum(); cellIndex++) {
                            Cell cell = rowValue.getCell(cellIndex);
                            if (cell != null) {
                                switch (cell.getCellTypeEnum()) {
                                    case BOOLEAN:
                                        cellValue = cell.getBooleanCellValue() + "";
                                        dataMap.put(ws.getRow(0).getCell(cellIndex).getStringCellValue(), cellValue);
                                        break;
                                    case NUMERIC:
                                        cellValue = formatter.formatCellValue(cell);
                                        dataMap.put(ws.getRow(0).getCell(cellIndex).getStringCellValue(), cellValue);
                                        break;
                                    case STRING:
                                        cellValue = cell.getStringCellValue() + "";
                                        dataMap.put(ws.getRow(0).getCell(cellIndex).getStringCellValue(), cellValue);
                                        break;
                                    case BLANK:
                                        cellValue = "";
                                        dataMap.put(ws.getRow(0).getCell(cellIndex).getStringCellValue(), cellValue);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                    if (flag == 1)
                        break;
                }
            }
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getData() throws IOException {
    File file =    new File("Samplesheet.xlsx");

    //Create an object of FileInputStream class to read excel file
    FileInputStream inputStream = new FileInputStream(file);

    //creating workbook instance that refers to .xls file
    XSSFWorkbook wb=new XSSFWorkbook(inputStream);

    //creating a Sheet object
    XSSFSheet sheet=wb.getSheet("ICICI");

    //get all rows in the sheet
    int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        int ColNum = sheet.getRow(0).getPhysicalNumberOfCells();
    //iterate over all the row to print the data present in each cell.
        for(int i=0;i<=ColNum;i++){

        //get cell count in a row
        int cellcount=sheet.getRow(i).getLastCellNum();

        //iterate over each cell to print its value
        System.out.println("Row"+ i+" data is :");

        for(int j=0;j<cellcount;j++){
            System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
        }
        System.out.println();
    }}
}
