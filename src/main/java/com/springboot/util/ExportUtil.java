package com.springboot.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class ExportUtil {
	// ���ñ�ͷ�ĵ�Ԫ����ʽ
    public static CellStyle getHeadStyle(SXSSFWorkbook wb) {
        // ������Ԫ����ʽ
        CellStyle cellStyle = wb.createCellStyle();
        // ���õ�Ԫ��ı�����ɫΪ����ɫ
        cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        // ��������������ʽ
        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        // ���õ�Ԫ����ж���
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // ���õ�Ԫ��ֱ���ж���
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // ������Ԫ��������ʾ����ʱ�Զ�����
        cellStyle.setWrapText(true);
        // ���õ�Ԫ��������ʽ
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// ��������Ӵ�
        font.setFontName("����");// �����������ʽ
        font.setFontHeight(14);// ��������Ĵ�С
        cellStyle.setFont(font);// ��������䵽�����ȥ

        // ���õ�Ԫ��߿�Ϊϸ�������������ң�
//        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);

        return cellStyle;
    }
    
    // ���ñ���ĵ�Ԫ����ʽ
    public static CellStyle getBodyStyle(SXSSFWorkbook wb) {
        // ������Ԫ����ʽ
        CellStyle cellStyle = wb.createCellStyle();
        // ���õ�Ԫ����ж���
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // ���õ�Ԫ����ж���
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // ������Ԫ�����ݲ���ʾ�Զ�����
        cellStyle.setWrapText(true);
        // ���õ�Ԫ��������ʽ
        XSSFFont font = (XSSFFont) wb.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// ��������Ӵ�
        font.setFontName("����");// ��������
        font.setFontHeight(12);// ��������Ĵ�С
        cellStyle.setFont(font);// ��������ӵ������ȥ

        // ���õ�Ԫ��߿�Ϊϸ����
//        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);

        return cellStyle;
    }
}
