package br.com.fiap.gs.controller;

import br.com.fiap.gs.dtos.UsinaSolarRequestCreateDto;
import br.com.fiap.gs.dtos.UsinaSolarRequestUpdateDto;
import br.com.fiap.gs.dtos.UsinaSolarResponseDto;
import br.com.fiap.gs.repository.UsinaSolarRepository;
import br.com.fiap.gs.service.UsinaSolarService;
import br.com.fiap.gs.views.UsinaSolarCompleteView;
import br.com.fiap.gs.views.UsinaSolarSimpleView;
import br.com.fiap.gs.views.UsinaSolarViewType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.fiap.gs.views.UsinaSolarViewType.SIMPLE;

@RestController
@RequestMapping("/usinas")
@RequiredArgsConstructor
public class UsinaSolarController {

    @Autowired
    private UsinaSolarService usinaSolarService;

    @Autowired
    private ModelMapper modelMapper;

    private final UsinaSolarRepository usinaSolarRepository;

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

    @GetMapping("/find")
    public ResponseEntity<?> findByLocal(
            @RequestParam String local,
            UsinaSolarViewType type) {

        return switch (type) {
            case SIMPLE ->
                    ResponseEntity.ok().body(usinaSolarRepository.findAllByLocalContains(local, UsinaSolarSimpleView.class));
            case COMPLETE ->
                    ResponseEntity.ok().body(usinaSolarRepository.findAllByLocalContains(local, UsinaSolarCompleteView.class));
        };
    }

}