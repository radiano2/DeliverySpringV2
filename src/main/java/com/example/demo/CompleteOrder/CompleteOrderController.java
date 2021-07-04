package com.example.demo.CompleteOrder;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompleteOrderController {
    private final CompleteOrderRepo completeOrderRepo;

    public CompleteOrderController(CompleteOrderRepo completeOrderRepo) {
        this.completeOrderRepo = completeOrderRepo;
    }

    @GetMapping("/completeorders")
    List<CompleteOrderModel> all() {
        return completeOrderRepo.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/completeorders")
    CompleteOrderModel newCompleteOrder(@RequestBody CompleteOrderModel newCompleteOder) {
        return completeOrderRepo.save(newCompleteOder);
    }

    // Single item

    @GetMapping("/completeorders/{id}")
    CompleteOrderModel one(@PathVariable Long id) {

        return completeOrderRepo.findById(id)
                .orElseThrow(() -> new CompleteOrderNotFoundException(id));
    }

    @PutMapping("/completeorders/{id}")
    CompleteOrderModel replaceCompleteOrder(@RequestBody CompleteOrderModel newCompleteOder, @PathVariable Long id) {

        return completeOrderRepo.findById(id)
                .map(completeOrder -> {
                    completeOrder.setName(newCompleteOder.getName());
                    completeOrder.setSurname(newCompleteOder.getSurname());
                    completeOrder.setPrice(newCompleteOder.getPrice());
                    completeOrder.setDescription(newCompleteOder.getDescription());
                    return completeOrderRepo.save(completeOrder);
                })
                .orElseGet(() -> {
                    newCompleteOder.setId(id);
                    return completeOrderRepo.save(newCompleteOder);
                });
    }

    @DeleteMapping("/completeorders/{id}")
    void deleteCompleteOrder(@PathVariable Long id) {
        completeOrderRepo.deleteById(id);
    }
}
