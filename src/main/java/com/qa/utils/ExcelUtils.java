package com.qa.utils;

import com.qa.constants.FrameWorkConstants;
import com.qa.exceptions.FrameworkExceptions;
import com.qa.exceptions.InvalidPathForExcelException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {
    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
//        FileInputStream fis = null;
        List<Map<String, String>> list = null;
        DataFormatter formatter = new DataFormatter();
        try (FileInputStream fis = new FileInputStream(FrameWorkConstants.getExcelpath());) {
            Map<String, String> map = null;
            list = new ArrayList<>();
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);
            int totalRowCount = sheet.getLastRowNum();
            int totalCellCount = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= totalRowCount; i++) {
                map = new HashMap<>();
                for (int j = 0; j < totalCellCount; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            throw new InvalidPathForExcelException("Excel file you are trying to read is not found");
        } catch (IOException e) {
            throw new FrameworkExceptions("some io exception happened while opening excel file");
        }
        return list;
    }
}
