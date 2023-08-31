package com.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.model.Cart;
import com.sys.model.Customer;
import com.sys.model.Product;
import com.sys.model.User;
import com.sys.service.CartService;
import com.sys.service.CustomerService;
import com.sys.service.ProductService;
import com.sys.service.RecordService;
import com.sys.vo.CartVO;
import com.sys.vo.CustomerVO;
import com.sys.vo.ProductVO;
import com.sys.vo.RecordVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    //service
    private CustomerService customerService;
    //service
    private ProductService productService;
    //
    private CartService cartService;
    //
    private RecordService recordService;

    public CustomerController(){}

    @Autowired
    public CustomerController(CustomerService customerService,ProductService productService,CartService cartService,RecordService recordService) {
        this.customerService = customerService;
        this.productService = productService;
        this.cartService = cartService;
        this.recordService = recordService;
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("index")
    public String index(Model model,CustomerVO customerVO, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        System.out.println("开始查询");
        List<Customer> customers = customerService.query(customerVO);
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        System.out.println(pageInfo.getList().size());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("customerVO",customerVO);
        return "customer/index";
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "customer/add";
    }
    @RequestMapping("/add")
    public String add(CustomerVO customerVO) {
        customerService.add(customerVO);
        return "redirect:index";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(int id) {
        customerService.delete(id);
        return "redirect:index";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("/toModify")
    public String toModify(Model model,CustomerVO customerVO) {
        model.addAttribute("customer", customerService.query(customerVO).get(0));
        return "customer/modify";
    }
    @RequestMapping("/modify")
    public String modify(CustomerVO customerVO, HttpServletRequest request) {
        customerService.modifyPwd(customerVO);
        request.getSession().setAttribute("msg", "修改成功!");
        return "redirect:index";
    }
    
    /**
     * 客户购买
     * @return
     */
    @RequestMapping("home")
    public String home(Model model,ProductVO productVO, @RequestParam(defaultValue = "1") Integer pageNum, Integer product_id,Integer quantity,Integer orginCartId, String direct, HttpServletRequest request,String settlement){
    	//取出人
		User user = (User) request.getSession().getAttribute("user");
		if (settlement != null && "settlement".equals(settlement)) {
			System.out.println("11111111111");
			RecordVO recordVO = new RecordVO();
			recordVO.setUserId(user.getId());
			recordService.add(recordVO);
			CartVO vv = new CartVO();
			vv.setUserId(user.getId());
			vv.setRecordId(recordVO.getId());
			cartService.modify(vv);
			//写入客户的累计消费金额
			double amount = customerService.queryAccumulatedAmount(recordVO.getId());
			CustomerVO customerVO = new CustomerVO();
			customerVO.setUserId(user.getId());
			customerVO.setTotalConsumption(amount);
			customerService.modifyAccumulatedAmount(customerVO);
			
			request.getSession().setAttribute("msg", "结算成功!");
		}
    	if (product_id != null && product_id > 0 && quantity!=null && quantity > 0 && direct!=null && !"".equals(direct)) {
			System.out.println("添加购物车");
			//取出商品
			ProductVO productCondition = new ProductVO();
			productCondition.setId(product_id);
			Product product = productService.query(productCondition).get(0);
			
			CartVO cv = new CartVO();
			cv.setProductId(product_id);
			cv.setUserId(user.getId());
			cv.setQuantity(quantity);
			if (direct.equals("+")) {
				if (product.getQuantity() >= quantity) {
					if(cartService.query(cv).size() > 0) {
						cartService.addCart(cv);
					}else {
						cartService.add(cv);
					}
					ProductVO pv = new ProductVO();
					pv.setId(product_id);
					pv.setQuantity(quantity);
					productService.subNum(pv);
					request.getSession().setAttribute("msg", "成功加入购物车!");
				}else {
					request.getSession().setAttribute("msg", "商品数量不足!");
				}
				
			}else {
				//根据id查询cart
				CartVO cvo = new CartVO();
				cvo.setId(orginCartId);
				Cart ca = cartService.query(cvo).get(0);
				if (ca.getQuantity() >= quantity) {
					CartVO cvt = new CartVO();
					cvt.setProductId(product_id);
					cvt.setUserId(user.getId());
					cvt.setQuantity(quantity);
					if (ca.getQuantity() - quantity == 0) {
						cartService.delete(orginCartId);
					}else {
						cartService.subCart(cvt);
					}
					ProductVO pv = new ProductVO();
					pv.setId(product_id);
					pv.setQuantity(quantity);
					productService.addNum(pv);
					request.getSession().setAttribute("msg", "移除成功!");
				}else {
					request.getSession().setAttribute("msg", "不能移除此数量的购物车商品");
				}
			}
		}
        PageHelper.startPage(pageNum,5);
        System.out.println("开始查询");
        List<Product> products = productService.query(productVO);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        System.out.println(pageInfo.getList().size());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("productVO",productVO);
        //查询购物车
        CartVO cc = new CartVO();
        cc.setUserId(user.getId());
        List<Cart> carts = cartService.query(cc);
        model.addAttribute("carts",carts);
        //总金额
        model.addAttribute("totalAmount", cartService.computeTotalAmount(user.getId()));
        return "shopping/index";
    }
}
