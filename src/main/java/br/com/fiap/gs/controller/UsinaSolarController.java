package br.com.fiap.gs.controller;

import br.com.fiap.gs.dtos.UsinaSolarRequestCreateDto;
import br.com.fiap.gs.dtos.UsinaSolarRequestUpdateDto;
import br.com.fiap.gs.dtos.UsinaSolarResponseDto;
import br.com.fiap.gs.service.UsinaSolarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usinas")
public class UsinaSolarController {

    @Autowired
    private UsinaSolarService usinaSolarService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UsinaSolarResponseDto>> list() {
        List<UsinaSolarResponseDto> dtos = usinaSolarService.list()
                .stream()
                .map(e -> new UsinaSolarResponseDto().toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<UsinaSolarResponseDto> create(@RequestBody UsinaSolarRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new UsinaSolarResponseDto().toDto(
                                usinaSolarService.save(dto.toModel()))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<UsinaSolarResponseDto> update(
            @PathVariable Long id,
            @RequestBody UsinaSolarRequestUpdateDto dto) {
        if (! usinaSolarService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        new UsinaSolarResponseDto().toDto(
                                usinaSolarService.save(dto.toModel(id)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! usinaSolarService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        usinaSolarService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsinaSolarResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        usinaSolarService
                                .findById(id)
                                .map(e -> new UsinaSolarResponseDto().toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );

    }

}