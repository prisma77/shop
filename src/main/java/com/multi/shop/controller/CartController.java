package com.multi.shop.controller;

import com.multi.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private String sid(HttpSession session) {
        return session.getId();
    }

    // 장바구니 목록
    @GetMapping
    public String list(Model model, HttpSession session) {
        String sessionId = sid(session);
        model.addAttribute("items", cartService.list(sessionId));
        model.addAttribute("total", cartService.totalAmount(sessionId));
        return "cart"; // templates/cart.html
    }

    // 장바구니 추가
    @PostMapping("/add")
    public String add(@RequestParam Long productId,
                      @RequestParam(defaultValue = "1") int qty,
                      HttpSession session) {
        cartService.add(sid(session), productId, qty);
        return "redirect:/cart";
    }

    // 수량 수정
    @PostMapping("/update")
    public String update(@RequestParam Long id,
                         @RequestParam int qty) {
        cartService.updateQty(id, qty);
        return "redirect:/cart";
    }

    // 항목 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        cartService.remove(id);
        return "redirect:/cart";
    }

    // 전체 비우기
    @PostMapping("/clear")
    public String clear(HttpSession session) {
        cartService.clear(sid(session));
        return "redirect:/cart";
    }
}

