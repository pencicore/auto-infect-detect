package com.infect.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static cn.hutool.poi.excel.cell.CellUtil.getCellValue;

public class ExcelUtil {    // 读取Excel文件
    public static List<List<String>> readExcelFile(MultipartFile file, Integer sheetIndex) throws Exception {
        List<List<String>> data = new ArrayList<>();

        // 获取文件输入流
        try (InputStream inputStream = file.getInputStream()) {
            // 创建Workbook对象
            Workbook workbook = new XSSFWorkbook(inputStream);

            // 选择第一个sheet
            Sheet sheet = workbook.getSheetAt(sheetIndex);

            // 遍历每一行
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>();

                // 遍历每一单元格
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowData.add(getCellValue(cell).toString());
                }

                data.add(rowData);
            }
        }
        return data;
    }
}
