package com.dx.test;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/23
 */
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**

 * 创建word文档 步骤:

 * 1,建立文档

 * 2,创建一个书写器

 * 3,打开文档

 * 4,向文档中写入数据

 * 5,关闭文档

 */

public class WordDemo {

    public WordDemo() {

    }

    /**

     * @param args

     */

    public static void main(String[] args) {

        // 创建word文档,并设置纸张的大小

        Document document = new Document(PageSize.A4);

        try {

            RtfWriter2.getInstance(document,

                    new FileOutputStream("E:/word5.doc"));

            document.open();

            //设置合同头

            Paragraph ph = new Paragraph();

            Font f = new Font();

            Paragraph p = new Paragraph("数据库表设计文档", new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)) );

            p.setAlignment(1);

            document.add(p);

            ph.setFont(f);

            // 设置中文字体

            // BaseFont bfFont =    BaseFont.createFont("STSongStd-Light",  "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);

            // Font chinaFont = new Font();

            /*

             * 创建有三列的表格

             */

            for(int i=0;i<5;i++){

                Table table = new Table(6);

                document.add(new Paragraph(""));

                table.setBorderWidth(1);

                // table.setBorderColor(Color.BLACK);

                table.setPadding(0);

                table.setSpacing(0);

                /*

                 * 添加表头的元素

                 */

                Color chade = new Color(176, 196, 222);

                Cell cell = new Cell("序号");//单元格

                cell.setBackgroundColor(chade);

                cell.setHeader(true);

                //        cell.setColspan(1);//设置表格为三列

                //        cell.setRowspan(1);//设置表格为三行

                table.addCell(cell);

                cell = new Cell("字段名");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("类型");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("是否为空");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("主键");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                cell = new Cell("字段说明");//单元格

                cell.setBackgroundColor(chade);

                table.addCell(cell);

                table.endHeaders();// 表头结束

                // 表格的主体

                table.addCell("1,1");

                table.addCell("1,2");

                table.addCell("1,3");

                table.addCell("1,4");

                table.addCell("1,5");

                table.addCell("1,6");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                table.addCell("你好啊");

                document.add(new Paragraph("表一"));

                document.add(table);

            }

            document.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (DocumentException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
