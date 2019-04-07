package com.fh.shop.backend.controller.product;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fh.shop.backend.common.DataTableInfo;
import com.fh.shop.backend.common.FileInfo;
import com.fh.shop.backend.controller.BaseController;
import com.fh.shop.backend.po.ImageInfo;
import com.fh.shop.backend.serverResponse.ServerResponse;
import com.fh.shop.backend.util.SystemConstants;
import com.fh.util.FileUtil;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.controller.brand.BrandController;
import com.fh.shop.backend.po.brand.Brand;
import com.fh.shop.backend.po.product.Product;




/**
 * <pre>项目名称：shop_admin_v2
 * 类名称：ProductController
 * 类描述：
 * 创建人：王亚州 2592683566@qq.com
 * 创建时间：2018年12月23日 下午7:28:26
 * 修改人：王亚州 2592683566@qq.com
 * 修改时间：2018年12月23日 下午7:28:26
 * 修改备注：
 * @version </pre>
 */
//<bean id="productController" class="com.fh.shop.backend.web.controller.product"
@RequestMapping("/product")
@Controller
public class ProductController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BrandController.class);

    @Resource(name = "productService")
    private IProductService productService;

    @Resource(name = "brandService")
    private IBrandService brandService;

    @RequestMapping("toAdd")
    public String toAdd(ModelMap map) {
        return "product/addProduct";
    }




    @RequestMapping(value = "uploadFile" , method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse uploadFile(@RequestParam("uploadImgFile") MultipartFile uploadImgFile, HttpServletRequest request){
        //获取项目根目录
        FileInfo fileInfo = createFileInfo(uploadImgFile);

        String realPath = getRootPath(request);

        String filePath = realPath + SystemConstants.PRODUCT_PICTURE_PATH;

        String path = FileUtil.copyFile(fileInfo.getInputStream(), fileInfo.getFileName(), filePath);

        String imgPath = SystemConstants.PRODUCT_PICTURE_PATH + path;

        return ServerResponse.success(imgPath);
    }



    @RequestMapping("add")
    @ResponseBody
    public String add(Product produc) {

        productService.addProduct(produc);

         return "redirect:queryProductPage.jhtml";
    }

    @RequestMapping("deleteProduct")
    @ResponseBody
    public ServerResponse deleteProduct(Integer id) {
        productService.deleteProduct(id);
        return ServerResponse.success();
    }
    @ResponseBody
    @RequestMapping("deleteBatchProduct")
    public ServerResponse deleteBatchProduct(String ids) {
        productService.deleteBatchProduct(ids);
        return ServerResponse.success();
    }


    @RequestMapping("selectProduct")
    public ModelAndView selectProduct(Integer id) {

        Product product = productService.selectProduct(id);

        ModelAndView value = new ModelAndView("product/updateProduct");

        List<Brand> brand = brandService.queryBrand();

        List<ImageInfo> productList = productService.childImage(product);

        value.addObject("brand", brand);

        value.addObject("product", product);

        value.addObject("productList", productList);

        return value;
    }

    @RequestMapping("updateProduct")
    @ResponseBody
    public String updateProduct(Product product, HttpServletRequest request) {

        //获取根目录
        String realPath = getRootPath(request);

        productService.updateProduct(product,realPath);

        return "redirect:queryProductPage.jhtml";
    }

    @ResponseBody
    @RequestMapping("queryProductPage")
    public ServerResponse queryProductPage(Product product, Integer start, Integer length, Integer draw, HttpServletRequest req) {
        //排序信息
        String order = req.getParameter(SystemConstants.ORDER_COLUMN);//排序的列号
        String orderDir = req.getParameter(SystemConstants.ORDER_DIR);//排序的顺序asc or desc
        String beanName = req.getParameter(buildParam(order));//排序的列。注意，我认为页面上的列的名字要和表中列的名字一致，否则，会导致SQL拼接错误
        DataTableInfo dataTableInfo = productService.buildDataTable(product, start, length, draw, orderDir, beanName);
        return ServerResponse.success(dataTableInfo);
    }

    private String buildParam(String order) {
        return "columns[" + order + "][data]";
    }

    @RequestMapping("productExcel")
    public void productExcel(HttpServletResponse response, Product product) {
        List<Product> productList = productService.productExcel(product);
        XSSFWorkbook workbook = bulidWorkbook(productList);
        FileUtil.excelDownload(workbook, response);

    }

    private XSSFWorkbook bulidWorkbook(List<Product> productList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = bulidSheet(workbook);
        buildCell(productList, sheet);
        return workbook;
    }

    private void buildCell(List<Product> productList, XSSFSheet sheet) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < productList.size(); i++) {
            Product productInfo = productList.get(i);
            XSSFRow row = sheet.createRow(i + start);
            XSSFCell productNameCell = row.createCell(end);
            productNameCell.setCellValue(productInfo.getProductName());
            XSSFCell priceCell = row.createCell(end + 1);
            priceCell.setCellValue(productInfo.getProductPrice());
            XSSFCell entryCell = row.createCell(end + 2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            entryCell.setCellValue(simpleDateFormat.format(productInfo.getEntryTime()));
            XSSFCell updateTimeCell = row.createCell(end + 3);
            updateTimeCell.setCellValue(simpleDateFormat.format(productInfo.getUpdateTime()));
        }
    }

    private XSSFSheet bulidSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("产品表");
        String[] title = {"产品名", "产品价格", "录入时间", "修改时间"};
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        return sheet;
    }

    @RequestMapping("excelBrand")
    public void excelBrand(Product product, HttpServletResponse response) {

        List<Brand> brands = brandService.queryBrand();

        Integer brandId = product.getBrand().getId();

        List<Product> list = null;

        XSSFWorkbook wookBook = new XSSFWorkbook();

        if (brandId == -1) {

            for (int i = 0; i < brands.size(); i++) {

                Brand brand = brands.get(i);

                product.setBrand(brand);

                list = productService.productExcel(product);

                XSSFSheet sheet = wookBook.createSheet(brand.getBrandName() + "【" + list.size() + "】");

                makeValue(list, wookBook, sheet);

            }

        } else {

            list = productService.productExcel(product);

            String brandName = list.get(1).getBrand().getBrandName();

            XSSFSheet sheet = wookBook.createSheet(brandName + "【" + list.size() + "】");

            makeValue(list, wookBook, sheet);

        }

        FileUtil.excelDownload(wookBook, response);
    }

    /**
     * 制作数据
     *
     * @param list
     * @param wookBook
     * @param sheet
     */
    private void makeValue(List<Product> list, XSSFWorkbook wookBook, XSSFSheet sheet) {

        buildTitle(sheet, wookBook);

        bulidHead(sheet, wookBook);

        excelValue(list, sheet, wookBook);
    }

    /**
     * 循环导出数据
     *
     * @param list
     * @param sheet
     */
    private void excelValue(List<Product> list, XSSFSheet sheet, XSSFWorkbook workbook) {

        Integer startRow = 8;

        Integer startCell = 7;

        //时间
        XSSFCellStyle styleDate = workbook.createCellStyle();

        styleDate.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        //数据类型
        XSSFCellStyle styleDouble = workbook.createCellStyle();

        styleDouble.setDataFormat(workbook.createDataFormat().getFormat("0.0"));
        //背景色/时间类型
        XSSFCellStyle cellStylecolor = workbook.createCellStyle();

        cellStylecolor.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        cellStylecolor.setFillForegroundColor(HSSFColor.RED.index);

        cellStylecolor.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        for (int j = 0; j < list.size(); j++) {

            Product value = list.get(j);

            XSSFRow sheetRow = sheet.createRow(startRow + j);

            XSSFCell cell = sheetRow.createCell(startCell);

            cell.setCellValue(value.getId());

            XSSFCell cell1 = sheetRow.createCell(startCell + 1);

            cell1.setCellValue(value.getProductName());

            XSSFCell cell2 = sheetRow.createCell(startCell + 2);

            cell2.setCellValue(value.getBrand().getBrandName());

            XSSFCell cell3 = sheetRow.createCell(startCell + 3);

            cell3.setCellValue(value.getProductPrice());

            cell3.setCellStyle(styleDouble);

            XSSFCell cell4 = sheetRow.createCell(startCell + 4);

            cell4.setCellValue(value.getEntryTime());

            cell4.setCellStyle(styleDate);

            XSSFCell cell5 = sheetRow.createCell(startCell + 5);

            cell5.setCellValue(value.getUpdateTime());

            cell5.setCellStyle(styleDate);

            XSSFCellStyle cellStyleTitle = workbook.createCellStyle();

            if (value.getProductPrice() < 75) {

                cellStyleTitle.setFillForegroundColor(HSSFColor.RED.index);//设置背景颜色

                cellStyleTitle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置图案样式

                cell.setCellStyle(cellStyleTitle);

                cell1.setCellStyle(cellStyleTitle);

                cell2.setCellStyle(cellStyleTitle);

                cell3.setCellStyle(cellStyleTitle);

                cell4.setCellStyle(cellStylecolor);

                cell5.setCellStyle(cellStylecolor);

            } else {
                cell4.setCellStyle(styleDate);

                cell5.setCellStyle(styleDate);
            }
        }
    }

    /**
     * 创建表头
     *
     * @param sheet
     * @param workbook
     */
    private void bulidHead(XSSFSheet sheet, XSSFWorkbook workbook) {

        Integer startRow = 7;

        Integer startCell = 7;

        XSSFCellStyle cellStyleTitle = bulidHeadStyle(workbook);

        String[] str = {"产品编号", "产品名称", "产品品牌", "产品价格", "创建时间", "修改时间"};

        XSSFRow titleRow = sheet.createRow(startRow);

        for (int i = 0; i < str.length; i++) {

            XSSFCell title = titleRow.createCell(i + startCell);

            title.setCellValue(str[i]);

            title.setCellStyle(cellStyleTitle);
        }
    }

    /**
     * 创建表头样式
     *
     * @param workbook
     * @return
     */
    private XSSFCellStyle bulidHeadStyle(XSSFWorkbook workbook) {

        //调试样式水平居中和字体加粗
        XSSFCellStyle cellStyleTitle = workbook.createCellStyle();
        //设置水平居中
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER.CENTER);
        // 垂直居中
        cellStyleTitle.setVerticalAlignment(VerticalAlignment.BOTTOM.CENTER);
        //创建字体
        XSSFFont font = workbook.createFont();
        //true是加粗
        font.setBold(true);
        //将字体样式加入到style样式中
        cellStyleTitle.setFont(font);
        return cellStyleTitle;
    }

    /**
     * 创建大标题
     *
     * @param sheet
     * @param workbook
     */
    private void buildTitle(XSSFSheet sheet, XSSFWorkbook workbook) {
        //构建大标题
        XSSFCellStyle cellStyleTitle = buildTitleStyle(workbook);
        //创建一个行
        XSSFRow row = sheet.createRow(4);
        //一个列
        XSSFCell cell = row.createCell(7);
        //给单元格赋值
        cell.setCellValue("商品列表");
        //【合并行列的大标题】
        //合并单元格【四个参数firstRow 开始行 lastRow 结束行 firstCol开始列 lastCol结束列】
        CellRangeAddress rangeaddress = new CellRangeAddress(4, 6, 7, 12);
        // 合并单元格
        sheet.addMergedRegion(rangeaddress);
        //给大标题加样式
        cell.setCellStyle(cellStyleTitle);

    }

    /**
     * 给大标题加样式方法
     *
     * @param workbook
     * @return
     */
    private XSSFCellStyle buildTitleStyle(XSSFWorkbook workbook) {
        //给大标题加样式
        //调试样式水平居中和字体加粗
        XSSFCellStyle cellStyleTitle = workbook.createCellStyle();
        //设置水平居中
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        cellStyleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置背景颜色
        cellStyleTitle.setFillForegroundColor(HSSFColor.BLUE.index);
        //设置图案样式
        cellStyleTitle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        XSSFFont font = workbook.createFont();
        //字体颜色
        font.setColor(XSSFFont.COLOR_RED);
        //字体大小
        font.setFontHeight(30);
        //true是加粗
        font.setBold(true);
        //将字体样式加入到style样式中
        cellStyleTitle.setFont(font);

        return cellStyleTitle;
    }


    @RequestMapping("childImage")
    public String childImage(Product product, ModelMap modelMap) {
        List<ImageInfo> productList = productService.childImage(product);
        modelMap.put("productList", productList);
        return "product/image";
    }

    @RequestMapping("tototo")
    public String tototo() {
        return "product/showProduct";
    }
}
