package cn.cmmunity.housing.utils;

import cn.cmmunity.beans.Charge;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2018/1/16.
 */
public class PoiUtils {

    public static ResponseEntity<byte[]> exportEmp2Excel(List<Charge> charges) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("雷风物业缴费账单表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);
            sheet.setColumnWidth(1, 12 * 256);
            sheet.setColumnWidth(2, 10 * 256);
            sheet.setColumnWidth(3, 5 * 256);
            sheet.setColumnWidth(4, 12 * 256);
            sheet.setColumnWidth(5, 20 * 256);
            sheet.setColumnWidth(6, 10 * 256);
            sheet.setColumnWidth(7, 10 * 256);

            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("户主名称");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("房源地址");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("支付状态");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("缴费类型");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("账单生成时间");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("缴费金额");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("所属小区");
            cell6.setCellStyle(headerStyle);
            HSSFCell cell7 = headerRow.createCell(7);
            cell7.setCellValue("缴费时间");
            cell7.setCellStyle(headerStyle);
            //装数据
            for (int i = 0; i < charges.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                Charge charge = charges.get(i);
               row.createCell(0).setCellValue(charge.getUserName());
                row.createCell(1).setCellValue(charge.getAddress());
                if(charge.getPaymentStatus()==0){
                    row.createCell(2).setCellValue("未支付");
                }else{
                    row.createCell(2).setCellValue("已支付");
                }
                row.createCell(3).setCellValue(charge.getPaymentTypeName());
                HSSFCell birthdayCell = row.createCell(4);
                birthdayCell.setCellValue(charge.getGenerationTime());
                birthdayCell.setCellStyle(dateCellStyle);
                row.createCell(5).setCellValue(charge.getMoney());
                row.createCell(6).setCellValue(charge.getHousingName());
                HSSFCell paymentTimeCell = row.createCell(7);
                if(null!=charge.getPaymentTime()&&!"".equals(charge.getPaymentTime())) {
                    paymentTimeCell.setCellValue(charge.getPaymentTime());
                    paymentTimeCell.setCellStyle(dateCellStyle);
                }else{
                    paymentTimeCell.setCellValue("");
                }
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("雷风物业缴费账单表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }


}
