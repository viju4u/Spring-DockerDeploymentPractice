package com.item.itemservice.controller;

import com.item.itemservice.dto.ItemRequestDto;
import com.item.itemservice.dto.ItemResponseDto;
import com.item.itemservice.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService=itemService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creteItem(@RequestBody ItemRequestDto itemRequestDto ) {
        itemService.createItem(itemRequestDto);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponseDto> getAllItems() {
            return itemService.getAllItems();
    }

    // We can use path variable as well as request parameter here we need to understand difference between both
    @GetMapping("/find/by-id")
    public ItemResponseDto getItemById(@RequestParam Long id) {

    }
}
