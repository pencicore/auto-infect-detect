package com.infect.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

import static cn.hutool.poi.excel.cell.CellUtil.getCellValue;

public class ExcelUtil {    // 读取Excel文件

    /**
     * 获取Excel文件中所有数据
     * @param file
     * @param sheetIndex
     * @return
     * @throws Exception
     */
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

    /**
     * 生成Excel表
     *
     * @param response
     * @param fileName
     * @param filePath
     * @param readStartY
     * @param readStartX
     * @param total
     * @param writeStartY
     * @param writeStartX
     * @param listData
     * @return
     */
    public static XSSFWorkbook getExcelFile(HttpServletResponse response, String fileName, String filePath,
                                            Integer readStartY, Integer readStartX, Integer total,
                                            Integer writeStartY, Integer writeStartX,
                                            List<List<Object>> listData){
        //1.根据startX和startY，读取total个元素名，按顺序保存到List集合里(忽略大小写)
        List<String> excelNameList = getExcelNameList(readStartY, readStartX, total, filePath);

        //2.利用反射获取对应字段的数据列表
        Map<String, List<String>> mysqlDataMap;
        try {
            mysqlDataMap = getDataBaseNameValueList(listData);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //3.设置信息，并打开文件
        String fileNameUTF8;
        try {
            fileNameUTF8 = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameUTF8 + "\"");

        try {
            XSSFWorkbook excel;
            InputStream in = new FileInputStream(filePath);
            excel = new XSSFWorkbook(in);
            XSSFSheet sheet = excel.getSheetAt(0);

            //4.通过POI将数据写入到Excel文件中
            int n = listData.size();

            for(int i=0;i<n;i++){
                sheet.createRow(writeStartY+i)
                        .createCell(writeStartX-1)
                        .setCellValue(i+1);
            }

            for(int i=0;i<total;i++){
                int writeX=writeStartX+i;
                int writeY=writeStartY;

                String key = excelNameList.get(i);

                if(!mysqlDataMap.containsKey(key)){
                    continue;
                }

                for (String s:
                        mysqlDataMap.get(key)) {
                    sheet.getRow(writeY).createCell(writeX).setCellValue(s);
                    writeY++;
                }
            }

            //5.关闭资源
            in.close();
            return excel;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 利用反射获取对应字段的数据列表
     * @param list
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, List<String>> getDataBaseNameValueList(List<List<Object>> list) throws IllegalAccessException {
        Map<String, List<String>> resultMap = new HashMap<>();

        //获取所有类的所有变量名，初始化map集合
        for(Object obj:list.get(0)){
            // 获取对象的类
            Class<?> clazz = obj.getClass();

            // 获取所有声明的字段
            Field[] fields = clazz.getDeclaredFields();

            for (Field field: fields) {
                String fieldName = field.getName().toLowerCase();
                //如果字段名重复，返回空，文件生成失败
                if(resultMap.containsKey(fieldName)) {
//                    return null;
                    continue;
                }
                resultMap.put(fieldName, new ArrayList<>());
            }
        }

        //遍历每行
        for(List<Object> resource:list){

            //遍历一行数据的每个对象
            for(Object obj:resource){
                if(obj==null) continue;
                // 获取对象的类
                Class<?> clazz = obj.getClass();
                // 获取所有声明的字段
                Field[] fields = clazz.getDeclaredFields();

                //遍历对象中所有字段
                for (Field field:fields) {
                    //获取该字段对应的值和字段名
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    String valueStr = value!=null?value.toString():"";

                    //如果value为bool类型，将true转为是，false转为否
                    if(value!=null && value.getClass().getName().equals("java.lang.Boolean")){
                        valueStr=(value.toString().equals("true")?"是":"否");
                    }

                    String name = field.getName().toLowerCase();

                    //向map对应位置添加值(如果存在的话)
                    if(resultMap.containsKey(name)){
                        resultMap.get(name).add(valueStr);
                    }
                }
            }
        }

        return resultMap;
    }

    /**
     * 获取excel表中sheet1中的指定位置的字段名
     * @param readStartY
     * @param readStartX
     * @param total
     * @param filePath
     * @return
     */
    public static List<String> getExcelNameList(Integer readStartY, Integer readStartX, Integer total, String filePath) {
        List<String> list = new ArrayList<>();

        // 指定工作表索引
        int sheetNumber = 1;

        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            // 打开文件
            fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);

            // 打开工作表
            Sheet sheet = workbook.getSheetAt(sheetNumber);

            // 获取指定行
            Row row = sheet.getRow(readStartY);
            if (row == null) {
                return null; // 行不存在时，返回null
            }

            Cell cell;
            // 获取字段名列表
            for (int i = 0; i < total; i++) {
                cell = row.getCell(i + readStartX);
                if (cell == null) {
                    list.add(""); // 如果单元格为空，加入空字符串，防止空指针异常
                } else {
                    list.add(cell.getStringCellValue().toLowerCase().trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading Excel file", e);
        } finally {
            // 确保文件流被关闭
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
