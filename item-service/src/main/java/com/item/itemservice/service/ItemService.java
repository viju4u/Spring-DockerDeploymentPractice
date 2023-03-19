package com.item.itemservice.service;

import com.item.itemservice.dto.ItemRequestDto;
import com.item.itemservice.dto.ItemResponseDto;
import com.item.itemservice.model.Item;
import com.item.itemservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository=itemRepository;
    }

    public void createItem(ItemRequestDto itemRequestDto) {
        Item item= new Item();
        item.setItemSize(itemRequestDto.getItemSize());
        item.setItemName(itemRequestDto.getItemName());
        itemRepository.save(item);
    }

    public List<ItemResponseDto> getAllItems() {
        return itemRepository.findAll().stream().map(this::mappedToDto).toList();
    }

    public ItemResponseDto getItemById(Long id) {

    }
    private ItemResponseDto mappedToDto(Item item) {
        ItemResponseDto itemResponseDto=new ItemResponseDto();
        itemResponseDto.setId(item.getItemId());
        itemResponseDto.setItemName(item.getItemName());
        itemResponseDto.setItemSize(item.getItemSize());
        return itemResponseDto;
    }
}
