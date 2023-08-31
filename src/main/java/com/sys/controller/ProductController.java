package com.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.model.Product;
import com.sys.service.ProductService;
import com.sys.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    //service
    private ProductService productService;

    public ProductController(){}

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("index")
    public String index(Model model,ProductVO productVO, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        System.out.println("开始查询");
        List<Product> products = productService.query(productVO);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        System.out.println(pageInfo.getList().size());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("productVO",productVO);
        return "product/index";
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "product/add";
    }
    @RequestMapping("/add")
    public String add(ProductVO productVO) {
        productService.add(productVO);
        return "redirect:index";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(int id) {
        productService.delete(id);
        return "redirect:index";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("/toModify")
    public String toModify(Model model,ProductVO productVO) {
        model.addAttribute("product", productService.query(productVO).get(0));
        return "product/modify";
    }
    @RequestMapping("/modify")
    public String modify(ProductVO productVO) {
        productService.modify(productVO);
        return "redirect:index";
    }
}
