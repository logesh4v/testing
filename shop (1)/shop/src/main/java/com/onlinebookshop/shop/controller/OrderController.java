//////package com.onlinebookshop.shop.controller;
//////
//////import java.util.List;
//////
//////import org.springframework.http.HttpStatus;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.stereotype.Controller;
//////import org.springframework.web.bind.annotation.DeleteMapping;
//////import org.springframework.web.bind.annotation.GetMapping;
//////import org.springframework.web.bind.annotation.PathVariable;
//////import org.springframework.web.bind.annotation.PostMapping;
//////import org.springframework.web.bind.annotation.PutMapping;
//////import org.springframework.web.bind.annotation.RequestBody;
//////import org.springframework.web.bind.annotation.RequestMapping;
//////import org.springframework.web.bind.annotation.ResponseBody;
//////import com.onlinebookshop.shop.model.Book;
//////import com.onlinebookshop.shop.model.Order;
//////import com.onlinebookshop.shop.service.BookService;
//////import com.onlinebookshop.shop.service.OrderService;
//////@Controller
//////@RequestMapping("/api")
//////public class OrderController {
//////	private OrderService orderService;
//////	public OrderController(OrderService orderService) {
//////		super();
//////		this.orderService = orderService;
//////	}
//////	@GetMapping("/authors")
//////	@ResponseBody
//////	public List<Order> fetchBooks(){
//////		return orderService.getAllOrders();
//////	}
//////	@GetMapping()
//////	public String showOrders() {
//////		return "redirect:/order.html"; //load books.html ->static folder
//////	}
//////	@GetMapping("/orders/{id}")
//////	@ResponseBody
//////	public Order fetchBookById(@PathVariable int id){
//////		return orderService.getOrderById(id);
//////	}
//////	@PostMapping("/orders")
//////	@ResponseBody
//////	public String addOrder(@RequestBody Order order) {
//////		orderService.addOrder(order);
//////		return "Order added successfully.";
//////	}
//////	 @DeleteMapping("/orders/{id}")
//////	 @ResponseBody
//////	public ResponseEntity<String> deleteOrder(@PathVariable int id) {
//////		try {
//////			int rowsAffected = orderService.deleteById(id);
//////			if(rowsAffected > 0) {
//////				return ResponseEntity.ok("Order deleted sucessfully");
//////		}
//////			else {
//////				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found");
//////			}
//////		}
//////		catch(Exception e) {
//////			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleteing order");
//////		}
//////	}	
//////
//////	 @PutMapping("/orders/{id}")
//////	    @ResponseBody
//////	    public ResponseEntity<String> updateOrder(@PathVariable int id,@RequestBody Order order) {
//////	        try {
//////	        	order.setId(id);
//////	            int rowsAffected = orderService.updateOrder(order);
//////	            if (rowsAffected > 0) {
//////	                return ResponseEntity.ok("order updated successfully.");
//////	            } else {
//////	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order not found.");
//////	            }
//////	        } catch (Exception e) {
//////	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating order.");
//////	        }
//////	    }
//////}
////// 
////package com.onlinebookshop.shop.controller;
////
////import java.util.List;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.DeleteMapping;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.ResponseBody;
////import com.onlinebookshop.shop.model.Order;
////import com.onlinebookshop.shop.service.OrderService;
////
////@Controller
////@RequestMapping("/api/orders")
////public class OrderController {
////    private final OrderService orderService;
////
////    public OrderController(OrderService orderService) {
////        this.orderService = orderService;
////    }
////
////    @GetMapping
////    @ResponseBody
////    public List<Order> fetchOrders(){
////        return orderService.getAllOrders();
////    }
////
////    @GetMapping("/{id}")
////    @ResponseBody
////    public Order fetchOrderById(@PathVariable int id){
////        return orderService.getOrderById(id);
////    }
////
////    @PostMapping
////    @ResponseBody
////    public String addOrder(@RequestBody Order order) {
////        orderService.addOrder(order);
////        return "Order added successfully.";
////    }
////
////    @DeleteMapping("/{id}")
////    @ResponseBody
////    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
////        try {
////            int rowsAffected = orderService.deleteById(id);
////            if(rowsAffected > 0) {
////                return ResponseEntity.ok("Order deleted successfully");
////            } else {
////                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found");
////            }
////        } catch(Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order");
////        }
////    }    
////
////    @PutMapping("/{id}")
////    @ResponseBody
////    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order order) {
////        try {
////            order.setId(id);
////            int rowsAffected = orderService.updateOrder(order);
////            if (rowsAffected > 0) {
////                return ResponseEntity.ok("Order updated successfully.");
////            } else {
////                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
////            }
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating order.");
////        }
////    }
////}
//
//
//package com.onlinebookshop.shop.controller;
// 
//import java.util.List;
// 
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
// 
//import com.onlinebookshop.shop.model.Order;
//import com.onlinebookshop.shop.service.OrderService;
// 
//@RestController
//@CrossOrigin(origins = "http://localhost:3002")
//@RequestMapping("/api/orders")
//public class OrderController {
//    private final OrderService orderService;
// 
//    // Constructor-based dependency injection
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
// 
////     //Redirect to HTML page
////    @GetMapping("/html")
////    public String showOrders() {
////        return "redirect:/orders.html"; // Load orders.html -> static folder
////    }
// 
//    // Get All Orders
//  
//    public ResponseEntity<List<Order>> fetchOrders() {
//        List<Order> orders = orderService.getAllOrders();
//        return ResponseEntity.ok(orders);
//    }
//    
//    
//    // Get Order by Id
//    @GetMapping("/{id}")
//    public ResponseEntity<Order> fetchOrderById(@PathVariable int id) {
//        Order order = orderService.getOrderById(id);
//        if (order != null) {
//            return ResponseEntity.ok(order);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
// 
// 
//    // Add a new order
//    @PostMapping
//    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
//        orderService.addOrder(order);
//        return ResponseEntity.status(HttpStatus.CREATED).body(order);
//    }
// 
//    // Delete an order by Id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
//        try {
//            int rowsAffected = orderService.deleteById(id);
//            if (rowsAffected > 0) {
//                return ResponseEntity.ok("Order deleted successfully");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found.");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order.");
//        }
//    }
// 
//    // Update order detail
//    @PutMapping
//    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
//        try {
//            int rowsAffected = orderService.updateOrder(order);
//            if (rowsAffected > 0) {
//                return ResponseEntity.ok(order);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//}
//




package com.onlinebookshop.shop.controller;
 
import java.util.List;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.service.OrderService;
 
@RestController
@CrossOrigin(origins = "http://localhost:3002")
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
 
    // Constructor-based dependency injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
 
    // Redirect to HTML page
//    @GetMapping("/html")
//    public String showOrders() {
//        return "redirect:/orders.html"; // Load orders.html -> static folder
//    }
 
    // Get All Orders
    @GetMapping
    public ResponseEntity<List<Order>> fetchOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
 
    // Get Order by Id
    @GetMapping("/{id}")
    public ResponseEntity<Order> fetchOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
 
    // Add a new order
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
 
    // Delete an order by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        try {
            int rowsAffected = orderService.deleteById(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Order deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order.");
        }
    }
 
    // Update order details
    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        try {
            int rowsAffected = orderService.updateOrder(order);
            if (rowsAffected > 0) {
                return ResponseEntity.ok(order);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
